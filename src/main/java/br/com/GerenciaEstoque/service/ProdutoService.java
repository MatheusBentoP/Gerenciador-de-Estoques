package br.com.GerenciaEstoque.service;

import br.com.GerenciaEstoque.dto.ProdutoDto;
import br.com.GerenciaEstoque.dto.ProdutoResponceDto;
import br.com.GerenciaEstoque.mapper.ProdutoMapper;
import br.com.GerenciaEstoque.model.Produto;
import br.com.GerenciaEstoque.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService{


    private IProdutoRepository repository;

    public ProdutoService(IProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponceDto salvarProduto(ProdutoDto dto) {
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = repository.save(produto);
        return ProdutoMapper.toDTO(salvo);

    }

    public List<ProdutoResponceDto> mostrarTudo(){
        return  repository.findAll().stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());

    }
    public ProdutoResponceDto getProdutoById(Long id) {
       Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
       return ProdutoMapper.toDTO(produto);
    }


    public ProdutoResponceDto updateProduto(Long id,ProdutoDto dto) {
        Produto produtoASerAlterado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoASerAlterado.setNome(dto.getNome());
        produtoASerAlterado.setQuantidade(dto.getQuantidade());
        produtoASerAlterado.setDescricao(dto.getDescricao());
        produtoASerAlterado.setTiposProduto(dto.getTiposProduto());

        Produto produtoAtualizado = repository.save(produtoASerAlterado);

        return ProdutoMapper.toDTO(produtoAtualizado);
    }



    public void deletarProdutoById(Long id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para exclusão com ID: " + id);
        }
        repository.deleteById(id);
    }








}
