
package com.kraken.miapp.Models;


import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
@Table(name = "usuarios")
@Builder
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(nullable = false,unique = true)
    private String email;
    private String telefono;
    private String password;
    private String rol;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_registro;

    @OneToMany(mappedBy = "usuario",cascade = { CascadeType.PERSIST,CascadeType.MERGE })    
    private List<Horario_Barbero> horario_barberos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Excepciones_Horario> excepciones_horarios = new ArrayList<>();

    @OneToMany(mappedBy = "cliente",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Cita> citas_1 = new ArrayList<>();

    @OneToMany(mappedBy = "barbero",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Cita> citas_2 = new ArrayList<>();

    @OneToMany(mappedBy = "cliente",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Venta> ventas_1 = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Venta> ventas_2 = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    private List<Movimiento_Inventario> movimiento_inventarios = new ArrayList<>();
    
}
    