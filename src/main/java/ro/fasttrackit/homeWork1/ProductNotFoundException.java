package ro.fasttrackit.homeWork1;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException() {
        super("This product doesn't exist");
    }
}
