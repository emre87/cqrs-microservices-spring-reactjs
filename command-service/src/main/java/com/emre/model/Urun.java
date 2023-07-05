package com.emre.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "urunler")
public class Urun {

    @Id
    private Long urunId;

    private String urunTanim;

    private double urunFiyat;

    private String urunKategori;

}
