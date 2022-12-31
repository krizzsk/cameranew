package us.pinguo.inspire.util;

import android.content.Context;
import java.util.Locale;
/* compiled from: LocaleUtils.java */
/* loaded from: classes4.dex */
public class r {
    public static String a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale == null) {
            return "";
        }
        return (locale.getLanguage() + "_" + locale.getCountry()).toLowerCase();
    }
}
