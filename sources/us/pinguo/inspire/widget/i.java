package us.pinguo.inspire.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: SimpleDividerDecoration.kt */
/* loaded from: classes9.dex */
public final class i extends RecyclerView.ItemDecoration {
    private final int a;
    private final int b;
    private final Paint c;

    public i(int i2, @ColorInt int i3) {
        this.a = i2;
        this.b = i3;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(i3);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        s.h(c, "c");
        s.h(parent, "parent");
        s.h(state, "state");
        int childCount = parent.getChildCount();
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int i2 = 0;
        while (i2 < childCount) {
            int i3 = i2 + 1;
            View childAt = parent.getChildAt(i2);
            c.drawRect(paddingLeft, childAt.getBottom(), width, childAt.getBottom() + this.a, this.c);
            i2 = i3;
        }
    }
}
