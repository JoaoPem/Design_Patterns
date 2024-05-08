public class Decorator {
    abstract class Beverage {
        String description = "Bebida desconhecida";

        public String getDescription() {
            return description;
        }

        public abstract double cost();
    }

    class Coffee extends Beverage {
        public Coffee() {
            description = "Café";
        }

        @Override
        public double cost() {
            return 1.99;
        }
    }

    class Tea extends Beverage {
        public Tea() {
            description = "Chá";
        }

        @Override
        public double cost() {
            return 1.50;
        }
    }

    abstract class CondimentDecorator extends Beverage {
        public abstract String getDescription();
    }

    class Milk extends CondimentDecorator {
        Beverage beverage;

        public Milk(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Leite";
        }

        @Override
        public double cost() {
            return beverage.cost() + 0.50;
        }
    }

    class Sugar extends CondimentDecorator {
        Beverage beverage;

        public Sugar(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Açúcar";
        }

        @Override
        public double cost() {
            return beverage.cost() + 0.20;
        }
    }

    public class DecoratorPatternDemo {
        public static void main(String[] args) {
            Beverage beverage = new Coffee();
            System.out.println(beverage.getDescription() + " $" + beverage.cost());

            Beverage beverage2 = new Tea();
            beverage2 = new Milk(beverage2);
            beverage2 = new Sugar(beverage2);
            System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
        }
    }

}
