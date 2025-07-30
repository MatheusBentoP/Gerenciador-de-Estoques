package br.com.GerenciaEstoque.controller;

import br.com.GerenciaEstoque.dto.ProdutoDto;
import br.com.GerenciaEstoque.dto.ProdutoResponceDto;
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


    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;

    }

    @PostMapping
    public ResponseEntity<ProdutoResponceDto> cadastrarProduto(@RequestBody ProdutoDto dto){
        ProdutoResponceDto newProdutoResponce = produtoService.salvarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProdutoResponce);

    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponceDto>> mostrar() {
        List<ProdutoResponceDto> showProduto = produtoService.mostrarTudo();
        return ResponseEntity.ok(showProduto);
    }

    @GetMapping("/{id}")
    public ProdutoResponceDto mostrarUmProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

//        ProdutoResponceDto dto = produtoService.getProdutoById(id);
//        return ResponseEntity.ok(dto); // Retorna 200 OK com o DTO


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponceDto> updateProduto(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        ProdutoResponceDto atualizaProduto = produtoService.updateProduto(id, produtoDto);
        return ResponseEntity.ok(atualizaProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtoService.deletarProdutoById(id);
        return ResponseEntity.noContent().build();
    }




}
