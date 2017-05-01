package co.bergamota.resources.cancelamento;


import co.bergamota.resources.cancelamento.models.Cancelamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CancelamentoRepository extends MongoRepository<Cancelamento, Integer>{

}
