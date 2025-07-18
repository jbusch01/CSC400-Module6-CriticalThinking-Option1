import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Read integers from a file
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                int number = scanner.nextInt();
                linkedList.insert(number);
            }
        } catch (FileNotFoundException e) {
            System.out.println("input.txt not found");
        }

        // Display elements using iterator
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }    
}