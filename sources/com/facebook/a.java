package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.y;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenCache.java */
/* loaded from: classes.dex */
public class a {
    private final SharedPreferences a;
    private final C0068a b;
    private LegacyTokenHelper c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenCache.java */
    /* renamed from: com.facebook.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a {
        C0068a() {
        }

        public LegacyTokenHelper a() {
            return new LegacyTokenHelper(f.f());
        }
    }

    a(SharedPreferences sharedPreferences, C0068a c0068a) {
        this.a = sharedPreferences;
        this.b = c0068a;
    }

    private AccessToken b() {
        String string = this.a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string != null) {
            try {
                return AccessToken.c(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private AccessToken c() {
        Bundle h2 = d().h();
        if (h2 == null || !LegacyTokenHelper.g(h2)) {
            return null;
        }
        return AccessToken.f(h2);
    }

    private LegacyTokenHelper d() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = this.b.a();
                }
            }
        }
        return this.c;
    }

    private boolean e() {
        return this.a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private boolean h() {
        return f.A();
    }

    public void a() {
        this.a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (h()) {
            d().a();
        }
    }

    public AccessToken f() {
        if (e()) {
            return b();
        }
        if (h()) {
            AccessToken c = c();
            if (c != null) {
                g(c);
                d().a();
                return c;
            }
            return c;
        }
        return null;
    }

    public void g(AccessToken accessToken) {
        y.l(accessToken, "accessToken");
        try {
            this.a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.C().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public a() {
        this(f.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new C0068a());
    }
}
