package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b.c;
import com.bytedance.sdk.openadsdk.j.h;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* compiled from: AdEventProviderImpl.java */
/* loaded from: classes.dex */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {
    private Context a;

    /* compiled from: AdEventProviderImpl.java */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0066a implements com.bytedance.sdk.openadsdk.f.a.a {
        JSONObject a;

        private C0066a(String str) {
            try {
                this.a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C0066a b(String str) {
            return new C0066a(str);
        }

        @Override // com.bytedance.sdk.openadsdk.f.a.a
        public JSONObject a() {
            return this.a;
        }
    }

    /* compiled from: AdEventProviderImpl.java */
    /* loaded from: classes.dex */
    private static class c {
        private static volatile com.bytedance.sdk.openadsdk.f.b.c a;

        public static com.bytedance.sdk.openadsdk.f.b.c a() {
            if (a == null) {
                synchronized (com.bytedance.sdk.openadsdk.f.b.c.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.f.b.c();
                    }
                }
            }
            return a;
        }
    }

    /* compiled from: AdEventProviderImpl.java */
    /* loaded from: classes.dex */
    private static class d {
        private static volatile com.bytedance.sdk.openadsdk.j.a a;

        public static com.bytedance.sdk.openadsdk.j.a a() {
            if (a == null) {
                synchronized (com.bytedance.sdk.openadsdk.j.a.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.j.b(o.a(), new h(o.a()));
                    }
                }
            }
            return a;
        }
    }

    public static void a(boolean z) {
        if (o.a() == null) {
            return;
        }
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                f2.getType(Uri.parse(g() + "logStatusStart" + ("?isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                String a = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                f2.getType(Uri.parse(g() + "logStatusUpload?event=" + a));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        if (o.a() == null) {
            return;
        }
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                f2.getType(Uri.parse(g() + "adEventStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                f2.getType(Uri.parse(g() + "trackFailed"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                f2.getType(Uri.parse(g() + "logStatusInit"));
            }
        } catch (Throwable unused) {
        }
    }

    private static ContentResolver f() {
        try {
            if (o.a() != null) {
                return o.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String g() {
        return e.b + "/t_event_ad_event/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_event_ad_event";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "dispatch event");
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                String a = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                f2.getType(Uri.parse(g() + "adEventDispatch?event=" + a));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.e("AdEventProviderImpl", "dispatch event Throwable:" + th.toString());
        }
    }

    /* compiled from: AdEventProviderImpl.java */
    /* loaded from: classes.dex */
    private static class b {
        private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a;
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> b;
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> c;

        static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a() {
            if (a == null) {
                synchronized (o.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.c.b<>(new f(o.a()), o.f(), g.b.a(), d());
                    }
                }
            }
            return a;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> b() {
            if (c == null) {
                synchronized (o.class) {
                    if (c == null) {
                        c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
            return c;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> c() {
            if (b == null) {
                synchronized (o.class) {
                    if (b == null) {
                        b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
            return b;
        }

        private static g.a d() {
            return new g.a() { // from class: com.bytedance.sdk.openadsdk.multipro.c.a.b.1
                @Override // com.bytedance.sdk.openadsdk.c.g.a
                public boolean a() {
                    return q.a(o.a());
                }
            };
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
            g.b b2;
            com.bytedance.sdk.openadsdk.c.e lVar;
            if (z) {
                lVar = new n(o.a());
                b2 = g.b.a();
            } else {
                b2 = g.b.b();
                lVar = new l(o.a());
            }
            g.a d2 = d();
            return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, d2, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, d2));
        }
    }

    public static void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(str));
                    sb.append(",");
                }
                String a = com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString());
                String str2 = "?track=" + String.valueOf(a);
                ContentResolver f2 = f();
                if (f2 == null) {
                    return;
                }
                f2.getType(Uri.parse(g() + "trackUrl" + str2));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver f2 = f();
            if (f2 != null) {
                f2.getType(Uri.parse(g() + "logStatusDispatch" + ("?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str) + "&isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("adEventStart".equals(str)) {
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "====ad event function will be start====");
            b.a().a();
        } else if ("logStatusStart".equals(str)) {
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "====log stats function will be start====");
            if (Boolean.valueOf(uri.getQueryParameter("isRealTime")).booleanValue()) {
                b.c().a();
            } else {
                b.b().a();
            }
        } else if ("adEventDispatch".equals(str)) {
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
            com.bytedance.sdk.openadsdk.c.a a = com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a != null) {
                b.a().a(a);
            }
        } else if ("logStatusDispatch".equals(str)) {
            Boolean valueOf = Boolean.valueOf(uri.getQueryParameter("isRealTime"));
            c.a a2 = c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a2 == null) {
                return null;
            }
            if (valueOf.booleanValue()) {
                b.c().a(a2);
            } else {
                b.b().a(a2);
            }
        } else if ("trackUrl".equals(str)) {
            try {
                String[] split = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("track")).split(",");
                if (split.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        String b2 = com.bytedance.sdk.openadsdk.multipro.c.b(str2);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                        }
                    }
                    d.a().a(arrayList);
                }
            } catch (Throwable unused) {
            }
        } else if ("trackFailed".equals(str)) {
            d.a().a();
            com.bytedance.sdk.openadsdk.utils.o.b("AdEventProviderImpl", "track failed: ");
        } else if ("logStatusInit".equals(str)) {
            c.a().a();
        } else if ("logStatusUpload".equals(str)) {
            String b3 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
            if (!TextUtils.isEmpty(b3)) {
                c.a().a(C0066a.b(b3));
            }
        }
        return null;
    }
}
