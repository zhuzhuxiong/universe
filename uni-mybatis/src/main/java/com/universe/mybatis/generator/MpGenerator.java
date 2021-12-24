package com.universe.mybatis.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * mybatis-plus 自动代码生成
 * @author
 */
public class MpGenerator {

    public static void main(String[] args) {
//        fastGenerator();
        MutualGenerator();
    }

    //快速生成
    public static void fastGenerator(){
        FastAutoGenerator.create("jdbc:mariadb://42.193.124.125:3306/test","username","password")
                .globalConfig(builder -> {
                    builder.author("dianxiaoer")
                            .enableSwagger()
                            .fileOverride()
                            .outputDir("/Users/hongqi/private/universe/mybatis/src/main/java/");//文件生成位置
                })
                .packageConfig(builder -> {
                    builder.parent("com.universe.mybatis")
//                            .moduleName("universe")//1、requestmapping（路径）2、在parent下会新建一个文件以此为名的文件夹
                            //xml生成位置
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/hongqi/private/universe/mybatis/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addExclude("user");//排除此表
//                            .addTablePrefix();
                })
//                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    //交互生成
    public static void MutualGenerator(){
        FastAutoGenerator.create(new DataSourceConfig
                        .Builder("jdbc:mariadb://42.193.124.125:3306/test","username","password"))
                .globalConfig((scanner,builder) -> {
                    builder.author(scanner.apply("作者："))
                            .outputDir("/Users/hongqi/private/universe/mybatis/src/main/java/")
                            .fileOverride();
                })
                .packageConfig((scanner,builder) -> {
                    builder.parent(scanner.apply("包名："));
                })
                .strategyConfig((scanner,builder) ->{
                    builder.addInclude(getTables(scanner.apply("表名（,分格）or all")))
                            .controllerBuilder().enableRestStyle().enableHyphenStyle()
                            .entityBuilder().enableLombok().addTableFills(
                                    new Column("create_time", FieldFill.INSERT)
                            )
                            .build();
                })
                .execute();
    }
    public static List<String> getTables(String tables){
      return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
