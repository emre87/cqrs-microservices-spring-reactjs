package com.emre.queryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    @Document(indexName = "urun")
    public class Urun{

        @Id
        private Long urunId;

        private String urunTanim;

        private double urunFiyat;

        private String urunKategori;

}
