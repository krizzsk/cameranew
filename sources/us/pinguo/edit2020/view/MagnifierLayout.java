package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: MagnifierLayout.kt */
/* loaded from: classes4.dex */
public final class MagnifierLayout extends FrameLayout {
    public Map<Integer, View> a;
    private volatile boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierLayout(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final boolean b() {
        return this.b;
    }

    public final void setClicked(boolean z) {
        this.b = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }
}
