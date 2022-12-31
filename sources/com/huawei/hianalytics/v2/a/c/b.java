package com.huawei.hianalytics.v2.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.util.k;
import com.huawei.hianalytics.v2.a.b.l;
import com.huawei.hianalytics.v2.a.c.a.c;
/* loaded from: classes2.dex */
public class b implements l {
    private Context a;

    public b(Context context) {
        this.a = context;
    }

    private String a(Context context) {
        return com.huawei.hianalytics.util.l.c(context, "cached");
    }

    private String a(SharedPreferences sharedPreferences, String str) {
        return k.a(sharedPreferences, str, (String) null);
    }

    private void a(Context context, String str) {
        SharedPreferences.Editor edit = k.a(context, str).edit();
        edit.clear();
        edit.apply();
    }

    private void a(com.huawei.hianalytics.v2.a.c.a.a aVar, String str, String str2) {
        aVar.a(str);
        aVar.b(str2);
        aVar.a();
    }

    private void a(String str, String str2, String str3) {
        a(new com.huawei.hianalytics.v2.a.c.a.b(), str, str3);
        a(new c(), str2, str3);
    }

    private void b(Context context) {
        a(context, "state");
        a(context, "sessioncontext");
        a(context, "flag");
        c(context);
    }

    private void c(Context context) {
        com.huawei.hianalytics.util.l.b(context, "cached");
    }

    public void a() {
        String str;
        SharedPreferences a = k.a(this.a, "state");
        if (a == null) {
            str = "checkAndReportV1Data: get sharedPreference error.";
        } else {
            String a2 = a(a, "events");
            String a3 = a(a, "activities");
            String a4 = a(this.a);
            b(this.a);
            if (!TextUtils.isEmpty(a2) || !TextUtils.isEmpty(a3) || !TextUtils.isEmpty(a4)) {
                a(a2, a3, a4);
                return;
            }
            str = "checkAndReportV1Data: No cached V1 data found.";
        }
        com.huawei.hianalytics.b.b.b("V1CompatibleReportTask", str);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
