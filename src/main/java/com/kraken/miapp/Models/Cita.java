
package com.kraken.miapp.Models;


import lombok.*;
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
@Table(name = "citas")
@Builder
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha_hora_inicio;
    private LocalDateTime fecha_hora_fin;
    private String estado;
    @Column(precision = 10,scale = 2)
    private BigDecimal pago_inicial;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "barbero_id")
    private Usuario barbero;

    @OneToMany(mappedBy = "cita",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Cita_Servicio> cita_servicios = new ArrayList<>();

    @OneToOne(mappedBy = "cita")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private Tipo_Pago tipopago;
}
