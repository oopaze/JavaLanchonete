import java.util.Scanner;

public class lanchonete {
    Scanner scan = new Scanner(System.in);
    public int opcao = -1;
    public String hamburguer = "";
    public Float preco = 0f;

    // Cardápio 
    public static String paes[] = {"Pão Francês", "Pão Carteira", "Pão de Hambúrguer", "Pão Árabe"};
    public static Float paes_preco[] = {0.25f, 0.32f, 0.70f, 1.30f};
    
    public static String queijo[] = {"Coalho", "Minas", "Muçarela", "Cream Cheese", "Gorgonzola"};
    public static Float queijo_preco[] = {1.50f, 1.80f, 2f, 3f, 3.50f};

    public static String carnes[] = {"Mortadela", "Apresuntado", "Presunto", "Bacon", "Pepperoni", "Salami"};
    public static Float carnes_preco[] = {0.50f, 1f, 1.60f, 1.30f, 1.80f, 2f};

    public static String verduras[] = {"Cebola", "Pimentão", "Tomate"};
    public static Float verduras_preco[] = {0.32f, 0.45f, 0.50f};
    
    public static String molhos[] = {"Maionese", "Ketchup", "Maionese Temperada", "Molho Tártaro", "Barbecue"};
    public static Float molhos_preco[] = {0.50f, 0.50f, 0.70f, 1f, 1.50f};
    
    public static String outros[] = {"Batata Palha", "Ovo"};
    public static Float outros_preco[] = {1f, 1f};

    // Montagem Hambúrguer
    public String opcoes[][] = {paes, queijo, carnes, verduras, molhos, outros}; 
    public Float opcoes_preco[][] = {paes_preco, queijo_preco, carnes_preco, verduras_preco, molhos_preco, outros_preco}; 
    public String labels[] = {
        "Pães (fatia de pão)", 
        "Queijos(fatia)", 
        "Carnes de Porco (fatia)", 
        "Verduras(fatua)", 
        "Molhos(porção)", 
        "Outros"
    };

    public static void main(String[] args) {
        new lanchonete().start();
    }

    private void start(){
        for (int i = 0; i < 5; i++){
            do {
                // Mostrando opções de acompanhamento
                mostra_cadarpio(labels[i], opcoes[i], opcoes_preco[i]);
                System.out.print("\n\nOpção: ");
                opcao = scan.nextInt();

                // Encerrando pedido
                if (opcao == opcoes[i].length + 1){
                    i = 100;
                } else if (opcao > 0 && opcao < opcoes[i].length) {
                    // Salvando a opção selecionada ao preco e ao hamburguer
                    salva_opcao(opcao, opcoes[i], opcoes_preco[i]);
                }

            } while ( opcao < 0 && opcao > opcoes[i].length + 1);
        }

        // Mostrando pedido 
        System.out.println("Hamburguer com: " + hamburguer);
        System.out.println("Preço: R$ " + preco);
        
        // Reinicializando variáveis
        hamburguer = "";
        preco = 0f;
    }

    private void mostra_cadarpio(String name, String[] opcoes, Float[] opcoes_preco) {
        System.out.println(name + ": ");
        for (int i = 0; i < opcoes_preco.length; i++) {
            int j = i + 1;
            System.out.println(j + " - " + opcoes[i] + " - R$ " + opcoes_preco[i]);
        }
        System.out.println((opcoes_preco.length + 1) + " - Encerrar pedido");
    }

    private void salva_opcao(int opcao, String[] opcoes, Float[] precos) {
        int opcao_ajustada = opcao - 1;
        hamburguer = hamburguer + opcoes[opcao_ajustada] + " - R$ " + precos[opcao_ajustada] + ", ";
        preco = preco + precos[opcao_ajustada];
        System.out.println("Preço até agora: " + precos[opcao_ajustada]);
    }
}
