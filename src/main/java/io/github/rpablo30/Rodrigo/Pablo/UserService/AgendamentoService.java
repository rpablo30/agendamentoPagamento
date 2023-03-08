package io.github.rpablo30.Rodrigo.Pablo.UserService;

import io.github.rpablo30.Rodrigo.Pablo.Dto.AgendamentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AgendamentoService {

    AgendamentoDto salvar(AgendamentoDto dto);
    Page<AgendamentoDto> mostrarTodos(Pageable pageable);
    Optional<AgendamentoDto> procurarPorId(Long id);
    AgendamentoDto atualizar(Long id, AgendamentoDto dto);
    void delete(Long id);
}
