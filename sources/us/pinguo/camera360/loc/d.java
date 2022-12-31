package us.pinguo.camera360.loc;

import android.app.Activity;
import android.content.DialogInterface;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.w;
import us.pinguo.loc.LocLoadingState;
import us.pinguo.loc.o;
import us.pinguo.loc.t;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
/* compiled from: LocResDialog.java */
/* loaded from: classes3.dex */
public class d {
    public static boolean a() {
        return !t.b(e.b(), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Activity activity, t.a aVar, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            us.pinguo.foundation.r.d.a().b(new o(0, LocLoadingState.DOWN_LOADING));
            t.v(activity.getApplicationContext(), c.f());
            return;
        }
        aVar.b();
        us.pinguo.foundation.r.d.a().b(new o(-1, LocLoadingState.DOWN_LOADING));
        t.t(null);
    }

    public static void c(final Activity activity, final t.a aVar) {
        t.t(aVar);
        if (q.f(activity.getApplicationContext())) {
            w.k(activity, q.h(activity.getApplicationContext()) ? R.string.notice_need_load_model : R.string.notice_no_wifi, R.string.dialog_sure, R.string.dialog_cancel, false, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.loc.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    d.b(activity, aVar, dialogInterface, i2);
                }
            });
            return;
        }
        aVar.c(false);
        us.pinguo.foundation.r.d.a().b(new o(-1, LocLoadingState.DOWN_LOADING));
        t.t(null);
        w.g(activity, R.string.fabby_net_work_error, R.string.fabby_net_work_error_msg, R.string.dialog_sure, -999, null);
    }
}
