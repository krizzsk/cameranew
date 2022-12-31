package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.R;
import us.pinguo.foundation.utils.u;
/* compiled from: LanFitTextView.kt */
/* loaded from: classes6.dex */
public final class LanFitTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanFitTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        c(context, attrs);
    }

    private final boolean b() {
        return u.b() || u.d();
    }

    private final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LanFitTextView);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…styleable.LanFitTextView)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LanFitTextView_scaleTextSize, us.pinguo.util.g.a(context, 9.0f));
        if (b()) {
            return;
        }
        setTextSize(0, dimensionPixelSize);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanFitTextView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        c(context, attrs);
    }
}
