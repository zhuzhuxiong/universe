package com.universe.mybatis.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * mybatis-plus 自动代码生成
 *
 * @author lx
 */
public class MpGenerator {

    private static final String URL = "jdbc:mariadb://42.193.124.125:3306/test";

    private static final String USERNAME = "username";

    private static final String PASSWORD = "password";


    public static void main(String[] args) {
        fastGenerator();
//        MutualGenerator();
    }

    /**
     * mp 快速生成
     */
    public static void fastGenerator() {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                //全局配置 作者、使用swagger、开启文件覆盖、文件输出位置
                .globalConfig(builder -> {
                    builder.author("dianxiaoer")
                            .enableSwagger()
                            .fileOverride()
                            .outputDir("/Users/hongqi/private/universe/uni-mybatis/src/main/java/");
                })
                //包配置 父包名
                .packageConfig(builder -> {
                    builder.parent("com.universe.mybatis")
                            //1、requestmapping（路径）2、在parent下会新建一个文件以此为名的文件夹
//                            .moduleName("universe")
                            //xml生成位置
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/hongqi/private/universe/uni-mybatis/src/main/resources/mapper"));
                })
                //策略配置
                .strategyConfig(builder -> {
                    //添加过滤-按表名
//                    builder.addExclude("user");
                    //添加过滤-按表名前缀
//                    builder.addTablePrefix("config_");
                    //只生成单个表
                    builder.addInclude("user");
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板（使用默认引擎需要加依赖）
//                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    //交互生成
    public static void MutualGenerator() {
        FastAutoGenerator.create(new DataSourceConfig
                        .Builder("jdbc:mariadb://42.193.124.125:3306/test", "username", "password"))
                .globalConfig((scanner, builder) -> {
                    builder.author(scanner.apply("作者："))
                            .outputDir("/Users/hongqi/private/universe/mybatis/src/main/java/")
                            .fileOverride();
                })
                .packageConfig((scanner, builder) -> {
                    builder.parent(scanner.apply("包名："));
                })
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(getTables(scanner.apply("表名（,分格）or all")))
                            .controllerBuilder().enableRestStyle().enableHyphenStyle()
                            .entityBuilder().enableLombok().addTableFills(
                                    new Column("create_time", FieldFill.INSERT)
                            )
                            .build();
                })
                .execute();
    }

    public static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
