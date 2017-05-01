package co.bergamota.resources.cancelamento.models;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Cancelamento {
    @Id
    public String id;
    public String assinaturaId;
    public Date dataSolicitacao;

    public Cancelamento(String assinaturaId, Date dataSolicitacao){
        this.assinaturaId = assinaturaId;
        this.dataSolicitacao = dataSolicitacao;
    }
}
