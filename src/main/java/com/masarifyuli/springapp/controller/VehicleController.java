package com.masarifyuli.springapp.controller;

import com.masarifyuli.springapp.entity.vehicle.Vehicle;
import com.masarifyuli.springapp.u.SimpleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@RestController
public class VehicleController {

    @Autowired
    private EntityManager em;

    @GetMapping("vehicles/search/findWithFilter")
    public ResponseEntity<ArrayList> findWithFilter() {
//        ArrayList<HashMap<String, String>> listMap = new ArrayList<>();
//        String[] select = {"id", "code", "licensePlat", "brand", "description"};
//        List<Object[]> query = em.createQuery(
//                "select id, code, licensePlat, brand, description from Vehicle",
//                Object[].class
//        ).getResultList();
//        for (Object[] result : query) {
//            HashMap<String, String> map = new HashMap<String, String>();
//            IntStream.range(0, select.length)
//                    .forEach(i ->
//                            map.put(select[i], result[i].toString())
//                    );
//            listMap.add(map);
//        }

        SimpleQuery si = new SimpleQuery(Vehicle.class, em);
        ArrayList listMap = si.resultListMap();

        return ResponseEntity.ok(listMap);
    }

}
