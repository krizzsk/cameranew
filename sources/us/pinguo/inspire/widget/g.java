package us.pinguo.inspire.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: CardItemDecoration.java */
/* loaded from: classes9.dex */
public class g extends RecyclerView.ItemDecoration {
    private int a;
    private int b;

    public g(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i2 = this.a;
        rect.right = i2;
        rect.left = i2;
        rect.bottom = i2;
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = this.b;
        }
    }
}
