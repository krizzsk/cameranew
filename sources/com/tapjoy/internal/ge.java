package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes3.dex */
public final class ge {

    /* renamed from: f  reason: collision with root package name */
    private static final ge f7566f;

    /* renamed from: g  reason: collision with root package name */
    private static ge f7567g;
    public Boolean a = null;
    public String b = null;
    public Boolean c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7568d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7569e = false;

    /* renamed from: h  reason: collision with root package name */
    private Context f7570h;

    static {
        ge geVar = new ge();
        f7566f = geVar;
        f7567g = geVar;
    }

    public static ge a() {
        return f7567g;
    }

    private boolean c() {
        Context context = this.f7570h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
            edit.putBoolean("gdpr", this.a.booleanValue());
            edit.apply();
            return true;
        }
        return false;
    }

    private boolean d() {
        Context context = this.f7570h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
            edit.putString("cgdpr", this.b);
            edit.apply();
            return true;
        }
        return false;
    }

    private boolean e() {
        Context context = this.f7570h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
            edit.putBoolean("below_consent_age", this.c.booleanValue());
            edit.apply();
            return true;
        }
        return false;
    }

    public final void b(boolean z) {
        this.c = Boolean.valueOf(z);
        if (e()) {
            return;
        }
        this.f7569e = true;
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.f7570h == null) {
                this.f7570h = context;
            }
        }
        ge geVar = f7567g;
        Context context2 = geVar.f7570h;
        if (context2 != null) {
            SharedPreferences sharedPreferences = context2.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            if (geVar.a == null && sharedPreferences.contains("gdpr")) {
                geVar.a = Boolean.valueOf(sharedPreferences.getBoolean("gdpr", false));
            }
            if (geVar.b == null) {
                geVar.b = sharedPreferences.getString("cgdpr", "");
            }
            if (geVar.c == null && sharedPreferences.contains("below_consent_age")) {
                geVar.c = Boolean.valueOf(sharedPreferences.getBoolean("below_consent_age", false));
            }
            if (geVar.f7568d == null) {
                geVar.f7568d = sharedPreferences.getString("us_privacy", "");
            }
        }
        if (this.f7569e) {
            this.f7569e = false;
            ge geVar2 = f7567g;
            if (geVar2.f7570h != null) {
                if (geVar2.a != null) {
                    geVar2.c();
                }
                if (geVar2.b != null) {
                    geVar2.d();
                }
                if (geVar2.c != null) {
                    geVar2.e();
                }
                if (geVar2.f7568d != null) {
                    geVar2.b();
                }
            }
        }
    }

    public final boolean b() {
        Context context = this.f7570h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
            edit.putString("us_privacy", this.f7568d);
            edit.apply();
            return true;
        }
        return false;
    }

    public final void a(boolean z) {
        this.a = Boolean.valueOf(z);
        if (c()) {
            return;
        }
        this.f7569e = true;
    }

    public final void a(String str) {
        if (al.a(str)) {
            return;
        }
        this.b = str;
        if (d()) {
            return;
        }
        this.f7569e = true;
    }
}
