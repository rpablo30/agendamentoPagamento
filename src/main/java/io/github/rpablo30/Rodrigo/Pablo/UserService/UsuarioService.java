package io.github.rpablo30.Rodrigo.Pablo.UserService;

import io.github.rpablo30.Rodrigo.Pablo.Dto.UsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioService {

    UsuarioDto salvar(UsuarioDto dto);
    Page<UsuarioDto> procurarTodos(Pageable pageable);
    Optional<UsuarioDto> procurarPorId(Long id);
    UsuarioDto atualizar(Long id, UsuarioDto dto);
    void delete(Long id);


}