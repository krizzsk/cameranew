package us.pinguo.edit2020.adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: Facial3DDecoration.kt */
/* loaded from: classes4.dex */
public final class d0 extends RecyclerView.ItemDecoration {
    private final Rect a = new Rect();
    private final Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f10127d;

    /* renamed from: e  reason: collision with root package name */
    private float f10128e;

    public d0() {
        Paint paint = new Paint(1);
        this.b = paint;
        this.c = Color.parseColor("#999999");
        this.f10127d = us.pinguo.common.widget.i.a.b(30);
        this.f10128e = us.pinguo.common.widget.i.a.b(1);
        paint.setColor(this.c);
        paint.setStrokeWidth(this.f10128e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int b;
        kotlin.jvm.internal.s.h(c, "c");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        super.onDrawOver(c, parent, state);
        int itemCount = state.getItemCount();
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int i2 = 0;
        while (i2 < itemCount) {
            int i3 = i2 + 1;
            View childAt = parent.getChildAt(i2);
            if (parent.getChildAdapterPosition(childAt) == 0) {
                layoutManager.getDecoratedBoundsWithMargins(childAt, this.a);
                int i4 = this.a.right;
                b = kotlin.y.c.b(childAt.getTranslationX());
                float f2 = i4 + b;
                float f3 = f2 - this.f10128e;
                float f4 = f3 + ((f2 - f3) * 0.5f);
                float f5 = 2;
                c.drawLine(f4, (parent.getHeight() - this.f10127d) / f5, f4, (parent.getHeight() + this.f10127d) / f5, this.b);
                return;
            }
            i2 = i3;
        }
    }
}
