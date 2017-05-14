package pl.sp.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("receiptsDao")
public class ReceiptsDAO {

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
	
	public boolean update(Receipt receipt) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(receipt);
		
		return jdbc.update("update receipts set description=:description, company=:company, date=:date where id=:id, price=:price where id=:id", params) == 1;
	}
	
	public boolean create(Receipt receipt) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(receipt);
		
		return jdbc.update("insert into receipts (description, company, date, price) values (:description, :company, :date, :price)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<Receipt> receipts) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(receipts.toArray());
		
		return jdbc.batchUpdate("insert into receipts (id, description, company, date, price) values (:id, :description, :company, :date, :price)", params);
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from receipts where id=:id", params) == 1;
	}

	public Receipt getReceipt(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from receipts where id=:id", params,
				new RowMapper<Receipt>() {

					public Receipt mapRow(ResultSet rs, int rowNum)
							throws SQLException {
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
	
}
