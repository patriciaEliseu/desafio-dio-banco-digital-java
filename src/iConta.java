public interface iConta {
    double sacar(double valor);
    double depositar(double valor);
    double transferir(double valor, Conta contaDestino);

}
