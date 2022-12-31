package us.pinguo.camera2020.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: Camera2020Activity.kt */
/* loaded from: classes2.dex */
final class x extends Handler {
    private WeakReference<Activity> a;

    public x(Activity activity) {
        kotlin.jvm.internal.s.h(activity, "activity");
        this.a = new WeakReference<>(activity);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Activity activity;
        kotlin.jvm.internal.s.h(msg, "msg");
        super.handleMessage(msg);
        if (msg.what != 1 || (activity = this.a.get()) == null || activity.isFinishing() || !activity.hasWindowFocus()) {
            return;
        }
        CameraScreenSaverActivity.b.a(activity);
    }
}
