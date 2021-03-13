package ro.fasttrackit.homeWork1;


import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class Project {
    private final String name;
    private final int price;
    private final String description;
    private final List<Category> categoryList;

    public Project(String name, int price, String description, List<Category> categoryList) {
        this.name = name;
        this.price = price;
        this.description = description;
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

    public List<Category> getCategoryList() {
        return new ArrayList<>(categoryList);
    }

    static class ProjectBuilder {
        private String name;
        private int price;
        private String description;
        private List<Category> categories = new ArrayList<>();

        public static ProjectBuilder project() {
            return new ProjectBuilder();
        }

        public ProjectBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProjectBuilder price(int price) {
            this.price = price;
            return this;
        }

        public ProjectBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProjectBuilder category(Category category) {
            if (category != null) {
                this.categories.add(category);
            }
            return this;
        }

        public Project build() {
            return new Project(name, price, description, categories);
        }

    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", categoryList=" + categoryList +
                '}';
    }
}
