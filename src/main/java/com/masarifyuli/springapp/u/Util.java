package com.masarifyuli.springapp.u;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class Util {
    public Logger logger(Class cls) {
        return LoggerFactory.getLogger(cls);
    }

    public String randomCode(String key) {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return (key + "-" + uuid).toUpperCase();
    }

}

