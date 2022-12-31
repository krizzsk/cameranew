package com.bytedance.sdk.openadsdk.f;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* compiled from: StatsLogManager.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private ExecutorService b = Executors.newFixedThreadPool(5);

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(c cVar) {
        return cVar == null;
    }

    public void b(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("load_ad_duration_no_ad");
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    public void c(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("express_ad_render");
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    public void d(@NonNull final c cVar) {
        if (h(cVar)) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.h(cVar) || !a.this.a(cVar.e(), 1)) {
                    return;
                }
                cVar.a("reg_creative");
                o.j().a(cVar);
            }
        });
    }

    public void e(@NonNull final c cVar) {
        if (h(cVar)) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.h(cVar) || !a.this.a(cVar.e(), 0)) {
                    return;
                }
                cVar.a("no_reg_creative");
                o.j().a(cVar);
            }
        });
    }

    public void f(@NonNull c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("load_icon_error");
        o.j().a(cVar);
    }

    public void g(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.a("show_backup_endcard");
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable unused) {
        }
        o.j().a(c.b().a("close_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(c cVar) {
        if (h(cVar)) {
            return;
        }
        cVar.c(System.currentTimeMillis() / 1000);
        o.j().a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i2) {
        d a2 = d.a(o.a());
        boolean z = false;
        int b = a2.b(str, 0);
        z = ((b & 2) == 0 || (b & 1) != i2) ? true : true;
        if (z) {
            a2.a(str, i2 + 2);
        }
        return z;
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable unused) {
        }
        o.j().a(c.b().a("click_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(String str, int i2, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
            jSONObject.put("error_code", i2);
            jSONObject.put("error_message", str2);
        } catch (Throwable unused) {
        }
        o.j().a(c.b().a("use_playable_test_tool_error").b(jSONObject.toString()), false);
    }
}
