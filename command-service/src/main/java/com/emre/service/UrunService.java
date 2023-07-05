package com.emre.service;

import com.emre.model.Urun;
import com.emre.repository.UrunRepository;
import org.springframework.stereotype.Service;


@Service
public class UrunService {

    private final UrunRepository urunRepository;

    public UrunService(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    public void createUrun(Urun urun) {

         urunRepository.save(urun);

    }
}
