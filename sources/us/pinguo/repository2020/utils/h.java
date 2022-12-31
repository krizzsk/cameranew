package us.pinguo.repository2020.utils;

import java.io.File;
import kotlin.jvm.internal.s;
import us.pinguo.util.v;
/* compiled from: EffectResourceUtil.kt */
/* loaded from: classes6.dex */
public final class h {
    private static final String a;
    private static final String b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f11943d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f11944e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f11945f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f11946g;

    static {
        String str;
        if (us.pinguo.foundation.d.f10985d) {
            str = us.pinguo.foundation.d.b ? "https://bmall-qa.camera360.com" : "https://bmall-dev.camera360.com";
        } else {
            str = "https://bmall.camera360.com";
        }
        a = str;
        String q = s.q(v.e(".filter"), "/");
        b = q;
        c = s.q(q, "files/");
        f11943d = s.q(q, "download/");
        s.q(q, "detail/");
        s.q(q, "download");
        String q2 = s.q(v.e("background"), "/");
        f11944e = q2;
        String q3 = s.q(v.e("background_blur"), "/");
        f11945f = q3;
        f11946g = s.q(q2, "cache/");
        s.q(q3, "cache/");
    }

    public static final String a() {
        return f11944e;
    }

    public static final String b() {
        return f11946g;
    }

    public static final String c() {
        return a;
    }

    public static final String d(String md5) {
        s.h(md5, "md5");
        return s.q(f11943d, md5);
    }

    public static final String e() {
        return b;
    }

    public static final String f() {
        return c;
    }

    public static final String g(String md5, String id) {
        s.h(md5, "md5");
        s.h(id, "id");
        return i(md5) + id + ((Object) File.separator);
    }

    public static final String h(String packageMd5, String id) {
        s.h(packageMd5, "packageMd5");
        s.h(id, "id");
        return s.q(g(packageMd5, id), "index.json");
    }

    public static final String i(String md5) {
        s.h(md5, "md5");
        return c + md5 + '/';
    }
}
