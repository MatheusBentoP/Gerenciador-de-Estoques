package br.com.GerenciaEstoque.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Produto")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;
    private String descricao;
    private Integer quantidade;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;


    @Enumerated(EnumType.STRING)
    private TiposProduto tiposProduto;

}