/**
 * Created by charly on 26/03/16.
 */
public class SaleLine {
    private int nup;    // Unitats producte
    private Product product;

    public SaleLine() {
        // TODO: 26/03/16
    }
    public SaleLine(int nup, Product product) {
        this.nup=nup;
        this.product=product;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleLine saleLine = (SaleLine) o;

        return !(product != null ? !product.equals(saleLine.product) : saleLine.product != null);
    }

    public void setProducte(Product producte) {
        product=producte;
    }

    public void setNup(int nup){
        this.nup=nup;
    }

    public int getNup() {
        return nup;
    }
    public Product getProduct() {
        return product;
    }
}
