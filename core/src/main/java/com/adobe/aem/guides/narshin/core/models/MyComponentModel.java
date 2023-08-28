package com.adobe.aem.guides.narshin.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.osgi.service.component.annotations.Reference;
import com.adobe.aem.guides.narshin.core.config.MyComponentConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MyComponentModel {
    private static final Logger logger = LoggerFactory.getLogger(MyComponentModel.class);


    @Reference
    private MyComponentConfig config;


        public String getName () {

        return config.getName();

    }

        public String getMobileNumber () {
    try {
        return config.getMobileNumber();
    } catch (Exception e) {
        logger.info("Error{}",e);
    }

            return null;
        }

}
