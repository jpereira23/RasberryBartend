package com.bartend.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection{
  Connection con;
  MySQLConnectionDelegate delegate;
  public List<Slot> slotArray; 
  public List<Integer> slotArray1;
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

  public int getId(String search){
    for(Slot d : slotArray){
      if(d.getDrinkName() != null && d.getDrinkName().contains(search)){
        return d.getId();
      }
    }
    return -1;
  }

  public String getDrinkName(int id){
    for(Slot d : slotArray){
      if(d.getId() != 0 && d.getId() == id)
        return d.getDrinkName();
    }
    return "";
  }
  public void getAlcoholMixers(){
    try{
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM alcoholMixer");
      slotArray = new ArrayList<>();
      while(rs.next()){
        String drinkName = rs.getString(2); 
        int id = rs.getInt(1);
        Slot s = new Slot(drinkName, id); 
        slotArray.add(s);
      }
      
      delegate.alcoholMixerData(slotArray.toArray());
    } catch (Exception e){
      System.out.println(e);
    }
  }
  public void getSlots(){
    try{
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM slots");
      slotArray1 = new ArrayList<>();
      while(rs.next())
      {
        if(rs.getInt(2) != 0){
          slotArray1.add(rs.getInt(2));
        }else{
          slotArray1.add(0);
        }
      }
      delegate.slotsData(slotArray1.toArray());
    } catch (Exception e){
      System.out.println(e);
    }
  } 

  public void updateSlots(int num, int slotNum){
    try{
      Statement stmt = con.createStatement(); 
      System.out.println(num);
      System.out.println(slotNum);
      slotNum = slotNum + 1;
      ResultSet rs = stmt.executeQuery("UPDATE slots set id=" + num + " where slot = " + slotNum + "");  
    } catch (Exception e){
      System.out.println(e); 
    }
  }
}
