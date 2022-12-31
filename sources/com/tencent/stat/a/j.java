package com.tencent.stat.a;

import android.content.Context;
import com.facebook.common.callercontext.ContextChain;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends e {
    Long a;

    /* renamed from: l  reason: collision with root package name */
    String f8271l;
    String m;

    public j(Context context, String str, String str2, int i2, Long l2) {
        super(context, i2);
        this.a = null;
        this.m = str;
        this.f8271l = str2;
        this.a = l2;
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.PAGE_VIEW;
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        com.tencent.stat.common.k.a(jSONObject, ContextChain.TAG_PRODUCT_AND_INFRA, this.f8271l);
        com.tencent.stat.common.k.a(jSONObject, "rf", this.m);
        Long l2 = this.a;
        if (l2 != null) {
            jSONObject.put("du", l2);
            return true;
        }
        return true;
    }
}
