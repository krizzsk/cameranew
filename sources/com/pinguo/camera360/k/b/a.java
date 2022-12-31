package com.pinguo.camera360.k.b;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.pinguo.camera360.lib.feedback.FeventId$camera;
import java.net.URLEncoder;
import java.util.Locale;
import us.pinguo.foundation.utils.n0;
import us.pinguo.foundation.utils.v;
import vStudio.Android.Camera360.R;
/* compiled from: PgStatistics.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.foundation.statistics.g {

    /* compiled from: PgStatistics.java */
    /* renamed from: com.pinguo.camera360.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0243a {
        public static void a() {
            us.pinguo.foundation.statistics.g.b("another_7_50");
            j.a.f.e.onEvent("id_another_50");
        }

        public static void b() {
            us.pinguo.foundation.statistics.g.b("another_7_51");
            j.a.f.e.onEvent("id_another_51");
        }

        public static void c(String str) {
            j.a.f.e.onEvent("id_another_10", str);
            us.pinguo.foundation.statistics.g.b("another_7_10_" + str);
        }

        public static void d(String str) {
            us.pinguo.foundation.statistics.g.b("another_7_4_" + str);
            j.a.f.e.onEvent("id_another_4", str);
        }

        public static void e(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            us.pinguo.foundation.statistics.g.b("another_7_46_" + str);
            j.a.f.e.onEvent("id_another_46", str);
        }

        public static void f(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            us.pinguo.foundation.statistics.g.b("another_7_47_" + str);
            j.a.f.e.onEvent("id_another_47", str);
        }

        public static void g(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            us.pinguo.foundation.statistics.g.b("another_7_49_" + str);
            j.a.f.e.onEvent("id_another_49", str);
        }

        public static void h(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            us.pinguo.foundation.statistics.g.b("another_7_48_" + str);
            j.a.f.e.onEvent("id_another_48", str);
        }

        public static void i(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            us.pinguo.foundation.statistics.g.b("another_45_" + str);
            j.a.f.e.onEvent("id_another_7_45", str);
        }

        public static void j(int i2) {
            String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "JSONException_local" : "IOException_data_read_fail" : "JSONException_services" : "IOException_save" : "GeneralSecurityException" : "IOException_request";
            us.pinguo.foundation.statistics.g.b("another_7_2_" + str);
            j.a.f.e.onEvent("id_another_2", str);
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class b {
        public static String a = "filter";
        public static String b = "sticker";
        public static String c = "list";

        /* renamed from: d  reason: collision with root package name */
        public static String f6820d = "topic";

        /* renamed from: e  reason: collision with root package name */
        public static String f6821e = "share_success";

        /* renamed from: f  reason: collision with root package name */
        public static String f6822f = "login_success";

        public static void a() {
            j.a.f.e.onEvent("id_0_2");
            j.a.f.e.f(String.valueOf(System.currentTimeMillis()));
        }

        public static void b(String str, String str2) {
            if (str.equals(str2)) {
                return;
            }
            j.a.f.e.onEvent("id_0_1", str, str2);
        }

        public static void c() {
            j.a.f.e.onEvent(FeventId$camera.id_1_6.name(), "0");
            us.pinguo.foundation.statistics.g.b("camera_7_116");
        }

        public static void d(boolean z) {
            String name;
            String str;
            if (z) {
                name = FeventId$camera.id_1_19_1.name();
                str = "home";
            } else {
                name = FeventId$camera.id_1_19_2.name();
                str = "camera";
            }
            j.a.f.e.onEvent(name);
            us.pinguo.foundation.statistics.g.b("camera_7_22_" + str);
            j.a.f.e.onEvent("id_camera_1_22", str);
        }

        public static void e(String str) {
            j.a.f.e.onEvent("id_camera_1_0", str);
            us.pinguo.foundation.statistics.g.b("camera_7_0_" + str);
        }

        public static void f(String str) {
            if (str == null || str.equals("null")) {
                return;
            }
            j.a.f.e.onEvent("id_camera_7_123", str);
            us.pinguo.foundation.statistics.g.b("camera_7_123_" + str);
        }

        public static void g() {
            j.a.f.e.onEvent("id_camera_7_122");
            us.pinguo.foundation.statistics.g.b("camera_7_122");
        }

        public static void h(String str, String str2, String str3) {
            String str4;
            if (str3 == null) {
                str4 = "material_type=" + str + ",material_package_id=" + str2 + ",material_id=Default";
            } else {
                str4 = "material_type=" + str + ",material_package_id=" + str2 + ",material_id=" + str3;
            }
            j.a.f.e.onEvent("iap_material_buy_success", str4);
            us.pinguo.foundation.statistics.g.b("iap_material_buy_success_" + str4);
        }

        public static void i(String str, String str2, String str3) {
            String str4 = "material_type=" + str + ",material_package_id=" + str2 + ",material_id=" + str3;
            j.a.f.e.onEvent("material_favorite_undo", str4);
            us.pinguo.foundation.statistics.g.b("material_favorite_undo_" + str4);
        }

        public static void j(String str, String str2, String str3) {
            String str4 = "store_type=" + str + ",material_package_id=" + str2 + ",page=" + str3;
            j.a.f.e.onEvent("material_package_delete", str4);
            us.pinguo.foundation.statistics.g.b("material_package_delete_" + str4);
        }

        public static void k(String str, String str2, String str3) {
            String str4 = "store_type=" + str + ",material_package_id=" + str2 + ",page=" + str3;
            j.a.f.e.onEvent("material_package_delete_undo", str4);
            us.pinguo.foundation.statistics.g.b("material_package_delete_undo_" + str4);
        }

        public static void l(String str) {
            String str2 = "card_id=" + str;
            j.a.f.e.onEvent("scene_card_view", str2);
            us.pinguo.foundation.statistics.g.b("scene_card_view_" + str2);
        }

        public static void m(String str) {
            String str2 = "store_type=" + str;
            j.a.f.e.onEvent("store_manage_button_click", str2);
            us.pinguo.foundation.statistics.g.b("store_manage_button_click_" + str2);
        }

        public static void n(String str, String str2, String str3) {
            String str4 = "store_type=" + str + ",material_package_id=" + str2 + ",page=" + str3;
            j.a.f.e.onEvent("store_material_detail_view", str4);
            us.pinguo.foundation.statistics.g.b("store_material_detail_view_" + str4);
        }

        public static void o(String str, String str2, String str3) {
            String str4 = "material_type=" + str + ",material_package_id=" + str2 + ",button_type=" + str3;
            j.a.f.e.onEvent("store_material_download_click", str4);
            us.pinguo.foundation.statistics.g.b("store_material_download_click_" + str4);
            us.pinguo.foundation.statistics.b.d(str, str2, str3);
        }

        public static void p(String str, String str2, String str3) {
            String str4 = "store_type=" + str + ",material_package_id=" + str2 + ",page=" + str3;
            j.a.f.e.onEvent("store_material_package_click", str4);
            us.pinguo.foundation.statistics.g.b("store_material_package_click_" + str4);
        }

        public static void q(String str, String str2) {
            String str3 = "store_type=" + str + ",topic_id=" + str2;
            j.a.f.e.onEvent("store_material_topic_click", str3);
            us.pinguo.foundation.statistics.g.b("store_material_topic_click_" + str3);
        }

        public static void r(String str, String str2) {
            String str3 = "store_type=" + str + ",topic_id=" + str2;
            j.a.f.e.onEvent("store_material_topic_view", str3);
            us.pinguo.foundation.statistics.g.b("store_material_topic_view_" + str3);
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class c {
        public static void a() {
            j.a.f.e.onEvent("id_edit_7_8");
            us.pinguo.foundation.statistics.g.b("edit_7_8");
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class d {
        private static boolean a = true;

        public static void a() {
            j.a.f.e.onEvent("id_c360_gallery_addStory");
            us.pinguo.foundation.statistics.g.b("c360_gallery_addStory");
        }

        public static void b() {
            j.a.f.e.onEvent("id_gallery_4_2");
            us.pinguo.foundation.statistics.g.b("gallery_7_2");
        }

        public static void c(int i2) {
            String str = "gallery_lay_btn_edit";
            switch (i2) {
                case 0:
                case 4:
                    break;
                case 1:
                    str = "pic_info";
                    break;
                case 2:
                    str = "gallery_lay_btn_to_camera";
                    break;
                case 3:
                    str = "gallery_lay_btn_share";
                    break;
                case 5:
                    str = "gallery_lay_btn_superposition";
                    break;
                case 6:
                    str = "gallery_lay_btn_delete";
                    break;
                case 7:
                    str = "gallery_lay_btn_back";
                    break;
                default:
                    str = "";
                    break;
            }
            f(str);
        }

        public static void d() {
            j.a.f.e.onEvent("id_c360_gallery_myAlbum");
            us.pinguo.foundation.statistics.g.b("c360_gallery_myAlbum");
        }

        public static void e() {
            j.a.f.e.onEvent("id_gallery_4_18");
            us.pinguo.foundation.statistics.g.b("gallery_7_18");
        }

        private static void f(String str) {
            String str2 = a ? "gallery_4_19" : "gallery_4_20";
            j.a.f.e.onEvent("id_" + str2, str);
            us.pinguo.foundation.statistics.g.b(str2 + "_" + str);
        }

        public static void g(int i2) {
            String valueOf = i2 < 10 ? String.valueOf(i2) : ">9";
            us.pinguo.foundation.j e2 = us.pinguo.foundation.j.e();
            if (e2 != null) {
                e2.s("key_picture_system_sum", String.valueOf(i2));
                e2.c();
            }
            j.a.f.e.onEvent("id_gallery_4_22", valueOf);
            us.pinguo.foundation.statistics.g.b("gallery_7_22_" + valueOf);
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class e {
        public static void a(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.a.f.e.onEvent("id_other_7_16", str + "," + z);
        }

        public static void b(int i2) {
            String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "lay_community" : "lay_store" : "lay_cloud" : "lay_my";
            j.a.f.e.onEvent("id_other_7_1", str);
            us.pinguo.foundation.statistics.g.b("other_7_1_" + str);
        }

        public static void c() {
            try {
                vStudio.Android.Camera360.activity.h b = vStudio.Android.Camera360.activity.h.b();
                Locale a = v.a();
                String str = "[" + (a.getLanguage() + '_' + a.getCountry()) + ";" + (n0.i() + "x" + n0.h()) + ";" + b.toString() + "]";
                us.pinguo.foundation.statistics.g.b("other_7_14_" + str);
                j.a.f.e.onEvent("idother_7_14", URLEncoder.encode(str, "UTF-8"));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class f {
        public static void a(int i2) {
            String str = i2 == R.id.id_personal_information_logoutBtn ? "quit" : "";
            j.a.f.e.onEvent("id_personal_1_20", str);
            us.pinguo.foundation.statistics.g.b("personal_7_20_" + str);
        }

        public static void b(int i2) {
            String str;
            switch (i2) {
                case 0:
                    str = "enter";
                    break;
                case 1:
                    str = "back";
                    break;
                case 2:
                    str = "header";
                    break;
                case 3:
                    str = "cloud";
                    break;
                case 4:
                default:
                    str = "";
                    break;
                case 5:
                    str = "message";
                    break;
                case 6:
                    str = "fans";
                    break;
                case 7:
                    str = "feedback";
                    break;
                case 8:
                    str = "setting";
                    break;
                case 9:
                    str = "about";
                    break;
                case 10:
                    str = "faq";
                    break;
            }
            j.a.f.e.onEvent("id_personal_1_1", str);
            us.pinguo.foundation.statistics.g.b("personal_7_1_" + str);
        }

        public static void c(int i2) {
            String str;
            switch (i2) {
                case 0:
                    str = "FeedBack";
                    break;
                case 1:
                    str = "Store";
                    break;
                case 2:
                    str = "EffectDetail";
                    break;
                case 3:
                    str = "Setting";
                    break;
                case 4:
                    str = "Cart";
                    break;
                case 5:
                    str = "Center";
                    break;
                case 6:
                    str = "Center_Cloud";
                    break;
                case 7:
                    str = "Gallery_Cloud";
                    break;
                default:
                    str = "";
                    break;
            }
            j.a.f.e.onEvent("id_personal_1_6", str);
            us.pinguo.foundation.statistics.g.b("personal_7_6_" + str);
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class g {
        public static void a(String str, String str2) {
            String str3;
            if (Constants.MessageTypes.MESSAGE.equals(str)) {
                str3 = "push_10_10";
            } else if ("xiaomi".equals(str)) {
                str3 = "push_10_11";
            } else if (!"umeng".equals(str)) {
                return;
            } else {
                str3 = "push_10_12";
            }
            us.pinguo.foundation.statistics.g.b(str3 + "_" + str2);
            StringBuilder sb = new StringBuilder();
            sb.append("id_");
            sb.append(str3);
            j.a.f.e.onEvent(sb.toString(), str2);
        }

        public static void b(int i2, String str) {
            String str2 = i2 != 1 ? i2 != 2 ? null : "receive" : "click";
            if (str != null && !str.equals("")) {
                j.a.f.e.onEvent("id_push_8_1", str2, str);
            } else {
                j.a.f.e.onEvent("id_push_8_1", str2);
            }
            us.pinguo.foundation.statistics.g.b("push_7_1_" + str2 + "_" + str);
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class h {
        public static void a(boolean z) {
            String str = z ? NotificationCompat.CATEGORY_EMAIL : "phone";
            us.pinguo.foundation.statistics.g.b("setting_7_20_" + str);
            j.a.f.e.onEvent("id_setting_7_20");
        }

        public static void b() {
            j.a.f.e.onEvent("id_setting_7_2");
            us.pinguo.foundation.statistics.g.b("setting_7_2");
        }

        public static void c(boolean z) {
            String str = z ? "home" : "camera";
            j.a.f.e.onEvent("id_setting_7_19", str);
            us.pinguo.foundation.statistics.g.b("setting_7_19_" + str);
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class i {
        public static void a(int i2, String str) {
            if (i2 == 0) {
                j.a.f.e.onEvent("id_share_7_28", str);
                us.pinguo.foundation.statistics.g.b("share_7_28_" + str);
            } else if (i2 == 1) {
                j.a.f.e.onEvent("id_share_7_29", str);
                us.pinguo.foundation.statistics.g.b("share_7_29_" + str);
            } else if (i2 == 2) {
                j.a.f.e.onEvent("id_share_7_30", str);
                us.pinguo.foundation.statistics.g.b("share_7_30_" + str);
            } else if (i2 != 3) {
            } else {
                j.a.f.e.onEvent("id_share_6_12", str);
                us.pinguo.foundation.statistics.g.b("share_7_12_" + str);
            }
        }
    }

    /* compiled from: PgStatistics.java */
    /* loaded from: classes3.dex */
    public static class j {
        public static String a = "0";
        public static int b = -1;

        public static void a(String str) {
            j.a.f.e.onEvent("id_store_9_2", str);
            us.pinguo.foundation.statistics.g.b("store_7_2_" + str);
        }

        public static void b(String str) {
            j.a.f.e.onEvent("id_store_9_3", str);
            us.pinguo.foundation.statistics.g.b("store_7_3_" + str);
        }
    }

    public static void g(Activity activity) {
        if (activity != null) {
            j.a.f.e.c();
            if (activity instanceof us.pinguo.foundation.statistics.e) {
                us.pinguo.foundation.statistics.f.b(((us.pinguo.foundation.statistics.e) activity).C(), true);
            } else {
                us.pinguo.foundation.statistics.f.b(activity.getClass().getSimpleName(), false);
            }
        }
    }

    public static boolean h(Activity activity) {
        if (activity != null) {
            j.a.f.e.d();
            String simpleName = activity.getClass().getSimpleName();
            if (activity instanceof us.pinguo.foundation.statistics.e) {
                simpleName = ((us.pinguo.foundation.statistics.e) activity).C();
            }
            us.pinguo.foundation.statistics.h.a.i(simpleName);
            return us.pinguo.foundation.statistics.f.c(simpleName);
        }
        return false;
    }
}
