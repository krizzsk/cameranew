package us.pinguo.repository2020.utils;

import java.io.File;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.u;
import us.pinguo.util.v;
/* compiled from: MaterialResourceUtil.kt */
/* loaded from: classes6.dex */
public final class n {
    public static final n a = new n();
    private static final String b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f11954d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f11955e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f11956f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f11957g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f11958h;

    static {
        String str;
        String str2;
        boolean z = us.pinguo.foundation.d.f10985d;
        if (z) {
            str = us.pinguo.foundation.d.b ? "https://bmall-qa.camera360.com" : "https://bmall-dev.camera360.com";
        } else {
            str = "https://bmall.camera360.com";
        }
        b = str;
        if (z) {
            str2 = "https://camera360-api-qa.camera360.com";
        } else {
            str2 = u.a() ? "https://camera360-api.camera360.com" : "https://camera360-api.360in.com";
        }
        c = str2;
        String q = s.q(v.e(".filter"), "/");
        f11954d = q;
        String q2 = s.q(v.e(".material"), "/");
        f11955e = q2;
        f11956f = s.q(q, "files/");
        f11957g = s.q(q2, "files/");
        f11958h = s.q(q, "download/");
        s.q(q, "detail/");
        s.q(q, "download");
    }

    private n() {
    }

    public static /* synthetic */ String d(n nVar, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return nVar.c(str);
    }

    public final String a() {
        return b;
    }

    public final String b(String str) {
        return str == null ? "" : s.q(f11958h, str);
    }

    public final String c(String md5) {
        s.h(md5, "md5");
        return s.q(f11956f, md5);
    }

    public final String e() {
        return c;
    }

    public final String f(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f11957g);
        sb.append("material");
        String str2 = File.separator;
        sb.append((Object) str2);
        sb.append((Object) str);
        sb.append((Object) str2);
        return sb.toString();
    }

    public final String g(String str) {
        if (str == null) {
            return "";
        }
        return f11957g + "material" + ((Object) File.separator) + ((Object) str);
    }
}
