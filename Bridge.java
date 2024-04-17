public class Bridge {
    interface Device {
        void powerOn();
        void powerOff();
        void setChannel(int channel);
    }

    class TV implements Device {
        public void powerOn() {
            System.out.println("TV turned on.");
        }

        public void powerOff() {
            System.out.println("TV turned off.");
        }

        public void setChannel(int channel) {
            System.out.println("TV channel set to " + channel);
        }
    }

    class DVDPlayer implements Device {
        public void powerOn() {
            System.out.println("DVD Player turned on.");
        }

        public void powerOff() {
            System.out.println("DVD Player turned off.");
        }

        public void setChannel(int channel) {
            // Typically DVD Players don't have channels but for simplicity, let's assume this one does.
            System.out.println("DVD channel set to " + channel);
        }
    }

    abstract class RemoteControl {
        protected Device device;

        protected RemoteControl(Device device) {
            this.device = device;
        }

        abstract void togglePower();
        abstract void changeChannel(int channel);
    }

    class SimpleRemote extends RemoteControl {
        public SimpleRemote(Device device) {
            super(device);
        }

        public void togglePower() {
            System.out.println("Toggling power...");
            device.powerOn();
            device.powerOff();
        }

        public void changeChannel(int channel) {
            device.setChannel(channel);
        }
    }

    public class Main {
        public static void main(String[] args) {
            Device tv = new TV();
            Device dvd = new DVDPlayer();
            RemoteControl remoteForTV = new SimpleRemote(tv);
            RemoteControl remoteForDVD = new SimpleRemote(dvd);

            remoteForTV.togglePower();
            remoteForTV.changeChannel(5);

            remoteForDVD.togglePower();
            remoteForDVD.changeChannel(2);
        }
    }
}
