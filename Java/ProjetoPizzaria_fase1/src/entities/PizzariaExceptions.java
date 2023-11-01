package entities;

public class PizzariaExceptions extends RuntimeException {

    public PizzariaExceptions(String msg) {
        super("ERRO:" + msg);
    }

}
