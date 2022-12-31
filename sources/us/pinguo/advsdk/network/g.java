package us.pinguo.advsdk.network;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.android.pgvolley.AuthFailureError;
import com.android.pgvolley.DefaultRetryPolicy;
import com.android.pgvolley.RequestQueue;
import com.android.pgvolley.Response;
import com.android.pgvolley.VolleyError;
import com.android.pgvolley.toolbox.MultipartEntity;
import com.android.pgvolley.toolbox.MultipartRequest;
import com.android.pgvolley.toolbox.StringRequest;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.collection.Constants;
import com.tapjoy.TapjoyConstants;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.advsdk.a.u;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.utils.AdvertisingIdClient;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.common.network.HttpRequest;
/* compiled from: VolleyHelper.java */
/* loaded from: classes3.dex */
public class g {
    private static g x;
    private Context a;
    private VolleyManager b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f9086d;

    /* renamed from: e  reason: collision with root package name */
    private String f9087e;

    /* renamed from: f  reason: collision with root package name */
    private String f9088f;

    /* renamed from: g  reason: collision with root package name */
    private String f9089g;

    /* renamed from: h  reason: collision with root package name */
    private String f9090h;

    /* renamed from: i  reason: collision with root package name */
    private String f9091i;

    /* renamed from: j  reason: collision with root package name */
    private String f9092j;

    /* renamed from: k  reason: collision with root package name */
    private String f9093k;

