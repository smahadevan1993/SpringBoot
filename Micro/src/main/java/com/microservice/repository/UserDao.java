package com.microservice.repository;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.microservice.objects.Helloobjects;
import com.microservice.objects.UserObject;

@Repository
public class UserDao extends JdbcDaoSupport {

	@Autowired
	private DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	 @PostConstruct
	 private void initialize() {
	  setDataSource(dataSource);
	 }

	public UserObject getuserdetails(String id) {
		String sql = "select * from users where uid='" + id + "';";

		Map<String, Object> rows = jdbcTemplate.queryForMap(sql);
		UserObject user = new UserObject();

		
		user.setid((String) rows.get("uid"));
		user.setname((String) rows.get("name"));
		user.setAddress((String) rows.get("address"));
		
		System.out.println("The ******************************* "+rows.get(user));
		return user;
	}

}
