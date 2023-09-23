package entities.categorias;

public class Comida extends Categoria {
    private String atributo = "É comestivel";

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public String toString() {
        return "Comida";
    }

}
