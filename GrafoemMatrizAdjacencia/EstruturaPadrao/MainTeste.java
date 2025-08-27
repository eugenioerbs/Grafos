public class MainTeste {
    public static void main(String[] args) {
        Graph grafinho = new Graph(6);

        grafinho.addAresta(0, 1);
        grafinho.addAresta(0, 3);
        grafinho.addAresta(1, 4);
        grafinho.addAresta(2, 4);
        grafinho.addAresta(2, 5);
        grafinho.addAresta(3, 1);
        grafinho.addAresta(4, 3);
        grafinho.addAresta(5, 5);

        System.out.println(grafinho.exibirMatriz());
        
    }//psvd
}//class
