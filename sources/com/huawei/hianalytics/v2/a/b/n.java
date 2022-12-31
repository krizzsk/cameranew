package com.huawei.hianalytics.v2.a.b;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public final class n implements k {
    private static n a;

    private n() {
    }

    public static synchronized k a() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new n();
            }
            nVar = a;
        }
        return nVar;
    }

    private Map<String, String> a(com.huawei.hianalytics.a.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", cVar.o());
        hashMap.put("App-Ver", cVar.l());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.0.0.309");
        hashMap.put("Device-Type", Build.MODEL);
        String replace = UUID.randomUUID().toString().replace(PGTransHeader.CONNECTOR, "");
        com.huawei.hianalytics.b.b.a("HiAnalytics", "sendData RequestId : %s", replace);
        hashMap.put("Request-Id", replace);
        return hashMap;
    }

    @Override // com.huawei.hianalytics.v2.a.b.k
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isoCode", str);
            com.huawei.hianalytics.c.e a2 = com.huawei.hianalytics.c.d.a("{url}/getServerInfo".replace("{url}", "https://metrics.data.hicloud.com:6447"), jSONObject.toString());
            com.huawei.hianalytics.v2.a.a.i iVar = new com.huawei.hianalytics.v2.a.a.i();
            iVar.a(a2.b());
            com.huawei.hianalytics.b.b.a("HiAnalytics", "get server add response err code: %s", iVar.a());
            return iVar.b();
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("NetHandler", "getUploadServerAddr(): JSONException");
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.hianalytics.v2.a.b.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(byte[] r6, java.lang.String r7) {
        /*
            r5 = this;
            com.huawei.hianalytics.v2.a.b.m r0 = com.huawei.hianalytics.v2.a.b.h.a()
            com.huawei.hianalytics.a.c r0 = r0.d()
            java.util.HashMap r1 = r0.y()
            java.lang.Object r1 = r1.get(r7)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r2 == 0) goto L1a
            return r3
        L1a:
            java.lang.String r2 = "preins"
            boolean r2 = r2.equals(r7)
            java.lang.String r4 = "{url}"
            if (r2 == 0) goto L2b
            java.lang.String r7 = "{url}/common/hmshioperbatch"
        L26:
            java.lang.String r7 = r7.replace(r4, r1)
            goto L43
        L2b:
            java.lang.String r2 = "oper"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L36
            java.lang.String r7 = "{url}/common/hmshioperqrt"
            goto L26
        L36:
            java.lang.String r2 = "maint"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L41
            java.lang.String r7 = "{url}/common/hmshimaintqrt"
            goto L26
        L41:
            java.lang.String r7 = ""
        L43:
            java.util.Map r0 = r5.a(r0)
            com.huawei.hianalytics.c.e r6 = com.huawei.hianalytics.c.d.a(r7, r6, r0)
            int r6 = r6.a()
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L54
            r3 = 1
        L54:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.v2.a.b.n.a(byte[], java.lang.String):boolean");
    }
}
