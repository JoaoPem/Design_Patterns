
public class Facade {
    public static class Stock {
        public boolean checkStock(int productId){
            System.out.println("Checked stock for the product" + productId);
            return true;
        }
    }

    public static class Send {
        public void sendProduct(int productId, int userId){
            System.out.println("Product " + productId + " sent to the user: " + userId);
        }
    }

    public static class Payment {
        public boolean checkPayment(int userId){
            System.out.println("Checked payment for the product..." + userId);
            return true;
        }
    }

    public static class EcommerceFacade {
        private Ecomerce.Send send;
        private Ecomerce.Payment payment;
        private Ecomerce.Stock stock;

        public EcommerceFacade(){
            this.send = new Ecomerce.Send();
            this.payment = new Ecomerce.Payment();
            this.stock = new Ecomerce.Stock();
        }

        public void  processOrder(int produtoId, int userId){
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
            Ecomerce.EcommerceFacade ecommerce = new Ecomerce.EcommerceFacade();
            ecommerce.processOrder(101, 202);
        }
    }
}
