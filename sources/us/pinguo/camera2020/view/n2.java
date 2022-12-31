package us.pinguo.camera2020.view;

import android.os.Handler;
import android.os.Message;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
/* compiled from: CameraZoomLayout.kt */
/* loaded from: classes3.dex */
public final class n2 extends Handler {
    private WeakReference<CameraZoomLayout> a;

    public n2(CameraZoomLayout zoomSeekLayout) {
        kotlin.jvm.internal.s.h(zoomSeekLayout, "zoomSeekLayout");
        this.a = new WeakReference<>(zoomSeekLayout);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        CameraZoomLayout cameraZoomLayout;
        kotlin.jvm.internal.s.h(msg, "msg");
        if (this.a.get() != null) {
            int i2 = msg.what;
            if (i2 == 1) {
                us.pinguo.foundation.utils.r0.c(this.a.get());
            } else if (i2 == 2) {
                us.pinguo.foundation.utils.r0.a(this.a.get());
            } else if (i2 == 3 && (cameraZoomLayout = this.a.get()) != null) {
                cameraZoomLayout.setVisibility(4);
                VdsAgent.onSetViewVisibility(cameraZoomLayout, 4);
            }
        }
        super.handleMessage(msg);
    }
}
