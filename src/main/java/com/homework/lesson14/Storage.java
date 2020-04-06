package main.java.com.homework.lesson14;

import java.io.*;
import java.nio.file.Files;
import java.util.TreeSet;

public class Storage {
    int numberOfBooksInStorage;
    String fileName;
    String folderName;
    File yourBooksFile;
    File booksFolder;

    public Storage() {
    }

    private Storage(String fileName, String folderName) {
        this.fileName = fileName;
        this.folderName = folderName;
        numberOfBooksInStorage = 0;
    }

    public Storage createNewBooksStorage(String fileName, String folderName) {
        Storage yourBooksStorage = new Storage(fileName, folderName);
        yourBooksStorage.yourBooksFile = new File("." + yourBooksStorage.fileName);
        yourBooksStorage.booksFolder = new File("." + yourBooksStorage.folderName);
        yourBooksStorage.booksFolder.mkdir();
        putFileInFolder();
        return yourBooksStorage;
    }

    public void putBooksInStorage(Book... books) {
        numberOfBooksInStorage = books.length;
        ObjectOutputStream objectOutputStream = createObjectOutputStream();
        for (Book b : books) {
            try {
                objectOutputStream.writeObject(b);
            } catch (IOException e) {
                System.out.println("Problem: " + e);
            }
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
    }

    public TreeSet<Book> getSortedByAuthorBooks() {
        TreeSet<Book> yourBooks = new TreeSet<>();
        ObjectInputStream objectInputStream = createObjectInputStream();
        for (int i = 0; i < numberOfBooksInStorage; i++) {
            try {
                yourBooks.add((Book) objectInputStream.readObject());
            } catch (IOException e) {
                System.out.println("Problem: " + e);
            } catch (ClassNotFoundException e) {
                System.out.println("Problem: " + e);
            }
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
        return yourBooks;
    }

    private void putFileInFolder() {
        try {
            FileWriter fileWriter = new FileWriter(folderName + File.pathSeparator + fileName);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
    }

    private ObjectOutputStream createObjectOutputStream() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Problem: " + e);
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
        return objectOutputStream;
    }

    private ObjectInputStream createObjectInputStream() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Problem: " + e);
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
        return objectInputStream;
    }
}