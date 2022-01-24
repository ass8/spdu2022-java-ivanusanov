import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Comparator;

public class Buyer implements Comparable<Buyer>{
  private final String fullName;
  Calendar dateOfPurchase;
  private final String phoneNum;
  private final int price;
  private boolean active =false;

    public Buyer(String fullName, Calendar dateOfPurchase, String phoneNum, int price){
         this.fullName = fullName;
         this.dateOfPurchase = dateOfPurchase;
         this.phoneNum = phoneNum;
         this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public Calendar getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getFullName() {
        return fullName;
    }

    /*
     *   Проверка даты
     */
    public void checkDate(Buyer buyer){
        active = buyer.getDateOfPurchase().get(Calendar.MONTH) == 8;
    }
    public boolean checkUserExistAndActive(Buyer buyer, Buyer[] arr){
        boolean isUserExistAndActive = false;
        for (Buyer ex:
             arr) {
            if (Objects.equals(buyer.getFullName(), ex.getFullName()) && ex.isActive()) {
                isUserExistAndActive = true;
                buyer.active = true;
                break;
            }
        }
        return isUserExistAndActive;
    }


    /*
     *  Сравнение по стоимости
     */
    public int compareTo(Buyer buyer){
        return Integer.compare(buyer.getPrice(), this.getPrice());
    }
    @Override
    public String toString() {
        return "   -   " + this.fullName + " (" + this.phoneNum + ") " + ": " + "$" + this.price;
    }
    static class PersonNameComparator implements Comparator<Buyer>{

        public int compare(Buyer a, Buyer b){

            return a.getFullName().compareTo(b.getFullName());
        }
    }
}




