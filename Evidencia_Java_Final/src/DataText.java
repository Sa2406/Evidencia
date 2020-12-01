import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class DataText {

    private static final String PATH_DOCTORES = ".\\DataBase\\doctores.txt";
    private static final String PATH_PACIENTES = ".\\DataBase\\pacientes.txt";
    private static final String PATH_CITAS = ".\\DataBase\\citas.txt";
    private static final String PATH_USERS = ".\\DataBase\\usuarios.txt";

    private Properties wr;


    public DataText(){

        wr = new Properties();

    }

    //Valida Carpeta DataBase
    public void validarCarpeta() {

        File file = new File(".\\DataBase");

        if(!file.exists()){
            file.mkdir();
        }


    }

    //Valida Txt Usuarios
    public void validarUsersTxt() throws Exception{

        File file = new File(PATH_USERS);


        if(!file.exists()){
            file.createNewFile();
            wr.load(new FileInputStream(file));
            wr.setProperty("admin", "123456");
            wr.store(new FileOutputStream(file), null);

        }


    }

    //Valida txt Doctores
    public void validarDoctoresTxt() throws Exception{

        File file = new File(PATH_DOCTORES);


        if(!file.exists()){
            file.createNewFile();

        }


    }

    //Valida txt Pacientes
    public void validarPacientesTxt() throws Exception{

        File file = new File(PATH_PACIENTES);

        if(!file.exists()){
            file.createNewFile();
        }
    }

    //Valida Citas
    public void validarCitasTxt() throws Exception{

        File file = new File(PATH_CITAS);

        if(!file.exists()){
            file.createNewFile();
        }

    }


}
