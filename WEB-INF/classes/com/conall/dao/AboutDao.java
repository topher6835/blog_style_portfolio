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

@Component("aboutDao")
public class AboutDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<About> getAbout() {

		return jdbc.query("select * from conallabout", new RowMapper<About>() {

			public About mapRow(ResultSet rs, int rowNum) throws SQLException {
				About about = new About();

				about.setId(rs.getInt("id"));
				about.setAbout(rs.getString("about"));

				return about;
			}
		});
	}
	
	public About getAbout(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from conallabout where id=:id ", params, new RowMapper<About>() {

			public About mapRow(ResultSet rs, int rowNum) throws SQLException {
				About about = new About();

				about.setId(rs.getInt("id"));
				about.setAbout(rs.getString("about"));

				return about;

			}

		});
	}

	public boolean update(About about) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(about);
		return jdbc.update("update conallabout set about=:about where id=:id", params) == 1;
	}
}