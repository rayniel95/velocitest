package com.github.rayniel95.velocitest.awsappsync.util;
    
import java.util.Map;
import com.google.gson.Gson;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class Util {

    public static void error(String valString) throws Exception {
        throw new Exception(valString);
    }
    public static boolean isNullOrEmpty(Object valuObject) {
        // TODO - add all the possible data types used in velocity
        if (valuObject != null) {
            return false;
        }   
        return true;
    }
    // public static boolean qr(Object valuObject) {
        
    // }
    // public static autoId() {
        
    // }
    public static String toJson(Object valObject) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type contextType = new TypeToken<HashMap<Object, Object>>(){}.getType();
        String loadedContext = gson.toJson(valObject, contextType);
        return loadedContext;
    }
    public static Map<Object, Object> parseJson(String valObject) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type contextType = new TypeToken<HashMap<Object, Object>>(){}.getType();
        HashMap<Object, Object> loadedContext = gson.fromJson(valObject, contextType);
        return loadedContext;
    }
}
