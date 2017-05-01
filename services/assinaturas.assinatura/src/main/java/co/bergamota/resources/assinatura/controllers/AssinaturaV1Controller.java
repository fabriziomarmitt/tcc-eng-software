package co.bergamota.resources.assinatura.controllers;

import co.bergamota.messaging.Event;
import co.bergamota.messaging.Sender;
import co.bergamota.resources.assinatura.AssinaturaRepository;
import co.bergamota.resources.assinatura.models.Assinatura;
import co.bergamota.resources.assinatura.models.AssinaturaRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assinaturas")
@Api(value = "assinatura", tags = "Assinatura",description = "Operações para assinatura de assinatura")
public class AssinaturaV1Controller {
    @Autowired
    AssinaturaRepository assinaturaRepository;

    @Autowired
    Sender sender;

    @RequestMapping(value = "/assinatura", method = RequestMethod.POST)
    public ResponseEntity postAssinatura(@RequestBody AssinaturaRequest assinaturaRequest){
        Assinatura assinatura = new Assinatura(assinaturaRequest.getDescricao(), Assinatura.Status.ATIVO);
        assinatura = assinaturaRepository.save(assinatura);
        sender.sendMessage(new Event(assinatura, "ASSINATURA_CRIADA"));
        return ResponseEntity.status(HttpStatus.CREATED).body(assinatura);
    }

    @RequestMapping(value = "/assinatura/{assinaturaId}", method = RequestMethod.GET)
    public ResponseEntity getAssinatura(@PathVariable("assinaturaId") String assinaturaid){
        return ResponseEntity.ok(assinaturaRepository.findOne(assinaturaid));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAssinaturas(){
        return ResponseEntity.ok(assinaturaRepository.findAll());
    }
}
