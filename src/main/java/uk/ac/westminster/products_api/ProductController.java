package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//tells Spring this class handles web requests and returns data (JSON) directly, not HTML pages.

@RequestMapping("/products")
//goes on the class, sets the common URL prefix for every endpoint inside it. So every method's path gets /products stuck in front.
public class ProductController {

    @GetMapping("/{id}")
    //goes on the method. {id} is a placeholder in the URL (e.g. /products/1, /products/42).
    public Product getById(@PathVariable Long id) {
    //grabs whatever value was in {id} from the URL and passes it into the method as the id parameter.
        return new Product(id, "Laptop", 999.99);
        //The method body just hardcodes a Product for now (name "Laptop", price 999.99) — you're not storing real data yet, just proving the endpoint returns an object.
    }
}
