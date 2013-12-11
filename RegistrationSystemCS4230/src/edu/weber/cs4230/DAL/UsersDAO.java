package edu.weber.cs4230.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.DatatypeConverter;

import org.eclipse.persistence.jaxb.javamodel.JavaAnnotation;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaXmlTypeMappingType;

import edu.weber.group.bean.Registration;



public class UsersDAO {
	
	//public static java.security.SecureRandom random = java.security.SecureRandom.getInstance("SHA1PRNG");
	/**
	 * 
	 *  A simple hash function. provides a little security too.
	 * 
	 * @param str the string to be hashed
	 * @return
	 */
	public static String Hash (String str) {
		
		try {
			java.security.MessageDigest md =  java.security.MessageDigest.getInstance("SHA-256");
			byte[] data = str.getBytes();
			byte[] res = md.digest(data);
			return DatatypeConverter.printHexBinary(res).substring(8, 19);
			
		} catch (Exception e) {
			
		}
		
		return "bad";
	}
	
	
	/**
	 *  Creates a new user.
	 * 
	 * 
	 * @param r this user to create.
	 * @return
	 * @throws SQLException
	 */
	public static int newUser(Registration r) throws SQLException{
		int status = 0;
		Connection c  = ConnectionProvider.getCon();
		String s = "Insert into users (username, password, firstName, lastName, email) values(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(s);
		
		ps.setString(1, r.getUsername());
		ps.setString(2, Hash (r.getPassword()));
		ps.setString(3, r.getFirstName());
		ps.setString(4, r.getLastName());
		ps.setString(5, r.getEmail());
		
		status = ps.executeUpdate();
		
		return status;
		
	}
	
	/**
	 *  Gets the specified user. username in user  must be set.
	 * 
	 * 
	 * @param user - the user to get. username must be set
	 * @return true if exists. false otherwise.
	 */
	public static boolean getUser(Registration user) {
		
		try
		{
		
		
		Connection c = ConnectionProvider.getCon();
		ResultSet rs = null;
		Statement s = c.createStatement();
		String sql = "select UserId, username, password, firstName, lastName, email from users where username = '" + user.getUsername() + "'";
		rs = s.executeQuery(sql);
		if (!rs.next()){
			return false;
		}
		
		int id = rs.getInt(1);
		user.setId(id);
		String username = rs.getString(2);
		user.setUsername(username);
		String password = rs.getString(3);
		user.setPassword(password);
		String firstName = rs.getString(4);
		user.setFirstName(firstName);
		String lastName = rs.getString(5);
		user.setLastName(lastName);
		String email = rs.getString(6);
		user.setEmail(email);
		
		
		
		return true;
		
		} catch (SQLException se) {
			System.out.print(se.toString());
			return false;
		}
		
	}
	
	
	/**
	 * 
	 * get the Id to the user. gets by username.
	 * 
	 * @deprecated
	 * @param user - user to get. user name must be set.
	 * @return
	 * @throws SQLException
	 */
	public static boolean getId(String user) throws SQLException{
		Registration r = new Registration();
		Connection c = ConnectionProvider.getCon();
		ResultSet rs = null;
		Statement s = c.createStatement();
		
		String sql = "Select userId from users where username = " + user;
		rs = s.executeQuery(sql);
		if (!rs.next()){
			return false;
		}
		int id = rs.getInt(1);
		r.setId(id);
		return true;
	}
	
	
	/**
	 * updates the user in the db with the new email
	 * 
	 * @param r - the user to update. with the new email intacted
	 * @return shpuld be 0
	 * @throws SQLException
	 */
	public static int updateEmail(Registration r)throws SQLException{
		int status = 0;
		int id = r.getId();
		//String i = Integer.toString(id);
		Connection c  = ConnectionProvider.getCon();
		String sql = "update users set email = ? where userId = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, r.getEmail());
		ps.setInt(2, id);
		status = ps.executeUpdate();
		
		
		return status;
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param r - the user
	 * @return should be 0
	 * @throws SQLException
	 */
	
	public static int updatePassword(Registration r)throws SQLException{
		int status = 0;
		
		int id = r.getId();
		String i = Integer.toString(id);
		Connection c = ConnectionProvider.getCon();
		String s = "update users set password = ? where userId = ?";
		
		PreparedStatement ps = c.prepareStatement(s);
		ps.setString(1, Hash( r.getPassword() ));
		ps.setInt(2, id);
		status = ps.executeUpdate();
		String tmp = r.getPassword();
		r.setPassword(Hash( tmp ));
		return status;
	}
	
	
	/**
	 * 
	 * gets the user by there email first user with the email will be returned.
	 * 
	 * @param email - the email
	 * @param user - Registration object to fill.
	 * @return true if found. false otherwise
	 */
	public static boolean getUserByEmail(String email, Registration user) {
		
		try {
			
			
			try
			{
			
			
			Connection c = ConnectionProvider.getCon();
			ResultSet rs = null;
			Statement s = c.createStatement();
			String sql = "select UserId, username, password, firstName, lastName, email from users where email = '" + email + "'";
			rs = s.executeQuery(sql);
			if (!rs.next()){
				return false;
			}
			
			int id = rs.getInt(1);
			user.setId(id);
			String username = rs.getString(2);
			user.setUsername(username);
			String password = rs.getString(3);
			user.setPassword(password);
			String firstName = rs.getString(4);
			user.setFirstName(firstName);
			String lastName = rs.getString(5);
			user.setLastName(lastName);
			String email2 = rs.getString(6);
			user.setEmail(email2);
			
			
			
			return true;
			
			} catch (SQLException se) {
				System.out.print(se.toString());
				return false;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	
}
