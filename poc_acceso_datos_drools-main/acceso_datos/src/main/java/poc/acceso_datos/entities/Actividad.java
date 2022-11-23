package poc.acceso_datos.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "actividad")
public class Actividad {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Integer id;

   @Column(name = "nro_empresa")
   private Long nroEmpresa;

   @Column(name = "nro_contribuyente")
   private Long nroContribuyente;

   @Column(name = "tipo_aportacion")
   private Integer tipoAportacion;

   @Column(name = "fecha_inicio")
   private LocalDate fechaInicio;

   @Column(name = "vinculo_funcional")
   private Integer vinculoFuncional;

   @Column(name = "computo_especial")
   private Integer computoEspecial;

   @Column(name = "seguro_salud")
   private Integer seguroSalud;

   @Column(name = "fecha_egreso")
   private LocalDate fechaEgreso;

   @Column(name = "codigo_egreso")
   private Integer codigoEgreso;

}