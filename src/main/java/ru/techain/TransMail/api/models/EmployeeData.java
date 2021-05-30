package ru.techain.TransMail.api.models;


import com.opencsv.bean.CsvBindByName;


public class EmployeeData {
    @CsvBindByName(column = "id")
    private String id;

    @CsvBindByName(column = "userName")
    private String userName;

    @CsvBindByName(column = "userFirstName")
    private String userFirstName;

    @CsvBindByName(column = "userLastName")
    private String userLastName;


    @CsvBindByName(column = "userMiddleName")
    private String userMiddleName;

    @CsvBindByName(column = "userDepartment")
    private String userDepartment;

    @CsvBindByName(column = "userCrocCode")
    private String userCrocCode;

    @CsvBindByName(column = "sex")
    private String sex;

    @CsvBindByName(column = "adminLevel")
    private String adminLevel;

    @CsvBindByName(column = "availableBalance")
    private String availableBalance;

    @CsvBindByName(column = "earnedBalance")
    private String earnedBalance;

    @CsvBindByName(column = "location")
    private String location;

    @CsvBindByName(column = "isRegion")
    private String isRegion;

    @CsvBindByName(column = "isArchive")
    private String isArchive;

    @CsvBindByName(column = "updatedDate")
    private String updatedDate;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "oneTimeGoodsBoughtIds")
    private String oneTimeGoodsBoughtIds;

    @CsvBindByName(column = "isSpecialGoodAdmin")
    private String isSpecialGoodAdmin;

    @Override
    public String toString() {
        return "EmployeeOrder{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", userDepartment='" + userDepartment + '\'' +
                ", userCrocCode='" + userCrocCode + '\'' +
                ", sex='" + sex + '\'' +
                ", adminLevel='" + adminLevel + '\'' +
                ", availableBalance='" + availableBalance + '\'' +
                ", earnedBalance='" + earnedBalance + '\'' +
                ", location='" + location + '\'' +
                ", isRegion='" + isRegion + '\'' +
                ", isArchive='" + isArchive + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", email='" + email + '\'' +
                ", oneTimeGoodsBoughtIds='" + oneTimeGoodsBoughtIds + '\'' +
                ", isSpecialGoodAdmin='" + isSpecialGoodAdmin + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public void setUserCrocCode(String userCrocCode) {
        this.userCrocCode = userCrocCode;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setEarnedBalance(String earnedBalance) {
        this.earnedBalance = earnedBalance;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIsRegion(String isRegion) {
        this.isRegion = isRegion;
    }

    public void setIsArchive(String isArchive) {
        this.isArchive = isArchive;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOneTimeGoodsBoughtIds(String oneTimeGoodsBoughtIds) {
        this.oneTimeGoodsBoughtIds = oneTimeGoodsBoughtIds;
    }

    public void setIsSpecialGoodAdmin(String isSpecialGoodAdmin) {
        this.isSpecialGoodAdmin = isSpecialGoodAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public String getUserCrocCode() {
        return userCrocCode;
    }

    public String getSex() {
        return sex;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public String getEarnedBalance() {
        return earnedBalance;
    }

    public String getLocation() {
        return location;
    }

    public String getIsRegion() {
        return isRegion;
    }

    public String getIsArchive() {
        return isArchive;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getEmail() {
        return email;
    }

    public String getOneTimeGoodsBoughtIds() {
        return oneTimeGoodsBoughtIds;
    }

    public String getIsSpecialGoodAdmin() {
        return isSpecialGoodAdmin;
    }

    public String getName() {
        return name;
    }

    @CsvBindByName
    private String name;



}
