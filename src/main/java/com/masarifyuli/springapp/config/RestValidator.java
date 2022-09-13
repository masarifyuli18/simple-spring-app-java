package com.masarifyuli.springapp.config;


import com.masarifyuli.springapp.entity.webuser.WebUserValidator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RestValidator implements RepositoryRestConfigurer {

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", new WebUserValidator());
        v.addValidator("beforeSave", new WebUserValidator());
    }
}
