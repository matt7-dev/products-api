// "A PhysicalProduct IS-A Product because is carries the same id, name and price. Because it is a child of the Product class"
// "A ShoppingCart is a Product" is false. a cart CONTAINS products. That is HAS-A, so
// it gets a List<Product> field, not extends.
package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;


    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
