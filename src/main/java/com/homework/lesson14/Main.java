package main.java.com.homework.lesson14;

public class Main {
    public static void main(String[] args) {
        Book a = new Book("Марк Твен", "Том Сойер");
        Book b = new Book("Грегори Дэвид Робертс", "Шантарам");
        Book c = new Book("Джордж Оруэлл", "1984");
        Book d = new Book("Михаил Афанасьевич Булгаков", "Записки на манжетах");
        Book e = new Book("Эрих Мария Ремарк", "Три товарища");
        Book f = new Book("Антуан де Сент-Экзюпери", "Планета людей");
        Book g = new Book("Айн Рэнд", "Атлант расправил плечи");
        Book[] goodBooks = {a, b, c, d, e, f, g};
        Storage myStorage = new Storage().createNewBooksStorage("goodBooks", "books");
        myStorage.putBooksInStorage(goodBooks);
        System.out.println(myStorage.getSortedByAuthorBooks());
    }
}
