package us.pinguo.common.gesture;

import android.content.Context;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public abstract class BaseGestureDetector {
    protected final Context a;
    protected boolean b;
    protected MotionEvent c;

    /* renamed from: d  reason: collision with root package name */
    protected MotionEvent f9909d;

    /* renamed from: e  reason: collision with root package name */
    protected float f9910e;

    /* renamed from: f  reason: collision with root package name */
    protected float f9911f;

    public BaseGestureDetector(Context context) {
        this.a = context;
    }

    protected abstract void a(int i2, MotionEvent motionEvent);

    protected abstract void b(int i2, MotionEvent motionEvent);

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!this.b) {
            b(action, motionEvent);
            return true;
        }
        a(action, motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        MotionEvent motionEvent = this.c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.c = null;
        }
        MotionEvent motionEvent2 = this.f9909d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f9909d = null;
        }
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.c;
        MotionEvent motionEvent3 = this.f9909d;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f9909d = null;
        }
        this.f9909d = MotionEvent.obtain(motionEvent);
        motionEvent.getEventTime();
        motionEvent2.getEventTime();
        this.f9910e = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f9911f = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }
}
