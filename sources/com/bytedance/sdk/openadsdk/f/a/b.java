package com.bytedance.sdk.openadsdk.f.a;

import org.json.JSONObject;
/* compiled from: LoadAdNoRspLog.java */
/* loaded from: classes.dex */
public class b extends c<b> {
    private long a;
    private long b;

    public b a(long j2) {
        this.a = j2;
        return this;
    }

    public b b(long j2) {
        this.b = j2;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.c, com.bytedance.sdk.openadsdk.f.a.a
    public JSONObject a() {
        JSONObject a = super.a();
        try {
            a.put("c_process_time", this.a);
            a.put("s_process_time", this.b);
        } catch (Exception unused) {
        }
        return a;
    }
}
