package us.pinguo.camera2020.view.focusview;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.s;
/* compiled from: PGFocusView.kt */
/* loaded from: classes3.dex */
public final class c extends Handler {
    private WeakReference<PGFocusView> a;

    public c(PGFocusView focusView) {
        s.h(focusView, "focusView");
        this.a = new WeakReference<>(focusView);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        PGFocusView pGFocusView;
        s.h(msg, "msg");
        if (msg.what == 2 && (pGFocusView = this.a.get()) != null) {
            PGFocusView.x(pGFocusView, false, 1, null);
        }
    }
}
