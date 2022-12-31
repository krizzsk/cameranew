package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
import org.slf4j.Marker;
/* loaded from: classes3.dex */
class c {
    String a;
    String b;
    DisplayMetrics c;

    /* renamed from: d  reason: collision with root package name */
    int f8276d;

    /* renamed from: e  reason: collision with root package name */
    String f8277e;

    /* renamed from: f  reason: collision with root package name */
    String f8278f;

    /* renamed from: g  reason: collision with root package name */
    String f8279g;

    /* renamed from: h  reason: collision with root package name */
    String f8280h;

    /* renamed from: i  reason: collision with root package name */
    String f8281i;

    /* renamed from: j  reason: collision with root package name */
    String f8282j;

    /* renamed from: k  reason: collision with root package name */
    String f8283k;

    /* renamed from: l  reason: collision with root package name */
    int f8284l;
    String m;
    Context n;
    private String o;
    private String p;
    private String q;
    private String r;

    private c(Context context) {
        this.b = StatConstants.VERSION;
        this.f8276d = Build.VERSION.SDK_INT;
        this.f8277e = Build.MODEL;
        this.f8278f = Build.MANUFACTURER;
        this.f8279g = Locale.getDefault().getLanguage();
        this.f8284l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.n = context;
        this.c = k.d(context);
        this.a = k.n(context);
        this.f8280h = StatConfig.getInstallChannel(context);
        this.f8281i = k.m(context);
        this.f8282j = TimeZone.getDefault().getID();
        this.f8284l = k.s(context);
        this.f8283k = k.t(context);
        this.m = context.getPackageName();
        if (this.f8276d >= 14) {
            this.o = k.A(context);
        }
        this.p = k.z(context).toString();
        this.q = k.x(context);
        this.r = k.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        jSONObject.put("sr", this.c.widthPixels + Marker.ANY_MARKER + this.c.heightPixels);
        k.a(jSONObject, "av", this.a);
        k.a(jSONObject, "ch", this.f8280h);
        k.a(jSONObject, "mf", this.f8278f);
        k.a(jSONObject, "sv", this.b);
        k.a(jSONObject, "ov", Integer.toString(this.f8276d));
        jSONObject.put("os", 1);
        k.a(jSONObject, "op", this.f8281i);
        k.a(jSONObject, "lg", this.f8279g);
        k.a(jSONObject, "md", this.f8277e);
        k.a(jSONObject, "tz", this.f8282j);
        int i2 = this.f8284l;
        if (i2 != 0) {
            jSONObject.put("jb", i2);
        }
        k.a(jSONObject, "sd", this.f8283k);
        k.a(jSONObject, "apn", this.m);
        if (k.h(this.n)) {
            JSONObject jSONObject2 = new JSONObject();
            k.a(jSONObject2, "bs", k.C(this.n));
            k.a(jSONObject2, "ss", k.D(this.n));
            if (jSONObject2.length() > 0) {
                k.a(jSONObject, "wf", jSONObject2.toString());
            }
        }
        k.a(jSONObject, "sen", this.o);
        k.a(jSONObject, "cpu", this.p);
        k.a(jSONObject, "ram", this.q);
        k.a(jSONObject, "rom", this.r);
    }
}
