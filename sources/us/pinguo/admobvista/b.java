package us.pinguo.admobvista;

import android.content.Context;
import android.text.TextUtils;
import d.f.a.b.d;
import java.util.HashMap;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: AppwallManager.java */
/* loaded from: classes3.dex */
public class b {
    public static void a(Context context, int i2, String str) {
        if (i2 != 1 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b(context, Integer.valueOf(str).intValue());
        } catch (NumberFormatException unused) {
        }
    }

    private static void b(Context context, int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appwallId", String.valueOf(i2));
            PgAdvManager.getInstance().q().d(3, context, hashMap);
        } catch (Exception e2) {
            d.c(e2);
        }
    }
}
