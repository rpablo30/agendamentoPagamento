package io.github.rpablo30.Rodrigo.Pablo.Controller;

import io.github.rpablo30.Rodrigo.Pablo.Dto.AgendamentoDto;
import io.github.rpablo30.Rodrigo.Pablo.UserService.AgendamentoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoDto salvar(@RequestBody AgendamentoDto dto) {
        return service.salvar(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AgendamentoDto> procurarTodos(@PageableDefault(page = 0,
            size = 10,
            sort = "id") Pageable pageable) {
        return service.mostrarTodos(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<AgendamentoDto> procurarPorId(@PathVariable Long id) {
        Optional<AgendamentoDto> dto = service.procurarPorId(id);
        return dto;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoDto atualizar(@PathVariable Long id, @RequestBody AgendamentoDto dto) {
        dto = service.atualizar(id, dto);
        return dto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoDto delete(@PathVariable Long id) {
        service.delete(id);
        return null;
    }

}
