package Modules;

import enums.Category;

public class Product {
    private String code;
    private String name;
    private double price;
    private Category category;

    public Product(String code, String name, double price, Category category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
