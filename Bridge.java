public class Bridge {
    
    interface DeviceControl {
        void turnOn();
        void turnOff();
        void setChannel(int channel);
    }
    
    
    class RemoteControl implements DeviceControl {
        public void turnOn() {
            System.out.println("Device turned on using Remote Control.");
        }
    
        public void turnOff() {
            System.out.println("Device turned off using Remote Control.");
        }
    
        public void setChannel(int channel) {
            System.out.println("Set channel to " + channel + " using Remote Control.");
        }
    }
    
    class VoiceControl implements DeviceControl {
        public void turnOn() {
            System.out.println("Device turned on using Voice Control.");
        }
    
        public void turnOff() {
            System.out.println("Device turned off using Voice Control.");
        }
    
        public void setChannel(int channel) {
            System.out.println("Set channel to " + channel + " using Voice Control.");
        }
    }
    
    abstract class Device {
        protected DeviceControl deviceControl;
    
        protected Device(DeviceControl deviceControl) {
            this.deviceControl = deviceControl;
        }
    
        abstract void turnOn();
        abstract void turnOff();
        abstract void changeChannel(int channel);
    }
    
    class Television extends Device {
        public Television(DeviceControl deviceControl) {
            super(deviceControl);
        }
    
        void turnOn() {
            deviceControl.turnOn();
        }
    
        void turnOff() {
            deviceControl.turnOff();
        }
    
        void changeChannel(int channel) {
            deviceControl.setChannel(channel);
        }
    }
    
    class Radio extends Device {
        public Radio(DeviceControl deviceControl) {
            super(deviceControl);
        }
    
        void turnOn() {
            deviceControl.turnOn();
        }
    
        void turnOff() {
            deviceControl.turnOff();
        }
    
        void changeChannel(int channel) {
            deviceControl.setChannel(channel);
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Device tvWithRemote = new Television(new RemoteControl());
            Device radioWithVoice = new Radio(new VoiceControl());
    
            tvWithRemote.turnOn();
            tvWithRemote.changeChannel(101);
            tvWithRemote.turnOff();
    
            radioWithVoice.turnOn();
            radioWithVoice.changeChannel(202);
            radioWithVoice.turnOff();
        }
    }
}
