package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;
/* compiled from: ProcessLevelSPDB.java */
/* loaded from: classes2.dex */
public class h {
    private static volatile boolean a = false;
    private static SharePrefrenceHelper b;

    public static synchronized void a(String str) {
        synchronized (h.class) {
            s();
            b.putString("key_switches", str);
        }
    }

    private static synchronized void b(boolean z) {
        synchronized (h.class) {
            if (b == null || z) {
                SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
                b = sharePrefrenceHelper;
                sharePrefrenceHelper.open("mob_commons", 1);
            }
        }
    }

    public static synchronized void c(String str) {
        synchronized (h.class) {
            s();
            if (str == null) {
                b.remove("key_conf_url");
            } else {
                b.putString("key_conf_url", str);
            }
        }
    }

    public static synchronized String d() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_lduid");
        }
        return string;
    }

    public static synchronized HashMap<String, Object> e() {
        synchronized (h.class) {
            s();
            String string = b.getString("key_channels");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new Hashon().fromJson(string);
        }
    }

    public static synchronized String f() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_privacy_policy_txt");
        }
        return string;
    }

    public static synchronized int g() {
        int i2;
        synchronized (h.class) {
            s();
            i2 = b.getInt("key_policy_txt_related_version");
        }
        return i2;
    }

    public static synchronized String h() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_privacy_policy_url");
        }
        return string;
    }

    public static synchronized int i() {
        int i2;
        synchronized (h.class) {
            s();
            i2 = b.getInt("key_policy_url_related_version");
        }
        return i2;
    }

    public static synchronized String j() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_privacy_policy_language");
        }
        return string;
    }

    public static synchronized boolean k() {
        synchronized (h.class) {
            s();
        }
        return true;
    }

    public static synchronized int l() {
        int i2;
        synchronized (h.class) {
            s();
            i2 = b.getInt("key_pp_grtd", -1);
        }
        return i2;
    }

    public static synchronized int m() {
        synchronized (h.class) {
            s();
        }
        return 0;
    }

    public static synchronized int n() {
        synchronized (h.class) {
            s();
        }
        return 0;
    }

    public static synchronized Boolean o() {
        Boolean bool;
        synchronized (h.class) {
            s();
            int i2 = b.getInt("key_re_upload_policy_grant_result", -1);
            if (i2 == 1) {
                bool = Boolean.TRUE;
            } else {
                bool = i2 == 0 ? Boolean.FALSE : null;
            }
        }
        return bool;
    }

    public static synchronized long p() {
        long j2;
        synchronized (h.class) {
            s();
            j2 = b.getLong("key_next_request_duid_time");
        }
        return j2;
    }

    public static synchronized long q() {
        long j2;
        synchronized (h.class) {
            s();
            j2 = b.getLong("key_first_launch_time", 0L);
        }
        return j2;
    }

    public static void r() {
    }

    private static synchronized void s() {
        synchronized (h.class) {
            b(false);
        }
    }

    public static synchronized void d(String str) {
        synchronized (h.class) {
            s();
            b.putString("key_lduid", str);
        }
    }

    public static synchronized void f(String str) {
        synchronized (h.class) {
            s();
            b.putString("key_privacy_policy_url", str);
        }
    }

    public static synchronized void g(String str) {
        synchronized (h.class) {
            s();
            b.putString("key_privacy_policy_language", str);
        }
    }

    public static synchronized String a() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_switches");
        }
        return string;
    }

    public static synchronized void b(String str) {
        synchronized (h.class) {
            s();
            if (str == null) {
                b.remove("key_data_url");
            } else {
                b.putString("key_data_url", str);
            }
        }
    }

    public static synchronized String c() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_conf_url");
        }
        return string;
    }

    public static synchronized void a(long j2) {
        synchronized (h.class) {
            s();
            b.putLong("key_backend_time", Long.valueOf(j2));
        }
    }

    public static synchronized void d(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_pprfms", Integer.valueOf(i2));
        }
    }

    public static synchronized void e(String str) {
        synchronized (h.class) {
            s();
            b.putString("key_privacy_policy_txt", str);
        }
    }

    public static synchronized void f(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_pprsbs", Integer.valueOf(i2));
        }
    }

    public static synchronized void g(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_pprspw", Integer.valueOf(i2));
        }
    }

    public static synchronized void c(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_pp_grtd", Integer.valueOf(i2));
        }
    }

    public static synchronized void a(HashMap<String, Object> hashMap) {
        synchronized (h.class) {
            s();
            b.putString("key_channels", new Hashon().fromHashMap(hashMap));
        }
    }

    public static synchronized String b() {
        String string;
        synchronized (h.class) {
            s();
            string = b.getString("key_data_url");
        }
        return string;
    }

    public static synchronized void e(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_pprdms", Integer.valueOf(i2));
        }
    }

    public static synchronized void c(long j2) {
        synchronized (h.class) {
            s();
            b.putLong("key_first_launch_time", Long.valueOf(j2));
        }
    }

    public static synchronized void b(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_policy_url_related_version", Integer.valueOf(i2));
        }
    }

    public static synchronized void a(int i2) {
        synchronized (h.class) {
            s();
            b.putInt("key_policy_txt_related_version", Integer.valueOf(i2));
        }
    }

    public static synchronized void b(long j2) {
        synchronized (h.class) {
            s();
            b.putLong("key_next_request_duid_time", Long.valueOf(j2));
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (h.class) {
            s();
            b.putBoolean("key_pp_ncsy", Boolean.valueOf(z));
        }
    }

    public static synchronized void a(Boolean bool) {
        int i2;
        synchronized (h.class) {
            s();
            if (bool == null) {
                i2 = -1;
            } else {
                i2 = bool.booleanValue() ? 1 : 0;
            }
            b.putInt("key_re_upload_policy_grant_result", Integer.valueOf(i2));
        }
    }
}
