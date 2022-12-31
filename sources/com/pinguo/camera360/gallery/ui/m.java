package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import java.util.Objects;
/* compiled from: CustomGestureDetector.java */
/* loaded from: classes3.dex */
public class m {
    private static final int x = ViewConfiguration.getLongPressTimeout();
    private static final int y = ViewConfiguration.getTapTimeout();
    private static final int z = ViewConfiguration.getDoubleTapTimeout();
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f6614d;

    /* renamed from: e  reason: collision with root package name */
    private int f6615e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f6616f;

    /* renamed from: g  reason: collision with root package name */
    private final c f6617g;

    /* renamed from: h  reason: collision with root package name */
    private b f6618h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6619i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6620j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6621k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6622l;
    private boolean m;
    private boolean n;
    private MotionEvent o;
    private MotionEvent p;
    private boolean q;
    private float r;
    private float s;
    private float t;
    private float u;
    private boolean v;
    private VelocityTracker w;

    /* compiled from: CustomGestureDetector.java */
    /* loaded from: classes3.dex */
    public interface b {
        boolean onDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    /* compiled from: CustomGestureDetector.java */
    /* loaded from: classes3.dex */
    public interface c {
        boolean b();

        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public m(Context context, c cVar) {
        this(context, cVar, null);
    }

    private void g() {
        this.f6616f.removeMessages(1);
        this.f6616f.removeMessages(2);
        this.f6616f.removeMessages(3);
        this.w.recycle();
        this.w = null;
        this.q = false;
        this.f6619i = false;
        this.m = false;
        this.n = false;
        this.f6620j = false;
        if (this.f6621k) {
            this.f6621k = false;
        }
    }

    private void h() {
        this.f6616f.removeMessages(1);
        this.f6616f.removeMessages(2);
        this.f6616f.removeMessages(3);
        this.q = false;
        this.m = false;
        this.n = false;
        this.f6620j = false;
        if (this.f6621k) {
            this.f6621k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f6616f.removeMessages(3);
        this.f6620j = false;
        this.f6621k = true;
        this.f6617g.onLongPress(this.o);
    }

    private void j(Context context) {
        int i2;
        int i3;
        int i4;
        Objects.requireNonNull(this.f6617g, "OnGestureListener must not be null");
        this.v = true;
        if (context == null) {
            i3 = ViewConfiguration.getTouchSlop();
            i4 = 100;
            this.f6614d = ViewConfiguration.getMinimumFlingVelocity();
            this.f6615e = ViewConfiguration.getMaximumFlingVelocity();
            i2 = i3;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            i2 = 8;
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f6614d = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f6615e = viewConfiguration.getScaledMaximumFlingVelocity();
            i3 = scaledTouchSlop;
            i4 = scaledDoubleTapSlop;
        }
        this.a = i3 * i3;
        this.b = i2 * i2;
        this.c = i4 * i4;
    }

    private boolean k(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (this.n) {
            long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
            if (eventTime > z || eventTime < 40) {
                return false;
            }
            int x2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y2 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x2 * x2) + (y2 * y2) < this.c;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.ui.m.l(android.view.MotionEvent):boolean");
    }

    public void m(boolean z2) {
        this.f6622l = z2;
    }

    public void n(b bVar) {
        this.f6618h = bVar;
    }

    /* compiled from: CustomGestureDetector.java */
    /* loaded from: classes3.dex */
    private class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                m.this.f6617g.onShowPress(m.this.o);
            } else if (i2 == 2) {
                m.this.i();
            } else if (i2 == 3) {
                if (m.this.f6618h != null) {
                    if (!m.this.f6619i) {
                        m.this.f6618h.onSingleTapConfirmed(m.this.o);
                    } else {
                        m.this.f6620j = true;
                    }
                }
            } else {
                throw new RuntimeException("Unknown message " + message);
            }
        }

        a(Handler handler) {
            super(handler.getLooper());
        }
    }

    public m(Context context, c cVar, Handler handler) {
        if (handler != null) {
            this.f6616f = new a(handler);
        } else {
            this.f6616f = new a();
        }
        this.f6617g = cVar;
        if (cVar instanceof b) {
            n((b) cVar);
        }
        j(context);
    }
}
