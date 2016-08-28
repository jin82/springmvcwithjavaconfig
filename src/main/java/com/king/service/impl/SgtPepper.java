package com.king.service.impl;

import com.king.service.CompactDisc;
import org.springframework.stereotype.Component;


/**
 * Created by jin82 on 2016/06/10.
 */
@Component
public class SgtPepper implements CompactDisc {
    private String title = "拉拉阿拉";
    private String artist = "周杰伦";
    public void play() {
        System.out.println("正在播放"+title+",歌手"+artist+"。");
    }
}
