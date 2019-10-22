import java.awt.*; 
import java.awt.event.*;

public class Drink{
  public String theDrink;
  public String m_1;
  public String m_2;
  public String m_3;
  public String m_4; 
  public String m_5; 
  public String m_6;
  public String m_7;
  public String m_8;
  public String m_9; 
  public String m_10;
  public String m_11;
  public String m_12;
  public String m_13;
  public String m_14;
  public String m_15;

  public Drink(String drinkName, int one, int two, int three, int four, int five, int six, int seven, int eight, int nine, int ten, int eleven, int twelve, int thirteen, int fourteen, int fifteen){
    theDrink = drinkName;
    m_1 = Integer.toString(one);
    m_2 = Integer.toString(two);
    m_3 = Integer.toString(three);
    m_4 = Integer.toString(four);
    m_5 = Integer.toString(five);
    m_6 = Integer.toString(six);
    m_7 = Integer.toString(seven);
    m_8 = Integer.toString(eight);
    m_9 = Integer.toString(nine);
    m_10 = Integer.toString(ten);
    m_11 = Integer.toString(eleven);
    m_12 = Integer.toString(twelve);
    m_13 = Integer.toString(thirteen);
    m_14 = Integer.toString(fourteen);
    m_15 = Integer.toString(fifteen);
  } 

  public void print(){
    System.out.println(theDrink);
    System.out.println(m_1);
    System.out.println(m_2);
    System.out.println(m_3);
    System.out.println(m_4);
    System.out.println(m_5);
    System.out.println(m_6);
    System.out.println(m_7);
    System.out.println(m_8);
    System.out.println(m_9);
    System.out.println(m_10);
    System.out.println(m_11);
    System.out.println(m_12);
    System.out.println(m_13);
    System.out.println(m_14);
    System.out.println(m_15);
  }
}
