package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
                for (int j = index + 1; j < products.length; j++) {
                        Product temp = products[j - 1];
                        products[j - 1] = products[j];
                        products[j] = temp;
                }
        products[products.length - 1] = null;
        return products;
    }
}