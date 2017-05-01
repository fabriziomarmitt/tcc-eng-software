package co.bergamota.resources.suspencao.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Suspencao {
    @Id private String id;
    private int assinaturaId;
    private Date dataInicio;
    private Date dataFim;

    public String getId() {
        return id;
    }

    public Suspencao setId(String id) {
        this.id = id;
        return this;
    }

    public int getAssinaturaId() {
        return assinaturaId;
    }

    public Suspencao setAssinaturaId(int assinaturaId) {
        this.assinaturaId = assinaturaId;
        return this;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Suspencao setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Suspencao setDataFim(Date dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public static Suspencao convert(SuspencaoRequest suspencaoRequest, int assinaturaId){
        return new Suspencao(){{
            setAssinaturaId(assinaturaId);
            setDataInicio(suspencaoRequest.getDataInicio());
            setDataFim(suspencaoRequest.getDataFim());
        }};
    }
}