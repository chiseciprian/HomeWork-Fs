package ro.fasttrackit.tema1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class Product {
    private final String name;
    private  int price;
    private  String description;
    private  int inventory;
    private  List<Category> categoryList;

    public Product(String name, int price, String description, int inventory, List<Category> categoryList) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventory = inventory;
        this.categoryList = ofNullable(categoryList)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getInventory() {
        return inventory;
    }

    public List<Category> getCategoryList() {
        return new ArrayList<>(categoryList);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", inventory=" + inventory +
                ", categoryList=" + categoryList +
                '}';
    }
}
