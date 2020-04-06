package main.java.com.homework.lesson14;

import java.io.Serializable;

public class Book implements Comparable, Serializable {
    String author;
    String name;

    Book( String author,String name){
        this.author = author;
        this.name = name;
    }

    @Override
    public int compareTo(Object b) {
        Book book = (Book) b;
        return author.compareTo(book.author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
