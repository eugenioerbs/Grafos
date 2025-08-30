public class ObjetcGraph {
    private int[][] matriz; //representando ligações
    private int qntVertices; //quantidade atual de vertices
    private int capacidadeVertices; //quantidade máxima de vertices
    private Node[] vertices; //representando os os nós com os dados dos vertices

    public ObjetcGraph (int capacidadeVertices) {
        matriz = new int[capacidadeVertices][capacidadeVertices];
        vertices = new Node[capacidadeVertices];
        this.qntVertices = 0;
        this.capacidadeVertices = capacidadeVertices;
    }//construtor

    public void addVertice (Node no) {
        if (qntVertices >= capacidadeVertices) {
            System.out.println("Capacidade máxima de vertices atingida.");
        } else {
            vertices[qntVertices] = no;
            qntVertices++;
        }
    }   

    public void addAresta (Node origem, Node destino) {
        matriz[origem.getIndice()][destino.getIndice()] = 1;
    }

    public void removerAresta (int origem, int destino) {
        matriz[origem][destino] = 0;
    }

    public boolean existeAresta (Node origem, Node destino) {
        return matriz[origem.getIndice()][destino.getIndice()] == 1;
    }


    public String exibirMatriz () {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");

        for (int i = 0; i < vertices.length; i++) {
            sb.append(vertices[i].getName()).append(" ");
        }
        sb.append("\n");

        for (int l = 0; l < vertices.length; l++) {
            sb.append(vertices[l].getName()).append(" ");
            for (int c = 0; c < vertices.length; c++) {
                sb.append(matriz[l][c]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}//clsss 
