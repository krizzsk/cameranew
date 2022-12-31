package us.pinguo.camera2020.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.ui.uilview.CircleImageView;
/* compiled from: AfterCaptureCircleImageView.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureCircleImageView extends CircleImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureCircleImageView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0 && super.onTouchEvent(motionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureCircleImageView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
