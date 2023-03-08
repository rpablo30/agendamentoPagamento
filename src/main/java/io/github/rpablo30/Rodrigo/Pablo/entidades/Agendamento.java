package io.github.rpablo30.Rodrigo.Pablo.entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_agendamento")
public class Agendamento extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tb_valorPagamento")
    private BigDecimal pagarValor;
    @Enumerated(EnumType.STRING)
    @Column(name = "tb_status")
    private StatusPagamento status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
