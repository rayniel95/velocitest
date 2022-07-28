package com.github.rayniel95.velocitest.awsappsync.util.rds;

import java.util.Map;

import com.github.rayniel95.velocitest.awsappsync.util.Util;
import com.google.gson.Gson;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class RdsUtil {

    public static Object toJsonObject(String serializedSQLResult) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type contextType = new TypeToken<SqlStatementResults>(){}.getType();
        SqlStatementResults loadedContext = gson.fromJson(
            serializedSQLResult, contextType
            );
        
    }
}
