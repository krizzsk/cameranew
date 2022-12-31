package com.pinguo.album.views.utils;

import android.view.MotionEvent;
/* compiled from: DownUpDetector.java */
/* loaded from: classes3.dex */
public class a {
    private boolean a;
    private InterfaceC0234a b;

    /* compiled from: DownUpDetector.java */
    /* renamed from: com.pinguo.album.views.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0234a {
        void a(MotionEvent motionEvent);

        void onDown(MotionEvent motionEvent);
    }

    public a(InterfaceC0234a interfaceC0234a) {
        this.b = interfaceC0234a;
    }

    private void b(boolean z, MotionEvent motionEvent) {
        us.pinguo.common.log.a.m("DownUpDetector", "on Touch set state is down :" + z, new Object[0]);
        us.pinguo.common.log.a.m("DownUpDetector", "on Touch set state mStillDown :" + this.a, new Object[0]);
        if (z == this.a) {
            return;
        }
        this.a = z;
        if (z) {
            this.b.onDown(motionEvent);
        } else {
            this.b.a(motionEvent);
        }
    }

    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            b(true, motionEvent);
        } else if (action == 1 || action == 3) {
            us.pinguo.common.log.a.m("DownUpDetector", "on Touch ev.getAction() & MotionEvent.ACTION_MASK :" + (motionEvent.getAction() & 255), new Object[0]);
            b(false, motionEvent);
        }
    }
}
