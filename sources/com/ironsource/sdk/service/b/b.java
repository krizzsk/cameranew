package com.ironsource.sdk.service.b;

import android.content.Context;
import android.os.Build;
import org.json.JSONObject;
/* compiled from: ConnectivityAdapter.java */
/* loaded from: classes2.dex */
public abstract class b implements d {
    private c a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(JSONObject jSONObject, Context context) {
        this.a = d(jSONObject, context);
        String simpleName = b.class.getSimpleName();
        com.ironsource.sdk.utils.d.d(simpleName, "created ConnectivityAdapter with strategy " + this.a.getClass().getSimpleName());
    }

    private c d(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt("connectivityStrategy") == 1) {
            return new a(this);
        }
        boolean i2 = com.ironsource.environment.c.i(context, "android.permission.ACCESS_NETWORK_STATE");
        if (Build.VERSION.SDK_INT >= 23 && i2) {
            return new e(this);
        }
        return new a(this);
    }

    @Override // com.ironsource.sdk.service.b.d
    public void a() {
    }

    @Override // com.ironsource.sdk.service.b.d
    public void b(String str, JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.service.b.d
    public void c(String str, JSONObject jSONObject) {
    }

    public JSONObject e(Context context) {
        return this.a.a(context);
    }

    public void f() {
        this.a.release();
    }

    public void g(Context context) {
        this.a.b(context);
    }

    public void h(Context context) {
        this.a.c(context);
    }
}
