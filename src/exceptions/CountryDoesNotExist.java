package exceptions;

public class CountryDoesNotExist extends Exception {
    public CountryDoesNotExist(String message){
        super(message);
    }
}
