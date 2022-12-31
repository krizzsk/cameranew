package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tapjoy.TapjoyConstants;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class hj {
    public final o A;
    public final h B;
    final h C;
    final o D;
    final Context a;
    final SharedPreferences b;
    final o c;

    /* renamed from: d  reason: collision with root package name */
    final o f7617d;

    /* renamed from: e  reason: collision with root package name */
    final k f7618e;

    /* renamed from: f  reason: collision with root package name */
    final k f7619f;

    /* renamed from: g  reason: collision with root package name */
    final o f7620g;

    /* renamed from: h  reason: collision with root package name */
    final k f7621h;

    /* renamed from: i  reason: collision with root package name */
    final l f7622i;

    /* renamed from: j  reason: collision with root package name */
    final l f7623j;

    /* renamed from: k  reason: collision with root package name */
    final l f7624k;

    /* renamed from: l  reason: collision with root package name */
    final o f7625l;
    final k m;
    final i n;
    final l o;
    final i p;
    final o q;
    final o r;
    final k s;
    final k t;
    final o u;
    final o v;
    final o w;
    final o x;
    final o y;
    final o z;

    private hj(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("fiverocks", 0);
        this.b = sharedPreferences;
        this.c = new o(sharedPreferences, "sdk");
        this.f7617d = new o(sharedPreferences, "ir");
        this.f7618e = new k(sharedPreferences, "fql", 0);
        this.f7619f = new k(sharedPreferences, "fq", 0);
        this.f7620g = new o(sharedPreferences, Constants.PUSH);
        this.f7621h = new k(sharedPreferences, "ss", 0);
        this.f7622i = new l(sharedPreferences, "std");
        this.f7623j = new l(sharedPreferences, "slt");
        this.f7624k = new l(sharedPreferences, "sld");
        this.f7625l = new o(sharedPreferences, "ptc");
        this.m = new k(sharedPreferences, "pc", 0);
        this.n = new i(sharedPreferences, "ptp");
        this.o = new l(sharedPreferences, "lpt");
        this.p = new i(sharedPreferences, "plp");
        this.q = new o(sharedPreferences, "adv");
        this.r = new o(sharedPreferences, DeviceInfo.TAG_IMEI);
        this.s = new k(sharedPreferences, "ul", -1);
        this.t = new k(sharedPreferences, "uf", -1);
        this.u = new o(sharedPreferences, TapjoyConstants.TJC_USER_VARIABLE_1);
        this.v = new o(sharedPreferences, TapjoyConstants.TJC_USER_VARIABLE_2);
        this.w = new o(sharedPreferences, TapjoyConstants.TJC_USER_VARIABLE_3);
        this.x = new o(sharedPreferences, TapjoyConstants.TJC_USER_VARIABLE_4);
        this.y = new o(sharedPreferences, TapjoyConstants.TJC_USER_VARIABLE_5);
        this.z = new o(sharedPreferences, "utags");
        this.A = new o(sharedPreferences, "idfa");
        this.B = new h(sharedPreferences, "idfa.optout");
        this.C = new h(sharedPreferences, "push.optout");
        this.D = new o(sharedPreferences, RemoteConfigConstants.RequestFieldKey.APP_ID);
    }

    public static hj a(Context context) {
        return new hj(context);
    }

    public final String b() {
        String string = this.b.getString("ir", null);
        if (string != null) {
            if (string.length() > 0) {
                return string;
            }
            return null;
        }
        File file = new File(gz.c(this.a), "referrer");
        if (file.exists()) {
            try {
                string = bg.a(file, ak.c);
            } catch (IOException unused) {
            }
        }
        this.b.edit().putString("ir", string != null ? string : "").apply();
        if (string == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SharedPreferences.Editor a() {
        return this.b.edit();
    }

    public final void a(boolean z) {
        n.a(this.b, "gcm.onServer", z);
    }
}
