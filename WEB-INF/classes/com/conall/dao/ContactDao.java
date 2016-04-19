package com.conall.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("contactDao")
public class ContactDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public Contact getContact(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbc.queryForObject("select * from conallcontact where id=:id ", params, new RowMapper<Contact>() {
			
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("id"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
				contact.setAddress(rs.getString("address"));
				contact.setAdditional(rs.getString("additional"));
				
				return contact;
			}
		});
	}
	
	public boolean update(Contact contact) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(contact);
		
		String additional = (String) params.getValue("additional");
		
		if(additional == "") {
			return jdbc.update("update conallcontact set email=:email, phone=:phone, address=:address, additional=null where id=:id", params) == 1;
		}
		else {
			return jdbc.update("update conallcontact set email=:email, phone=:phone, address=:address, additional=:additional where id=:id", params) == 1;
		}
		
	}
}