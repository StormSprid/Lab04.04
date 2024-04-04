import java.io.*;
import java.util.ArrayList;

public class Client {
    ArrayList<BuyHistory> buyHistory = new ArrayList<>();

    ArrayList<Gooditems> Items = new ArrayList<>();
    ArrayList<Gooditems> getGoodItems() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/gooditems.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" = ");
                if(parts.length == 2){
                    Gooditems gooditem = new Gooditems();
                    gooditem.setName(parts[0]);
                    gooditem.setPrice(Integer.parseInt(parts[1]));
                    Items.add(gooditem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
return Items;
    }


   public  ArrayList<BuyHistory> getBuyhistory(){
        ArrayList<BuyHistory> BuyHistoryList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/BuyHistory.txt"))){
            String line;
            while((line = br.readLine())!=null){
                String[] parts = line.split(" = ");
                if(parts.length ==2){
                    String name = parts[0];
                    int price = Integer.parseInt(parts[1]);
                    BuyHistory soldItem = new BuyHistory(name,price);
                  BuyHistoryList.add(soldItem);

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return getBuyhistory();
    }


    public void saveBuyHistory(ArrayList<BuyHistory> BuyHistoryList){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/BuyHistory.txt"))){
            for(BuyHistory BH : BuyHistoryList) {
                bw.write(BH.getGoodName() + " = " + BH.getGoodPrice() + " at: " + BH.getBuyTime());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