    /* renamed from: l  reason: collision with root package name */
    private String f9094l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String t;
    private String u;
    private boolean s = false;
    private String v = "GoogleMarket";
    private String w = null;

    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    class a implements Response.Listener<String> {
        final /* synthetic */ us.pinguo.advsdk.network.b a;
        final /* synthetic */ boolean b;
        final /* synthetic */ long c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j.a.a.a.a.b f9095d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f9096e;

        a(us.pinguo.advsdk.network.b bVar, boolean z, long j2, j.a.a.a.a.b bVar2, String str) {
            this.a = bVar;
            this.b = z;
            this.c = j2;
            this.f9095d = bVar2;
            this.f9096e = str;
        }

        @Override // com.android.pgvolley.Response.Listener
        /* renamed from: a */
        public void onResponse(String str) {
            us.pinguo.advsdk.utils.b.a("请求结果:" + str);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : 0;
                if (i2 != 200) {
                    String string = jSONObject.has("message") ? jSONObject.getString("message") : "";
                    us.pinguo.advsdk.network.b bVar = this.a;
                    if (bVar != null) {
                        bVar.onFailed(i2, string);
                        return;
                    }
                    return;
                }
                if (this.a != null) {
                    this.a.onSuccess(jSONObject.getJSONObject("data").toString());
                }
                String string2 = jSONObject.has("exetime") ? jSONObject.getString("exetime") : null;
                if (this.b) {
                    g gVar = g.this;
                    String valueOf = String.valueOf(this.c);
                    String valueOf2 = String.valueOf(currentTimeMillis);
                    j.a.a.a.a.b bVar2 = this.f9095d;
                    gVar.n(valueOf, valueOf2, bVar2 != null ? String.valueOf(bVar2.b().a()) : "", string2, this.f9096e);
                }
            } catch (Exception e2) {
                us.pinguo.advsdk.network.b bVar3 = this.a;
                if (bVar3 != null) {
                    bVar3.onFailed(101, "gson parse error:" + e2.getMessage());
                }
            }
        }
    }

    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    class b implements Response.ErrorListener {
        final /* synthetic */ us.pinguo.advsdk.network.b a;

        b(g gVar, us.pinguo.advsdk.network.b bVar) {
            this.a = bVar;
        }

        @Override // com.android.pgvolley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            us.pinguo.advsdk.network.b bVar = this.a;
            if (bVar != null) {
                bVar.onFailed(volleyError.hashCode(), volleyError.getMessage());
            }
            us.pinguo.advsdk.utils.b.a("请求错误:" + volleyError.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    public class c implements Response.Listener<String> {
        final /* synthetic */ String a;
        final /* synthetic */ us.pinguo.advsdk.network.a b;
        final /* synthetic */ boolean c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f9098d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ j.a.a.a.a.b f9099e;

        c(String str, us.pinguo.advsdk.network.a aVar, boolean z, long j2, j.a.a.a.a.b bVar) {
            this.a = str;
            this.b = aVar;
            this.c = z;
            this.f9098d = j2;
            this.f9099e = bVar;
        }

        @Override // com.android.pgvolley.Response.Listener
        /* renamed from: a */
        public void onResponse(String str) {
            us.pinguo.advsdk.utils.b.a("请求结果:" + str);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : 0;
                if (i2 != 200) {
                    String string = jSONObject.has("message") ? jSONObject.getString("message") : "";
                    us.pinguo.advsdk.utils.b.a("错误url:" + this.a);
                    us.pinguo.advsdk.network.a aVar = this.b;
                    if (aVar != null) {
                        aVar.b(i2, string);
                        return;
                    }
                    return;
                }
                if (this.b != null) {
                    try {
                        this.b.c(PgAdvManager.getInstance().m().j(jSONObject.getJSONObject("data").toString(), this.b.a()));
                    } catch (Exception e2) {
                        us.pinguo.advsdk.utils.b.a("data fromJson error = " + e2);
                        this.b.c(null);
                    }
                }
                String string2 = jSONObject.has("exetime") ? jSONObject.getString("exetime") : null;
                if (this.c) {
                    g gVar = g.this;
                    String valueOf = String.valueOf(this.f9098d);
                    String valueOf2 = String.valueOf(currentTimeMillis);
                    j.a.a.a.a.b bVar = this.f9099e;
                    gVar.n(valueOf, valueOf2, bVar != null ? String.valueOf(bVar.b().a()) : "", string2, this.a);
                }
            } catch (Exception e3) {
                us.pinguo.advsdk.network.a aVar2 = this.b;
                if (aVar2 != null) {
                    aVar2.b(101, "gson parse error:" + e3.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    public class d implements Response.ErrorListener {
        final /* synthetic */ us.pinguo.advsdk.network.a a;

        d(g gVar, us.pinguo.advsdk.network.a aVar) {
            this.a = aVar;
        }

        @Override // com.android.pgvolley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            us.pinguo.advsdk.network.a aVar = this.a;
            if (aVar != null) {
                aVar.b(volleyError.hashCode(), volleyError.getMessage());
            }
            us.pinguo.advsdk.utils.b.a("请求错误:" + volleyError.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    public class e extends StringRequest {
        e(int i2, String str, Map map, Response.Listener listener, Response.ErrorListener errorListener) {
            super(i2, str, map, listener, errorListener);
        }

        @Override // com.android.pgvolley.Request
        public Map<String, String> getHeaders() throws AuthFailureError {
            if (TextUtils.isEmpty(g.this.p)) {
                return super.getHeaders();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(HttpRequest.HEADER_USER_AGENT, g.this.p);
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    public class f implements Runnable {
        final /* synthetic */ Context a;

        f(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.AdInfo a = AdvertisingIdClient.a(this.a);
                if (a != null) {
                    g.this.f9092j = a.getId();
                    PgAdvManager.getInstance().i().m(g.this.f9092j);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* renamed from: us.pinguo.advsdk.network.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0357g implements Response.Listener<String> {
        final /* synthetic */ String a;
        final /* synthetic */ us.pinguo.advsdk.network.b b;
        final /* synthetic */ boolean c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f9101d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ j.a.a.a.a.b f9102e;

        C0357g(String str, us.pinguo.advsdk.network.b bVar, boolean z, long j2, j.a.a.a.a.b bVar2) {
            this.a = str;
            this.b = bVar;
            this.c = z;
            this.f9101d = j2;
            this.f9102e = bVar2;
        }

        @Override // com.android.pgvolley.Response.Listener
        /* renamed from: a */
        public void onResponse(String str) {
            us.pinguo.advsdk.utils.b.a("请求结果:" + str);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : 0;
                if (i2 != 200) {
                    String string = jSONObject.has("message") ? jSONObject.getString("message") : "";
                    us.pinguo.advsdk.utils.b.a("错误url:" + this.a);
                    us.pinguo.advsdk.network.b bVar = this.b;
                    if (bVar != null) {
                        bVar.onFailed(i2, string);
                        return;
                    }
                    return;
                }
                if (this.b != null) {
                    this.b.onSuccess(jSONObject.getJSONObject("data").toString());
                }
                String string2 = jSONObject.has("exetime") ? jSONObject.getString("exetime") : null;
                if (this.c) {
                    g gVar = g.this;
                    String valueOf = String.valueOf(this.f9101d);
                    String valueOf2 = String.valueOf(currentTimeMillis);
                    j.a.a.a.a.b bVar2 = this.f9102e;
                    gVar.n(valueOf, valueOf2, bVar2 != null ? String.valueOf(bVar2.b().a()) : "", string2, this.a);
                }
            } catch (Exception e2) {
                us.pinguo.advsdk.network.b bVar3 = this.b;
                if (bVar3 != null) {
                    bVar3.onFailed(101, "gson parse error:" + e2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    public class h implements Response.ErrorListener {
        final /* synthetic */ us.pinguo.advsdk.network.b a;

        h(g gVar, us.pinguo.advsdk.network.b bVar) {
            this.a = bVar;
        }

        @Override // com.android.pgvolley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            us.pinguo.advsdk.network.b bVar = this.a;
            if (bVar != null) {
                bVar.onFailed(volleyError.hashCode(), volleyError.getMessage());
            }
            us.pinguo.advsdk.utils.b.a("请求错误:" + volleyError.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VolleyHelper.java */
    /* loaded from: classes3.dex */
    public class i implements Runnable {
        final /* synthetic */ Context a;

        i(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.h(this.a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f7, code lost:
        r6.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void a(android.content.Context r5, us.pinguo.advsdk.a.u r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.c     // Catch: java.lang.Throwable -> Lfc
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lfc
            if (r0 != 0) goto Lf5
            java.lang.String r0 = r4.o     // Catch: java.lang.Throwable -> Lfc
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lfc
            if (r0 != 0) goto Lf5
            android.content.Context r0 = r4.a     // Catch: java.lang.Throwable -> Lfc
            if (r0 != 0) goto L17
            goto Lf5
        L17:
            boolean r0 = r4.s     // Catch: java.lang.Throwable -> Lfc
            if (r0 == 0) goto L22
            if (r6 == 0) goto L22
            r6.b()     // Catch: java.lang.Throwable -> Lfc
            monitor-exit(r4)
            return
        L22:
            java.lang.String r0 = "4.1.0"
            r4.f9088f = r0     // Catch: java.lang.Throwable -> Lfc
            android.content.res.Resources r0 = r5.getResources()     // Catch: java.lang.Throwable -> Lfc
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch: java.lang.Throwable -> Lfc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lfc
            r1.<init>()     // Catch: java.lang.Throwable -> Lfc
            int r2 = r0.widthPixels     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Lfc
            r1.append(r2)     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r2 = "*"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lfc
            int r0 = r0.heightPixels     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lfc
            r1.append(r0)     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> Lfc
            r4.f9089g = r0     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = "GoogleMarket"
            java.lang.String r1 = r4.v     // Catch: java.lang.Throwable -> Lfc
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lfc
            if (r0 != 0) goto L68
            us.pinguo.advsdk.manager.PgAdvManager r0 = us.pinguo.advsdk.manager.PgAdvManager.getInstance()     // Catch: java.lang.Throwable -> Lfc
            us.pinguo.advsdk.a.o r0 = r0.r()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = r0.b()     // Catch: java.lang.Throwable -> Lfc
            r4.m = r0     // Catch: java.lang.Throwable -> Lfc
        L68:
            java.lang.String r0 = us.pinguo.advsdk.utils.d.e(r5)     // Catch: java.lang.Throwable -> Lfc
            r4.f9090h = r0     // Catch: java.lang.Throwable -> Lfc
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch: java.lang.Throwable -> Lfc
            int r0 = r0.getRawOffset()     // Catch: java.lang.Throwable -> Lfc
            int r0 = r0 / 1000
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lfc
            r4.f9091i = r0     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = us.pinguo.advsdk.utils.d.d(r5)     // Catch: java.lang.Throwable -> Lfc
            r4.f9093k = r0     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = us.pinguo.advsdk.utils.d.b(r5)     // Catch: java.lang.Throwable -> Lfc
            r4.f9094l = r0     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = us.pinguo.advsdk.utils.d.f(r5)     // Catch: java.lang.Throwable -> Lfc
            r4.n = r0     // Catch: java.lang.Throwable -> Lfc
            us.pinguo.advsdk.manager.PgAdvManager r0 = us.pinguo.advsdk.manager.PgAdvManager.getInstance()     // Catch: java.lang.Throwable -> Lfc
            us.pinguo.advsdk.a.e r0 = r0.i()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> Lfc
            r4.t = r0     // Catch: java.lang.Throwable -> Lfc
            us.pinguo.advsdk.manager.PgAdvManager r0 = us.pinguo.advsdk.manager.PgAdvManager.getInstance()     // Catch: java.lang.Throwable -> Lfc
            us.pinguo.advsdk.a.e r0 = r0.i()     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = r0.j()     // Catch: java.lang.Throwable -> Lfc
            r4.u = r0     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r1 = android.os.Build.DEVICE     // Catch: java.lang.Throwable -> Lfc
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lfc
            if (r2 != 0) goto Lbe
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replaceAll(r2, r3)     // Catch: java.lang.Throwable -> Lfc
        Lbe:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lfc
            if (r2 != 0) goto Lcc
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)     // Catch: java.lang.Throwable -> Lfc
        Lcc:
            r4.q = r0     // Catch: java.lang.Throwable -> Lfc
            r4.r = r1     // Catch: java.lang.Throwable -> Lfc
            java.lang.String r0 = r5.getPackageName()     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
            r4.f9086d = r0     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
            java.lang.String r1 = r4.f9086d     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
            java.lang.String r0 = r0.versionName     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
            r4.f9087e = r0     // Catch: java.lang.Exception -> Le5 java.lang.Throwable -> Lfc
        Le5:
            r4.l(r5)     // Catch: java.lang.Throwable -> Lfc
            r4.m(r5)     // Catch: java.lang.Throwable -> Lfc
            r5 = 1
            r4.s = r5     // Catch: java.lang.Throwable -> Lfc
            if (r6 == 0) goto Lf3
            r6.b()     // Catch: java.lang.Throwable -> Lfc
        Lf3:
            monitor-exit(r4)
            return
        Lf5:
            if (r6 == 0) goto Lfa
            r6.a()     // Catch: java.lang.Throwable -> Lfc
        Lfa:
            monitor-exit(r4)
            return
        Lfc:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advsdk.network.g.a(android.content.Context, us.pinguo.advsdk.a.u):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context) {
        String property;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                property = WebSettings.getDefaultUserAgent(context);
            } else {
                property = System.getProperty("http.agent");
            }
            if (property == null) {
                this.p = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if (charAt > 31 && charAt < 127) {
                    sb.append(charAt);
                }
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            this.p = sb.toString();
        } catch (Throwable unused) {
            this.p = "";
        }
        PgAdvManager.getInstance().i().k(this.p);
        PgAdvStrategyManager.getInstance().setUserAgentInit(true);
    }

    private Map<String, String> i() {
        HashMap hashMap = new HashMap();
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.c);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, this.f9087e);
        hashMap.put("pkgName", this.f9086d);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.f9088f);
        hashMap.put("os", Constants.PLATFORM_ANDROID);
        hashMap.put("osv", String.valueOf(Build.VERSION.RELEASE));
        hashMap.put("osNum", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, this.q);
        if (!TextUtils.isEmpty(this.r)) {
            hashMap.put("childDevice", this.r);
        }
        hashMap.put("screenSize", this.f9089g);
        hashMap.put("network", this.f9090h);
        hashMap.put("utcOffset", this.f9091i);
        hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, Locale.getDefault().toString());
        hashMap.put(DeviceInfo.TAG_ANDROID_ID, TextUtils.isEmpty(this.f9094l) ? "" : this.f9094l);
        hashMap.put("aaid", TextUtils.isEmpty(this.f9092j) ? "" : this.f9092j);
        hashMap.put("useragent", TextUtils.isEmpty(this.p) ? "" : this.p);
        hashMap.put("eid", TextUtils.isEmpty(this.f9093k) ? "" : this.f9093k);
        hashMap.put("channel", this.v);
        if (!TextUtils.isEmpty(this.m)) {
            hashMap.put("imei", this.m);
        }
        if (!TextUtils.isEmpty(this.w)) {
            hashMap.put("preInstall", this.w);
        }
        if (!TextUtils.isEmpty(this.t)) {
            hashMap.put("initStamp", this.t);
        }
        if (!TextUtils.isEmpty(this.u)) {
            hashMap.put("upgradeStamp", this.u);
        }
        if (!TextUtils.isEmpty(this.n)) {
            hashMap.put("oaid", this.n);
        }
        return hashMap;
    }

    private us.pinguo.advsdk.bean.a j(String str, Map<String, String> map, String str2) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            map.putAll(i());
            us.pinguo.advsdk.bean.a f2 = us.pinguo.advsdk.utils.e.f(map, str2);
            f2.f9042d = str2;
            String h2 = us.pinguo.advsdk.utils.e.h(str, map);
            f2.a = h2 + "&sig=" + f2.c;
            return f2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static g k() {
        if (x == null) {
            x = new g();
        }
        return x;
    }

    private void l(Context context) {
        this.f9092j = PgAdvManager.getInstance().i().l();
        if (TextUtils.isEmpty(this.f9094l) || "unknown".equals(this.f9094l)) {
            this.f9092j = "unknown";
        }
        new Thread(new f(context)).start();
    }

    private void m(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 24 || i2 == 25 || i2 == 16 || i2 == 17 || i2 == 19) {
            return;
        }
        us.pinguo.advsdk.utils.b.a("initUserAgent mUserAgent =" + this.p);
        if (PgAdvManager.getInstance().i().getUserAgent() != null && !TextUtils.isEmpty(PgAdvManager.getInstance().i().getUserAgent())) {
            this.p = PgAdvManager.getInstance().i().getUserAgent();
            PgAdvStrategyManager.getInstance().setUserAgentInit(false);
            us.pinguo.advsdk.utils.b.a("initUserAgent is exsited  , mUserAgent =" + this.p);
            return;
        }
        o(context);
        us.pinguo.advsdk.utils.b.a("userAgent need to get  , mUserAgent =" + this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3, String str4, String str5) {
        PgAdvManager.getInstance().r().c(str, str2, str3, str4, str5);
    }

    private void o(Context context) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            h(context);
        } else {
            new Handler(Looper.getMainLooper()).post(new i(context));
        }
    }

    private void w(int i2, String str, Map<String, String> map, us.pinguo.advsdk.network.a aVar) {
        us.pinguo.advsdk.utils.b.a(str);
        boolean a2 = PgAdvManager.getInstance().r().a(str);
        long currentTimeMillis = System.currentTimeMillis();
        j.a.a.a.a.b bVar = a2 ? new j.a.a.a.a.b(currentTimeMillis) : null;
        e eVar = new e(i2, str, map, new c(str, aVar, a2, currentTimeMillis, bVar), new d(this, aVar));
        eVar.setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1.0f));
        eVar.setSSLTimeProxy(bVar);
        RequestQueue a3 = this.b.a();
        if (a3 == null && aVar != null) {
            aVar.b(101, "requestqueue is null");
        } else {
            a3.add(eVar);
        }
    }

    private void x(int i2, String str, us.pinguo.advsdk.network.b bVar) {
        us.pinguo.advsdk.utils.b.a("secret:" + this.o + "___" + str);
        boolean a2 = PgAdvManager.getInstance().r().a(str);
        long currentTimeMillis = System.currentTimeMillis();
        j.a.a.a.a.b bVar2 = a2 ? new j.a.a.a.a.b(currentTimeMillis) : null;
        StringRequest stringRequest = new StringRequest(i2, str, new C0357g(str, bVar, a2, currentTimeMillis, bVar2), new h(this, bVar));
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 0, 1.0f));
        stringRequest.setSSLTimeProxy(bVar2);
        RequestQueue a3 = this.b.a();
        if (a3 != null) {
            a3.add(stringRequest);
        } else if (bVar != null) {
            bVar.onFailed(101, "requestqueue is null");
        }
    }

    public void b(Context context, String str, String str2, String str3, u uVar) {
        if (this.a != null) {
            if (uVar != null) {
                uVar.b();
                return;
            }
            return;
        }
        this.a = context;
        this.c = str;
        this.o = str2;
        this.v = str3;
        this.b = new VolleyManager(context);
        a(context, uVar);
    }

    public void p(String str, Map<String, String> map, us.pinguo.advsdk.network.a aVar) {
        if (!this.s) {
            us.pinguo.advsdk.utils.b.a("please init volley first");
            if (aVar != null) {
                aVar.b(102, "please init volley first");
                return;
            }
            return;
        }
        us.pinguo.advsdk.bean.a j2 = j(str, map, this.o);
        if (j2 != null && !TextUtils.isEmpty(j2.a)) {
            w(0, j2.a, null, aVar);
        } else if (aVar != null) {
            aVar.b(100, "params error");
        }
    }

    public void q(String str, us.pinguo.advsdk.network.a aVar) {
        if (!this.s) {
            us.pinguo.advsdk.utils.b.a("please init volley first");
        } else if (!TextUtils.isEmpty(str)) {
            w(0, str, null, aVar);
        } else if (aVar != null) {
            aVar.b(100, "params error");
        }
    }

    public void r(String str, Map<String, String> map, us.pinguo.advsdk.network.b bVar) {
        if (!this.s) {
            us.pinguo.advsdk.utils.b.a("please init volley first");
            return;
        }
        us.pinguo.advsdk.bean.a j2 = j(str, map, this.o);
        if (j2 != null && !TextUtils.isEmpty(j2.a)) {
            x(0, j2.a, bVar);
        } else if (bVar != null) {
            bVar.onFailed(100, "params error");
        }
    }

    public void s(String str, Map<String, String> map, File file, us.pinguo.advsdk.network.b bVar) {
        us.pinguo.advsdk.utils.b.a("secret:" + this.o + "___" + str);
        boolean a2 = PgAdvManager.getInstance().r().a(str);
        long currentTimeMillis = System.currentTimeMillis();
        j.a.a.a.a.b bVar2 = a2 ? new j.a.a.a.a.b(currentTimeMillis) : null;
        MultipartRequest multipartRequest = new MultipartRequest(str, new a(bVar, a2, currentTimeMillis, bVar2, str), new b(this, bVar));
        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1.0f));
        multipartRequest.setSSLTimeProxy(bVar2);
        MultipartEntity multiPartEntity = multipartRequest.getMultiPartEntity();
        multiPartEntity.addStringPart("data", map.get("data"));
        if (file != null) {
            multiPartEntity.addFilePart("htmlFile", file);
        }
        RequestQueue a3 = this.b.a();
        if (a3 != null) {
            a3.add(multipartRequest);
        } else if (bVar != null) {
            bVar.onFailed(101, "requestqueue is null");
        }
    }

    public void t(String str, Map<String, String> map, us.pinguo.advsdk.network.a aVar) {
        if (!this.s) {
            us.pinguo.advsdk.utils.b.a("please init volley first");
            return;
        }
        us.pinguo.advsdk.bean.a j2 = j(str, map, this.o);
        if (j2 != null && !TextUtils.isEmpty(j2.a)) {
            map.put("sig", j2.c);
            w(1, j2.a, map, aVar);
        } else if (aVar != null) {
            aVar.b(100, "params error");
        }
    }

    public void u(String str, Map<String, String> map, us.pinguo.advsdk.network.a aVar) {
        if (!this.s) {
            us.pinguo.advsdk.utils.b.a("please init volley first");
        } else if (!TextUtils.isEmpty(str)) {
            w(1, str, map, aVar);
        } else if (aVar != null) {
            aVar.b(100, "params error");
        }
    }

    public void v(String str, Map<String, String> map, Map<String, String> map2, us.pinguo.advsdk.network.a aVar) {
        if (!this.s) {
            us.pinguo.advsdk.utils.b.a("please init volley first");
            return;
        }
        us.pinguo.advsdk.bean.a j2 = j(str, map, this.o);
        if (j2 != null && !TextUtils.isEmpty(j2.a)) {
            map.put("sig", j2.c);
            w(1, j2.a, map2, aVar);
        } else if (aVar != null) {
            aVar.b(100, "params error");
        }
    }

    public void y(String str) {
        this.w = str;
    }
}
