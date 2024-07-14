package gmao.api.Equipement.config;

import gmao.api.Equipement.Domain.Equipement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class KafkaConsumer {
    private final List<Equipement> messages = Collections.synchronizedList(new LinkedList<>());

    @KafkaListener(topics = "equipement", groupId = "gmao")
    public void consume(Equipement message) {
        System.out.println("Message consommé: " + message);
        messages.add(message);
    }

    public List<Equipement> getMessages() {
        return messages;
    }
}
