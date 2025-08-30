public class MainTesteObjectGraph {
    public static void main(String[] args) {
        ObjetcGraph grafo =  new ObjetcGraph(5);
        Node a = new Node("A", 0);
        Node b = new Node("B", 1);
        Node c = new Node("C", 2);
        Node d = new Node("D", 3);
        Node e = new Node("E", 4);
       
        grafo.addVertice(a);
        grafo.addVertice(b);
        grafo.addVertice(c);
        grafo.addVertice(d);
        grafo.addVertice(e);

        grafo.addAresta(a, c);
        grafo.addAresta(c, d);
        grafo.addAresta(d, a);
        grafo.addAresta(d, e);
        grafo.addAresta(b, a);


        System.out.println(grafo.exibirMatriz());
        
    }//psvd
}//class
