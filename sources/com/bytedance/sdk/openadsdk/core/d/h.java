package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: MaterialMeta.java */
/* loaded from: classes.dex */
public class h {
    private Map<String, Object> A;
    private a B;
    private boolean C;
    private int D;
    private String E;
    private AdSlot J;
    private int K;
    private String M;
    private JSONObject Q;
    private int S;
    private String T;
    private int a;
    private g b;
    private g c;

    /* renamed from: d  reason: collision with root package name */
    private String f1588d;

    /* renamed from: f  reason: collision with root package name */
    private String f1590f;

    /* renamed from: j  reason: collision with root package name */
    private String f1594j;

    /* renamed from: k  reason: collision with root package name */
    private String f1595k;

    /* renamed from: l  reason: collision with root package name */
    private String f1596l;
    private b n;
    private e o;
    private int p;
    private String q;
    private String r;
    private long u;
    private int v;
    private n w;
    private boolean x;
    private boolean y;
    private int z;

    /* renamed from: e  reason: collision with root package name */
    private List<g> f1589e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private List<String> f1591g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private List<String> f1592h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private List<String> f1593i = new ArrayList();
    private String m = "0";
    private List<FilterWord> s = new ArrayList();
    private int t = 0;
    private String F = "";
    private c G = new c();
    private int H = -200;
    private int I = 0;
    private int L = 1;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int R = 1;

    /* compiled from: MaterialMeta.java */
    /* loaded from: classes.dex */
    public static class a {
        private String a;
        private String b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private String f1597d;

        /* renamed from: e  reason: collision with root package name */
        private String f1598e;

        /* renamed from: f  reason: collision with root package name */
        private String f1599f;

        /* renamed from: g  reason: collision with root package name */
        private String f1600g;

        public String a() {
            return this.f1599f;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.c;
        }

        public String e() {
            return this.f1597d;
        }

        public String f() {
            return this.f1598e;
        }

        public String g() {
            return this.f1600g;
        }

        public void a(String str) {
            this.f1599f = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.c = str;
        }

        public void e(String str) {
            this.f1597d = str;
        }

        public void f(String str) {
            this.f1598e = str;
        }

        public void g(String str) {
            this.f1600g = str;
        }
    }

    public String A() {
        return this.f1588d;
    }

    public List<g> B() {
        return this.f1589e;
    }

    public String C() {
        return this.f1590f;
    }

    public List<String> D() {
        return this.f1591g;
    }

    public List<String> E() {
        return this.f1592h;
    }

    public List<String> F() {
        return this.f1593i;
    }

    public String G() {
        return this.f1594j;
    }

    public String H() {
        return this.f1595k;
    }

    public String I() {
        return this.f1596l;
    }

    public String J() {
        return this.m;
    }

    public b K() {
        return this.n;
    }

    public e L() {
        return this.o;
    }

    public String M() {
        return this.r;
    }

    public int N() {
        return this.p;
    }

    public List<FilterWord> O() {
        return this.s;
    }

    public long P() {
        return this.u;
    }

    public int Q() {
        return this.v;
    }

    public boolean R() {
        return this.x;
    }

    public boolean S() {
        return this.y;
    }

    public Map<String, Object> T() {
        return this.A;
    }

    public JSONObject U() {
        return this.Q;
    }

    public String V() {
        return this.M;
    }

