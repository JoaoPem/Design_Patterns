
public class Facade {
    public class Stock {
        public boolean checkStock(int productId){
            System.out.println("Checked stock for the product" + productId);
            return true;
        }
    }

    public class Send {
        public void sendProduct(int productId, int userId){
            System.out.println("Product " + productId + " sent to the user: " + userId);
        }
    }

    public class Payment {
        public boolean checkPayment(int userId){
            System.out.println("Checked payment for the product..." + userId);
            return true;
        }
    }

    public class EcommerceFacade {
        private Send send;
        private Payment payment;
        private Stock stock;

        public EcommerceFacade(){
            this.send = new Send();
            this.payment = new Payment();
            this.stock = new Stock();
        }

        public void processOrder(int produtoId, int userId){
            if (stock.checkStock(produtoId) && payment.checkPayment(userId)){
                send.sendProduct(produtoId, userId);
                System.out.println("Success in submitting the order!");
            }else {
                System.out.println("Failed to send the order");
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            EcommerceFacade ecommerce = new EcommerceFacade();
            ecommerce.processOrder(101, 202);
        }
    }
}
