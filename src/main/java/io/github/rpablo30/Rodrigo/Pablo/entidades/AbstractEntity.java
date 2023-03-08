package io.github.rpablo30.Rodrigo.Pablo.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class AbstractEntity {

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime dataDeCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime dataDeAtualizacao;
}
