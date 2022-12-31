package com.growingio.android.sdk.collection;
/* loaded from: classes2.dex */
public class ErrorLog {
    public static final String EVENT_NAME_ILLEGAL = "当前数据的标识符不合法。合法的标识符的详细定义请参考：https://docs.growingio.com/v3/developer-manual/sdkintegrated/android-sdk/android-sdk-api/customize-api";
    public static final String JSON_KEY_VALUE_NOT_VALID = "JSONObject传参中键值对不合法, 发送失败";
    public static final String JSON_TOO_LONG = "JSONObject传参最长仅支持100个键值对";
    public static final String JSON_VALUE_EMPTY_VALID = "当前JSONObject没有任何有效数据, 发送失败";
    public static final String TRACK_FRAGMENT_ERROR = "trackAllFragment策略与全局策略相同， 不需要单独设置";
    public static final String USER_ID_TOO_LONG = "GrowingIO.setUserId(VALUE):VALUE长度大于1000，不发送";
    public static final String VALUE_BE_EMPTY = "当前事件类型数据的值不合法。值不能为空或者null";

    public static String argumentBeNull(String str) {
        return "参数:" + str + "不能为null";
    }

    public static String jsonInValidKey(String str) {
        return "JSONObject中的key要求: 1. 非空, 2. 长度小于50: " + str;
    }

    public static String jsonNullValue(String str) {
        return "value 不能为null, 可以传字符串\"null\"代替: " + str;
    }

    public static String jsonObjArrayNotSupport(String str) {
        return "jsonObject 不支持嵌套JSONObject或者JsonArray， 发送失败, key:" + str;
    }

    public static String jsonValueTooLong(String str) {
        return "JSON Object中有键值对，值的字符个数在1000个以下, 发送失败, key: " + str;
    }
}
