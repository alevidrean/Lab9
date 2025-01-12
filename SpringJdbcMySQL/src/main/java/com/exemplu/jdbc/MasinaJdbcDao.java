package com.exemplu.jdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MasinaJdbcDao {
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 public int adaugaMasina(Masina masina) {
	        String sql = "INSERT INTO masini (nr, marca, anul, culoarea, kilometri) VALUES (?, ?, ?, ?, ?)";
	       return jdbcTemplate.update(sql, masina.getNr(), masina.getMarca(), masina.getAnul(), masina.getCuloarea(), masina.getKilometri());
	    }
	 
	public int stergeMasina(String nr)
	{
		String sql="delete from masini where nr=?";
		return jdbcTemplate.update(sql,nr);
	}
	
	public Masina cautareMasina(String nr)
	{
		String sql="select * from masini where nr=?";
		
	 try {
         return jdbcTemplate.queryForObject(sql, new MasinaMapper(), nr);
     } catch (EmptyResultDataAccessException e) {
         System.out.println("Masina cu numarul de inmatriculare " + nr + " nu a fost gasita.");
         return null;
     }
	   
	}
	
	public List<Masina> findAll(){
		 String sql="select * from masini";
		
		 try {
	            return jdbcTemplate.query(sql, new MasinaMapper());
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("Nu s-au gasit masini in baza de date.");
	            return List.of();
	        }
		 
		 }
	
	public int numararemasini(String marca)
	{
		String sql="select count(*) from masini where marca=?";
		try {
	 return jdbcTemplate.queryForObject(sql, Integer.class,marca);
		}catch(EmptyResultDataAccessException e)
		{
			System.out.println("Nu s-au gasit masini cu marca  " + marca);
	         return 0;
		}
	   
	}
	
	public int kilomm()
	{
		String sql="select count(*) from masini where kilometri<100000";
		try {
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Nu s-au gasit masini cu kilometraj sub 100000.");
            return 0;
        }
	}
	public List<Masina>masininoi()
	{
		String sql="select * from masini where anul>2019";
		try {
		return jdbcTemplate.query(sql,new MasinaMapper());
		}  catch (EmptyResultDataAccessException e) {
	         System.out.println("Nu s-au gasit masini mai noi de 5 ani ");
	         return List.of();
	}
	}
}
