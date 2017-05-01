package co.bergamota.resources.assinatura.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "assinatura")
public class Assinatura {
    public enum Status { ATIVO, CANCELADO, SUSPENSO }

    @Id
    public String assinaturaId;
    @Field("descricao")
    public String descricao;
    @Field("status")
    public Status status;

    public Assinatura(){}

    public Assinatura(String descricao, Status status){
        this.descricao = descricao;
        this.status = status;
    }
}
