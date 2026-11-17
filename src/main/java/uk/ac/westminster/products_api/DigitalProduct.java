package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    // no-arg constructor for Jackson POST operations
    public DigitalProduct() {
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public String getSummary() {
        return "this is the digital product. download url: " + downloadUrl + ". name " + getName();
    }

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice() * (1-rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
