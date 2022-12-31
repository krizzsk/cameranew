package us.pinguo.common.gesture;

import android.content.Context;
import android.view.MotionEvent;
/* compiled from: RotateGestureDetector.java */
/* loaded from: classes4.dex */
public class a extends TwoFingerGestureDetector {
    private final InterfaceC0379a n;
    private boolean o;

    /* compiled from: RotateGestureDetector.java */
    /* renamed from: us.pinguo.common.gesture.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0379a {
        void c(a aVar);

        boolean j(a aVar);

        boolean k(a aVar);
    }

    public a(Context context, InterfaceC0379a interfaceC0379a) {
        super(context);
        this.n = interfaceC0379a;
    }

    @Override // us.pinguo.common.gesture.BaseGestureDetector
    protected void a(int i2, MotionEvent motionEvent) {
        if (i2 == 2) {
            e(motionEvent);
            if (this.f9910e / this.f9911f <= 0.67f || !this.n.k(this)) {
                return;
            }
            this.c.recycle();
            this.c = MotionEvent.obtain(motionEvent);
        } else if (i2 == 3) {
            if (!this.o) {
                this.n.c(this);
            }
            d();
        } else if (i2 != 6) {
        } else {
            e(motionEvent);
            if (!this.o) {
                this.n.c(this);
            }
            d();
        }
    }

    @Override // us.pinguo.common.gesture.BaseGestureDetector
    protected void b(int i2, MotionEvent motionEvent) {
        if (i2 == 2) {
            if (this.o) {
                boolean h2 = h(motionEvent);
                this.o = h2;
                if (h2) {
                    return;
                }
                this.b = this.n.j(this);
            }
        } else if (i2 != 5) {
        } else {
            d();
            this.c = MotionEvent.obtain(motionEvent);
            e(motionEvent);
            boolean h3 = h(motionEvent);
            this.o = h3;
            if (h3) {
                return;
            }
            this.b = this.n.j(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.gesture.BaseGestureDetector
    public void d() {
        super.d();
        this.o = false;
    }

    public float i() {
        return (float) (((Math.atan2(this.f9916k, this.f9915j) - Math.atan2(this.m, this.f9917l)) * 180.0d) / 3.141592653589793d);
    }
}
