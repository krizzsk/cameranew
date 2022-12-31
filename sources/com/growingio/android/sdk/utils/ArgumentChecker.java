package com.growingio.android.sdk.utils;

import android.util.Log;
import com.growingio.android.sdk.collection.ErrorLog;
import com.growingio.android.sdk.collection.GConfig;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ArgumentChecker {
    private static final int MAX_VALUE_SIZE = 1000;
    private static final String TAG = "GIO.ArgumentChecker";
    private final GConfig config;

    public ArgumentChecker(GConfig gConfig) {
        this.config = gConfig;
    }

    public boolean isIllegalEventName(String str) {
        return isIllegalEventName(str, true);
    }

    public boolean isIllegalValue(String str, boolean z) {
        boolean z2 = str == null || str.trim().length() == 0 || str.length() > 1000;
        if (z2 && z) {
            Log.e(TAG, ErrorLog.VALUE_BE_EMPTY);
        }
        return z2;
    }

    public JSONObject validJSONObject(JSONObject jSONObject) {
        return validJSONObject(jSONObject, true);
    }

    public boolean isIllegalEventName(String str, boolean z) {
        if (str == null || str.trim().length() == 0 || str.length() > 50) {
            if (z) {
                Log.e(TAG, ErrorLog.EVENT_NAME_ILLEGAL);
                return true;
            }
            return true;
        }
        return false;
    }

    public JSONObject validJSONObject(JSONObject jSONObject, boolean z) {
        if (z) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
        } else if (jSONObject == null || jSONObject.length() == 0) {
            Log.e("GrowingIO", ErrorLog.VALUE_BE_EMPTY);
            return null;
        }
        if (jSONObject.length() > 100) {
            Log.e("GrowingIO", ErrorLog.JSON_TOO_LONG);
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 0;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (isIllegalEventName(next, true)) {
                    return null;
                }
                if (!(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                    if (opt instanceof String) {
                        if (z && ((String) opt).trim().length() == 0) {
                            opt = "";
                        } else if (isIllegalValue((String) opt, true)) {
                            return null;
                        }
                    }
                    i2++;
                    jSONObject2.put(next, opt);
                    if (i2 >= 100) {
                        break;
                    }
                }
                Log.e("GrowingIO", ErrorLog.jsonObjArrayNotSupport(next));
                return null;
            }
        } catch (JSONException unused) {
        }
        int length = jSONObject.length() - i2;
        if (i2 == 0 && !z) {
            Log.e("GrowingIO", ErrorLog.JSON_VALUE_EMPTY_VALID);
            return null;
        } else if (length > 0) {
            Log.e("GrowingIO", ErrorLog.JSON_KEY_VALUE_NOT_VALID);
            return null;
        } else {
            return jSONObject2;
        }
    }

    public boolean isIllegalValue(String str) {
        return isIllegalValue(str, true);
    }

    public boolean isIllegalValue(Number number) {
        if (number == null) {
            Log.e(TAG, ErrorLog.VALUE_BE_EMPTY);
            return true;
        }
        return false;
    }
}
