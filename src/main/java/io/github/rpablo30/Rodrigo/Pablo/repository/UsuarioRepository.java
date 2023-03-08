package io.github.rpablo30.Rodrigo.Pablo.repository;


import io.github.rpablo30.Rodrigo.Pablo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



}