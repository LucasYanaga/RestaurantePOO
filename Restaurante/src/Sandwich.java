public class Sandwich extends Dish{
    String bread;
    String filling;
    String sauce;

    public Sandwich(String name, String expirationDate, float price, float weight, String bread, String filling, String sauce) {
        super(name, expirationDate, price, weight);
        this.bread = bread;
        this.filling = filling;
        this.sauce = sauce;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}
