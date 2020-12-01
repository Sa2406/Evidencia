import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TxtHandler {

    private static final String PATH_DOCTORES = ".\\DataBase\\doctores.txt";
    private static final String PATH_PACIENTES = ".\\DataBase\\pacientes.txt";
    private static final String PATH_CITAS = ".\\DataBase\\citas.txt";
    private static final String PATH_USERS = ".\\DataBase\\usuarios.txt";

    public TxtHandler(){

    }

    public boolean buscarUser(Usuario usuario) throws Exception{


        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_USERS));

        List<String> llaves = new ArrayList<>();

        List<String> pass = new ArrayList<>();

        for(Object object: Arrays.asList(prop.keySet().toArray())){
            llaves.add(object.toString());
        }

        for (String i:llaves) {
            pass.add(prop.getProperty(i));
        }

        for (String i:llaves){

            if(usuario.getUser().equals(i)){

                for (String p:pass){

                    if(usuario.getPassword().equals(p)){

                        return true;
                    }
                }
            }
        }

        return false;

    }

    public void addDoctor(Doctor doctor) throws Exception{

        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_DOCTORES));

        int tamId = prop.keySet().toArray().length;

        doctor.setIdDoctor("DOC"+(tamId+1));

        prop.setProperty(doctor.getIdDoctor(),doctor.getCadena());

        prop.store(new FileOutputStream(PATH_DOCTORES), null);

        System.out.println("Registro Exitoso");

    }

    public void addPaciente(Paciente paciente) throws Exception{

        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_PACIENTES));

        int tamId = prop.keySet().toArray().length;

        paciente.setIdPaciente("PA"+(tamId+1));

        prop.setProperty(paciente.getIdPaciente(),paciente.getCadena());

        prop.store(new FileOutputStream(PATH_PACIENTES), null);

        System.out.println("Registro Exitoso");

    }

    public void addCita(Cita cita)throws Exception{

        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_CITAS));

        int tamId = prop.keySet().toArray().length;

        cita.setIdCita("C"+tamId+1);

        prop.setProperty(cita.getIdCita(), cita.getCadena());

        prop.store(new FileOutputStream(PATH_CITAS), null);

        System.out.println("Cita Creada");


    }

    public void mostrarDoctores()throws Exception{

        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_DOCTORES));

        if(prop.isEmpty()){
            throw new Exception("Archivo vacio -- Registra un Doctor y un Paciente");
        }

        List<String> llaves = new ArrayList<>();
        String values="";

        for (Object object:Arrays.asList(prop.keySet().toArray())){
            llaves.add(object.toString());
        }

        for (String i:llaves) {
            values = values + prop.getProperty(i)+",";
        }

        String[] array = values.split(",");
        int cont=0;
        List<Doctor> doctores = new ArrayList<>();

        for(int i=0;i<array.length;i+=3){

            doctores.add(new Doctor(llaves.get(cont),array[i],array[i+1],array[i+2]));
            cont++;
        }

        for(Doctor doctor:doctores){
            System.out.println(doctor.getIdDoctor()+","+doctor.getCadena());
        }


    }

    public void mostrarPacientes()throws Exception{

        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_PACIENTES));

        if(prop.isEmpty()){
            throw new Exception("Archivo vacio -- Registra un Doctor y un Paciente");
        }

        List<String> llaves = new ArrayList<>();
        String values="";

        for (Object object:Arrays.asList(prop.keySet().toArray())){
            llaves.add(object.toString());
        }

        for (String i:llaves) {
            values = values + prop.getProperty(i)+",";
        }

        String[] array = values.split(",");
        int cont=0;
        List<Paciente> pacientes = new ArrayList<>();

        for(int i=0;i<array.length;i+=3){

            pacientes.add(new Paciente(llaves.get(cont),array[i],array[i+1],array[i+2]));
            cont++;
        }

        for(Paciente paciente:pacientes){
            System.out.println(paciente.getIdPaciente()+","+paciente.getCadena());
        }

    }

    public void mostrarCitas()throws Exception{

        Properties prop = new Properties();
        prop.load(new FileInputStream(PATH_CITAS));

        List<String> llaves = new ArrayList<>();
        String values="";

        if(prop.isEmpty()){
            throw new Exception("Archivo vacio -- Registra una Cita");
        }

        for (Object object:Arrays.asList(prop.keySet().toArray())){
            llaves.add(object.toString());
        }

        for (String i:llaves) {
            values = values + prop.getProperty(i)+",";
        }

        String[] array = values.split(",");
        int cont=0;

        List<Cita> citas = new ArrayList<>();

        for(int i=0;i<array.length;i+=4){

            citas.add(new Cita(llaves.get(cont),array[i],array[i+1],array[i+2],array[i+3]));
            cont++;
        }

        for(Cita cita:citas){
            System.out.println(cita.getIdCita()+","+cita.getCadena());
        }
    }


}
