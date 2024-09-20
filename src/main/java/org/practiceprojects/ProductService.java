package org.practiceprojects;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();
    public void addProduct(Product objProduct){
        products.add(objProduct);
        db.save(objProduct);
    }

    public List<Product> getAllProducts() {
        return db.getAllproducts();
    }

    public Product getProduct(String name) {
        return db.getProduct(name);
//        for(Product p : products){
//            if(p.getName().equals(name))
//                return p;
//        }
//        return new Product();
    }

    public List<Product> getProductWithText(String text) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(text) || p.getType().toLowerCase().contains(text) || p.getPlace().toLowerCase().contains(text))
                .toList();
    }

    public List<Product> getProductInPlace(String place) {
        List<Product> productsInPlaceMatch = new ArrayList<>();
        for(Product p : products){
            if(p.getPlace().toLowerCase().contains(place))
                productsInPlaceMatch.add(p);
        }
        return productsInPlaceMatch;
    }

    public List<Product> getProductOutOfWarranty() {

        return products.stream()
                .filter(s->Year.now().getValue() - s.getWarranty() > 1)
                .toList();
    }

    public List<Product> getProductInWarranty() {
        return products.stream()
                .filter(s->Year.now().getValue() - s.getWarranty() <= 1)
                .toList();
    }
}
