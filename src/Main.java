import java.io.File;
import java.io.FileNotFoundException;
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

        // Display list after insertion
        System.out.println("List after insertions: ");
        printList(linkedList);

        // Demonstrate deletion
        System.out.println("\nDeleting 5 from the list...");
        linkedList.delete(5);
        System.out.println("List after deleting 5: ");
        printList(linkedList);

        // Demonstrate inserting new element
        System.out.println("\nInserting 11 to the list...");
        linkedList.insert(11);
        System.out.println("List after inserting 11: ");
        printList(linkedList);

    }

    public static void printList(CustomLinkedList list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}