package us.pinguo.foundation.utils;

import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: ToastUtils.kt */
/* loaded from: classes4.dex */
public final class k0 {
    public static final k0 a = new k0();
    private static Toast b;
    private static Toast c;

    private k0() {
    }

    public final void a(int i2) {
        Toast toast = b;
        if (toast != null) {
            toast.setText(i2);
            toast.setDuration(0);
            toast.show();
            VdsAgent.showToast(toast);
            return;
        }
        Toast makeText = Toast.makeText(us.pinguo.util.v.a(), i2, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
        b = makeText;
    }

    public final void b(String msg) {
        kotlin.jvm.internal.s.h(msg, "msg");
        Toast toast = b;
        if (toast != null) {
            toast.setText(msg);
            toast.setDuration(0);
            toast.show();
            VdsAgent.showToast(toast);
            return;
        }
        Toast makeText = Toast.makeText(us.pinguo.util.v.a(), msg, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
        b = makeText;
    }

    public final void c(int i2) {
        Toast toast = c;
        if (toast != null) {
            toast.setText(i2);
            toast.setDuration(0);
            toast.show();
            VdsAgent.showToast(toast);
            return;
        }
        Toast makeText = Toast.makeText(us.pinguo.util.v.a(), i2, 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
        c = makeText;
    }

    public final void d(String msg) {
        kotlin.jvm.internal.s.h(msg, "msg");
        Toast toast = c;
        if (toast != null) {
            toast.setText(msg);
            toast.setDuration(0);
            toast.show();
            VdsAgent.showToast(toast);
            return;
        }
        Toast makeText = Toast.makeText(us.pinguo.util.v.a(), msg, 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
        c = makeText;
    }

    public final void e(String msg) {
        kotlin.jvm.internal.s.h(msg, "msg");
        Toast toast = b;
        if (toast != null) {
            toast.setText(msg);
            toast.setDuration(1);
            toast.show();
            VdsAgent.showToast(toast);
            return;
        }
        Toast makeText = Toast.makeText(us.pinguo.util.v.a(), msg, 1);
        makeText.show();
        VdsAgent.showToast(makeText);
        b = makeText;
    }
}
