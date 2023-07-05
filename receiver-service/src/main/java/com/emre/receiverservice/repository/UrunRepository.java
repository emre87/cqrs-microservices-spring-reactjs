package com.emre.receiverservice.repository;

import com.emre.receiverservice.model.Urun;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends ElasticsearchRepository<Urun, Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}
