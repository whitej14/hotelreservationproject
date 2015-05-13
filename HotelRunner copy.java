import java.util.*;
import java.io.*;
import java.lang.*;
public class HotelRunner
{
  public static String fname, lname, arrive, depart;
  public static ArrayList<Hotel> guestlist = new ArrayList<Hotel>();
  public static void main(String[] args) throws IOException
  {
    String x;
    Scanner scan = new Scanner(System.in);
    //reads in file for instructors/greeting 
    Scanner fileScan = new Scanner ( new File("greeting.txt"));
    while (fileScan.hasNext())     
    {       
      x=fileScan.nextLine();       
      System.out.println(x);     
    } 
    open();
    Hotel p1 = new Hotel(fname, lname, arrive, depart);
    p1.choice();
    open();
    Hotel p2 = new Hotel(fname, lname, arrive, depart);
    p2.choice();
    open();
    Hotel p3 = new Hotel(fname, lname, arrive, depart);
    p3.choice();
    open();
    Hotel p4 = new Hotel(fname, lname, arrive, depart);
    p4.choice();
    open();
    Hotel p5 = new Hotel(fname, lname, arrive, depart);
    p5.choice();
    open();
    Hotel p6 = new Hotel(fname, lname, arrive, depart);
    p6.choice();
    
    guestlist.add(p1);
    guestlist.add(p2);
    guestlist.add(p3);
    guestlist.add(p4);
    guestlist.add(p5);
    guestlist.add(p6);
    
    bubblesort(guestlist);
    System.out.println("Enter a last name to check if they are on the Guest List:");
    String guest = scan.nextLine();
    search(guestlist, guest);
    
    System.out.println("Enter to Win Free Night!");
    rando(p6);
    
    PrintWriter write = new PrintWriter("guestlist.txt");
    write.println("Guest List:");
    for (Hotel item : guestlist) 
    {
      write.println(item);
    }
    write.close();
    
  }
  // ask information from user
  public static void open()
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter first name:");
    fname = scan.nextLine();
    System.out.println("Enter last name:");
    lname = scan.nextLine();
    System.out.println("Enter arrival date in mm/dd/yy format:");
    arrive = scan.nextLine();
    System.out.println("Enter departing date in mm/dd/yy format:");
    depart = scan.nextLine();
    
  }
// sorts the arraylist alphabetically
  public static void bubblesort(ArrayList<Hotel> list)
  {
        Hotel temp;
        if (list.size()>1) // check if the number of orders is larger than 1
        {
            for (int i=0; i<list.size(); i++) // bubble sort outer loop
            {
                for (int j=0; j < list.size() - i - 1; j++) 
                {
                    if (list.get(j).compareTo(list.get(j+1)) > 0)
                    {
                        temp = list.get(j);
                        list.set(j,list.get(j+1) );
                        list.set(j+1, temp);
                    }
                }
            }
        }
 
  }
  //searches for a certain guest by last name
  public static void search(ArrayList<Hotel> list, String guest)
  {
    for (Hotel item : list) 
    {
    if (item.getLname().contains(guest))
      System.out.println("Found the guest we were looking for!");
    }
 }
  //compares the random number to guest's arrival date
  // if it is equal they win a free night
  public static void rando(Hotel person)
  {
    int date = person.getArriveDate();
    Random generator = new Random(32);
    int rand = generator.nextInt();
    if (rand == date)
    {
      System.out.println("You win a free night!");
    }
    else
    {
      System.out.println("Maybe next time!");
    }
  }
}
//Sample Output
/*
Welcome!
When prompted enter the guests first and last name.
Then, enter their arrival date formatted like mm/dd/yy.
After, you will be able to book a suite, a family room, or a standard room.
Also, you can check when the rooms are already booked. 
Thank you and enjoy your stay!
//*************************************************************************
Enter first name:
Welcome!
When prompted enter the guests first and last name.
Then, enter their arrival date formatted like mm/dd/yy.
After, you will be able to book a suite, a family room, or a standard room.
Also, you can check when the rooms are already booked. 
Thank you and enjoy your stay!
//*************************************************************************
Enter first name:
Joy
Enter last name:
White
Enter arrival date in mm/dd/yy format:
12/12/14
Enter departing date in mm/dd/yy format:
12/15/14
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
1
Enter first name:
Sarah
Enter last name:
White
Enter arrival date in mm/dd/yy format:
12/12/14
Enter departing date in mm/dd/yy format:
12/17/14
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
1
Enter first name:
Charlie
Enter last name:
Brown
Enter arrival date in mm/dd/yy format:
12/11/14
Enter departing date in mm/dd/yy format:
12/14/14
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
1
I am sorry. The room type you desire is not available on the date you would like. 
Please choose another type or room.
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
3
Enter first name:
Ron
Enter last name:
Swanson
Enter arrival date in mm/dd/yy format:
12/22/14
Enter departing date in mm/dd/yy format:
12/24/14
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
1
Enter first name:
Leslie
Enter last name:
Knope
Enter arrival date in mm/dd/yy format:
12/23/14
Enter departing date in mm/dd/yy format:
12/27/14
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
2
Enter first name:
McKenna
Enter last name:
Batterson
Enter arrival date in mm/dd/yy format:
12/16/14
Enter departing date in mm/dd/yy format:
12/19/14
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
9
Occupied
Suites: 
 Suite 1 
   Days: 12 13 14 15 22 23 24 
 Suite 2 
   Days: 12 13 14 15 16 17 
Family Rooms: 
 Family Room 1 
   Days: 23 24 25 26 27 
 Family Room 2 
   Days: 
 Family Room 3 
   Days: 
 Family Room 4 
   Days: 
Standard Rooms: 
 Standard Room 1 
   Days: 11 12 13 14 
 Standard Room 2 
   Days: 
 Standard Room 3 
   Days: 
 Standard Room 4 
   Days: 
1: Suite
2: Family Room
3: Standard Room
8: Check Availability
9: Check Occupancy 
3
Enter a last name to check if they are on the Guest List:
Knope
Found the guest we were looking for!
Enter to Win Free Night!
Maybe next time!
////////////////////////////////
In guestlist.txt
///////////////////////////////
Guest List:
Charlie Brown 12/11/14 to 12/14/14
McKenna Batterson 12/16/14 to 12/19/14
Leslie Knope 12/23/14 to 12/27/14
Ron Swanson 12/22/14 to 12/24/14
Joy White 12/12/14 to 12/15/14
Sarah White 12/12/14 to 12/17/14
*/