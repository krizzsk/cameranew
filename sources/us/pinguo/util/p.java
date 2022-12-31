package us.pinguo.util;

import java.util.Locale;
import java.util.TimeZone;
/* compiled from: LocalUtils.kt */
/* loaded from: classes6.dex */
public final class p {
    public static final p a = new p();
    private static final String[] b = {"America/New_York", "America/Denver", "America/Costa_Rica", "America/Chicago", "America/Mexico_City", "America/Regina", "America/Los_Angeles", "America/Phoenix", "America/Tijuana", "America/Anchorage", "America/Adak", "Pacific/Honolulu", "America/Metlakatla"};
    private static final String[] c = {"CA", "JP", "KR", "HK", "MO", "TW", "TH", "SG", "MY"};

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f12484d;

    private p() {
    }

    private final String b() {
        String id = TimeZone.getDefault().getID();
        kotlin.jvm.internal.s.g(id, "getDefault().id");
        return id;
    }

    public static final boolean c() {
        boolean z;
        boolean m;
        Boolean bool = f12484d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (kotlin.jvm.internal.s.c("US", Locale.getDefault().getCountry())) {
            m = kotlin.collections.n.m(b, a.b());
            if (m) {
                z = true;
                f12484d = Boolean.valueOf(z);
                return z;
            }
        }
        z = false;
        f12484d = Boolean.valueOf(z);
        return z;
    }

    public static final boolean d() {
        boolean n;
        n = kotlin.text.t.n(Locale.getDefault().getLanguage(), Locale.CHINESE.toString(), true);
        return n;
    }

    public static final boolean e() {
        Locale locale = Locale.getDefault();
        return kotlin.jvm.internal.s.c("zh", locale.getLanguage()) && kotlin.jvm.internal.s.c("CN", locale.getCountry());
    }

    public final String a() {
        if (c()) {
            return "US";
        }
        String country = Locale.getDefault().getCountry();
        kotlin.jvm.internal.s.g(country, "getDefault().country");
        return country;
    }

    public final boolean f() {
        String str;
        boolean n;
        if (c()) {
            return true;
        }
        String country = Locale.getDefault().getCountry();
        String[] strArr = c;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = null;
                break;
            }
            str = strArr[i2];
            i2++;
            n = kotlin.text.t.n(str, country, true);
            if (n) {
                break;
            }
        }
        return str != null;
    }
}
