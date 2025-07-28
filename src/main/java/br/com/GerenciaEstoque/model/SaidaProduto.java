package br.com.GerenciaEstoque.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Saída")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaidaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_saida;

    private Produto produto;

    private Integer quantidade_saida;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_saida;
}
