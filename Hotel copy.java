//Joy White ECS102
//Final Project
//December 12th 2014
//Hotel Reservation System for the Month of December 
import java.util.*;
import java.io.*;
public class Hotel
{
  String fname, lname, arrivalDate, departureDate;
  boolean suitesfull, familyfull, standardfull;
  String full = "I am sorry. The room type you desire is not available on the date you would like. \nPlease choose another type or room.";
  String suitesTitle = "Suite ";
  public static boolean [][] suites = new boolean[2][31]; //2 repesents two suites and 31 represents 31 days
  String familyTitle = "Family Room ";
  public static boolean [][] family = new boolean[4][31]; //4 repesents four family rooms and 31 represents 31 days
  String standardTitle = "Standard Room ";
  public static boolean [][] standard = new boolean[4][31]; //4 repesents four standard rooms and 31 represents 31 days
  
  //Constructor for Hotel
  //Takes in the Guest's Name and the day they will be at the hotel
  public Hotel(String f, String l, String arrive, String depart)
  {
    fname = f;
    lname = l;
    arrivalDate = arrive;
    departureDate = depart;
  }
  public String getFname()
  {
    return fname;
  }
  public String getLname()
  {
    return lname;
  }
  //gets the arrive date and returns it with just the day
  public int getArriveDate()
  {
    int date = Integer.parseInt(arrivalDate.substring(3,5));
    return date;
  }
  //gets the depart date and returns it with just the day
  public int getDepartDate()
  {
    int date = Integer.parseInt(departureDate.substring(3,5));
    return date;
  }
  //choice acts as the menu allowing the user to choose the room type and see room occupancy 
  public void choice()
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("1: Suite\n2: Family Room\n3: Standard Room"+
                         "\n8: Check Availability\n9: Check Occupancy ");
    int c = scan.nextInt();
    if (c==1)
    {
      bookSuite1();
    }
    else if (c==2)
    {
      bookFamily1();
    }
    else if(c==3)
    {
      bookStandard1();
    }
    else if(c==8)
    {
      roomAvailability();
    }
    else if(c==9)
    {
      roomOccupied();
    }
    else
      System.out.print("Come again!");
  }
  //loops through the 2D arrays to check for occupancy
  // if it is false it is unoccupied, if it is true it is occupied on that day
  // prints the open rooms
  public void roomAvailability()
  {
    System.out.println("Availablity\nSuites: ");
      for (int i=0; i<2; i++)
      {
        System.out.print("\t"+suitesTitle + (i+1) + " \n\t\t\tDays: ");
        for (int j=0; j<31; j++)
        {
          if (suites[i][j] == false)
          {
            System.out.print((j+1) + " ");
          }
        }
        System.out.println();
      } 
      System.out.println("Family Rooms: ");
      for (int i=0; i<4; i++)
      {
        System.out.print("\t"+familyTitle + (i+1) + " \n\t\t\tDays: ");
        for (int j=0; j<31; j++)
        {
          if (family[i][j] == false)
          {
            System.out.print((j+1) + " ");
          }
        }
        System.out.println();
      }
      System.out.println("Standard Rooms: ");
      for (int i=0; i<4; i++)
      {
        System.out.print("\t"+standardTitle + (i+1) + " \n\t\t\tDays: ");
        for (int j=0; j<31; j++)
        {
          if (standard[i][j] == false)
          {
            System.out.print((j+1) + " ");
          }
        }
        System.out.println();
      }
     choice();
  }
