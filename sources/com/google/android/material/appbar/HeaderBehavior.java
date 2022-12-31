package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Runnable f4058d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f4059e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4060f;

    /* renamed from: g  reason: collision with root package name */
    private int f4061g;

    /* renamed from: h  reason: collision with root package name */
    private int f4062h;

    /* renamed from: i  reason: collision with root package name */
    private int f4063i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f4064j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Field signature parse error: b
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TV at position 1 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
     */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private final CoordinatorLayout a;
        private final View b;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.a = coordinatorLayout;
            this.b = v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.b == null || (overScroller = HeaderBehavior.this.f4059e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = HeaderBehavior.this;
                headerBehavior.l(this.a, this.b, headerBehavior.f4059e.getCurrY());
                ViewCompat.postOnAnimation(this.b, this);
                return;
            }
            HeaderBehavior.this.j(this.a, this.b);
        }
    }

    public HeaderBehavior() {
        this.f4061g = -1;
        this.f4063i = -1;
    }

    private void e() {
        if (this.f4064j == null) {
            this.f4064j = VelocityTracker.obtain();
        }
    }

    boolean d(V v) {
        return false;
    }

    final boolean f(CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i3, float f2) {
        Runnable runnable = this.f4058d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f4058d = null;
        }
        if (this.f4059e == null) {
            this.f4059e = new OverScroller(v.getContext());
        }
        this.f4059e.fling(0, a(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f4059e.computeScrollOffset()) {
            a aVar = new a(coordinatorLayout, v);
            this.f4058d = aVar;
            ViewCompat.postOnAnimation(v, aVar);
            return true;
        }
        j(coordinatorLayout, v);
        return false;
    }

    int g(@NonNull V v) {
        return -v.getHeight();
    }

    int h(@NonNull V v) {
        return v.getHeight();
    }

    int i() {
        return a();
    }

    void j(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int k(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return m(coordinatorLayout, v, i() - i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return m(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int m(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        int clamp;
        int a2 = a();
        if (i3 == 0 || a2 < i3 || a2 > i4 || a2 == (clamp = MathUtils.clamp(i2, i3, i4))) {
            return 0;
        }
        c(clamp);
        return a2 - clamp;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f4063i < 0) {
            this.f4063i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f4060f) {
            int i2 = this.f4061g;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f4062h) > this.f4063i) {
                this.f4062h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f4061g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = d(v) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.f4060f = z;
            if (z) {
                this.f4062h = y2;
                this.f4061g = motionEvent.getPointerId(0);
                e();
                OverScroller overScroller = this.f4059e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f4059e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f4064j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f4061g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f4062h = r12
            goto L4c
        L2d:
            int r0 = r11.f4061g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f4062h
            int r7 = r1 - r0
            r11.f4062h = r0
            int r8 = r11.g(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.k(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f4064j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f4064j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f4064j
            int r4 = r11.f4061g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.h(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.f(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f4060f = r3
            r11.f4061g = r1
            android.view.VelocityTracker r13 = r11.f4064j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f4064j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f4064j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f4060f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4061g = -1;
        this.f4063i = -1;
    }
}
