package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends e {
    private com.tencent.stat.common.a a;

    /* renamed from: l  reason: collision with root package name */
    private JSONObject f8272l;

    public k(Context context, int i2, JSONObject jSONObject) {
        super(context, i2);
        this.f8272l = null;
        this.a = new com.tencent.stat.common.a(context);
        this.f8272l = jSONObject;
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.SESSION_ENV;
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        DeviceInfo deviceInfo = this.f8255e;
        if (deviceInfo != null) {
            jSONObject.put("ut", deviceInfo.getUserType());
        }
        JSONObject jSONObject2 = this.f8272l;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        this.a.a(jSONObject);
        return true;
    }
}
