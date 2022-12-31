package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.collection.Constants;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.eu;
import com.tapjoy.internal.fa;
import com.tapjoy.internal.fe;
import com.tapjoy.internal.fh;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class hc {
    public static final String a = UUID.randomUUID().toString();

    /* renamed from: d  reason: collision with root package name */
    private static hc f7603d;
    public final fh.a b;
    public final hj c;

    /* renamed from: e  reason: collision with root package name */
    private final fa.a f7604e;

    /* renamed from: f  reason: collision with root package name */
    private final eu.a f7605f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f7606g;

    private hc(Context context, hj hjVar) {
        hn.a();
        fa.a aVar = new fa.a();
        this.f7604e = aVar;
        eu.a aVar2 = new eu.a();
        this.f7605f = aVar2;
        fh.a aVar3 = new fh.a();
        this.b = aVar3;
        aVar.p = "12.6.1/Android";
        aVar.f7477g = Constants.PLATFORM_ANDROID;
        aVar.f7478h = Build.VERSION.RELEASE;
        aVar.f7475e = Build.MANUFACTURER;
        aVar.f7476f = Build.MODEL;
        aVar.f7482l = Locale.getDefault().toString();
        aVar.m = TimeZone.getDefault().getID();
        Context applicationContext = context.getApplicationContext();
        this.f7606g = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        File file = new File(gz.c(applicationContext), "deviceid");
        String string = sharedPreferences.getString(TapjoyConstants.PREF_ANALYTICS_ID, null);
        if (jq.c(string)) {
            String b = file.exists() ? jq.b(bg.a(file)) : null;
            string = b == null ? UUID.randomUUID().toString() : b;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(TapjoyConstants.PREF_ANALYTICS_ID, string);
            edit.apply();
        }
        aVar.f7474d = string;
        if (!ga.b().a(TapjoyConnectFlag.DISABLE_ANDROID_ID_AS_ANALYTICS_ID, true)) {
            String string2 = Settings.Secure.getString(applicationContext.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            aVar.t = !"9774d56d682e549c".equals(string2) ? jq.b(string2) : null;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        if (telephonyManager != null) {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!jq.c(simCountryIso)) {
                aVar.q = simCountryIso.toUpperCase(Locale.US);
            }
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!jq.c(networkCountryIso)) {
                aVar.r = networkCountryIso.toUpperCase(Locale.US);
            }
        }
        String packageName = applicationContext.getPackageName();
        aVar.n = packageName;
        Signature[] e2 = z.e(packageManager, packageName);
        aVar.o = jq.a((e2 == null || e2.length <= 0) ? null : Base64.encodeToString(ch.a(e2[0].toByteArray()), 2));
        aVar2.c = z.a(packageManager, packageName);
        aVar2.f7428d = Integer.valueOf(z.b(packageManager, packageName));
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (!jq.c(installerPackageName)) {
            aVar2.f7430f = installerPackageName;
        }
        String a2 = a(packageManager, packageName);
        if (!jq.c(a2)) {
            aVar2.f7431g = a2;
        }
        a();
        this.c = hjVar;
        String a3 = hjVar.c.a();
        if (a3 != null && a3.length() > 0) {
            aVar.p = a3 + " 12.6.1/Android";
        }
        String b2 = hjVar.b();
        if (b2 != null) {
            aVar3.f7529d = b2;
        }
        long j2 = hjVar.b.getLong("it", 0L);
        if (j2 == 0) {
            Context context2 = hjVar.a;
            j2 = z.c(context2.getPackageManager(), context2.getPackageName());
            if (j2 == 0) {
                j2 = gz.d(hjVar.a).lastModified();
                if (j2 == 0) {
                    Context context3 = hjVar.a;
                    j2 = new File(z.d(context3.getPackageManager(), context3.getPackageName())).lastModified();
                    if (j2 == 0) {
                        j2 = System.currentTimeMillis();
                    }
                }
            }
            hjVar.b.edit().putLong("it", j2).apply();
        }
        aVar3.c = Long.valueOf(j2);
        int b3 = hjVar.f7619f.b();
        aVar3.f7530e = Integer.valueOf(a(7, b3));
        aVar3.f7531f = Integer.valueOf(a(30, b3));
        int b4 = hjVar.f7621h.b();
        if (b4 > 0) {
            aVar3.f7533h = Integer.valueOf(b4);
        }
        long a4 = hjVar.f7622i.a();
        if (a4 > 0) {
            aVar3.f7534i = Long.valueOf(a4);
        }
        long a5 = hjVar.f7623j.a();
        if (a5 > 0) {
            aVar3.f7535j = Long.valueOf(a5);
        }
        long a6 = hjVar.f7624k.a();
        if (a6 > 0) {
            aVar3.f7536k = Long.valueOf(a6);
        }
        String a7 = hjVar.f7625l.a();
        if (a7 != null) {
            aVar3.f7537l = a7;
        }
        int b5 = hjVar.m.b();
        if (b5 > 0) {
            aVar3.m = Integer.valueOf(b5);
        }
        double a8 = hjVar.n.a();
        if (a8 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            aVar3.n = Double.valueOf(a8);
        }
        long a9 = hjVar.o.a();
        if (a9 > 0) {
            aVar3.o = Long.valueOf(a9);
        }
        double a10 = hjVar.p.a();
        if (a10 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            aVar3.p = Double.valueOf(a10);
        }
        String a11 = hjVar.f7620g.a();
        if (a11 != null) {
            try {
                byte[] decode = Base64.decode(a11, 2);
                aVar3.f7532g.clear();
                aVar3.f7532g.addAll(((ff) ff.c.a(decode)).f7518d);
            } catch (IOException unused) {
                this.c.f7620g.c();
            } catch (IllegalArgumentException unused2) {
                this.c.f7620g.c();
            }
        }
        this.f7605f.f7429e = this.c.q.a();
        this.b.s = this.c.r.a();
        int intValue = this.c.s.a().intValue();
        this.b.t = intValue != -1 ? Integer.valueOf(intValue) : null;
        int intValue2 = this.c.t.a().intValue();
        this.b.u = intValue2 != -1 ? Integer.valueOf(intValue2) : null;
        this.b.v = this.c.u.a();
        this.b.w = this.c.v.a();
        this.b.x = this.c.w.a();
        this.b.y = this.c.x.a();
        this.b.z = this.c.y.a();
        String a12 = this.c.z.a();
        if (a12 != null) {
            try {
                byte[] decode2 = Base64.decode(a12, 2);
                this.b.A.clear();
                this.b.A.addAll(((fg) fg.c.a(decode2)).f7519d);
            } catch (IOException unused3) {
                this.c.z.c();
            } catch (IllegalArgumentException unused4) {
                this.c.z.c();
            }
        }
        String a13 = this.c.A.a();
        boolean booleanValue = this.c.B.a().booleanValue();
        if (a13 != null) {
            fh.a aVar4 = this.b;
            aVar4.q = a13;
            aVar4.r = Boolean.valueOf(booleanValue);
        } else {
            fh.a aVar5 = this.b;
            aVar5.q = null;
            aVar5.r = null;
        }
        this.b.B = this.c.C.a();
    }

    public static synchronized hc a(Context context) {
        hc hcVar;
        synchronized (hc.class) {
            if (f7603d == null) {
                f7603d = new hc(context, hj.a(context));
            }
            hcVar = f7603d;
        }
        return hcVar;
    }

    private void g() {
        this.c.f7620g.a(Base64.encodeToString(ff.c.b(new ff(this.b.f7532g)), 2));
    }

    public final fb b() {
        fb fbVar;
        synchronized (this) {
            this.f7604e.f7482l = Locale.getDefault().toString();
            this.f7604e.m = TimeZone.getDefault().getID();
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis() - 259200000;
            Iterator it = this.b.f7532g.iterator();
            while (it.hasNext()) {
                if (((fe) it.next()).f7514g.longValue() <= currentTimeMillis) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                g();
            }
            fbVar = new fb(this.f7604e.b(), this.f7605f.b(), this.b.b());
        }
        return fbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        String a2;
        synchronized (this) {
            a2 = this.c.f7617d.a();
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dc  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.tapjoy.internal.fc d() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hc.d():com.tapjoy.internal.fc");
    }

    public final Set e() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.b.A);
        }
        return hashSet;
    }

    public final boolean f() {
        return ((Boolean) jo.b(this.b.B, fh.r)).booleanValue();
    }

    private static String a(PackageManager packageManager, String str) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, 128).metaData;
            if (bundle == null || (obj = bundle.get("com.tapjoy.appstore")) == null) {
                return null;
            }
            return obj.toString().trim();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final boolean c(String str) {
        synchronized (this) {
            for (int size = this.b.f7532g.size() - 1; size >= 0; size--) {
                fe feVar = (fe) this.b.f7532g.get(size);
                if (feVar.f7513f.equals(str)) {
                    fe.a b = feVar.b();
                    b.f7517e = Long.valueOf(System.currentTimeMillis());
                    this.b.f7532g.set(size, b.b());
                    g();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Window window;
        synchronized (this) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.f7606g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                Activity a2 = gr.a();
                if (a2 != null && (window = a2.getWindow()) != null) {
                    int i2 = displayMetrics.heightPixels;
                    Rect rect = new Rect();
                    window.getDecorView().getWindowVisibleDisplayFrame(rect);
                    displayMetrics.heightPixels = i2 - rect.top;
                }
                this.f7604e.f7479i = Integer.valueOf(displayMetrics.densityDpi);
                this.f7604e.f7480j = Integer.valueOf(displayMetrics.widthPixels);
                this.f7604e.f7481k = Integer.valueOf(displayMetrics.heightPixels);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean b(String str) {
        boolean z;
        synchronized (this) {
            this.c.r.a(str);
            z = !jo.a(this.b.s, str);
            if (z) {
                this.b.s = str;
            }
        }
        return z;
    }

    public final boolean b(Integer num) {
        boolean z;
        synchronized (this) {
            this.c.t.a(num);
            z = !jo.a(this.b.u, num);
            if (z) {
                this.b.u = num;
            }
        }
        return z;
    }

    private static int a(int i2, int i3) {
        return Integer.bitCount(((1 << i2) - 1) & i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str, long j2, boolean z) {
        synchronized (this) {
            int size = this.b.f7532g.size();
            for (int i2 = 0; i2 < size; i2++) {
                fe feVar = (fe) this.b.f7532g.get(i2);
                if (feVar.f7513f.equals(str)) {
                    if (z) {
                        fe.a b = feVar.b();
                        b.f7516d = Long.valueOf(j2);
                        this.b.f7532g.set(i2, b.b());
                        return true;
                    }
                    return false;
                }
            }
            this.b.f7532g.add(new fe(str, Long.valueOf(j2)));
            g();
            return true;
        }
    }

    public final boolean a(String str) {
        boolean z;
        synchronized (this) {
            this.c.q.a(str);
            z = true;
            if (str != null) {
                if (jo.a(this.f7605f.f7429e, str)) {
                    z = false;
                }
                this.f7605f.f7429e = str;
            } else {
                eu.a aVar = this.f7605f;
                if (aVar.f7429e == null) {
                    z = false;
                }
                aVar.f7429e = null;
            }
        }
        return z;
    }

    public final boolean a(Integer num) {
        boolean z;
        synchronized (this) {
            this.c.s.a(num);
            z = !jo.a(this.b.t, num);
            if (z) {
                this.b.t = num;
            }
        }
        return z;
    }

    public final boolean a(int i2, String str) {
        boolean z;
        synchronized (this) {
            z = false;
            if (i2 == 1) {
                this.c.u.a(str);
                z = !jo.a(this.b.v, str);
                if (z) {
                    this.b.v = str;
                }
            } else if (i2 == 2) {
                this.c.v.a(str);
                z = !jo.a(this.b.w, str);
                if (z) {
                    this.b.w = str;
                }
            } else if (i2 == 3) {
                this.c.w.a(str);
                z = !jo.a(this.b.x, str);
                if (z) {
                    this.b.x = str;
                }
            } else if (i2 == 4) {
                this.c.x.a(str);
                z = !jo.a(this.b.y, str);
                if (z) {
                    this.b.y = str;
                }
            } else if (i2 == 5) {
                this.c.y.a(str);
                z = !jo.a(this.b.z, str);
                if (z) {
                    this.b.z = str;
                }
            }
        }
        return z;
    }

    public final boolean a(boolean z) {
        boolean z2;
        synchronized (this) {
            this.c.C.a(z);
            z2 = z != ((Boolean) jo.b(this.b.B, fh.r)).booleanValue();
            this.b.B = Boolean.valueOf(z);
        }
        return z2;
    }
}
