package com.growingio.android.sdk.collection;

import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GInternal {
    private final String TAG = "GIO.InternalAPI";
    private String featuresVersionJson = null;

    /* loaded from: classes2.dex */
    private static class Internal {
        static GInternal instance = new GInternal();

        private Internal() {
        }
    }

    public static GInternal getInstance() {
        return Internal.instance;
    }

    public synchronized GInternal addFeaturesVersion(String... strArr) {
        if (strArr.length % 2 != 0) {
            if (!GConfig.DEBUG) {
                LogUtil.e("GIO.InternalAPI", "GInternal addFeaturesVersion the num of arguments must be even");
                return this;
            }
            throw new IllegalArgumentException("GInternal addFeaturesVersion the num of arguments must be even");
        }
        try {
            JSONObject jSONObject = this.featuresVersionJson == null ? new JSONObject() : new JSONObject(this.featuresVersionJson);
            int i2 = 0;
            while (i2 < strArr.length) {
                String str = strArr[i2];
                String str2 = strArr[i2 + 1];
                if (str != null && str2 != null) {
                    i2 += 2;
                    if (jSONObject.has(str)) {
                        LogUtil.d("GIO.InternalAPI", "addFeaturesVersion key: ", str, " has exist on featuresVersionJson, oops");
                    }
                    jSONObject.put(str, str2);
                }
                if (!GConfig.DEBUG) {
                    LogUtil.e("GIO.InternalAPI", "key or value is null");
                    return this;
                }
                throw new IllegalArgumentException("key or value is null");
            }
            if (jSONObject.length() == 0) {
                this.featuresVersionJson = null;
            } else {
                this.featuresVersionJson = jSONObject.toString();
            }
        } catch (JSONException e2) {
            LogUtil.e("GIO.InternalAPI", e2.getMessage(), e2);
        }
        return this;
    }

    public String getFeaturesVersionJson() {
        return this.featuresVersionJson;
    }
}
