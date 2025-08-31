//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupan�a ===");
        super.imprimirInfosComuns();
        System.out.println("Histórico de Transações:");
        for (String transacao : getHistoricoTransacoes()) {
            System.out.println("- " + transacao);
        }
    }
}
