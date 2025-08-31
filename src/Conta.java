//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia = 1;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private List<String> historicoTransacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            registrarTransacao("Tentativa de saque de R$" + valor + " - Saldo insuficiente");
            System.out.println("Operação negada: saldo insuficiente.");
            return;
        }
        saldo -= valor;
        registrarTransacao("Saque de R$" + valor);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao("Depósito de R$" + valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > saldo) {
            registrarTransacao("Tentativa de transferência de R$" + valor + " - Saldo insuficiente");
            System.out.println("Transferência negada: saldo insuficiente.");
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarTransacao("Transferência de R$" + valor + " para conta " + ((Conta) contaDestino).getNumero());
    }

    protected void registrarTransacao(String descricao) {
        historicoTransacoes.add(descricao);
    }
    public List<String> getHistoricoTransacoes() {
        return historicoTransacoes;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
