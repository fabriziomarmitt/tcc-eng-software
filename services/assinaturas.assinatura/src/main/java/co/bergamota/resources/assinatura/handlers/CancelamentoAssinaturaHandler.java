package co.bergamota.resources.assinatura.handlers;

import co.bergamota.messaging.Event;
import co.bergamota.messaging.EventHandler;
import co.bergamota.resources.assinatura.AssinaturaRepository;
import co.bergamota.resources.assinatura.models.Assinatura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class CancelamentoAssinaturaHandler {

    @Autowired
    AssinaturaRepository assinaturaRepository;

    private static final Logger log = LoggerFactory.getLogger(CancelamentoAssinaturaHandler.class);

    @EventHandler("ASSINATURAS_ASSINATURA_CANCELAMENTO")
    public void handleEvent(Event event){
        String assinaturaId = ((LinkedHashMap) event.getPayload()).get("assinaturaId").toString();
        Assinatura assinatura = assinaturaRepository.findOne(assinaturaId);
        assinatura.status = Assinatura.Status.CANCELADO;
        assinaturaRepository.save(assinatura);
        log.info("Assinatura {} cancelada com sucesso", assinatura.assinaturaId);
    }

}