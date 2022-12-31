package com.github.chrisbanes.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomGestureDetector.java */
/* loaded from: classes9.dex */
public class b {
    private int a = -1;
    private int b = 0;
    private final ScaleGestureDetector c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f3290d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3291e;

    /* renamed from: f  reason: collision with root package name */
    private float f3292f;

    /* renamed from: g  reason: collision with root package name */
    private float f3293g;

    /* renamed from: h  reason: collision with root package name */
    private final float f3294h;

    /* renamed from: i  reason: collision with root package name */
    private final float f3295i;

    /* renamed from: j  reason: collision with root package name */
    private d f3296j;

    /* compiled from: CustomGestureDetector.java */
    /* loaded from: classes9.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            b.this.f3296j.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3295i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3294h = viewConfiguration.getScaledTouchSlop();
        this.f3296j = dVar;
        this.c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f3290d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f3292f = b(motionEvent);
            this.f3293g = c(motionEvent);
            this.f3291e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.f3291e && this.f3290d != null) {
                this.f3292f = b(motionEvent);
                this.f3293g = c(motionEvent);
                this.f3290d.addMovement(motionEvent);
                this.f3290d.computeCurrentVelocity(1000);
                float xVelocity = this.f3290d.getXVelocity();
                float yVelocity = this.f3290d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f3295i) {
                    this.f3296j.c(this.f3292f, this.f3293g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f3290d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f3290d = null;
            }
        } else if (action == 2) {
            float b = b(motionEvent);
            float c = c(motionEvent);
            float f2 = b - this.f3292f;
            float f3 = c - this.f3293g;
            if (!this.f3291e) {
                this.f3291e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f3294h);
            }
            if (this.f3291e) {
                this.f3296j.a(f2, f3);
                this.f3292f = b;
                this.f3293g = c;
                VelocityTracker velocityTracker2 = this.f3290d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker3 = this.f3290d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f3290d = null;
            }
        } else if (action == 6) {
            int b2 = n.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b2) == this.a) {
                int i2 = b2 == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i2);
                this.f3292f = motionEvent.getX(i2);
                this.f3293g = motionEvent.getY(i2);
            }
        }
        int i3 = this.a;
        this.b = motionEvent.findPointerIndex(i3 != -1 ? i3 : 0);
        return true;
    }

    public boolean d() {
        return this.f3291e;
    }

    public boolean e() {
        return this.c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
