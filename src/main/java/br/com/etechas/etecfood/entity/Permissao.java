// Beatriz Alves, Gustavo Bastos, Roger Novais, Kauã Peregrino, Igor Henrique

package br.com.etechas.etecfood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TBL_PERMISSAO")
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERMISSAO")
    private Long id;

    @Column(name = "TX_AUTHORITY")
    private String authority;
    //teste
}
