package us.pinguo.foundation.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.foundation.utils.n0;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.util.u;
/* compiled from: Statistics.java */
/* loaded from: classes4.dex */
public class k {
    public static void a(int i2) {
        String str = "from=" + (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER : "index_plus" : "index_shotcut" : "index_functional");
        j.a.f.e.onEvent("enter_camera_page", str);
        g.b("enter_camera_page_" + str);
    }

    public static void b() {
        j.a.f.e.onEvent("enter_camera_from_index_plus_page");
        g.b("enter_camera_from_index_plus_page");
    }

    private static String c(String str) {
        if ("click".equals(str)) {
            String str2 = n0.l(us.pinguo.foundation.e.b()) ? "yes" : "no";
            n0.p(us.pinguo.foundation.e.b());
            return str2;
        }
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    private static String d(String str, String str2) {
        return TextUtils.isEmpty(str) ? "unknown" : !TextUtils.isEmpty(str2) ? "op" : str.contains("app://inspire/at") ? "@" : str.contains("app://inspire/like") ? "like" : str.contains("app://inspire/vote") ? InspireMsg.TYPE_VOTE : str.contains("app://inspire/award") ? "award" : str.contains("app://inspire/comment") ? "comment" : str.contains("app://inspire/attention") ? "fan" : str.contains("app://inspire/pcmessagelist") ? "pcmessagelist" : str.contains("app://inspire/system") ? "system" : (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) || str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) ? "http" : str;
    }

    public static void e(int i2, String str) {
        String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : "receive" : "update_later" : "update_now" : "click";
        if (str != null && !str.equals("")) {
            j.a.f.e.onEvent("id_push_8_2", str2, str);
        } else {
            j.a.f.e.onEvent("id_push_8_2", str2);
        }
        g.b("push_7_2_" + str2 + "_" + str);
    }

    public static void f(int i2, String str) {
        String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : "back" : "button_2" : "button_1" : "click" : "show";
        if (str != null && !str.equals("")) {
            j.a.f.e.onEvent("id_push_10_5", str2, str);
        } else {
            j.a.f.e.onEvent("id_push_10_5", str2);
        }
        g.b("push_7_5_" + str2 + "_" + str);
    }

    public static void g(int i2, String str) {
        String str2 = i2 != 0 ? i2 != 5 ? "" : "receive" : "click";
        if (str != null && !str.equals("")) {
            j.a.f.e.onEvent("id_push_7_4", str2, str);
        } else {
            j.a.f.e.onEvent("id_push_7_4", str2);
        }
        g.b("push_7_4_" + str2 + "_" + str);
    }

    public static void h(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        j.a.f.e.onEvent("id_push_10_9", str);
        g.b("push_7_9_" + str);
    }

    public static void i(int i2, String str) {
        String str2 = i2 != 0 ? i2 != 1 ? "" : "click" : "show";
        if (str != null && !str.equals("")) {
            j.a.f.e.onEvent("id_push_10_1", str2, str);
        } else {
            j.a.f.e.onEvent("id_push_10_1", str2);
        }
        g.b("push_7_3_" + str2 + "_" + str);
    }

    public static void j(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean equals = "5976eefb8852d6140a235ed7".equals(str2);
        String d2 = equals ? "local" : d(str3, str6);
        String c = c(str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(d2) || d2.matches("@|like|vote|like|award|comment|fan")) {
            str2 = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        if (equals) {
            str2 = u.d(System.currentTimeMillis(), AdvTimeUtils.DATE_FORMAT_DAY);
        }
        String n = n(str5);
        StringBuilder sb = new StringBuilder();
        sb.append("push_id=" + str2);
        sb.append(",push_type=" + d2);
        sb.append(",action=" + str);
        sb.append(",is_active=" + c);
        if (!"op".equals(d2)) {
            n = TaskDetailBasePresenter.SCENE_LIST;
        }
        sb.append(",show_type=" + n);
        l.i(us.pinguo.foundation.e.b(), "push_action", sb.toString());
        b.b(str2, d2, str, n, c);
    }

    public static void k(int i2, String str) {
        String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : "back" : "update_later" : "update_now" : "click" : "show";
        if (str != null && !str.equals("")) {
            j.a.f.e.onEvent("id_push_10_6", str2, str);
        } else {
            j.a.f.e.onEvent("id_push_10_6", str2);
        }
        g.b("push_7_6_" + str2 + "_" + str);
    }

    public static void l(int i2, String str) {
        String str2 = i2 != 0 ? i2 != 1 ? "" : "click" : "show";
        if (str != null && !str.equals("")) {
            j.a.f.e.onEvent("id_push_7_8", str2, str);
        } else {
            j.a.f.e.onEvent("id_push_7_8", str2);
        }
        g.b("push_7_8_" + str2);
    }

    public static void m(Intent intent) {
        String stringExtra = intent.getStringExtra("web_view_push_id");
        String stringExtra2 = intent.getStringExtra("web_view_url");
        String stringExtra3 = intent.getStringExtra("ad_url");
        String stringExtra4 = intent.getStringExtra("show_type");
        String stringExtra5 = intent.getStringExtra("notify_type");
        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        j("click", stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
    }

    private static String n(String str) {
        int i2;
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception unused) {
            i2 = -1;
        }
        return String.valueOf(i2 > 0 ? i2 : -1);
    }
}
