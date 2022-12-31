package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
/* compiled from: GestureView.kt */
/* loaded from: classes4.dex */
public final class GestureView extends View {
    private kotlin.jvm.b.l<? super MotionEvent, Boolean> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GestureView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        kotlin.jvm.b.l<? super MotionEvent, Boolean> lVar = this.a;
        Boolean invoke = lVar == null ? null : lVar.invoke(event);
        return invoke == null ? super.onTouchEvent(event) : invoke.booleanValue();
    }

    public final void setOnEvent(kotlin.jvm.b.l<? super MotionEvent, Boolean> lVar) {
        this.a = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GestureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GestureView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
