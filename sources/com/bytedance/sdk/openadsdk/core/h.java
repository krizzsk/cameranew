package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: GlobalInfo.java */
/* loaded from: classes.dex */
public class h {
    private static final h q = new h();
    @NonNull
    private String a;
    @NonNull
    private String b;
    private boolean c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f1662d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f1663e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f1664f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private int f1665g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1666h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1667i = false;

    /* renamed from: j  reason: collision with root package name */
    private final Set<Integer> f1668j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1669k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f1670l;
    private com.bytedance.sdk.openadsdk.utils.a m;
    private String[] n;
    private int o;
    private int p;
    private com.bytedance.sdk.openadsdk.b.c r;
    private com.bytedance.sdk.openadsdk.core.video.c.c s;

    private h() {
        Set<Integer> synchronizedSet = Collections.synchronizedSet(new HashSet());
        this.f1668j = synchronizedSet;
        this.f1669k = false;
        this.f1670l = null;
        this.m = new com.bytedance.sdk.openadsdk.utils.a();
        this.o = 0;
        this.p = 0;
        com.bytedance.sdk.openadsdk.h.g.a.a(o.a());
        synchronizedSet.add(4);
        Context a = o.a();
        if (a instanceof Application) {
            ((Application) a).registerActivityLifecycleCallbacks(this.m);
        } else if (a == null || a.getApplicationContext() == null) {
        } else {
            ((Application) a.getApplicationContext()).registerActivityLifecycleCallbacks(this.m);
        }
    }

    public static h b() {
        return q;
    }

    public boolean a() {
        return this.m.a();
    }

    @NonNull
    public String c() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", TapjoyConstants.TJC_APP_ID, (String) null);
        }
        return this.a;
    }

    @NonNull
    public String d() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null);
        }
        return this.b;
    }

    public int e() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_coppa", 0);
        }
        int b = com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).b("sdk_coppa", 0);
        this.o = b;
        return b;
    }

    public int f() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "tt_gdrp", -1);
        }
        return com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).b("tt_gdrp", -1);
    }

    public int g() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "global_coppa", -99);
        }
        int b = com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).b("global_coppa", -99);
        this.p = b;
        if (b == -99) {
            this.p = e();
        }
        return this.p;
    }

    public boolean h() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false);
        }
        return this.c;
    }

    @Nullable
    public String i() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", (String) null);
        }
        return this.f1662d;
    }

    @Nullable
    public String j() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", (String) null);
        }
        return this.f1663e;
    }

    public int k() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0);
        }
        return this.f1665g;
    }

    public boolean l() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", false);
        }
        return this.f1667i;
    }

    public void m() {
        e(this.a);
        f(this.b);
    }

    public com.bytedance.sdk.openadsdk.b.c n() {
        if (this.r == null) {
            this.r = new com.bytedance.sdk.openadsdk.b.c(10, 8);
        }
        return this.r;
    }

    public com.bytedance.sdk.openadsdk.core.video.c.c o() {
        if (this.s == null) {
            this.s = new com.bytedance.sdk.openadsdk.core.video.c.c(10, 8);
        }
        return this.s;
    }

    public boolean p() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false);
        }
        return this.f1669k;
    }

    public Bitmap q() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.utils.d.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", (String) null));
        }
        return this.f1670l;
    }

    public void a(@NonNull String str) {
        e(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", TapjoyConstants.TJC_APP_ID, str);
        }
        this.a = str;
    }

    public void b(@NonNull String str) {
        f(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.b = str;
    }

    private static void e(String str) {
        com.bytedance.sdk.openadsdk.utils.r.a(str, "appid不能为空");
    }

    private static void f(String str) {
        com.bytedance.sdk.openadsdk.utils.r.a(str, "name不能为空");
    }

    private static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.r.a(str.length() <= 1000, "data超长, 最长为1000");
    }

    public void c(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "global_coppa", Integer.valueOf(i2));
        } else {
            com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).a("global_coppa", i2);
        }
        this.p = i2;
    }

    public void d(@Nullable String str) {
        h(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", str);
        }
        this.f1663e = str;
    }

    private static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.r.a(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    public void a(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_coppa", Integer.valueOf(i2));
        } else {
            com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).a("sdk_coppa", i2);
        }
        this.o = i2;
    }

    public void b(@NonNull int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "tt_gdrp", Integer.valueOf(i2));
        } else {
            com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).a("tt_gdrp", i2);
        }
    }

    public void c(@Nullable String str) {
        g(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
        }
        this.f1662d = str;
    }

    public void d(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i2));
        }
        this.f1665g = i2;
    }

    public void b(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.f1666h = z;
    }

    public void a(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.c = z;
    }

    public void d(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.f1669k = z;
    }

    public void c(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.f1667i = z;
    }

    public void a(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String a = com.bytedance.sdk.openadsdk.utils.d.a(bitmap);
            if (!TextUtils.isEmpty(a)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "pause_icon", a);
            }
        }
        this.f1670l = bitmap;
    }

    public void a(String[] strArr) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int i3 = i2 + 1;
                    if (i2 > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                    i2 = i3;
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "need_clear_task_reset", sb2);
            }
        }
        this.n = strArr;
    }
}
