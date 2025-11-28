// Beatriz Alves, Gustavo Bastos, Roger Novais, Kauã Peregrino, Igor Henrique

package br.com.etechas.etecfood.enums;

public enum StatusUsuarioEnum {
    ATIVO,
    INATIVO,
    BLOQUEADO;
    
    public String getDescricao() {
        switch (this) {
            case ATIVO:
                return "Usuário ativo";
            case INATIVO:
                return "Usuário inativo";
            case BLOQUEADO:
                return "Usuário bloqueado";
            default:
                return "Status desconhecido";
        }
    }
}
