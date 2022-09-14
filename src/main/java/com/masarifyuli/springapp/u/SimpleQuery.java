package com.masarifyuli.springapp.u;

import com.masarifyuli.springapp.entity.vehicle.Vehicle;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class SimpleQuery<T> {

    private Class<T> tClass;
    private EntityManager entityManager;
    String[] select = {"id", "code", "licensePlat", "brand", "description"};

    public SimpleQuery(Class<T> tClass, EntityManager entityManager) {
        this.tClass = tClass;
        this.entityManager = entityManager;
    }

    public ArrayList<HashMap<String, String>> resultListMap() {
        ArrayList<HashMap<String, String>> listMap = new ArrayList<>();
        List<Object[]> query = this.entityManager.createQuery(
                "select id, code, licensePlat, brand, description from Vehicle",
                Object[].class
        ).getResultList();
        for (Object[] result : query) {
            HashMap<String, String> map = new HashMap<String, String>();
            IntStream.range(0, select.length)
                    .forEach(i ->
                            map.put(select[i], result[i].toString())
                    );
            listMap.add(map);
        }
        return listMap;
    }

}
