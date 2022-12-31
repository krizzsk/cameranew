package us.pinguo.user;

import androidx.core.app.NotificationCompat;
/* compiled from: Statistics.java */
/* loaded from: classes6.dex */
public class w0 extends us.pinguo.foundation.statistics.g {
    public static void g(boolean z) {
        String str = z ? NotificationCompat.CATEGORY_EMAIL : "phone";
        j.a.f.e.onEvent("id_cloud_1_7", str);
        us.pinguo.foundation.statistics.g.b("cloud_7_7_" + str);
    }

    public static void h(int i2) {
        String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? (i2 == 4 || i2 == 5) ? "login_use_huawei" : "" : "login_use_twitter" : "login_use_facebook" : "login_use_weibo" : "login_use_qq";
        j.a.f.e.onEvent("id_other_7_6", str);
        us.pinguo.foundation.statistics.g.b("other_7_6_" + str);
    }

    public static void i(int i2) {
        String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "btn_register" : "btn_password_findBack" : "btn_login_success" : "btn_login";
        j.a.f.e.onEvent("id_other_7_2", str);
        us.pinguo.foundation.statistics.g.b("other_7_2_" + str);
    }

    public static void j(int i2) {
        String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "lay_community" : "lay_store" : "lay_cloud" : "lay_my";
        j.a.f.e.onEvent("id_other_7_1", str);
        us.pinguo.foundation.statistics.g.b("other_7_1_" + str);
    }

    public static void k(int i2) {
        String str = i2 != 0 ? i2 != 1 ? "" : "register_use_email" : "register_use_phone";
        j.a.f.e.onEvent("id_other_7_3", str);
        us.pinguo.foundation.statistics.g.b("other_7_3_" + str);
    }
}
