package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.gf;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class fq {
    private static final String c = "fq";
    public final Map a;
    public final Map b;

    /* JADX INFO: Access modifiers changed from: protected */
    public fq(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        this.b = new HashMap();
        hashMap.put("placement", str);
        hashMap.put("placement_type", str2);
        hashMap.put(FirebaseAnalytics.Param.CONTENT_TYPE, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final gf.a a(String str, Map map, Map map2) {
        gf.a b = gf.e(str).a().a(this.a).a(map).b(map2);
        this.b.put(str, b);
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final gf.a b(String str, Map map, Map map2) {
        gf.a aVar = !al.a(str) ? (gf.a) this.b.remove(str) : null;
        if (aVar == null) {
            String str2 = c;
            TapjoyLog.e(str2, "Error when calling endTrackingEvent -- " + str + " tracking has not been started.");
        } else {
            aVar.a(this.a).a(map).b(map2).b().c();
        }
        return aVar;
    }

    public final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final gf.a a() {
        return a("Content.rendered", null, null);
    }

    public final gf.a b() {
        return b("Content.rendered", null, null);
    }
}
