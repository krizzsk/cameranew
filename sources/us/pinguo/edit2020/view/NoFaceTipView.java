package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: NoFaceTipView.kt */
/* loaded from: classes4.dex */
public final class NoFaceTipView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoFaceTipView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        View.inflate(getContext(), R.layout.edit_no_face_tip_view, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoFaceTipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        View.inflate(getContext(), R.layout.edit_no_face_tip_view, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoFaceTipView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        View.inflate(getContext(), R.layout.edit_no_face_tip_view, this);
    }
}
