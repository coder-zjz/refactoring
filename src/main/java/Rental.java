public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge() {
        double result = 0;
        //determine amounts for each line
        return _movie.getCharge(this._daysRented);
    }

    public int getFrequentRenterPoint() {
        return this._movie.getFrequentRenterPoint(this._daysRented);
    }
}
