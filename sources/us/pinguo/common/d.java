package us.pinguo.common;

import android.view.MotionEvent;
/* compiled from: GestureEventManager.kt */
/* loaded from: classes4.dex */
public final class d {
    private MotionEvent a;
    private EventType b;
    private boolean c;

    public final boolean a() {
        return this.c;
    }

    public final MotionEvent b() {
        return this.a;
    }

    public final EventType c() {
        return this.b;
    }

    public final void d(boolean z) {
        this.c = z;
    }

    public final void e(MotionEvent motionEvent) {
        this.a = motionEvent;
    }

    public final void f(EventType eventType) {
        this.b = eventType;
    }
}
