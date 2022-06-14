package ui;

import model.Doctor;
import model.Patient;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMain {
    //variables estaticas que contendran al paciente y al doctor loggeado
    public  static Doctor doctorLogged;
    public  static Patient patientLogged;
    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"};

    public static void showMenu() throws ParseException {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");
        //creacion del menu
        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");
            //ingreso de datos del usuario
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            // de acuerdo a la respuesta tomara caminos distintos
            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0; // reiniciamos el valor de response
                    authUser(1);//autentifica al usuario
                    break;
                case 2:
                    response = 0;
                    authUser(2);//autentifica al usuario
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);// mientras la respuesta sea diferente de 0 se seguira ejecutando
    }

    public static void showPatientMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void authUser(int userType) throws ParseException {
        //userType = 1 Doctor
        //userType = 2 Patient
        ArrayList<Doctor> doctors = new ArrayList<>();//creacion de lista que contiene a los doctores
        doctors.add(new Doctor("Juan Benitez","juan@gmail.com"));//instanciacion de objetos doctor
        doctors.add(new Doctor("Carlos Martinez","carlos@gmail.com"));
        doctors.add(new Doctor("Martin Ramiro","martin@gmail.com"));

            //lista que contiene a los pacientes
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anahi","anahi@gmail.com"));//instanciacion de objetos Patient
        patients.add(new Patient("Juana","juana@gmail.com"));
        patients.add(new Patient("Carla","carla@gmail.com"));


        boolean emailCorrect = false;//bandera que contiene si el email es valido
        //ciclo que se ejecuta mientras el email sea falso
        do {
            Scanner lector = new Scanner(System.in);
            System.out.println("Insert your email: [a@a.com]");
            String email = lector.nextLine();//lee el email introcido por el usuario
            if(userType == 1){//doctores
                //recorre la lista donde estan los doctores
                for (Doctor doctor : doctors) {
                    //si el email del doctor que esta en la lista es igual al que el usuario introducio
                    if (doctor.getEmail().equals(email)){
                        emailCorrect = true;//el email es valido
                        doctorLogged = doctor;//le asignas el doctor que entro al if al doctor loggeado
                        UIDoctorMenu.showDoctorMenu();//llamada al metodo del menu de doctores
                    }
                }
            }
            else if(userType == 2){//pacientes
                //recorre la lista de pacientes
                for (Patient patient : patients) {
                    //si el email del paciente se encuentra en la lista
                    if(patient.getEmail().equals(email)){
                        emailCorrect = true;//email es valido
                        patientLogged = patient;//asignacion de objeto a paciente loggeado
                        UIPatientMenu.showPatientMenu();//llamada al metodo de menu de paciente
                    }
                }
            }
        }while(!emailCorrect);
    }
}
