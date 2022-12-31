package us.pinguo.hawkeye.util;

import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;
import kotlin.jvm.internal.s;
/* compiled from: CommonInfoUtils.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final String a() {
        Locale locale = Locale.getDefault();
        s.d(locale, "Locale.getDefault()");
        String country = locale.getCountry();
        s.d(country, "Locale.getDefault().country");
        return country;
    }

    public final String b() {
        Locale locale = Locale.getDefault();
        s.d(locale, "Locale.getDefault()");
        String language = locale.getLanguage();
        s.d(language, "Locale.getDefault().language");
        return language;
    }

    public final String c() {
        String str = Build.MANUFACTURER;
        s.d(str, "Build.MANUFACTURER");
        return str;
    }

    public final String d() {
        String str = Build.MODEL;
        s.d(str, "Build.MODEL");
        return str;
    }

    public final String e() {
        String str = Build.VERSION.RELEASE;
        s.d(str, "Build.VERSION.RELEASE");
        return str;
    }

    public final float f() {
        Resources system = Resources.getSystem();
        s.d(system, "Resources.getSystem()");
        return system.getDisplayMetrics().density;
    }

    public final int g() {
        Resources system = Resources.getSystem();
        s.d(system, "Resources.getSystem()");
        return system.getDisplayMetrics().densityDpi;
    }

    public final int h() {
        Resources system = Resources.getSystem();
        s.d(system, "Resources.getSystem()");
        return system.getDisplayMetrics().heightPixels;
    }

    public final int i() {
        Resources system = Resources.getSystem();
        s.d(system, "Resources.getSystem()");
        return system.getDisplayMetrics().widthPixels;
    }

    public final String[] j() {
        if (Build.VERSION.SDK_INT < 21) {
            String str = Build.CPU_ABI;
            s.d(str, "Build.CPU_ABI");
            String str2 = Build.CPU_ABI2;
            s.d(str2, "Build.CPU_ABI2");
            return new String[]{str, str2};
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        s.d(strArr, "Build.SUPPORTED_ABIS");
        return strArr;
    }
}
