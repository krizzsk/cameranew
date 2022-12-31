package us.pinguo.foundation.utils;

import java.util.Locale;
/* compiled from: PhoneLocale.java */
/* loaded from: classes4.dex */
public final class z {
    public static boolean a(Locale locale) {
        return "ja".equals(locale.getLanguage().toLowerCase(Locale.ENGLISH));
    }

    public static boolean b(Locale locale) {
        return locale != null && "zh".equals(locale.getLanguage()) && "CN".equals(locale.getCountry());
    }
}
