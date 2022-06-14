package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //Atributos de la clase model.Doctor
    private String speciality;
    private ArrayList<Doctor.AvailableAppointment> availableAppointments = new ArrayList<>();

    //constructor sobrecargado
    public Doctor(String name, String email) {
        super(name,email);
    }

    //metodos get y set de los atributos de la clase
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //creacion de una lista que almacena objetos de tipo availableAppointment

    //agrega los objetos de tipo doctor.AvailableAppointment que tengan fecha y hora
    public void addAvailableAppointment(String date,String time) throws ParseException {
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }
    //regresa la lista que contiene las citas
    public ArrayList<Doctor.AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality:" + speciality +
                "\nAvailable:" + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
    }

    //creacion de clase estatica anidada
    public static class AvailableAppointment{
        //atributos de la clase anidada
        private int idAvaiableAppointment;
        private Date date;
        private String time;
        private SimpleDateFormat format =
                new SimpleDateFormat("dd/MM/yyyy");
        //constructor de la clase anidad
        public AvailableAppointment(String date, String time) throws ParseException {
            this.date = format.parse(date);//   parsea el string a date y le da formato
            this.time = time;
        }
        //setters y getters de los atributos
        public int getIdAvaiableAppointment() {
            return idAvaiableAppointment;
        }

        public void setIdAvaiableAppointment(int idAvaiableAppointment) {
            this.idAvaiableAppointment = idAvaiableAppointment;
        }
        //metodo getDate recargado
        public Date getDate(String DATE) {
            return date;
        }
        public String getDate(){
            return format.format(date);//le aplica el formato a la fecha
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \nDate:" + getDate() + "\nTime:" + getTime();
        }
    }
}
