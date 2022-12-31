package us.pinguo.inspire.module.discovery.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
/* loaded from: classes9.dex */
public class DiscoverySquareDecoration extends RecyclerView.ItemDecoration {
    private StaggeredGridLayoutManager.LayoutParams lp;
    private int space;
    private Integer topMargin;

    public DiscoverySquareDecoration(int i2) {
        this.space = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i2;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition < 0) {
            return;
        }
        int itemViewType = recyclerView.getAdapter().getItemViewType(childAdapterPosition);
        if (itemViewType >= DiscoverySquareCellType.WATER_FALL_WORK.ordinal()) {
            rect.bottom = this.space;
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            this.lp = layoutParams;
            if (layoutParams.getSpanIndex() == 0) {
                rect.left = 0;
                rect.right = this.space / 2;
            } else {
                rect.left = this.space / 2;
                rect.right = 0;
            }
        } else {
            rect.bottom = (int) (this.space * 1.5d);
            rect.left = 0;
            rect.right = 0;
        }
        if (itemViewType == 0) {
            rect.bottom = 0;
        }
        DiscoverySquareCellType discoverySquareCellType = DiscoverySquareCellType.CHALLENGE;
        if (itemViewType == discoverySquareCellType.ordinal() && (i2 = childAdapterPosition + 1) < recyclerView.getAdapter().getItemCount() - 1 && recyclerView.getAdapter().getItemViewType(i2) == discoverySquareCellType.ordinal()) {
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }

    public DiscoverySquareDecoration(int i2, int i3) {
        this.space = i2;
        this.topMargin = Integer.valueOf(i3);
    }
}
