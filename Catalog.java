import java.util.HashSet;

/**
 * Created by charly on 26/03/16.
 */
public class Catalog {
    private String name;
    private HashSet<Product> products;

    public Catalog() {
        this("Sense nom");
    }
    public Catalog(String name) {
        this.name=name;
        products=new HashSet<>();
    }
    public boolean add(Product product) {
        return products.add(product);
    }
    public boolean remove(Product product) {
        return products.remove(product);
    }
    public Product search(int ean) {
        Product buscar = new Product(ean);
        if (products.contains(buscar)) {
            for (Product p:products) {
                if (p.equals(buscar)) {
                    return p;
                }
            }
        }
        return null;
    }
    public int productsNumber() {
        return products.size();
    }
    public HashSet<Product> getProducts() {
        return products;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        return !(name != null ? !name.equals(catalog.name) : catalog.name != null);

    }
}
