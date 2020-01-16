package com.bartend.app;

import java.sql.*;

public class MySQLConnection{
  public MySQLConnection(){
    try{
      Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/alcoholmixer", "root", "password");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from alcoholMixer");
      while(rs.next()){
        System.out.println(rs.getString(1));
      }
      con.close();
    } catch(Exception e){
      System.out.println(e);
    }
  }
}
