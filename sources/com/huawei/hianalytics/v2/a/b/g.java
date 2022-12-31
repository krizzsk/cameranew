package com.huawei.hianalytics.v2.a.b;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements l {
    private boolean a;
    private com.huawei.hianalytics.v2.a.a.f b;
    private Context c;

    public g(Context context, boolean z, com.huawei.hianalytics.v2.a.a.f fVar) {
        this.c = context.getApplicationContext();
        this.a = z;
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a || this.b == null) {
            return;
        }
        com.huawei.hianalytics.b.b.b("HiAnalytics", "data send failed, write to cache file...");
        com.huawei.hianalytics.v2.a.a.a[] b = com.huawei.hianalytics.v2.a.a.a.b(com.huawei.hianalytics.util.e.b(this.c));
        com.huawei.hianalytics.v2.a.a.a[] a = this.b.a();
        int length = b.length + a.length;
        com.huawei.hianalytics.v2.a.a.c[] cVarArr = new com.huawei.hianalytics.v2.a.a.a[length];
        System.arraycopy(b, 0, cVarArr, 0, b.length);
        System.arraycopy(a, 0, cVarArr, b.length, a.length + b.length > 3000 ? 3000 - b.length : a.length);
        if (length > 0) {
            int i2 = length <= 3000 ? 0 : length - 3000;
            com.huawei.hianalytics.b.b.a("EventSendResultHandleTask", "total size: %d event size to save: %d, start index: %d", Integer.valueOf(length), Integer.valueOf(length), Integer.valueOf(i2));
            JSONArray jSONArray = new JSONArray();
            while (i2 < length) {
                com.huawei.hianalytics.v2.a.a.a aVar = new com.huawei.hianalytics.v2.a.a.a();
                cVarArr[i2].a(aVar);
                jSONArray.put(aVar.a());
                i2++;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("events", jSONArray);
                com.huawei.hianalytics.util.l.a(this.c, jSONObject, "cached_v2");
            } catch (JSONException unused) {
                com.huawei.hianalytics.b.b.c("EventSendResultHandleTask", "run(): JSONException");
            }
        }
    }
}
