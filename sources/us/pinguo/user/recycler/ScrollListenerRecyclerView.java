package us.pinguo.user.recycler;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ScrollListenerRecyclerView extends RecyclerView {
    private List<RecyclerView.OnScrollListener> mCopyScrollListeners;

    public ScrollListenerRecyclerView(Context context) {
        super(context);
        this.mCopyScrollListeners = new LinkedList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        super.addOnScrollListener(onScrollListener);
        this.mCopyScrollListeners.add(onScrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void clearOnScrollListeners() {
        super.clearOnScrollListeners();
        this.mCopyScrollListeners.clear();
    }

    public List<RecyclerView.OnScrollListener> getOnScrollListeners() {
        return this.mCopyScrollListeners;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        super.removeOnScrollListener(onScrollListener);
        this.mCopyScrollListeners.remove(onScrollListener);
    }

    public ScrollListenerRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCopyScrollListeners = new LinkedList();
    }

    public ScrollListenerRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCopyScrollListeners = new LinkedList();
    }
}
