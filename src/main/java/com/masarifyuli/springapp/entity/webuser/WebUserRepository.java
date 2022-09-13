package com.masarifyuli.springapp.entity.webuser;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WebUserRepository extends CrudRepository<WebUser, Integer> {
    @Override
    public List<WebUser> findAll();

    public WebUser findByUsername(String username);
}
