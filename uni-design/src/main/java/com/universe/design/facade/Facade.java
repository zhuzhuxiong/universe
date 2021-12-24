package com.universe.design.facade;

import com.sun.xml.internal.fastinfoset.util.ValueArray;

/**
 * 门面接口
 */
public class Facade {

    private SubFacade1 facade1 = new SubFacade1();
    private SubFacade2 facade2 = new SubFacade2();

    public void method(){
        facade1.subMethod1();
        facade2.subMethod2();
    }

}
