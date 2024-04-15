public class FactoryPrototype {
    public interface Tool extends Cloneable {
        void use();

        Tool clone() throws CloneNotSupportedException;
    }

    class Hammer implements Tool {
        public void use() {
            System.out.println("Using a hammer.");
        }

        public Tool clone() throws CloneNotSupportedException {
            return (Hammer) super.clone();
        }
    }

    class Screwdriver implements Tool {
        public void use() {
            System.out.println("Using a screwdriver.");
        }

        public Tool clone() throws CloneNotSupportedException {
            return (Screwdriver) super.clone();
        }
    }

    class Pliers implements Tool {
        public void use() {
            System.out.println("Using pliers.");
        }

        public Tool clone() throws CloneNotSupportedException {
            return (Pliers) super.clone();
        }
    }

    class Wrench implements Tool {
        public void use() {
            System.out.println("Using a wrench.");
        }

        public Tool clone() throws CloneNotSupportedException {
            return (Wrench) super.clone();
        }
    }

    interface ToolFactory {
        Hammer createHammer();

        Screwdriver createScrewdriver();

        Pliers createPliers();

        Wrench createWrench();
    }

    class BasicToolFactory implements ToolFactory {
        public Hammer createHammer() {
            return new Hammer();
        }

        public Screwdriver createScrewdriver() {
            return new Screwdriver();
        }

        public Pliers createPliers() {
            return new Pliers();
        }

        public Wrench createWrench() {
            return new Wrench();
        }
    }

    public class Main {
        public static void main(String[] args) {
            ToolFactory factory = new BasicToolFactory();
            Tool hammer = factory.createHammer();
            Tool screwdriver = factory.createScrewdriver();
            Tool pliers = factory.createPliers();
            Tool wrench = factory.createWrench();

            // Uso das ferramentas
            hammer.use();
            screwdriver.use();
            pliers.use();
            wrench.use();

            // Clonando uma ferramenta
            Tool hammerClone = hammer.clone();
            hammerClone.use();
        }
    }
}