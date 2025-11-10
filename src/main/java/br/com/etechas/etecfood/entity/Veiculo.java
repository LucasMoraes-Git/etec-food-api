/* Guilherme Rosseto Valentim
* Vinicius Kobayashi
* João Pedro Vieira
* Lucas de Andrade Moraes
* Raphael Luis*/

package br.com.etechas.etecfood.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import br.com.etechas.etecfood.Enums.TipoVeiculoEnum;

@Getter
@Setter

@Entity
@Table(name = "Veiculo")

public class Veiculo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_VEIC")
    private Long id;

    @Column(name = "TX_PLACA_VEIC")
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_VEIC")
    private TipoVeiculoEnum tipo;

    @JoinColumn(name = "ID_ENT")
    @ManyToOne
    private Entregador entregador;
}
