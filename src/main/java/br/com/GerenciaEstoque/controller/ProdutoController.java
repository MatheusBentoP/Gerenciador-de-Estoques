package br.com.GerenciaEstoque.controller;

import br.com.GerenciaEstoque.model.Produto;
import br.com.GerenciaEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ProdutoController {

    @Autowired
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;

    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
        Produto newProduto = produtoService.salvarProduto(produto);
        return new ResponseEntity<>(newProduto, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> mostrar() {
        List<Produto> showProduto = produtoService.mostrarTudo();
        return ResponseEntity.ok(showProduto);
    }

    @GetMapping("/{id}")
    public Produto mostrarUmProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        Produto updateProduto = produtoService.updateProduto(produto);
        return ResponseEntity.ok(updateProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtoService.deletarProdutoById(id);
        return ResponseEntity.noContent().build();
    }




}
