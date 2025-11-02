
package com.kraken.miapp.Models;


import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
@Table(name = "productos")
@Builder
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(precision = 10,scale = 2)
    private BigDecimal precio_venta;

    private int stock_actual;
    private int stock_minimo;

    @OneToMany(mappedBy = "producto",cascade = { CascadeType.PERSIST,CascadeType.MERGE })    
    private List<Movimiento_Inventario> movimiento_inventarios = new ArrayList<>();

    @OneToMany(mappedBy = "producto",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Detalle> detalles = new ArrayList<>();
    
}
    