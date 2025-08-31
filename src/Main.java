public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Cliente test = new Cliente();
        test.setNome("Graziele");
        Conta cc = new ContaCorrente(test);
        Conta poupanca = new ContaPoupanca(test);
        cc.depositar(100.0);
        cc.transferir(50.0, poupanca);
        cc.transferir(30.0, poupanca);
        cc.imprimirExtrato();
    }
}
