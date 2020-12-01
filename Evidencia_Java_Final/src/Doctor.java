public class Doctor {

    private String idDoctor;
    private String nombre;
    private String especialidad;
    private String telefono;

    public Doctor(){}

    public Doctor(String id, String nombre, String especialidad, String telefono){

        this.idDoctor = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;

    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCadena(){
        return this.nombre+","+this.especialidad+","+this.telefono;
    }

}
