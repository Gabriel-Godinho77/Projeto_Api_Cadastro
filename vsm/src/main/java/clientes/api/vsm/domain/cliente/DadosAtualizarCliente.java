package clientes.api.vsm.domain.cliente;

import clientes.api.vsm.domain.endereco.DadosCadastroEndereco;
import clientes.api.vsm.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarCliente(
        @NotNull
        Long id,
        String nome,
        @Pattern(regexp = "\\d{11,14}")
        String cpfCnpj,
        String senha,
        @Valid
        DadosCadastroEndereco endereco,
        @Email
        String email,
        String telefone)
     {
}
