package entities;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Relatorio {
    private static Double saldo = 50000.0;

    public static Double getSaldo() {
        return saldo;
    }

    public static void acrescentarSaldo(Double novoSaldo, String nome, int quantidade) {
        saldo += novoSaldo;
        registrarTransacao("Venda de " + quantidade + " " + nome + "'s : +", novoSaldo);
        atualizarSaldoNoArquivo();
    }

    public static void diminuirSaldo(Double novoSaldo, String nome, int quantidade) {
        saldo -= novoSaldo;
        registrarTransacao("Compra de " + quantidade + " " + nome + "'s : -", novoSaldo);
        atualizarSaldoNoArquivo();
    }

    private static void registrarTransacao(String descricao, Double valor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt", true));
                BufferedWriter bwt = new BufferedWriter(new FileWriter("relatorioTemporario.txt", true))) {

            String transacao = descricao + "R$ " + String.format("%.2f", valor) + "\n";

            bw.write(transacao);
            bwt.write(transacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Double lerSaldoDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("relatorio.txt"))) {
            String ultimaLinha = null;
            String linha;
            while ((linha = br.readLine()) != null) {
                ultimaLinha = linha;
            }
            String[] partes = ultimaLinha.split(": ");
            return Double.parseDouble(partes[1]);

        } catch (NullPointerException | FileNotFoundException e) {
            criarArquivo();
        } catch (IOException | NumberFormatException e) {
        }

        return 50000.0;
    }

    private static void criarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt"))) {
            bw.write("Saldo Atual: " + saldo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void criarArquivoTemporario() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorioTemporario.txt"))) {
            bw.write("Saldo Atual: " + saldo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarSaldoNoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("relatorio.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt", true))) {

            bw.write("Saldo Atual: " + saldo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}