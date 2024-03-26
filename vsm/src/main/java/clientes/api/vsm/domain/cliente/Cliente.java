package clientes.api.vsm.domain.cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import clientes.api.vsm.domain.endereco.Endereco;


@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String senha;

    @Embedded
    private Endereco endereco;

    private String telefone;
    private String email;
    private Boolean ativo;


    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.cpfCnpj = dados.cpfCnpj();
        this.senha = dados.senha();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarCliente dados) {
        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
        if(dados.cpfCnpj()!= null){
            this.cpfCnpj = dados.cpfCnpj();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarEndereco(dados.endereco());
        }
        if(dados.email() != null){
            this.email = dados.email();
            
        }if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
