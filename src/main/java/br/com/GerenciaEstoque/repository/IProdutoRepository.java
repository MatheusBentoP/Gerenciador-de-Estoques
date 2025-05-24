package br.com.GerenciaEstoque.repository;

import br.com.GerenciaEstoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);


}
