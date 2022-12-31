package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TapjoyConstants;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;
import com.tencent.tauth.AuthActivity;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: NetApiImpl.java */
/* loaded from: classes.dex */
public class q implements p<com.bytedance.sdk.openadsdk.c.a> {

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f1737g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f1738h = true;
    private final Context a;

    /* renamed from: e  reason: collision with root package name */
    private long f1740e;

    /* renamed from: f  reason: collision with root package name */
    private int f1741f;
    private final ExecutorService c = Executors.newFixedThreadPool(1);
    private final boolean b = f();

    /* renamed from: d  reason: collision with root package name */
    private final String f1739d = i();

    /* compiled from: NetApiImpl.java */
    /* loaded from: classes.dex */
    public static class a {
        final int a;
        final long b;
        final long c;

        /* renamed from: d  reason: collision with root package name */
        final int f1748d;

        /* renamed from: e  reason: collision with root package name */
        final String f1749e;

        /* renamed from: f  reason: collision with root package name */
        final int f1750f;

        /* renamed from: g  reason: collision with root package name */
        final String f1751g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.d.a f1752h;

        /* renamed from: i  reason: collision with root package name */
        final String f1753i;

        private a(String str, int i2, int i3, String str2, int i4, String str3, @Nullable com.bytedance.sdk.openadsdk.core.d.a aVar, long j2, long j3) {
            this.a = i2;
            this.f1748d = i3;
            this.f1749e = str2;
            this.f1751g = str3;
            this.f1752h = aVar;
            this.f1753i = str;
            this.f1750f = i4;
            this.b = j2;
            this.c = j3;
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot) {
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt("reason");
            com.bytedance.sdk.openadsdk.core.d.a a = c.a(jSONObject, adSlot);
            if (a != null) {
                a.a(jSONObject.optLong("request_after"));
            }
            return new a(optString, optInt, optInt2, optString2, optInt3, optString3, a, optLong, optLong2);
        }
    }

    /* compiled from: NetApiImpl.java */
    /* loaded from: classes.dex */
    public static class b {
        public final int a;
        public final boolean b;
        public final com.bytedance.sdk.openadsdk.core.d.m c;

        private b(int i2, boolean z, com.bytedance.sdk.openadsdk.core.d.m mVar) {
            this.a = i2;
            this.b = z;
            this.c = mVar;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
            if (optJSONObject != null) {
                try {
                    mVar.a(optJSONObject.optInt("reason"));
                    mVar.b(optJSONObject.optInt("corp_type"));
                    mVar.c(optJSONObject.optInt("reward_amount"));
                    mVar.a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new b(optInt, optBoolean, mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        this.a = context;
    }

    private int a(int i2) {
        return 10000;
    }

    private static String b(int i2) {
        return i2 != 120 ? i2 != 160 ? i2 != 240 ? i2 != 320 ? i2 != 480 ? i2 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        int f2 = h.b().f();
        if ((o.h().u() == -1 && ab.m()) || o.h().u() == 1) {
            if (f2 == 1 || f2 == -1 || h.b().g() == 1) {
                return;
            }
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, d());
        } else if (o.h().u() == 1 && f2 == 0) {
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, d());
        } else {
            boolean z = false;
            boolean z2 = o.h().u() == 1 && (f2 == 1 || f2 == -1);
            if (o.h().u() == -1 && f2 == 1) {
                z = true;
            }
            if (z2 || z || h.b().g() == 1) {
                return;
            }
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, d());
        }
    }

    private boolean d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase(FirebaseAnalytics.Param.SUCCESS);
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private void e(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", ab.f());
            jSONObject.put("version_code", ab.g());
            jSONObject.put("version", ab.h());
        } catch (Exception unused) {
        }
    }

