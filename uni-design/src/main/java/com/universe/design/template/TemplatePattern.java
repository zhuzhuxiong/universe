package com.universe.design.template;

/**
 * 模板模式-template
 * 抽象模板：模板方法：公共方法；抽象方法
 * 具体方法：继承模板，重写抽象方法
 * 客户端：调用模板方法
 */
public class TemplatePattern {
    public static void main(String[] args) {
        SpecificMethod method = new SpecificMethod();
        method.templateMethod();
    }
}
