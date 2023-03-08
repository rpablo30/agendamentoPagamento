package io.github.rpablo30.Rodrigo.Pablo.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "usuario_nome", nullable = false)
    private String nome;
    @Column(name = "usuario_cpf", length = 11, nullable = false)
    private String cpf;
    @Column(name = "usuario_telefone", nullable = false)
    private String telefone;
    @Column(name = "usuario_email", length = 40, nullable = false)
    private String email;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime data;
}
