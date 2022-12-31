package us.pinguo.inspire.module.discovery.cell;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.adapter.DiscoveryBannerCellAdapter;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryBanner;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryBannerItem;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.inspire.widget.video.WorkDetailVideoView;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.ui.widget.banner.BannerView;
import us.pinguo.ui.widget.video.VideoPlayer;
import us.pinguo.ui.widget.video.c;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryBannerCell extends us.pinguo.widget.common.cell.recycler.b<DiscoveryBanner, c> implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    private static final long AUTO_SCROLL_DELAY_TIME = 5000;
    private static final int MSG_SCROLL_TO_NEXT = 1;
    private DiscoveryBannerCellAdapter mBannerItemAdapter;
    public boolean mBannerVisiable;
    private View mCurrentItemView;
    private int mCurrentSelectPosition;
    private int mHeight;
    private Handler mPostHandler;
    private VideoPlayer mVideoPlayer;
    private int mWidth;
    private AdapterView.OnItemClickListener onItemClickListener;

    public DiscoveryBannerCell(DiscoveryBanner discoveryBanner, Context context) {
        super(discoveryBanner);
        int j2 = us.pinguo.foundation.t.b.a.j(Inspire.a());
        this.mWidth = j2;
        this.mHeight = (int) (j2 * 0.73333335f);
        this.mPostHandler = new Handler();
        this.mBannerVisiable = true;
        this.onItemClickListener = new AdapterView.OnItemClickListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryBannerCell.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j3) {
                DiscoveryBannerItem item = DiscoveryBannerCell.this.mBannerItemAdapter.getItem(i2);
                AdvItem advItem = item.advItem;
                if (advItem != null) {
                    if (TextUtils.isEmpty(advItem.interactionUri)) {
                        return;
                    }
                    us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c(item.advItem.headclickUri);
                    c.c("force_inner_browser", item.advItem.forceInnerBrowser);
                    c.b(view.getContext());
                    item.advItem.exePvTaskClick();
                } else if ("task".equals(item.squareBanner.type)) {
                    Context context2 = view.getContext();
                    Intent intent = new Intent();
                    intent.setClassName(context2, "us.pinguo.inspire.module.MissionDetail.TaskDetailActivity");
                    intent.putExtra("task", DiscoveryBannerCell.this.mBannerItemAdapter.getItem(i2).squareBanner.task);
                    context2.startActivity(intent);
                }
            }
        };
        this.mVideoPlayer = new VideoPlayer(context);
    }

    private void checkToPlayVideo(View view, int i2) {
        DiscoveryBannerItem item = this.mBannerItemAdapter.getItem(i2);
        if (this.mBannerVisiable && item != null && "video".equals(item.media)) {
            playVideo(view, item);
        }
    }

    private void playVideo(View view, DiscoveryBannerItem discoveryBannerItem) {
        if (view == null || discoveryBannerItem == null) {
            return;
        }
        playVideo((InspireVideoView) view.findViewById(R.id.ivv_discovery_square_banner_cell), discoveryBannerItem.url);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        BannerView bannerView = (BannerView) LayoutInflater.from(viewGroup.getContext()).inflate(us.pinguo.ui.R.layout.banner_layout, viewGroup, false);
        c cVar = new c(bannerView);
        bannerView.getLayoutParams().height = this.mHeight;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return DiscoverySquareCellType.BANNER.ordinal();
    }

    public boolean isCurrentVideoItem() {
        return 1 == this.mBannerItemAdapter.getItemViewType(this.mCurrentSelectPosition);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        T t = this.mData;
        if (t == 0 || k.a(((DiscoveryBanner) t).list)) {
            return;
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) cVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        BannerView bannerView = (BannerView) cVar.itemView;
        this.mBannerItemAdapter = new DiscoveryBannerCellAdapter();
        bannerView.b(false);
        bannerView.setOnItemClickListener(this);
        bannerView.setOnItemSelectedListener(this);
        bannerView.setAutoScroll(true);
        bannerView.setAdapter(this.mBannerItemAdapter);
        this.mBannerItemAdapter.addAll(((DiscoveryBanner) this.mData).list);
        bannerView.setOnItemClickListener(this.onItemClickListener);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.mCurrentSelectPosition = i2;
        this.mCurrentItemView = view;
        checkToPlayVideo(view, i2);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onPause() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null || !videoPlayer.isPlaying()) {
            return;
        }
        this.mVideoPlayer.O();
    }

    public void onResume() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null || !videoPlayer.isPlaying()) {
            return;
        }
        this.mVideoPlayer.g0();
    }

    public void playCurrentVideo() {
        checkToPlayVideo(this.mCurrentItemView, this.mCurrentSelectPosition);
    }

    public void playVideo(final InspireVideoView inspireVideoView, String str) {
        WorkDetailVideoView b = inspireVideoView.b();
        if (str == null || b == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mVideoPlayer.f();
        this.mVideoPlayer.a();
        final Uri parse = Uri.parse(str);
        this.mVideoPlayer.W(new c.a() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryBannerCell.2
            @Override // us.pinguo.ui.widget.video.c.a
            public void onBufferingUpdate(int i2) {
                us.pinguo.common.log.a.g("zhouwei", "percent：" + i2, new Object[0]);
            }
        });
        this.mVideoPlayer.c0(new c.InterfaceC0457c() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryBannerCell.3
            @Override // us.pinguo.ui.widget.video.c.InterfaceC0457c
            public void onPrepared() {
                System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                if (us.pinguo.inspire.data.a.a(parse)) {
                    hashMap.put("repeat_seek", "true");
                } else {
                    hashMap.put("repeat_seek", "false");
                }
                us.pinguo.common.log.a.g("zhouwei", "prepare..................", new Object[0]);
                DiscoveryBannerCell.this.mPostHandler.post(new Runnable() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryBannerCell.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        inspireVideoView.h();
                    }
                });
            }
        });
        this.mVideoPlayer.Z(new IMediaPlayer.OnErrorListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryBannerCell.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
                us.pinguo.common.log.a.g("zhangkaiyu", "onError", new Object[0]);
                return false;
            }
        });
        this.mVideoPlayer.Y(new IMediaPlayer.OnCompletionListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryBannerCell.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                us.pinguo.common.log.a.g("zhouwei", "onCompletion..................", new Object[0]);
            }
        });
        inspireVideoView.j();
        this.mVideoPlayer.Q(parse);
        this.mVideoPlayer.c(b);
        this.mVideoPlayer.V(true);
        this.mVideoPlayer.d();
    }
}
