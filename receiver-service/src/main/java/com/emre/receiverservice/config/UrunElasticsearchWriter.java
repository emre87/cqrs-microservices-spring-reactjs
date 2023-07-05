package com.emre.receiverservice.config;

import com.emre.receiverservice.model.Urun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

@Component
public class UrunElasticsearchWriter {

    private final ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public UrunElasticsearchWriter(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public void saveUrun(Urun urun) {
        try {
            String indexName = urun.getClass().getSimpleName().toLowerCase();
            IndexCoordinates indexCoordinates = IndexCoordinates.of(indexName);
            elasticsearchOperations.save(urun, indexCoordinates);
            System.out.println("Elasticsearch'e kaydedildi");
        } catch (Exception e) {
            System.out.println("Elasticsearch'e kaydedilirken bir hata oluştu: " + e.getMessage());
        }
    }



}
