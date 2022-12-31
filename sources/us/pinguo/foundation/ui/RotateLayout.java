package us.pinguo.foundation.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
@TargetApi(11)
/* loaded from: classes4.dex */
public class RotateLayout extends ViewGroup implements d {
    private static boolean c;
    protected View a;
    private int b;

    static {
        c = Build.VERSION.SDK_INT < 11;
    }

    public RotateLayout(Context context) {
        super(context);
        setBackgroundResource(17170445);
    }

    private float a(float f2) {
        double d2;
        int i2 = this.b;
        if (i2 == 90) {
            f2 -= 1.5707964f;
        } else if (i2 == 180) {
            f2 = -f2;
        } else if (i2 == 270) {
            f2 += 1.5707964f;
        }
        double d3 = f2;
        if (d3 < -1.5707963267948966d) {
            d2 = d3 + 3.141592653589793d;
        } else if (d3 <= 1.5707963267948966d) {
            return f2;
        } else {
            d2 = d3 - 3.141592653589793d;
        }
        return (float) d2;
    }

    @SuppressLint({"Recycle"})
    @TargetApi(9)
    private MotionEvent b(MotionEvent motionEvent, int i2, float f2, float f3) {
        int[] iArr = new int[i2];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = motionEvent.getPointerId(i3);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            float x = motionEvent.getX(i3);
            float y = motionEvent.getY(i3);
            int i4 = this.b;
            if (i4 == 90) {
                pointerCoords.x = f3 - y;
                pointerCoords.y = x;
                pointerCoords.orientation = a(motionEvent.getOrientation(i3));
            } else if (i4 == 180) {
                pointerCoords.x = f2 - x;
                pointerCoords.y = f3 - y;
                pointerCoords.orientation = -motionEvent.getOrientation(i3);
            } else if (i4 != 270) {
                pointerCoords.x = x;
                pointerCoords.y = y;
                pointerCoords.orientation = motionEvent.getOrientation(i3);
            } else {
                pointerCoords.x = y;
                pointerCoords.y = f2 - x;
                pointerCoords.orientation = a(motionEvent.getOrientation(i3));
            }
            pointerCoords.pressure = motionEvent.getPressure(i3);
            pointerCoords.size = motionEvent.getSize(i3);
            pointerCoords.toolMajor = motionEvent.getToolMajor(i3);
            pointerCoords.toolMinor = motionEvent.getToolMinor(i3);
            pointerCoords.touchMajor = motionEvent.getTouchMajor(i3);
            pointerCoords.touchMinor = motionEvent.getTouchMinor(i3);
            pointerCoordsArr[i3] = pointerCoords;
        }
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), i2, iArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (c) {
            int i2 = this.b;
            if (i2 == 0) {
                canvas.rotate(-i2, this.a.getWidth() / 2.0f, this.a.getHeight() / 2.0f);
            } else if (i2 == 90) {
                canvas.rotate(-i2, this.a.getWidth() / 2.0f, this.a.getWidth() / 2.0f);
            } else if (i2 == 180) {
                canvas.rotate(-i2, this.a.getWidth() / 2.0f, this.a.getHeight() / 2.0f);
            } else if (i2 == 270) {
                canvas.rotate(-i2, this.a.getHeight() / 2.0f, this.a.getHeight() / 2.0f);
            }
            canvas.save();
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (c) {
            float width = getWidth();
            float height = getHeight();
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i2 = this.b;
                if (i2 == 90) {
                    motionEvent.setLocation(height - y, x);
                } else if (i2 == 180) {
                    motionEvent.setLocation(width - x, height - y);
                } else if (i2 != 270) {
                    motionEvent.setLocation(x, y);
                } else {
                    motionEvent.setLocation(y, width - x);
                }
                return this.a.dispatchTouchEvent(motionEvent);
            } else if (pointerCount == 2 && Build.VERSION.SDK_INT >= 9) {
                return this.a.dispatchTouchEvent(b(motionEvent, pointerCount, width, height));
            } else {
                return this.a.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (c) {
            rect.set(0, 0, getWidth(), getHeight());
        }
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        View childAt = getChildAt(0);
        this.a = childAt;
        if (c) {
            return;
        }
        childAt.setPivotX(0.0f);
        this.a.setPivotY(0.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = this.b;
        if (i8 != 0) {
            if (i8 != 90) {
                if (i8 != 180) {
                    if (i8 != 270) {
                        return;
                    }
                }
            }
            try {
                this.a.layout(0, 0, i7, i6);
            } catch (Exception unused) {
                return;
            }
        }
        this.a.layout(0, 0, i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.view.View r0 = r6.a
            if (r0 != 0) goto L5
            return
        L5:
            int r1 = r6.b
            r2 = 270(0x10e, float:3.78E-43)
            r3 = 180(0xb4, float:2.52E-43)
            r4 = 90
            r5 = 0
            if (r1 == 0) goto L28
            if (r1 == r4) goto L18
            if (r1 == r3) goto L28
            if (r1 == r2) goto L18
            r7 = 0
            goto L37
        L18:
            r6.measureChild(r0, r8, r7)
            android.view.View r7 = r6.a
            int r5 = r7.getMeasuredHeight()
            android.view.View r7 = r6.a
            int r7 = r7.getMeasuredWidth()
            goto L37
        L28:
            r6.measureChild(r0, r7, r8)
            android.view.View r7 = r6.a
            int r5 = r7.getMeasuredWidth()
            android.view.View r7 = r6.a
            int r7 = r7.getMeasuredHeight()
        L37:
            r6.setMeasuredDimension(r5, r7)
            boolean r8 = us.pinguo.foundation.ui.RotateLayout.c
            if (r8 != 0) goto L83
            int r8 = r6.b
            r0 = 0
            if (r8 == 0) goto L6f
            if (r8 == r4) goto L63
            if (r8 == r3) goto L56
            if (r8 == r2) goto L4a
            goto L79
        L4a:
            android.view.View r7 = r6.a
            float r8 = (float) r5
            r7.setTranslationX(r8)
            android.view.View r7 = r6.a
            r7.setTranslationY(r0)
            goto L79
        L56:
            android.view.View r8 = r6.a
            float r0 = (float) r5
            r8.setTranslationX(r0)
            android.view.View r8 = r6.a
            float r7 = (float) r7
            r8.setTranslationY(r7)
            goto L79
        L63:
            android.view.View r8 = r6.a
            r8.setTranslationX(r0)
            android.view.View r8 = r6.a
            float r7 = (float) r7
            r8.setTranslationY(r7)
            goto L79
        L6f:
            android.view.View r7 = r6.a
            r7.setTranslationX(r0)
            android.view.View r7 = r6.a
            r7.setTranslationY(r0)
        L79:
            android.view.View r7 = r6.a
            int r8 = r6.b
            int r8 = -r8
            float r8 = (float) r8
            r7.setRotation(r8)
            goto L86
        L83:
            r6.invalidate()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.ui.RotateLayout.onMeasure(int, int):void");
    }

    @Override // us.pinguo.foundation.ui.d
    public void setOrientation(int i2, boolean z) {
        int i3 = i2 % BaseBlurEffect.ROTATION_360;
        if (this.b == i3) {
            return;
        }
        this.b = i3;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public RotateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(17170445);
    }

    public RotateLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setBackgroundResource(17170445);
    }
}
