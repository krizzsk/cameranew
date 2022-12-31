package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.growingio.android.sdk.utils.LinkedString;
import com.growingio.android.sdk.utils.LogUtil;
import com.tencent.open.SocialConstants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ActionStruct {
    private static final String TAG = "GIO.ActionStruct";
    public String content;
    private volatile int hashCode;
    public String imgHashcode;
    public int index = -1;
    public String obj;
    public long time;
    public LinkedString xpath;

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            LinkedString linkedString = this.xpath;
            int hashCode = (((527 + (linkedString != null ? linkedString.hashCode() : 0)) * 31) + this.index) * 31;
            String str = this.content;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.obj;
            int hashCode3 = hashCode2 + (str2 != null ? str2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.xpath);
            jSONObject.put("tm", System.currentTimeMillis());
            int i2 = this.index;
            if (i2 >= 0) {
                jSONObject.put("idx", i2);
            }
            if (!TextUtils.isEmpty(this.obj)) {
                jSONObject.put("obj", this.obj);
            }
            if (!TextUtils.isEmpty(this.content)) {
                jSONObject.put("v", this.content);
            }
            if (!TextUtils.isEmpty(this.imgHashcode)) {
                jSONObject.put(SocialConstants.PARAM_IMG_URL, this.imgHashcode);
            }
            return jSONObject;
        } catch (JSONException e2) {
            LogUtil.d(TAG, "generate impress view error", e2);
            return null;
        }
    }

    public String toString() {
        return String.format(Locale.getDefault(), "tm: %d, xpath: %s, idx: %d, content: %s", Long.valueOf(this.time), this.xpath, Integer.valueOf(this.index), this.content);
    }
}
