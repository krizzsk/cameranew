package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.i;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: AccessTokenManager.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f  reason: collision with root package name */
    private static volatile b f2345f;
    private final LocalBroadcastManager a;
    private final com.facebook.a b;
    private AccessToken c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f2346d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private Date f2347e = new Date(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ AccessToken.b a;

        a(AccessToken.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                b.this.k(this.a);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenManager.java */
    /* renamed from: com.facebook.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0084b implements GraphRequest.e {
        final /* synthetic */ AtomicBoolean a;
        final /* synthetic */ Set b;
        final /* synthetic */ Set c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Set f2348d;

        C0084b(b bVar, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
            this.a = atomicBoolean;
            this.b = set;
            this.c = set2;
            this.f2348d = set3;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            JSONArray optJSONArray;
            JSONObject h2 = graphResponse.h();
            if (h2 == null || (optJSONArray = h2.optJSONArray("data")) == null) {
                return;
            }
            this.a.set(true);
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("permission");
                    String optString2 = optJSONObject.optString("status");
                    if (!x.S(optString) && !x.S(optString2)) {
                        String lowerCase = optString2.toLowerCase(Locale.US);
                        if (lowerCase.equals("granted")) {
                            this.b.add(optString);
                        } else if (lowerCase.equals("declined")) {
                            this.c.add(optString);
                        } else if (lowerCase.equals("expired")) {
                            this.f2348d.add(optString);
                        } else {
                            Log.w("AccessTokenManager", "Unexpected status: " + lowerCase);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenManager.java */
    /* loaded from: classes.dex */
    public class c implements GraphRequest.e {
        final /* synthetic */ e a;

        c(b bVar, e eVar) {
            this.a = eVar;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            JSONObject h2 = graphResponse.h();
            if (h2 == null) {
                return;
            }
            this.a.a = h2.optString("access_token");
            this.a.b = h2.optInt("expires_at");
            this.a.c = Long.valueOf(h2.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME));
            this.a.f2354d = h2.optString("graph_domain", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenManager.java */
    /* loaded from: classes.dex */
    public class d implements i.a {
        final /* synthetic */ AccessToken a;
        final /* synthetic */ AccessToken.b b;
        final /* synthetic */ AtomicBoolean c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f2349d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Set f2350e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Set f2351f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Set f2352g;

        d(AccessToken accessToken, AccessToken.b bVar, AtomicBoolean atomicBoolean, e eVar, Set set, Set set2, Set set3) {
            this.a = accessToken;
            this.b = bVar;
            this.c = atomicBoolean;
            this.f2349d = eVar;
            this.f2350e = set;
            this.f2351f = set2;
            this.f2352g = set3;
        }

        @Override // com.facebook.i.a
        public void a(i iVar) {
            AccessToken accessToken;
            Date k2;
            try {
                if (b.h().g() != null && b.h().g().u() == this.a.u()) {
                    if (!this.c.get()) {
                        e eVar = this.f2349d;
                        if (eVar.a == null && eVar.b == 0) {
                            AccessToken.b bVar = this.b;
                            if (bVar != null) {
                                bVar.a(new FacebookException("Failed to refresh access token"));
                            }
                            b.this.f2346d.set(false);
                            AccessToken.b bVar2 = this.b;
                            return;
                        }
                    }
                    String str = this.f2349d.a;
                    if (str == null) {
                        str = this.a.t();
                    }
                    String str2 = str;
                    String h2 = this.a.h();
                    String u = this.a.u();
                    Set<String> q = this.c.get() ? this.f2350e : this.a.q();
                    Set<String> l2 = this.c.get() ? this.f2351f : this.a.l();
                    Set<String> m = this.c.get() ? this.f2352g : this.a.m();
                    AccessTokenSource s = this.a.s();
                    Date date = this.f2349d.b != 0 ? new Date(this.f2349d.b * 1000) : this.a.n();
                    Date date2 = new Date();
                    if (this.f2349d.c != null) {
                        k2 = new Date(1000 * this.f2349d.c.longValue());
                    } else {
                        k2 = this.a.k();
                    }
                    accessToken = r15;
                    AccessToken accessToken2 = new AccessToken(str2, h2, u, q, l2, m, s, date, date2, k2, this.f2349d.f2354d);
                    try {
                        b.h().m(accessToken);
                        b.this.f2346d.set(false);
                        AccessToken.b bVar3 = this.b;
                        if (bVar3 != null) {
                            bVar3.b(accessToken);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        b.this.f2346d.set(false);
                        AccessToken.b bVar4 = this.b;
                        if (bVar4 != null && accessToken != null) {
                            bVar4.b(accessToken);
                        }
                        throw th;
                    }
                }
                AccessToken.b bVar5 = this.b;
                if (bVar5 != null) {
                    bVar5.a(new FacebookException("No current access token to refresh"));
                }
                b.this.f2346d.set(false);
                AccessToken.b bVar6 = this.b;
            } catch (Throwable th2) {
                th = th2;
                accessToken = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AccessTokenManager.java */
    /* loaded from: classes.dex */
    public static class e {
        public String a;
        public int b;
        public Long c;

        /* renamed from: d  reason: collision with root package name */
        public String f2354d;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    b(LocalBroadcastManager localBroadcastManager, com.facebook.a aVar) {
        y.l(localBroadcastManager, "localBroadcastManager");
        y.l(aVar, "accessTokenCache");
        this.a = localBroadcastManager;
        this.b = aVar;
    }

    private static GraphRequest c(AccessToken accessToken, GraphRequest.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        bundle.putString("client_id", accessToken.h());
        return new GraphRequest(accessToken, "oauth/access_token", bundle, HttpMethod.GET, eVar);
    }

    private static GraphRequest d(AccessToken accessToken, GraphRequest.e eVar) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b h() {
        if (f2345f == null) {
            synchronized (b.class) {
                if (f2345f == null) {
                    f2345f = new b(LocalBroadcastManager.getInstance(f.f()), new com.facebook.a());
                }
            }
        }
        return f2345f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccessToken.b bVar) {
        AccessToken accessToken = this.c;
        if (accessToken == null) {
            if (bVar != null) {
                bVar.a(new FacebookException("No current access token to refresh"));
            }
        } else if (!this.f2346d.compareAndSet(false, true)) {
            if (bVar != null) {
                bVar.a(new FacebookException("Refresh already in progress"));
            }
        } else {
            this.f2347e = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            e eVar = new e(null);
            i iVar = new i(d(accessToken, new C0084b(this, atomicBoolean, hashSet, hashSet2, hashSet3)), c(accessToken, new c(this, eVar)));
            iVar.c(new d(accessToken, bVar, atomicBoolean, eVar, hashSet, hashSet2, hashSet3));
            iVar.f();
        }
    }

    private void l(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(f.f(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.a.sendBroadcast(intent);
    }

    private void n(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.c;
        this.c = accessToken;
        this.f2346d.set(false);
        this.f2347e = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.b.g(accessToken);
            } else {
                this.b.a();
                x.g(f.f());
            }
        }
        if (x.b(accessToken2, accessToken)) {
            return;
        }
        l(accessToken2, accessToken);
        o();
    }

    private void o() {
        Context f2 = f.f();
        AccessToken j2 = AccessToken.j();
        AlarmManager alarmManager = (AlarmManager) f2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (!AccessToken.x() || j2.n() == null || alarmManager == null) {
            return;
        }
        Intent intent = new Intent(f2, CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        VdsAgent.onPendingIntentGetBroadcastBefore(f2, 0, intent, 0);
        PendingIntent broadcast = PendingIntent.getBroadcast(f2, 0, intent, 0);
        VdsAgent.onPendingIntentGetBroadcastAfter(f2, 0, intent, 0, broadcast);
        try {
            alarmManager.set(1, j2.n().getTime(), broadcast);
        } catch (Exception unused) {
        }
    }

    private boolean p() {
        if (this.c == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        return this.c.s().canExtendToken() && valueOf.longValue() - this.f2347e.getTime() > 3600000 && valueOf.longValue() - this.c.p().getTime() > AdvTimeUtils.MILLIS_OF_A_DAY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        AccessToken accessToken = this.c;
        l(accessToken, accessToken);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (p()) {
            j(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessToken g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        AccessToken f2 = this.b.f();
        if (f2 != null) {
            n(f2, false);
            return true;
        }
        return false;
    }

    void j(AccessToken.b bVar) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            k(bVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new a(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(AccessToken accessToken) {
        n(accessToken, true);
    }
}
