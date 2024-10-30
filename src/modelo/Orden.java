package modelo;

import lombok.*;
import modelo.enums.Estado;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Orden {

    public String idOrden;
    public Cliente cliente;
    public Pago pago;
    public String producto;
    public LocalDate fechaCreacion;
    public Estado estado;
    public String descripcionAveria;

    public Orden(){}



}
