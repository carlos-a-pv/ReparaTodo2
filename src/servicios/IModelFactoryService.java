package servicios;

import modelo.Cliente;
import modelo.Orden;
import modelo.Pago;
import modelo.Producto;
import modelo.enums.Estado;

import java.util.ArrayList;

public interface IModelFactoryService {

    //Orden
    boolean crearOrden(Orden orden);
    boolean cambiarEstadoOrden(String idOrden, Estado estadoNuevo);
    boolean tomarOrden(String idTecnico,String idOrden);
    boolean registrarActividad(String idOrden,String registroActividades);
    boolean registrarPago(String idOrden, Pago pago);

    //Cliente
    /*boolean registrarCliente(Cliente cliente);
    boolean actualizarCliente(Cliente datosNuevos,String idCliente);*/

    //Producto
    boolean actualizaProducto(Producto datosNuevos,String idProducto);

    Cliente buscarCliente(String idCliente);

    ArrayList<Orden> getOrdenes();

    ArrayList<Cliente> getClientes();

    String generarId();

    Orden getOrdenSeleccionada();

    void setOrdenSeleccionada(Orden ordeSelecionada);

    boolean crearCliente(Cliente newCliente);
}
