import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Main {
    static ArrayList<User> getUsersList() {
        ArrayList<User> users = new ArrayList<User>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Эмиль\\Desktop\\java\\Lab Files No1\\memory.txt"))){
            String line;
            while((line= br.readLine()) !=null){
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    User user = new User();
                    user.setId(Integer.parseInt(parts[0]));
                    user.setLogin(parts[1]);
                    user.setPassword(parts[2]);
                    users.add(user);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }

    static void saveUsersList(ArrayList<User> users){
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Эмиль\\Desktop\\java\\Lab Files No1\\memory.txt"))){
        for(User user : users){
            bw.write(user.getId()+user.getPassword()+user.getLogin());
            bw.newLine();
        }
    }catch (IOException e){
        e.printStackTrace();
    }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users =  getUsersList();

        while(true){
            System.out.println("PRESS [1] TO ADD USERS");
            System.out.println("PRESS [2] TO LIST USERS");
            System.out.println("PRESS [3] TO DELETE USERS");
            System.out.println("PRESS [4] TO EXIT");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    User user = new User();
                    System.out.println("Id: ");
                    user.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Login: ");
                    String userLogin = ","+scanner.nextLine() + ",";
                    user.setLogin(userLogin);
                    System.out.println("Password: ");
                    user.setPassword(scanner.nextLine());
                    users.add(user);
                    saveUsersList(users);
                    break;
                case 2:
                    for (User u : users){
                        System.out.println(u);
                    }
                    if (users == null){
                        System.out.println("database is empty");
                    }
                    break;
                case 3:
                    System.out.println("Enter login to  delete:");
                    String loginToDelete = scanner.nextLine();
                    for (User u : users){
                        if (u.getLogin().equalsIgnoreCase(loginToDelete)){
                            users.remove(u);
                            break;
                        }
                    }
                    saveUsersList(users);
                case 4:
                    break;
            }
        }
    }
}