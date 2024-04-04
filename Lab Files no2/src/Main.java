import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Main{

    public static void main(String[] args){
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Gooditems> Items =admin.getGoodItems();
        System.out.println("Are you Client[1] or Admin[2] ?");
        int choose = scanner.nextInt();
        switch(choose) {
            case 1:
                System.out.println("Welcome to market!");
                Client client = new Client();
                while(true){
                    System.out.println("PRESS[1] LIST ITEMS");
                    System.out.println("PRESS[2] BUY ITEMS");
                    System.out.println("PRESS[3] BUY HISTORY");
                    System.out.println("PRESS[4] EXIT ");

                    choose = scanner.nextInt();
                    switch (choose){
                        case 1:
                            for (Gooditems i : Items) {
                                if (i != null) {

                                    System.out.println(i);
                                }else{
                                    System.out.println("Database is null");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter name of a Product to buy:");
                            scanner.nextLine();
                            String nameProductToBuy = scanner.nextLine();
                            for (Gooditems i : Items){
                                if(i.getName().equalsIgnoreCase(nameProductToBuy)){
                                    System.out.println(i.getName() + " Price is: " + i.getPrice());
                                    System.out.println("Buy/Not");
                                    String chooseBuy = scanner.nextLine();
                                    if(chooseBuy.equalsIgnoreCase("Buy")){
                                        BuyHistory newPurchase = new BuyHistory(i.getName(),i.getPrice());
                                        client.buyHistory.add(newPurchase);
                                        client.saveBuyHistory(client.buyHistory);
                                    } else if (chooseBuy.equalsIgnoreCase("Not")) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 3:
                            for(BuyHistory BH : client.buyHistory){
                                System.out.println(BH);
                            }
                            break;
                        case 4:
                            System.out.println("Exiting>>>");
                            return;
                    }
                }
            case 2:
                System.out.println("Enter password: ");
                int password = 123456789;
                int userEnterPassword = scanner.nextInt();
                if (userEnterPassword == password) {
                    while (true) {
                        System.out.println("PRESS[1] ADD ITEMS");
                        System.out.println("PRESS[2] LIST ITEMS");
                        System.out.println("PRESS[3] DELETE ITEMS");
                        System.out.println("PRESS[4] EXIT");
                        choose = scanner.nextInt();
                        switch (choose) {
                            case 1:
                                Gooditems item = new Gooditems();
                                System.out.println("Enter name of a product: ");
                                scanner.nextLine();
                                item.setName(scanner.nextLine());
                                System.out.println("Enter price of this product:");
                                item.setPrice(scanner.nextInt());

                                Items.add(item);
                                admin.saveGoodItems(Items);
                                break;
                            case 2:
                                for (Gooditems i : Items) {
                                    if (i != null) {
                                        System.out.println(i);
                                    } else {
                                        System.out.println("Database is null");
                                    }

                                }
                                break;
                            case 3:
                                System.out.println("Enter product name to delete:");
                                scanner.nextLine();
                                String nameToDelete = scanner.nextLine();
                                Iterator<Gooditems> iterator = Items.iterator();
                                    while(iterator.hasNext()){
                                        Gooditems i = iterator.next();
                                        if (i.getName().equalsIgnoreCase(nameToDelete)){
                                            iterator.remove();
                                        }

                                    }


                                break;
                            case 4:
                                System.out.println("Exiting>>>");
                                return;
                        }

                    }
                }
                else{
                    System.out.println("Access denied!");
                }
                break;
        }

    }
}
