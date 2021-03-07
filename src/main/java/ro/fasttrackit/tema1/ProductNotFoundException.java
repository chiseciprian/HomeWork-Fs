package ro.fasttrackit.tema1;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException() {
        super("This product doesn't exist");
    }
}
