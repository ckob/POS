import java.util.HashSet;
import java.util.Scanner;

public class Sale {

    private int code;
    private String datetime;
    private HashSet<SaleLine> saleLines;


    public Sale() {
        // TODO: 26/03/16
    }
    public Sale(int code, String datetime) {
        this.code=code;
        this.datetime=datetime;
        saleLines = new HashSet<>();
    }
    public boolean add(SaleLine sl) {
        return saleLines.add(sl);
    }
    public boolean remove(SaleLine sl) {
        return saleLines.remove(sl);
    }
    public double totalAmount() {
        double total=0;
        for (SaleLine s : saleLines) {
            total+=s.getProduct().getPrice()*s.getNup();
        }
        return total;
    }

    @Override
    public int hashCode() {
        return code;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return code == sale.code;

    }

    public static void main(String[] args) {
        Sale s = new Sale(1, "01/01/1970-00:00:00");

        Catalog catalog = new Catalog("Roba mercadona");


        catalog.add(new Product(481867450, "Pantalons vermells", "Mercadona", 20));
        catalog.add(new Product(481867451, "Pantalons negres", "Mercadona", 20));
        catalog.add(new Product(481867452, "Pantalons blaus", "Mercadona", 20));
        catalog.add(new Product(481867453, "Pantalons grocs", "Mercadona", 20));
        catalog.add(new Product(481867454, "Pantalons roses", "Mercadona", 20));
        catalog.add(new Product(516724320, "Samarreta vermella", "Mercadona", 15));
        catalog.add(new Product(516724321, "Samarreta negra", "Mercadona", 15));
        catalog.add(new Product(516724322, "Samarreta blava", "Mercadona", 15));
        catalog.add(new Product(516724323, "Samarreta groga", "Mercadona", 15));
        catalog.add(new Product(516724324, "Samarreta violeta", "Mercadona", 15));


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--------- Punt de venda ----------");
            System.out.println("Seccions: ");
            System.out.println("\t1 - Nova linea de compra");
            System.out.println("\t2 - Borrar linea de compra");
            System.out.println("\t3 - Total compra");
            System.out.println("\t4 - Afegir producte al catàleg");
            System.out.println("\t5 - Borrar producte del catàleg");
            System.out.println("\t6 - Cercar producte al catàleg per EAN");
            System.out.println("\t7 - Nombre de productes que hi ha al catàleg");
            System.out.println("\t8 - Mostrar productes del catàleg");
            System.out.println("\t0 - Sortir");

            int resp = sc.nextInt();
            switch (resp) {
                case 0:
                    System.out.println("Fins aviat!");
                    System.exit(0);
                case 1:
                    System.out.print("Línia de compra a introduir (EAN): ");
                    Product p = catalog.search(sc.nextInt());
                    if (p != null) {
                        System.out.print("Quantitat de: " + p.getDescription() + ": ");
                        int unitats = sc.nextInt();
                        if (unitats > 0 && s.add(new SaleLine(unitats, p)))
                            System.out.println("Línia de compra afegida correctament.");
                        else
                            System.err.println("Error: la línia de compra no s'ha afegit.");
                    } else {
                        System.err.println("Error: producte no trobat.");
                    }
                    break;

                case 2:
                    System.out.print("Línia de compra a borrar (EAN): ");
                    Product tmp = catalog.search(sc.nextInt());
                    if (tmp != null) {
                        if (s.remove(new SaleLine(0, tmp)))
                            System.out.println("Línia de compra borrada correctament");
                        else
                            System.err.println("Error: la línia de compra no s'ha borrat.");
                    } else {
                        System.err.println("Error: producte no trobat.");
                    }
                    break;
                case 3:
                    System.out.println("Total de la compra actual: "+s.totalAmount()+"€");
                    break;
                case 4:
                    System.out.print("EAN del producte a introduir: ");
                    int ean=sc.nextInt();
                    sc.nextLine(); // per arreglar un bug
                    System.out.print("Descripció: ");
                    String des=sc.nextLine();
                    System.out.print("Marca: ");
                    String mar=sc.nextLine();
                    System.out.print("Preu: ");
                    int pre=sc.nextInt();
                    if (catalog.add(new Product(ean,des,mar,pre)))
                        System.out.println("Producte introduit correctament");
                    else
                        System.err.println("Error: el producte no s'ha introduit");
                    break;
                case 5:
                    System.out.print("EAN del producte a borrar: ");
                    if (catalog.remove(new Product(sc.nextInt())))
                        System.out.println("Producte borrat correctament");
                    else
                        System.err.println("Error: el producte no s'ha borrat");
                    break;
                case 6:
                    System.out.print("EAN del producte a cercar: ");
                    Product tmpP = catalog.search(sc.nextInt());
                    if (tmpP!=null) {
                        System.out.println(tmpP);
                    }
                    else
                        System.err.println("Error, aquest producte no existeix");
                    break;
                case 7:
                    System.out.println("Nombre de productes: "+catalog.productsNumber());
                    break;
                case 8:
                    for (Product pro:catalog.getProducts()) {
                        System.out.println(pro);
                    }
                    break;
                default:
                    System.err.println("Error, opció invalida");
                    break;
            }

        }

    }
}