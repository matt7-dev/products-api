package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//tells Spring to create one ProductService when the app starts.
@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
//        products.add(new Product(1L, "Laptop", 999.99));
//        products.add(new Product(2L, "Mouse", 24.99));
//        products.add(new Product(3L, "Keyboard", 59.99));
        products.add(new DigitalProduct( 1L,"Virus Guard",1500,"httpDownload", 14.5));
        products.add(new PhysicalProduct(2L,"Graphics Card",999999,1,"50x50x30"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Product> getProductByName(String name){
        return products.stream().filter(p-> p.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public boolean removeProduct(Long id) {
        return products.removeIf(p ->
                p.getId().equals(id)
        );
    }

    public List<String> getAllSummaries(){
        List<String> summaries = new ArrayList<>();
        for (Product p : products){
//            p.applyDiscount(0.10);
            if (p instanceof Discountable d) {
                d.applyDiscount(0.10);
            }
            summaries.add(p.getSummary());
        }
        return summaries;
    }

}
