package us.pinguo.camera2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
/* compiled from: CameraRootLayout.kt */
/* loaded from: classes3.dex */
public final class CameraRootLayout extends ConstraintLayout {
    private boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraRootLayout(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && this.a) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 2) {
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setInterceptTouchEvent(boolean z) {
        this.a = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraRootLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
    }
}
