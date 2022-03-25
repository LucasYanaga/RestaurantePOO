public class Snack extends Dish{
    String pasta;
    String recheio;

    public Snack(String name, String expirationDate, float price, float weight, String pasta, String recheio) {
        super(name, expirationDate, price, weight);
        this.pasta = pasta;
        this.recheio = recheio;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
}
