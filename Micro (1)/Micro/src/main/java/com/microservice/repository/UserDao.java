package com.microservice.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.microservice.objects.Helloobjects;
import com.microservice.objects.UserObject;

import java.util.Random;

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

	// to get the userdetails based on user name 
	public UserObject getuserdetails(String username) {
		String sql = "select * from users where username='" + username + "';";

		Map<String, Object> rows = jdbcTemplate.queryForMap(sql);
		UserObject user = new UserObject();

		user.setUserid((String) rows.get("userid"));
		user.setUsername((String) rows.get("username"));

		System.out.println("The ******************************* " + rows.get(user));
		return user;
	}

	// to save the user details in users table 
	public void saveUserDetails(UserObject userobj) {

		Random rand = new Random();
		int rand_userid = rand.nextInt(1000);
		String useridgen=Integer.toString(rand_userid);

		String sql = "INSERT INTO users (userid, username) " + "values(?,?);";
		try {
			getJdbcTemplate().update(sql, new Object[] { useridgen, userobj.getUsername() });

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("THERE IS AN ERROR ::::" + e);

								}

	}

	
	// to save user chat details in userchat table 
	public void saveUserChat(UserObject userobj)
	{
		
		String sql = "INSERT INTO userchat (userid, username) " + "values(?,?);";
		
		
		
	}
	
	


}
