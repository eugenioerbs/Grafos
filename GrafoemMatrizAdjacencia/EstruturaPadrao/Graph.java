public class Graph {
    private int numVertices;
    private int[][] matriz;

    public Graph (int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }//construtor

    public void addAresta (int origem, int destino) {
        matriz[origem][destino] =1;
    }

     public void removerAresta (int origem, int destino) {
        matriz[origem][destino] = 0;
    }

     public void addArestaNaoDirecionada (int origem, int destino) {
        matriz[origem][destino] = 1;
        matriz[destino][origem] = 1;     
    }

    public boolean exixteAresta (int origem, int destino) {
        return matriz[origem][destino] == 1;
    }

    public String exibirMatriz () {
        StringBuilder sb = new StringBuilder();

        for (int l = 0; l < numVertices; l++) {
            for (int c = 0; c < numVertices; c++) {
                sb.append(matriz[l][c]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }



}//class
