package us.pinguo.camera360.shop.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import d.f.a.a.a.d.c;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.v;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: RequestIntervalPref.kt */
/* loaded from: classes4.dex */
public final class RequestIntervalPref {
    private static SharedPreferences b;
    public static final RequestIntervalPref a = new RequestIntervalPref();
    private static final HashMap<String, String> c = new HashMap<>();

    /* compiled from: RequestIntervalPref.kt */
    /* loaded from: classes4.dex */
    public enum RefreshType {
        NONE_REFRESH,
        RESET_REFRESH,
        TIME_REFRESH
    }

    private RequestIntervalPref() {
    }

    private final String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('_');
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append('_');
        Context d2 = BaseApplication.d();
        s.g(d2, "getAppContext()");
        sb.append(us.pinguo.util.s.e(d2));
        sb.append('_');
        sb.append(Build.VERSION.SDK_INT);
        String sb2 = sb.toString();
        HashMap<String, String> hashMap = c;
        String str3 = hashMap.get(sb2);
        if (str3 == null) {
            String a2 = new c().a(sb2);
            hashMap.put(sb2, a2);
            return a2;
        }
        return str3;
    }

    private final synchronized SharedPreferences d() {
        SharedPreferences sharedPreferences;
        sharedPreferences = b;
        if (sharedPreferences == null) {
            sharedPreferences = BaseApplication.d().getSharedPreferences("request_interval_pref", 0);
            b = sharedPreferences;
        }
        return sharedPreferences;
    }

    public final void a() {
        d().edit().clear().apply();
    }

    public final long c(String url, String str) {
        s.h(url, "url");
        String b2 = b(url, str);
        s.e(b2);
        return d().getLong(s.q(b2, "_interval"), 7200000L);
    }

    public final RefreshType e(String url, long j2, String str) {
        s.h(url, "url");
        String b2 = b(url, str);
        s.e(b2);
        String q = s.q(b2, "_time");
        String q2 = s.q(b2, "_lng");
        SharedPreferences d2 = d();
        long j3 = d2.getLong(q, 0L);
        String string = d2.getString(q2, null);
        if (j2 == -1) {
            j2 = d2.getLong(s.q(b2, "_interval"), 7200000L);
        }
        Locale a2 = v.a();
        if (!s.c(a2.getLanguage() + '_' + ((Object) a2.getCountry()), string)) {
            return RefreshType.RESET_REFRESH;
        }
        if (Math.abs(System.currentTimeMillis() - j3) >= j2) {
            return RefreshType.TIME_REFRESH;
        }
        return RefreshType.NONE_REFRESH;
    }

    public final void f(String url, String str) {
        s.h(url, "url");
        String b2 = b(url, str);
        s.e(b2);
        String q = s.q(b2, "_lng");
        SharedPreferences.Editor edit = d().edit();
        edit.putString(q, "--");
        edit.apply();
    }

    public final void g(String url, long j2, String str) {
        s.h(url, "url");
        String b2 = b(url, str);
        s.e(b2);
        String q = s.q(b2, "_time");
        String q2 = s.q(b2, "_lng");
        Locale a2 = v.a();
        SharedPreferences.Editor edit = d().edit();
        edit.putLong(q, System.currentTimeMillis());
        edit.putString(q2, a2.getLanguage() + '_' + ((Object) a2.getCountry()));
        if (j2 > 60000) {
            edit.putLong(s.q(b2, "_interval"), j2);
        }
        edit.apply();
    }
}
