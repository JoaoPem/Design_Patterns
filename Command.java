public class Command {
    interface Comando {
        void executar();
    }

    // Receptor
    class Luz {
        void ligar() {
            System.out.println("Luz ligada");
        }

        void desligar() {
            System.out.println("Luz desligada");
        }
    }

    // Comandos Concretos
    class ComandoLigarLuz implements Comando {
        private Luz luz;

        ComandoLigarLuz(Luz luz) {
            this.luz = luz;
        }

        public void executar() {
            luz.ligar();
        }
    }

    class ComandoDesligarLuz implements Comando {
        private Luz luz;

        ComandoDesligarLuz(Luz luz) {
            this.luz = luz;
        }

        public void executar() {
            luz.desligar();
        }
    }

    // Invocador
    class ControleRemoto {
        private Comando comando;

        void setComando(Comando comando) {
            this.comando = comando;
        }

        void pressionarBotao() {
            comando.executar();
        }
    }

    public class Main {
        public static void main(String[] args) {

            Luz luz = new Luz();

            ComandoLigarLuz ligarLuzComando = new ComandoLigarLuz(luz);
            ComandoDesligarLuz desligarLuzComando = new ComandoDesligarLuz(luz);

            ControleRemoto controleRemoto = new ControleRemoto();

            controleRemoto.setComando(ligarLuzComando); // Ligando a luz
            controleRemoto.pressionarBotao(); // Pressionando o botão para ligar a luz

            controleRemoto.setComando(desligarLuzComando); // Desligando a luz
            controleRemoto.pressionarBotao(); // Pressionando o botão para desligar a luz
        }
}
