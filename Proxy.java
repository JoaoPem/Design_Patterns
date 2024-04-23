public class Proxy {
    interface Image {
        void display();
    }

    class HighResolutionImage implements Image {
        public HighResolutionImage(String imagePath) {

            System.out.println("Loading heavy image of:" + imagePath);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Charging complete.");
        }

        public void display() {
            System.out.println("Displaying image.");
        }
    }

    class ImageProxy implements Image {
        private HighResolutionImage highResImage;
        private String imagePath;

        public ImageProxy(String imagePath) {
            this.imagePath = imagePath;
        }

        @Override
        public void display() {
            if (highResImage == null) {
                highResImage = new HighResolutionImage(imagePath);
            }
            highResImage.display();
        }
    }

    public class Main {
        public static void main(String[] args) {
            Image image1 = new ImageProxy("path/to/highres/image1.jpg");
            System.out.println("Image will now be displayed:");
            image1.display();
        }
    }

}
