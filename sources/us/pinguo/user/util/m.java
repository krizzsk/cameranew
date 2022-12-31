package us.pinguo.user.util;

import android.app.Activity;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.s0;
/* compiled from: UserTimeoutUtils.java */
/* loaded from: classes6.dex */
public class m {
    public static boolean a(Throwable th) {
        if ((th instanceof Fault) && ((Fault) th).getStatus() == 420) {
            s0.getInstance().k();
            return true;
        }
        return false;
    }

    public static void b(Activity activity) {
        s0.getInstance().onLogout();
        us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
        s0.getInstance().a(activity, 10001, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
    }
}
