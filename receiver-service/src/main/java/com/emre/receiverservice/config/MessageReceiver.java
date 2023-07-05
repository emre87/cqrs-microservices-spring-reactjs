package com.emre.receiverservice.config;

import com.emre.receiverservice.model.Urun;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    private UrunElasticsearchWriter urunElasticsearchWriter;


    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessageFromQueue(@Payload Urun urun) {
        System.out.println("Message recieved from queue : " + urun);

        urunElasticsearchWriter.saveUrun(urun);

    }
}
