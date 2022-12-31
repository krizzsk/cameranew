package us.pinguo.camera2020.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: AfterCaptureWatermarkLayout.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureWatermarkLayout extends ConstraintLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureWatermarkLayout(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureWatermarkLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureWatermarkLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
