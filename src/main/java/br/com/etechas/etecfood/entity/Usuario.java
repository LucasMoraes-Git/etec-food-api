// Beatriz Alves, Gustavo Bastos, Roger Novais, Kauã Peregrino, Igor Henrique

package br.com.etechas.etecfood.entity;

import br.com.etechas.etecfood.enums.StatusUsuarioEnum;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_SENHA")
    private String senha;

    @Column(name = "NR_TENTATIVAS_ACESSO")
    private int tentativasAcesso;

    @Column(name = "DT_DATA_BLOQUEIO")
    private LocalDateTime dataBloqueio;

    @Column(name = "DT_DATA_INATIVACAO")
    private LocalDateTime dataInativacao;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioEnum status;

    @ManyToMany
    @JoinTable(
            name = "TBL_USUARIO_PERMISSAO",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERMISSAO")
    )
    private List<Permissao> permissoes;
}
