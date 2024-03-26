package clientes.api.vsm.domain.cliente;

import clientes.api.vsm.domain.endereco.DadosCadastroEndereco;
import clientes.api.vsm.domain.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String cpfCnpj, String senha, Endereco endereco, String telefone, String email, Boolean ativo) {

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getCpfCnpj(), cliente.getSenha(), cliente.getEndereco(),cliente.getTelefone(), cliente.getEmail(), cliente.getAtivo());
    }
}
