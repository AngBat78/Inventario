
package conexion;

/**
 *
 * @author Prueba 1
 */
public class Proveedor {
    private int id_prov;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    
    public Proveedor(){
        
    }

    public Proveedor(int id_prov, String nombre, String telefono, String correo, String direccion) {
        this.id_prov = id_prov;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    
    
}
