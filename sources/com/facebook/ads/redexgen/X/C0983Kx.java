package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import java.util.concurrent.atomic.AtomicBoolean;
@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "RethrownThrowableArgument"})
/* renamed from: com.facebook.ads.redexgen.X.Kx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0983Kx extends ViewGroup {
    public static final AtomicBoolean A00 = new AtomicBoolean();

    private final void A00() {
        super.onAttachedToWindow();
    }

    private final void A01() {
        super.onDetachedFromWindow();
    }

    private final void A02() {
        super.onFinishInflate();
    }

    private final void A03(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    @SuppressLint({"WrongCall"})
    private final void A04(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    private final void A05(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }

    @SuppressLint({"WrongCall"})
    private final void A06(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void A07(Throwable th) {
        L2.A00().A8g(3304, th);
    }

    public static void A08(boolean z) {
        A00.set(z);
    }

    private final void A09(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A0A(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
    }

    private final boolean A0B() {
        return super.performClick();
    }

    private final boolean A0C(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    private final boolean A0D(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    private final boolean A0E(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private final boolean A0F(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        try {
            A00();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onAttachedToWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        try {
            A01();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onDetachedFromWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            A06(canvas);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onDraw(canvas);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        try {
            A02();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onFinishInflate();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        try {
            A0A(z, i2, rect);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onFocusChanged(z, i2, rect);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        try {
            return A0C(i2, keyEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onKeyDown(i2, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        try {
            return A0D(i2, keyEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onKeyUp(i2, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        try {
            A04(i2, i3);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onMeasure(i2, i3);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        try {
            A05(i2, i3, i4, i5);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onSizeChanged(i2, i3, i4, i5);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return A0E(motionEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onTouchEvent(motionEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        try {
            return A0F(motionEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onTrackballEvent(motionEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        try {
            A09(z);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onWindowFocusChanged(z);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        try {
            A03(i2);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onWindowVisibilityChanged(i2);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        try {
            return A0B();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.performClick();
            }
            throw th;
        }
    }
}
