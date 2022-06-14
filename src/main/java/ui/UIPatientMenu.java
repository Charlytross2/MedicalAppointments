package ui;

import model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() throws ParseException {
        int response = 0;
        //mientras la respuesta sea diferente de 0 se ejecutara
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMain.patientLogged.getNombre());// trae el nombre del paciente loggeado
            System.out.println("1. Book an Appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");
            //recibe la respuesta del usuario
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());//convierte a int la respuesta
            switch (response){
                case 1:
                    showBookAppointmentMenu();//metodo que muestra el menu para reservar cita
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMain.showMenu();//regresa al menu principal de la aplicacion
                    break;
            }
        }while (response != 0);
    }

    private static void showBookAppointmentMenu() throws ParseException {
        int response = 0;
        //mientras la respuesta sea distinta de 0 se seguira ejecutando
        do {
            System.out.println("Book an appointment");
            System.out.println("Select date:");
            // Primer Integer ->Numeracion de la lista de doctores a modo de indice
            //Segundo Integer -> indice de la fecha que seleccione el paciente
            //Doctor -> es el doctor en general con su numeracion y su fecha
            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            //variable que sirve para capturar la lista de doctores
            int k = 0;//
            //recorremos en funcion de las citas que tiene
            for (int i = 0; i < UIDoctorMenu.doctorAvailableAppointments.size(); i++) {
                //capturamos la cita del doctor que contiene citas
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorAvailableAppointments.get(i)
                        .getAvailableAppointments();
                //creacion del map para acceder a los datos que faltan
                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();
                //recorremos las citas disponibles del doctor
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;//aumentamos en 1 e imprimimos la fecha de la cita
                    System.out.println(k + "." + availableAppointments.get(j)
                            .getDate());
                    //insertamos en el map el doctor que tiene citas disponibles
                    doctorAppointment.put(Integer.valueOf(j),
                            UIDoctorMenu.doctorAvailableAppointments.get(i));
                    //insertamos en el arbol principal al doctor y su key
                    doctors.put(Integer.valueOf(k),doctorAppointment);
                }
            }
            //seleccion de respuesta del usuario
            Scanner sc = new Scanner(System.in);
            //captura la respuesta de la fecha seleccionada
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            //tendra el doctor del cual se selecciono la fecha
            Map<Integer,Doctor> doctorAvailableSelected =
                    doctors.get(responseDateSelected);
            Integer indexDate = 0;
            //creacion de un doctor
            Doctor doctorSelected = new Doctor("","");
            //recorremos el doctor de citas seleccionado
            for (Map.Entry<Integer,Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();//le asigna la llave del doctor
                doctorSelected = doc.getValue();// le asigna el valor del
            }
            System.out.println("Nombre:" + doctorSelected.getNombre() +
                    "\nTime:" +
                    doctorSelected.getAvailableAppointments().get(indexDate)
                            .getTime() +
                    "\nDate:" +
                    doctorSelected.getAvailableAppointments().get(indexDate)
                            .getDate());
            System.out.println("Confirm your appointment: \n1.Yes" +
                    "\n2.Change data");
            response = Integer.valueOf(sc.nextLine());
            if(response == 1){
                UIMain.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
                response = 0;
            }
        }while(response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("My appointments");
            if(UIMain.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Dont have appointments");
                break;
            }
            for (int i = 0; i < UIMain.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(
                    j + "." +
                    "Date:" + UIMain.patientLogged.getAppointmentDoctors().get(i).getDate() +
                    "\nTime:" + UIMain.patientLogged.getAppointmentDoctors().get(i).getTime() +
                    "\nDoctor:" + UIMain.patientLogged.getAppointmentDoctors().get(i).getDoctor().getNombre());
            }
            System.out.println("0.Return");
        }while(response != 0);
    }
}
