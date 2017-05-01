package co.bergamota.resources.suspencao;

import co.bergamota.messaging.Event;
import co.bergamota.messaging.Sender;
import co.bergamota.resources.suspencao.models.Suspencao;
import co.bergamota.resources.suspencao.models.SuspencaoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assinaturas")
@Api(value = "suspencao", tags = "Suspenção",description = "Operações para suspenção de assinatura")
public class SuspencaoV1Controller {

    @Autowired
    SuspencaoRepository suspencaoRepository;


    @Autowired
    Sender sender;

    @RequestMapping(value = "/assinatura/{assinaturaId}/suspender", method = RequestMethod.POST)
    @ApiOperation(value = "Registra nova suspenção para uma assinatura")
    public ResponseEntity suspender(@PathVariable int assinaturaId, @RequestBody SuspencaoRequest suspencaoRequest) {
        Suspencao suspencao = suspencaoRepository.save(Suspencao.convert(suspencaoRequest, assinaturaId));
        sender.sendMessage(new Event(suspencao, "ASSINATURAS_ASSINATURA_SUSPENCAO"));
        return ResponseEntity.status(HttpStatus.CREATED).body(suspencao);
    }
}