package com.bartend.app; 

import java.sql.*; 
import java.util.ArrayList;
import java.util.List;

public class SQLManager{  
  private String connectionString = "jdbc:mariadb://localhost/alcoholmixer"; 
  private String username = "root";
  private String password = "password";
  public String[] getIDOne(){ 
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password);
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT drinkName FROM alcoholMixer");

      //String[] itemList = {"Coke", "Sprite", "Lemonade"};
      ArrayList<String> tmp = new ArrayList<>();
      while(rs.next()){
        tmp.add(rs.getString(1));
      }

      String[] itemList = new String[tmp.size()];
      tmp.toArray(itemList);
      return itemList;     
    } catch(Exception e){
      System.out.println(e);
      return null;
    }
  }

  public AlcMixer[] getAlcMixers(int drinkId){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password); 
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT alcMixerId, percentage FROM DRINKS_MAPPING WHERE drinkId = " + drinkId); 

      ArrayList<AlcMixer> tmp = new ArrayList<>();
      while(rs.next()){
        int alcMixerId = rs.getInt(1); 
        int percentage = rs.getInt(2); 
        int slot = getSlot(alcMixerId);
        String drinkName = getAlcMixerDrinkName(alcMixerId); 
        AlcMixer alc = new AlcMixer(drinkName, percentage, slot);
        tmp.add(alc);
      }   

      AlcMixer[] alcMixerList = new AlcMixer[tmp.size()]; 
      tmp.toArray(alcMixerList); 
      return alcMixerList;
    } catch(Exception e){
      System.out.println(e); 
      return null;
    }    
  }

  public String getAlcMixerDrinkName(int alcMixerId){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password); 
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT drinkName FROM alcoholMixer WHERE id = " + alcMixerId);

      rs.next(); 
      return rs.getString(1); 
    } catch(Exception e){
      System.out.println(e); 
      return null;
    }
  }

  public String[] getDrinks(){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password);
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT drinkName FROM DRINKS");
      ArrayList<String> tmp = new ArrayList<>();
      while(rs.next()){
        tmp.add(rs.getString(1));
      }

      String[] drinkList = new String[tmp.size()];
      tmp.toArray(drinkList);
      return drinkList;
    } catch(Exception e){
      System.out.println(e);
      return null;
    }
  }

  public int getSlot(int drinkId){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password); 
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT slot FROM slots WHERE id = " + drinkId);
      
      rs.next(); 
      return rs.getInt(1);
    } catch (Exception e){
      System.out.println(e); 
      return 0;
    }
  }

  public void createDrink(String drinkName){  
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password);
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("INSERT INTO DRINKS (drinkName) VALUES ('" + drinkName + "')");
      
    } catch(Exception e){
      System.out.println(e);
    }
  }

  public void addAlcoholMixerToDrink(int percentage, int alcMixerId, int drinkId){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password); 
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("INSERT INTO DRINKS_MAPPING (drinkId, alcMixerId, percentage) VALUES (" + drinkId + "," + alcMixerId + "," + percentage + ")");
    } catch(Exception e){
      System.out.println(e);
    }
  }
  
  public int getDrinkID(String drinkName){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password); 
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT drinkid FROM DRINKS WHERE drinkName = '" + drinkName + "'");
      rs.next();
      return rs.getInt(1);
    } catch(Exception e){
      System.out.println(e); 
      return 0;
    }
  }

  public int getAlcoholMixerID(String drinkName){
    try{
      Connection con = DriverManager.getConnection(connectionString, username, password); 
      Statement stmt = con.createStatement(); 
      ResultSet rs = stmt.executeQuery("SELECT id FROM alcoholMixer WHERE drinkName = '" + drinkName + "'");
      rs.next();
      return rs.getInt(1);
    } catch(Exception e){
      System.out.println(e); 
      return 0;
    }
  }
}
