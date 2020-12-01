import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static TxtHandler txtHandler;
    private static DataText dataText;


    public static void main(String [] args) throws Exception{

        txtHandler = new TxtHandler();
        dataText = new DataText();

        Main main = new Main();

        try {

            dataText.validarCarpeta();
            dataText.validarDoctoresTxt();
            dataText.validarPacientesTxt();
            dataText.validarCitasTxt();
            dataText.validarUsersTxt();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        main.loginCreate();
        main.menuCreate();


    }

    public void loginCreate() throws Exception{

        Usuario login = new Usuario();
        boolean rep = false;

        do {
            System.out.println("Iniciar Sesion\n");
            System.out.println("Ingresa Ususario: ");
            login.setUser(in.readLine().trim());

            System.out.println("Ingresa Password: ");
            login.setPassword(in.readLine().trim());


            if (txtHandler.buscarUser(login)) {

                System.out.println("Bienvenido");
                rep = true;

            } else {

                System.out.println("Credenciales Incorrectas -- INTENTE OTRA VEZ\n");
            }

        }while(!rep);

    }

    public void menuCreate() throws Exception{

        int opcion;
        boolean menu = true;

        do {
            System.out.println("Menú de Opciones\n" +
                    "\n" +
                    "1. Dar de Alta nuevo Doctor\n" +
                    "2. Dar de Alta nuevo Paciente\n" +
                    "3. Crear Cita\n" +
                    "4. Ver Agenda de Citas\n" +
                    "5. Salir\n" +
                    "\n" +
                    "Opcion: ");

            opcion = Integer.parseInt(in.readLine());

            switch (opcion) {

                case 1:
                    addDoctorMenu();
                    System.out.println("-presiona enter para continuar-");
                    in.readLine();
                    break;
                case 2:
                    addPacienteMenu();
                    System.out.println("-presiona enter para continuar-");
                    in.readLine();
                    break;
                case 3:
                    addCitaMenu();
                    System.out.println("-presiona enter para continuar-");
                    in.readLine();
                    break;
                case 4:
                    mostarAgendaMenu();
                    System.out.println("-presiona enter para continuar-");
                    in.readLine();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida -- Intenta otra vez");
                    System.out.println("-presiona enter para continuar-");
                    in.readLine();
                    break;

            }

        }while (menu);


    }

    public void addDoctorMenu() throws Exception{

        Doctor doctor = new Doctor();

        System.out.println("Dar de Alta ---- Doctor\n");
        System.out.println("Ingresa el Nombre: ");
        doctor.setNombre(in.readLine());
        System.out.println("Ingresa la Especialidad: ");
        doctor.setEspecialidad(in.readLine());
        System.out.println("Ingresa el Telefono: ");
        doctor.setTelefono(in.readLine());

        txtHandler.addDoctor(doctor);

    }

    public void addPacienteMenu()throws Exception{

        Paciente paciente = new Paciente();

        System.out.println("Dar de Alta ---- Paciente\n");
        System.out.println("Ingresa el Nombre: ");
        paciente.setNombre(in.readLine());
        System.out.println("Ingresa la Email: ");
        paciente.setEmail(in.readLine());
        System.out.println("Ingresa el Telefono: ");
        paciente.setTelefono(in.readLine());

        txtHandler.addPaciente(paciente);

    }

    public void addCitaMenu()throws Exception{

        Cita cita = new Cita();
        try {
            System.out.println("Crear Cita\n");
            System.out.println("Doctores Disponibles: ");
            txtHandler.mostrarDoctores();

            System.out.println("\nIngresa el Nombre de un Doctor: ");
            cita.setDoctor(in.readLine());

            System.out.println("\nPacientes Registrados: ");
            txtHandler.mostrarPacientes();

            System.out.println("\nIngresa el nombre de un paciente: ");
            cita.setPaciente(in.readLine());

            System.out.println("Ingresa la Fecha de la Cita (Formato día/mes/año): ");
            cita.setFecha(in.readLine());

            System.out.println("Ingresa Hora de la cita (Formato 12hrs)(06:00): ");
            cita.setHora(in.readLine());

            txtHandler.addCita(cita);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void mostarAgendaMenu(){

        System.out.println("Agenda --- Historial\n");

        try {
            txtHandler.mostrarCitas();
            System.out.println();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
