package entities.categorias;

public class Comida implements Categoria {
    private String atributo = "É comestivel";

    @Override
    public String getAtributo() {
        return atributo;
    }

    @Override
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public String toString() {
        return "Comida";
    }

}
