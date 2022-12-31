package com.pinguo.album.common;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* compiled from: RotationScaleGestureDetector.java */
/* loaded from: classes3.dex */
public class d extends ScaleGestureDetector {
    protected MotionEvent a;
    protected MotionEvent b;
    protected float c;

    /* renamed from: d  reason: collision with root package name */
    protected float f6021d;

    /* renamed from: e  reason: collision with root package name */
    protected float f6022e;

    /* renamed from: f  reason: collision with root package name */
    protected float f6023f;

    /* renamed from: g  reason: collision with root package name */
    protected float f6024g;

    /* renamed from: h  reason: collision with root package name */
    protected float f6025h;

    /* renamed from: i  reason: collision with root package name */
    private a f6026i;

    /* compiled from: RotationScaleGestureDetector.java */
    /* loaded from: classes3.dex */
    public interface a extends ScaleGestureDetector.OnScaleGestureListener {
        boolean a(d dVar);
    }

    public d(Context context, a aVar) {
        super(context, aVar);
        this.f6026i = aVar;
    }

    public float a() {
        return (float) (((Math.atan2(this.f6023f, this.f6022e) - Math.atan2(this.f6025h, this.f6024g)) * 180.0d) / 3.141592653589793d);
    }

    protected void b() {
        MotionEvent motionEvent = this.a;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.a = null;
        }
        MotionEvent motionEvent2 = this.b;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.b = null;
        }
    }

    protected void c(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.a;
        MotionEvent motionEvent3 = this.b;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.b = null;
        }
        this.b = MotionEvent.obtain(motionEvent);
        this.c = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f6021d = motionEvent2.getPressure(motionEvent2.getActionIndex());
        float x = motionEvent2.getX(0);
        float y = motionEvent2.getY(0);
        this.f6022e = motionEvent2.getX(1) - x;
        this.f6023f = motionEvent2.getY(1) - y;
        float x2 = motionEvent.getX(0);
        float y2 = motionEvent.getY(0);
        this.f6024g = motionEvent.getX(1) - x2;
        this.f6025h = motionEvent.getY(1) - y2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r1 != 6) goto L9;
     */
    @Override // android.view.ScaleGestureDetector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = super.onTouchEvent(r4)
            int r1 = r4.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            if (r1 == r2) goto L28
            r2 = 3
            if (r1 == r2) goto L24
            r2 = 5
            if (r1 == r2) goto L17
            r4 = 6
            if (r1 == r4) goto L24
            goto L4e
        L17:
            r3.b()
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r4)
            r3.a = r1
            r3.c(r4)
            goto L4e
        L24:
            r3.b()
            goto L4e
        L28:
            android.view.MotionEvent r1 = r3.a
            if (r1 == 0) goto L4e
            r3.c(r4)
            float r1 = r3.c
            float r2 = r3.f6021d
            float r1 = r1 / r2
            r2 = 1059816735(0x3f2b851f, float:0.67)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L4e
            com.pinguo.album.common.d$a r1 = r3.f6026i
            boolean r1 = r1.a(r3)
            if (r1 == 0) goto L4e
            android.view.MotionEvent r1 = r3.a
            r1.recycle()
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r4)
            r3.a = r4
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.album.common.d.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
