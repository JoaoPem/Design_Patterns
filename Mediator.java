import java.util.ArrayList;
import java.util.List;

public class Mediator {
    interface Mediator {
        void send(String message, Colleague colleague);
    }

    // Classe Colleague abstrata
    abstract class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }

        public abstract void send(String message);
        public abstract void receive(String message);
    }

    class Button extends Colleague {
        public Button(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void send(String message) {
            mediator.send(message, this);
        }

        @Override
        public void receive(String message) {
            System.out.println("Button received: " + message);
        }
    }

    class TextBox extends Colleague {
        public TextBox(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void send(String message) {
            mediator.send(message, this);
        }

        @Override
        public void receive(String message) {
            System.out.println("TextBox received: " + message);
        }
    }

    class ConcreteMediator implements Mediator {
        private List<Colleague> colleagues;

        public ConcreteMediator() {
            this.colleagues = new ArrayList<>();
        }

        public void addColleague(Colleague colleague) {
            colleagues.add(colleague);
        }

        @Override
        public void send(String message, Colleague colleague) {
            for (Colleague col : colleagues) {
                if (col != colleague) {
                    col.receive(message);
                }
            }
        }
    }

    public class MediatorMain {
        public static void main(String[] args) {
            Mediator mediator = new ConcreteMediator();

            Button button = new Button(mediator);
            TextBox textBox = new TextBox(mediator);

            ((ConcreteMediator) mediator).addColleague(button);
            ((ConcreteMediator) mediator).addColleague(textBox);

            button.send("Clicked");
            textBox.send("Hello");
        }
    }
}
