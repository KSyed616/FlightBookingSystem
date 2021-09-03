/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author syedk
 */
public class FlightTest {
    int flightNum = 1030;
    String origin = "Toronto";
    String destination = "Kolkata";
    String date = "03/02/99 7:50 PM";
    int capacity = 100;
    double originalPrice = 1000;
    
    @Test
    public void FlightTest() {
        Flight test = new Flight(flightNum, origin, destination, date, capacity, originalPrice);
        assertEquals(flightNum, test.getFlightNum());
        assertSame(origin, test.getOrigin());
        assertSame(destination, test.getDestination());
        assertSame(date, test.getDepartureTime());
        assertEquals(capacity, test.getCapacity());
        assertEquals(originalPrice, test.getOrigPrice(), 0f);
        
    }

    /**
     * Test of setFlightNum method, of class Flight.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor(){
        String newDest = "Toronto";
        Flight test = new Flight(flightNum, origin, newDest, date, capacity, originalPrice);
    }
    
    @Test
    public void testGetandSet(){
        Flight test = new Flight(flightNum, origin, destination, date, capacity, originalPrice);
        
        test.setFlightNum(111);
        assertEquals(111,test.getFlightNum());
        
        test.setOrigin("Pakistan");
        assertSame("Pakistan", test.getOrigin());
        
        test.setDestination("Italy");
        assertSame("Italy", test.getDestination());
        
        test.setDepartureTime("30/01/2001 8:53 AM");
        assertSame("30/01/2001 8:53 AM", test.getDepartureTime());
        
        test.setCapacity(100);
        assertEquals(100, test.getCapacity());
        
        test.setSeatsLeft(50);
        assertEquals(50, test.getSeatsLeft());
        
        test.setOrigPrice(5000);
        assertEquals(5000, test.getOrigPrice(), 0f);
    }
    
    @Test
    public void testBookASeat(){
        Flight test = new Flight(flightNum, origin, destination, date, capacity, originalPrice);
        
        for(int i = 0; i<30; i++){
            test.bookASeat();
        }
        assertEquals(70, test.getSeatsLeft());
    }
    
    @Test
    public void testToString(){
        Flight test = new Flight(flightNum, origin, destination, date, capacity, originalPrice);
        
        String expected = "Flight "+flightNum+
                "\n "+origin+" to "
                +destination+" \n"
                +date+
                "\noriginal price:"
                +originalPrice+"$";
        assertEquals(expected, test.toString());
    }
}
