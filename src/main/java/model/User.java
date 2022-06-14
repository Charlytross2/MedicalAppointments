package model;

public abstract class User {

    private int id;
    private String name;
    private String email;
    private String adress;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() > 8){
            System.out.println("El numero de telefono debe de ser de 8 digitos");
        } else if(phoneNumber.length() == 8){
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "model.User:" + name + ", Email:" + email + "\nAdress:" + adress +
                ".Phone:" + phoneNumber;
    }

    public abstract void showDataUser();
}
