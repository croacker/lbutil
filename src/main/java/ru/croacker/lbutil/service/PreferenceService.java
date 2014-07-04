package ru.croacker.lbutil.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import ru.croacker.lbutil.dto.ConnectionDto;

import java.io.File;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: croacker
 * Date: 25.05.14
 * Time: 15:42
 *
 */
@Slf4j
public class PreferenceService {

    private static PreferenceService instance;

    private static final String ENCODING = "UTF-8";
    private static final String FILE_NAME = "../conf/config.xml";
    private static final String ROOT_ELEMENT = "lbutil-xml-configuration";

    public static PreferenceService getInstance(){
        if(instance == null){
            instance = new PreferenceService();
        }
        return instance;
    }

    private AbstractConfiguration configuration;

    private AbstractConfiguration getConfiguration(){
        if(configuration == null){
            try {
                configuration = new XMLConfiguration(getFile());
                ((XMLConfiguration)configuration).setEncoding(ENCODING);
                ((XMLConfiguration)configuration).setRootElementName(ROOT_ELEMENT);
            } catch (ConfigurationException e) {
                log.error(e.getMessage(), e);
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return configuration;
    }

    private File getFile(){
        File file = new File(FILE_NAME);
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return file;
    }

    public Properties getConnectionsNames(){
        return getConfiguration().getProperties("connections");
    }

    public void addConnection(ConnectionDto connectionDto){

    }

}
