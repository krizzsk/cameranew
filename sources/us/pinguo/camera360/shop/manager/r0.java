package us.pinguo.camera360.shop.manager;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: MyItemTouchCallback.java */
/* loaded from: classes4.dex */
public class r0 extends ItemTouchHelper.Callback {
    private a a;
    private Drawable b = null;
    private int c = -1;

    /* compiled from: MyItemTouchCallback.java */
    /* loaded from: classes4.dex */
    public interface a {
        void onMove(int i2, int i3);
    }

    public r0(a aVar) {
        this.a = aVar;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        Drawable drawable = this.b;
        if (drawable != null) {
            viewHolder.itemView.setBackgroundDrawable(drawable);
        }
        int i2 = this.c;
        if (i2 != -1) {
            viewHolder.itemView.setBackgroundColor(i2);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
        if (i2 == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(f2) / viewHolder.itemView.getWidth()));
            viewHolder.itemView.setTranslationX(f2);
            return;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f2, f3, i2, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        this.a.onMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
        if (i2 != 0) {
            if (this.b == null && this.c == -1) {
                Drawable background = viewHolder.itemView.getBackground();
                if (background == null) {
                    this.c = 0;
                } else {
                    this.b = background;
                }
            }
            viewHolder.itemView.setBackgroundColor(-3355444);
        }
        super.onSelectedChanged(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
    }
}
