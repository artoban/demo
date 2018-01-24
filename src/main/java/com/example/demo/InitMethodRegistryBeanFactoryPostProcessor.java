package com.example.demo;

import com.example.mypackage.Invoker;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 24/01/18.
 */
@Component
public class InitMethodRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Map<String,Object> beans = new HashMap<>();

    private String className;

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();

        for(String name : names) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if(beanClassName == null) { continue; }
            Class<?> beanClass = ClassUtils.resolveClassName(beanClassName, ClassLoader.getSystemClassLoader());

           /* Class<?> [] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(beanClass);
            for(Class<?> ifc : allInterfacesForClass) {
                Method[] methods = ifc.getMethods();
                for(Method method : methods) {
                    if(method.isAnnotationPresent(PostConstruct.class)) {
                        beanDefinition.setInitMethodName(method.getName());
                        beanDefinition.
                    }
                }
            }*/


            if(beanClass.isAnnotationPresent(Invoker.class) ) {
                System.out.println(beanClass.getCanonicalName());

                AbstractBeanDefinition def = new GenericBeanDefinition();
                def.setBeanClass(StringBuilder.class);

                ConstructorArgumentValues args = new ConstructorArgumentValues();

                args.addGenericArgumentValue("com.example.mypackage.Communicator");

                beanDefinition.setConstructorArgumentValues(args);

                GenericApplicationContext ctx = new GenericApplicationContext();

                ctx.registerBeanDefinition(beanClass.getCanonicalName(), def);

                continue;
            }
        }

    }

    public Map<String, Object> getBeans() {
        return beans;
    }
}
