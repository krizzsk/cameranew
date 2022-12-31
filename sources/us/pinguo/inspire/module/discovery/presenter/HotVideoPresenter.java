package us.pinguo.inspire.module.discovery.presenter;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.cell.hotvideo.HotVideoCell;
import us.pinguo.inspire.module.discovery.cell.hotvideo.IFilterColorCell;
import us.pinguo.inspire.module.discovery.cell.hotvideo.IHeaderCell;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.inspire.widget.videocell.e;
import us.pinguo.inspire.widget.videocell.f;
import us.pinguo.widget.common.cell.recycler.b;
import us.pinguo.widget.common.cell.recycler.c;
/* loaded from: classes9.dex */
public class HotVideoPresenter extends f {
    private static final int MSG_PLAY_VIDEO = 1;
    private int mDy;
    private RecyclerView.OnScrollListener mFilterScrollListener;
    private Handler mPlayVideoHandler;
    private int mPlayingItem;
    private int mPreviousIndex;
    private int mPreviousState;
    private RecyclerView.OnScrollListener mScrollToCenterListener;
    private boolean mScrolledToWork;
    private Runnable scrollToCenterRunnable;

    public HotVideoPresenter(RecyclerView recyclerView, e eVar) {
        super(recyclerView, eVar);
        this.mFilterScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.discovery.presenter.HotVideoPresenter.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i2) {
                super.onScrollStateChanged(recyclerView2, i2);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i2, int i3) {
                super.onScrolled(recyclerView2, i2, i3);
                HotVideoPresenter.this.changeFilterColor(recyclerView2);
            }
        };
        this.mDy = 0;
        this.mScrollToCenterListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.discovery.presenter.HotVideoPresenter.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i2) {
                super.onScrollStateChanged(recyclerView2, i2);
                if (i2 == 1) {
                    HotVideoPresenter.this.mDy = 0;
                }
                if (i2 == 0) {
                    HotVideoPresenter hotVideoPresenter = HotVideoPresenter.this;
                    hotVideoPresenter.mPreviousIndex = hotVideoPresenter.scrollToCenterAndPlayVideo(recyclerView2, hotVideoPresenter.mDy);
                    HotVideoPresenter.this.mDy = 0;
                }
                HotVideoPresenter.this.mPreviousState = i2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i2, int i3) {
                super.onScrolled(recyclerView2, i2, i3);
                if (HotVideoPresenter.this.mPreviousState == 1) {
                    HotVideoPresenter.access$112(HotVideoPresenter.this, i3);
                }
            }
        };
        this.mPlayVideoHandler = new Handler() { // from class: us.pinguo.inspire.module.discovery.presenter.HotVideoPresenter.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (1 == message.what) {
                    int intValue = ((Integer) message.obj).intValue();
                    if (HotVideoPresenter.this.isPositionVisible(intValue)) {
                        HotVideoPresenter.this.mPlayingItem = intValue;
                        HotVideoPresenter.this.playVideo(intValue);
                    }
                }
            }
        };
        this.scrollToCenterRunnable = new Runnable() { // from class: us.pinguo.inspire.module.discovery.presenter.HotVideoPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                HotVideoPresenter hotVideoPresenter = HotVideoPresenter.this;
                hotVideoPresenter.scrollToCenterAndPlayVideo(((f) hotVideoPresenter).mRecyclerView, 0);
            }
        };
        this.mScrolledToWork = false;
        this.mRecyclerView.addOnScrollListener(this.mFilterScrollListener);
        this.mRecyclerView.addOnScrollListener(this.mScrollToCenterListener);
        this.mRecyclerView.removeOnScrollListener(this.onScrollListener);
        this.mRecyclerView.setFlingEnabled(false);
    }

    static /* synthetic */ int access$112(HotVideoPresenter hotVideoPresenter, int i2) {
        int i3 = hotVideoPresenter.mDy + i2;
        hotVideoPresenter.mDy = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeFilterColor(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        if (linearLayoutManager == null) {
            return;
        }
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int height = recyclerView.getHeight() / 2;
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            if (this.mAdapter.getItem(findFirstVisibleItemPosition) instanceof IFilterColorCell) {
                View findViewByPosition = this.mRecyclerView.getLayoutManager().findViewByPosition(findFirstVisibleItemPosition);
                ((IFilterColorCell) this.mAdapter.getItem(findFirstVisibleItemPosition)).filterColor((Math.abs((findViewByPosition.getTop() + (findViewByPosition.getHeight() / 2)) - height) * 1.0f) / (findViewByPosition.getHeight() * 0.5f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPositionVisible(int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        return i2 >= linearLayoutManager.findFirstVisibleItemPosition() && i2 <= linearLayoutManager.findLastVisibleItemPosition();
    }

    private int scrollToCenter(RecyclerView recyclerView, int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        if (linearLayoutManager == null) {
            return -1;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        View findViewByPosition = this.mRecyclerView.getLayoutManager().findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            return -1;
        }
        int height = (recyclerView.getHeight() / 2) + a.a(recyclerView.getContext(), 36.0f);
        int top = (findViewByPosition.getTop() + (findViewByPosition.getHeight() / 2)) - height;
        int i3 = findFirstVisibleItemPosition;
        int i4 = i3;
        boolean z = false;
        while (i3 <= findLastVisibleItemPosition) {
            View findViewByPosition2 = this.mRecyclerView.getLayoutManager().findViewByPosition(i3);
            int top2 = (findViewByPosition2.getTop() + (findViewByPosition2.getHeight() / 2)) - height;
            if (Math.abs(i2) > 50) {
                if (this.mPreviousIndex != i3) {
                    if (z) {
                        if (Math.abs(top2) >= Math.abs(top)) {
                        }
                        i4 = i3;
                        top = top2;
                    } else {
                        i4 = i3;
                        top = top2;
                        z = true;
                    }
                }
            } else {
                if (Math.abs(top2) >= Math.abs(top)) {
                }
                i4 = i3;
                top = top2;
            }
            i3++;
        }
        if (i4 == 0 && this.mAdapter.getItemCount() > 1) {
            View findViewByPosition3 = this.mRecyclerView.getLayoutManager().findViewByPosition(1);
            top = (findViewByPosition3.getTop() + (findViewByPosition3.getHeight() / 2)) - height;
            i4 = 1;
        }
        if (i4 == this.mAdapter.getItemCount() - 1 && this.mAdapter.getItemCount() > 1) {
            View findViewByPosition4 = this.mRecyclerView.getLayoutManager().findViewByPosition(this.mAdapter.getItemCount() - 2);
            top = (findViewByPosition4.getTop() + (findViewByPosition4.getHeight() / 2)) - height;
            i4 = this.mAdapter.getItemCount() - 2;
        }
        for (int i5 = findFirstVisibleItemPosition; i5 <= findLastVisibleItemPosition; i5++) {
            b item = this.mAdapter.getItem(i5);
            if ((item instanceof IHeaderCell) && i5 != i4 - 1) {
                ((IHeaderCell) item).hideHeader();
            }
        }
        int i6 = i4 - 1;
        if (i6 >= findFirstVisibleItemPosition) {
            b item2 = this.mAdapter.getItem(i6);
            if (item2 instanceof IHeaderCell) {
                ((IHeaderCell) item2).showHeader();
            }
        }
        if (top != 0) {
            recyclerView.smoothScrollBy(0, top);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int scrollToCenterAndPlayVideo(RecyclerView recyclerView, int i2) {
        c cVar;
        InspireVideoView videoView;
        int scrollToCenter = scrollToCenter(recyclerView, i2);
        Message obtainMessage = this.mPlayVideoHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = Integer.valueOf(scrollToCenter);
        if (this.mPlayingItem != scrollToCenter) {
            stopCurrentVideo();
            b item = this.mAdapter.getItem(this.mPlayingItem);
            if (item != null && (item instanceof HotVideoCell) && (cVar = item.mViewHolder) != null && (videoView = ((HotVideoCell) item).getVideoView(cVar)) != null) {
                videoView.k();
            }
        }
        this.mPlayVideoHandler.removeMessages(1);
        this.mPlayVideoHandler.sendMessageDelayed(obtainMessage, 300L);
        return scrollToCenter;
    }

    public void onRefreshCellsAdded(String str) {
        if (!TextUtils.isEmpty(str)) {
            scrollToWork(str);
        } else {
            this.mPostHandler.postDelayed(this.scrollToCenterRunnable, 200L);
        }
    }

    public void scrollToWork(String str) {
        InspireWork data;
        if (this.mScrolledToWork || TextUtils.isEmpty(str)) {
            return;
        }
        this.mScrolledToWork = true;
        List<b> cells = this.mAdapter.getCells();
        if (cells != null) {
            int i2 = 0;
            for (b bVar : cells) {
                if ((bVar instanceof HotVideoCell) && (data = ((HotVideoCell) bVar).getData()) != null && str.equals(data.getWorkId())) {
                    this.mRecyclerView.scrollToPosition(i2);
                    this.mPostHandler.postDelayed(this.scrollToCenterRunnable, 200L);
                    return;
                }
                i2++;
            }
        }
    }
}
