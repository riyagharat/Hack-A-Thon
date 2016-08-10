/*

Riya Gharat        N00901846
Mounika Putikam    N01038361
Hitasri Cherukuri  N00899720
Kai Thawng         N01060076

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class clubAlliance{
  public static void main(String[] args){
   
     Scanner input = new Scanner(System.in);
     
     String fileName2 = "masterFile";       
      
     File file2 = new File(fileName2 + ".txt");   
     if (!file2.exists()) {
        System.out.println(fileName2 + " does not exist.");
     return;
     }
   
     if (!(file2.isFile() && file2.canRead())) {
        System.out.println(file2.getName() + " cannot be read from.");
     return;
     }
      
     String nNumberNew = "";
     String preferredNameNew = "";
     String firstNameNew = "";
     String middleINew = "";
     String lastNameNew = "";
     double gpaNew = 0.0;
     String positionNew = "";
     String clubNameNew = "";
      
     int counter = 0;
     
     try{
        Scanner sc = new Scanner(new FileInputStream(file2));
        while(sc.hasNext()){
           if(counter == 0){
              nNumberNew = sc.next();
              counter++;
           }else if(counter == 1){
              preferredNameNew = sc.next();
              counter++;
           }else if(counter == 2){
              firstNameNew = sc.next();
              counter++;
           }else if(counter == 3){
              middleINew = sc.next();
              counter++;
           }else if(counter == 4){
              lastNameNew = sc.next();
              counter++;
           }else if(counter == 5){
              gpaNew = Double.parseDouble(sc.next());
              counter++;
           }else if(counter == 6){
              positionNew = sc.next();
              counter++;
           }else if(counter == 7){
              clubNameNew = sc.next();
              counter++;
           }else if(counter == 8){
              linkedList.addLast(nNumberNew, preferredNameNew, firstNameNew, middleINew, lastNameNew, gpaNew, positionNew, clubNameNew);
              counter = 0;
           }
        }           
             
     }catch (IOException e){
        e.printStackTrace();
     
     } 
      
     input = new Scanner(System.in);
     boolean check = true, check2 = true;
     String theClub = "";
                
     while(check2){
         System.out.println("Option a: New Club (Enter Information)");
         System.out.println("Option b: Existing Club");
         System.out.println("Option e: EXIT.");
         System.out.print("Enter a choice: ");
         int choice = input.next().charAt(0);
         System.out.println("");
         switch(choice){
            case 'a':
               linkedList.newClub();
               break;
            case 'b':
               
               while(check){
                  System.out.println("Option a: Add a Member");
                  System.out.println("Option b: Remove a Member");
                  System.out.println("Option c: Find a Member");
                  System.out.println("Option d: Modify a Member");
                  System.out.println("Option e: DisplayAll");
                  System.out.println("Option f: EXIT.");
                  System.out.print("Enter a choice: ");
                  choice = input.next().charAt(0);
                  System.out.println("");
                  switch(choice){
                     case 'a':
                        input = new Scanner(System.in);
                        System.out.println("Enter the folowing information: ");
                        System.out.print("N Number: " );
                        String nNumber2 = input.nextLine();
                        System.out.print("Preferred Name : ");
                        String pName = input.nextLine();
                        System.out.print("First Name: ");
                        String fName = input.nextLine();
                        System.out.print("Middle Initial: ");
                        String mName = input.nextLine();
                        System.out.print("Last Name: ");
                        String lName = input.nextLine();
                        System.out.print("GPA: ");
                        double gpA = input.nextDouble();
                        input = new Scanner(System.in);
                        System.out.print("Position: ");
                        String posi = input.nextLine();
                        System.out.print("Club Name: ");
                        String cn = input.nextLine();
                        System.out.println(""); 
                        linkedList.addLast(nNumber2, pName, fName, mName, lName, gpA, posi, cn);
                        break;
                     case 'b':
                        input = new Scanner(System.in);
                        System.out.println("Enter a N number to delete: ");
                        String search = input.nextLine();
                        linkedList.remove(search);
                        break;
                     case 'c':
                        System.out.println("Enter a N number to search: ");
                        search = input.nextLine();
                        Node newNode = linkedList.find(search);
                        if(newNode != null){
                           System.out.println("N Number: " + newNode.nNumber);
                           System.out.println("Preferred Name : " + newNode.preferredName);
                           System.out.println("First Name: " + newNode.firstName);
                           System.out.println("Middle Initial: " + newNode.middleI);
                           System.out.println("Last Name: " + newNode.lastName);
                           System.out.println("GPA: " + newNode.gPA);
                           System.out.println("Position: " + newNode.position);  
                           System.out.println("");    
                        }
                        break;
                     case 'd':
                        input = new Scanner(System.in);
                        System.out.println("Enter a N number to modify: ");
                        search = input.nextLine();
                        linkedList.modify(search);
                        break;
                     case 'e':
                        linkedList.displayAll();
                        System.out.println("");
                        System.out.println("");
                        break;
                     case 'f':
                        System.out.println("Returning to Main.");
                        check = false; 
                        break; 
                     default:
                        System.out.print("Invalid entry\n");
                  }
               }   
               break;
            case 'e':
               System.out.println("Thank you for running the program. See you next time.");
               linkedList.writeFile();
               check2 = false;
               return;   
            default:
               System.out.print("Invalid entry\n");
         }
      }                                                  
   }         
      
   static class Node{
      private String nNumber;
      private String preferredName;
      private String firstName;
      private String middleI;
      private String lastName;
      private double gPA;
      private String position;
      private String clubName;
      private Node previous;
      private Node next;   
      
      Node(String nN, String pN, String fN, String mI, String lN, double gpa, String pos, String cN){
         nNumber = nN;
         preferredName = pN;
         firstName = fN;
         middleI = mI;
         lastName = lN;
         gPA = gpa;
         position = pos;
         clubName = cN;
      }   
      
      public void displayNodeAllTitles(){
         System.out.printf("\n%-10s %10s %10s %10s %10s", "N Number:" , "Preferred Name: ", "First Name: ", "Middle Initial: ", "Last Name:");
      }   
      
      public void displayNodeAll(){
         System.out.printf("\n%-10s %10s %15s %12s %14s", nNumber, preferredName, firstName, middleI, lastName);
      }   
      
      public void displayNodeFind(){  
         System.out.println("N Number: " + nNumber);
         System.out.println("Preferred Name : " + preferredName);
         System.out.println("First Name: " + firstName);
         System.out.println("Middle Initial: " + middleI);
         System.out.println("Last Name: " + lastName);
         System.out.println("GPA: " + gPA);
         System.out.println("Position: " + position);      
      }
    
   }
   
   static class linkedList{
   
      static Node first;
      static Node last;
      
      public static void linkedList(){
         first = null;
         last = null;
      }
      
      public static boolean isEmpty(){
         return (first == null);
      }      
      
      public static void add(String nNumber, String preferredName, String firstName, String middleI, String lastName, double gpa, String position, String clubName){
         Node newNode = new Node(nNumber, preferredName, firstName, middleI, lastName, gpa, position, clubName);
         
      }
      
      public static void addLast(String nNumber, String preferredName, String firstName, String middleI, String lastName, double gpa, String position, String clubName){
         Node newNode = new Node(nNumber, preferredName, firstName, middleI, lastName, gpa, position, clubName);
         if(isEmpty()){
            first = newNode;
            last = newNode;
         }else{
            last.next = newNode;
            newNode.previous = last;
         }
         last = newNode;
         last.next = null;
      }
      
      public static void remove(String key){
         Node current = first;
         while(!current.nNumber.equals(key)){
            current = current.next;
         }   
         if(current == first){
            first = current.next;
         }else{
            current.previous.next = current.next;
         }
         
         if(current == last){
            last = current.previous;
         }else{
            current.next.previous = current.previous;
         }                  
      
      }
      
      public static Node find(String key){
         Node current = first;
         while(!current.nNumber.equals(key)){
            current = current.next;
            if(current.next.equals(null)){
               return null;
            }else{   
               current = current.next;
            }             
         }
         return current;
      }
      
      public static void modify(String key){
         Node current = first;
         while(!current.nNumber.equals(key)){
            current = current.next;
            if((current).equals(null)){
               System.out.println(key + " not found.");
            }else{   
               current = current.next;
            }             
         }
         System.out.println("This is the original record which you are editing.");
         System.out.println("");
         System.out.println("N Number: " + current.nNumber);
         System.out.println("Preferred Name : " + current.preferredName);
         System.out.println("First Name: " + current.firstName);
         System.out.println("Middle Initial: " + current.middleI);
         System.out.println("Last Name: " + current.lastName);
         System.out.println("GPA: " + current.gPA);
         System.out.println("Position: " + current.position);
         System.out.println("");
         
         boolean check3 = true;
         Scanner input = new Scanner(System.in);
         
         while(check3){
            System.out.println("Option a: Change Preferred Name");
            System.out.println("Option b: Change First Name");
            System.out.println("Option c: Change Middle Initial");
            System.out.println("Option d: Change Last Name");
            System.out.println("Option e: Change GPA");
            System.out.println("Option f: Change Position");
            System.out.println("Option g: EXIT.");
            System.out.print("Enter a choice: ");
            int choice = input.next().charAt(0);
            System.out.println("");
            switch(choice){
               case 'a':
                  input = new Scanner(System.in);
                  System.out.println("Enter new preferred name: ");
                  String newEntry = input.nextLine();
                  current.preferredName = newEntry;
                  break;
               case 'b':
                  input = new Scanner(System.in);
                  System.out.println("Enter new first name: ");
                  newEntry = input.nextLine();
                  current.firstName = newEntry;
                  break;
               case 'c':
                  input = new Scanner(System.in);
                  System.out.println("Enter new middle initial: ");
                  newEntry = input.nextLine();
                  current.middleI = newEntry;
                  break;
               case 'd':
                  input = new Scanner(System.in);
                  System.out.println("Enter new last name: ");
                  newEntry = input.nextLine();
                  current.lastName = newEntry;
                  break;
               case 'e':
                  input = new Scanner(System.in);
                  System.out.println("Enter new GPA: ");
                  double newEntry2 = input.nextDouble();
                  current.gPA = newEntry2;
                  break;
               case 'f':
                  input = new Scanner(System.in);
                  System.out.println("Enter new position: ");
                  newEntry = input.nextLine();
                  current.position = newEntry;
                  break;      
               case 'g':
                  System.out.println("Returning to Main.");
                  check3 = false; 
                  break; 
               default:
                  System.out.print("Invalid entry\n");  
            }
         }   

      }
      
      public static void displayAll(){
         Node current = first;
         current.displayNodeAllTitles();   
         while(current != null){
            current.displayNodeAll();
            current = current.next;
         }  
      }
      
      public static void writeFile(){
         try{
            PrintWriter writer = new PrintWriter("masterFile.txt", "UTF-8");
            Node current = first;
            while(current != null){
               writer.println(current.nNumber);
               writer.println(current.preferredName);
               writer.println(current.firstName);
               writer.println(current.middleI);
               writer.println(current.lastName);
               writer.println(current.gPA);
               writer.println(current.position);
               writer.println(current.clubName);
               writer.println("");
               current = current.next;
            }
            writer.println("END");
            writer.close();        
         }catch (IOException e){
            e.printStackTrace();
         }

                  
      }
      
      public static void newClub(){
         Scanner input = new Scanner(System.in);
      
         System.out.print("Enter the name of your new club: ");
         String newClubName = input.next();
         
         System.out.println("Enter the name of the file with the information of the members: ");
         String fileName = input.next();
         
         System.out.println("");
         
         File file = new File(fileName + ".txt");   
         if (!file.exists()) {
            System.out.println(fileName + " does not exist.");
         return;
         }
   
         if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
         return;
         }
         
         String nNumber1 = "";
         String preferredName = "";
         String firstName1 = "";
         String middleI1 = "";
         String lastName1 = "";
         double gpa = 0;
         String position1 = "";
         
         int counter = 0;
         
         try{
            Scanner sc = new Scanner(new FileInputStream(file));
            while(sc.hasNext()){
               if(counter == 0){
                  nNumber1 = sc.next();
                  counter++;
               }else if(counter == 1){
                  preferredName = sc.next();
                  counter++;
               }else if(counter == 2){
                  firstName1 = sc.next();
                  counter++;
               }else if(counter == 3){
                  middleI1 = sc.next();
                  counter++;
               }else if(counter == 4){
                  lastName1 = sc.next();
                  counter++;
               }else if(counter == 5){
                  gpa = Double.parseDouble(sc.next());
                  counter++;
               }else if(counter == 6){
                  position1 = sc.next();
                  counter++;
               }else if(counter == 7){
                  addLast(nNumber1, preferredName, firstName1, middleI1, lastName1, gpa, position1, newClubName);
                  counter = 0;
               }
            }           
                 
         }catch (IOException e){
            e.printStackTrace();
         }

      } 
   }     
} 

  