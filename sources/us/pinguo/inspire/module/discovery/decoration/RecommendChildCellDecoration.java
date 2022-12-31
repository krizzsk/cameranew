package us.pinguo.inspire.module.discovery.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes9.dex */
public class RecommendChildCellDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public RecommendChildCellDecoration(int i2) {
        this.space = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if ((Build.VERSION.SDK_INT >= 17 ? recyclerView.getLayoutDirection() : 0) == 1) {
            rect.left = this.space;
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.right = this.space;
                return;
            } else {
                rect.right = 0;
                return;
            }
        }
        rect.right = this.space;
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.space;
        } else {
            rect.left = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }
}
