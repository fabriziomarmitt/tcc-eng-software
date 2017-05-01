package co.bergamota.resources.suspencao;

import co.bergamota.resources.suspencao.models.Suspencao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuspencaoRepository extends MongoRepository<Suspencao, Integer> {
}
