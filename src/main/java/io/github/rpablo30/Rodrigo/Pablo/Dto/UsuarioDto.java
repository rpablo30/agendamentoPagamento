package io.github.rpablo30.Rodrigo.Pablo.Dto;

import io.github.rpablo30.Rodrigo.Pablo.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private String nome;
    @CPF
    private String cpf;
    private String telefone;
    @Email
    private String email;

    public UsuarioDto(Usuario usuario) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
    }
}
