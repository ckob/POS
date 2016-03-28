/**
 * Created by charly on 26/03/16.
 */
public class Product {
    private int ean;
    private String description;
    private String brand;
    private double price;

    public Product() {
        // TODO: 26/03/16
    }
    public Product(int ean) {
        this(ean, "No definit", "No definit", 0);
    }
    public Product(int ean, String description, String brand, double price) {
        this.ean=ean;
        this.description=description;
        this.brand=brand;
        this.price=price;

    }

    @Override
    public int hashCode() {
        return ean;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return ean == product.ean;

    }

    @Override
    public String toString() {
        return "ean = [" + ean + "], description = [" + description + "], brand = [" + brand + "], price = [" + price + "]";
    }

    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
}
