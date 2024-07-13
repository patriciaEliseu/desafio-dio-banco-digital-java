import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstituicaoFinanceira {
    private String nome;
    private TipoConta tipoConta;
    private static List<Conta> contas;

    public String getNome () {
        return nome;
    }
    public void setNome (String nome){
        this.nome = nome;
    }

    public List<Conta>getContas() {
        return contas;
    }
    private void setContas(List<Conta> listaDeContas) {
    }

    public void imprimirListaDeContas() {
        if (contas != null && !contas.isEmpty()) {
            for (Conta conta : contas) {
                System.out.println("Agencia: " + conta.getAgencia());
                System.out.println("Numero: " + conta.getNumero());
                System.out.println("Tipo: " + conta.getTipo());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("Titular: " + conta.getTitular().getNome());
                System.out.println("---------------------------");
            }
        } else {
                System.out.println("Nenhuma conta encontrada.");
        }
    }


    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Oliveira");

        Conta conta1 = new Conta(1, 456, TipoConta.CONTACORRENTE, 1000.0, cliente1);
        conta1.abrir();

        Conta conta2 = new Conta(1, 789, TipoConta.POUPANCA, 2000.0, cliente2);
        conta2.abrir();

//        List<Conta> listaDeContas = new ArrayList<>();
//        listaDeContas.add(conta1);
//        listaDeContas.add(conta2);

//        InstituicaoFinanceira banco = new InstituicaoFinanceira();
//        banco.setNome("Banco Digital");
//        banco.setContas(listaDeContas);



    Transacao transacao = new Transacao(1,100, new Date(),conta1, conta2);
    transacao.realizar();

    transacao.cancelar();





    }



}