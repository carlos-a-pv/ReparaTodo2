package modelo;

import lombok.Data;

@Data
public class CallCenter{
    public String idCall;
    public String nombre;
    public String email;
    public String telefono;
    public String direccion;

    public CallCenter( ){

    }
}
