package entities.categorias;

public class Eletronico implements Categoria {
    private String atributo = "Não pode molhar";

    @Override
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public String getAtributo() {
        return atributo;
    }

    @Override
    public String toString() {
        return "Eletronico";
    }

}
