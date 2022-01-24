import java.util.*;

public class Main{
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2021, 6 , 15);
        Calendar calendar1 = new GregorianCalendar(2021,8,15);
        Calendar calendar2 = new GregorianCalendar(2021,8,15);
        Calendar calendar3 = new GregorianCalendar(2021,8,15);
        Calendar calendar4 = new GregorianCalendar(2021,6,15);
        Calendar calendar5 = new GregorianCalendar(2021,7,15);

        Buyer person = new Buyer("Adam Brown", calendar, "097 111 22 33", 300);
        Buyer person1= new Buyer("Adam Brown", calendar1, "097 111 22 33", 800);
        Buyer person3= new Buyer("Robert C. Martin", calendar3, "097 111 33 22", 250);
        Buyer person4= new Buyer("Tom Hanks", calendar4, "096 222 33 44", 200);
        Buyer person2= new Buyer("Alex Fox" , calendar2, "050 111 22 33", 500);
        Buyer person5= new Buyer("Bill Gates", calendar5, "097 777 77 77", 1000);

        Comparator<Buyer> pcomp = new Buyer.PersonNameComparator();

        person.checkDate(person);
        person1.checkDate(person1);
        person2.checkDate(person2);
        person3.checkDate(person3);
        person4.checkDate(person4);
        person5.checkDate(person5);

        Buyer[] persons = new Buyer[6];
        persons[0] = person;
        persons[4] = person1;
        persons[2] = person2;
        persons[3] = person3;
        persons[1] = person4;
        persons[5] = person5;

       Arrays.sort(persons,pcomp);

            /*
            * Вывод для активных покупателей
            */
        System.out.println("Active buyers:" + "\nJune");
        boolean flag = true;
        for (Buyer buyer:
             persons) {

                if (buyer.getDateOfPurchase().get(Calendar.MONTH) == 6 && buyer.isActive()){
                    System.out.println(buyer);
                    flag = false;
                }
                if (buyer.checkUserExistAndActive(buyer, persons) && buyer.getDateOfPurchase().get(Calendar.MONTH) == 6){
                    System.out.println(buyer);
                    flag = false;
                }

            }
        if(flag) {System.out.println("   -   none"); }else flag = true;
        System.out.println("July");
        for (Buyer buyer:
                persons) {
            if(buyer.getDateOfPurchase().get(Calendar.MONTH) == 7 && buyer.isActive()) {
                System.out.println(buyer);
                flag = false;
            }
        }
        if(flag) {System.out.println("   -   none"); }else flag = true;

        System.out.println("August");
        for (Buyer buyer:
                persons) {
            if(buyer.getDateOfPurchase().get(Calendar.MONTH) == 8 && buyer.isActive()){
                System.out.println(buyer);
                flag = false;
            }
        }
        if(flag) {System.out.println("   -   none"); }else flag = true;

        /*
         * Вывод для неактивных покупателей
         */
        System.out.println("\nInactive buyers:" + "\nJune");
        for (Buyer buyer:
                persons) {
            if(buyer.getDateOfPurchase().get(Calendar.MONTH) == 6 && !buyer.isActive()){
                System.out.println(buyer);
                flag = false;
            }
        }
        if(flag) {System.out.println("   -   none"); }else flag = true;
        System.out.println("July");
        for (Buyer buyer:
                persons) {
            if(buyer.getDateOfPurchase().get(Calendar.MONTH) == 7 && !buyer.isActive()){
                System.out.println(buyer);
                flag = false;
            }
        }
        if(flag) {System.out.println("   -   none"); }else flag = true;
        System.out.println("August");
        for (Buyer buyer:
                persons) {
            if(buyer.getDateOfPurchase().get(Calendar.MONTH) == 8 && !buyer.isActive()){
                System.out.println(buyer);
                flag = false;
            }
        }
        if(flag) {System.out.println("   -   none"); }else flag = true;

        }
    }

