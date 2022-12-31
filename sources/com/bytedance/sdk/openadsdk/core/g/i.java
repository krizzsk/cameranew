package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.v;
import com.google.android.gms.common.ConnectionResult;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: TTSdkSettings.java */
/* loaded from: classes.dex */
public class i implements d {

    /* renamed from: g  reason: collision with root package name */
    private static final String f1653g = ab.j();

    /* renamed from: h  reason: collision with root package name */
    private static final String f1654h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final String f1655i = null;

    /* renamed from: j  reason: collision with root package name */
    private static final String f1656j = null;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private int F;
    private String R;
    private String S;
    private int T;
    private String U;
    private int V;
    private String W;
    private String c;

    /* renamed from: e  reason: collision with root package name */
    private String f1658e;

    /* renamed from: k  reason: collision with root package name */
    private String f1660k;
    private Map<String, a> a = new HashMap();
    private Map<String, j> b = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f1657d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private Set<String> f1659f = Collections.synchronizedSet(new HashSet());

    /* renamed from: l  reason: collision with root package name */
    private int f1661l = 1;
    private int m = 0;
    private int n = 1;
    private String o = "com.oppo.market";
    private int p = 0;
    private String q = "com.huawei.appmarket";
    private int r = 1;
    private int s = 30;
    private int t = 1;
    private int u = 30;
    private int v = 10;
    private int w = 1;
    private int x = 0;
    private int y = 5;
    private int z = 2;
    private int G = 0;
    private long H = 0;
    private Set<String> I = Collections.synchronizedSet(new HashSet());
    private Set<String> J = Collections.synchronizedSet(new HashSet());
    private int K = 0;
    private int L = 1;
    private long M = 10000;
    private int N = 50;
    private int O = 30;
    private int P = 5;
    private int Q = 3600;
    private String X = null;
    private String Y = null;
    private boolean Z = false;
    private int aa = PathInterpolatorCompat.MAX_NUM_POINTS;
    private int ab = 100;

    private int a(boolean z) {
        return z ? 20 : 5;
    }

    private static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        int optInt = jSONObject.optInt("auto_play", 1);
        int optInt2 = jSONObject.optInt("voice_control", 1);
        int optInt3 = jSONObject.optInt("rv_preload", 2);
        int optInt4 = jSONObject.optInt("nv_preload", 1);
        int optInt5 = jSONObject.optInt("read_video_from_cache", 1);
        int optInt6 = jSONObject.optInt("proportion_watching", 100);
        int optInt7 = jSONObject.optInt("skip_time_displayed", 0);
        int optInt8 = jSONObject.optInt("video_skip_result", 2);
        int optInt9 = jSONObject.optInt("reg_creative_control", 1);
        int optInt10 = jSONObject.optInt("play_bar_show_time", 3);
        int optInt11 = jSONObject.optInt("rv_skip_time", -1);
        int optInt12 = jSONObject.optInt("endcard_close_time", -1);
        int optInt13 = jSONObject.optInt("playable_endcard_close_time", -1);
        int optInt14 = jSONObject.optInt("voice_control", 2);
        int optInt15 = jSONObject.optInt("if_show_win", 1);
        int optInt16 = jSONObject.optInt("sp_preload", 0);
        int optInt17 = jSONObject.optInt("stop_time", ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        int optInt18 = jSONObject.optInt("native_playable_delay", 2);
        int optInt19 = jSONObject.optInt("time_out_control", -1);
        int optInt20 = jSONObject.optInt("playable_duration_time", 20);
        int optInt21 = jSONObject.optInt("playable_close_time", -1);
        int optInt22 = jSONObject.optInt("playable_reward_type", 0);
        int optInt23 = jSONObject.optInt("reward_is_callback", 0);
        int optInt24 = jSONObject.optInt("iv_skip_time", 5);
        return a.a().a(optString).n(optInt).o(optInt2).p(optInt3).q(optInt4).r(optInt5).s(optInt6).t(optInt7).u(optInt8).v(optInt9).m(optInt10).l(optInt11).j(optInt12).i(optInt14).k(optInt13).w(optInt15).f(optInt16).g(optInt17).h(optInt18).e(optInt19).a(optInt21).d(optInt20).b(optInt22).c(optInt23).x(jSONObject.optInt("slot_type", 2)).y(optInt24).a(jSONObject.optJSONArray("parent_tpl_ids"));
    }

