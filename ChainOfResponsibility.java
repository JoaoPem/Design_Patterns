public class ChainOfResponsibility {
    // Handler
    interface Handler {
        void setNextHandler(Handler nextHandler);
        void handleRequest(Message request);
    }

    // Concrete Handlers
    class EmailHandler implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(Message request) {
            if (request.getType() == MessageType.EMAIL) {
                System.out.println("EmailHandler is handling this message: " + request.getContent());
            } else if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("No handler available for message: " + request.getContent());
            }
        }
    }

    class SMSHandler implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(Message request) {
            if (request.getType() == MessageType.SMS) {
                System.out.println("SMSHandler is handling this message: " + request.getContent());
            } else if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("No handler available for message: " + request.getContent());
            }
        }
    }

    // Message and MessageType
    enum MessageType {
        EMAIL, SMS, UNKNOWN
    }

    static class Message {
        private final MessageType type;
        private final String content;

        public Message(MessageType type, String content) {
            this.type = type;
            this.content = content;
        }

        public MessageType getType() {
            return type;
        }

        public String getContent() {
            return content;
        }
    }

    // Client
    public class Main {
        public static void main(String[] args) {
            // Create handlers
            Handler emailHandler = new EmailHandler();
            Handler smsHandler = new SMSHandler();

            // Chain them
            emailHandler.setNextHandler(smsHandler);

            // Create messages
            Message email = new Message(MessageType.EMAIL, "Hello, this is an email!");
            Message sms = new Message(MessageType.SMS, "Hello, this is an SMS!");
            Message unknown = new Message(MessageType.UNKNOWN, "Unknown message type");

            // Process messages
            emailHandler.handleRequest(email);
            emailHandler.handleRequest(sms);
            emailHandler.handleRequest(unknown);
        }
    }

}
