package com.github.rayniel95.velocitest.awsappsync.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.StringWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.github.rayniel95.velocitest.awsappsync.util.*;


/**
 * Unit test for simple App.
 */
public class UtilTest 
{
    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void flattenSqlStatementResult()
    {
        // log.log(Level.INFO, "I'm starting");
        try {
            String result = runTemplate(
                "src/obtenersesion/flattensqlstatement/flattenSqlStatementResult.vt", 
                "src/obtenersesion/flattensqlstatement/context.json"
            );
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String runTemplate(String templatePath, String contextPath) throws Exception {
        VelocityEngine engine = new VelocityEngine();
        engine.init();
        
        try {
            Template template = engine.getTemplate(templatePath);
            String input = FileUtils.readFileToString(
                new File(contextPath), StandardCharsets.UTF_8
            );
            
            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
            Type contextType = new TypeToken<HashMap<String, Object>>(){}.getType();
            HashMap<String, Object> loadedContext = gson.fromJson(input, contextType);
            
            loadedContext.put("util", new Util());

            VelocityContext context = new VelocityContext(loadedContext);

            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            throw new Exception(writer.toString());
            // return writer.toString();
        } catch (Exception e) {
            throw e;
        }
    }
}
