public class Node {
    private String name;
    private int indice;
    
    public Node (String valor, int indice) {
        this.name = valor;
        this.indice = indice;
    }//construtor

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }



    
}//class
