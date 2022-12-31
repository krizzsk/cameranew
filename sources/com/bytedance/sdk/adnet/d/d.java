package com.bytedance.sdk.adnet.d;

import android.content.Context;
import java.util.LinkedHashMap;
/* compiled from: MultiProcessFileUtils.java */
/* loaded from: classes.dex */
public class d {
    public static void a(Context context, int i2, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i2 == 1) {
                linkedHashMap.put("tnc_config", str);
            }
            c.b("MultiProcessFileUtils", "saveData = " + str);
            com.bytedance.sdk.adnet.a.a().a(context, linkedHashMap);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r2, int r3) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L6
            goto L12
        L6:
            com.bytedance.sdk.adnet.c.b r3 = com.bytedance.sdk.adnet.a.a()     // Catch: java.lang.Exception -> L12
            java.lang.String r1 = "tnc_config"
            java.lang.String r2 = r3.a(r2, r1, r0)     // Catch: java.lang.Exception -> L12
            goto L13
        L12:
            r2 = r0
        L13:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L1b
            java.lang.String r0 = java.lang.String.valueOf(r2)
        L1b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.d.d.a(android.content.Context, int):java.lang.String");
    }
}
