package co.bergamota.resources.suspencao.models;

import java.util.Date;

public class SuspencaoRequest {
    private Date dataInicio;
    private Date dataFim;

    public Date getDataInicio() {
        return dataInicio;
    }

    public SuspencaoRequest setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public SuspencaoRequest setDataFim(Date dataFim) {
        this.dataFim = dataFim;
        return this;
    }
}