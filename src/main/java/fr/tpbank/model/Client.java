package fr.tpbank.model;

public class Client {
    private String id_client;
    private String name;
    private String surname;
    private String email;
    private String password;

    public Client(String id_client, String name, String surname, String email, String password) {
        this.id_client = id_client;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client
                + ", name=" + name
                + ", surname=" + surname
                + ", email=" + email
                + ", password=" + password + '}';
    }


}
