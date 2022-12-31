package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: AlphaPressedAutofitTextView.kt */
/* loaded from: classes6.dex */
public final class AlphaPressedAutofitTextView extends AutofitTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaPressedAutofitTextView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        s.h(event, "event");
        int action = event.getAction() & event.getActionMasked();
        if (action == 0) {
            setAlpha(0.6f);
        } else if (action == 1 || action == 3) {
            setAlpha(1.0f);
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaPressedAutofitTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaPressedAutofitTextView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
