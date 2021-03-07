package ro.fasttrackit.tema1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shop {
    private final List<Product> products;

    public Shop(List<Product> products) {
        if (products != null) {
            this.products = products.stream()
                    .filter(product -> product.getPrice() > 0)
                    .filter(product -> product.getInventory() > 0)
                    .filter(distinctByKey(Product::getName))
                    .collect(Collectors.toList());
        } else {
            this.products = new ArrayList<>();
        }
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        boolean productExist = isProductExist(product.getName());
        if (productExist) {
            updateProduct(product);
        } else {
            this.products.add(product);
        }
    }

    public void buyProduct(String productName, int quantity) throws ProductNotFoundException {
        if (isProductExist(productName)) {
            Product product = getProductByName(productName);
            if (product.getInventory() - quantity >= 0) {
                product.setInventory(product.getInventory() - quantity);
                updateProduct(product);
                System.out.println("Transaction successful");
            } else {
                System.out.println("Actual stock is " + product.getInventory());
            }
        } else {
            throw new ProductNotFoundException();
        }
    }

    private Product getProductByName(String productName) {
        return products.stream()
                .filter(prod -> prod.getName().equals(productName))
                .collect(Collectors.toList())
                .get(0);
    }

    private boolean isProductExist(String name) {
        return products.stream()
                .anyMatch(prod -> prod.getName().equals(name));
    }

    private void updateProduct(Product product) {
        for (Product prod : this.products) {
            if (prod.getName().equals(product.getName())) {
                prod.setPrice(product.getPrice());
                prod.setCategoryList(product.getCategoryList());
                prod.setDescription(product.getDescription());
                prod.setInventory(product.getInventory());
            }
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
