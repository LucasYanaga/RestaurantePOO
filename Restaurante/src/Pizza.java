public class Pizza extends Dish{
    String pasta;
    String filling;
    String edge;

    public Pizza(String name, String expirationDate, float price, float weight, String pasta, String filling, String edge) {
        super(name, expirationDate, price, weight);
        this.pasta = pasta;
        this.filling = filling;
        this.edge = edge;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }
}
