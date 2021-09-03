
package lab1;

public class Ticket {
    private Passenger p;
    private Flight f;
    private double price;
    private static int num;
    private int tickNum;
    
    public Ticket(Passenger p, Flight f, double price){
        this.p = p;
        this.f = f;
        this.price = price;
        tickNum = tickNum+num;
        num++;
    }
    
    public void setPassenger(Passenger p){
        this.p = p;
    }
    public Passenger getPassenger(){
        return p;
    }
    
    public void setFlight(Flight f){
        this.f = f;
    }
    public Flight getFlight(){
        return f;
    }
    
    public void setPrice(double price){
        price = p.getDiscPrice();
    }
    public double getPrice(){
        return price;
    }
    
    public void setNum(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
    
    @Override
    public String toString(){
        String returnStg = "\n"+p.getName()+
                "\nTicket Number: "+tickNum+
                "\nFlight Number: "+f.getFlightNum()+
                "\n"+f.getOrigin()+" to "+f.getDestination()+
                "\nDeparture Time: "+f.getDepartureTime()+
                "\nOriginal Price: "+f.getOrigPrice()+
                "\nTicket Price: "+price;
        return returnStg;
    }
}
