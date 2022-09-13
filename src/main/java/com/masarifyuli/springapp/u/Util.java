package com.masarifyuli.springapp.u;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class Util {

    public Logger logger(Class cls) {
        return LoggerFactory.getLogger(cls);
    }

}

