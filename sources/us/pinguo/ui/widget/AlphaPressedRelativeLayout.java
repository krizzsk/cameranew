package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
/* compiled from: AlphaPressedRelativeLayout.kt */
/* loaded from: classes6.dex */
public final class AlphaPressedRelativeLayout extends RelativeLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaPressedRelativeLayout(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        kotlin.z.d h2;
        kotlin.z.d h3;
        s.h(event, "event");
        int action = event.getAction() & event.getActionMasked();
        if (action == 0) {
            h2 = kotlin.z.j.h(0, getChildCount());
            Iterator<Integer> it = h2.iterator();
            while (it.hasNext()) {
                View childAt = getChildAt(((h0) it).nextInt());
                if (s.c(childAt.getTag(), "a")) {
                    childAt.setAlpha(childAt.getAlpha() * 0.6f);
                }
            }
        } else if (action == 1 || action == 3) {
            h3 = kotlin.z.j.h(0, getChildCount());
            Iterator<Integer> it2 = h3.iterator();
            while (it2.hasNext()) {
                View childAt2 = getChildAt(((h0) it2).nextInt());
                if (s.c(childAt2.getTag(), "a")) {
                    childAt2.setAlpha(childAt2.getAlpha() / 0.6f);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaPressedRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaPressedRelativeLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
