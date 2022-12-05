import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental rental) {
        this._rentals.add(rental);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        double totalAmount = 0;
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            //show figure for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + "frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getFrequentRenterPoint();
        }

        return result;
    }
}
