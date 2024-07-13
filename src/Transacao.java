import java.util.Date;

public class Transacao {
    private int id;
    private double valor;
    private Date data;
    private TipoConta tipo;
    private Conta contaOrigem;
    private Conta contaDestino;
    private boolean realizada;

    public Transacao(int id, double valor, Date data, Conta contaOrigem, Conta contaDestino) {
        this.id = id;
        this.valor = valor;
        this.data = data;
//        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this. realizada = false;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void realizar() {
        if (!realizada && contaOrigem.isAtiva() && contaDestino.isAtiva()) {
            if ("transferencia".equals(tipo)) {
                contaOrigem.transferir(valor, contaDestino);
            } else if ("deposito".equals(tipo)) {
                contaDestino.depositar(valor);
            } else if ("saque".equals(tipo)) {
                contaOrigem.sacar(valor);
            }
            realizada = true;
            System.out.println("Transação realizada com sucesso.");
        } else {
            System.out.println("Transação falhou.");
        }
    }

    public void cancelar() {
        if (realizada) {
            if ("Transferencia".equals(tipo)) {
                contaDestino.sacar(valor);
                contaOrigem.depositar(valor);
            } else if ("deposito".equals(tipo)) {
                contaDestino.sacar(valor);
            } else if ("saque".equals(tipo)) {
                contaOrigem.depositar(valor);
            }
            realizada = false;
            System.out.println("Transação cancelada com sucesso.");
        } else  {
            System.out.println("Não é possível cancelar uma transação não realizada.");
        }
    }


}
