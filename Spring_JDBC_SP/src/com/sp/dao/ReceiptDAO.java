package com.sp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("receiptsDao")
public class ReceiptDAO {
	
private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Receipt> getReceipts() {

		return jdbc.query("select * from receipts", new RowMapper<Receipt>() {

			public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
				Receipt receipt = new Receipt();

				receipt.setId(rs.getInt("id"));
				receipt.setDescription(rs.getString("description"));
				receipt.setCompany(rs.getString("company"));
				receipt.setDate(rs.getString("date"));
				receipt.setPrice(rs.getDouble("price"));

				return receipt;
			}

		});
	}
	
public boolean create(Receipt receipt) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(receipt);
		
		return jdbc.update("insert into receipts (description, company, date, price) values (:description, :company, :date, :price)", params) == 1;
	}

}
