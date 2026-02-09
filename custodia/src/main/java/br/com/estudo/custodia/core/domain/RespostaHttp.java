package br.com.estudo.custodia.core.domain;

import br.com.estudo.custodia.adapter.out.dto.LiquidacaoResponseDTO;

public class RespostaHttp {
    private int status;
    private LiquidacaoResponseDTO body;

    public RespostaHttp(int status, LiquidacaoResponseDTO body) {
        this.status = status;
        this.body = body;
    }

    public LiquidacaoResponseDTO getBody() {
        return body;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "RespostaHttp{" +
                "status=" + status +
                ", body=" + body +
                '}';
    }
}