//does the same as roomAvailablity except prints occupied rooms
  public void roomOccupied()
  {
    System.out.println("Occupied\nSuites: ");
      for (int i=0; i<2; i++)
      {
        System.out.print("\t"+suitesTitle + (i+1) + " \n\t\t\tDays: ");
        for (int j=0; j<31; j++)
        {
          if (suites[i][j] == true)
          {
            System.out.print((j+1) + " ");
          }
        }
        System.out.println();
      } 
      System.out.println("Family Rooms: ");
      for (int i=0; i<4; i++)
      {
        System.out.print("\t"+familyTitle + (i+1) + " \n\t\t\tDays: ");
        for (int j=0; j<31; j++)
        {
          if (family[i][j] == true)
          {
            System.out.print((j+1) + " ");
          }
        }
        System.out.println();
      }
      System.out.println("Standard Rooms: ");
      for (int i=0; i<4; i++)
      {
        System.out.print("\t"+standardTitle + (i+1) + " \n\t\t\tDays: ");
        for (int j=0; j<31; j++)
        {
          if (standard[i][j] == true)
          {
            System.out.print((j+1) + " ");
          }
        }
        System.out.println();
      }
     choice();
  }
  //it books suite 1(by making the days true) if all the dates entered are false(unoccupied)
  // else it calls the other suite method
  public void bookSuite1()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = suites[0][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        suites[0][dates[count]-1] = true;
        count++;
      }   
      else
      {
       store = true;
       break;
      }
        
    }
    if(store)
    {
      bookSuite2();
    }
}
 // does the same as bookSuite1 unless it is occupied
 // then it says the suites are full and sends the user back to the main menu
 public void bookSuite2()
 {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = suites[1][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        suites[1][dates[count]-1] = true;
        count++;
      }   
      else
      {
        store = true;
        break;
      }
        
    }
    if(store)
    {
      System.out.println(full);
      choice();
    }
 }
 //does the same for the family rooms as the suites except there are four family rooms
 public void bookFamily1()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = family[0][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        family[0][dates[count]-1] = true;
        count++;
      }   
      else
      {
       store = true;
       break;
      }
        
    }
    if(store)
    {
      bookFamily2();
    }
 }
 public void bookFamily2()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = family[1][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        family[1][dates[count]-1] = true;
        count++;
      }   
      else
      {
        store = true;
        break;
      }
        
    }
    if(store)
    {
      bookFamily3();
    }
 }
  public void bookFamily3()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = family[2][dates[i]];
    }
   int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        family[2][dates[count]-1] = true;
        count++;
      }   
      else
      {
        store = true;
        break;
      }
        
    }
     if(store)
    {
      bookFamily4();
    }
 }
  public void bookFamily4()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = family[3][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        family[3][dates[count]-1] = true;
        count++;
      }   
      else
      {
        store = true;
        break;
      }
        
    }
    if(store)
    {
      System.out.println(full);
      choice();
    }
 }
 //does the same for the standard rooms as the suites except there are four standard rooms
   public void bookStandard1()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = standard[0][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        standard[0][dates[count]-1] = true;
        count++;
      }   
      else
      {
       store = true;
       break;
      }
        
    }
    if(store)
    {
      bookStandard2();
    }
 }
 public void bookStandard2()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = standard[1][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        standard[1][dates[count]-1] = true;
        count++;
      }   
      else
      {
       store = true;
       break;
      }
        
    }
    if(store)
    {
      bookStandard3();
    }
 }
  public void bookStandard3()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = standard[2][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        standard[2][dates[count]-1] = true;
        count++;
      }   
      else
      {
       store = true;
       break;
      }
        
    }
    if(store)
    {
      bookStandard4();
    }
 }
  public void bookStandard4()
  {
    int arrive = getArriveDate();
    int depart = getDepartDate();
    int difference = depart - arrive;
    int[] dates = new int[difference+1];
    boolean[] check = new boolean [difference+1];
    boolean store = false;
    for (int i = 0; i<difference+1; i++)
    {
      dates[i] = i+arrive;
    }
    for(int i = 0; i<difference+1; i++)
    {
      check[i] = standard[3][dates[i]];
    }
    int count = 0;
    for(boolean value : check) 
    {
      if (!value)
      {
        standard[3][dates[count]-1] = true;
        count++;
      }   
      else
      {
        store = true;
        break;
      }
        
    }
    if(store)
    {
      System.out.println(full);
      choice();
    }
 }
  //it compares each object to unicode
  public int compareTo(Hotel hotel)
  {
    Character i = new Character(getLname().charAt(0));
    return i.compareTo(hotel.getLname().charAt(0));
  }
  //organizes the guest's information for the output
  public String toString()
  {
    String result = fname +" "+ lname +" "+ arrivalDate + " to " + departureDate;
    return result;
  }
}