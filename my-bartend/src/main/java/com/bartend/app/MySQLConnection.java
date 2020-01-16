package com.bartend.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection{
  Connection con;
  MySQLConnectionDelegate delegate;
  public MySQLConnection(){
    try{
      con = DriverManager.getConnection("jdbc:mariadb://localhost/alcoholmixer", "root", "password");
    } catch(Exception e){
      System.out.println(e);
    }
  }

  public void addMixerAlcohol(String mixer, MySQLConnection aCon){
    try{
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("INSERT INTO alcoholMixer(drinkName) VALUES ('" + mixer + "')");
      aCon.getAlcoholMixers();
    } catch (Exception e){
      System.out.println(e);
    }
  }


  public void getAlcoholMixers(){
    try{
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM alcoholMixer");
      List<String> array = new ArrayList<>();
      while(rs.next()){
        array.add(rs.getString(1));
      }
      
      delegate.alcoholMixerData(array.toArray());
    } catch (Exception e){
      System.out.println(e);
    }
    
  }
}
