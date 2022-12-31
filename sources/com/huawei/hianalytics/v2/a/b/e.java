package com.huawei.hianalytics.v2.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.Data;
/* loaded from: classes2.dex */
public class e implements l {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private long f5139d;

    /* renamed from: e  reason: collision with root package name */
    private Context f5140e;

    public e(Context context, int i2, String str, String str2, long j2) {
        String str3;
        this.c = "oper";
        this.f5140e = context.getApplicationContext();
        this.a = str;
        this.b = str2;
        if (i2 == 1) {
            str3 = "maint";
        } else if (i2 != 2) {
            this.c = "oper";
            this.f5139d = j2;
        } else {
            str3 = "preins";
        }
        this.c = str3;
        this.f5139d = j2;
    }

    public e(Context context, String str, String str2, long j2) {
        this.c = "oper";
        this.f5140e = context.getApplicationContext();
        this.a = str;
        this.b = str2;
        this.c = "oper";
        this.f5139d = j2;
    }

    @SuppressLint({"ApplySharedPref"})
    private void a() {
        if (com.huawei.hianalytics.util.k.a(this.f5140e, "stat_v2", 5242880)) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "stat sp file reach max limited size, discard new event");
            h.a().c();
            return;
        }
        SharedPreferences a = com.huawei.hianalytics.util.k.a(this.f5140e, "stat_v2");
        if (a == null) {
            com.huawei.hianalytics.b.b.c("EventRecordTask", "event sp is null");
            return;
        }
        com.huawei.hianalytics.v2.a.a.e eVar = new com.huawei.hianalytics.v2.a.a.e();
        eVar.b(this.a);
        eVar.d(com.huawei.hianalytics.util.m.b(this.b, this.f5140e));
        eVar.c(this.c);
        eVar.a(String.valueOf(this.f5139d));
        eVar.a(a);
        if (com.huawei.hianalytics.util.k.a(this.f5140e, "stat_v2", (int) Data.MAX_DATA_BYTES)) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "state file size limit for report ! ");
            h.a().c();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
