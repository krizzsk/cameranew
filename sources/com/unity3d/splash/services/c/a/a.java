package com.unity3d.splash.services.c.a;

import android.text.TextUtils;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private JSONObject a;

    private synchronized Object b(String str) {
        String[] split = str.split("\\.");
        JSONObject jSONObject = this.a;
        if (str.length() == 0) {
            return jSONObject;
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!jSONObject.has(split[i2])) {
                return null;
            }
            try {
                jSONObject = jSONObject.getJSONObject(split[i2]);
            } catch (Exception e2) {
                DeviceLog.g("Couldn't read JSONObject: " + split[i2], e2);
                return null;
            }
        }
        return jSONObject;
    }

    private synchronized String e(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList(Arrays.asList(str.split("\\.")));
        arrayList.remove(arrayList.size() - 1);
        return TextUtils.join(".", arrayList.toArray());
    }

    public synchronized boolean a(String str) {
        JSONObject jSONObject;
        if (this.a == null) {
            DeviceLog.f("Data is NULL, readStorage probably not called");
            return false;
        }
        String[] split = str.split("\\.");
        return (!(b(e(str)) instanceof JSONObject) || (jSONObject = (JSONObject) b(e(str))) == null || jSONObject.remove(split[split.length - 1]) == null) ? false : true;
    }

    public synchronized Object c(String str) {
        JSONObject jSONObject;
        Object obj = null;
        if (this.a == null) {
            DeviceLog.f("Data is NULL, readStorage probably not called");
            return null;
        }
        String[] split = str.split("\\.");
        if (!(b(e(str)) instanceof JSONObject) || (jSONObject = (JSONObject) b(e(str))) == null) {
            return null;
        }
        try {
            if (jSONObject.has(split[split.length - 1])) {
                obj = jSONObject.get(split[split.length - 1]);
            }
        } catch (Exception e2) {
            DeviceLog.g("Error getting data", e2);
        }
        return obj;
    }

    public synchronized JSONObject d() {
        return this.a;
    }

    public synchronized boolean f() {
        boolean z;
        if (this.a == null) {
            this.a = new JSONObject();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void g(JSONObject jSONObject) {
        this.a = jSONObject;
    }
}
