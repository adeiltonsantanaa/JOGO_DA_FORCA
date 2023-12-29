package principal.enums;

public enum ConfiguracaoEnum {
    
    QTD_TENTATIVAS("qtdTentativas", "6"), DIFICULDADE("dificuldade", "Fácil");
    
    private final String chave;
    private final String valorPadrao;
    
    ConfiguracaoEnum(String chave, String valorPadrao) {
        this.chave = chave;
        this.valorPadrao = valorPadrao;
    }
    
    public String getChave() {
        return chave;
    }
    
    public String getValorPadrao() {
        return valorPadrao;
    }
}
