package com.kraken.miapp.Models;


import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "detalles")
@Builder
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

}
