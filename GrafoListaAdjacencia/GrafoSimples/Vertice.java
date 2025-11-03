public class Vertice {
    private String nome;
    private String[] adjacentes;
    private int quantidadeAdjacentes;

    public Vertice(String nome) {
        this.nome = nome;
        adjacentes = new String[1];
        this.quantidadeAdjacentes = 0;
    }//construtor

    public String getNome() {
        return nome;
    }

    public int getQuantidadeAdjacentes() {
        return quantidadeAdjacentes;
    }

    public void setQuantidadeAdjacentes(int quantidadeAdjacentes) {
        this.quantidadeAdjacentes = quantidadeAdjacentes;
    }

    private void expandirVetor() {
        String[] novoVetor = new String[quantidadeAdjacentes * 2];

        for (int i = 0; i < quantidadeAdjacentes; i++) {
            novoVetor[i] = adjacentes[i];
        }
        adjacentes = novoVetor;
    }

    public void adicionarVizinho(String nomeVizinho) {
        if (quantidadeAdjacentes >= adjacentes.length) {
            expandirVetor();
        }
        adjacentes[quantidadeAdjacentes] = nomeVizinho;
        quantidadeAdjacentes++;
    }

    public String removerVizinho(String nomeVizinho) {
        for (int i = 0; i < quantidadeAdjacentes; i++) {
            if (adjacentes[i].equalsIgnoreCase(nomeVizinho)) {
                for (int e = i; e < quantidadeAdjacentes; e++) {
                    if (adjacentes[e + 1] != null) {
                        adjacentes[e] = adjacentes[e + 1];
                    }
                }
                return "Vizinho removido";
            }
        }
        String seNãoEncontrar = "Vizinho não encontrado";
        return seNãoEncontrar;
    }

    public String showAdjacentes() {
        StringBuilder sb = new StringBuilder();

        if (quantidadeAdjacentes == 0) {
            return "Sem vizinhos";
        }

        for (int i = 0; i < quantidadeAdjacentes; i++) {
            sb.append(adjacentes[i]);
            if (i < quantidadeAdjacentes - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    

}//class
