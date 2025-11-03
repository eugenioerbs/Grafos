public class MainTeste {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.addVertice("Blumenau");
        g.addVertice("Pomerode");
        g.addVertice("Indaial");
        Vertice blumenau = g.getVertice("Blumenau");

        blumenau.adicionarVizinho("Pomerode");
        blumenau.adicionarVizinho("Indaial");
        System.out.println(g.showGrafo());

    }
}
