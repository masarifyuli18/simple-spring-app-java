package com.masarifyuli.springapp;

import com.masarifyuli.springapp.entity.webuser.WebUser;
import com.masarifyuli.springapp.entity.webuser.WebUserRepository;
import com.masarifyuli.springapp.u.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class AfterSpringStart {

    @Autowired
    private WebUserRepository webRepo;

    @Autowired
    private Util u;

    @EventListener(ApplicationReadyEvent.class)
    public void afterAppReady() {
        if (webRepo.findById(1).isEmpty()) {
            u.logger(AfterSpringStart.class).info("save default webUser");
            webRepo.save(
                    new WebUser("masarifyuli", "Masarifyuli",
                            "masarif", "Magelang, Indonesia", WebUser.Gender.MALE
                    )
            );
        }
    }

}
