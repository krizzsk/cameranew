package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import java.util.concurrent.atomic.AtomicBoolean;
@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "WrongCall", "RethrownThrowableArgument"})
/* renamed from: com.facebook.ads.redexgen.X.Kw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0982Kw extends View {
    public static String[] A00 = {"kAVfBRgsuHAPyLthoP", "", "t17O26GbxI", "rw", "AAEx162laq7qeqX9thcQ", "HAXhrl7a7PCZ9u3oTFWkwwhVB4A5", "GFzV2eDHhD", "HOPUDh1leN9OTkJ3x1a"};
    public static final AtomicBoolean A01 = new AtomicBoolean();

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

    private final void A04(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    private final void A05(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }

    private final void A06(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void A07(Throwable th) {
        L2.A00().A8g(3303, th);
    }

    public static void A08(boolean z) {
        A01.set(z);
    }

    private final void A09(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A0A(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    private final void A0B(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
    }

    private final boolean A0C() {
        return super.performClick();
    }

    private final boolean A0D(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    private final boolean A0E(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    private final boolean A0F(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private final boolean A0G(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        try {
            A00();
        } catch (Throwable th) {
            String[] strArr = A00;
            if (strArr[6].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A00[7] = "rnq1MXg";
            if (A01.get()) {
                A07(th);
                super.onAttachedToWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        try {
            A01();
        } catch (Throwable th) {
            if (A01.get()) {
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
            if (A01.get()) {
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
            if (A01.get()) {
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
            A0B(z, i2, rect);
        } catch (Throwable th) {
            if (A01.get()) {
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
            return A0D(i2, keyEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A07(th);
                boolean onKeyDown = super.onKeyDown(i2, keyEvent);
                String[] strArr = A00;
                if (strArr[6].length() != strArr[1].length()) {
                    String[] strArr2 = A00;
                    strArr2[6] = "5DVI70tdQk";
                    strArr2[1] = "";
                    return onKeyDown;
                }
                throw new RuntimeException();
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        try {
            return A0E(i2, keyEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A07(th);
                return super.onKeyUp(i2, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        try {
            A0A(z, i2, i3, i4, i5);
        } catch (Throwable th) {
            if (A01.get()) {
                A07(th);
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        try {
            A04(i2, i3);
        } catch (Throwable th) {
            if (A01.get()) {
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
            if (A01.get()) {
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
            return A0F(motionEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A07(th);
                return super.onTouchEvent(motionEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        try {
            return A0G(motionEvent);
        } catch (Throwable th) {
            if (A01.get()) {
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
            if (A01.get()) {
                A07(th);
                if (A00[5].length() == 25) {
                    throw new RuntimeException();
                }
                A00[0] = "0jBFwaBL8FA97JJQoE8VdUJeS";
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
            if (A01.get()) {
                A07(th);
                if (A00[0].length() == 7) {
                    throw new RuntimeException();
                }
                A00[5] = "8Ha1wZjMuo1MUnpr2KcgLPpAJB";
                super.onWindowVisibilityChanged(i2);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        try {
            return A0C();
        } catch (Throwable th) {
            AtomicBoolean atomicBoolean = A01;
            if (A00[7].length() != 24) {
                A00[7] = "LfZZ0wz91OrvOK";
                if (atomicBoolean.get()) {
                    A07(th);
                    return super.performClick();
                }
                throw th;
            }
            throw new RuntimeException();
        }
    }
}
