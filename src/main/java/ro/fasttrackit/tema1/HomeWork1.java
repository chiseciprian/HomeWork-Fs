package ro.fasttrackit.tema1;

import ro.fasttrackit.tema1.Project.ProjectBuilder;

import java.util.ArrayList;
import java.util.List;

public class HomeWork1 {

    public static void main(String[] args) throws ProductNotFoundException {
        checkImmutability();
        System.out.printf("---------------------------------");
        System.out.println();
        projectBuilder();
        System.out.printf("---------------------------------");
        System.out.println();
        secondProjectBuilder();
        System.out.printf("---------------------------------");
        System.out.println();
        shopExercises();
    }

    private static void shopExercises() throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", 12, "description1", 12, List.of(Category.CLOTHES)));
        products.add(new Product("product1", 15, "description2", 5, List.of(Category.DYI)));
        Shop shop = new Shop(products);
        System.out.println(shop);
        shop.addProduct(new Product("product1", 3333, "description1", 12, List.of(Category.CLOTHES, Category.DYI)));
        shop.addProduct(new Product("product2", 13, "description2", 13, List.of(Category.CLOTHES)));
        shop.buyProduct("product2", 13);
        System.out.println(shop);
    }

    private static void secondProjectBuilder() {
        SecondProject secondProject = SecondProject.SecondProjectBuilder.secondProject()
                .name("randomName")
                .price(123)
                .description("randomDescription")
                .category(Category.CLOTHES)
                .category(null)
                .build();
        System.out.println(secondProject);
    }

    private static void projectBuilder() {
        Project project = ProjectBuilder.project()
                .name("randomName")
                .price(123)
                .description("randomDescription")
                .category(Category.CLOTHES)
                .category(Category.DYI)
                .build();
        System.out.println(project);
    }

    private static void checkImmutability() {
        List<Category> categories = new ArrayList<>();
        categories.add(Category.CLOTHES);
        Project project = new Project("randomName", 1234, "randomDescription", categories);
        categories.add(Category.DYI);
        project.getCategoryList().clear();
        System.out.println(project);
        Project project2 = new Project("randomName", 1234, "randomDescription", null);
        System.out.println(project2);
        Project project3 = new Project("randomName", 1234, "randomDescription", List.of(Category.values()));
        System.out.println(project3);
    }
}
