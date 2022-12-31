package us.pinguo.picker.image;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: SpliceDecoration.kt */
/* loaded from: classes5.dex */
public final class h extends RecyclerView.ItemDecoration {
    private final int a;
    private final boolean b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11719d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11720e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11721f;

    public h(int i2, boolean z) {
        int b;
        int b2;
        this.a = i2;
        this.b = z;
        b = kotlin.y.c.b(i2 / 2.0f);
        this.c = b;
        this.f11719d = i2;
        b2 = kotlin.y.c.b((i2 / 2.0f) * 3);
        this.f11720e = b2;
        this.f11721f = i2 * 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        s.h(outRect, "outRect");
        s.h(view, "view");
        s.h(parent, "parent");
        s.h(state, "state");
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        if (this.b) {
            childLayoutPosition--;
        }
        int i2 = childLayoutPosition % 3;
        if (i2 != -1) {
            if (i2 == 0) {
                outRect.set(0, 0, this.f11720e, this.f11721f);
            } else if (i2 == 1) {
                outRect.set(this.c, 0, this.f11719d, this.f11721f);
            } else if (i2 != 2) {
                outRect.set(0, 0, this.f11720e, this.a * 2);
            } else {
                outRect.set(this.f11719d, 0, 0, this.f11721f);
            }
        }
    }

    public /* synthetic */ h(int i2, boolean z, int i3, o oVar) {
        this(i2, (i3 & 2) != 0 ? false : z);
    }
}
