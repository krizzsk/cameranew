package us.pinguo.inspire.proxy;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import j.a.f.e;
import us.pinguo.common.log.a;
import us.pinguo.foundation.statistics.k;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InspireStatistics {
    public static void clickPublishBtn() {
        l.i(Inspire.a(), "click_publish_btn", s0.getInstance().e() ? FirebaseAnalytics.Event.LOGIN : "logout");
    }

    public static void enterAddFriendsPage() {
        l.h(Inspire.a(), "enter_add_friends_page");
    }

    public static void enterEditInfoPage() {
        l.h(Inspire.a(), "Profile_edit_info_page");
    }

    public static void enterGuestProfilePage() {
        l.h(Inspire.a(), "Profile_guest_page");
    }

    public static void enterNearbyUserPage() {
        l.h(Inspire.a(), "enter_nearby_user_page");
    }

    public static void onError(Throwable th) {
        a.f(th);
        e.onEvent("id_pg_exception_msg", Log.getStackTraceString(th));
    }

    public static void onPageEnd(String str) {
        l.e(str);
    }

    public static void onPageStart(String str) {
        l.f(str);
    }

    public static void pushSimpleClick(int i2, String str) {
        k.i(1, str);
    }

    public static void taskInfoJoinBtnClick(String str, String str2) {
        l.i(Inspire.a(), "pc_taskInfo_joinbtnClicked", str2);
    }

    public static void taskInfoShareClick(String str, String str2) {
        l.i(Inspire.a(), "pc_taskInfo_sharebtnClicked", str2);
    }
}
