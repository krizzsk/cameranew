package d.e.d.a;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ISNEventsBaseData.java */
/* loaded from: classes2.dex */
public class b implements d.e.a.c {
    private static Map<String, Object> a = new HashMap();

    /* compiled from: ISNEventsBaseData.java */
    /* renamed from: d.e.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0297b {
        String a;
        String b;
        Context c;

        /* renamed from: d  reason: collision with root package name */
        String f8533d;

        public b a() {
            return new b(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0297b b(String str) {
            this.b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0297b c(Context context) {
            this.c = context;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0297b d(String str) {
            this.a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0297b e(String str) {
            this.f8533d = str;
            return this;
        }
    }

    private void b(Context context) {
        a.put("connectiontype", d.e.c.b.b(context));
    }

    private void c(C0297b c0297b) {
        Context context = c0297b.c;
        com.ironsource.sdk.utils.a h2 = com.ironsource.sdk.utils.a.h(context);
        a.put("deviceos", com.ironsource.sdk.utils.f.c(h2.e()));
        a.put("deviceosversion", com.ironsource.sdk.utils.f.c(h2.f()));
        a.put("deviceapilevel", Integer.valueOf(h2.a()));
        a.put("deviceoem", com.ironsource.sdk.utils.f.c(h2.d()));
        a.put("devicemodel", com.ironsource.sdk.utils.f.c(h2.c()));
        a.put("bundleid", com.ironsource.sdk.utils.f.c(context.getPackageName()));
        a.put("applicationkey", com.ironsource.sdk.utils.f.c(c0297b.b));
        a.put("sessionid", com.ironsource.sdk.utils.f.c(c0297b.a));
        a.put("sdkversion", com.ironsource.sdk.utils.f.c(com.ironsource.sdk.utils.a.i()));
        a.put("applicationuserid", com.ironsource.sdk.utils.f.c(c0297b.f8533d));
        a.put("env", "prod");
        a.put(FirebaseAnalytics.Param.ORIGIN, "n");
    }

    public static void d(String str) {
        a.put("connectiontype", com.ironsource.sdk.utils.f.c(str));
    }

    @Override // d.e.a.c
    public Map<String, Object> a() {
        return a;
    }

    private b(C0297b c0297b) {
        c(c0297b);
        b(c0297b.c);
    }
}
