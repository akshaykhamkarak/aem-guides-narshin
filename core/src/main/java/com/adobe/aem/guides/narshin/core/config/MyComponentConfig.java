package com.adobe.aem.guides.narshin.core.config;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Component(
        service = MyComponentConfig.class,
        property = {
                "name=Default Name",
                "mobileNumber=1234567890"
        }
)
@Designate(ocd = MyComponentConfig.Config.class)
public class MyComponentConfig {

    private static final Logger LOGGER =  LoggerFactory.getLogger(MyComponentConfig.class);
    private String name;
    private String mobileNumber;

    public String getName() {
        LOGGER.info("NAME{}",name);
        return name;
    }

    public String getMobileNumber() {
        LOGGER.info("NUMBER{}",mobileNumber);
        return mobileNumber;
    }

    @ObjectClassDefinition(name = "My Component Configuration")
    public @interface Config {
        @AttributeDefinition(name = "Name", description = "The name")
        String name() default "Default Name";

        @AttributeDefinition(name = "Mobile Number", description = "The mobile number")
        String mobileNumber() default "1234567890";
    }
}

