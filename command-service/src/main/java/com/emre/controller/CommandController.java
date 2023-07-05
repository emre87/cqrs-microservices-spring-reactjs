package com.emre.controller;


import com.emre.config.MessagePublisher;
import com.emre.model.Urun;
import com.emre.service.UrunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/urun_yaz")
public class CommandController {

    private final UrunService urunService;
    private final MessagePublisher messagePublisher;

    public CommandController(UrunService urunService, MessagePublisher messagePublisher) {
        this.urunService = urunService;
        this.messagePublisher = messagePublisher;
    }

    @PostMapping("/yaz")
    public ResponseEntity<String> createProduct(@RequestBody Urun urun) {
        // Ürünü MySQL veritabanına kaydet
        urunService.createUrun(urun);

        // Ürünü RabbitMQ'ya yayınla
        messagePublisher.publishProduct(urun);

        return ResponseEntity.ok("Product created successfully");
    }


}
