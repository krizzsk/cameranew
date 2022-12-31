package us.pinguo.camera360.shop.manager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* loaded from: classes4.dex */
public class DividerGridItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] a = {16843284};

    public DividerGridItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    private int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        state.willRunPredictiveAnimations();
        ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        a(recyclerView);
        recyclerView.getAdapter().getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
    }

    public DividerGridItemDecoration(int i2) {
        new ColorDrawable(i2);
    }

    public DividerGridItemDecoration() {
        this(Color.parseColor("#ffffff"));
    }
}
