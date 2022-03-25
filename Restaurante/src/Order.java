import java.util.ArrayList;

public class Order {
    Client client;
    ArrayList<Dish> itensConsumidos = new ArrayList<>();
    float serviceFee;

    public Order() {
    }

    public Order(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Dish> getItensConsumidos() {
        return itensConsumidos;
    }

    public void setItensConsumidos(ArrayList<Dish> itensConsumidos) {
        this.itensConsumidos = itensConsumidos;
    }

    public float getServiceCharge() {
        return serviceFee;
    }

    public void setServiceCharge(float serviceFee) {
        this.serviceFee = serviceFee;
    }

    public void addItem(Dish item){
        this.itensConsumidos.add(item);
    }

    public float calculateFee(ArrayList<Dish> itemsList){
        float fee = 0;
        float total = 0;
        total = calculateOrderPrice(itemsList);
        fee = (total/100) * 10; //10%

        return fee;
    }

    public float calculateChange(float pay, ArrayList<Dish> itemsList){
        float change = 0;
        float total = 0;
        total = calculateTotalOrderPrice(itemsList);
        change = pay - total;
        return change;
    }

    public float calculateOrderPrice(ArrayList<Dish> itemsList){
        float orderPrice = 0;
        for (int i = 0; i < itemsList.size(); i++) {
            orderPrice += itemsList.get(i).price;
        }
        return orderPrice;
    }

    public float calculateTotalOrderPrice(ArrayList<Dish> itemsList){
        float orderPrice = 0;
        float total = 0;
        float fee = 0;
        orderPrice = calculateOrderPrice(itemsList);
        fee = calculateFee(itemsList);

        total = orderPrice + fee;
        return total;
    }

    public void printInvoice(ArrayList<Dish> itemsList, float pay){
        float orderPrice = 0;
        float fee = 0;
        float total = 0;
        float change = 0;

        orderPrice = calculateOrderPrice(itemsList);
        fee = calculateFee(itemsList);
        total = calculateTotalOrderPrice(itemsList);
        change = calculateChange(pay, itemsList);

        System.out.println("-----------------------------------");
        System.out.println("------| Cliente " + client.getName() + " |------");
        System.out.println("Itens: ");
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println("[" + i + "] " + itemsList.get(i).name.toString() + "\t" +itemsList.get(i).getPrice());
        }
        System.out.println("-----------------------------------");
        System.out.println("Itens: \t" + orderPrice);
        System.out.println("Taxa:  \t" + fee);
        System.out.println("Total: \t" + total);
        System.out.println("-----------------------------------");
        System.out.println("Pago:  \t" + pay);
        System.out.println("Troco: \t" + change);
        System.out.println("-----------------------------------");
    }
}
