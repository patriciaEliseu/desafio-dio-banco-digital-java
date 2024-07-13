import java.util.Date;

public class Cliente {
    private String nome;
    private String cpf;
    private String logradouro;
    private Date dataNascimento;
    private Date dataOpenConta;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public  Cliente cadastrar() {
        return this;

    }

    public Cliente atualizarDados() {
        return this;
    }
}
