package com.alibaba.ls.dao.mapper.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author LvSheng
 * @date 2021/12/5
 **/
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
    RowBounds.class, ResultHandler.class}))
public class MyInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Method   method = invocation.getMethod();
        Object[] args   = invocation.getArgs();
        Object   target = invocation.getTarget();
        Object   result = invocation.proceed();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
