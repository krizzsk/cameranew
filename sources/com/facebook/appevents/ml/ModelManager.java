package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.e;
import com.facebook.f;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class ModelManager {
    private static final Map<String, e> a = new ConcurrentHashMap();
    private static final Integer b = 259200000;
    private static final List<String> c = Arrays.asList(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout");

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f2333d = Arrays.asList(PortalFollowFeeds.TYPE_NONE, "address", "health");

    /* loaded from: classes.dex */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public String toKey() {
            int i2 = d.a[ordinal()];
            return i2 != 1 ? i2 != 2 ? "Unknown" : "app_event_pred" : "integrity_detect";
        }

        @Nullable
        public String toUseCase() {
            int i2 = d.a[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return "MTML_APP_EVENT_PRED";
            }
            return "MTML_INTEGRITY_DETECT";
        }
    }

    /* loaded from: classes.dex */
    static class a implements Runnable {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x006e, Exception -> 0x0072, TryCatch #2 {Exception -> 0x0072, all -> 0x006e, blocks: (B:5:0x000b, B:7:0x001d, B:10:0x0024, B:12:0x002f, B:14:0x003d, B:16:0x0043, B:22:0x0067, B:18:0x0049, B:21:0x0050, B:11:0x002a), top: B:28:0x000b }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = "model_request_timestamp"
                java.lang.String r1 = "models"
                boolean r2 = com.facebook.internal.instrument.e.a.c(r7)
                if (r2 == 0) goto Lb
                return
            Lb:
                android.content.Context r2 = com.facebook.f.f()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
                r4 = 0
                android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                r3 = 0
                java.lang.String r3 = r2.getString(r1, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                if (r3 == 0) goto L2a
                boolean r4 = r3.isEmpty()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                if (r4 == 0) goto L24
                goto L2a
            L24:
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                goto L2f
            L2a:
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                r4.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            L2f:
                r5 = 0
                long r5 = r2.getLong(r0, r5)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                com.facebook.internal.FeatureManager$Feature r3 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                boolean r3 = com.facebook.internal.FeatureManager.g(r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                if (r3 == 0) goto L49
                int r3 = r4.length()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                if (r3 == 0) goto L49
                boolean r3 = com.facebook.appevents.ml.ModelManager.a(r5)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                if (r3 != 0) goto L67
            L49:
                org.json.JSONObject r4 = com.facebook.appevents.ml.ModelManager.b()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                if (r4 != 0) goto L50
                return
            L50:
                android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                r0.apply()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            L67:
                com.facebook.appevents.ml.ModelManager.c(r4)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                com.facebook.appevents.ml.ModelManager.d()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                goto L72
            L6e:
                r0 = move-exception
                com.facebook.internal.instrument.e.a.b(r0, r7)
            L72:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.a.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                com.facebook.appevents.n.d.c();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                com.facebook.appevents.l.a.a();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Task.values().length];
            a = iArr;
            try {
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        String a;
        String b;
        @Nullable
        String c;

        /* renamed from: d  reason: collision with root package name */
        int f2334d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        float[] f2335e;

        /* renamed from: f  reason: collision with root package name */
        File f2336f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        Model f2337g;

        /* renamed from: h  reason: collision with root package name */
        private Runnable f2338h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements e.a {
            final /* synthetic */ List a;

            /* renamed from: com.facebook.appevents.ml.ModelManager$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0082a implements e.a {
                final /* synthetic */ e a;
                final /* synthetic */ Model b;

                C0082a(a aVar, e eVar, Model model) {
                    this.a = eVar;
                    this.b = model;
                }

                @Override // com.facebook.appevents.internal.e.a
                public void a(File file) {
                    e eVar = this.a;
                    eVar.f2337g = this.b;
                    eVar.f2336f = file;
                    if (eVar.f2338h != null) {
                        this.a.f2338h.run();
                    }
                }
            }

            a(List list) {
                this.a = list;
            }

            @Override // com.facebook.appevents.internal.e.a
            public void a(File file) {
                Model a = Model.a(file);
                if (a != null) {
                    for (e eVar : this.a) {
                        e.e(eVar.c, eVar.a + "_" + eVar.f2334d + "_rule", new C0082a(this, eVar, a));
                    }
                }
            }
        }

        e(String str, String str2, @Nullable String str3, int i2, @Nullable float[] fArr) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f2334d = i2;
            this.f2335e = fArr;
        }

        @Nullable
        static e c(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new e(jSONObject.getString("use_case"), jSONObject.getString("asset_uri"), jSONObject.optString("rules_uri", null), jSONObject.getInt("version_id"), ModelManager.e(jSONObject.getJSONArray("thresholds")));
            } catch (Exception unused) {
                return null;
            }
        }

        private static void d(String str, int i2) {
            File[] listFiles;
            File a2 = com.facebook.appevents.ml.c.a();
            if (a2 == null || (listFiles = a2.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            String str2 = str + "_" + i2;
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith(str) && !name.startsWith(str2)) {
                    file.delete();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void e(String str, String str2, e.a aVar) {
            File file = new File(com.facebook.appevents.ml.c.a(), str2);
            if (str != null && !file.exists()) {
                new com.facebook.appevents.internal.e(str, file, aVar).execute(new String[0]);
            } else {
                aVar.a(file);
            }
        }

        static void f(e eVar, List<e> list) {
            d(eVar.a, eVar.f2334d);
            e(eVar.b, eVar.a + "_" + eVar.f2334d, new a(list));
        }

        e g(Runnable runnable) {
            this.f2338h = runnable;
            return this;
        }
    }

    static /* synthetic */ boolean a(long j2) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return false;
        }
        try {
            return l(j2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return false;
        }
    }

    static /* synthetic */ JSONObject b() {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            return i();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    static /* synthetic */ void c(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return;
        }
        try {
            f(jSONObject);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
        }
    }

    static /* synthetic */ void d() {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return;
        }
        try {
            h();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
        }
    }

    static /* synthetic */ float[] e(JSONArray jSONArray) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            return m(jSONArray);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    private static void f(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    e c2 = e.c(jSONObject.getJSONObject(keys.next()));
                    if (c2 != null) {
                        a.put(c2.a, c2);
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
        }
    }

    public static void g() {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return;
        }
        try {
            x.q0(new a());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
        }
    }

    private static void h() {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = null;
            int i2 = 0;
            for (Map.Entry<String, e> entry : a.entrySet()) {
                String key = entry.getKey();
                if (key.equals(Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                    e value = entry.getValue();
                    str = value.b;
                    i2 = Math.max(i2, value.f2334d);
                    if (FeatureManager.g(FeatureManager.Feature.SuggestedEvents) && k()) {
                        value.g(new b());
                        arrayList.add(value);
                    }
                }
                if (key.equals(Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                    e value2 = entry.getValue();
                    String str2 = value2.b;
                    int max = Math.max(i2, value2.f2334d);
                    if (FeatureManager.g(FeatureManager.Feature.IntelligentIntegrity)) {
                        value2.g(new c());
                        arrayList.add(value2);
                    }
                    str = str2;
                    i2 = max;
                }
            }
            if (str == null || i2 <= 0 || arrayList.isEmpty()) {
                return;
            }
            e.f(new e("MTML", str, null, i2, null), arrayList);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
        }
    }

    @Nullable
    private static JSONObject i() {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
            GraphRequest J = GraphRequest.J(null, String.format("%s/model_asset", f.g()), null);
            J.a0(true);
            J.Z(bundle);
            JSONObject h2 = J.g().h();
            if (h2 == null) {
                return null;
            }
            return n(h2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    @Nullable
    public static File j(Task task) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            e eVar = a.get(task.toUseCase());
            if (eVar == null) {
                return null;
            }
            return eVar.f2336f;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    private static boolean k() {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return false;
        }
        try {
            Locale D = x.D();
            if (D != null) {
                if (!D.getLanguage().contains("en")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return false;
        }
    }

    private static boolean l(long j2) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class) || j2 == 0) {
            return false;
        }
        try {
            return System.currentTimeMillis() - j2 < ((long) b.intValue());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return false;
        }
    }

    @Nullable
    private static float[] m(@Nullable JSONArray jSONArray) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class) || jSONArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    fArr[i2] = Float.parseFloat(jSONArray.getString(i2));
                } catch (JSONException unused) {
                }
            }
            return fArr;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    private static JSONObject n(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                    jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                    jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                    jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                    if (jSONObject3.has("rules_uri")) {
                        jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                    }
                    jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
                }
                return jSONObject2;
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    @Nullable
    public static String[] o(Task task, float[][] fArr, String[] strArr) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            e eVar = a.get(task.toUseCase());
            if (eVar != null && eVar.f2337g != null) {
                int length = strArr.length;
                int length2 = fArr[0].length;
                com.facebook.appevents.ml.a aVar = new com.facebook.appevents.ml.a(new int[]{length, length2});
                for (int i2 = 0; i2 < length; i2++) {
                    System.arraycopy(fArr[i2], 0, aVar.b(), i2 * length2, length2);
                }
                com.facebook.appevents.ml.a d2 = eVar.f2337g.d(aVar, strArr, task.toKey());
                float[] fArr2 = eVar.f2335e;
                if (d2 != null && fArr2 != null && d2.b().length != 0 && fArr2.length != 0) {
                    int i3 = d.a[task.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return null;
                        }
                        return q(d2, fArr2);
                    }
                    return p(d2, fArr2);
                }
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    @Nullable
    private static String[] p(com.facebook.appevents.ml.a aVar, float[] fArr) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            int c2 = aVar.c(0);
            int c3 = aVar.c(1);
            float[] b2 = aVar.b();
            String[] strArr = new String[c2];
            if (c3 != fArr.length) {
                return null;
            }
            for (int i2 = 0; i2 < c2; i2++) {
                strArr[i2] = PortalFollowFeeds.TYPE_NONE;
                for (int i3 = 0; i3 < fArr.length; i3++) {
                    if (b2[(i2 * c3) + i3] >= fArr[i3]) {
                        strArr[i2] = f2333d.get(i3);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }

    @Nullable
    private static String[] q(com.facebook.appevents.ml.a aVar, float[] fArr) {
        if (com.facebook.internal.instrument.e.a.c(ModelManager.class)) {
            return null;
        }
        try {
            int c2 = aVar.c(0);
            int c3 = aVar.c(1);
            float[] b2 = aVar.b();
            String[] strArr = new String[c2];
            if (c3 != fArr.length) {
                return null;
            }
            for (int i2 = 0; i2 < c2; i2++) {
                strArr[i2] = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
                for (int i3 = 0; i3 < fArr.length; i3++) {
                    if (b2[(i2 * c3) + i3] >= fArr[i3]) {
                        strArr[i2] = c.get(i3);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, ModelManager.class);
            return null;
        }
    }
}
