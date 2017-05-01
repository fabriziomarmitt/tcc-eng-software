package co.bergamota.resources.assinatura;


import co.bergamota.resources.assinatura.models.Assinatura;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssinaturaRepository extends MongoRepository<Assinatura, String>{

}
