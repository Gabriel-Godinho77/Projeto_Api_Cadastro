package clientes.api.vsm.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
        String logradouro,

        String bairro,

        @Pattern(regexp = "\\d{8}")
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf
        ) {
        public DadosCadastroEndereco(Endereco endereco) {
                this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getNumero(), endereco.getComplemento(), endereco.getCidade(), endereco.getUf());
        }
}
