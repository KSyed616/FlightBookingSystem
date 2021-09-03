package lab1;

abstract class Passenger {
    
    public abstract double applyDiscount(double p);
    public abstract double getDiscPrice();
    String name;
    int age;
    
    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String Name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}

class Member extends Passenger{
    
    int year;
    double discPrice;
    
    public Member(String name, int age, int year){
        super(name, age);
        this.year = year;
    }
    
    public double applyDiscount(double p){
        if(year>5){
            discPrice = p-(0.50*p);
            return (p-(0.50*p));
        }
        else if(year>1 && year<=5){
            discPrice = p-(0.10*p);
            return (p-(0.10*p));
        }
        else{
            discPrice = p;
            return p;
        }
    }
    
    public double getDiscPrice(){
        return discPrice;
    }
}

class nonMember extends Passenger{
    
    double discPrice;
    
    public nonMember(String name, int age){
        super(name, age);
    }
    
    public double applyDiscount(double p){
        if(age>=65){
            discPrice = p-(0.10*p);
            return (p-(0.10*p));
        }
        else{
            discPrice = p;
            return p;
        }
    }
    
    public double getDiscPrice(){
        return discPrice;
    }
    
}