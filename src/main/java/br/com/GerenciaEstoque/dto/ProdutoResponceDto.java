package br.com.GerenciaEstoque.dto;

import br.com.GerenciaEstoque.model.TiposProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponceDto {
    private String nome;
    private Integer quantidade;

    private TiposProduto tiposProduto;
}
