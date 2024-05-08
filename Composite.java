import java.util.ArrayList;
import java.util.List;

public class Composite {
    abstract class GraphicComponent {
        public abstract void draw();
    }

    class Rectangle extends GraphicComponent {
        @Override
        public void draw() {
            System.out.println("Desenhando um retângulo.");
        }
    }

    class Circle extends GraphicComponent {
        @Override
        public void draw() {
            System.out.println("Desenhando um círculo.");
        }
    }

    class CompositeGraphic extends GraphicComponent {
        private List<GraphicComponent> components = new ArrayList<>();

        public void add(GraphicComponent graphic) {
            components.add(graphic);
        }

        public void remove(GraphicComponent graphic) {
            components.remove(graphic);
        }

        @Override
        public void draw() {
            for (GraphicComponent graphic : components) {
                graphic.draw();
            }
        }
    }

    public class CompositePatternDemo {
        public static void main(String[] args) {
            CompositeGraphic graphic = new CompositeGraphic();
            graphic.add(new Rectangle());
            graphic.add(new Circle());

            CompositeGraphic subGraphic = new CompositeGraphic();
            subGraphic.add(new Rectangle());
            subGraphic.add(new Circle());

            graphic.add(subGraphic);

            graphic.draw();
        }
    }
}
