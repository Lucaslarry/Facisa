package entities.categorias;

public class Comida extends Categoria {
    private String dataVencimento;

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    @Override
    public String toString() {
        return "Comida";
    }

}
