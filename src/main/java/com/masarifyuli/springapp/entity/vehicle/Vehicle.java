package com.masarifyuli.springapp.entity.vehicle;

import com.masarifyuli.springapp.entity.webuser.WebUser;
import com.masarifyuli.springapp.u.ConverterEnum;
import com.masarifyuli.springapp.u.Util;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;

    @Column(nullable = false, length = 12)
    private String code = new Util().randomCode("VE");

    @Column(nullable = false, length = 10)
    private String licensePlat;
    @Column(nullable = false, length = 50)
    private String brand;
    @Column(nullable = false)
    @Convert(converter = TypeVehicleConverter.class)
    private TypeVehicle type;
    @Column(length = 255)
    private String description;

    @ManyToOne(targetEntity = WebUser.class)
    @JoinColumn(referencedColumnName = "code", nullable = false, foreignKey = @ForeignKey(name = "FKVehicleWebUser"))
    private WebUser owner;

    public enum TypeVehicle { MOTORCYCLE, CAR, BICYCLE, UNDEFINED }

    public Vehicle() {
    }

    public Vehicle(String code, String brand, TypeVehicle type) {
        this.code = code;
        this.brand = brand;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getLicensePlat() {
        return licensePlat;
    }

    public void setLicensePlat(String licensePlat) {
        this.licensePlat = licensePlat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public TypeVehicle getType() {
        return type;
    }

    public void setType(TypeVehicle type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WebUser getOwner() {
        return owner;
    }

    public void setOwner(WebUser owner) {
        this.owner = owner;
    }
}

@Converter
class TypeVehicleConverter extends ConverterEnum<Vehicle.TypeVehicle> implements AttributeConverter<Vehicle.TypeVehicle, String> {
    public TypeVehicleConverter() {
        super(Vehicle.TypeVehicle.class);
    }
}

