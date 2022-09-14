package com.masarifyuli.springapp.entity.vehicle;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    @Override
    public List<Vehicle> findAll();

    public Vehicle findByCode(String code);
}
