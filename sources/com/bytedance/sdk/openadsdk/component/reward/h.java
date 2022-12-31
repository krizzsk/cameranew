package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.o;
import org.json.JSONObject;
/* compiled from: SpCache.java */
/* loaded from: classes.dex */
class h {
    private String a;
    private Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str) {
        this.b = context;
        this.a = TextUtils.isEmpty(str) ? "" : str;
    }

    @Nullable
    private Context b() {
        Context context = this.b;
        return context == null ? o.a() : context;
    }

    private String c() {
        return this.a + "_adslot";
    }

    private String d() {
        return this.a + "_adslot_preload";
    }

    @Nullable
    private SharedPreferences f(String str) {
        try {
            if (b() != null) {
                return b().getSharedPreferences(str, 0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.a + "_cache_" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b(g(str), "material_data", (String) null);
        }
        SharedPreferences f2 = f(g(str));
        if (f2 != null) {
            return f2.getString("material_data", null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AdSlot e(String str) {
        String string;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                string = com.bytedance.sdk.openadsdk.multipro.d.a.b(c(), str, (String) null);
            } else {
                SharedPreferences f2 = f(c());
                string = f2 != null ? f2.getString(str, null) : null;
            }
            return AdSlot.getSlot(string != null ? new JSONObject(string) : null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", 0L);
            }
            SharedPreferences f2 = f(g(str));
            if (f2 != null) {
                return f2.getLong("create_time", 0L);
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", true);
        }
        SharedPreferences f2 = f(g(str));
        if (f2 != null) {
            return f2.getBoolean("has_played", true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str));
                return;
            }
            SharedPreferences f2 = f(g(str));
            if (f2 != null) {
                f2.edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "material_data", str2);
                return;
            }
            SharedPreferences f2 = f(g(str));
            if (f2 != null) {
                f2.edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String jSONObject = adSlot.toJsonObj().toString();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(d(), "preload_data", jSONObject);
                    } else {
                        SharedPreferences f2 = f(d());
                        if (f2 != null) {
                            f2.edit().putString("preload_data", jSONObject).apply();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String jSONObject = adSlot.toJsonObj().toString();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(c(), adSlot.getCodeId(), jSONObject);
                    } else {
                        SharedPreferences f2 = f(c());
                        if (f2 != null) {
                            f2.edit().putString(adSlot.getCodeId(), jSONObject).apply();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AdSlot a() {
        String str;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                str = com.bytedance.sdk.openadsdk.multipro.d.a.b(d(), "preload_data", (String) null);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(d());
            } else {
                SharedPreferences f2 = f(d());
                if (f2 != null) {
                    String string = f2.getString("preload_data", null);
                    f2.edit().clear().apply();
                    str = string;
                } else {
                    str = null;
                }
            }
            return AdSlot.getSlot(str != null ? new JSONObject(str) : null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
