package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
/* compiled from: RoundCornerRecyclerView.kt */
/* loaded from: classes4.dex */
public final class RoundCornerRecyclerView extends RecyclerView {
    private final Path a;
    private final float b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Path();
        this.b = us.pinguo.common.widget.i.a.b(20);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        this.a.reset();
        this.a.moveTo(0.0f, this.b);
        this.a.quadTo(0.0f, 0.0f, this.b, 0.0f);
        this.a.lineTo(getWidth(), 0.0f);
        this.a.lineTo(getWidth(), getHeight());
        this.a.lineTo(0.0f, getHeight());
        this.a.lineTo(0.0f, this.b);
        if (canvas != null) {
            canvas.clipPath(this.a);
        }
        super.onDraw(canvas);
    }
}
