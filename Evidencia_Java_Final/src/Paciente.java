public class Paciente {

    private String idPaciente;
    private String nombre;
    private String email;
    private String telefono;

    public Paciente(){}

    public Paciente(String id, String nombre, String email, String telefono){

        this.idPaciente = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;

    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCadena(){

        return this.nombre+","+this.email+","+this.telefono;

    }

}
