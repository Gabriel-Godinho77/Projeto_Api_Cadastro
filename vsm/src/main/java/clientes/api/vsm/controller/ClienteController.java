package clientes.api.vsm.controller;



import clientes.api.vsm.domain.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import clientes.api.vsm.domain.cliente.DadosCadastroCliente;
import clientes.api.vsm.domain.cliente.Cliente;


@RestController
@RequestMapping("clientes")
public class ClienteController {


    @Autowired
    public ClienteRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(dados);
        repository.save(cliente);
        var uri= uriBuilder.path("/clientes/{cpfCnpj}").buildAndExpand(cliente.getCpfCnpj()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<DadosDetalhamentoCliente>> listarAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<DadosDetalhamentoCliente>> listarInativos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoFalse(paginacao).map(DadosDetalhamentoCliente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterar(@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosCadastroCliente(cliente));

    }

    @DeleteMapping({"/{id}"})
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
        return ResponseEntity.noContent().build();

    }

    @PutMapping({"/{id}"})
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.ativar();
        return ResponseEntity.noContent().build();

    }

    @GetMapping({"/{cpfCnpj}"})
    public ResponseEntity buscarCliente(@PathVariable String cpfCnpj){
        Cliente cliente = repository.findByCpfCnpj(cpfCnpj);
        return ResponseEntity.ok(new DadosCadastroCliente(cliente));
    }

}
