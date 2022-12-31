package com.pinguo.album.views.utils;

import android.content.Context;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.pinguo.album.views.utils.a;
/* compiled from: GestureRecognizer.java */
/* loaded from: classes3.dex */
public class d {
    private final GestureDetector a;
    private final ScaleGestureDetector b;
    private final com.pinguo.album.views.utils.a c = new com.pinguo.album.views.utils.a(new c());

    /* renamed from: d  reason: collision with root package name */
    private final b f6139d;

    /* compiled from: GestureRecognizer.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a();

        boolean b(float f2, float f3, float f4);

        void c();

        boolean d(float f2, float f3);

        void e(float f2, float f3);

        boolean f(float f2, float f3);

        boolean g(float f2, float f3, float f4, float f5, MotionEvent motionEvent, MotionEvent motionEvent2);

        boolean h(float f2, float f3);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onLongPress(MotionEvent motionEvent);
    }

    /* compiled from: GestureRecognizer.java */
    /* loaded from: classes3.dex */
    private class c implements a.InterfaceC0234a {
        private c() {
        }

        @Override // com.pinguo.album.views.utils.a.InterfaceC0234a
        public void a(MotionEvent motionEvent) {
            d.this.f6139d.a();
        }

        @Override // com.pinguo.album.views.utils.a.InterfaceC0234a
        public void onDown(MotionEvent motionEvent) {
            d.this.f6139d.e(motionEvent.getX(), motionEvent.getY());
        }
    }

    /* compiled from: GestureRecognizer.java */
    /* renamed from: com.pinguo.album.views.utils.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0235d extends GestureDetector.SimpleOnGestureListener {
        private C0235d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return d.this.f6139d.d(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return d.this.f6139d.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            d.this.f6139d.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return d.this.f6139d.g(f2, f3, motionEvent2.getX() - motionEvent.getX(), motionEvent2.getY() - motionEvent.getY(), motionEvent, motionEvent2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return d.this.f6139d.f(motionEvent.getX(), motionEvent.getY());
        }
    }

    /* compiled from: GestureRecognizer.java */
    /* loaded from: classes3.dex */
    private class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private e() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return d.this.f6139d.b(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getScaleFactor());
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return d.this.f6139d.h(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            d.this.f6139d.c();
        }
    }

    public d(Context context, b bVar) {
        this.f6139d = bVar;
        this.a = new GestureDetector(context, new C0235d(), null, true);
        this.b = new ScaleGestureDetector(context, new e());
    }

    public void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public void c(MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        try {
            this.b.onTouchEvent(motionEvent);
        } catch (Exception unused) {
        }
        this.c.a(motionEvent);
    }
}
