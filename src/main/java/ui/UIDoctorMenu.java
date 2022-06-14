package ui;

import model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    //lista que contiene las citas disponibles aceptadas por el doctor
    public static ArrayList<Doctor> doctorAvailableAppointments =
            new ArrayList<>();

    //mostrara las opciones para el doctor
    public static void showDoctorMenu() throws ParseException {
        int response = 0;
        //mientras la respuesta sea diferente de 0 se seguira ejecutando
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " +
                    UIMain.doctorLogged.getNombre());//trae el nombre del doctor loggeado
            System.out.println("1.Add Available Appointment");
            System.out.println("2.My Schedule Appointments");
            System.out.println("0. Logout");
            //entrada de la respuesta del usuario
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            // logica de respuesta del usuario
            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();//metodo para agregar citas
                    break;
                case 2:
                    break;

                case 0:
                    UIMain.showMenu();//regresa al metodo principal de la app
                    break;
            }
        }while(response != 0);
    }

    private static void showAddAvailableAppointmentsMenu() throws ParseException {
        int response = 0;
        //ciclo que se ejecutara mientras la respuesta sea distinta de 0
        do {
            System.out.println();
            System.out.println(":Add available Appointment");
            System.out.println("Select a Month");
            // de la enum que tenemos imprimimos los primeros 3 meses
            for (int i = 0; i < 3; i++) {
                System.out.println(i+1 + "." + UIMain.MONTHS[i]);
            }
            System.out.println("0.Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());//convierte a int el string que introdujo el usuario
            //si la respuesta esta entre 1 y 3
            if (response > 0 && response < 4){
                int monthSelected = response;//el mes seleccionado es la respuesta
                //imprimimos el mes seleccionado restandole 1 ya que comienza desde 0
                System.out.println(monthSelected + "." + UIMain.MONTHS[monthSelected - 1]);
                System.out.println("Insert the date Available: [dd/mm/yyyy]");
                String date = sc.nextLine();//entrada de fecha por el usuario

                System.out.println("Your date is:" + date + "\n1.Correct" +
                        "\n2.Change Date");//imprime la fecha
                int responseDate = Integer.valueOf(sc.nextLine());//respuesta del usuario sobre la fecha
                if(responseDate == 2) continue;//si quiere cambiar la fecha iniciamos el ciclo nuevamente
                int responseTime = 0;//guarda la respuesta del tiempo
                String time ="";
                //mientras la respuesta sea igual a cambiarTiempo se ejecutara
                do {
                    System.out.println("Insert the time available for date:" +
                            date + " [16:00]");
                    time = sc.nextLine();//se lee el tiempo que el usuario desee
                    System.out.println("Your time is:" +
                            time + "\n1.Correct" + "\n2.Change time");
                    responseTime = Integer.valueOf(sc.nextLine());//guarda la respuesta del tiempo del user
                }while(responseTime == 2);
                //agrega una cita en la lista de citas disponibles
                UIMain.doctorLogged.addAvailableAppointment(date,time);//manda la fecha y la hora
                checkDoctorAvailableAppointments(UIMain.doctorLogged);//verificacion de citas disponibles
            }
            else if(response == 0) showDoctorMenu();//regresa al menu principal de doctor
        }while(response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        //si la lista de citas disponibles del doctor tiene como minimo una cita
        //y no contiene al doctor
        if(doctor.getAvailableAppointments().size() > 0
         && !doctorAvailableAppointments.contains(doctor)){
            doctorAvailableAppointments.add(doctor);//agrega el doctor loggeado que tiene citas disponibles
        }
    }

}
