package us.pinguo.repository2020.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.v;
/* compiled from: RequestIntervalPref.kt */
/* loaded from: classes6.dex */
public final class RequestIntervalPref {
    private static SharedPreferences b;
    public static final RequestIntervalPref a = new RequestIntervalPref();
    private static final HashMap<String, String> c = new HashMap<>();

    /* compiled from: RequestIntervalPref.kt */
    /* loaded from: classes6.dex */
    public enum RefreshType {
        NONE_REFRESH,
        RESET_REFRESH,
        TIME_REFRESH
    }

    private RequestIntervalPref() {
    }

    private final String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('_');
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append('_');
        Context b2 = us.pinguo.foundation.e.b();
        s.g(b2, "getAppContext()");
        sb.append(us.pinguo.util.s.e(b2));
        sb.append('_');
        sb.append(Build.VERSION.SDK_INT);
        String sb2 = sb.toString();
        HashMap<String, String> hashMap = c;
        String str3 = hashMap.get(sb2);
        if (str3 == null) {
            str3 = new d.f.a.a.a.d.c().a(sb2);
            hashMap.put(sb2, str3);
        }
        s.e(str3);
        return str3;
    }

    private final synchronized SharedPreferences b() {
        SharedPreferences sharedPreferences;
        if (b == null) {
            b = us.pinguo.foundation.e.b().getSharedPreferences("request_interval_pref", 0);
        }
        sharedPreferences = b;
        s.e(sharedPreferences);
        return sharedPreferences;
    }

    public final RefreshType c(String url, long j2, String str) {
        s.h(url, "url");
        String a2 = a(url, str);
        String q = s.q(a2, "_time");
        String q2 = s.q(a2, "_lng");
        SharedPreferences b2 = b();
        long j3 = b2.getLong(q, 0L);
        String string = b2.getString(q2, null);
        if (j2 == -1) {
            j2 = b2.getLong(s.q(a2, "_interval"), 7200000L);
        }
        Locale a3 = v.a();
        if (!s.c(a3.getLanguage() + '_' + ((Object) a3.getCountry()), string)) {
            return RefreshType.RESET_REFRESH;
        }
        if (Math.abs(System.currentTimeMillis() - j3) >= j2) {
            return RefreshType.TIME_REFRESH;
        }
        return RefreshType.NONE_REFRESH;
    }

    public final void d(String url, long j2, String str) {
        s.h(url, "url");
        String a2 = a(url, str);
        String q = s.q(a2, "_time");
        String q2 = s.q(a2, "_lng");
        Locale a3 = v.a();
        SharedPreferences.Editor edit = b().edit();
        edit.putLong(q, System.currentTimeMillis());
        edit.putString(q2, a3.getLanguage() + '_' + ((Object) a3.getCountry()));
        if (j2 > 60000) {
            edit.putLong(s.q(a2, "_interval"), j2);
        }
        edit.apply();
    }
}
