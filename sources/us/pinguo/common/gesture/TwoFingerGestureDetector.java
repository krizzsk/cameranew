package us.pinguo.common.gesture;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public abstract class TwoFingerGestureDetector extends BaseGestureDetector {

    /* renamed from: g  reason: collision with root package name */
    private final float f9912g;

    /* renamed from: h  reason: collision with root package name */
    private float f9913h;

    /* renamed from: i  reason: collision with root package name */
    private float f9914i;

    /* renamed from: j  reason: collision with root package name */
    protected float f9915j;

    /* renamed from: k  reason: collision with root package name */
    protected float f9916k;

    /* renamed from: l  reason: collision with root package name */
    protected float f9917l;
    protected float m;

    public TwoFingerGestureDetector(Context context) {
        super(context);
        this.f9912g = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float f(MotionEvent motionEvent, int i2) {
        float x = motionEvent.getX() - motionEvent.getRawX();
        if (i2 < motionEvent.getPointerCount()) {
            return motionEvent.getX(i2) + x;
        }
        return 0.0f;
    }

    protected static float g(MotionEvent motionEvent, int i2) {
        float y = motionEvent.getY() - motionEvent.getRawY();
        if (i2 < motionEvent.getPointerCount()) {
            return motionEvent.getY(i2) + y;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.gesture.BaseGestureDetector
    public void e(MotionEvent motionEvent) {
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.c;
        try {
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            this.f9915j = motionEvent2.getX(1) - x;
            this.f9916k = motionEvent2.getY(1) - y;
            float x2 = motionEvent.getX(0);
            float y2 = motionEvent.getY(0);
            this.f9917l = motionEvent.getX(1) - x2;
            this.m = motionEvent.getY(1) - y2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        float f2 = this.f9912g;
        float f3 = displayMetrics.widthPixels - f2;
        this.f9913h = f3;
        float f4 = displayMetrics.heightPixels - f2;
        this.f9914i = f4;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f5 = f(motionEvent, 1);
        float g2 = g(motionEvent, 1);
        boolean z = rawX < f2 || rawY < f2 || rawX > f3 || rawY > f4;
        boolean z2 = f5 < f2 || g2 < f2 || f5 > f3 || g2 > f4;
        return (z && z2) || z || z2;
    }
}
