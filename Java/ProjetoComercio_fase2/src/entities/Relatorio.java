package entities;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import application.UI;

public class Relatorio {
    private static Double saldo = lerSaldoDoArquivo();

    public static Double getSaldo() {
        return saldo;
    }

    public static void acrescentarSaldo(Double valor, String nome, int quantidade) {
        saldo += valor;
        registrarTransacao("Venda de " + quantidade + " " + nome + "'s : +", valor);
        atualizarSaldoNoArquivo();
    }

    public static void diminuirSaldo(Double valor, String nome, int quantidade) {
        saldo -= valor;
        registrarTransacao("Compra de " + quantidade + " " + nome + "'s : -", valor);
        atualizarSaldoNoArquivo();
    }

    private static void registrarTransacao(String descricao, Double valor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt", true));
                BufferedWriter bwt = new BufferedWriter(new FileWriter("relatorioTemporario.txt", true))) {

            String transacao = descricao + "R$ " + UI.FormatarDecimal(valor) + "\n";

            bw.write(transacao);
            bwt.write(transacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void criarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt"))) {
            if (saldo == null) {
                saldo = 50000.00;
            }

            bw.write("Saldo Atual: " + UI.FormatarDecimal(saldo) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void criarArquivoTemporario() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorioTemporario.txt"))) {
            bw.write("Saldo Atual: " + UI.FormatarDecimal(saldo) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarSaldoNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt", true));
                BufferedWriter bwt = new BufferedWriter(new FileWriter("relatorioTemporario.txt", true))) {

            bw.write("Saldo Atual: " + UI.FormatarDecimal(saldo) + "\n");
            bwt.write("Saldo Atual: " + UI.FormatarDecimal(saldo) + "\n");
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
            System.out.println(e.getMessage());
        }

        return 50000.00;
    }
}