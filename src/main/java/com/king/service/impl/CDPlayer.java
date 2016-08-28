package com.king.service.impl;

import com.king.service.CompactDisc;
import com.king.service.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by jin82 on 2016/06/10.
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
