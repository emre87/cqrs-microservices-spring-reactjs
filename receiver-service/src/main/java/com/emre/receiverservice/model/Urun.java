package com.emre.receiverservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Urun{

    @Id
    private Long urunId;

    private String urunTanim;

    private double urunFiyat;

    private String urunKategori;

}
