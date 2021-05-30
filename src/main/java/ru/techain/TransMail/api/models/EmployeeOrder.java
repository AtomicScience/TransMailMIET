package ru.techain.TransMail.api.models;
import com.opencsv.bean.CsvBindByPosition;

public class EmployeeOrder {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String nameProduct;
    @CsvBindByPosition(position = 2)
    private String categoryProduct;

    @CsvBindByPosition(position = 3)
    private String Department;


    @CsvBindByPosition(position = 4)
    private String deliveryDate;

    @CsvBindByPosition(position = 5)
    private String count;

    @CsvBindByPosition(position = 6)
    private String address;

    @CsvBindByPosition(position = 7)
    private String phoneNumber;

    @CsvBindByPosition(position = 8)
    private String additionalInformation;
    @CsvBindByPosition(position = 9)
    private String recipient;

    @CsvBindByPosition(position = 10)
    private String specialLot;

    @CsvBindByPosition(position = 11)
    private String categorySpecialLot;
    @CsvBindByPosition(position = 12)
    private String userCrocCode;

    @CsvBindByPosition(position = 13)
    private String price;

    @CsvBindByPosition(position = 14)
    private String sum;

    @CsvBindByPosition(position = 15)
    private String date;

    @CsvBindByPosition(position = 16)
    private String status;

    @CsvBindByPosition(position = 17)
    private String typeDate;

    @CsvBindByPosition(position = 18)
    private String login;

    @CsvBindByPosition(position = 19)
    private String surname;

    @CsvBindByPosition(position = 20)
    private String name;

    @CsvBindByPosition(position = 21)
    private String patronymic;

    @CsvBindByPosition(position = 22)
    private String location;

/*
    @CsvBindByName(column = "id")
    private String id;
    @CsvBindByName(column = "Наименование товара")
    private String nameProduct;
    @CsvBindByName(column = "Категория товара")
    private String categoryProduct;

    @CsvBindByName(column = "Департамент")
    private String Department;


    @CsvBindByName(column = "Дата доставки")
    private String deliveryDate;

    @CsvBindByName(column = "Тип доставки")
    private String typeDate;

    @CsvBindByName(column = "Адрес")
    private String address;

    @CsvBindByName(column = "Номер телефона")
    private String phoneNumber;

    @CsvBindByName(column = "Дополнительная инфорация")
    private String additionalInformation;
    @CsvBindByName(column = "Получатель")
    private String recipient;

    @CsvBindByName(column = "Спец. лот")
    private String specialLot;

    @CsvBindByName(column = "Категория спец. лота")
    private String categorySpecialLot;
    @CsvBindByName(column = "Количество")
    private String count;

    @CsvBindByName(column = "Цена")
    private String price;

    @CsvBindByName(column = "Сумма")
    private String sum;

    @CsvBindByName(column = "Дата покупки")
    private String date;

    @CsvBindByName(column = "Статус")
    private String status;

    @CsvBindByName(column = "КрокКод пользователя")
    private String userCrocCode;

    @CsvBindByName(column = "Логин")
    private String login;

    @CsvBindByName(column = "Фамилия")
    private String surname;

    @CsvBindByName(column = "Имя")
    private String name;

    @CsvBindByName(column = "Отчество")
    private String patronymic;

    @CsvBindByName(column = "Location")
    private String location;
*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getSpecialLot() {
        return specialLot;
    }

    public void setSpecialLot(String specialLot) {
        this.specialLot = specialLot;
    }

    public String getCategorySpecialLot() {
        return categorySpecialLot;
    }

    public void setCategorySpecialLot(String categorySpecialLot) {
        this.categorySpecialLot = categorySpecialLot;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserCrocCode() {
        return userCrocCode;
    }

    public void setUserCrocCode(String userCrocCode) {
        this.userCrocCode = userCrocCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTypeDate() {
        return typeDate;
    }

    public void setTypeDate(String typeDate) {
        this.typeDate = typeDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }


    @Override
    public String toString() {
        return "EmployeeOrder{" +
                "id='" + id + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", categoryProduct='" + categoryProduct + '\'' +
                ", specialLot='" + specialLot + '\'' +
                ", categorySpecialLot='" + categorySpecialLot + '\'' +
                ", count='" + count + '\'' +
                ", price='" + price + '\'' +
                ", sum='" + sum + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", userCrocCode='" + userCrocCode + '\'' +
                ", login='" + login + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", location='" + location + '\'' +
                ", Department='" + Department + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", typeDate='" + typeDate + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }

}
