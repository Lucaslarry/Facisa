package entities;

public class Relatorio {
    private static Double saldo = 50000.00;

    public static Double getSaldo() {
        return saldo;
    }

    public static void acrescentarSaldo(Double novoSaldo) {
        saldo += novoSaldo;
    }

    public static void diminuirSaldo(Double novoSaldo) {
        saldo -= novoSaldo;
    }

}
