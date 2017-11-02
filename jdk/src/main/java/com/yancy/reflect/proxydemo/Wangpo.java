package com.yancy.reflect.proxydemo;

/**
 * Created by yancy on 2017/11/1.
 */
public class Wangpo implements KindWomen{

    private KindWomen kindWomen;

    public Wangpo() {
        this.kindWomen = new PanJinLian();
    }

    public Wangpo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWithMan() {
        this.kindWomen.makeEyesWithMan();
    }

    @Override
    public void happyWithMan() {
        this.kindWomen.happyWithMan();
    }
}
