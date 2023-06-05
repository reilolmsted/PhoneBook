import java.util.*;
public class BookManager{
    private BookList head;
    private Scanner input;

    public BookManager(){
        this.head = null;
        input = new Scanner(System.in);
    }
    public void menu(Scanner input){
        String begin;
        do{
            System.out.println("To use this phone book, follow the directions as below: ");
            System.out.println("Press 'a' to add contents to the phone book");
            System.out.println("Press 's' to search for a contact in the book");
            System.out.println("Press 'm' to modify existing contacts in the phone book");
            System.out.println("Press 'd' to delete existing contacts in the phone book");
            System.out.println("Press 'e' to exit the phone book");
            begin = input.next().toLowerCase();

            switch(begin){
                case "a":
                    add(input);
                    break;
                case "s":
                    search(input);
                    break;
                case "m":
                    modify(input);
                case "d":
                    delete();
                    break;
                case "e":
                    System.out.println("Goodbye");
                    break;
            }
        }while(!begin.equals("e"));
    }
    private void add(Scanner s){
        System.out.println("Type first name: ");
        String firstName = s.next().toLowerCase();
        System.out.println("Type last name: ");
        String lastName = s.next().toLowerCase();
        System.out.println("Type phone number: ");
        String pNumber = s.next();
        System.out.println("Type address: ");
        String newAddress = s.next();

        if(head == null)
            head = new BookList(firstName, lastName, pNumber, newAddress);
        else{
            BookList temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = new BookList(firstName, lastName, pNumber, newAddress);
        }
    }

    private BookList search(Scanner s){

        System.out.println("Type the first & last name of the contact you wish to view");

        String firstName = s.next().toLowerCase();
        String lastName = s.next().toLowerCase();
        BookList search = head;
        System.out.println(search.getFirst().equals(firstName));
        System.out.println(search.getLast().equals(lastName));
        while(!(search.getFirst().equals(firstName) && search.getLast().equals(lastName)))
            search = search.next;

        search.print();

        return search;
    }
    private void modify(Scanner s){

        BookList temp = search(input);
        temp.print();
        System.out.println("To change first name press '1'");
        System.out.println("To change last name press '2'");
        System.out.println("To change phone # press '3'");
        System.out.println("To change address press '4'");
        String entry = s.next();

        switch(entry){
            case "1":
                System.out.println("Type the new first name");
                temp.setFirst(s.next().toLowerCase());
                break;
            case"2":
                System.out.println("Type the new last name");
                temp.setLast(s.next().toLowerCase());
                break;
            case"3":
                System.out.println("Type the new phone #");
                temp.setPN(s.next().toLowerCase());
                break;
            case"4":
                System.out.println("Type the new address");
                temp.setAddress(s.next().toLowerCase());
                break;
            default:
                System.out.println("Try a new command");
        }
        temp.print();
    }
    private void delete(){

        BookList temp = search(input);
        BookList prev = head;

        if(temp == head){ //first node delete
            head = head.next;
            temp.next = null;
            return;
        }else if(temp.next == null){//last node delete
            while(prev.next !=temp)//moves prev to next node until temp
                prev = prev.next;

            prev.next = null;

        }else{
            while(prev.next !=temp)
                prev = prev.next;

            prev.next = temp.next;
        }
        temp = null;
    }
}