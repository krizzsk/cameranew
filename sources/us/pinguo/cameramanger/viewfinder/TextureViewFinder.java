package us.pinguo.cameramanger.viewfinder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: TextureViewFinder.kt */
/* loaded from: classes4.dex */
public final class TextureViewFinder extends TextureView implements a {
    private int a;
    private int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureViewFinder(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void a() {
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void b() {
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void c() {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = this.a;
        if (i5 != 0 && (i4 = this.b) != 0) {
            if (size < (size2 * i5) / i4) {
                setMeasuredDimension(size, (i4 * size) / i5);
                return;
            } else {
                setMeasuredDimension((i5 * size2) / i4, size2);
                return;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void setCameraInfo(boolean z, int i2) {
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void setTextureSize(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            this.a = i2;
            this.b = i3;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Size cannot be negative.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureViewFinder(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureViewFinder(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
