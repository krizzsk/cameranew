package us.pinguo.foundation.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* compiled from: LocaleSupport.java */
/* loaded from: classes4.dex */
public abstract class t<T> {
    public static final Locale a;
    public static final Locale b;
    public static final Locale c;

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f11112d;

    /* renamed from: e  reason: collision with root package name */
    public static final Locale[] f11113e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f11114f;

    /* renamed from: g  reason: collision with root package name */
    private static Map<Locale, Integer> f11115g;

    static {
        Locale locale = new Locale("zh", "CN");
        a = locale;
        new Locale("zh", "HK");
        Locale locale2 = new Locale("zh", "TW");
        b = locale2;
        Locale locale3 = new Locale("en", "US");
        c = locale3;
        Locale locale4 = new Locale("th", "TH");
        f11112d = locale4;
        Locale[] localeArr = {locale, locale2, locale3, locale4};
        f11113e = localeArr;
        HashMap hashMap = new HashMap();
        f11115g = hashMap;
        hashMap.put(locale, 0);
        f11115g.put(locale2, 1);
        f11115g.put(locale3, 2);
        f11115g.put(locale4, 3);
        f11114f = new HashSet();
        for (Locale locale5 : localeArr) {
            f11114f.add(b(locale5));
        }
    }

    public static int a(Locale locale) {
        Integer num = f11115g.get(locale);
        if (num != null) {
            return num.intValue();
        }
        if (locale.getLanguage().equals("zh")) {
            return 1;
        }
        return (!locale.getLanguage().equals("en") && locale.getLanguage().equals("th")) ? 3 : 2;
    }

    public static String b(Locale locale) {
        return f11113e[a(locale)].toString();
    }

    @Deprecated
    public static String c(String str) {
        if (str == null) {
            return "UNKNOW";
        }
        String[] split = str.split("\\n");
        Locale a2 = v.a();
        String language = a2.getLanguage();
        String country = a2.getCountry();
        if ("zh_CN".equals(language + "_" + country) && split.length > 0) {
            return split[0];
        }
        if ("zh".equals(language) && split.length > 1) {
            return split[1];
        }
        if (!"th".equals(language) || split.length <= 4) {
            return split.length > 3 ? split[3] : "UNKNOW";
        }
        return split[4];
    }
}
