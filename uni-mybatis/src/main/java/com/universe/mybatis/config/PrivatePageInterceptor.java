//package com.universe.mybatis.config;
//
//import org.apache.ibatis.cache.CacheKey;
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//
///**
// * @author
// */
//@Intercepts({
//        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
//        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
//})
//public class PrivatePageInterceptor implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        System.out.println("start");
//
//        Object[] args = invocation.getArgs();
//        MappedStatement mappedStatement = (MappedStatement)args[0];
//
//        Object arg = args[1];
//
//        BoundSql boundSql = mappedStatement.getBoundSql(arg);
//
//        RowBounds rowBounds = (RowBounds)args[2];
//
//        String sql = boundSql.getSql();
//
//        String s = sql + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
//
//        BoundSql pageSql = new BoundSql(mappedStatement.getConfiguration(), s, boundSql.getParameterMappings(), arg);
//
//        Executor executor = (Executor)invocation.getTarget();
//
//        CacheKey cacheKey = executor.createCacheKey(mappedStatement, arg, rowBounds, pageSql);
//        return executor.query(mappedStatement, arg, rowBounds, (ResultHandler) args[3], cacheKey, pageSql);
//    }
//}