    private static j c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("tpl_id", "");
        String optString2 = jSONObject.optString("md5", "");
        return j.a().a(optString).b(optString2).c(jSONObject.optString("url", ""));
    }

    private void d(JSONObject jSONObject) {
        String b;
        if (jSONObject == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            b = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", f1653g);
        } else {
            b = z().b("dyn_draw_engine_url", f1653g);
        }
        this.X = jSONObject.optString("dyn_draw_engine_url", f1653g);
        o.e("TemplateManager", "settinng---TTDynamic.init().....oldDynDrawEngineUrl=" + b);
        o.e("TemplateManager", "settinng---TTDynamic.init().....newmDynDrawEngineUrl=" + this.X);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(this.X) || this.X.equals(b)) {
            return;
        }
        o.b("TemplateManager", "重新初始化模板TTDynamic.init().....");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d.a().e();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d.a().a(false);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a().g();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a().b(false);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a().b();
    }

    private void e(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("is_gdpr_user", -1);
        this.V = optInt;
        if (optInt == -1 || optInt == 1 || optInt == 0) {
            return;
        }
        this.V = -1;
    }

    private int f(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_load_type", 1);
        this.E = optInt;
        if (optInt == 0 || optInt == 1 || optInt == 2 || optInt == 3) {
            return optInt;
        }
        return 1;
    }

    private int g(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_check_type", 1);
        this.F = optInt;
        if (optInt == 0 || optInt == 1) {
            return optInt;
        }
        return 1;
    }

    private void w() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e();
        } catch (Throwable unused) {
        }
    }

    private void x() {
        if (TextUtils.isEmpty(this.f1658e)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f1658e);
            int length = jSONArray.length();
            if (length > 0) {
                this.f1659f.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    this.f1659f.add((String) jSONArray.opt(i2));
                }
            }
        } catch (Exception unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this.f1659f);
        } catch (Throwable unused2) {
        }
    }

    private void y() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.c);
            int length = jSONArray.length();
            if (length > 0) {
                this.b.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    j c = c(jSONArray.optJSONObject(i2));
                    if (c != null) {
                        this.b.put(c.a, c);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private v z() {
        return v.a("tt_sdk_settings", com.bytedance.sdk.openadsdk.core.o.a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.f1660k = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
            this.M = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", TypedValues.TransitionType.S_DURATION, 10000L);
            this.N = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
            this.f1661l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_back_dialog", 1);
            this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_progressbar", 0);
            this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook", 1);
            this.o = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_config_hook_oppo_arg1", "com.oppo.market");
            this.p = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_oppo_arg4", 0);
            this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_config_hook_huawei_arg1", "com.huawei.appmarket");
            this.r = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
            this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
            this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_enable_install_again", 1);
            this.u = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time", 30);
            this.v = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time_next", 10);
            this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
            this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_switch", 0);
            this.y = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_time", 5);
            this.z = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_count", 2);
            this.O = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pos_cache_time", 30);
            this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
            this.Q = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", 3600);
            this.f1658e = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "template_ids", (String) null);
            this.A = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
            this.B = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
            this.C = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
            this.D = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
            this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", 1);
            this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
            this.K = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", 0);
            this.L = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
            this.aa = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", (int) PathInterpolatorCompat.MAX_NUM_POINTS);
            this.ab = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
            w();
            this.c = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "tpl_infos", (String) null);
            this.G = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
            this.H = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", 0L);
            this.R = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ads_url", f1655i);
            this.S = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "app_log_url", f1654h);
            this.T = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "coppa", -99);
            com.bytedance.sdk.openadsdk.core.h.b().c(this.T);
            this.U = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "policy_url", f1656j);
            this.W = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_dev_607_en.html");
            this.V = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "isGdprUser", -1);
            this.X = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", f1653g);
            this.Y = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dc", (String) null);
            this.I.clear();
            Set<String> b = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "hit_app_list_data", (Set<String>) null);
            if (b != null && !b.isEmpty()) {
                for (String str : b) {
                    this.I.add(str);
                }
            }
            this.J.clear();
            Set<String> b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "scheme_list_data", (Set<String>) null);
            if (b2 != null && !b2.isEmpty()) {
                for (String str2 : b2) {
                    this.J.add(str2);
                }
            }
            x();
            y();
            String b3 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            if (TextUtils.isEmpty(b3)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(b3);
                int length = jSONArray.length();
                if (length > 0) {
                    this.a.clear();
                    for (int i2 = 0; i2 < length; i2++) {
                        a b4 = b(jSONArray.optJSONObject(i2));
                        if (b4 != null) {
                            this.a.put(b4.a, b4);
                        }
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        v z = z();
        this.f1660k = z.b("xpath", "");
        this.M = z.b(TypedValues.TransitionType.S_DURATION, 10000L);
        this.N = z.b("max", 50);
        this.f1661l = z.b("download_config_back_dialog", 1);
        this.m = z.b("download_config_progressbar", 0);
        this.n = z.b("download_config_hook", 1);
        this.o = z.b("download_config_hook_oppo_arg1", "com.oppo.market");
        this.p = z.b("download_config_hook_oppo_arg4", 0);
        this.q = z.b("download_config_hook_huawei_arg1", "com.huawei.appmarket");
        this.r = z.b("download_config_dl_network", 1);
        this.s = z.b("download_config_dl_size", 30);
        this.t = z.b("download_config_enable_install_again", 1);
        this.u = z.b("download_config_install_again_time", 30);
        this.v = z.b("download_config_install_again_time_next", 10);
        this.w = z.b("download_config_storage_internal", 1);
        this.x = z.b("download_config_resume_notify_switch", 0);
        this.z = z.b("download_config_resume_notify_count", 2);
        this.y = z.b("download_config_resume_notify_time", 5);
        this.O = z.b("pos_cache_time", 30);
        this.Q = z.b("fetch_template", 3600);
        this.A = z.a("ab_test_version");
        this.B = z.a("ab_test_param");
        this.P = z.b("vbtt", 5);
        this.f1658e = z.b("template_ids", (String) null);
        this.C = z.b("pyload_h5", (String) null);
        this.D = z.b("playableLoadH5Url", (String) null);
        this.E = z.b("splash_load_type", 1);
        this.F = z.b("splash_check_type", 1);
        this.K = z.b("if_both_open", 0);
        this.L = z.b("support_tnc", 1);
        this.c = z.b("tpl_infos", (String) null);
        this.G = z.b("app_list_control", 0);
        this.aa = z.b("fetch_tpl_timeout_ctrl", PathInterpolatorCompat.MAX_NUM_POINTS);
        this.ab = z.b("max_tpl_cnts", 100);
        w();
        this.H = z.b("hit_app_list_time", 0L);
        this.R = z.a("ads_url");
        this.S = z.a("app_log_url");
        this.T = z.b("coppa", -99);
        com.bytedance.sdk.openadsdk.core.h.b().c(this.T);
        this.U = z.b("policy_url", f1656j);
        this.W = z.b("consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_dev_607_en.html");
        this.X = z.b("dyn_draw_engine_url", f1653g);
        this.Y = z.a("dc");
        this.V = z.b("isGdprUser", -1);
        this.I.clear();
        Set<String> b5 = z.b("hit_app_list_data", (Set<String>) null);
        if (b5 != null && !b5.isEmpty()) {
            for (String str3 : b5) {
                this.I.add(str3);
            }
        }
        this.J.clear();
        Set<String> b6 = z.b("scheme_list_data", (Set<String>) null);
        if (b6 != null && !b6.isEmpty()) {
            for (String str4 : b6) {
                this.J.add(str4);
            }
        }
        x();
        y();
        String b7 = z.b("ad_slot_conf", (String) null);
        if (TextUtils.isEmpty(b7)) {
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONArray(b7);
            int length2 = jSONArray2.length();
            if (length2 > 0) {
                this.a.clear();
                for (int i3 = 0; i3 < length2; i3++) {
                    a b8 = b(jSONArray2.optJSONObject(i3));
                    if (b8 != null) {
                        this.a.put(b8.a, b8);
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public long h() {
        return this.M;
    }

    public int i() {
        return this.N;
    }

    public int j() {
        return this.Q;
    }

    public String k() {
        return this.C;
    }

    public String l() {
        return this.D;
    }

    public int m() {
        if (this.aa <= 0) {
            this.aa = PathInterpolatorCompat.MAX_NUM_POINTS;
        }
        return this.aa;
    }

    public boolean n() {
        return this.Z;
    }

    public int o(String str) {
        if (str == null) {
            return 20;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).u;
    }

    public int p(String str) {
        if (str == null) {
            return -1;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).n;
    }

    public boolean q(String str) {
        return str == null || com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).f1637f == 1;
    }

    public String r() {
        return this.W;
    }

    public String s() {
        return this.X;
    }

    public String t() {
        return this.Y;
    }

    public int u() {
        return this.V;
    }

    public int v() {
        return this.P;
    }

    private a t(String str) {
        return a.a().a(str).n(1).o(!this.f1657d.contains(str) ? 1 : 0).p(2).q(1).r(1).s(100).t(0).v(1).m(3).l(-1).j(-1).i(2).k(-1).w(1).e(-1).a(-1).d(20).x(2).y(5).a((JSONArray) null);
    }

    public String f() {
        return this.B;
    }

    public String g() {
        return this.f1660k;
    }

    public JSONArray h(String str) {
        try {
            a r = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str));
            if (r != null && r.z != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : r.z) {
                    l a = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str2);
                    if (a != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, a.b());
                        jSONObject.put("md5", a.c());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean i(String str) {
        try {
            a r = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str));
            if (r != null) {
                return r.z != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean j(String str) {
        try {
            a r = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str));
            if (r != null) {
                return r.A == 8;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int k(String str) {
        return r(String.valueOf(str)).f1640i;
    }

    public int l(String str) {
        return r(str).f1642k;
    }

    public boolean n(String str) {
        return r(String.valueOf(str)).y == 0;
    }

    public a r(String str) {
        a aVar = this.a.get(str);
        return aVar == null ? t(str) : aVar;
    }

    public void s(String str) {
        this.f1657d.add(str);
    }

    public String e() {
        return this.A;
    }

    public int f(String str) {
        return str == null ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).r;
    }

    public int g(String str) {
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).f1643l;
    }

    public String o() {
        return this.R;
    }

    public String p() {
        return this.S;
    }

    public String q() {
        return this.U;
    }

    public boolean e(String str) {
        return str == null || com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).p == 1;
    }

    public int m(String str) {
        if (str == null) {
            return -1;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).m;
    }

    public int e(int i2) {
        return r(String.valueOf(i2)).x;
    }

    public boolean c() {
        return this.K == 1;
    }

    public boolean c(String str) {
        return r(String.valueOf(str)).f1639h == 1;
    }

    public int c(int i2) {
        return r(String.valueOf(i2)).b;
    }

    public boolean d() {
        return this.L == 1;
    }

    public int d(String str) {
        return r(String.valueOf(str)).t;
    }

    public int d(int i2) {
        return r(String.valueOf(i2)).f1641j;
    }

    public int b() {
        return this.ab;
    }

    public boolean b(String str) {
        int i2 = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).f1636e;
        if (i2 != 1) {
            return i2 == 2 && q.c(com.bytedance.sdk.openadsdk.core.o.a()) != 0;
        }
        return q.d(com.bytedance.sdk.openadsdk.core.o.a());
    }

    public boolean b(int i2) {
        return i2 != 0 && com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(i2)).o == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a(@NonNull JSONObject jSONObject) {
        String str;
        this.f1660k = jSONObject.optString("xpath");
        this.O = jSONObject.optInt("pos_cache_time", 30);
        JSONObject optJSONObject = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject != null) {
            this.M = optJSONObject.optLong(TypedValues.TransitionType.S_DURATION) * 1000;
            this.N = optJSONObject.optInt("max");
        }
        this.P = jSONObject.optInt("vbtt", 5);
        this.Q = jSONObject.optInt("fetch_tpl_interval", 3600);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("abtest");
        if (optJSONObject2 != null) {
            this.A = optJSONObject2.optString("version");
            this.B = optJSONObject2.optString("param");
        } else {
            this.B = null;
            this.A = null;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_version");
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_param");
            } else {
                v z = z();
                z.b("ab_test_version");
                z.b("ab_test_param");
            }
        }
        this.C = jSONObject.optString("pyload_h5");
        this.D = jSONObject.optString("pure_pyload_h5");
        this.R = jSONObject.optString("ads_url");
        this.S = jSONObject.optString("app_log_url");
        this.T = jSONObject.optInt("coppa", -99);
        com.bytedance.sdk.openadsdk.core.h.b().c(this.T);
        this.U = jSONObject.optString("privacy_url", f1656j);
        this.W = jSONObject.optString("consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_dev_607_en.html");
        this.Y = jSONObject.optString("dc");
        d(jSONObject);
        e(jSONObject);
        this.E = f(jSONObject);
        o.e("splashLoad", "setting-》mSplashLoadType=" + this.E);
        this.F = g(jSONObject);
        o.e("splashLoad", "setting-》mSplashCheckType=" + this.F);
        this.K = jSONObject.optInt("if_both_open", 0);
        this.L = jSONObject.optInt("support_tnc", 1);
        this.G = jSONObject.optInt("al", 0);
        this.ab = jSONObject.optInt("max_tpl_cnts", 100);
        w();
        JSONObject optJSONObject3 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject3 != null) {
            this.aa = optJSONObject3.optInt("fetch_tpl_timeout_ctrl", PathInterpolatorCompat.MAX_NUM_POINTS);
        }
        this.H = System.currentTimeMillis();
        this.I.clear();
        JSONArray optJSONArray = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    this.I.add(optString);
                }
            }
        }
        this.J.clear();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("scheme_check_list");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                String optString2 = optJSONArray2.optString(i3);
                if (!TextUtils.isEmpty(optString2)) {
                    this.J.add(optString2);
                }
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("download_config");
        if (optJSONObject4 != null) {
            this.f1661l = optJSONObject4.optInt("is_enable_back_dialog", 1);
            this.m = optJSONObject4.optInt("landing_page_progressbar_visible", 0);
            this.n = optJSONObject4.optInt("hook", 1);
            this.o = optJSONObject4.optString("hook_oppo_arg1", "com.oppo.market");
            this.p = optJSONObject4.optInt("hook_oppo_arg4", 0);
            this.q = optJSONObject4.optString("hook_huawei_arg1", "com.huawei.appmarket");
            this.r = optJSONObject4.optInt("dl_network", 1);
            this.s = optJSONObject4.optInt("dl_size", 30);
            this.t = optJSONObject4.optInt("is_enable_start_install_again", 1);
            this.u = optJSONObject4.optInt("start_install_time", 30);
            this.v = optJSONObject4.optInt("next_install_min_time", 10);
            this.w = optJSONObject4.optInt("if_storage_internal", 1);
            this.x = optJSONObject4.optInt("if_tips", 0);
            this.y = optJSONObject4.optInt("min_failed_time", 5);
            this.z = optJSONObject4.optInt("max_failes_count", 2);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("tpl_ids");
        if (optJSONArray3 != null) {
            this.f1658e = optJSONArray3.toString();
            x();
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray4 != null) {
            str = optJSONArray4.toString();
            int length3 = optJSONArray4.length();
            if (length3 > 0) {
                this.a.clear();
                for (int i4 = 0; i4 < length3; i4++) {
                    a b = b(optJSONArray4.optJSONObject(i4));
                    if (b != null) {
                        this.a.put(b.a, b);
                    }
                }
            }
        } else {
            str = null;
        }
        JSONArray optJSONArray5 = jSONObject.optJSONArray("tpl_infos");
        if (optJSONArray5 != null) {
            this.c = optJSONArray5.toString();
            int length4 = optJSONArray5.length();
            if (length4 > 0) {
                this.b.clear();
                for (int i5 = 0; i5 < length4; i5++) {
                    j c = c(optJSONArray5.optJSONObject(i5));
                    if (c != null) {
                        this.b.put(c.a, c);
                        a(c);
                    }
                }
            }
        }
        a(str, (String) null);
        this.Z = true;
    }

    public int a(String str) {
        if (str == null) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).w;
    }

    private void a(j jVar) {
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(jVar);
    }

    private void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "xpath", this.f1660k);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", TypedValues.TransitionType.S_DURATION, Long.valueOf(this.M));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", Integer.valueOf(this.N));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_back_dialog", Integer.valueOf(this.f1661l));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_progressbar", Integer.valueOf(this.m));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook", Integer.valueOf(this.n));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_oppo_arg1", this.o);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_oppo_arg4", Integer.valueOf(this.p));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_huawei_arg1", this.q);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.r));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.s));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_enable_install_again", Integer.valueOf(this.t));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time", Integer.valueOf(this.u));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time_next", Integer.valueOf(this.v));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.w));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_switch", Integer.valueOf(this.x));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_time", Integer.valueOf(this.y));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_count", Integer.valueOf(this.z));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pos_cache_time", Integer.valueOf(this.O));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.P));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.Q));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", Integer.valueOf(this.E));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.F));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.K));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.L));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pyload_h5", this.C);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "playableLoadH5Url", this.D);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.G));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.ab));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.aa));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.H));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_data", this.I);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "scheme_list_data", this.J);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ads_url", this.R);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_log_url", this.S);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "coppa", Integer.valueOf(this.T));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "policy_url", this.U);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "consent_url", this.W);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dyn_draw_engine_url", this.X);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dc", this.Y);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "isGdprUser", Integer.valueOf(this.V));
            if (!TextUtils.isEmpty(this.A)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_version", this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_param", this.B);
            }
            if (!TextUtils.isEmpty(str)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ad_slot_conf", str);
            }
            if (!TextUtils.isEmpty(this.f1658e)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "template_ids", this.f1658e);
            }
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "tpl_infos", this.c);
            return;
        }
        v z = z();
        z.a("xpath", this.f1660k);
        z.a(TypedValues.TransitionType.S_DURATION, this.M);
        z.a("max", this.N);
        z.a("download_config_back_dialog", this.f1661l);
        z.a("download_config_progressbar", this.m);
        z.a("download_config_hook", this.n);
        z.a("download_config_hook_oppo_arg1", this.o);
        z.a("download_config_hook_oppo_arg4", this.p);
        z.a("download_config_hook_huawei_arg1", this.q);
        z.a("download_config_dl_network", this.r);
        z.a("download_config_dl_size", this.s);
        z.a("download_config_enable_install_again", this.t);
        z.a("download_config_install_again_time", this.u);
        z.a("download_config_install_again_time_next", this.v);
        z.a("download_config_storage_internal", this.w);
        z.a("download_config_resume_notify_switch", this.x);
        z.a("download_config_resume_notify_time", this.y);
        z.a("download_config_resume_notify_count", this.z);
        z.a("pos_cache_time", this.O);
        z.a("fetch_template", this.Q);
        z.a("pyload_h5", this.C);
        z.a("playableLoadH5Url", this.D);
        z.a("splash_load_type", this.E);
        z.a("splash_check_type", this.F);
        z.a("if_both_open", this.K);
        z.a("support_tnc", this.L);
        z.a("app_list_control", this.G);
        z.a("max_tpl_cnts", this.ab);
        z.a("fetch_tpl_timeout_ctrl", this.aa);
        z.a("hit_app_list_time", this.H);
        z.a("hit_app_list_data", this.I);
        z.a("scheme_list_data", this.J);
        z.a("ads_url", this.R);
        z.a("app_log_url", this.S);
        z.a("coppa", this.T);
        z.a("policy_url", this.U);
        z.a("consent_url", this.W);
        z.a("dyn_draw_engine_url", this.X);
        z.a("dc", this.Y);
        z.a("isGdprUser", this.V);
        if (!TextUtils.isEmpty(this.A)) {
            z.a("ab_test_version", this.A);
        }
        if (!TextUtils.isEmpty(this.B)) {
            z.a("ab_test_param", this.B);
        }
        z.a("vbtt", this.P);
        if (!TextUtils.isEmpty(str)) {
            z.a("ad_slot_conf", str);
        }
        if (!TextUtils.isEmpty(this.f1658e)) {
            z.a("template_ids", this.f1658e);
        }
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        z.a("tpl_infos", this.c);
    }

    public boolean a(int i2) {
        return r(String.valueOf(i2)).c == 1;
    }

    public int a(String str, boolean z) {
        if (str == null) {
            return a(z);
        }
        int i2 = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).v;
        return i2 != -1 ? i2 : a(z);
    }
}
