package com.emre.queryservice.service;

import com.emre.queryservice.model.Urun;
import com.emre.queryservice.repository.UrunRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrunService {

    private final UrunRepository urunRepository;

    public UrunService(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    public Iterable<Urun> tumUrunleriGetirService(){
        return urunRepository.findAll();
    }

    public Optional<Urun> tekKayitGetir(Long urun_id){
        return  urunRepository.findById(urun_id);
    }


}
