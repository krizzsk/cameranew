package us.pinguo.inspire.module.discovery.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes9.dex */
public class TaskVideoChildCellDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public TaskVideoChildCellDecoration(int i2) {
        this.space = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i2 = this.space;
        rect.left = i2;
        rect.right = i2;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition - 1 == recyclerView.getAdapter().getItemCount()) {
            rect.right = 0;
        } else if (childAdapterPosition == 0) {
            rect.left = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }
}
