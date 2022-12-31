package us.pinguo.common.filter.util;

import java.io.File;
import kotlin.jvm.internal.s;
import us.pinguo.util.v;
/* compiled from: ResourceUtil.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final a a = new a();
    private static final String b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f9876d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f9877e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f9878f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f9879g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f9880h;

    static {
        String q = s.q(v.e(".filter"), "/");
        b = q;
        c = s.q(q, "files/");
        f9876d = s.q(q, "download/");
        f9877e = "display.json";
        f9878f = "icon.png";
        f9879g = "icon.jpg";
        f9880h = "icon.jpeg";
    }

    private a() {
    }

    public final String a() {
        return f9877e;
    }

    public final String b(String md5) {
        s.h(md5, "md5");
        return s.q(f9876d, md5);
    }

    public final String c() {
        return c;
    }

    public final String d(String md5) {
        s.h(md5, "md5");
        return c + md5 + ((Object) File.separator);
    }

    public final String e() {
        return f9878f;
    }

    public final String f() {
        return f9880h;
    }

    public final String g() {
        return f9879g;
    }
}
