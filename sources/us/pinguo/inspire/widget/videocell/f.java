package us.pinguo.inspire.widget.videocell;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.c360.i18n.R;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.VideoPlayer;
import us.pinguo.ui.widget.video.c;
import us.pinguo.user.recycler.FlingFilterRecyclerView;
import us.pinguo.util.q;
/* compiled from: InspireVideoPresenter.java */
/* loaded from: classes9.dex */
public class f implements us.pinguo.ui.widget.dialog.a, BaseAbsListFragment.e {
    protected us.pinguo.inspire.widget.videocell.e mAdapter;
    private boolean mDefaultSilent;
    private boolean mFirstResume;
    private us.pinguo.ui.widget.dialog.a mILifeCycleInteceptor;
    protected FlingFilterRecyclerView mRecyclerView;
    protected VideoPlayer mVideoPlayer;
    protected Handler mPostHandler = new Handler();
    private boolean isScroll = false;
    private boolean isPause = false;
    private int mCurrentPlayingCellIndex = -1;
    private boolean mFirstResumeNoPlay = false;
    protected RecyclerView.OnScrollListener onScrollListener = new a();
    protected us.pinguo.inspire.b0.b videoLoadCompleteListener = new C0412f();
    private us.pinguo.inspire.b0.a mClickVideoListener = new g();

    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                f.this.isScroll = false;
                f.this.playVideo();
                return;
            }
            f.this.isScroll = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            us.pinguo.widget.common.cell.recycler.b item;
            us.pinguo.widget.common.cell.recycler.b item2;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) f.this.mRecyclerView.getLayoutManager();
            if (i3 < 0) {
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= f.this.mAdapter.getItemCount() - 1 && findFirstVisibleItemPosition != f.this.mCurrentPlayingCellIndex && (item2 = f.this.mAdapter.getItem(findFirstVisibleItemPosition)) != null && (item2 instanceof us.pinguo.inspire.widget.videocell.d)) {
                    us.pinguo.inspire.widget.videocell.d dVar = (us.pinguo.inspire.widget.videocell.d) item2;
                    dVar.showCoverView();
                    dVar.setSilent(f.this.mDefaultSilent);
                }
            } else {
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (findLastVisibleItemPosition <= f.this.mAdapter.getItemCount() - 1 && findLastVisibleItemPosition >= 0 && findLastVisibleItemPosition != f.this.mCurrentPlayingCellIndex && (item = f.this.mAdapter.getItem(findLastVisibleItemPosition)) != null && (item instanceof us.pinguo.inspire.widget.videocell.d)) {
                    us.pinguo.inspire.widget.videocell.d dVar2 = (us.pinguo.inspire.widget.videocell.d) item;
                    dVar2.showCoverView();
                    dVar2.setSilent(f.this.mDefaultSilent);
                }
            }
            if (f.this.mCurrentPlayingCellIndex >= 0) {
                f.this.checkToPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    public class b implements c.a {
        b(f fVar) {
        }

        @Override // us.pinguo.ui.widget.video.c.a
        public void onBufferingUpdate(int i2) {
            us.pinguo.common.log.a.g("zhouwei", "percent：" + i2, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    public class c implements c.InterfaceC0457c {
        final /* synthetic */ long a;
        final /* synthetic */ Uri b;
        final /* synthetic */ us.pinguo.inspire.widget.videocell.d c;

        /* compiled from: InspireVideoPresenter.java */
        /* loaded from: classes9.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.c.onVideoPrepared();
            }
        }

        c(long j2, Uri uri, us.pinguo.inspire.widget.videocell.d dVar) {
            this.a = j2;
            this.b = uri;
            this.c = dVar;
        }

        @Override // us.pinguo.ui.widget.video.c.InterfaceC0457c
        public void onPrepared() {
            System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            if (us.pinguo.inspire.data.a.a(this.b)) {
                hashMap.put("repeat_seek", "true");
            } else {
                hashMap.put("repeat_seek", "false");
            }
            us.pinguo.common.log.a.g("zhouwei", "prepare..................", new Object[0]);
            f.this.mPostHandler.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    public class d implements IMediaPlayer.OnErrorListener {
        d(f fVar) {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
            if (!q.f(Inspire.a())) {
                j0.c(R.string.network_error);
            }
            us.pinguo.common.log.a.g("zhangkaiyu", "onError", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    public class e implements IMediaPlayer.OnCompletionListener {
        final /* synthetic */ us.pinguo.inspire.widget.videocell.d a;

        /* compiled from: InspireVideoPresenter.java */
        /* loaded from: classes9.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                us.pinguo.inspire.widget.videocell.d dVar = e.this.a;
                if (dVar != null) {
                    dVar.showPlayView();
                }
            }
        }

        e(f fVar, us.pinguo.inspire.widget.videocell.d dVar) {
            this.a = dVar;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            if (q.h(Inspire.a())) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    /* compiled from: InspireVideoPresenter.java */
    /* renamed from: us.pinguo.inspire.widget.videocell.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0412f implements us.pinguo.inspire.b0.b {
        C0412f() {
        }

        @Override // us.pinguo.inspire.b0.b
        public void a(String str) {
            if (f.this.isScroll || f.this.isPause) {
                return;
            }
            f.this.delayPlayVideo();
        }
    }

    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    class g implements us.pinguo.inspire.b0.a {
        g() {
        }

        @Override // us.pinguo.inspire.b0.a
        public void a(us.pinguo.inspire.widget.videocell.d dVar) {
            f fVar = f.this;
            fVar.playVideo(fVar.mAdapter.indexOf(dVar), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireVideoPresenter.java */
    /* loaded from: classes9.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.playVideo();
        }
    }

    public f(RecyclerView recyclerView, us.pinguo.inspire.widget.videocell.e eVar) {
        this.mRecyclerView = (FlingFilterRecyclerView) recyclerView;
        this.mAdapter = eVar;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkToPause() {
        if (this.mVideoPlayer == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0) {
            findFirstVisibleItemPosition = 0;
        }
        int i2 = this.mCurrentPlayingCellIndex;
        if (i2 < findFirstVisibleItemPosition || i2 > findLastVisibleItemPosition) {
            this.mVideoPlayer.f();
            this.mVideoPlayer.b();
            us.pinguo.common.log.a.k("index:" + this.mCurrentPlayingCellIndex + "item已移出界面，停止播放", new Object[0]);
            this.mCurrentPlayingCellIndex = -1;
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(-1);
            if (item == null || !(item instanceof us.pinguo.inspire.widget.videocell.d)) {
                return;
            }
            us.pinguo.inspire.widget.videocell.d dVar = (us.pinguo.inspire.widget.videocell.d) item;
            dVar.showCoverView();
            dVar.setSilent(this.mDefaultSilent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideo() {
        playVideo(getCurrentItem());
    }

    protected void delayPlayVideo() {
        this.mPostHandler.postDelayed(new h(), 100L);
    }

    public int getCurrentItem() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        if (linearLayoutManager == null) {
            return -1;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0) {
            findFirstVisibleItemPosition = 0;
        }
        if (findLastVisibleItemPosition >= this.mAdapter.getItemCount()) {
            findLastVisibleItemPosition = this.mAdapter.getItemCount() - 1;
        }
        if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
            int i2 = findLastVisibleItemPosition - findFirstVisibleItemPosition;
            if (i2 >= 2) {
                return findFirstVisibleItemPosition + (i2 / 2);
            }
            us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(findFirstVisibleItemPosition);
            us.pinguo.widget.common.cell.recycler.b item2 = this.mAdapter.getItem(findLastVisibleItemPosition);
            if (item == null || item2 == null || item.mViewHolder == 0 || item2.mViewHolder == 0) {
                return 0;
            }
            int height = this.mRecyclerView.getHeight() / 2;
            if (Math.abs(height - (item.mViewHolder.itemView.getTop() + (item.mViewHolder.itemView.getHeight() / 2))) >= Math.abs(height - (item2.mViewHolder.itemView.getTop() + (item2.mViewHolder.itemView.getHeight() / 2)))) {
                return findLastVisibleItemPosition;
            }
        }
        return findFirstVisibleItemPosition;
    }

    public int getSeekTime(Uri uri) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null || !videoPlayer.isPlaying() || uri == null || !uri.equals(this.mVideoPlayer.B())) {
            return 0;
        }
        return (int) this.mVideoPlayer.z();
    }

    public us.pinguo.inspire.b0.b getVideoLoadCompleteListener() {
        return this.videoLoadCompleteListener;
    }

    public VideoPlayer getVideoPlayer() {
        return this.mVideoPlayer;
    }

    protected void init() {
        this.mRecyclerView.addOnScrollListener(this.onScrollListener);
        this.mAdapter.setVideoLoadCompleteListener(this.videoLoadCompleteListener);
        this.mAdapter.setClickVideoListener(this.mClickVideoListener);
    }

    public boolean isPause() {
        return this.isPause;
    }

    public boolean isPlaying() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null) {
            return false;
        }
        return videoPlayer.isPlaying();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment.e
    public void onDataRefreshed() {
        stopCurrentVideo();
    }

    public void onDestroyView() {
    }

    @Override // us.pinguo.ui.widget.dialog.a
    public void onPause() {
        us.pinguo.ui.widget.dialog.a aVar = this.mILifeCycleInteceptor;
        if (aVar != null) {
            aVar.onPause();
            return;
        }
        this.isPause = true;
        stopCurrentVideo();
    }

    @Override // us.pinguo.ui.widget.dialog.a
    public void onResume() {
        us.pinguo.ui.widget.dialog.a aVar = this.mILifeCycleInteceptor;
        if (aVar != null) {
            aVar.onResume();
            return;
        }
        this.isPause = false;
        if (this.mFirstResumeNoPlay && this.mFirstResume) {
            return;
        }
        playVideo();
    }

    public void onSelected() {
        onResume();
    }

    public void onUnSelected() {
        onPause();
    }

    public void onViewCreated() {
        this.mVideoPlayer = new VideoPlayer(Inspire.a());
        this.mFirstResume = true;
    }

    public void postPause() {
        this.mCurrentPlayingCellIndex = -1;
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.f();
            if (this.mVideoPlayer.isPlaying()) {
                this.mVideoPlayer.a();
            }
        }
    }

    public void setFirstResumeNoPlay(boolean z) {
        this.mFirstResumeNoPlay = z;
    }

    public void setILifeCyclerInteceptor(us.pinguo.ui.widget.dialog.a aVar) {
        this.mILifeCycleInteceptor = aVar;
    }

    public void setSilent(boolean z) {
        this.mDefaultSilent = z;
        this.mAdapter.setDefaultSilent(z);
    }

    public void stopCurrentVideo() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.f();
            us.pinguo.common.log.a.k("stopCurrentVideo:releaseAsync", new Object[0]);
            this.mVideoPlayer.b();
        }
        us.pinguo.widget.common.cell.recycler.b item = this.mAdapter.getItem(this.mCurrentPlayingCellIndex);
        if (item != null && (item instanceof us.pinguo.inspire.widget.videocell.d)) {
            ((us.pinguo.inspire.widget.videocell.d) item).setSilent(true);
        }
        this.mCurrentPlayingCellIndex = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playVideo(int i2) {
        playVideo(i2, false);
    }

    protected void playVideo(int i2, boolean z) {
        us.pinguo.widget.common.cell.recycler.b item;
        VideoPlayer videoPlayer;
        us.pinguo.widget.common.cell.recycler.c cVar;
        if (!q.h(this.mRecyclerView.getContext()) && !z) {
            us.pinguo.widget.common.cell.recycler.b item2 = this.mAdapter.getItem(i2);
            if (!(item2 instanceof us.pinguo.inspire.widget.videocell.d) || (cVar = item2.mViewHolder) == null) {
                return;
            }
            ((us.pinguo.inspire.widget.videocell.d) item2).getVideoView(cVar).l();
        } else if (this.isPause || (item = this.mAdapter.getItem(i2)) == null || (videoPlayer = this.mVideoPlayer) == null) {
        } else {
            if (!(this.mCurrentPlayingCellIndex == i2 && videoPlayer.isPlaying()) && (item instanceof us.pinguo.inspire.widget.videocell.d)) {
                us.pinguo.inspire.widget.videocell.d dVar = (us.pinguo.inspire.widget.videocell.d) item;
                String videoUrl = dVar.getVideoUrl();
                BaseVideoTextureView videoView = dVar.getVideoView();
                if (videoUrl == null || videoView == null) {
                    return;
                }
                videoView.setRotation(dVar.getViewSize().c);
                long currentTimeMillis = System.currentTimeMillis();
                this.mCurrentPlayingCellIndex = i2;
                this.mVideoPlayer.f();
                if (this.mVideoPlayer.isPlaying()) {
                    this.mVideoPlayer.a();
                }
                Uri parse = Uri.parse(videoUrl);
                this.mVideoPlayer.a0(dVar.getInspireVideoView());
                this.mVideoPlayer.W(new b(this));
                this.mVideoPlayer.c0(new c(currentTimeMillis, parse, dVar));
                this.mVideoPlayer.Z(new d(this));
                this.mVideoPlayer.Y(new e(this, dVar));
                dVar.onVideoStart();
                this.mVideoPlayer.d0(dVar.isSilent());
                this.mVideoPlayer.Q(parse);
                this.mVideoPlayer.c(videoView);
                this.mVideoPlayer.V(q.h(Inspire.a()));
                this.mVideoPlayer.d();
            }
        }
    }
}
