package d.e.d.a;

import com.facebook.ads.AdError;
/* compiled from: SDK5Events.java */
/* loaded from: classes2.dex */
public class f {
    public static a a = new a(AdError.INTERNAL_ERROR_CODE, a("initsdk"));
    public static a b = new a(AdError.CACHE_ERROR_CODE, a("createcontrollerweb"));
    public static a c = new a(AdError.INTERNAL_ERROR_2003, a("createcontrollernative"));

    /* renamed from: d  reason: collision with root package name */
    public static a f8534d = new a(AdError.INTERNAL_ERROR_2004, a("controllerstageready"));

    /* renamed from: e  reason: collision with root package name */
    public static a f8535e = new a(2005, a("loadad"));

    /* renamed from: f  reason: collision with root package name */
    public static a f8536f = new a(AdError.INTERNAL_ERROR_2006, a("loadadfailed"));

    /* renamed from: g  reason: collision with root package name */
    public static a f8537g = new a(2007, a("initproduct"));

    /* renamed from: h  reason: collision with root package name */
    public static a f8538h = new a(AdError.REMOTE_ADS_SERVICE_ERROR, a("initproductfailed"));

    /* renamed from: i  reason: collision with root package name */
    public static a f8539i = new a(AdError.INTERSTITIAL_AD_TIMEOUT, a("loadproduct"));

    /* renamed from: j  reason: collision with root package name */
    public static a f8540j = new a(2010, a("parseadmfailed"));

    /* renamed from: k  reason: collision with root package name */
    public static a f8541k = new a(2011, a("loadadsuccess"));

    /* renamed from: l  reason: collision with root package name */
    public static a f8542l = new a(2013, a("controllerfailed"));
    public static a m = new a(2014, a("extractinstalledpackagesfailed"));
    public static a n = new a(2015, a("appendnativefeaturesdatafailed"));
    public static a o = new a(2016, a("adunitcouldnotloadtowebview"));
    public static a p = new a(2017, a("webviewcleanupfailed"));
    public static a q = new a(2018, a("removewebviewfailed"));
    public static a r = new a(2019, a("adunitcouldnotloadtowebviewbanners"));
    public static a s = new a(2020, a("banneralreadydestroyed"));
    public static a t = new a(2021, a("fialedregactlifecycle"));
    public static a u = new a(2022, a("loadcontrollerhtml"));
    public static a v = new a(2023, a("controllerhtmlsuccess"));
    public static a w = new a(2024, a("controllerhtmlfailed"));
    public static a x = new a(2025, a("webviewcrashrpg"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SDK5Events.java */
    /* loaded from: classes2.dex */
    public static class a {
        String a;
        int b;

        a(int i2, String str) {
            this.b = i2;
            this.a = str;
        }
    }

    static String a(String str) {
        return "n_" + str;
    }
}
