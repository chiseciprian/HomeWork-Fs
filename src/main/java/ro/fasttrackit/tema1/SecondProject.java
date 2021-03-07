package ro.fasttrackit.tema1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class SecondProject {
    private String name;
    private int price;
    private String description;
    private List<Category> categoryList = new ArrayList<>();

    private SecondProject() {
    }

    private SecondProject(String name, int price, String description, List<Category> categoryList) {
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

    static class SecondProjectBuilder {
        private final SecondProject secondProject = new SecondProject();

        public static SecondProjectBuilder secondProject() {
            return new SecondProjectBuilder();
        }

        public SecondProjectBuilder name(String name) {
            this.secondProject.name = name;
            return this;
        }

        public SecondProjectBuilder price(int price) {
            this.secondProject.price = price;
            return this;
        }

        public SecondProjectBuilder description(String description) {
            this.secondProject.description = description;
            return this;
        }

        public SecondProjectBuilder category(Category category) {
            if (category != null) {
                this.secondProject.categoryList.add(category);
            }
            return this;
        }

        public SecondProject build() {
            return secondProject;
        }
    }

    @Override
    public String toString() {
        return "SecondProject{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", categoryList=" + categoryList +
                '}';
    }
}
