package com.masarifyuli.springapp.entity.webuser;

import com.masarifyuli.springapp.exception.MaxLengthValidation;
import com.masarifyuli.springapp.exception.RequiredValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WebUserValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return WebUser.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors err) {
        WebUser web = (WebUser) o;
        new RequiredValidation("username", web.getUsername());
        new RequiredValidation("name", web.getName());
        new RequiredValidation("address", web.getAddress());
        new RequiredValidation("password", web.getPassword());

        new MaxLengthValidation("username", web.getUsername(), 15);
        new MaxLengthValidation("name", web.getName(), 30);
        new MaxLengthValidation("address", web.getAddress(), 255);
    }

}
