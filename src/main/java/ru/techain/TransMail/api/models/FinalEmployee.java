package ru.techain.TransMail.api.models;

public class FinalEmployee {
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String nameProduct;
    private int count;

    public FinalEmployee(String surname, String name, String patronymic, String email, String nameProduct, int count) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.nameProduct = nameProduct;
        this.count = count;
    }

    @Override
    public String toString() {
        return "FinalEmployee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", count=" + count +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
