package com.king.service;



import com.king.model.Spittle;

import java.util.List;

/**
 * Created by jin82 on 2016/06/10.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
