package co.bergamota.resources.cancelamento;

import co.bergamota.messaging.Event;
import co.bergamota.messaging.Sender;
import co.bergamota.resources.cancelamento.models.Cancelamento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/assinaturas")
@Api(value = "cancelamento", tags = "Cancelamento",description = "Operações para cancelamento de assinatura")
public class CancelamentoV1Controller {

    @Autowired
    CancelamentoRepository cancelamentoRepository;

    @Autowired
    Sender sender;

    @RequestMapping(value = "/assinatura/{assinaturaId}/cancelar", method = RequestMethod.POST)
    @ApiOperation(value = "Registra novo cancelamento para uma assinatura")
    public ResponseEntity cancelar(@PathVariable String assinaturaId) {
        Cancelamento cancelamento = cancelamentoRepository.save(new Cancelamento (assinaturaId, new Date()));
        sender.sendMessage(new Event(cancelamento, "ASSINATURAS_ASSINATURA_CANCELAMENTO"));
        return ResponseEntity.status(HttpStatus.CREATED).body(cancelamento);
    }
}
