package com.ironsource.mediationsdk;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class TokenDataService {
    private static TokenDataService b;
    private JSONObject a = new JSONObject();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TokenDataService tokenDataService = TokenDataService.this;
                tokenDataService.f(tokenDataService.e());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private TokenDataService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject e() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.ironsource.mediationsdk.utils.ContextProvider r2 = com.ironsource.mediationsdk.utils.ContextProvider.getInstance()
            android.content.Context r2 = r2.a()
            if (r2 == 0) goto L7d
            r3 = 0
            java.lang.String[] r4 = com.ironsource.environment.e.d(r2)     // Catch: java.lang.Exception -> L38
            if (r4 == 0) goto L36
            int r5 = r4.length     // Catch: java.lang.Exception -> L38
            r6 = 2
            if (r5 != r6) goto L36
            r5 = r4[r3]     // Catch: java.lang.Exception -> L38
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L38
            if (r5 != 0) goto L27
            r5 = r4[r3]     // Catch: java.lang.Exception -> L38
            goto L28
        L27:
            r5 = r0
        L28:
            r6 = 1
            r4 = r4[r6]     // Catch: java.lang.Exception -> L34
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L34
            boolean r3 = r4.booleanValue()     // Catch: java.lang.Exception -> L34
            goto L54
        L34:
            r4 = move-exception
            goto L3a
        L36:
            r5 = r0
            goto L54
        L38:
            r4 = move-exception
            r5 = r0
        L3a:
            com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "got the following error "
            r7.append(r8)
            java.lang.String r4 = r4.getMessage()
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r6.error(r4)
        L54:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 != 0) goto L5d
            java.lang.String r0 = "GAID"
            goto L69
        L5d:
            java.lang.String r5 = com.ironsource.environment.e.I(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L69
            java.lang.String r0 = "UUID"
        L69:
            java.lang.String r2 = "advId"
            r1.put(r2, r5)     // Catch: java.lang.Exception -> L79
            java.lang.String r2 = "advType"
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = "isLAT"
            r1.put(r0, r3)     // Catch: java.lang.Exception -> L79
            goto L7d
        L79:
            r0 = move-exception
            r0.printStackTrace()
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.TokenDataService.e():org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c(next, jSONObject.opt(next));
        }
    }

    public static synchronized TokenDataService getInstance() {
        TokenDataService tokenDataService;
        synchronized (TokenDataService.class) {
            if (b == null) {
                b = new TokenDataService();
            }
            tokenDataService = b;
        }
        return tokenDataService;
    }

    synchronized void c(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        try {
            new Thread(new a()).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
