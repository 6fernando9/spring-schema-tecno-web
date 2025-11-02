package com.kraken.miapp.Models;



import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tipo_pagos")
@Builder
public class Tipo_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @OneToMany(mappedBy = "tipopago",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Cita> citas = new ArrayList<>();
    @OneToMany(mappedBy = "tipopago",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Detalle_Pago> detalle_pagos = new ArrayList<>();

}

