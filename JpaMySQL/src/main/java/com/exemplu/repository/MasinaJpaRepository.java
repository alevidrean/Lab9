package com.exemplu.repository;
import java.util.List;
import com.exemplu.entity.Masina;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MasinaJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Masina adaugare(Masina m){
		 return entityManager.merge(m);
		 }
	
	 public Masina findById(String nr){
		 return entityManager.find(Masina.class, nr);
		 }
	 public void stergere(String nr){
		 Masina m=findById(nr);
		 if (m != null) {
		        entityManager.remove(m);
		    } else {
		        System.out.println("Masina cu numarul de inmatriculare " + nr + " nu exista.");
		    }
		 }
	 public Masina cautaremarca(String nr){
		 return entityManager.find(Masina.class, nr);
		 }
	 
	 public List<Masina> findAll(){
		 TypedQuery<Masina> query=entityManager.createQuery("from Masina",Masina.class);
		 return query.getResultList();
		 }
	 
	 public long numaraMasiniDupaMarca(String marca) {
		    String jpql = "SELECT COUNT(m) FROM Masina m WHERE m.marca = :marca";
		    TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		    query.setParameter("marca", marca);
		    return query.getSingleResult();
		}
	 
	 public long numaraMasinimaimici() {
		    String jpql = "SELECT COUNT(m) FROM Masina m WHERE m.kilometri < 100000";
		    TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		    return query.getSingleResult();
		}
	 
	 public List<Masina> masininoi(){
		 String jpql = "SELECT m FROM Masina m WHERE m.anul>2019";
		 TypedQuery<Masina> query=entityManager.createQuery(jpql,Masina.class);
		 return query.getResultList();
		 }

}
