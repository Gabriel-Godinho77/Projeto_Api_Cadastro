package clientes.api.vsm.domain.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;


    public Endereco(DadosCadastroEndereco dados){
            this.logradouro = dados.logradouro();
            this.bairro = dados.bairro();
            this.cep = dados.cep();
            this.numero = dados.numero();
            this.complemento = dados.complemento();
            this.cidade = dados.cidade();
            this.uf = dados.uf();
        }


    public void atualizarEndereco(DadosCadastroEndereco dados) {
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.numero() != null){
            this.numero = dados.numero();
        }
        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null){
            this.uf = dados.uf();
        }
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
    }
}
