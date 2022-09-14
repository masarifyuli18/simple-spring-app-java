package com.masarifyuli.springapp.entity.vehicle;

import com.masarifyuli.springapp.exception.MaxLengthValidation;
import com.masarifyuli.springapp.exception.RequiredValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VehicleValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Vehicle.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors err) {
        Vehicle web = (Vehicle) o;
        new RequiredValidation("code", web.getLicensePlat());
        new RequiredValidation("brand", web.getBrand());

        new MaxLengthValidation("code", web.getLicensePlat(), 10);
        new MaxLengthValidation("brand", web.getBrand(), 50);

        if (!web.getDescription().isBlank()) {
            new MaxLengthValidation("brand", web.getBrand(), 255);
        }

    }

}
