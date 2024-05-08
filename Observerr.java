import java.util.ArrayList;
import java.util.List;

public class Observerr{
    interface Observer {
        void update(String message);
    }

    interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    class Newspaper implements Subject {
        private List<Observer> observers;
        private String latestEdition;

        public Newspaper() {
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(latestEdition);
            }
        }

        public void newEdition(String edition) {
            this.latestEdition = edition;
            notifyObservers();
        }
    }

    class Subscriber implements Observer {
        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " received a new edition of the newspaper: " + message);
        }
    }

    public class ObserverPatternDemo {
        public static void main(String[] args) {
            Newspaper newspaper = new Newspaper();
            Subscriber sub1 = new Subscriber("Alice");
            Subscriber sub2 = new Subscriber("Bob");

            newspaper.registerObserver(sub1);
            newspaper.registerObserver(sub2);

            newspaper.newEdition("Edition 1: Observer Pattern Explained");
            newspaper.newEdition("Edition 2: More Design Patterns");
        }
    }
}