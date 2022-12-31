package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.z;
import com.tencent.stat.DeviceInfo;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: TTAdManagerImpl.java */
/* loaded from: classes.dex */
public class t implements TTAdManager {
    String a;
    boolean b = false;
    boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    String f1759d = "com.union_test.internationad";

    /* renamed from: e  reason: collision with root package name */
    String f1760e = "5001121";

    private void e(String str) {
        com.bytedance.sdk.openadsdk.core.d.a aVar;
        if (TextUtils.isEmpty(str) || str.equals(this.a)) {
            return;
        }
        this.a = str;
        try {
            JSONObject a = o.f().a(new JSONObject(str));
            if (a == null) {
                return;
            }
            q.a a2 = q.a.a(a, null);
            if (a2.f1748d == 20000 && (aVar = a2.f1752h) != null && aVar.c().size() > 0) {
                com.bytedance.sdk.openadsdk.core.d.h hVar = a2.f1752h.c().get(0);
                this.b = ab.d(hVar);
                this.c = hVar.u() != null;
            }
        } catch (Throwable unused) {
        }
    }

    private String f(String str) {
        String a = a.a(str);
        if (str == null) {
            String a2 = b.a();
            return a2.concat(a2).substring(8, 24);
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public t setAppId(String str) {
        h.b().a(str);
        com.bytedance.sdk.openadsdk.core.g.e.a(o.i()).a();
        com.bytedance.sdk.openadsdk.core.g.f.a(o.h()).c();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: b */
    public t setName(String str) {
        h.b().b(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: c */
    public t setKeywords(String str) {
        h.b().c(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        h.b().m();
        return new u(context);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: d */
    public t setData(String str) {
        h.b().d(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String e2 = o.h().e();
            String f2 = o.h().f();
            if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(f2)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", e2);
                jSONObject3.put("param", f2);
                jSONObject2.put("abtest", jSONObject3);
            }
            jSONObject2.put("ad_sdk_version", "3.1.5.4");
            jSONObject2.put("package_name", ab.f());
            jSONObject2.put("user_data", a());
            jSONObject2.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis() / 1000);
            String b = b();
            String a = a.a(jSONObject2.toString(), f(b));
            jSONObject.put("message", 2 + b + a);
            jSONObject.put("cypher", 2);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getGdpr() {
        return h.b().f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "3.1.5.4";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean isExpressAd(String str, String str2) {
        if (o.h().i(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        e(str2);
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean isFullScreenVideoAd(String str, String str2) {
        if (o.h().j(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        e(str2);
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager isUseTextureView(boolean z) {
        h.b().d(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        if (this.f1759d.equals(o.a().getPackageName()) && this.f1760e.equals(h.b().c()) && !TextUtils.isEmpty(str)) {
            try {
                Method a = z.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
                if (a != null) {
                    a.invoke(null, str, Integer.valueOf(i2), str2, str3, str4);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
            }
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager openDebugMode() {
        com.bytedance.sdk.openadsdk.utils.o.b();
        com.bytedance.sdk.adnet.a.c();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        h.b().c(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        h.b().b(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setCoppa(int i2) {
        h.b().a(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setGdpr(int i2) {
        h.b().b(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        h.b().a(strArr);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTitleBarTheme(int i2) {
        h.b().d(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void showPrivacyProtection() {
        TTDelegateActivity.a();
    }

    private String b() {
        String a = a.a();
        return a == null ? b.a() : a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public t setPaid(boolean z) {
        h.b().a(z);
        return this;
    }

    private JSONObject a() {
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

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }
}
