
package conexion;


public class login {
    private int id_empleado;
    private String nombre;
    private String correo;
    private String pass;

    public login() {
    }

    public login(int id_empleado, String nombre, String correo, String pass) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}

