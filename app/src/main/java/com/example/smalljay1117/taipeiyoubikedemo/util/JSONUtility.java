package com.example.smalljay1117.taipeiyoubikedemo.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * JSON相關Utility
 *
 * @author Shannon Lo
 */
public class JSONUtility {

    /**
     * Get JSONObject from String
     *
     * @param data String
     * @return JSONObject
     * @author Shannon Lo
     */
    public static JSONObject getJSONObject(String data) {
        JSONObject json = null;

        if (TextUtils.isEmpty(data)) {
            return json;
        }

        try {
            json = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Get JSONObject from JSONArray
     *
     * @param array JSONArray
     * @return JSONObject
     * @author Shannon Lo
     */
    public static JSONObject getJSONObject(JSONArray array, int position) {
        JSONObject json = null;

        if (array == null) {
            return json;
        }

        try {
            json = array.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Get JSONObject from JSONObject
     *
     * @param json JSONObject
     * @return JSONObject
     * @author Shannon Lo
     */
    public static JSONObject getJSONObject(JSONObject json, String key) {
        JSONObject jsonChild = null;

        if (json == null) {
            return jsonChild;
        }

        try {
            if (json.has(key)) {
                jsonChild = json.getJSONObject(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonChild;
    }

    /**
     * Get JSONArray from String
     *
     * @param data String
     * @return JSONArray
     * @author Shannon Lo
     */
    public static JSONArray getJSONArray(String data) {
        JSONArray json = null;

        if (TextUtils.isEmpty(data)) {
            return json;
        }

        try {
            json = new JSONArray(data);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * 在JSON增加Object
     *
     * @param json JSONObject
     * @param key key
     * @param value value
     * @return JSONObject
     * @author Shannon Lo
     */
    public static JSONObject putObjectToJSONObject(JSONObject json, String key, String value) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }

        if (json == null) {
            json = new JSONObject();
        }

        try {
            json.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Get the String value from key in JSONObject
     *
     * @param json JSONObject
     * @param key search key
     * @return value. If return is null, it means that there has no key in json
     * object
     * @author Shannon Lo
     */
    public static String getStringFromJSONObject(JSONObject json, String key) {
        String value = "";

        if (json == null) {
            return value;
        }

        try {
            if (json.has(key)) {
                value = json.getString(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * Get the int value from key in JSONObject
     *
     * @param json JSONObject
     * @param key search key
     * @return value. If return is null, it means that there has no key in json
     * object
     * @author Shannon Lo
     */
    public static int getIntFromJSONObject(JSONObject json, String key) {
        int value = 0;

        if (json == null) {
            return value;
        }

        try {
            if (json.has(key)) {
                value = json.getInt(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * Get the Long value from key in JSONObject
     *
     * @param json JSONObject
     * @param key search key
     * @return value. If return is null, it means that there has no key in json
     * object
     * @author Shannon Lo
     */
    public static Long getLongFromJSONObject(JSONObject json, String key) {
        Long value = 0l;

        if (json == null) {
            return value;
        }

        try {
            if (json.has(key)) {
                value = json.getLong(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * Get the Double value from key in JSONObject
     *
     * @param json JSONObject
     * @param key search key
     * @return value. If return is null, it means that there has no key in json
     * object
     * @author Shannon Lo
     */
    public static Double getDoubleFromJSONObject(JSONObject json, String key) {
        Double value = null;

        if (json == null) {
            return value;
        }

        try {
            if (json.has(key)) {
                value = json.getDouble(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * Get the JSONArray from key in JSONObject
     *
     * @param json JSONObject
     * @param key search key
     * @return JSONArray. If return is null, it means that there has no key in
     * json object
     * @author Shannon Lo
     */
    public static JSONArray getJSONArrayFromJSONObject(JSONObject json, String key) {
        JSONArray array = null;

        if (json == null) {
            return array;
        }

        try {
            if (json.has(key)) {
                array = json.getJSONArray(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return array;
    }

    /**
     * Get the JSONObkect from String data
     *
     * @param data String data
     * @return JSONObject
     * @author Shannon Lo
     */
    public static JSONObject getJSONObjectFromString(String data) {
        JSONObject json = null;

        if (TextUtils.isEmpty(data)) {
            return json;
        }

        try {
            json = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * Get ArrayList<String> from JSONArray
     *
     * @param jsonArray JSONArray
     * @return ArrayList
     * @author Shannon Lo
     */
    public static ArrayList<String> getArrayListFromJSONArray(JSONArray jsonArray) {
        ArrayList<String> arrayList = null;

        if (jsonArray == null) {
            return arrayList;
        }

        try {
            arrayList = new ArrayList<String>();
            if (jsonArray != null && jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(jsonArray.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }

}
