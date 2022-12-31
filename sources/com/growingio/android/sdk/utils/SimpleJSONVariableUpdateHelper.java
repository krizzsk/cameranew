package com.growingio.android.sdk.utils;

import android.util.Log;
import com.growingio.android.sdk.collection.ErrorLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class SimpleJSONVariableUpdateHelper implements Runnable {
    public static final int MAX_JSON_SIZE = 100;
    private final String TAG;
    private JSONObject mVariable;

    public SimpleJSONVariableUpdateHelper() {
        this.TAG = "GIO.SimpleJSONVariableUpdateHelper";
        this.mVariable = new JSONObject();
    }

    private boolean isValueChanged(Object obj, Object obj2) {
        return !(obj == null || obj.equals(obj2)) || (obj == null && obj2 != null);
    }

    private int mergeJson(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (mergeOverMaxJsonSize(JsonUtil.copyJson(jSONObject, false), jSONObject2) > 0) {
                return mergeOverMaxJsonSize(jSONObject, jSONObject2);
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private int mergeOverMaxJsonSize(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        int i2 = 0;
        int i3 = 100;
        while (keys.hasNext()) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            String next = keys.next();
            Object obj = jSONObject2.get(next);
            Object opt = jSONObject.opt(next);
            if ("".equals(obj)) {
                obj = null;
            }
            if (isValueChanged(opt, obj)) {
                i2++;
            }
            jSONObject.put(next, obj);
            if (jSONObject.length() > 100) {
                Log.e("GrowingIO", ErrorLog.JSON_TOO_LONG);
                return -1;
            }
            i3 = i4;
        }
        return i2;
    }

    public abstract void afterUpdated();

    public JSONObject getVariable() {
        return this.mVariable;
    }

    @Override // java.lang.Runnable
    public void run() {
        afterUpdated();
    }

    public void setVariable(JSONObject jSONObject) {
        this.mVariable = jSONObject;
    }

    public void update(String str, Object obj) {
        if (isValueChanged(this.mVariable.opt(str), obj)) {
            try {
                this.mVariable.put(str, obj);
                ThreadUtils.cancelTaskOnUiThread(this);
                ThreadUtils.postOnUiThread(this);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public SimpleJSONVariableUpdateHelper(JSONObject jSONObject) {
        this.TAG = "GIO.SimpleJSONVariableUpdateHelper";
        this.mVariable = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public void update(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            int mergeJson = mergeJson(this.mVariable, jSONObject);
            LogUtil.d("GIO.SimpleJSONVariableUpdateHelper", "数据变更量：" + mergeJson);
            if (mergeJson > 0) {
                ThreadUtils.cancelTaskOnUiThread(this);
                ThreadUtils.postOnUiThread(this);
                return;
            }
            return;
        }
        LogUtil.d("GIO.SimpleJSONVariableUpdateHelper", "update JSONObject, and variable is null");
        this.mVariable = new JSONObject();
    }
}
