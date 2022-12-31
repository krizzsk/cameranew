package com.huawei.hianalytics.v2.a.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p {
    private Context a;
    private k b = n.a();

    public p(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a() {
        com.huawei.hianalytics.a.c d2 = h.a().d();
        if (d2.z()) {
            String a = com.huawei.hianalytics.util.j.a();
            com.huawei.hianalytics.b.b.a("HiAnalytics", "cust version: %s", a);
            String a2 = this.b.a(a);
            HashMap<Object, String> hashMap = new HashMap<>();
            hashMap.put("preins", a2);
            d2.a(hashMap);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            com.huawei.hianalytics.util.k.b(com.huawei.hianalytics.util.k.a(this.a, "global_v2"), "upload_url", a2);
            d2.e(false);
            i.a();
        }
    }
}
