package br.com.GerenciaEstoque.mapper;

import br.com.GerenciaEstoque.dto.ProdutoDto;
import br.com.GerenciaEstoque.dto.ProdutoResponceDto;
import br.com.GerenciaEstoque.model.Produto;

public class ProdutoMapper {
    public static Produto toEntity(ProdutoDto dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setQuantidade(dto.getQuantidade());
        produto.setDescricao(dto.getDescricao());
        produto.setTiposProduto(dto.getTiposProduto());


        return  produto;
    }

    public static ProdutoResponceDto toDTO(Produto produto){
        return new ProdutoResponceDto(
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getDescricao(),
                produto.getTiposProduto()
        );
    }

}
