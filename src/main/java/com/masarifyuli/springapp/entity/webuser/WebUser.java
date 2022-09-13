package com.masarifyuli.springapp.entity.webuser;

import com.masarifyuli.springapp.u.ConverterEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "webUser")
public class WebUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    @Column(nullable = false, length = 15)
    private String username;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false, length = 255)
    private String address;
    @Column(nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender = Gender.MALE;

    @Column(length = 30)
    private String email;
    @Column(length = 20)
    private String mobileNo;

    public enum Gender { MALE, FEMALE, UNDEFINED }

    public WebUser() {
    }

    public WebUser(String username, String name, String password, String address, Gender gender) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}

@Converter
class GenderConverter extends ConverterEnum<WebUser.Gender> implements AttributeConverter<WebUser.Gender, String> {
    public GenderConverter() {
        super(WebUser.Gender.class);
    }
}

