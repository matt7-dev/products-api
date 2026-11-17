package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//tells Spring this class handles web requests and returns data (JSON) directly, not HTML pages.
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/products/search")
    public List<Product> getProductByName(@RequestParam("name") String nama) {
        return productService.getProductByName(nama);
    }

    @PostMapping("/products")
    public Product addProduct (@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct (@PathVariable Long id){
        return productService.removeProduct(id) ? ("Deleted " + id) : "Delete unsuccessful";
    }

}


