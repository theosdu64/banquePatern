package fr.tpbank.model;

public class Client {
    private Integer client_id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public Client(Integer client_id, String name, String surname, String email, String password) {
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Integer getId_client() {
        return client_id;
    }

    public void setId_client(Integer id_client) {
        this.client_id = id_client;
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
        return "Client{" + "id_client=" + client_id
                + ", name=" + name
                + ", surname=" + surname
                + ", email=" + email
                + ", password=" + password + '}';
    }


}
