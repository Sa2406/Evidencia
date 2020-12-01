public class Cita {

    private String idCita;
    private String doctor;
    private String paciente;
    private String fecha;
    private String hora;

    public Cita(){

    }

    public Cita(String id, String doctor, String paciente, String fecha, String hora ){

        this.idCita = id;
        this.doctor =  doctor;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;

    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCadena(){

        return this.doctor+","+this.paciente+","+this.fecha+","+this.hora;

    }

}