    private static boolean f() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String g() {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.sdk.openadsdk.utils.u.e()) {
                sb.append("MIUI-");
            } else if (com.bytedance.sdk.openadsdk.utils.u.b()) {
                sb.append("FLYME-");
            } else {
                String n = com.bytedance.sdk.openadsdk.utils.u.n();
                if (com.bytedance.sdk.openadsdk.utils.u.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append(PGTransHeader.CONNECTOR);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static int h() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String i() {
        return com.bytedance.sdk.openadsdk.utils.g.b(this.a) ? "tv" : com.bytedance.sdk.openadsdk.utils.g.a(this.a) ? "android_pad" : TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE;
    }

    private String j() {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a();
        return a2 == null ? com.bytedance.sdk.openadsdk.core.b.a() : a2;
    }

    private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AuthActivity.ACTION_KEY, "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "3.1.5.4");
            jSONObject2.put(JsonMarshaller.EXTRA, hVar.M());
            jSONObject2.put("filter_words", b(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String d() {
        return com.bytedance.sdk.openadsdk.utils.g.a(true);
    }

    private String d(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", r.a);
            jSONObject.put("openudid", j.c(this.a));
            jSONObject.put("ad_sdk_version", "3.1.5.4");
            jSONObject.put("sim_op", a(this.a));
            jSONObject.put("root", this.b ? 1 : 0);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, h());
            jSONObject.put("access", com.bytedance.sdk.openadsdk.utils.q.f(this.a));
            jSONObject.put("os", com.growingio.android.sdk.collection.Constants.PLATFORM_ANDROID);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f1739d);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_MANUFACTURER, Build.MANUFACTURER);
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("resolution", ac.d(this.a) + "x" + ac.c(this.a));
            jSONObject.put("display_density", b(ac.f(this.a)));
            jSONObject.put("density_dpi", ac.f(this.a));
            jSONObject.put("device_id", j.a(this.a));
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, "1371");
            jSONObject.put("rom", g());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", j.e(this.a));
            jSONObject.put("ut", this.f1741f);
            jSONObject.put("uid", this.f1740e);
            jSONObject.put("google_aid", d.a.a.a.a.b.a.a().e());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|2|3|(15:8|9|(1:(1:14))(2:39|(1:44))|15|16|(1:20)|22|(1:24)|25|(1:28)|29|30|(1:32)(1:37)|33|34)|45|9|(0)(0)|15|16|(2:18|20)|22|(0)|25|(1:28)|29|30|(0)(0)|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b A[Catch: all -> 0x013c, TryCatch #0 {all -> 0x013c, blocks: (B:3:0x000b, B:5:0x0012, B:8:0x001b, B:13:0x0029, B:15:0x002d, B:27:0x006f, B:29:0x008b, B:30:0x0094, B:33:0x00db, B:34:0x00eb, B:37:0x0121, B:39:0x0133, B:38:0x0128, B:19:0x0037, B:21:0x003b, B:9:0x001e), top: B:43:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0121 A[Catch: all -> 0x013c, TRY_ENTER, TryCatch #0 {all -> 0x013c, blocks: (B:3:0x000b, B:5:0x0012, B:8:0x001b, B:13:0x0029, B:15:0x002d, B:27:0x006f, B:29:0x008b, B:30:0x0094, B:33:0x00db, B:34:0x00eb, B:37:0x0121, B:39:0x0133, B:38:0x0128, B:19:0x0037, B:21:0x003b, B:9:0x001e), top: B:43:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0128 A[Catch: all -> 0x013c, TryCatch #0 {all -> 0x013c, blocks: (B:3:0x000b, B:5:0x0012, B:8:0x001b, B:13:0x0029, B:15:0x002d, B:27:0x006f, B:29:0x008b, B:30:0x0094, B:33:0x00db, B:34:0x00eb, B:37:0x0121, B:39:0x0133, B:38:0x0128, B:19:0x0037, B:21:0x003b, B:9:0x001e), top: B:43:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r11, com.bytedance.sdk.openadsdk.core.d.i r12, int r13) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.d.i, int):org.json.JSONObject");
    }

    @NonNull
    private Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpRequest.HEADER_CONTENT_TYPE, "application/json; charset=utf-8");
        if (b(str)) {
            hashMap.put(HttpRequest.HEADER_CONTENT_ENCODING, "union_sdk_encode");
        }
        return hashMap;
    }

    private JSONArray b(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord filterWord : list) {
            jSONArray.put(filterWord.getId());
        }
        return jSONArray;
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coppa", h.b().g());
            jSONObject.put("gdpr", h.b().f());
            jSONObject.put("is_gdpr_user", o.h().u());
            a(jSONObject, "keywords", h.b().i());
            a(jSONObject, "data", h.b().j());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", h.b().c());
            jSONObject.put("name", h.b().d());
            e(jSONObject);
            ab.a(jSONObject, false);
            jSONObject.put("is_paid_app", h.b().h());
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.utils.c.a(this.a));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.c.h b(JSONObject jSONObject) {
        int i2;
        boolean z;
        int i3;
        com.bytedance.sdk.adnet.core.m mVar;
        if (com.bytedance.sdk.openadsdk.core.g.g.a() && jSONObject != null && jSONObject.length() > 0) {
            com.bytedance.sdk.adnet.b.i a2 = com.bytedance.sdk.adnet.b.i.a();
            boolean z2 = true;
            new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/stats/batch/"), ab.a(jSONObject), a2).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).setUserAgent(r.a).build(com.bytedance.sdk.openadsdk.g.d.a(this.a).d());
            String str = "error unknown";
            boolean z3 = false;
            try {
                mVar = a2.get();
            } catch (Throwable unused) {
                i2 = 0;
                z2 = false;
            }
            if (mVar == null) {
                return new com.bytedance.sdk.openadsdk.c.h(false, 0, "error unknown", false);
            }
            T t = mVar.a;
            if (t != 0) {
                int optInt = ((JSONObject) t).optInt("code", -1);
                str = ((JSONObject) mVar.a).optString("data", "");
                z = optInt == 20000;
                if (optInt != 60005) {
                    z2 = false;
                }
            } else {
                z2 = false;
                z = false;
            }
            try {
                i3 = (int) mVar.f1258h;
                try {
                    VAdError vAdError = mVar.c;
                    if (vAdError != null) {
                        str = vAdError.getMessage();
                    }
                } catch (Throwable unused2) {
                    i2 = i3;
                    z3 = z;
                    z = z3;
                    i3 = i2;
                    return new com.bytedance.sdk.openadsdk.c.h(z, i3, str, z2);
                }
            } catch (Throwable unused3) {
                z3 = z;
                i2 = 0;
            }
            return new com.bytedance.sdk.openadsdk.c.h(z, i3, str, z2);
        }
        return null;
    }

    private boolean b(p.a aVar) {
        if (!f1737g) {
            if (com.bytedance.sdk.openadsdk.utils.k.a(o.a())) {
                f1737g = true;
            } else if (aVar != null) {
                aVar.a(-15, g.a(-15));
                f1737g = false;
            }
        }
        return f1737g;
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.d.i iVar) {
        JSONArray jSONArray;
        if (iVar != null && (jSONArray = iVar.f1601d) != null) {
            try {
                jSONObject.put("source_temai_product_ids", jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    private boolean a(String str) {
        if (com.bytedance.sdk.openadsdk.core.b.b.a()) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.b.b.a(str)) {
            String b2 = com.bytedance.sdk.openadsdk.core.b.b.b();
            if (!TextUtils.isEmpty(b2)) {
                com.bytedance.sdk.openadsdk.c.d.a(this.a, b2, System.currentTimeMillis());
            }
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.d.i iVar, final int i2, final p.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            if (aVar != null) {
                aVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else if (b(aVar)) {
            com.bytedance.sdk.openadsdk.core.g.f.a((com.bytedance.sdk.openadsdk.core.g.d) null).c();
            if (aVar == null) {
                return;
            }
            if (a(adSlot.getCodeId())) {
                aVar.a(-8, g.a(-8));
            } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                try {
                    JSONObject a2 = a(new JSONObject(adSlot.getBidAdm()));
                    if (a2 == null) {
                        a(aVar);
                        return;
                    }
                    a a3 = a.a(a2, adSlot);
                    j.a(this.a, a3.f1753i);
                    int i3 = a3.f1748d;
                    if (i3 != 20000) {
                        aVar.a(i3, a3.f1749e);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.d.a aVar2 = a3.f1752h;
                    if (aVar2 == null) {
                        a(aVar);
                        return;
                    }
                    aVar2.c(a2.toString());
                    aVar.a(a3.f1752h);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.o.c("NetApiImpl", "get ad error: ", th);
                    a(aVar);
                }
            } else {
                JSONObject a4 = a(adSlot, iVar, i2);
                if (a4 == null) {
                    aVar.a(-9, g.a(-9));
                    return;
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final AtomicLong atomicLong = new AtomicLong(currentTimeMillis);
                final AtomicLong atomicLong2 = new AtomicLong(currentTimeMillis);
                new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/get_ads/"), a4, new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.q.1
                    @Override // com.bytedance.sdk.adnet.core.m.a
                    public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                        atomicLong.set(System.currentTimeMillis());
                        JSONObject a5 = q.this.a(mVar.a);
                        if (a5 == null) {
                            q.this.a(aVar);
                            q.this.a(mVar.f1255e, adSlot.getCodeId(), i2, null, -1, "mate parse_fail");
                            return;
                        }
                        try {
                            a a6 = a.a(a5, adSlot);
                            j.a(q.this.a, a6.f1753i);
                            if (a6.f1748d != 20000) {
                                if (!o.h().n() && a6.f1748d == 40029) {
                                    aVar.a(-100, g.a(-100));
                                } else {
                                    aVar.a(a6.f1748d, a6.f1749e);
                                }
                                q.this.a(mVar.f1255e, adSlot.getCodeId(), i2, a6, a6.f1748d, String.valueOf(a6.f1750f));
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.d.a aVar3 = a6.f1752h;
                            if (aVar3 == null) {
                                q.this.a(aVar);
                                q.this.a(mVar.f1255e, adSlot.getCodeId(), i2, a6, -1, "parse_fail");
                                return;
                            }
                            aVar3.c(a5.toString());
                            atomicLong2.set(System.currentTimeMillis());
                            aVar.a(a6.f1752h);
                            if (a6.f1752h.c() == null || a6.f1752h.c().isEmpty()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.d.h hVar = a6.f1752h.c().get(0);
                            String b2 = ab.b(i2);
                            HashMap hashMap = new HashMap();
                            com.bytedance.sdk.openadsdk.core.d.i iVar2 = iVar;
                            if (iVar2 != null) {
                                long j2 = iVar2.f1603f;
                                if (j2 > 0) {
                                    hashMap.put("client_start_time", Long.valueOf(currentTimeMillis - j2));
                                    hashMap.put("load_ts", Long.valueOf(iVar.f1603f));
                                    hashMap.put("total_time", Long.valueOf(atomicLong2.get() - iVar.f1603f));
                                }
                            }
                            hashMap.put("request_ts", Long.valueOf(currentTimeMillis));
                            hashMap.put("s_revice_ts", Long.valueOf(a6.b));
                            hashMap.put("s_send_ts", Long.valueOf(a6.c));
                            hashMap.put("c_revice_ts", Long.valueOf(atomicLong.get()));
                            hashMap.put("c_end_ts", Long.valueOf(atomicLong2.get()));
                            hashMap.put("network_time", Long.valueOf(mVar.f1256f));
                            hashMap.put("go_time", Long.valueOf(a6.b - currentTimeMillis));
                            hashMap.put("sever_time", Integer.valueOf(a6.a));
                            hashMap.put("back_time", Long.valueOf(atomicLong.get() - a6.c));
                            hashMap.put("client_end_time", Long.valueOf(atomicLong2.get() - atomicLong.get()));
                            com.bytedance.sdk.openadsdk.c.d.a(hVar, b2, hashMap);
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.utils.o.c("NetApiImpl", "get ad error: ", th2);
                            q.this.a(aVar);
                            q.this.a(mVar.f1255e, adSlot.getCodeId(), i2, null, -1, "parse_fail");
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.core.m.a
                    public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                        int i4;
                        VAdError vAdError = mVar.c;
                        if (vAdError instanceof com.bytedance.sdk.adnet.err.e) {
                            q.this.a(aVar);
                            q.this.a(mVar.f1255e, adSlot.getCodeId(), i2, null, -1, g.a(-1));
                            return;
                        }
                        String a5 = g.a(-2);
                        if (vAdError == null || mVar == null) {
                            i4 = -2;
                        } else {
                            a5 = vAdError.getMessage();
                            i4 = (int) mVar.f1258h;
                        }
                        aVar.a(i4, a5);
                        q.this.a(mVar.f1255e, adSlot.getCodeId(), i2, null, i4, vAdError instanceof com.bytedance.sdk.adnet.err.g ? "SocketTimeout" : a5);
                    }
                }) { // from class: com.bytedance.sdk.openadsdk.core.q.2
                    @Override // com.bytedance.sdk.adnet.core.Request
                    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                        return new HashMap();
                    }
                }.setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(a(i2)).b(0)).setUserAgent(r.a).setShouldCache(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.a).e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:10:0x002d, B:12:0x0031, B:14:0x0037, B:16:0x0043, B:22:0x006a, B:25:0x0072, B:27:0x0076, B:28:0x007a, B:30:0x0082, B:31:0x0086, B:33:0x009e, B:35:0x00a4), top: B:44:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:10:0x002d, B:12:0x0031, B:14:0x0037, B:16:0x0043, B:22:0x006a, B:25:0x0072, B:27:0x0076, B:28:0x007a, B:30:0x0082, B:31:0x0086, B:33:0x009e, B:35:0x00a4), top: B:44:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r4, java.lang.String r6, int r7, com.bytedance.sdk.openadsdk.core.q.a r8, int r9, java.lang.String r10) {
        /*
            r3 = this;
            boolean r0 = com.bytedance.sdk.openadsdk.core.g.g.a()
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L11
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.g.a(r9)
        L11:
            com.bytedance.sdk.openadsdk.f.a.b r0 = new com.bytedance.sdk.openadsdk.f.a.b
            r0.<init>()
            com.bytedance.sdk.openadsdk.f.a.c r7 = r0.a(r7)
            com.bytedance.sdk.openadsdk.f.a.b r7 = (com.bytedance.sdk.openadsdk.f.a.b) r7
            com.bytedance.sdk.openadsdk.f.a.c r7 = r7.b(r9)
            com.bytedance.sdk.openadsdk.f.a.b r7 = (com.bytedance.sdk.openadsdk.f.a.b) r7
            com.bytedance.sdk.openadsdk.f.a.c r7 = r7.f(r10)
            com.bytedance.sdk.openadsdk.f.a.b r7 = (com.bytedance.sdk.openadsdk.f.a.b) r7
            r9 = 0
            java.lang.String r10 = ""
            if (r8 == 0) goto L68
            com.bytedance.sdk.openadsdk.core.d.a r0 = r8.f1752h     // Catch: java.lang.Throwable -> La8
            if (r0 == 0) goto L68
            java.util.List r0 = r0.c()     // Catch: java.lang.Throwable -> La8
            if (r0 == 0) goto L68
            com.bytedance.sdk.openadsdk.core.d.a r0 = r8.f1752h     // Catch: java.lang.Throwable -> La8
            java.util.List r0 = r0.c()     // Catch: java.lang.Throwable -> La8
            int r0 = r0.size()     // Catch: java.lang.Throwable -> La8
            if (r0 <= 0) goto L68
            com.bytedance.sdk.openadsdk.core.d.a r9 = r8.f1752h     // Catch: java.lang.Throwable -> La8
            java.util.List r9 = r9.c()     // Catch: java.lang.Throwable -> La8
            r0 = 0
            java.lang.Object r9 = r9.get(r0)     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.core.d.h r9 = (com.bytedance.sdk.openadsdk.core.d.h) r9     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = r9.M()     // Catch: java.lang.Throwable -> La8
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La8
            if (r1 != 0) goto L66
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L66
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = "req_id"
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L66
            goto L6a
        L66:
            r1 = r10
            goto L6a
        L68:
            r0 = r10
            r1 = r0
        L6a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> La8
            if (r2 == 0) goto L7a
            if (r8 == 0) goto L7a
            com.bytedance.sdk.openadsdk.core.d.a r2 = r8.f1752h     // Catch: java.lang.Throwable -> La8
            if (r2 == 0) goto L7a
            java.lang.String r1 = r2.a()     // Catch: java.lang.Throwable -> La8
        L7a:
            com.bytedance.sdk.openadsdk.f.a.c r1 = r7.e(r1)     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.b r1 = (com.bytedance.sdk.openadsdk.f.a.b) r1     // Catch: java.lang.Throwable -> La8
            if (r9 == 0) goto L86
            java.lang.String r10 = r9.J()     // Catch: java.lang.Throwable -> La8
        L86:
            com.bytedance.sdk.openadsdk.f.a.c r9 = r1.d(r10)     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.b r9 = (com.bytedance.sdk.openadsdk.f.a.b) r9     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.c r9 = r9.g(r0)     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.b r9 = (com.bytedance.sdk.openadsdk.f.a.b) r9     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.c r6 = r9.c(r6)     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.b r6 = (com.bytedance.sdk.openadsdk.f.a.b) r6     // Catch: java.lang.Throwable -> La8
            com.bytedance.sdk.openadsdk.f.a.b r4 = r6.a(r4)     // Catch: java.lang.Throwable -> La8
            if (r8 == 0) goto La2
            int r5 = r8.a     // Catch: java.lang.Throwable -> La8
            long r5 = (long) r5     // Catch: java.lang.Throwable -> La8
            goto La4
        La2:
            r5 = 0
        La4:
            r4.b(r5)     // Catch: java.lang.Throwable -> La8
            goto Lb1
        La8:
            r4 = move-exception
            java.lang.String r5 = "NetApiImpl"
            java.lang.String r6 = "uploadAdTypeTimeOutEvent throws exception "
            com.bytedance.sdk.openadsdk.utils.o.c(r5, r6, r4)
        Lb1:
            com.bytedance.sdk.openadsdk.f.a r4 = com.bytedance.sdk.openadsdk.f.a.a()
            r4.b(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(long, java.lang.String, int, com.bytedance.sdk.openadsdk.core.q$a, int, java.lang.String):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    @WorkerThread
    public com.bytedance.sdk.openadsdk.c.h a(List<com.bytedance.sdk.openadsdk.c.a> list) {
        String message;
        VAdError vAdError;
        com.bytedance.sdk.adnet.core.m mVar = null;
        if (com.bytedance.sdk.openadsdk.core.g.g.a()) {
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            try {
                a(list.get(0));
                jSONObject.put("header", e());
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.c.a aVar : list) {
                    jSONArray.put(aVar.b);
                }
                jSONObject.put("event", jSONArray);
                jSONObject.put("_gen_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.b());
            if (!b(a2)) {
                a2 = jSONObject.toString();
            }
            String str = a2;
            com.bytedance.sdk.openadsdk.utils.o.b("adevent", "adevent is :" + jSONObject.toString());
            final Map<String, String> c = c(str);
            com.bytedance.sdk.adnet.b.i a3 = com.bytedance.sdk.adnet.b.i.a();
            new com.bytedance.sdk.adnet.b.f(1, ab.i(), str, a3) { // from class: com.bytedance.sdk.openadsdk.core.q.3
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return c;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).setUserAgent(r.a).build(com.bytedance.sdk.openadsdk.g.d.a(this.a).d());
            try {
                mVar = a3.get();
            } catch (Throwable unused2) {
            }
            boolean z2 = mVar != null && d((JSONObject) mVar.a);
            int i2 = mVar != null ? (int) mVar.f1258h : 0;
            if (z2 || i2 != 200) {
                message = (mVar == null || (vAdError = mVar.c) == null) ? "error unknown" : vAdError.getMessage();
            } else {
                message = "server say not success";
                z = true;
            }
            return new com.bytedance.sdk.openadsdk.c.h(z2, i2, message, z);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.g.g.a() && (b2 = b(hVar, list)) != null) {
            new com.bytedance.sdk.adnet.b.h(1, ab.i("/api/ad/union/dislike_event/"), ab.a(b2), null).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.g.d.a(this.a).d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.a aVar) {
        aVar.a(-1, g.a(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.b bVar) {
        bVar.a(-1, g.a(-1));
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        if (r8.f1601d == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
        r2 = r6.getAdCount();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r6, int r7, com.bytedance.sdk.openadsdk.core.d.i r8) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "id"
            java.lang.String r2 = r6.getCodeId()     // Catch: java.lang.Exception -> L86
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L86
            java.lang.String r1 = "adtype"
            r0.put(r1, r7)     // Catch: java.lang.Exception -> L86
            java.lang.String r1 = "render_method"
            r2 = 1
            if (r8 == 0) goto L1e
            int r3 = r8.f1602e     // Catch: java.lang.Exception -> L86
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L86
            goto L21
        L1e:
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L86
        L21:
            java.lang.String r1 = "ptpl_ids"
            com.bytedance.sdk.openadsdk.core.g.i r3 = com.bytedance.sdk.openadsdk.core.o.h()     // Catch: java.lang.Exception -> L86
            java.lang.String r4 = r6.getCodeId()     // Catch: java.lang.Exception -> L86
            org.json.JSONArray r3 = r3.h(r4)     // Catch: java.lang.Exception -> L86
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L86
            java.lang.String r1 = "pos"
            int r3 = com.bytedance.sdk.openadsdk.AdSlot.getPosition(r7)     // Catch: java.lang.Exception -> L86
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L86
            java.lang.String r1 = "accepted_size"
            int r3 = r6.getImgAcceptedWidth()     // Catch: java.lang.Exception -> L86
            int r4 = r6.getImgAcceptedHeight()     // Catch: java.lang.Exception -> L86
            r5.a(r0, r1, r3, r4)     // Catch: java.lang.Exception -> L86
            java.lang.String r1 = "is_support_dpl"
            boolean r3 = r6.isSupportDeepLink()     // Catch: java.lang.Exception -> L86
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L86
            int r1 = r6.getNativeAdType()     // Catch: java.lang.Exception -> L86
            if (r1 > 0) goto L5e
            r1 = 9
            if (r7 == r1) goto L5e
            r1 = 5
            if (r7 != r1) goto L63
        L5e:
            java.lang.String r1 = "is_origin_ad"
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L86
        L63:
            int r1 = r6.getAdCount()     // Catch: java.lang.Exception -> L86
            if (r1 >= r2) goto L6a
            r1 = 1
        L6a:
            r3 = 3
            if (r1 <= r3) goto L6e
            r1 = 3
        L6e:
            r3 = 7
            if (r7 == r3) goto L77
            r3 = 8
            if (r7 != r3) goto L76
            goto L77
        L76:
            r2 = r1
        L77:
            if (r8 == 0) goto L81
            org.json.JSONArray r7 = r8.f1601d     // Catch: java.lang.Exception -> L86
            if (r7 == 0) goto L81
            int r2 = r6.getAdCount()     // Catch: java.lang.Exception -> L86
        L81:
            java.lang.String r6 = "ad_count"
            r0.put(r6, r2)     // Catch: java.lang.Exception -> L86
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(com.bytedance.sdk.openadsdk.AdSlot, int, com.bytedance.sdk.openadsdk.core.d.i):org.json.JSONObject");
    }

    private void a(JSONObject jSONObject, String str, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.b) == null) {
            return;
        }
        String optString = jSONObject.optString("log_extra", "");
        long e2 = ab.e(optString);
        int f2 = ab.f(optString);
        if (e2 == 0) {
            e2 = this.f1740e;
        }
        this.f1740e = e2;
        if (f2 == 0) {
            f2 = this.f1741f;
        }
        this.f1741f = f2;
    }

    private static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(JSONObject jSONObject, final p.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            if (bVar != null) {
                bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else if (jSONObject == null || bVar == null) {
        } else {
            new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/reward_video/reward/"), ab.a(jSONObject), new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.q.4
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    JSONObject jSONObject2;
                    if (mVar != null && (jSONObject2 = mVar.a) != null) {
                        int optInt = jSONObject2.optInt("cypher", -1);
                        String optString = mVar.a.optString("message");
                        JSONObject jSONObject3 = mVar.a;
                        String str = null;
                        if (optInt == 1) {
                            str = com.bytedance.sdk.openadsdk.core.a.b(optString, com.bytedance.sdk.openadsdk.core.b.a());
                        } else if (optInt == 2) {
                            str = ab.k(optString);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject3 = new JSONObject(str);
                            } catch (Throwable unused) {
                            }
                        }
                        b a2 = b.a(jSONObject3);
                        int i2 = a2.a;
                        if (i2 != 20000) {
                            bVar.a(i2, g.a(i2));
                            return;
                        } else if (a2.c == null) {
                            q.this.a(bVar);
                            return;
                        } else {
                            bVar.a(a2);
                            return;
                        }
                    }
                    q.this.a(bVar);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    VAdError vAdError;
                    String a2 = g.a(-2);
                    int i2 = mVar != null ? (int) mVar.f1258h : -2;
                    if (mVar != null && (vAdError = mVar.c) != null) {
                        a2 = vAdError.getMessage();
                    }
                    bVar.a(i2, a2);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.g.d.a(this.a).d());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject a(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "auction_price"
            if (r8 != 0) goto L5
            return r8
        L5:
            boolean r1 = com.bytedance.sdk.openadsdk.core.q.f1738h     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L5b
            java.lang.String r1 = "cypher"
            r2 = -1
            int r1 = r8.optInt(r1, r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = "message"
            java.lang.String r2 = r8.optString(r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = ""
            java.lang.String r3 = r8.optString(r0, r3)     // Catch: java.lang.Throwable -> L5b
            r4 = 1
            if (r1 != r4) goto L28
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.b.a()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.b(r2, r5)     // Catch: java.lang.Throwable -> L5b
            goto L29
        L28:
            r5 = r2
        L29:
            r6 = 2
            if (r1 != r6) goto L4a
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4a
            int r1 = r2.length()     // Catch: java.lang.Throwable -> L5b
            r6 = 17
            if (r1 < r6) goto L4a
            java.lang.String r1 = r2.substring(r4, r6)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = r7.d(r1)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = r2.substring(r6)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.b(r2, r1)     // Catch: java.lang.Throwable -> L5b
        L4a:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L5b
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r5)
            r1.put(r0, r3)     // Catch: java.lang.Throwable -> L59
            goto L5c
        L59:
            goto L5c
        L5b:
            r1 = r8
        L5c:
            boolean r0 = com.bytedance.sdk.openadsdk.core.q.f1738h
            if (r0 == 0) goto L61
            r8 = r1
        L61:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject):org.json.JSONObject");
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.core.d.k a() {
        com.bytedance.sdk.adnet.core.m mVar;
        if (com.bytedance.sdk.openadsdk.core.g.g.a()) {
            com.bytedance.sdk.adnet.b.i a2 = com.bytedance.sdk.adnet.b.i.a();
            new com.bytedance.sdk.adnet.b.j(0, o.h().s(), a2).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).setShouldCache(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.a).d());
            try {
                mVar = a2.get();
            } catch (Exception unused) {
                mVar = null;
            }
            if (mVar == null || !mVar.a()) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.d.k.d((String) mVar.a);
        }
        return null;
    }
}
