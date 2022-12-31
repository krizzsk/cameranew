package com.tencent.stat.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends e {
    private static String a;

    /* renamed from: l  reason: collision with root package name */
    private String f8270l;
    private String m;

    public i(Context context, int i2) {
        super(context, i2);
        this.f8270l = null;
        this.m = null;
        this.f8270l = com.tencent.stat.common.k.p(context);
        if (a == null) {
            a = com.tencent.stat.common.k.m(context);
        }
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.NETWORK_MONITOR;
    }

    public void a(String str) {
        this.m = str;
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        com.tencent.stat.common.k.a(jSONObject, "op", a);
        com.tencent.stat.common.k.a(jSONObject, "cn", this.f8270l);
        jSONObject.put("sp", this.m);
        return true;
    }
}
