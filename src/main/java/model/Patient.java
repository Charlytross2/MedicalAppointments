package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{

    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private  ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public Patient(String name,String email){
        super(name,email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge:" + birthday +
                "\nWeight:" + getWeight() +
                "\nHeight:" + getHeight() + "\nBlood:" + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente del Hospital: Cruz Roja\nHistorial del paciente");
    }
}
