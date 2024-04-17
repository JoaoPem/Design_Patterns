public class Adapter {
    public interface CarCharger {
        void chargeCar();
    }

    public class WallSocket {
        public void provideElectricity() {
            System.out.println("Electricity is provided by the wall socket.");
        }
    }

    public class WallSocketAdapter implements CarCharger {
        private WallSocket wallSocket;

        public WallSocketAdapter(WallSocket wallSocket) {
            this.wallSocket = wallSocket;
        }

        @Override
        public void chargeCar() {
            wallSocket.provideElectricity();
            System.out.println("Car is charging using the wall socket through the adapter.");
        }
    }

    public class Main {
        public static void main(String[] args) {
            WallSocket wallSocket = new WallSocket();
            CarCharger charger = new WallSocketAdapter(wallSocket);
            charger.chargeCar();
        }
    }
}
