public class IteratorProject {
    interface Iterator {
        boolean hasNext();
        Object next();
    }

    interface Aggregate {
        Iterator createIterator();
    }

    class BookIterator implements Iterator {
        private List<Book> books;
        private int position;

        public BookIterator(List<Book> books) {
            this.books = books;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return books.get(position++);
            }
            return null;
        }
    }

    class BookCollection implements Aggregate {
        private List<Book> books;

        public BookCollection() {
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        @Override
        public Iterator createIterator() {
            return new BookIterator(this.books);
        }
    }

    class Book {
        private String title;

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public class Main {
        public static void main(String[] args) {
            BookCollection collection = new BookCollection();
            collection.addBook(new Book("Design Patterns: Elements of Reusable Object-Oriented Software"));
            collection.addBook(new Book("Clean Code: A Handbook of Agile Software Craftsmanship"));
            collection.addBook(new Book("Effective Java"));

            Iterator iterator = collection.createIterator();
            while (iterator.hasNext()) {
                Book book = (Book) iterator.next();
                System.out.println("Book: " + book.getTitle());
            }
        }
    }
    
}
