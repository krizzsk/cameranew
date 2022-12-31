package us.pinguo.camera2020.view.focusview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.view.focusview.PGSeekBar;
/* compiled from: ZoomSeekBar.kt */
/* loaded from: classes3.dex */
public final class ZoomSeekBar extends PGSeekBar {

    /* compiled from: ZoomSeekBar.kt */
    /* loaded from: classes3.dex */
    protected final class a extends PGSeekBar.c {
        final /* synthetic */ ZoomSeekBar b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ZoomSeekBar this$0) {
            super(this$0);
            s.h(this$0, "this$0");
            this.b = this$0;
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.c, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.b.x();
            return true;
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.c, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            this.b.x();
            super.onScroll(motionEvent, motionEvent2, f2, f3);
            this.b.invalidate();
            return true;
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.c, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            super.onSingleTapUp(motionEvent);
            this.b.invalidate();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        q(true);
        PGSeekBar.a a2 = a();
        if (a2 != null) {
            a2.a(m());
        }
        invalidate();
    }

    @Override // us.pinguo.camera2020.view.focusview.PGSeekBar
    protected PGSeekBar.c i() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera2020.view.focusview.PGSeekBar, android.view.View
    public void onMeasure(int i2, int i3) {
        int g2;
        int paddingLeft;
        int g3;
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            if (d() != null) {
                Drawable d2 = d();
                s.e(d2);
                g2 = d2.getIntrinsicHeight() * 7;
                paddingLeft = getPaddingLeft() + getPaddingRight();
                Drawable d3 = d();
                s.e(d3);
                g3 = d3.getIntrinsicHeight();
            } else {
                g2 = (int) (7 * g());
                paddingLeft = getPaddingLeft() + getPaddingRight();
                g3 = (int) (2 * g());
            }
            setMeasuredDimension(paddingLeft + g3, g2);
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // us.pinguo.camera2020.view.focusview.PGSeekBar
    public void setCurrentSeekRate(float f2) {
        u(f2);
        if (k() > 1.0f) {
            u(1.0f);
        } else if (k() < 0.0f) {
            u(0.0f);
        }
        t(j() * k());
        invalidate();
        PGSeekBar.b c = c();
        if (c == null) {
            return;
        }
        c.d(this, k());
    }

    public final void w() {
        u(0.0f);
        t(j() * k());
        invalidate();
    }
}
