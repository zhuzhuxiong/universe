package com.universe.design;

/**
 * 原型模式
 */
public class PrototypeModel implements Cloneable{

    public PrototypeModel(){
        System.out.println("具体原型创建成功！");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (PrototypeModel)super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeModel model = new PrototypeModel();
        PrototypeModel model1 = (PrototypeModel)model.clone();
        System.out.println(model == model1);
    }
}
