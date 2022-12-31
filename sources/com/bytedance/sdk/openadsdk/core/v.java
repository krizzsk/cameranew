package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.matrix.report.Issue;
import com.tencent.stat.DeviceInfo;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: TTAndroidObject.java */
/* loaded from: classes.dex */
public class v implements com.bytedance.sdk.openadsdk.d.b, ad.a {

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Boolean> f1761f;
    private com.bytedance.sdk.openadsdk.e.h A;
    private List<com.bytedance.sdk.openadsdk.core.d.h> C;
    private HashMap<String, i> D;
    private com.bytedance.sdk.openadsdk.c.p G;
    private String H;
    protected Map<String, Object> a;
    boolean b;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<WebView> f1762d;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Context> f1764g;

    /* renamed from: h  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.d.c f1765h;

    /* renamed from: i  reason: collision with root package name */
    private String f1766i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<View> f1767j;

    /* renamed from: k  reason: collision with root package name */
    private String f1768k;

    /* renamed from: l  reason: collision with root package name */
    private int f1769l;
    private String m;
    private int n;
    private com.bytedance.sdk.openadsdk.core.d.h p;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.j q;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.g r;
    private JSONObject s;
    private com.bytedance.sdk.openadsdk.d.d t;
    private com.bytedance.sdk.openadsdk.e.a u;
    private com.bytedance.sdk.openadsdk.e.e v;
    private com.bytedance.sdk.openadsdk.e.d w;
    private JSONObject x;
    private com.bytedance.sdk.openadsdk.core.a.d y;
    private com.bytedance.sdk.openadsdk.e.b z;
    private boolean o = true;
    private boolean B = true;
    private boolean E = false;
    private boolean F = false;
    boolean c = false;

    /* renamed from: e  reason: collision with root package name */
    private ad f1763e = new ad(Looper.getMainLooper(), this);

    /* compiled from: TTAndroidObject.java */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public String b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f1770d;

