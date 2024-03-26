package clientes.api.vsm.domain.cliente;

import clientes.api.vsm.domain.endereco.DadosCadastroEndereco;
import clientes.api.vsm.domain.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        String nome,
        @Pattern(regexp = "\\d{11,14}")
        String cpfCnpj,
        String senha,
        DadosCadastroEndereco endereco,
        @Email
        String email,
        String telefone) {

    public DadosCadastroCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getCpfCnpj(), cliente.getSenha(), new DadosCadastroEndereco(cliente.getEndereco()), cliente.getEmail(), cliente.getTelefone());
    }

}

