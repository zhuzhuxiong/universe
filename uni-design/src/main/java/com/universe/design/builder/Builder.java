package com.universe.design.builder;

import javax.lang.model.element.VariableElement;

/**
 * 建造者模式--抽象建造者
 */
public abstract class Builder {

   Product product =  new Product();

   public abstract void buildPartA();
   public abstract void buildPartB();
   public abstract void buildPartC();

   public Product getProduct(){
        return product;
   }

}
