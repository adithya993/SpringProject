package org.practiceprojects;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*// Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }*/

        ProductService service = new ProductService();
        /*service.addProduct(new Product("Dell G7","Laptop", "Left Table",2019));
        service.addProduct(new Product("Dell Monitor","Monitor", "Left Table",2023));
        service.addProduct(new Product("Logitech Wireless Keyboard","Keyboard", "Left Table",2024));
        service.addProduct(new Product("Logitech Wireless Mouse","Mouse", "Left Table",2024));
        service.addProduct(new Product("JBL BT750NC","Headphones White", "Left Table",2018));
        service.addProduct(new Product("Dell Integrated Camera","Web Camera", "Left Table",2018));
        service.addProduct(new Product("Dell Integrated Speaker","Speaker", "Left Table White",2018));
        service.addProduct(new Product("HP Monitor","Monitor", "Left Table",2022));
        service.addProduct(new Product("Chinese Lamp","Night Lamp", "Right Table",2021));
        service.addProduct(new Product("Lenovo Laptop","Laptop", "Right Table",2019));
        service.addProduct(new Product("Table Clock white","Clock", "Left Table",2016));
        service.addProduct(new Product("Powerbank","Powerbank", "Right Table",2020));
        service.addProduct(new Product("iPad Mini","iPad", "Right Table",2016));
        service.addProduct(new Product("Extension Cord","Extension Cord", "Right Table",2022));
        service.addProduct(new Product("Tesla Car","Toy", "Center Table",2024));*/

        List<Product> products = service.getAllProducts();
        int ii = 1;
        for(Product i : products)
            System.out.println(ii++ + " " + i.toString());

        System.out.println("____________________________________________________________________________________________");

        System.out.println("Particular name search");
        Product findByNameProduct = service.getProduct("Extension Cord");
        System.out.println(findByNameProduct);


        System.out.println("____________________________________________________________________________________________");

        ii = 1;
        System.out.println("Particular text search");
        List<Product> findByTextMatchProduct = service.getProductWithText("White".toLowerCase());
        for(Product i : findByTextMatchProduct)
            System.out.println(ii++ + " " + i.toString());


        System.out.println("____________________________________________________________________________________________");

        System.out.println("Particular place search");
        List<Product> findByPlaceProduct = service.getProductInPlace("Left Table".toLowerCase());
        findByPlaceProduct.stream().forEach(i -> {System.out.println(i.toString());});


        System.out.println("____________________________________________________________________________________________");

        System.out.println("Out of Warranty search");
        List<Product> findOutOfWarrantyProduct = service.getProductOutOfWarranty();
        findOutOfWarrantyProduct.forEach(i -> {System.out.println(i.toString());});


        System.out.println("____________________________________________________________________________________________");

        System.out.println("In Warranty search");
        List<Product> findInWarrantyProduct = service.getProductInWarranty();
        findInWarrantyProduct.forEach(i -> {System.out.println(i.toString());});
    }
}