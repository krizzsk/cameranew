package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.view.n0;
/* compiled from: BusinessShellView.kt */
/* loaded from: classes4.dex */
public final class BusinessShellView<T extends n0> extends View {
    private T a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BusinessShellView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BusinessShellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ BusinessShellView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.a;
        if (t == null) {
            return;
        }
        t.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        T t = this.a;
        if (t == null) {
            return;
        }
        t.a(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        T t = this.a;
        if (t == null) {
            return;
        }
        t.c();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        T t = this.a;
        if (t == null) {
            return;
        }
        t.b(z, i2, i3, i4, i5);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        T t = this.a;
        if (t == null) {
            return;
        }
        t.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        T t = this.a;
        Boolean valueOf = t == null ? null : Boolean.valueOf(t.onTouchEvent(motionEvent));
        return valueOf == null ? super.onTouchEvent(motionEvent) : valueOf.booleanValue();
    }

    public final void setProxyImpl(T t) {
        this.a = t;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BusinessShellView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
    }
}
