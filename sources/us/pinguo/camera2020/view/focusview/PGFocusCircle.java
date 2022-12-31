package us.pinguo.camera2020.view.focusview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: PGFocusCircle.kt */
/* loaded from: classes3.dex */
public final class PGFocusCircle extends PGFocusShape {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
    }

    private final void u(Canvas canvas) {
        if (g() >= 0) {
            if (m() <= 1.0f) {
                r(1.0f);
            } else if (m() >= 5.0f) {
                r(5.0f);
            }
            l().setStrokeWidth(m());
            invalidate();
        }
        if (canvas == null) {
            return;
        }
        canvas.drawCircle(e(), f(), k(), l());
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public void d(Canvas canvas) {
        u(canvas);
    }

    public final void setTouchDownPaintSize() {
        i().setStrokeWidth(j() * 2);
        invalidate();
    }

    public final void setTouchUpPanitSize() {
        i().setStrokeWidth(m());
        invalidate();
    }
}
