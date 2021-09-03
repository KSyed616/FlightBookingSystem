package lab1;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    
    ArrayList<Flight> flights = new ArrayList<Flight>();
    Scanner in = new Scanner(System.in);
    
    public void createflights(){
        System.out.println("How many flights are there?");
        int numOfFlights = in.nextInt();
        
        for(int i = 0; i<numOfFlights; i++){
            System.out.println("Enter the flight number:");
            int flightNum = in.nextInt();
            
            in.nextLine();
            
            System.out.println("Enter the starting point of the flight: ");
            String origin = in.nextLine();
            
            System.out.println("Enter the destination of the flight: ");
            String destination = in.nextLine();
            
            System.out.println("Enter the departure time of the flight: ");
            String time = in.nextLine();
            
            System.out.println("Enter the capacity of the flight:");
            int capacity = in.nextInt();

            System.out.println("Enter the original price of the ticket:");
            double price = in.nextDouble();
            
            Flight f = new Flight(flightNum, origin, destination, time, capacity, price);
            
            flights.add(f);
            
            System.out.println("\n");
        }
    }
    
    public void displayAvailableFlights(String origin, String destination){
        for(int i = 0; i<flights.size(); i++){
            if(flights.get(i).getOrigin().equals(origin)&&flights.get(i).getDestination().equals(destination)){
                System.out.println(flights.get(i));
            }
        }
    }
    
    public Flight getFlight(int flightNum){
        for(int i = 0; i<flights.size(); i++){
            if(flights.get(i).getFlightNum() == flightNum){
                return flights.get(i);
            }
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        for(int i = 0; i<flights.size(); i++){
            if(flights.get(i).getFlightNum() == flightNumber){
                if(flights.get(i).getSeatsLeft()>0){
                    
                    p.applyDiscount(flights.get(i).getOrigPrice());
                    
                    Ticket t = new Ticket(p, flights.get(i), p.getDiscPrice());
                    System.out.println(t);
                }
                else{
                    System.out.println("\nNo seats available");
                }
            }
            else{
                System.out.println("\nNo flight of this number exists");
            }
        }
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Manager m = new Manager();
        m.createflights();
        
        System.out.println("\n\nDo you want to get the information of a flight? (1 for yes, 2 for no)");
        int info = in.nextInt();
        String first = "";
        String second = "";
        
        while(info == 1){
            System.out.println("\nWhich method will you use to get information of a flight:"
                    + "\n1 for location"
                    + "\n2 for flight number");
            int info2 = in.nextInt();
            if(info2 == 1){
                System.out.println("\nWhere are you travelling from?");
                first = in.next();
                
                System.out.println("\nWhere are you travelling to?");
                second = in.next();
                
                m.displayAvailableFlights(first, second);
            }
            if(info2 == 2){
                System.out.println("\nEnter the flight number: ");
                int flightNum = in.nextInt();
                
                System.out.println(m.getFlight(flightNum));
            }
            System.out.println("\n\nDo you want to get the information of a flight? (1 for yes, 2 for no)");
            info = in.nextInt();
        }
        System.out.println("\n\nDo you want to book a ticket for a new passenger?(1 for yes, 2 for no)");
        int book = in.nextInt();
        
        while(book == 1){
            System.out.println("\nWhat is the flight number of the flight you want to book for?");
            int flightNum = in.nextInt();
            
            for(int i = 0; i<m.flights.size(); i++){
                if(m.flights.get(i).getFlightNum() == flightNum){
                    if(m.flights.get(i).getSeatsLeft()>0){
                        System.out.println("There are available seats");
                        
                        System.out.println("\nEnter the passengers name: ");
                        String name = in.next();
                        
                        in.nextLine();
                    
                        System.out.println("\nEnter the passengers age: ");
                        int age = in.nextInt();
                        
                        System.out.println("\nIs the passeneger a member or not? (1 for member, 2 for non-member");
                        int member = in.nextInt();
                        
                        if(member == 1){
                            System.out.println("\nHow many years have they been a member?");
                            int years = in.nextInt();
                            
                            Member mem = new Member(name, age, years);
                            m.bookSeat(flightNum, mem);
                        }
                        if(member == 2){
                            nonMember non = new nonMember(name, age);
                            m.bookSeat(flightNum, non);
                        }
                    }
                    else if(m.flights.get(i).getSeatsLeft()<=0){
                        System.out.println("No seats are available on this flight");
                    }
                }
            }
            System.out.println("\n\nDo you want to book a ticket for a new passenger?(1 for yes, 2 for no)");
            book = in.nextInt();
        }
    }
}
