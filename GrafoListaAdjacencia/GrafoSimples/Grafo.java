
public class Grafo {
    private Vertice[] vertices;
    private int qntVertices;

    public Grafo() {
        this.qntVertices = 0;
        vertices = new Vertice[1];
    }// construtor

    public void setQntVertices(int valor) {
        this.qntVertices = valor;
    }

    public int getQntVertices() {
        return qntVertices;
    }

    private void expandirVetor() {
        Vertice[] novoVetor = new Vertice[qntVertices * 2];

        for (int i = 0; i < qntVertices; i++) {
            novoVetor[i] = vertices[i];
        }
        vertices = novoVetor;
    }

    public void addVertice(String nome) {
        if (qntVertices < vertices.length) {
            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i] != null && vertices[i].getNome().equalsIgnoreCase(nome)) {
                    throw new Error("Já existe esse nome em algum vértice.");
                }
            }
            vertices[qntVertices] = new Vertice(nome);
            qntVertices++;
        } else {
            expandirVetor();
            for (int i = 0; i < vertices.length; i++) {
                if ( vertices[i] != null && vertices[i].getNome().equalsIgnoreCase(nome)) {
                    throw new Error("Já existe esse nome em algum vértice.");
                }
            }
            vertices[qntVertices] = new Vertice(nome);
            qntVertices++;
        }

    }

    public void removerVertice(String nome) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null && vertices[i].getNome().equalsIgnoreCase(nome)) {
                for (int e = i; e < qntVertices; e++) {
                        vertices[e] = vertices[e + 1];
                    }
                    vertices[qntVertices - 1] = null;
                    qntVertices--;
                    return;
                }
            }
        throw new Error("Vértice não encontrado.");
    }

    public String showGrafo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qntVertices; i++) {
            sb.append(vertices[i].getNome()).append(" -> ").append(vertices[i].showAdjacentes()).append("\n");
        }
        return sb.toString();
    }

    public Vertice getVertice (String nome) {
        for (int i = 0; i < qntVertices; i++) {
            if (vertices[i].getNome().equalsIgnoreCase(nome)) {
                return vertices[i];
            }
        }
        return null;
    }

}// classe
