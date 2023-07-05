package com.emre.queryservice.controller;


import com.emre.queryservice.model.Urun;
import com.emre.queryservice.service.UrunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("urun_oku")
public class QueryController {

    Logger logger = LoggerFactory.getLogger(QueryController.class);
    private final UrunService urunService;


    public QueryController(UrunService urunService) {
        this.urunService = urunService;
    }

    @GetMapping("/tum")
    public Iterable<Urun> tumUrunleriGetirController() {
        try {
            Iterable<Urun> urunler = urunService.tumUrunleriGetirService();

            logger.info("Tüm ürünler getirildi.");

            return urunler;
        } catch (Exception ex) {
            logger.error("Tüm ürünleri getirme işlemi sırasında bir hata oluştu.", ex);

        }
        return null;
    }

    @GetMapping("/tek/{urun_id}")
    public Optional<Urun> tekKayitGetir(@PathVariable Long urun_id) {

        try {
            Optional<Urun> urun = urunService.tekKayitGetir(urun_id);

            if (urun.isPresent()) {
                logger.info("Tek kayıt getirildi. Urun ID: {}", urun_id);
            } else {
                logger.info("Tek kayıt bulunamadı. Urun ID: {}", urun_id);
            }

            return urun;
        } catch (Exception ex) {
            logger.error("Tek kayıt getirme işlemi sırasında bir hata oluştu. Urun ID: {}", urun_id, ex);
        }

       return null;
    }
}