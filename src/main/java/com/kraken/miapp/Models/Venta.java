
package com.kraken.miapp.Models;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
    
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ventas")
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_hora;

    @Column(precision = 10,scale = 2)
    private BigDecimal monto_total;

    @Column(nullable = false)
    private String estado_pago;

    @Column(nullable = false)
    private String tipo_pago;

    @OneToOne
    @JoinColumn(name = "cita_id",referencedColumnName = "id",unique = true)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "venta",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Detalle> detalles = new ArrayList<>();

    @OneToMany(mappedBy = "venta",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Detalle_Pago> detalle_pagos = new ArrayList<>();
    
}
