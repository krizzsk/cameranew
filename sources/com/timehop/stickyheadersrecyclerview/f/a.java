package com.timehop.stickyheadersrecyclerview.f;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.g.b;
/* compiled from: HeaderRenderer.java */
/* loaded from: classes3.dex */
public class a {
    private final com.timehop.stickyheadersrecyclerview.e.a a;
    private final b b;
    private final Rect c;

    public a(b bVar) {
        this(bVar, new com.timehop.stickyheadersrecyclerview.e.a());
    }

    private void b(Rect rect, RecyclerView recyclerView, View view) {
        this.a.b(rect, view);
        if (this.b.a(recyclerView) == 1) {
            rect.set(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), (recyclerView.getWidth() - recyclerView.getPaddingRight()) - rect.right, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            rect.set(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getWidth() - recyclerView.getPaddingRight(), (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - rect.bottom);
        }
    }

    public void a(RecyclerView recyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            b(this.c, recyclerView, view);
            canvas.clipRect(this.c);
        }
        canvas.translate(rect.left, rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    private a(b bVar, com.timehop.stickyheadersrecyclerview.e.a aVar) {
        this.c = new Rect();
        this.b = bVar;
        this.a = aVar;
    }
}
