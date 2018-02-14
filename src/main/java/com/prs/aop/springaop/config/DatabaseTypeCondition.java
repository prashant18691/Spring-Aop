package com.prs.aop.springaop.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class DatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String,Object> m =  annotatedTypeMetadata.getAnnotationAttributes(DatabaseType.class.getName());
        String dbType = (String)m.get("value");
        String enableddbType = conditionContext.getEnvironment().getProperty("dbType");
        return enableddbType!=null && dbType!=null && enableddbType.equalsIgnoreCase(dbType);
    }
}
