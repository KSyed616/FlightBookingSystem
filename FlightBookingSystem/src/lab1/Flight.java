
package lab1;

public class Flight {
    private int flightNum;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int seatsLeft;
    private double originalPrice;
    
    public Flight(int flightNum, String origin, String destination, String departureTime, int capacity, double originalPrice){
        if(origin.equalsIgnoreCase(destination)){
            throw new IllegalArgumentException("The destination and origin cannot be the same");
        }
        this.flightNum = flightNum;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        seatsLeft = capacity;
    }

    Flight(int i, String string, String string0, String string1, String string2, int i0, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setFlightNum(int flightNum){
        this.flightNum = flightNum;
    }
    public int getFlightNum(){
        return flightNum;
    }
    
    public void setOrigin(String origin){
        this.origin = origin;
    }
    public String getOrigin(){
        return origin;
    }
    
    public void setDestination(String destination){
        this.destination = destination;
    }
    public String getDestination(){
        return destination;
    }
    
    public void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }
    public String getDepartureTime(){
        return departureTime;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    
    public void setSeatsLeft(int seatsLeft){
        this.seatsLeft = seatsLeft;
    }
    public int getSeatsLeft(){
        return seatsLeft;
    }
    
    public void setOrigPrice(double originalPrice){
        this.originalPrice = originalPrice;
    }
    public double getOrigPrice(){
        return originalPrice;
    }
    
    public boolean bookASeat(){
        if(seatsLeft>0){
            seatsLeft-=1;
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        String returnStg = "Flight "+flightNum+
                "\n "+origin+" to "
                +destination+" \n"
                +departureTime+
                "\noriginal price:"
                +originalPrice+"$";
        return returnStg;
    }
}
