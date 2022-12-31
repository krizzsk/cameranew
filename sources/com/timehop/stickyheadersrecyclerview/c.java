package com.timehop.stickyheadersrecyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: StickyRecyclerHeadersDecoration.java */
/* loaded from: classes3.dex */
public class c extends RecyclerView.ItemDecoration {
    private final b a;
    private final SparseArray<Rect> b;
    private final com.timehop.stickyheadersrecyclerview.d.a c;

    /* renamed from: d  reason: collision with root package name */
    private final com.timehop.stickyheadersrecyclerview.g.b f8315d;

    /* renamed from: e  reason: collision with root package name */
    private final a f8316e;

    /* renamed from: f  reason: collision with root package name */
    private final com.timehop.stickyheadersrecyclerview.f.a f8317f;

    /* renamed from: g  reason: collision with root package name */
    private final com.timehop.stickyheadersrecyclerview.e.a f8318g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f8319h;

    public c(b bVar) {
        this(bVar, new com.timehop.stickyheadersrecyclerview.g.a(), new com.timehop.stickyheadersrecyclerview.e.a());
    }

    private void b(Rect rect, View view, int i2) {
        this.f8318g.b(this.f8319h, view);
        if (i2 == 1) {
            int height = view.getHeight();
            Rect rect2 = this.f8319h;
            rect.top = height + rect2.top + rect2.bottom;
            return;
        }
        int width = view.getWidth();
        Rect rect3 = this.f8319h;
        rect.left = width + rect3.left + rect3.right;
    }

    public View a(RecyclerView recyclerView, int i2) {
        return this.c.a(recyclerView, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1 && this.f8316e.d(childAdapterPosition, this.f8315d.b(recyclerView))) {
            b(rect, a(recyclerView, childAdapterPosition), this.f8315d.a(recyclerView));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean e2;
        super.onDrawOver(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0 || this.a.getItemCount() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && ((e2 = this.f8316e.e(childAt, this.f8315d.a(recyclerView), childAdapterPosition)) || this.f8316e.d(childAdapterPosition, this.f8315d.b(recyclerView)))) {
                View a = this.c.a(recyclerView, childAdapterPosition);
                Rect rect = this.b.get(childAdapterPosition);
                if (rect == null) {
                    rect = new Rect();
                    this.b.put(childAdapterPosition, rect);
                }
                Rect rect2 = rect;
                this.f8316e.h(rect2, recyclerView, a, childAt, e2);
                this.f8317f.a(recyclerView, canvas, a, rect2);
            }
        }
    }

    private c(b bVar, com.timehop.stickyheadersrecyclerview.g.b bVar2, com.timehop.stickyheadersrecyclerview.e.a aVar) {
        this(bVar, bVar2, aVar, new com.timehop.stickyheadersrecyclerview.f.a(bVar2), new com.timehop.stickyheadersrecyclerview.d.b(bVar, bVar2));
    }

    private c(b bVar, com.timehop.stickyheadersrecyclerview.g.b bVar2, com.timehop.stickyheadersrecyclerview.e.a aVar, com.timehop.stickyheadersrecyclerview.f.a aVar2, com.timehop.stickyheadersrecyclerview.d.a aVar3) {
        this(bVar, aVar2, bVar2, aVar, aVar3, new a(bVar, aVar3, bVar2, aVar));
    }

    private c(b bVar, com.timehop.stickyheadersrecyclerview.f.a aVar, com.timehop.stickyheadersrecyclerview.g.b bVar2, com.timehop.stickyheadersrecyclerview.e.a aVar2, com.timehop.stickyheadersrecyclerview.d.a aVar3, a aVar4) {
        this.b = new SparseArray<>();
        this.f8319h = new Rect();
        this.a = bVar;
        this.c = aVar3;
        this.f8315d = bVar2;
        this.f8317f = aVar;
        this.f8318g = aVar2;
        this.f8316e = aVar4;
    }
}
