package com.AirlineFeedback.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.AirlineFeedback.bean.Login;
import com.AirlineFeedback.bean.User;
import com.AirlineFeedback.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static int workload = 12;

	public void register(User user) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final String stringDate= dateFormat.format(user.getBirthDate());
		final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
		String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
		System.out.println("Inside dao");

		jdbcTemplate.update(sql, new Object[] { user.getUserId(), user.getEmailId(),
				user.getName(),hashPassword(user.getPassword()), sqlDate});
	}


	private String hashPassword(String plainTextPassword){
		String salt = BCrypt.gensalt(workload);
		return BCrypt.hashpw(plainTextPassword, salt);
	}
	
	private boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}
	
	public User validateUser(Login login) { 

		List<User> users = jdbcTemplate.query("SELECT * FROM user WHERE user_id = ?",
				new Object[] { login.getUserId() } , new UserMapper());
		if(users.size() > 0) {
			if(checkPass(login.getPassword(), users.get(0).getPassword())) {
				return(users.get(0));
			}else {
				return null;
			}

		}	
		return null;

	}
}

	class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();

			user.setUserId(rs.getString("user_id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setEmailId(rs.getString("email_id"));
			user.setBirthDate(rs.getDate("birth_date"));


			return user;
		}


	}