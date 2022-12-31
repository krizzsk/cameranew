package us.pinguo.camera2020.view.focusview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: PGFocusSquare.kt */
/* loaded from: classes3.dex */
public final class PGFocusSquare extends PGFocusShape {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusSquare(Context context, AttributeSet attributeSet) {
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
        canvas.drawRect(e() - k(), f() - k(), e() + k(), f() + k(), i());
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public void d(Canvas canvas) {
        u(canvas);
    }
}
