package io.github.rpablo30.Rodrigo.Pablo.UserService;


import io.github.rpablo30.Rodrigo.Pablo.Dto.UsuarioDto;
import io.github.rpablo30.Rodrigo.Pablo.entidades.Usuario;
import io.github.rpablo30.Rodrigo.Pablo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public UsuarioDto salvar(UsuarioDto dto) {
        Usuario entity = new Usuario();
        BeanUtils.copyProperties(dto, entity);
        entity.setData(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<UsuarioDto> procurarTodos(Pageable pageable) {
        Page<Usuario> list = repository.findAll(pageable);
        return list.map(x -> new UsuarioDto(x));
    }

    @Override
    public Optional<UsuarioDto> procurarPorId(Long id) {
        Optional<Usuario> userOptional = repository.findById(id);
        Usuario entity = userOptional.get();
        return Optional.of(new UsuarioDto(entity));
    }

    @Override
    public UsuarioDto atualizar(Long id, UsuarioDto dto) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        Usuario entity = new Usuario();
        entity.setCpf(dto.getCpf());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        repository.save(entity);
        return new UsuarioDto(entity);
    }

    @Override
    public void delete(Long id) {

    }
}