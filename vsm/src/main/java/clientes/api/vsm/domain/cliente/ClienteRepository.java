package clientes.api.vsm.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);

    Page<Cliente> findAllByAtivoFalse(Pageable paginacao);

    Cliente findByCpfCnpj(String cpfCnpj);
}
