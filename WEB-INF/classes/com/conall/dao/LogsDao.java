package com.conall.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("logsDao")
public class LogsDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	// used by /logs:
	public List<Log> getLogs() {

		return jdbc.query("select * from conallnews", new RowMapper<Log>() {

			// ResultSet is where results from query are stored
			public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
				Log log = new Log();

				log.setId(rs.getInt("id"));
				log.setDate(rs.getString("date"));
				log.setText(rs.getString("text"));
				log.setLinkUrl(rs.getString("linkUrl"));

				return log;

			}

		});
	}
			
	public boolean update(Log log) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(log);
		
		String url = (String) params.getValue("linkUrl");
		
		if(url == "") {
			return jdbc.update("update conallnews set date=:date, text=:text, linkUrl=null where id=:id", params) == 1;
		}
		else {
			return jdbc.update("update conallnews set date=:date, text=:text, linkUrl=:linkUrl where id=:id", params) == 1;
		}
		
	}
	
	public boolean create(Log log) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(log);  // creates a set of params to replace placeholders in sql from bean properties
		
		String url = (String) params.getValue("linkUrl");
		
		if(url=="") {
			return jdbc.update("insert into conallnews (date, text, linkUrl) values (:date, :text, null)", params) == 1;
		} else {
			return jdbc.update("insert into conallnews (date, text, linkUrl) values (:date, :text, :linkUrl)", params) == 1;
		}
		
	}
		
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from conallnews where id=:id", params) == 1;
		// will return the number or rows effected by query (should be 1 in this case)
	}

	// used by edit log:
	public Log getLogEdit(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		// queryForObject returns an object so no type casting needed
		return jdbc.queryForObject("select * from conallnews where id=:id ", params, new RowMapper<Log>() {

			public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Log log = new Log();

				log.setId(rs.getInt("id"));
				log.setDate(rs.getString("date"));
				log.setText(rs.getString("text"));
				log.setLinkName(rs.getString("linkName"));
				log.setLinkUrl(rs.getString("linkUrl"));

				return log;

			}

		});
	}

}