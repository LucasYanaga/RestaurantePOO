import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    //Tuple
     static class Tuple<X, Y> {
        public X x;
        public Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    //Criar order
    public static void newOrder(Client client) {
        Order order = new Order(client);
    }

    //Carregar Menu
    public static ArrayList<Dish> loadDish() {

        ArrayList<Dish> dishList = new ArrayList<>();
        Pizza p1 = new Pizza("Pizza de calabresa", "24/04/2022", 40, 750, "Napolitana", "Calabresa", "Normal");
        Sandwich sa1 = new Sandwich("Sanduiche de mignon", "24/04/2022", 25, 100, "Italiano", "Carne", "Barbecue");
        Snack sn1 = new Snack("Coxinha", "24/04/2022", 7, 100, "Massa branca", "Catupiry");

        dishList.add(p1);
        dishList.add(sa1);
        dishList.add(sn1);

        return dishList;
    }

    //Indexar Menu
    public static ArrayList<Tuple<Integer, Dish>> tupleMenu(ArrayList<Dish> dishList) {
        int count = 1;
        ArrayList<Tuple<Integer, Dish>> menuIndex = new ArrayList<>();

        for (Dish dish : dishList) {
            Tuple<Integer, Dish> tupleMenu = new Tuple<>(count, dish);
            tupleMenu.x = count;
            tupleMenu.y = dish;

            menuIndex.add(tupleMenu);
            count++;
        }

        return menuIndex;
    }

    //Print menu
    public static void printMenu(ArrayList<Tuple<Integer, Dish>> menuIndex) {
        System.out.println("----------| Menu |----------");
        for (Tuple<Integer, Dish> tuple : menuIndex) {
            System.out.println("[" + tuple.x.toString() + "] " + tuple.y.getName());
        }
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int comando;
        ArrayList<Dish> dishList = new ArrayList<>();

        while (true) {
            System.out.println("----------| Opções |----------");
            System.out.println("[1] Fazer pedido\n[2] Sair");
            System.out.println("------------------------------\n");
            comando = scan.nextInt();

            if (comando == 1) {
                //Criar cliente
                System.out.println("Nome do cliente: ");
                String clientName = scan.next();
                Client client = new Client(clientName);

                //Cria a order
                Order order = new Order(client);
                dishList = loadDish();

                //Indexando o menu
                ArrayList<Tuple<Integer, Dish>> menuIndex;
                menuIndex = tupleMenu(dishList);

                //Montagem do carrinho
                while (true) {
                    //Mostra menu
                    printMenu(menuIndex);

                    //Esolhe o item
                    int escolha = scan.nextInt();
                    for (Tuple<Integer, Dish> item : menuIndex) {
                        if (item.x == escolha) {
                            //adiciona na lista
                            order.itensConsumidos.add(item.y);
                            System.out.println(item.y.getName() + " adicionado com sucesso!\n");

                            System.out.println("----------| Opções |----------");
                            System.out.println("[1] Adicionar mais itens\n[2] Ver carrinho\n[3] Finalizar");
                            System.out.println("------------------------------");

                            int escolha2 = scan.nextInt();
                            if (escolha2 == 1) {
                                continue;
                            } else if (escolha2 == 2) {
                                System.out.println("----------| Carrinho |----------");
                                for (Dish dish : order.itensConsumidos) {
                                    System.out.println(dish.getName());
                                }
                                System.out.println("--------------------------------\n");
                                System.out.println("----------| Opções |----------");
                                System.out.println("[1] Adicionar mais itens\n[2] Finalizar");
                                System.out.println("------------------------------");

                                int escolha3 = scan.nextInt();
                                try {
                                    if (escolha3 == 1) {
                                        continue;
                                    } else if (escolha3 == 2) {
                                        escolha = 0;
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Opção inválida!");
                                }
                            } else if (escolha2 == 3) {
                                break;
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        }
                    }
                    if (escolha == 0) {
                        break;
                    }
                }
                //Pagamento
                System.out.print("Pagamento: ");
                float pay = scan.nextFloat();

                order.printInvoice(order.getItensConsumidos(), pay);
            } else {
                System.out.println("Saindo...");
                break;
            }
        }
    }
}


