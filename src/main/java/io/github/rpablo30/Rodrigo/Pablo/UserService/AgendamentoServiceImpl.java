package io.github.rpablo30.Rodrigo.Pablo.UserService;

import io.github.rpablo30.Rodrigo.Pablo.Dto.AgendamentoDto;
import io.github.rpablo30.Rodrigo.Pablo.entidades.Agendamento;
import io.github.rpablo30.Rodrigo.Pablo.entidades.StatusPagamento;
import io.github.rpablo30.Rodrigo.Pablo.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository repository;

    @Override
    public AgendamentoDto salvar(AgendamentoDto dto) {
        Agendamento entity = new Agendamento();
        BeanUtils.copyProperties(dto, entity);
        entity.setDataDeCriacao(LocalDateTime.now());
        entity.setStatus(StatusPagamento.PENDING);
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<AgendamentoDto> mostrarTodos(Pageable pageable) {
        Page<Agendamento> list = repository.findAll(pageable);
        return list.map(x-> new AgendamentoDto(x));
    }

    @Override
    public Optional<AgendamentoDto> procurarPorId(Long id) {
        Optional<Agendamento> scheduleOptional = repository.findById(id);
        Agendamento entity = scheduleOptional.orElseThrow();
        return Optional.of(new AgendamentoDto(entity));
    }

    @Override
    public AgendamentoDto atualizar(Long id, AgendamentoDto dto) {
        Agendamento entity = repository.findById(id).orElseThrow();

        entity.setStatus(dto.getStatus());
        entity.setDataDeAtualizacao(LocalDateTime.now());
        repository.save(entity);
        return new AgendamentoDto(entity);
    }



    @Override
    public void delete(Long id) {

    }

}
