package com.huawei.hianalytics.v2.a.b;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements l {
    private k a = n.a();
    private com.huawei.hianalytics.v2.a.a.f b;
    private Context c;

    /* renamed from: d  reason: collision with root package name */
    private String f5138d;

    public b(Context context, com.huawei.hianalytics.v2.a.a.f fVar, String str) {
        this.c = context.getApplicationContext();
        this.b = fVar;
        this.f5138d = str;
    }

    private boolean a(com.huawei.hianalytics.v2.a.a.f fVar) {
        JSONObject b = fVar.b();
        if (b == null) {
            return false;
        }
        try {
            return this.a.a(com.huawei.hianalytics.util.m.a(b.toString().getBytes("UTF-8")), this.f5138d);
        } catch (UnsupportedEncodingException unused) {
            com.huawei.hianalytics.b.b.c("DataSendTask", "sendData(): UnsupportedEncodingException");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.huawei.hianalytics.b.b.b("HiAnalytics", " begin to send event data");
        com.huawei.hianalytics.v2.a.a.f fVar = this.b;
        if (fVar == null) {
            return;
        }
        boolean a = a(fVar);
        com.huawei.hianalytics.b.b.a("HiAnalytics", "data send result: %s", Boolean.valueOf(a));
        i.a(new g(this.c, a, this.b));
    }
}
