package model;

public class Nurse extends User{

    private String speciality;

    public Nurse(String nombre, String email) {
        super(nombre, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Azul\nDepartamentos: Criminologia");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
