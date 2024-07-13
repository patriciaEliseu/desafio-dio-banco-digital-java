
import java.util.List;

public class Conta implements iConta {
    private  int agencia;
    private int numero;
    private TipoConta tipo;
    private double saldo;
    private Cliente titular;
    private boolean ativa;

    private static  final int AGENCIA_PADRAO = 1;
//    private static int SEQUENCIAL = 1;
    private Conta Conta;

    public Conta(int agencia, int numero, TipoConta tipo, double saldo, Cliente titular) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.titular = titular;
        this.ativa = false;
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public Conta abrir() {
       this.ativa = true;
        System.out.println("Conta aberta com sucesso "+" Agência: " + agencia + " Tipo de conta: " + tipo + " número da conta: " +  numero );
        return Conta;
    }

    public Conta fechar() {
        if(this.saldo == 0) {
            this.ativa = false;
            System.out.println("Conta fechada com sucesso.");
        } else {
            System.out.println("Não é possível fechar a conta. Saldo deve ser zero.");
        }
        return Conta;
    }

    @Override
    public double transferir(double valor, Conta contaDestino) {
        if(this.ativa && contaDestino.isAtiva() && valor > 0 && saldo >= valor ) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            return saldo;
        }
        System.out.println("Transferência falhou!");
        return saldo;
    }

    @Override
    public double depositar(double valor) {
        if(this.ativa && valor >0) {
            saldo += valor;
            return saldo;
        }
        System.out.println("Depósito falhou!");
        return saldo;
    }

    @Override
    public double sacar(double valor) {
       if(this.ativa && valor > 0 && saldo >= valor) {
           saldo -= valor;
           return saldo;
       }
        System.out.println("Saque falhou!");
        return saldo;

    }

//    Conta imprimirInfosComuns() {
//        System.out.println(String.format("Titular:  %s" , this.titular));
//        System.out.println(String.format("Agencia:  %d" , this.agencia));
//        System.out.println(String.format("numero:  %d" , this.numero));
//        System.out.println(String.format("saldo:  %.2f" , this.saldo));
//        return null;
//    }


}