        /* renamed from: e  reason: collision with root package name */
        public int f1771e;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f1761f = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
    }

    public v(Context context) {
        this.f1764g = new WeakReference<>(context);
    }

    private void d(JSONObject jSONObject) throws Exception {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
        if (hVar == null || TextUtils.isEmpty(hVar.d())) {
            return;
        }
        jSONObject.put("playable_style", this.p.d());
    }

    private void e(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.c.p pVar;
        if (jSONObject == null || (pVar = this.G) == null) {
            return;
        }
        pVar.a(jSONObject);
    }

    private void f(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.e.b bVar = this.z;
        if (bVar == null || jSONObject == null) {
            return;
        }
        bVar.a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject) {
        if (this.r != null && jSONObject != null) {
            try {
                this.r.e(jSONObject.optBoolean("mute", false));
            } catch (Exception unused) {
            }
        }
    }

    private WebView h() {
        WeakReference<WebView> weakReference = this.f1762d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private JSONObject i() {
        try {
            View view = this.f1767j.get();
            WebView webView = this.f1762d.get();
            if (view != null && webView != null) {
                int[] b = ac.b(view);
                int[] b2 = ac.b(webView);
                if (b != null && b2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", ac.b(o.a(), b[0] - b2[0]));
                    jSONObject.put("y", ac.b(o.a(), b[1] - b2[1]));
                    jSONObject.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, ac.b(o.a(), view.getWidth()));
                    jSONObject.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, ac.b(o.a(), view.getHeight()));
                    jSONObject.put("isExist", ac.e(view));
                    return jSONObject;
                }
                com.bytedance.sdk.openadsdk.utils.o.e("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                return null;
            }
            com.bytedance.sdk.openadsdk.utils.o.e("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("TTAndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    private List<String> j() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void k() {
        com.bytedance.sdk.openadsdk.e.h hVar = this.A;
        if (hVar == null) {
            return;
        }
        hVar.a();
    }

    private void l() {
        com.bytedance.sdk.openadsdk.e.h hVar = this.A;
        if (hVar == null) {
            return;
        }
        hVar.b();
    }

    private void m() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.r;
        if (gVar != null) {
            gVar.K();
        }
    }

    private void n() {
        WeakReference<Context> weakReference = this.f1764g;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.p != null) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f1764g.get(), this.p, this.H, "open_policy");
        }
        if (TextUtils.isEmpty(o.h().q())) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.b.a(this.f1762d.get().getContext(), new Intent(this.f1762d.get().getContext(), TTWebsiteActivity.class), null);
    }

    private JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        if (o.h() != null) {
            try {
                int d2 = ab.d(this.f1768k);
                int g2 = o.h().g(String.valueOf(d2));
                int e2 = o.h().e(d2);
                boolean c = o.h().c(String.valueOf(d2));
                jSONObject.put("voice_control", o.h().b(d2));
                jSONObject.put("rv_skip_time", g2);
                jSONObject.put("fv_skip_show", c);
                jSONObject.put("iv_skip_time", e2);
                com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
                jSONObject.put("show_dislike", hVar != null && hVar.X());
                com.bytedance.sdk.openadsdk.core.d.h hVar2 = this.p;
                jSONObject.put("video_adaptation", hVar2 != null ? hVar2.g() : 0);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Context context;
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.C;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.D = new HashMap<>();
        WeakReference<WebView> weakReference = this.f1762d;
        WebView webView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.f1764g;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.h hVar : this.C) {
            this.D.put(hVar.J(), new i(context, hVar, webView));
        }
    }

    private boolean q() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
        if (hVar == null || hVar.U() == null || this.p.r() || this.E || this.p.U().optInt("parent_type") != 2) {
            return false;
        }
        int c = ab.c(this.f1768k);
        if (c == 8 || c == 7) {
            this.E = true;
            return true;
        }
        return false;
    }

    private void r() {
        if (this.f1765h == null) {
            this.f1765h = com.bytedance.sdk.openadsdk.d.a.a(this, this.p);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                h(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.2
                    @Override // java.lang.Runnable
                    public void run() {
                        v.this.h(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                j(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.3
                    @Override // java.lang.Runnable
                    public void run() {
                        v.this.j(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        i(jSONObject);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        a("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.s;
            if (jSONObject != null) {
                jSONObject.put("setting", o());
            }
            a("getTemplateInfo", false);
            return this.s.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                g(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.1
                    @Override // java.lang.Runnable
                    public void run() {
                        v.this.g(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTAndroidObject", "");
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            k(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject) {
        if (this.r != null && jSONObject != null) {
            try {
                this.r.c(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        String str;
        int i2;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d11 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                d4 = optJSONObject.optDouble("down_y", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                d5 = optJSONObject.optDouble("up_x", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                d6 = optJSONObject.optDouble("up_y", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                d7 = optJSONObject.optDouble("down_time", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double optDouble2 = optJSONObject.optDouble("up_time", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double optDouble3 = optJSONObject.optDouble("button_x", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double optDouble4 = optJSONObject.optDouble("button_y", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                double optDouble5 = optJSONObject.optDouble("button_width", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                d10 = optJSONObject.optDouble("button_height", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                d11 = optDouble;
                d3 = optDouble2;
                d8 = optDouble4;
                d9 = optDouble5;
                str = optString;
                i2 = optInt;
                d2 = optDouble3;
            } else {
                str = optString;
                i2 = optInt;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                d10 = 0.0d;
            }
            com.bytedance.sdk.openadsdk.core.d.f a2 = new f.a().d((int) d11).c((int) d4).b((int) d5).a((int) d6).b((long) d7).a((long) d3).e((int) d2).f((int) d8).g((int) d9).h((int) d10).a();
            com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar = this.q;
            int i3 = i2;
            if (jVar != null) {
                jVar.a(i3, a2);
            }
            a(str, i3, a2);
        } catch (Exception unused) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar2 = this.q;
            if (jVar2 != null) {
                jVar2.a(-1, null);
            }
        }
    }

    public v c(String str) {
        this.m = str;
        return this;
    }

    private String e(String str) {
        return this.q == null ? ab.a(this.f1769l) : str;
    }

    private void f(String str) {
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView h2 = h();
                    if (h2 != null) {
                        com.bytedance.sdk.openadsdk.utils.n.a(h2, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/")) {
                    int indexOf = str.indexOf(38, 30);
                    if (indexOf <= 0) {
                        return;
                    }
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        d(substring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void k(JSONObject jSONObject) {
        double d2;
        boolean z;
        if (this.q == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.j jVar = new com.bytedance.sdk.openadsdk.core.d.j();
        try {
            boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
            double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (optJSONObject != null) {
                d3 = optJSONObject.optDouble("width");
                d2 = optJSONObject.optDouble("height");
            } else {
                d2 = 0.0d;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.VIDEO_INFO_EVENT);
            if (optJSONObject2 != null) {
                double optDouble = optJSONObject2.optDouble("x");
                double optDouble2 = optJSONObject2.optDouble("y");
                z = optBoolean;
                double optDouble3 = optJSONObject2.optDouble("width");
                double optDouble4 = optJSONObject2.optDouble("height");
                jVar.c(optDouble);
                jVar.d(optDouble2);
                jVar.e(optDouble3);
                jVar.f(optDouble4);
            } else {
                z = optBoolean;
            }
            String optString = jSONObject.optString("message", g.a(101));
            int optInt = jSONObject.optInt("code", 101);
            jVar.a(z);
            jVar.a(d3);
            jVar.b(d2);
            jVar.a(optString);
            jVar.a(optInt);
            this.q.a(jVar);
        } catch (Exception unused) {
            jVar.a(101);
            jVar.a(g.a(101));
            this.q.a(jVar);
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.l.a(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    private void m(JSONObject jSONObject) {
        if (jSONObject == null || this.t == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.t.a(true, optJSONArray);
            } else {
                this.t.a(false, null);
            }
        } catch (Exception unused) {
            this.t.a(false, null);
        }
    }

    public v b(boolean z) {
        this.F = z;
        return this;
    }

    public v c(boolean z) {
        this.B = z;
        return this;
    }

    public void d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", a(this.C));
            a("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.f1766i)) {
            jSONObject.put("cid", this.f1766i);
        }
        if (!TextUtils.isEmpty(this.f1768k)) {
            jSONObject.put("log_extra", this.f1768k);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("download_url", this.m);
        }
        jSONObject.put("dc", TextUtils.isEmpty(o.h().t()) ? o.h().t() : "SG");
        jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, ab.c(o.a()));
    }

    public v b(String str) {
        this.f1768k = str;
        return this;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.d.c cVar = this.f1765h;
        if (cVar != null) {
            cVar.c();
        }
    }

    public v a(WebView webView) {
        this.f1762d = new WeakReference<>(webView);
        return this;
    }

    public v b(int i2) {
        this.f1769l = i2;
        return this;
    }

    public void e() {
        com.bytedance.sdk.openadsdk.d.c cVar = this.f1765h;
        if (cVar != null) {
            cVar.a();
        }
        if (q()) {
            c();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.c.p pVar) {
        this.G = pVar;
    }

    public v b(JSONObject jSONObject) {
        this.x = jSONObject;
        return this;
    }

    private void d(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                a aVar = new a();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        aVar.a = optJSONObject.optString("__msg_type", null);
                        aVar.b = optJSONObject.optString("__callback_id", null);
                        aVar.c = optJSONObject.optString("func");
                        aVar.f1770d = optJSONObject.optJSONObject("params");
                        aVar.f1771e = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(aVar.a) && !TextUtils.isEmpty(aVar.c)) {
                    Message obtainMessage = this.f1763e.obtainMessage(11);
                    obtainMessage.obj = aVar;
                    this.f1763e.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.openadsdk.utils.o.a()) {
                com.bytedance.sdk.openadsdk.utils.o.d("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.bytedance.sdk.openadsdk.utils.o.d("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    private boolean n(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", a(this.C));
        } catch (Exception unused) {
        }
        return true;
    }

    public v a(boolean z) {
        this.b = z;
        return this;
    }

    public boolean b() {
        return this.c;
    }

    private void b(final a aVar, final JSONObject jSONObject) {
        if (aVar == null) {
            return;
        }
        try {
            a(aVar.f1770d, new com.bytedance.sdk.openadsdk.e.c() { // from class: com.bytedance.sdk.openadsdk.core.v.4
                @Override // com.bytedance.sdk.openadsdk.e.c
                public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.h> list) {
                    if (z) {
                        try {
                            jSONObject.put("creatives", v.this.a(list));
                            v.this.b(aVar.b, jSONObject);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    v.this.b(aVar.b, jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    public v a(String str) {
        this.f1766i = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            o(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public v a(View view) {
        this.f1767j = new WeakReference<>(view);
        return this;
    }

    private JSONObject p(JSONObject jSONObject) {
        if (this.a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry<String, Object> entry : this.a.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.utils.o.b(e2.toString());
            }
        }
        return jSONObject;
    }

    public v a(int i2) {
        this.n = i2;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.p = hVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.b bVar) {
        this.z = bVar;
        return this;
    }

    public void c() {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.e.c() { // from class: com.bytedance.sdk.openadsdk.core.v.5
            @Override // com.bytedance.sdk.openadsdk.e.c
            public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.h> list) {
                v.this.C = list;
                v.this.p();
                v.this.d();
            }
        });
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            o(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public v a(com.bytedance.sdk.openadsdk.e.h hVar) {
        this.A = hVar;
        return this;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.d.c cVar = this.f1765h;
        if (cVar != null) {
            cVar.b();
        }
    }

    private boolean i(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.r;
        if (gVar != null && jSONObject != null) {
            double L = gVar.L();
            int M = this.r.M();
            try {
                jSONObject.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, L / 1000.0d);
                jSONObject.put("state", M);
                com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "currentTime,state:" + M);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void o(JSONObject jSONObject) {
        WebView h2;
        if (jSONObject == null || (h2 = h()) == null) {
            return;
        }
        String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")";
        com.bytedance.sdk.openadsdk.utils.n.a(h2, str);
        if (com.bytedance.sdk.openadsdk.utils.o.a()) {
            com.bytedance.sdk.openadsdk.utils.o.a("TTAndroidObject", "js_msg " + str);
        }
    }

    public boolean a() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
        return hVar != null && hVar.b();
    }

    public void b(@NonNull Uri uri) {
        long j2;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.openadsdk.utils.o.d("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                f(uri.toString());
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter(Issue.ISSUE_REPORT_TAG);
            this.H = queryParameter2;
            String queryParameter3 = uri.getQueryParameter(Constants.ScionAnalytics.PARAM_LABEL);
            long j3 = 0;
            try {
                j2 = Long.parseLong(uri.getQueryParameter(FirebaseAnalytics.Param.VALUE));
            } catch (Exception unused) {
                j2 = 0;
            }
            try {
                j3 = Long.parseLong(uri.getQueryParameter("ext_value"));
            } catch (Exception unused2) {
            }
            long j4 = j3;
            JSONObject jSONObject = null;
            String queryParameter4 = uri.getQueryParameter(JsonMarshaller.EXTRA);
            if (!TextUtils.isEmpty(queryParameter4)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(queryParameter4);
                    try {
                        jSONObject2.putOpt("ua_policy", Integer.valueOf(this.n));
                    } catch (Exception unused3) {
                    }
                    jSONObject = jSONObject2;
                } catch (Exception unused4) {
                }
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.p, queryParameter, e(queryParameter2), queryParameter3, j2, j4, "click".equals(queryParameter3) ? p(jSONObject) : jSONObject);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "handleUri exception: ", e2);
        }
    }

    public v a(Map<String, Object> map) {
        this.a = map;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        this.q = jVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar) {
        this.r = gVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.d.d dVar) {
        this.t = dVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.a.d dVar) {
        this.y = dVar;
        return this;
    }

    public v a(JSONObject jSONObject) {
        this.s = jSONObject;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.a aVar) {
        this.u = aVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.e eVar) {
        this.v = eVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.d dVar) {
        this.w = dVar;
        return this;
    }

    private void a(JSONObject jSONObject, int i2) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String str : j()) {
            jSONArray.put(str);
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
        jSONObject.put(DeviceInfo.TAG_ANDROID_ID, com.bytedance.sdk.openadsdk.a.a.b());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, com.bytedance.sdk.openadsdk.a.a.d());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(o.a()));
    }

    private void a(a aVar) throws Exception {
        JSONObject i2;
        com.bytedance.sdk.openadsdk.e.a aVar2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (NotificationCompat.CATEGORY_CALL.equals(aVar.a)) {
            JSONObject jSONObject3 = new JSONObject();
            if ("appInfo".equals(aVar.c)) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return;
                }
                a(jSONObject3, aVar.f1771e);
                b(aVar.b, jSONObject3);
            } else if ("adInfo".equals(aVar.c)) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return;
                }
                c(jSONObject3);
                b(aVar.b, jSONObject3);
            } else if ("sendLog".equals(aVar.c)) {
                JSONObject jSONObject4 = aVar.f1770d;
                if (jSONObject4 != null && (jSONObject2 = jSONObject4.getJSONObject("extJson")) != null && jSONObject2.has("category") && jSONObject2.has(Issue.ISSUE_REPORT_TAG) && jSONObject2.has(Constants.ScionAnalytics.PARAM_LABEL)) {
                    String string = jSONObject2.getString("category");
                    jSONObject2.getString(Issue.ISSUE_REPORT_TAG);
                    String string2 = jSONObject2.getString(Constants.ScionAnalytics.PARAM_LABEL);
                    long j2 = jSONObject4.getLong(FirebaseAnalytics.Param.VALUE);
                    long j3 = jSONObject4.getLong("extValue");
                    try {
                        jSONObject2.putOpt("ua_policy", Integer.valueOf(this.n));
                    } catch (Exception unused) {
                    }
                    if ("click".equals(string2)) {
                        jSONObject2 = p(jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.c.d.a(this.p, string, ab.a(this.f1769l), string2, j2, j3, jSONObject2);
                }
            } else if ("playable_style".equals(aVar.c)) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return;
                }
                d(jSONObject3);
                b(aVar.b, jSONObject3);
            } else if ("getTemplateInfo".equals(aVar.c)) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return;
                }
                JSONObject jSONObject5 = this.s;
                if (jSONObject5 != null) {
                    jSONObject5.put("setting", o());
                }
                b(aVar.b, this.s);
            } else {
                if ("getTeMaiAds".equals(aVar.c) && !TextUtils.isEmpty(aVar.b) && (jSONObject = this.x) != null) {
                    b(aVar.b, jSONObject);
                }
                if ("isViewable".equals(aVar.c)) {
                    if (TextUtils.isEmpty(aVar.b)) {
                        return;
                    }
                    jSONObject3.put("viewStatus", this.F ? 1 : 0);
                    b(aVar.b, jSONObject3);
                } else if ("getScreenSize".equals(aVar.c)) {
                    if (TextUtils.isEmpty(aVar.b) || (aVar2 = this.u) == null) {
                        return;
                    }
                    int b = aVar2.b();
                    int a2 = this.u.a();
                    jSONObject3.put("width", b);
                    jSONObject3.put("height", a2);
                    b(aVar.b, jSONObject3);
                } else if ("getCloseButtonInfo".equals(aVar.c)) {
                    if (TextUtils.isEmpty(aVar.b) || (i2 = i()) == null) {
                        return;
                    }
                    b(aVar.b, i2);
                } else {
                    if ("getVolume".equals(aVar.c)) {
                        AudioManager audioManager = (AudioManager) o.a().getSystemService("audio");
                        int i3 = -1;
                        if (audioManager != null) {
                            i3 = audioManager.getStreamVolume(3);
                            com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "音乐音量 >>>> AudioManager-->currentVolume=" + i3);
                        }
                        if (TextUtils.isEmpty(aVar.b)) {
                            return;
                        }
                        jSONObject3.put("endcard_mute", i3 <= 0);
                        b(aVar.b, jSONObject3);
                    } else if ("removeLoading".equals(aVar.c)) {
                        com.bytedance.sdk.openadsdk.e.d dVar = this.w;
                        if (dVar != null) {
                            dVar.a();
                        }
                    } else {
                        if ("sendReward".equals(aVar.c)) {
                            this.c = true;
                            com.bytedance.sdk.openadsdk.e.e eVar = this.v;
                            if (eVar != null) {
                                eVar.a();
                            }
                        }
                        boolean a3 = a(aVar, jSONObject3);
                        if (!TextUtils.isEmpty(aVar.b) && a3) {
                            b(aVar.b, jSONObject3);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(a aVar, JSONObject jSONObject) {
        Context context;
        WeakReference<Context> weakReference;
        Context context2;
        Context context3;
        if (this.b) {
            try {
                JSONObject optJSONObject = aVar.f1770d.optJSONObject("data");
                if (optJSONObject != null) {
                    com.bytedance.sdk.openadsdk.utils.o.b("download_app_ad", "替换 download_url 前 appAdJson:" + optJSONObject.toString());
                    optJSONObject.put("download_url", this.p.K().a());
                    com.bytedance.sdk.openadsdk.utils.o.c("download_app_ad", "替换 download_url 后 appAdJson::" + optJSONObject.toString());
                }
            } catch (Throwable unused) {
            }
        }
        String str = aVar.c;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2036781162:
                if (str.equals("subscribe_app_ad")) {
                    c = 0;
                    break;
                }
                break;
            case -1330994877:
                if (str.equals("pauseWebView")) {
                    c = 1;
                    break;
                }
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    c = 2;
                    break;
                }
                break;
            case -844321441:
                if (str.equals("webview_time_track")) {
                    c = 3;
                    break;
                }
                break;
            case -800853518:
                if (str.equals("clickEvent")) {
                    c = 4;
                    break;
                }
                break;
            case -511324706:
                if (str.equals("openPrivacy")) {
                    c = 5;
                    break;
                }
                break;
            case -489318846:
                if (str.equals("getMaterialMeta")) {
                    c = 6;
                    break;
                }
                break;
            case -278382602:
                if (str.equals("send_temai_product_ids")) {
                    c = 7;
                    break;
                }
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    c = '\b';
                    break;
                }
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    c = '\t';
                    break;
                }
                break;
            case 571273292:
                if (str.equals("dynamicTrack")) {
                    c = '\n';
                    break;
                }
                break;
            case 711635577:
                if (str.equals("getCurrentVideoState")) {
                    c = 11;
                    break;
                }
                break;
            case 1107374321:
                if (str.equals("pauseWebViewTimers")) {
                    c = '\f';
                    break;
                }
                break;
            case 1151744482:
                if (str.equals("muteVideo")) {
                    c = '\r';
                    break;
                }
                break;
            case 1237100796:
                if (str.equals("renderDidFinish")) {
                    c = 14;
                    break;
                }
                break;
            case 1634511418:
                if (str.equals("endcard_load")) {
                    c = 15;
                    break;
                }
                break;
            case 1713585602:
                if (str.equals("getNetworkData")) {
                    c = 16;
                    break;
                }
                break;
            case 2086000188:
                if (str.equals("skipVideo")) {
                    c = 17;
                    break;
                }
                break;
            case 2105008900:
                if (str.equals("landscape_click")) {
                    c = 18;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                r();
                WeakReference<Context> weakReference2 = this.f1764g;
                if (weakReference2 != null && (context = weakReference2.get()) != null) {
                    this.f1765h.a(context, aVar.f1770d, this.f1768k, this.f1769l, this.o);
                }
                return false;
            case 1:
                k();
                break;
            case 2:
                h(aVar.f1770d);
                break;
            case 3:
                e(aVar.f1770d);
                break;
            case 4:
                j(aVar.f1770d);
                break;
            case 5:
                com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "openPrivacy");
                n();
                break;
            case 6:
                return n(jSONObject);
            case 7:
                m(aVar.f1770d);
                break;
            case '\b':
                com.bytedance.sdk.openadsdk.core.a.d dVar = this.y;
                if (dVar != null) {
                    dVar.a(this.B);
                    return false;
                } else if (this.f1765h != null && (weakReference = this.f1764g) != null && (context2 = weakReference.get()) != null) {
                    this.f1765h.a(context2, aVar.f1770d);
                    break;
                }
                break;
            case '\t':
                com.bytedance.sdk.openadsdk.d.c cVar = this.f1765h;
                if (cVar != null) {
                    cVar.a(aVar.f1770d);
                    break;
                } else {
                    return false;
                }
            case '\n':
                l(aVar.f1770d);
                break;
            case 11:
                return i(jSONObject);
            case '\f':
                l();
                e(aVar.f1770d);
                break;
            case '\r':
                g(aVar.f1770d);
                break;
            case 14:
                k(aVar.f1770d);
                break;
            case 15:
                f(aVar.f1770d);
                break;
            case 16:
                b(aVar, jSONObject);
                break;
            case 17:
                m();
                break;
            case 18:
                WeakReference<Context> weakReference3 = this.f1764g;
                if (weakReference3 != null && (context3 = weakReference3.get()) != null && (context3 instanceof com.bytedance.sdk.openadsdk.core.video.d.b)) {
                    ((com.bytedance.sdk.openadsdk.core.video.d.b) context3).Q();
                    break;
                }
                break;
        }
        return false;
    }

    private void a(String str, boolean z) {
        if (this.G == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.G.a(str);
        } else {
            this.G.b(str);
        }
    }

    private void a(String str, int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        HashMap<String, i> hashMap;
        i iVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.D) == null || (iVar = hashMap.get(str)) == null) {
            return;
        }
        iVar.a(i2, fVar);
    }

    private void a(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.e.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            if (this.p != null && !TextUtils.isEmpty(this.f1768k)) {
                int c = ab.c(this.f1768k);
                AdSlot k2 = this.p.k();
                com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
                if (this.p.u() != null) {
                    iVar.f1602e = 2;
                }
                JSONObject U = this.p.U();
                if (U == null) {
                    U = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        U.put(next, jSONObject.opt(next));
                    }
                }
                iVar.f1604g = U;
                o.f().a(k2, iVar, c, new p.a() { // from class: com.bytedance.sdk.openadsdk.core.v.6
                    @Override // com.bytedance.sdk.openadsdk.core.p.a
                    public void a(int i2, String str) {
                        cVar.a(false, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.a
                    public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            cVar.a(true, aVar.c());
                        } else {
                            cVar.a(false, null);
                        }
                    }
                });
                return;
            }
            cVar.a(false, null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray a(List<com.bytedance.sdk.openadsdk.core.d.h> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(list.get(i2).Z());
        }
        return jSONArray;
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return f1761f.containsKey(uri.getHost());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof a) {
                try {
                    a((a) obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }
}
