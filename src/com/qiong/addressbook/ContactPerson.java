package com.qiong.addressbook;

public class ContactPerson {
    private int id;
    private String name;
    private String age;
    private String sex;
    private String telNum;
    private String address;

    public ContactPerson(String name, String age, String sex, String telNum, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNum = telNum;
        this.address = address;
    }

    public ContactPerson() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ContactPerson: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", telNum='" + telNum + '\'' +
                ", address='" + address + '\'';
    }
}
