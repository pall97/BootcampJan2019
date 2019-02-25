package com.example.demo.controllers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.beans.*;
import com.example.demo.myPack.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class getDesignation {
  @RequestMapping(method = RequestMethod.GET, value="/Designation/{regdNum}")
  @ResponseBody
  public Designation getAllEmployees(@PathVariable("regdNum") String regdNum) {
  
	   Designation deg= new Designation();
		
		Connection conn = null;
		try {
			conn = JdbcCheck.getConnection();
			if(conn != null ) {
				Statement stmt = conn.createStatement();
				String SQL = "SELECT * from Designation where Id="+regdNum+";";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					deg.setId(rs.getInt("Id"));
					deg.setName(rs.getString("Name"));
				}

				System.out.println("done");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

		return deg;
  
  }
}