    public boolean W() {
        if (this.f1589e.isEmpty()) {
            return false;
        }
        if (this.p != 4 || this.f1589e.size() >= 3) {
            for (g gVar : this.f1589e) {
                if (!gVar.d()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean X() {
        return Y() == 1;
    }

    public int Y() {
        return this.t;
    }

    public JSONObject Z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", x());
            jSONObject.put("target_url", A());
            jSONObject.put("ad_id", J());
            jSONObject.put("source", w());
            jSONObject.put("screenshot", R());
            jSONObject.put("dislike_control", Y());
            jSONObject.put("play_bar_show_time", m());
            jSONObject.put("is_playable", r());
            jSONObject.put("playable_type", c());
            jSONObject.put("playable_style", d());
            jSONObject.put("play_bar_style", i());
            jSONObject.put("if_block_lp", a());
            jSONObject.put("cache_sort", n());
            jSONObject.put("if_sp_cache", o());
            g y = y();
            if (y != null && !TextUtils.isEmpty(y.a())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", y.a());
                jSONObject2.put("height", y.c());
                jSONObject2.put("width", y.b());
                jSONObject.put("icon", jSONObject2);
            }
            g z = z();
            if (z != null && !TextUtils.isEmpty(z.a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", z.a());
                jSONObject3.put("height", z.c());
                jSONObject3.put("width", z.b());
                jSONObject.put("cover_image", jSONObject3);
            }
            Object U = U();
            if (U != null) {
                jSONObject.put("session_params", U);
            }
            c j2 = j();
            if (j2 != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", j2.a);
                jSONObject4.put("click_upper_non_content_area", j2.b);
                jSONObject4.put("click_lower_content_area", j2.c);
                jSONObject4.put("click_lower_non_content_area", j2.f1553d);
                jSONObject4.put("click_button_area", j2.f1554e);
                jSONObject4.put("click_video_area", j2.f1555f);
                jSONObject.put("click_area", jSONObject4);
            }
            AdSlot k2 = k();
            if (k2 != null) {
                jSONObject.put("adslot", k2.toJsonObj());
            }
            List<g> B = B();
            if (B != null) {
                JSONArray jSONArray = new JSONArray();
                for (g gVar : B) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", gVar.a());
                    jSONObject5.put("height", gVar.c());
                    jSONObject5.put("width", gVar.b());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put(QiniuAuthToken.TYPE_IMAGE, jSONArray);
            }
            List<String> D = D();
            if (D != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : D) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> E = E();
            if (E != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : E) {
                    jSONArray3.put(str2);
                }
                jSONObject.put(TapjoyConstants.TJC_CLICK_URL, jSONArray3);
            }
            List<String> F = F();
            if (F != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (String str3 : F) {
                    jSONArray4.put(str3);
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", C());
            jSONObject.put("title", G());
            jSONObject.put(SocialConstants.PARAM_COMMENT, H());
            jSONObject.put("ext", M());
            jSONObject.put("image_mode", N());
            jSONObject.put("is_playable", r());
            jSONObject.put("intercept_flag", l());
            jSONObject.put("button_text", I());
            jSONObject.put("ad_logo", h());
            jSONObject.put("video_adaptation", g());
            jSONObject.put("feed_video_opentype", e());
            b K = K();
            if (K != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("app_name", K.b());
                jSONObject6.put("package_name", K.c());
                jSONObject6.put("download_url", K.a());
                jSONObject6.put(FirebaseAnalytics.Param.SCORE, K.d());
                jSONObject6.put("comment_num", K.e());
                jSONObject6.put("app_size", K.f());
                jSONObject.put("app", jSONObject6);
            }
            e L = L();
            if (L != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("deeplink_url", L.a());
                jSONObject7.put("fallback_url", L.b());
                jSONObject7.put("fallback_type", L.c());
                jSONObject.put("deep_link", jSONObject7);
            }
            List<FilterWord> O = O();
            if (O != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (FilterWord filterWord : O) {
                    JSONObject b = b(filterWord);
                    if (b != null) {
                        jSONArray5.put(b);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            jSONObject.put("count_down", Q());
            jSONObject.put("expiration_time", P());
            n v = v();
            if (v != null) {
                jSONObject.put("video", v.l());
            }
            if (T() != null) {
                JSONObject jSONObject8 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = T().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject8.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject8);
            }
            a u = u();
            if (u != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put(TapjoyAuctionFlags.AUCTION_ID, u.b());
                jSONObject9.put("md5", u.c());
                jSONObject9.put("url", u.d());
                jSONObject9.put("data", u.e());
                jSONObject9.put("diff_data", u.f());
                jSONObject9.put("version", u.a());
                jSONObject9.put("dynamic_creative", u.g());
                jSONObject.put("tpl_info", jSONObject9);
            }
            jSONObject.put("market_url", V());
            jSONObject.put("auction_price", f());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int a() {
        return this.N;
    }

    public boolean b() {
        return this.N == 1;
    }

    public int c() {
        return this.D;
    }

    public String d() {
        return this.E;
    }

    public int e() {
        return this.P;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.m.equals(hVar.m) && this.r.equals(hVar.r);
    }

    public String f() {
        return this.T;
    }

    public int g() {
        return this.O;
    }

    public int h() {
        return this.L;
    }

    public int hashCode() {
        return (this.m.hashCode() * 31) + this.r.hashCode();
    }

    public int i() {
        return this.I;
    }

    public c j() {
        return this.G;
    }

    public AdSlot k() {
        return this.J;
    }

    public int l() {
        return this.K;
    }

    public int m() {
        return this.H;
    }

    public int n() {
        return this.R;
    }

    public int o() {
        return this.S;
    }

    public boolean p() {
        n nVar = this.w;
        return nVar == null || nVar.m() != 1;
    }

    public boolean q() {
        n nVar = this.w;
        return nVar != null && nVar.n() == 1;
    }

    public boolean r() {
        return this.C;
    }

    public boolean s() {
        return r() && c() == 1;
    }

    public int t() {
        return this.z;
    }

    public a u() {
        return this.B;
    }

    public n v() {
        return this.w;
    }

    public String w() {
        return this.q;
    }

    public int x() {
        return this.a;
    }

    public g y() {
        return this.b;
    }

    public g z() {
        return this.c;
    }

    public void a(int i2) {
        this.N = i2;
    }

    public void b(int i2) {
        this.D = i2;
    }

    public void c(int i2) {
        this.P = i2;
    }

    public void d(int i2) {
        this.O = i2;
    }

    public void e(int i2) {
        this.L = i2;
    }

    public void f(int i2) {
        this.I = i2;
    }

    public void g(int i2) {
        this.K = i2;
    }

    public void h(int i2) {
        this.H = i2;
    }

    public void i(int i2) {
        this.R = i2;
    }

    public void j(int i2) {
        this.S = i2;
    }

    public void k(int i2) {
        this.z = i2;
    }

    public void l(int i2) {
        this.a = i2;
    }

    public void m(int i2) {
        this.p = i2;
    }

    public void n(int i2) {
        this.v = i2;
    }

    public void o(int i2) {
        this.t = i2;
    }

    public void a(String str) {
        this.E = str;
    }

    public void b(String str) {
        this.T = str;
    }

    public void c(String str) {
        this.q = str;
    }

    public void d(String str) {
        this.f1588d = str;
    }

    public void e(String str) {
        this.f1590f = str;
    }

    public void f(String str) {
        this.f1594j = str;
    }

    public void g(String str) {
        this.f1595k = str;
    }

    public void h(String str) {
        this.f1596l = str;
    }

    public void i(String str) {
        this.m = str;
    }

    public void j(String str) {
        this.r = str;
    }

    public void k(String str) {
        this.M = str;
    }

    public void a(c cVar) {
        this.G = cVar;
    }

    public void b(g gVar) {
        this.c = gVar;
    }

    public void c(g gVar) {
        this.f1589e.add(gVar);
    }

    public static boolean c(h hVar) {
        return hVar != null && hVar.r() && hVar.c() == 0;
    }

    public void a(AdSlot adSlot) {
        this.J = adSlot;
    }

    public void b(boolean z) {
        this.x = z;
    }

    public static boolean a(h hVar) {
        return hVar != null && hVar.r();
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = 4;
        this.m = jSONObject.optString(TapjoyAuctionFlags.AUCTION_ID);
        this.q = jSONObject.optString("source");
        b bVar = new b();
        this.n = bVar;
        bVar.c(jSONObject.optString("pkg_name"));
        this.n.b(jSONObject.optString("name"));
        this.n.a(jSONObject.optString("download_url"));
    }

    public void a(boolean z) {
        this.C = z;
    }

    public void a(a aVar) {
        this.B = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
    }

    public void a(n nVar) {
        this.w = nVar;
    }

    public void a(g gVar) {
        this.b = gVar;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    for (FilterWord filterWord2 : filterWord.getOptions()) {
                        jSONArray.put(b(filterWord2));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void a(b bVar) {
        this.n = bVar;
    }

    public void a(e eVar) {
        this.o = eVar;
    }

    public void a(FilterWord filterWord) {
        this.s.add(filterWord);
    }

    public void a(long j2) {
        this.u = j2;
    }

    public void a(Map<String, Object> map) {
        this.A = map;
    }

    public void a(JSONObject jSONObject) {
        this.Q = jSONObject;
    }

    public static boolean a(h hVar, boolean z, boolean z2) {
        n nVar;
        if (hVar != null && (nVar = hVar.w) != null && nVar.a() == 1) {
            o.b("MaterialMeta", "can show end card follow js");
            return z2;
        }
        o.b("MaterialMeta", "can show end card follow js WebViewClient");
        return z;
    }

    public static boolean b(h hVar) {
        return hVar != null && hVar.r() && hVar.c() == 1;
    }
}
