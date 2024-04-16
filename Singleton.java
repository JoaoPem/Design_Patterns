public class Singleton {

    public class Tabuleiro {
        private static Tabuleiro instance;
        private String[][] casas;

        private Tabuleiro(){
            this.casas = new String[8][8];
            for( int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j ++){
                    this.casas[i][j] = " ";
                }
            }
        }

        public static Tabuleiro getInstance(){
            if (instance == null){
                instance = new Tabuleiro();
            }
            return instance;
        }

        public void adicionaPeca(int linha, int coluna, String peca){
            this.casas[linha][coluna] = peca;
        }

        public void mostrar(){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    System.out.print("|" + this.casas[i][j]);
                }
                System.out.println("|");
            }
        }
    }

    public class Jogo {
        public static void main(String[] args) {
            Tabuleiro t = Tabuleiro.getInstance();
            for (int i = 0; i < 8; i += 2) {
                t.adicionaPeca(0, i, "P");
                t.adicionaPeca(2, i, "P");
                t.adicionaPeca(6, i, "B");
                t.adicionaPeca(7, i + 1, "B");
            }
            t.mostrar();
        }
    }
}
