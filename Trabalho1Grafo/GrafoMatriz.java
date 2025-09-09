//Eugênio Victor Erbs e Eduarda Dagnoni Mazureck

public class GrafoMatriz {
    private int numVertices;
    private int[][] matriz;

    //atrubutos para o método DSF
    boolean[] visitados = new boolean[numVertices];
    int tempo = 0;
    int[] descoberta = new int[numVertices];
    int[] finalizacao = new int[numVertices];

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }

    public void addAresta(int origem, int destino) {
        matriz[origem][destino]++;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int[][] getMatriz() {
        int[][] copia = new int[this.numVertices][this.numVertices];

        for (int l = 0; l < this.numVertices; l++) {
            for (int c = 0; c < this.numVertices; c++) {
                copia[l][c] = this.matriz[l][c];
            }
        }
        return copia;
    }

    public void removerAresta(int origem, int destino) {
        if (matriz[origem][destino] > 0) {
            matriz[origem][destino]--;
        }
    }

    public boolean exixteAresta(int origem, int destino) {
        return matriz[origem][destino] > 0;
    }

    public int qntArestas(int origem, int destino) {
        int qnt = matriz[origem][destino];
        return qnt;
    }

    public String exibirMatrizFormatada() {
        StringBuilder sb = new StringBuilder();

        for (int l = 0; l < numVertices; l++) {
            for (int c = 0; c < numVertices; c++) {
                sb.append(matriz[l][c]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //TIPO DO GRAFO
    public String tipoDoGrafo(int[][] matrizParametro) {
        StringBuilder sb = new StringBuilder();
        sb.append("Dirigido, Não Dirigido ou Misto: ").append(classificacaoGrafo(matrizParametro)).append("\n");
        sb.append("Multigrafo: ").append(isMultigrafo(matrizParametro)).append("\n");
        sb.append("Regular: ").append(isRegular(matrizParametro)).append("\n");
        sb.append("Completo: ").append(isCompleto(matrizParametro)).append("\n");

        return sb.toString();
    }

    enum tipoEnumGrafo {
        DIRIGIDO, NAO_DIRIGIDO, MISTO
    }

    private tipoEnumGrafo classificacaoGrafo(int[][] matrizParametro) {
        boolean temDirigido = false;
        boolean temNaoDirigido = false;

        for (int l = 0; l < matrizParametro.length; l++) {
            for (int c = 0; c < matrizParametro.length; c++) {
                if (matrizParametro[l][c] != 0 || matrizParametro[c][l] != 0) {
                    if (matrizParametro[l][c] != matrizParametro[c][l]) {
                        temDirigido = true;
                    } else {
                        temNaoDirigido = true;
                    }
                }
            }
        }
        if (temDirigido && temNaoDirigido) {
            return tipoEnumGrafo.MISTO;
        }
        if (temDirigido) {
            return tipoEnumGrafo.DIRIGIDO;
        }
        return tipoEnumGrafo.NAO_DIRIGIDO;
    }

    private boolean isMultigrafo(int[][] matrizParametro) {
        for (int l = 0; l < matrizParametro.length; l++) {
            for (int c = 0; c < matrizParametro.length; c++) {
                if (matrizParametro[l][c] > 1) {
                    return true;
                }
                if (l == c && matrizParametro[l][c] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRegular(int[][] matrizParametro) {
        int grau = 0;
        for (int l = 0; l < matrizParametro.length; l++) {
            grau += matrizParametro[0][l];
        }

        for (int l = 1; l < matrizParametro.length; l++) {
            int soma = 0;
            for (int c = 0; c < matrizParametro.length; c++) {
                soma += matrizParametro[l][c];
            }
            if (soma != grau) {
                return false;
            }
        }
        return true;
    }

    private boolean isCompleto(int[][] matrizParametro) {
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz.length; c++) {
                if (l != c && matrizParametro[l][c] == 0 && matrizParametro[c][l] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //QUANTIDAD DE ARESTAS DO GRAFO
    public String qntArestasGrafo(int[][] matrizParametro) {
        StringBuilder sb = new StringBuilder();
        int soma = 0;

        for (int l = 0; l < matrizParametro.length; l++) {
            for (int c = 0; c < matrizParametro.length; c++) {
                if (matrizParametro[l][c] > 0) {
                    soma += qntArestas(l, c);
                    sb.append(l).append("->").append(c).append(" (")
                            .append(matrizParametro[l][c]).append(")").append("\n");
                }
            }
        }
        String result = "Quantidade de arestas do grafo: " + soma;
        sb.append(result);
        return sb.toString();
    }

    //GRAUS DO VERTICE E DO GRAFO
    public String grausDoVertice(int[][] matrizParametro) {
        StringBuilder sb = new StringBuilder();
        int[] graus = new int[matrizParametro.length];

        for (int l = 0; l < matrizParametro.length; l++) {
            int somaAux = 0;
            for (int c = 0; c < matrizParametro.length; c++) {
                somaAux += qntArestas(l, c);
            }
            graus[l] = somaAux;
        }

        sb.append("Graus dos vertices------\n");
        for (int i = 0; i < matrizParametro.length; i++) {
            sb.append(i).append(": ").append(graus[i]).append("\n");
        }

        for (int i = 0; i < graus.length - 1; i++) {
            for (int j = 0; j < graus.length - 1; j++) {
                if (graus[j] > graus[j + 1]) {
                    int aux = graus[j];
                    graus[j] = graus[j + 1];
                    graus[j + 1] = aux;
                }
            }
        }

        int indiceElementoFinal = graus.length - 1;
        sb.append("Grau do grafo: ").append(graus[indiceElementoFinal]);
        return sb.toString();
    }

    //BUSCA EM PROFUNDIDADE
    public String buscaEmProfundidade(int[][] matrizParametro) {
        tempo = 0;
        visitados = new boolean[matrizParametro.length];
        descoberta = new int[matrizParametro.length];
        finalizacao = new int[matrizParametro.length];

        StringBuilder sb = new StringBuilder();

        for (int v = 0; v < matrizParametro.length; v++) {
            if (!visitados[v]) {
                dfsTempoString(v, sb, matrizParametro);
            }
        }
        return sb.toString();
    }

    public void dfsTempoString(int verticeDaVez, StringBuilder sb, int[][] matrizParametro) {
        visitados[verticeDaVez] = true;
        tempo++;
        descoberta[verticeDaVez] = tempo;

        for (int i = 0; i < matrizParametro.length; i++) {
            if (matriz[verticeDaVez][i] == 1 && !visitados[i]) {
                dfsTempoString(i, sb, matrizParametro);
            }
        }

        tempo++;
        finalizacao[verticeDaVez] = tempo;

        sb.append("Vértice ").append(verticeDaVez).append(" -> (").append(descoberta[verticeDaVez]).append("/").append(finalizacao[verticeDaVez]).append(")\n");
    }

}// class