public class BookList{

    private String first;
    private String last;
    private String phoneNumber;
    private String address;
    public BookList next;
    //Node class
    public BookList(String first, String last, String phoneNumber, String address){

        this.first = first;
        this.last = last;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.next = null;

    }

    public BookList getNext(){//getter method

        return next;
    }
    public void setNext(BookList newNode){ //setter method for

        this.next = newNode;
    }
    public void setFirst(String first){ //setter method for

        this.first = first;
    }
    public void setLast(String last){ //setter method for

        this.last = last;
    }
    public void setPN(String phoneNumber){ //setter method for

        this.phoneNumber = phoneNumber;

    }
    public void setAddress(String address){ //setter method for

        this.address = address;

    }
    public String getFirst(){ //getter method

        return first;
    }

    public String getLast(){ //getter method

        return last;
    }

    public void print(){

        System.out.println("First Name: " + first);
        System.out.println("Last Name: " + last);
        System.out.println("Phone #: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}