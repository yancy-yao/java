package com.yancy.reflect.proxydemo;

/**
 * Created by yancy on 2017/11/1.
 */
public class XiMenQing {

    public static void main(String[] args) {
        //demo 1
        Wangpo wangpo = new Wangpo();

        wangpo.makeEyesWithMan();
        wangpo.happyWithMan();

        //demo2
        JiaShi jiashi = new JiaShi();
        Wangpo wangpo1 = new Wangpo(jiashi);
        wangpo1.happyWithMan();
        wangpo1.makeEyesWithMan();
    }
}
