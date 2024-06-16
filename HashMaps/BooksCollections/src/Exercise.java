import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        Book [] books = new Book[6];

        // Book-Objekte erstellen und dem Array hinzufügen
        books[0] = new Book("B.K. Rowling", "Harry Potter and the Philosopher's Stone", 5);
        books[1] = new Book("George Orwell", "1984", 6);
        books[2] = new Book("J.R.R. Tolkien", "The Lord of the Rings", 1);
        books[3] = new Book("Harper Lee", "To Kill a Mockingbird", 2);
        books[4] = new Book("F. Scott Fitzgerald", "The Great Gatsby", 8);
        books[5] = new Book("Abriel Garcia Marquez", "One Hundred Years of Solitude", 10);

        part6(books);
        part7(books);
        part8(books);
        part9(books);

    }

    private static void part9(Book[] books) {
        System.out.println("-------------------------Part 9 ( treeSet)  ---------------------------------");
        TreeSet<Book> treeSet = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            treeSet.add(books[i]);
        }
        treeSet.add(books[2]);
        System.out.println(treeSet.toString());

    }
    private static void part8(Book[] books) {
        System.out.println("-------------------------Part 8 ( hashMap)  ---------------------------------");
        HashMap<Integer, Book> hashMap = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            hashMap.put(i, books[i]);
        }
        for( Book b : hashMap.values()){
            System.out.println(b);
        }
    }

    private static void part7(Book[] books) {
        System.out.println("-------------------------Part 7 ( hashSet)  ---------------------------------");
        //Create
        Set<Book> hashSet = new HashSet<>();
        //Add
        for (int i = 0; i < 6; i++) {
            hashSet.add(books[i]);
        }
        //Try to add new on
        hashSet.add(books[2]);
        //Print
        System.out.println(hashSet.toString());

    }

    public static void part6 (Book [] books){
        System.out.println("-------------------------Part 6 ---------------------------------");
        //create
        List<Book> arrayList = new ArrayList<>();

        //Add to List
        Collections.addAll(arrayList, books);

        //Unsorted
        System.out.println("Unsorted:");
        System.out.println(arrayList.toString());

        //Sorted
        System.out.println("Sorted");
        Collections.sort(arrayList);
        System.out.println(arrayList.toString());

        //Reversed
        System.out.println("Reversed");
        Collections.reverse(arrayList);
        System.out.println(arrayList.toString());
    }


}
