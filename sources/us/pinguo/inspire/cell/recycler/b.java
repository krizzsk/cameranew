package us.pinguo.inspire.cell.recycler;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.inspire.Inspire;
/* compiled from: NiceUserSpaceItemDecoration.java */
/* loaded from: classes9.dex */
public class b extends RecyclerView.ItemDecoration {
    private int a;

    public b(int i2) {
        this.a = us.pinguo.foundation.t.b.a.a(Inspire.a(), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.a;
        rect.right = i2;
        rect.left = i2;
        rect.top = i2;
        if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
            rect.bottom = this.a;
        } else {
            rect.bottom = 0;
        }
        if (childAdapterPosition == 0) {
            rect.left = 0;
            rect.right = 0;
            rect.top = 0;
        }
    }
}
