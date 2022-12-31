package us.pinguo.camera2020.view.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: StickerGridDecoration.kt */
/* loaded from: classes3.dex */
public final class s extends RecyclerView.ItemDecoration {
    private final int a;
    private final int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9375d;

    public s(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f9375d = i5;
    }

    public final void a(int i2) {
        this.c = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        kotlin.jvm.internal.s.h(outRect, "outRect");
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(parent, "parent");
        kotlin.jvm.internal.s.h(state, "state");
        int i2 = this.a;
        outRect.left = i2;
        outRect.right = i2;
        outRect.top = this.b;
        if (((int) Math.ceil((parent.getChildAdapterPosition(view) + 1) * 0.2f)) == this.c) {
            outRect.bottom = (parent.getMeasuredHeight() - this.b) - this.f9375d;
        } else {
            outRect.bottom = this.b;
        }
    }
}
