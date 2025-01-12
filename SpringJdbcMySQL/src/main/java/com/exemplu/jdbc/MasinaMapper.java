package com.exemplu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MasinaMapper implements RowMapper<Masina> {
	 public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
		 return new Masina(rs.getString("nr"), rs.getString("marca"), rs.getInt("anul"), rs.getString("culoarea"), rs.getInt("kilometri"));
		 }

}
