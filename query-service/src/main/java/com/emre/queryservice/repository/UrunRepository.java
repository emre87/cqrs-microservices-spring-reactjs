package com.emre.queryservice.repository;

import com.emre.queryservice.model.Urun;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends ElasticsearchRepository<Urun,Long> {
}
