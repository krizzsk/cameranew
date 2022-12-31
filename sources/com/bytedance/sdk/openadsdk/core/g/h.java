package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.v;
import org.json.JSONObject;
/* compiled from: TTDnsSettings.java */
/* loaded from: classes.dex */
public class h implements d {
    private String a;
    private b b;

    private void c() {
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        try {
            this.b = b.a(new JSONObject(this.a));
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_dns_settings", "dnsinfo", this.a);
            return;
        }
        v e2 = e();
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        e2.a("dnsinfo", this.a);
    }

    private v e() {
        return v.a("tt_dns_settings", o.a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.a = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_dns_settings", "dnsinfo", "");
            c();
            return;
        }
        this.a = e().b("dnsinfo", "");
        c();
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a(@NonNull JSONObject jSONObject) {
        b a = b.a(jSONObject);
        this.b = a;
        if (a != null) {
            this.a = a.c().toString();
        }
        d();
    }
}
