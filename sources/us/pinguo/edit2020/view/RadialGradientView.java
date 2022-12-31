package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
/* compiled from: RadialGradientView.kt */
/* loaded from: classes4.dex */
public final class RadialGradientView extends View {
    private float a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadialGradientView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = 10.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        new RadialGradient(getMeasuredWidth() * 0.5f, getMeasuredHeight() * 0.5f, this.a, new int[]{-1}, (float[]) null, Shader.TileMode.CLAMP);
    }

    public final void setColor(int i2) {
    }

    public final void setRadius(float f2) {
        this.a = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadialGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = 10.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadialGradientView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = 10.0f;
    }
}
