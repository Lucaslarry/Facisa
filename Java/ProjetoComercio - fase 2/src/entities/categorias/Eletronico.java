package entities.categorias;

public class Eletronico extends Categoria {
    private boolean aprovaDagua = false;

    public void setAprovaDagua(boolean aprovaDagua) {
        this.aprovaDagua = aprovaDagua;
    }

    public boolean getAprovaDagua() {
        return aprovaDagua;
    }

    @Override
    public String toString() {
        return "Eletronicos";
    }

}
