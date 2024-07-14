package gmao.api.Equipement.config;

import gmao.api.Equipement.Domain.Equipement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private static final String TOPIC = "equipement";

    @Autowired
    private KafkaTemplate<String, Equipement> kafkaTemplate;

    public void sendMessage(Equipement equipement) {
        kafkaTemplate.send(TOPIC, equipement);
    }
}
