import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    ArrayList<Gooditems> getGoodItems() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Gooditems> Items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/gooditems.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts;
                parts = line.split(" = ");
                if (parts.length == 2) {
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

    public void saveGoodItems(ArrayList<Gooditems> Items) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/gooditems.txt"))) {
            for (Gooditems item : Items) {

                bw.write(item.getName() + " = " + item.getPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}