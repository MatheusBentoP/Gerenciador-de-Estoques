package br.com.GerenciaEstoque.service;

import br.com.GerenciaEstoque.dto.ProdutoDto;
import br.com.GerenciaEstoque.model.Produto;
import br.com.GerenciaEstoque.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService{

    @Autowired
    private IProdutoRepository repository;

    public ProdutoService(IProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvarProduto(ProdutoDto dto){
        Produto produto = new Produto();
        return repository.save(produto);
    }

    public List<Produto> mostrarTudo(){
        return repository.findAll();
    }
    public Produto getProdutoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


    public  Produto updateProduto(Produto produto) {
        repository.save(produto);
        return produto;
    }



    public void deletarProdutoById(Long id){
        repository.deleteById(id);
    }








}
