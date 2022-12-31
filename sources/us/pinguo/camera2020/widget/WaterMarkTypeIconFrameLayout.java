package us.pinguo.camera2020.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.util.g;
/* compiled from: WaterMarkTypeIconFrameLayout.kt */
/* loaded from: classes3.dex */
public final class WaterMarkTypeIconFrameLayout extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterMarkTypeIconFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View childAt = getChildAt(0);
        if (childAt == null || !(childAt instanceof ImageView)) {
            return;
        }
        int measuredWidth = ((ImageView) childAt).getMeasuredWidth();
        Context context = getContext();
        s.g(context, "context");
        setMeasuredDimension(measuredWidth + (g.a(context, 10.0f) * 2), getMeasuredHeight());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterMarkTypeIconFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaterMarkTypeIconFrameLayout(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }
}
