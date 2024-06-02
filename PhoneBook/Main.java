package PhoneBook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();


        addContact(phoneBook, "Иванов", "123456");
        addContact(phoneBook, "Васильев", "321456");
        addContact(phoneBook, "Петрова", "234561");
        addContact(phoneBook, "Иванов", "234432");
        addContact(phoneBook, "Петрова", "654321");
        addContact(phoneBook, "Иванов", "345678");
        addContact(phoneBook, "Сидоров", "434561");
        removeContact(phoneBook, "Сидоров", "434561");

        printPhoneBook(phoneBook);
    }

    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(phoneNumber);
    }

    public static void removeContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).remove(phoneNumber);
    }

    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        List<Map.Entry<String, Set<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());


        sortedList.sort((a, b) -> b.getValue().size() - a.getValue().size());


        for (Map.Entry<String, Set<String>> entry : sortedList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
