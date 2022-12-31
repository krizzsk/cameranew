package us.pinguo.camera2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: StickerManagerLayout.kt */
/* loaded from: classes3.dex */
public final class StickerManagerLayout extends ConstraintLayout {
    public Map<Integer, View> a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerManagerLayout(Context context) {
        this(context, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public View _$_findCachedViewById(int i2) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerManagerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }
}
