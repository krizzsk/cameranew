package us.pinguo.camera360.shop.download;

import us.pinguo.foundation.d;
/* compiled from: ShopUrls.java */
/* loaded from: classes4.dex */
public class a {
    public static final String a;
    public static final String b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f9706d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f9707e;

    static {
        boolean z = d.f10985d;
        String str = z ? d.b ? "https://bmall-qa.camera360.com" : "https://bmall-dev.camera360.com" : "https://bmall.camera360.com";
        a = str;
        b = str + "/api/product/query";
        String str2 = z ? "http://sharetest1.camera360.com" : "http://share.camera360.com";
        c = str2;
        f9706d = str2 + "/api/share/detail";
        f9707e = z ? "http://optimize.360in.com" : "https://optimize.360in.com";
    }
}
