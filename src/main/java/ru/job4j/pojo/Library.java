package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 300);
        Book philJava = new Book("Phylosofy Java", 254);
        Book javaRukovodstvo = new Book("Java8 Rukovodstvo", 320);
        Book headFirst = new Book("Head First", 300);
        Book[] books = new Book[4];

        books[0] = cleanCode;
        books[1] = philJava;
        books[2] = javaRukovodstvo;
        books[3] = headFirst;

        printBook(books);

            Book temp = books[3];
            books[3] = books[0];
            books[0] = temp;

          printBook(books);

        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println("Название " + books[index].getName()
                        + " количество страниц " + books[index].getCountPage());
            }
        }
        }

        public static void printBook(Book[] books) {
            for (int index = 0; index < books.length; index++) {
                System.out.println("Название " + books[index].getName()
                        + " количество страниц " + books[index].getCountPage());
            }
            System.out.println();
        }
    }

