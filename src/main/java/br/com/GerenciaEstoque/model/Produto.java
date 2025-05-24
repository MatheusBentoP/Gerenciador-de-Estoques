package br.com.GerenciaEstoque.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(unique = true, nullable = false)
    private String nome;
    private String descricao;
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private TiposProduto tiposProduto;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Integer quantidade, TiposProduto tiposProduto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tiposProduto = tiposProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TiposProduto getTiposProduto() {
        return tiposProduto;
    }

    public void setTiposProduto(TiposProduto tiposProduto) {
        this.tiposProduto = tiposProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", tiposProduto=" + tiposProduto +
                '}';
    }

}

