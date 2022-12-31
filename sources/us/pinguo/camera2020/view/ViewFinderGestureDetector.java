package us.pinguo.camera2020.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import us.pinguo.camera2020.view.focusview.PGFocusView;
import us.pinguo.common.EventType;
import us.pinguo.common.gesture.a;
/* compiled from: ViewFinderGestureDetector.kt */
/* loaded from: classes3.dex */
public final class ViewFinderGestureDetector extends GestureDetector.SimpleOnGestureListener implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, a.InterfaceC0379a, LifecycleObserver {
    private us.pinguo.common.f a;
    private final ScaleGestureDetector b;
    private final us.pinguo.common.gesture.a c;

    /* renamed from: d  reason: collision with root package name */
    private final GestureDetector f9329d;

    /* renamed from: e  reason: collision with root package name */
    private o2 f9330e;

    /* renamed from: f  reason: collision with root package name */
    private q2 f9331f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9332g;

    /* renamed from: h  reason: collision with root package name */
    public PGFocusView f9333h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f9334i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9335j;

    public ViewFinderGestureDetector(Context ctx, us.pinguo.common.f eventDispatcher) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        kotlin.jvm.internal.s.h(eventDispatcher, "eventDispatcher");
        this.a = eventDispatcher;
        this.b = new ScaleGestureDetector(ctx, this);
        this.c = new us.pinguo.common.gesture.a(ctx, this);
        this.f9329d = new GestureDetector(ctx, this);
        this.f9332g = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        this.f9330e = null;
        this.f9331f = null;
    }

    public final PGFocusView b() {
        PGFocusView pGFocusView = this.f9333h;
        if (pGFocusView != null) {
            return pGFocusView;
        }
        kotlin.jvm.internal.s.z("focusView");
        throw null;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public void c(us.pinguo.common.gesture.a detector) {
        kotlin.jvm.internal.s.h(detector, "detector");
        Integer num = this.f9334i;
        if ((num == null || num.intValue() != 1) && this.f9335j && b().P()) {
            b().j();
            b().G(3000L);
        }
    }

    public final boolean d(MotionEvent event, Integer num, boolean z) {
        kotlin.jvm.internal.s.h(event, "event");
        this.f9334i = num;
        this.f9335j = z;
        this.b.onTouchEvent(event);
        this.c.c(event);
        this.f9329d.onTouchEvent(event);
        if (event.getAction() == 1 || event.getAction() == 3) {
            us.pinguo.common.d dVar = new us.pinguo.common.d();
            dVar.f(EventType.ACTION_UP);
            dVar.e(event);
            dVar.d(this.f9335j);
            this.a.b(dVar);
        }
        return true;
    }

    public final void e(o2 o2Var) {
        this.f9330e = o2Var;
    }

    public final void f(boolean z) {
        this.f9332g = z;
    }

    public final void g(PGFocusView pGFocusView) {
        kotlin.jvm.internal.s.h(pGFocusView, "<set-?>");
        this.f9333h = pGFocusView;
    }

    public final void h(q2 q2Var) {
        this.f9331f = q2Var;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public boolean j(us.pinguo.common.gesture.a detector) {
        kotlin.jvm.internal.s.h(detector, "detector");
        Integer num = this.f9334i;
        if ((num != null && num.intValue() == 1) || !this.f9335j) {
            return false;
        }
        if (b().P()) {
            b().i();
            return true;
        }
        return true;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public boolean k(us.pinguo.common.gesture.a detector) {
        kotlin.jvm.internal.s.h(detector, "detector");
        Integer num = this.f9334i;
        if ((num != null && num.intValue() == 1) || !this.f9335j) {
            return false;
        }
        if (b().P()) {
            b().h(detector.i());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Integer num = this.f9334i;
        if (num != null && num.intValue() == 1) {
            return false;
        }
        us.pinguo.common.d dVar = new us.pinguo.common.d();
        dVar.e(motionEvent);
        dVar.f(EventType.DOUBLE_CLICK);
        return this.a.b(dVar);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        o2 o2Var;
        if (motionEvent != null && motionEvent2 != null) {
            if (this.f9335j) {
                if (!this.f9332g || Math.abs(f2) < Math.abs(f3)) {
                    return false;
                }
                int c = us.pinguo.foundation.utils.n0.c(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                boolean z = f2 > ((float) c);
                boolean z2 = f2 < ((float) (-c));
                if ((z || z2) && (o2Var = this.f9330e) != null) {
                    o2Var.a(z);
                }
            }
            us.pinguo.common.d dVar = new us.pinguo.common.d();
            dVar.f(EventType.FLING);
            dVar.d(this.f9335j);
            this.a.b(dVar);
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (motionEvent != null && this.f9335j) {
            us.pinguo.common.d dVar = new us.pinguo.common.d();
            dVar.e(motionEvent);
            dVar.f(EventType.LONG_PRESS);
            dVar.d(this.f9335j);
            if (this.a.b(dVar)) {
                return;
            }
            Integer num = this.f9334i;
            if (num != null && num.intValue() == 1) {
                return;
            }
            b().setFocusViewCurrentPosition(motionEvent.getX(), motionEvent.getY());
            b().o();
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        q2 q2Var;
        kotlin.jvm.internal.s.h(detector, "detector");
        Integer num = this.f9334i;
        boolean z = false;
        if ((num != null && num.intValue() == 1) || !this.f9335j) {
            return false;
        }
        us.pinguo.common.log.a.e(kotlin.jvm.internal.s.q("ViewFinderGestureDetector:onScale:", Float.valueOf(detector.getScaleFactor())), new Object[0]);
        if (!b().k(detector.getScaleFactor())) {
            q2 q2Var2 = this.f9331f;
            if (q2Var2 != null && q2Var2.e()) {
                z = true;
            }
            if (z && (q2Var = this.f9331f) != null) {
                q2Var.c(detector.getScaleFactor() - 1.0f);
            }
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        q2 q2Var;
        kotlin.jvm.internal.s.h(detector, "detector");
        Integer num = this.f9334i;
        boolean z = false;
        if ((num != null && num.intValue() == 1) || !this.f9335j) {
            return false;
        }
        if (b().M()) {
            b().l();
        } else {
            q2 q2Var2 = this.f9331f;
            if (q2Var2 != null && q2Var2.e()) {
                z = true;
            }
            if (z && (q2Var = this.f9331f) != null) {
                q2Var.show();
            }
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        kotlin.jvm.internal.s.h(detector, "detector");
        Integer num = this.f9334i;
        if ((num == null || num.intValue() != 1) && this.f9335j && b().P()) {
            b().m();
            b().G(3000L);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        Integer num;
        if (motionEvent != null && motionEvent2 != null && (((num = this.f9334i) == null || num.intValue() != 1) && this.f9335j && b().P())) {
            b().p();
            b().r(motionEvent2.getX(), motionEvent2.getY());
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        us.pinguo.common.d dVar = new us.pinguo.common.d();
        dVar.e(motionEvent);
        dVar.f(EventType.TOUCH_UP);
        dVar.d(this.f9335j);
        if (this.a.b(dVar)) {
            return true;
        }
        Integer num = this.f9334i;
        if ((num != null && num.intValue() == 1) || !this.f9335j) {
            return false;
        }
        if (b().O()) {
            l2.a.e();
            b().setFocusViewCurrentPosition(motionEvent.getX(), motionEvent.getY());
            b().q();
            b().G(3000L);
        }
        q2 q2Var = this.f9331f;
        if (q2Var != null) {
            q2Var.a();
        }
        return true;
    }
}
