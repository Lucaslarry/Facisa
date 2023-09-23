package entities.categorias;

public abstract class Categoria {
    private String atributo = "oi";

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getAtributo() {
        return atributo;
    }
}
