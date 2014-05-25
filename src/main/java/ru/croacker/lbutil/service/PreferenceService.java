package ru.croacker.lbutil.service;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: croacker
 * Date: 25.05.14
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class PreferenceService {

    private static PreferenceService instance;
    private static final String FILE_NAME = "config.xml";
    private static final String ROOT_ELEMENT = "root-xml-configuration";

    public static PreferenceService getInstance(){
        if(instance == null){
            instance = new PreferenceService();
        }
        return instance;
    }

    private AbstractConfiguration configuration;

    private AbstractConfiguration getConfiguration(){
        if(configuration == null){
            configuration = new XMLConfiguration();
            ((XMLConfiguration)configuration).setEncoding("UTF-8");
            ((XMLConfiguration)configuration).setFileName(FILE_NAME);
            ((XMLConfiguration)configuration).setRootElementName(ROOT_ELEMENT);
        }
        return configuration;
    }

    public Properties getConnectionsNames(){
        return getConfiguration().getProperties("connections");
    }

}
