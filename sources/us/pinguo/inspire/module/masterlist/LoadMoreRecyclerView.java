package us.pinguo.inspire.module.masterlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.R;
/* loaded from: classes9.dex */
public class LoadMoreRecyclerView extends RecyclerView {
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_NORMAL = 0;
    private AutoLoadAdapter mAutoLoadAdapter;
    private boolean mIsFooterEnable;
    private boolean mIsLoadingMore;
    private LoadMoreListener mListener;
    private int mLoadMorePosition;

    /* loaded from: classes9.dex */
    public class AutoLoadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private RecyclerView.Adapter mInternalAdapter;
        private int mInternalCount;

        /* loaded from: classes9.dex */
        public class FooterViewHolder extends RecyclerView.ViewHolder {
            public FooterViewHolder(View view) {
                super(view);
            }
        }

        public AutoLoadAdapter(RecyclerView.Adapter adapter) {
            this.mInternalAdapter = adapter;
            this.mInternalCount = adapter.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int itemCount = this.mInternalAdapter.getItemCount();
            return (!LoadMoreRecyclerView.this.mIsFooterEnable || this.mInternalCount <= 6) ? itemCount : itemCount + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return (getItemCount() + (-1) == i2 && LoadMoreRecyclerView.this.mIsFooterEnable && this.mInternalCount > 6) ? 2 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            if (getItemViewType(i2) != 2) {
                this.mInternalAdapter.onBindViewHolder(viewHolder, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 2) {
                return new FooterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_load_more, viewGroup, false));
            }
            return this.mInternalAdapter.onCreateViewHolder(viewGroup, i2);
        }
    }

    /* loaded from: classes9.dex */
    public interface LoadMoreListener {
        void onLoadMore();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        this.mIsFooterEnable = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastVisiblePosition() {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
        }
        return getLayoutManager().getItemCount() - 1;
    }

    private void init() {
        super.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.masterlist.LoadMoreRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                us.pinguo.common.log.a.m("chenxiaokai", "chenixoakai==>newState=" + i2, new Object[0]);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                us.pinguo.common.log.a.m("chenxiaokai", "chenixoakai==>dx=" + i2 + ",dy=" + i3, new Object[0]);
                if (LoadMoreRecyclerView.this.mListener == null || !LoadMoreRecyclerView.this.mIsFooterEnable || LoadMoreRecyclerView.this.mIsLoadingMore || i3 <= 0) {
                    return;
                }
                int lastVisiblePosition = LoadMoreRecyclerView.this.getLastVisiblePosition();
                if (lastVisiblePosition + 1 == LoadMoreRecyclerView.this.mAutoLoadAdapter.getItemCount()) {
                    LoadMoreRecyclerView.this.setLoadingMore(true);
                    LoadMoreRecyclerView.this.mLoadMorePosition = lastVisiblePosition;
                    LoadMoreRecyclerView.this.mListener.onLoadMore();
                }
            }
        });
    }

    public void notifyMoreFinish(boolean z) {
        setAutoLoadMoreEnable(z);
        if (getAdapter() != null && getAdapter().getItemCount() > 6) {
            getAdapter().notifyItemRemoved(this.mLoadMorePosition);
        }
        this.mIsLoadingMore = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            this.mAutoLoadAdapter = new AutoLoadAdapter(adapter);
        }
        super.swapAdapter(this.mAutoLoadAdapter, true);
    }

    public void setAutoLoadMoreEnable(boolean z) {
        this.mIsFooterEnable = z;
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.mListener = loadMoreListener;
    }

    public void setLoadingMore(boolean z) {
        this.mIsLoadingMore = z;
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFooterEnable = false;
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsFooterEnable = false;
        init();
    }
}
