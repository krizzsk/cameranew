package us.pinguo.foundation.utils;

import java.util.Locale;
/* compiled from: LocaleUtil.java */
/* loaded from: classes4.dex */
public class u {
    public static final boolean a() {
        Locale a = v.a();
        return "zh".equals(a.getLanguage()) && "cn".equalsIgnoreCase(a.getCountry());
    }

    public static final boolean b() {
        return "zh".equalsIgnoreCase(v.a().getLanguage());
    }

    public static final boolean c() {
        Locale locale = Locale.getDefault();
        if ("zh".equals(locale.getLanguage())) {
            return !"cn".equalsIgnoreCase(locale.getCountry());
        }
        return false;
    }

    public static final boolean d() {
        return "ko".equalsIgnoreCase(v.a().getLanguage());
    }
}
