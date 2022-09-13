package com.masarifyuli.springapp;

import com.masarifyuli.springapp.u.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {
        Util u = new Util();
        u.logger(SpringappApplication.class).info("Running Spring Application --- Masarifyuli");
        SpringApplication.run(SpringappApplication.class, args);
    }

}
