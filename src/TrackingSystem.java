import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class TrackingSystem {
    public static void main(String[] args) throws IOException {
        BST tree = new BST();

        Scanner sc = new Scanner(System.in);
        //String fileName = sc.nextLine();
        String fileName = "src\\example.txt";

        LinkedList<String> list = readFile(fileName);
        System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");

        //We called the necessary methods by reading the values in the list line by line.
        while (!list.isEmpty()) {
            if (list.getFirst().contains("Quit")) {
                quit();
            } else if (list.getFirst().contains("Is_Available")) {
                String arr[] = (list.getFirst().split(" "));

                tree.isAvailable(Integer.parseInt(arr[1]));
            } else if (list.getFirst().contains("Add_product")) {
                String arr[] = (list.getFirst().replaceAll("( )+", " ").split(" "));

                tree.createProduct(new BST.Node(Integer.parseInt(arr[1]), arr[2], Integer.parseInt(arr[3])));
                System.out.println("Create Product:");
                tree.printProduct(Integer.parseInt(arr[1]));
            } else {
                //Do not anything
            }
            list.removeFirst();
        }
    }

    static void quit() {
//--------------------------------------------------------
// Summary:In this function we stopped the program.
// Precondition: -
// Postcondition: Program stopped.
//--------------------------------------------------------
        System.out.println();
        System.out.println("Thank you for using ITS, Good Bye!");
        System.exit(0);
    }

    static LinkedList<String> readFile(String path) throws IOException {
//--------------------------------------------------------
// Summary: In this function we read the files.
// Precondition: path is String for txt file names.
// Postcondition: txt file read and transferred to list.
//--------------------------------------------------------
        BufferedReader in = new BufferedReader(new FileReader(path));
        String str;

        LinkedList<String> list = new LinkedList<>();
        while ((str = in.readLine()) != null) {
            list.add(str);
        }
        return list;

    }
}
