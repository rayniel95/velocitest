package com.github.rayniel95.velocitest.awsappsync.util;

import org.junit.Test;

import java.io.StringWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
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

    @Test
    public void addPrefix()
    {
        try {
            String result = runTemplate(
                "src/testinfo/obtenersesion/addprefix/addPrefix.vt", 
                "src/testinfo/obtenersesion/addprefix/context.json"
            );
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    @Test
    public void getSession()
    {
        // try {
        //     String result = runTemplate(
        //         "src/testinfo/obtenersesion/getsession/GetSessionForObtenerSesion.req.vt", 
        //         "src/testinfo/obtenersesion/getsession/req.context.json"
        //     );
        // } catch (Exception e) {
        //     System.err.println(e);
        // }

        // try {
        //     String result = runTemplate(
        //         "src/testinfo/obtenersesion/getsession/GetSessionForObtenerSesion.res.vt", 
        //         "src/testinfo/obtenersesion/getsession/res.context.json"
        //     );
        // } catch (Exception e) {
        //     System.err.println(e);
        // }
    }
    @Test
    public void concatQueryAttributes()
    {
        // try {
        //     String result = runTemplate(
        //         "src/testinfo/obtenersesion/concatqueryattributes/concatQueryAttributes.vt", 
        //         "src/testinfo/obtenersesion/concatqueryattributes/GetSharedCredentialsForObtenerSesion.req.context.json"
        //     );
        // } catch (Exception e) {
        //     System.err.println(e);
        // }
    }
    @Test
    public void getSharedCredentialsForObtenerSesion()
    {
        // try {
        //     String result = runTemplate(
        //         "src/testinfo/obtenersesion/getsharedcredentialsforobtenersesion/GetSharedCredentialsForObtenerSesion.req.vt", 
        //         "src/testinfo/obtenersesion/getsharedcredentialsforobtenersesion/req.context.json"
        //     );
        // } catch (Exception e) {
        //     System.err.println(e);
        // }
    }

    @Test
    public void flattenSqlStatementResult()
    {
        // try {
        //     String result = runTemplate(
        //         "src/testinfo/obtenersesion/flattensqlstatementresult/flattenSqlStatementResult.vt", 
        //         "src/testinfo/obtenersesion/flattensqlstatementresult/context.json"
        //     );
        // } catch (Exception e) {
        //     System.err.println(e);
        // }
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
