package com.king.service.impl;

import com.king.model.Spittle;
import com.king.service.SpittleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jin82 on 2016/06/10.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle(new Date(),"Spittle "+i));
        }
        return spittles;
    }
}
