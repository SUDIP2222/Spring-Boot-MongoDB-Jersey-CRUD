package com.example.Sentry;

import com.example.Constants.AppConstant;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sudip sarker on 4/8/2017.
 */
public class SentryDBUtils {

    private static MongoOperations mongoOperation;
    private final static Properties properties = new Properties();
    private final static Logger logger = LoggerFactory.getLogger(SentryDBUtils.class);

    public static MongoOperations getMongoOperation() throws Exception {

        if (mongoOperation == null) {
            logger.info("Connecting to db ... Creating mongoOperations first time ");
            MongoClientURI mongoClientURI = new MongoClientURI(getDatabaseURI()+getDatabaseName());
            MongoClient client = new MongoClient(mongoClientURI);
            mongoOperation = new MongoTemplate(client, getDatabaseName());
            logger.info("Connected to db : "+  getDatabaseName());
        }

        return mongoOperation;
    }

    protected static String getDatabaseName() {

        try {
            InputStream inputStream = SentryDBUtils.class.getClassLoader()
                    .getResourceAsStream(AppConstant.PROPERTIES_FILE);
            properties.load(inputStream);

        } catch (IOException e) {

            logger.error("Error:"+e.getMessage());
        }

        return properties.getProperty(AppConstant.PROPERTIES_DB_NAME);
    }

    protected static  String getDatabaseURI() {

        try {
            InputStream inputStream = SentryDBUtils.class.getClassLoader().getResourceAsStream(AppConstant.PROPERTIES_FILE);
            properties.load(inputStream);

        } catch (IOException e) {
            logger.error("Error:"+e.getMessage());
        }

        String dbURI = "mongodb://"+ properties.getProperty(AppConstant.PROPERTIES_DB_IP)      +
                ":" + properties.getProperty(AppConstant.PROPERTIES_DB_PORT)      + "/";

        logger.info(dbURI);

        return dbURI;
    }


}
