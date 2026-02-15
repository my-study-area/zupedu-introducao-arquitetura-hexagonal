package br.com.estudo.custodia.port.out;

public class CustodiaNumeroOperacao {
    private final String numeroContratoLegado;
    private final String numeroContratoModernizado;
    private final String siglaSistemaOrigemOperacao;

    private CustodiaNumeroOperacao(Builder builder) {
        this.numeroContratoLegado = builder.numeroContratoLegado;
        this.numeroContratoModernizado = builder.numeroContratoModernizado;
        this.siglaSistemaOrigemOperacao = builder.siglaSistemaOrigemOperacao;
    }

    public String getNumeroContratoModernizado() {
        return numeroContratoModernizado;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String numeroContratoLegado;
        private String numeroContratoModernizado;
        private String siglaSistemaOrigemOperacao;

        public Builder numeroContratoLegado(String numeroContratoLegado) {
            this.numeroContratoLegado = numeroContratoLegado;
            return this;
        }

        public Builder numeroContratoModernizado(String numeroContratoModernizado) {
            this.numeroContratoModernizado = numeroContratoModernizado;
            return this;
        }

        public Builder siglaSistemaOrigemOperacao(String siglaSistemaOrigemOperacao) {
            this.siglaSistemaOrigemOperacao = siglaSistemaOrigemOperacao;
            return this;
        }

        public CustodiaNumeroOperacao build() {
            return new CustodiaNumeroOperacao(this);
        }
    }
}