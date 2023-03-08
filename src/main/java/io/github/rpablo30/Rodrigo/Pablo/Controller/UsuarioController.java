package io.github.rpablo30.Rodrigo.Pablo.Controller;


import io.github.rpablo30.Rodrigo.Pablo.Dto.UsuarioDto;
import io.github.rpablo30.Rodrigo.Pablo.UserService.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @PostMapping
    public ResponseEntity<UsuarioDto> salvar(@RequestBody UsuarioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>> procurarTodos(@PageableDefault(page = 0,
            size = 10,
            sort = "id") Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.procurarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioDto>> procurarPorId(@PathVariable Long id) {
        Optional<UsuarioDto> dto = service.procurarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
