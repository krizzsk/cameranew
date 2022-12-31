package us.pinguo.camera360.shop.data.install;

import java.io.File;
/* compiled from: ResourceUtil.java */
/* loaded from: classes3.dex */
public class t {
    private static final String a;
    public static final String b;
    public static final String c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f9608d;

    static {
        String str = us.pinguo.util.v.e(".filter") + "/";
        a = str;
        b = str + "files/";
        String str2 = us.pinguo.util.v.d() + "/download";
        c = str2;
        f9608d = str2 + "/";
        String str3 = str + "detail/";
    }

    public static String a(String str) {
        return f9608d + str;
    }

    public static String b(String str, String str2) {
        return c(str) + str2 + File.separator;
    }

    public static String c(String str) {
        return b + str + "/";
    }
}
