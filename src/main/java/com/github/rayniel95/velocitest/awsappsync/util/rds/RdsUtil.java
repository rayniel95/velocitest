package com.github.rayniel95.velocitest.awsappsync.util.rds;

import java.util.Map;

import com.github.rayniel95.velocitest.awsappsync.util.Util;
import com.google.gson.Gson;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class RdsUtil {

    public static SqlStatementResults toJsonObject(String serializedSQLResult) {
        Map<Object, Object> result = Util.parseJson(serializedSQLResult);
        // if(jsonRep["sqlStatementResults"].lenght() == 0){

        // }
        return jsonRep;
    }
}
