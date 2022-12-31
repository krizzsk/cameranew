package us.pinguo.inspire.module.challenge.videomusic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.models.PageEvent;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.base.easyload.EasyListFragment;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.ui.widget.video.VideoPlayer;
import vStudio.Android.Camera360.R;
/* compiled from: VideoMusicListFragment.kt */
/* loaded from: classes9.dex */
public final class VideoMusicListFragment extends EasyListFragment<VideoMusicResp> implements IMusicListFragment {
    private ProgressWheel downloadProgressView;
    private VideoMusic lastDownloadMusic;
    private boolean loadFromIntent;
    private ProgressWheel playProgressView;
    private VideoPlayer player;
    private final kotlin.f referer$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final int COUNT = 100;
    private int current_page = 1;
    private boolean showOriItem = true;

    public VideoMusicListFragment() {
        kotlin.f b;
        b = kotlin.h.b(new VideoMusicListFragment$referer$2(this));
        this.referer$delegate = b;
    }

    private final String getReferer() {
        return (String) this.referer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hidePlayProgress$lambda-6  reason: not valid java name */
    public static final void m121hidePlayProgress$lambda6(VideoMusicListFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ProgressWheel progressWheel = this$0.playProgressView;
        if (progressWheel == null) {
            return;
        }
        progressWheel.setVisibility(8);
    }

    private final void initFromIntent() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if ((activity == null || (intent = activity.getIntent()) == null || !intent.hasExtra("task")) ? false : true) {
            InspireTask inspireTask = (InspireTask) requireActivity().getIntent().getParcelableExtra("task");
            if ((inspireTask == null ? null : inspireTask.fixedMusic) == null || inspireTask.fixedMusic.size() <= 0) {
                return;
            }
            this.loadFromIntent = true;
            ArrayList arrayList = new ArrayList();
            List<VideoMusic> it = inspireTask.fixedMusic;
            kotlin.jvm.internal.s.g(it, "it");
            for (VideoMusic it2 : it) {
                kotlin.jvm.internal.s.g(it2, "it");
                arrayList.add(new VideoMusicCell(it2, this));
            }
            this.mAdapter.set(arrayList);
            setLoadMoreEnabled(false);
            this.mRefreshLayout.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m122onViewCreated$lambda1(final VideoMusicListFragment this$0, IMediaPlayer iMediaPlayer) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.mRecyclerView.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.q0
            @Override // java.lang.Runnable
            public final void run() {
                VideoMusicListFragment.m123onViewCreated$lambda1$lambda0(VideoMusicListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1$lambda-0  reason: not valid java name */
    public static final void m123onViewCreated$lambda1$lambda0(VideoMusicListFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        VideoMusicCell playingCell = VideoMusicCell.Companion.getPlayingCell();
        if (playingCell != null) {
            playingCell.onPlayStop();
        }
        this$0.hidePlayProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final boolean m124onViewCreated$lambda2(VideoMusicListFragment this$0, IMediaPlayer iMediaPlayer, int i2, int i3) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == 701) {
            this$0.showPlayProgress();
            return false;
        } else if (i2 == 702) {
            this$0.hidePlayProgress();
            return false;
        } else if (i2 != 10002) {
            return false;
        } else {
            this$0.hidePlayProgress();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final boolean m125onViewCreated$lambda3(VideoMusicListFragment this$0, IMediaPlayer iMediaPlayer, int i2, int i3) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.hidePlayProgress();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPlayProgress$lambda-7  reason: not valid java name */
    public static final void m126showPlayProgress$lambda7(VideoMusicListFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ProgressWheel progressWheel = this$0.playProgressView;
        if (progressWheel == null) {
            return;
        }
        progressWheel.setVisibility(0);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final int getCOUNT() {
        return this.COUNT;
    }

    public final int getCurrent_page() {
        return this.current_page;
    }

    public final ProgressWheel getDownloadProgressView() {
        return this.downloadProgressView;
    }

    public final VideoMusic getLastDownloadMusic() {
        return this.lastDownloadMusic;
    }

    public final boolean getLoadFromIntent() {
        return this.loadFromIntent;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "challenge_bgm_advance_page";
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PageEvent.TYPE_NAME, "1");
        hashMap.put("num", String.valueOf(this.COUNT));
        return hashMap;
    }

    public final ProgressWheel getPlayProgressView() {
        return this.playProgressView;
    }

    public final VideoPlayer getPlayer() {
        return this.player;
    }

    public final boolean getShowOriItem() {
        return this.showOriItem;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected Type getType() {
        Type type = new com.google.gson.t.a<BaseResponse<VideoMusicResp>>() { // from class: us.pinguo.inspire.module.challenge.videomusic.VideoMusicListFragment$getType$1
        }.getType();
        kotlin.jvm.internal.s.g(type, "object : TypeToken<BaseR…Resp>>() {\n        }.type");
        return type;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return kotlin.jvm.internal.s.q(Inspire.f11205f, "/camera360/music/list");
    }

    public final void hidePlayProgress() {
        ProgressWheel progressWheel = this.playProgressView;
        if (progressWheel == null) {
            return;
        }
        progressWheel.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.r0
            @Override // java.lang.Runnable
            public final void run() {
                VideoMusicListFragment.m121hidePlayProgress$lambda6(VideoMusicListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initData() {
        if (this.loadFromIntent) {
            return;
        }
        super.initData();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        setTitle(getString(R.string.video_change_music));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean isLoadMoreEnable(VideoMusicResp videoMusicResp) {
        return true;
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        VideoPlayer videoPlayer = this.player;
        if (videoPlayer != null) {
            videoPlayer.b();
        }
        this.player = null;
        VideoMusicCell.Companion.setPlayingCell(null);
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.IMusicListFragment
    public void onMusicDownload(boolean z, boolean z2, VideoMusic music, boolean z3) {
        Intent intent;
        Intent intent2;
        kotlin.jvm.internal.s.h(music, "music");
        if (z3) {
            us.pinguo.foundation.utils.j0.c(us.pinguo.c360.i18n.R.string.network_error);
            ProgressWheel progressWheel = this.downloadProgressView;
            if (progressWheel != null) {
                progressWheel.setVisibility(8);
            }
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                InspireTask inspireTask = null;
                Integer valueOf = (activity == null || (intent = activity.getIntent()) == null) ? null : Integer.valueOf(intent.getIntExtra("publish_video_type", 0));
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                    inspireTask = (InspireTask) intent2.getParcelableExtra("task");
                }
                us.pinguo.foundation.statistics.h.a.k0("bgm_selected_faild", (valueOf != null && valueOf.intValue() == 0) ? "shot_video" : "library_video", inspireTask == null ? "" : inspireTask.taskId, "feedback");
            }
        } else if (z) {
            this.lastDownloadMusic = music;
            ProgressWheel progressWheel2 = this.downloadProgressView;
            if (progressWheel2 == null) {
                return;
            }
            progressWheel2.setVisibility(0);
        } else if (z2) {
            VideoMusic videoMusic = this.lastDownloadMusic;
            if (videoMusic == null || videoMusic == music) {
                ProgressWheel progressWheel3 = this.downloadProgressView;
                if (progressWheel3 != null) {
                    progressWheel3.setVisibility(8);
                }
                onMusicSelected(music);
            }
        }
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.IMusicListFragment
    public void onMusicSelected(VideoMusic music) {
        kotlin.jvm.internal.s.h(music, "music");
        File downloadedMusic = MusicDownloader.INSTANCE.getDownloadedMusic(music.j());
        Intent intent = new Intent();
        boolean z = false;
        if (downloadedMusic != null && downloadedMusic.exists()) {
            z = true;
        }
        if (z) {
            music.k(downloadedMusic.getAbsolutePath());
        }
        intent.putExtra("music_select", music);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        us.pinguo.foundation.statistics.h.a.X("challenge_bgm_advance_action", music.h(), getReferer(), "selected");
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.IMusicListFragment
    public void onOriMusicSeleced() {
        Intent intent = new Intent();
        intent.putExtra("music_select", "");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        us.pinguo.foundation.statistics.h.a.X("challenge_bgm_advance_action", "original", getReferer(), "selected");
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoPlayer videoPlayer;
        super.onPause();
        VideoPlayer videoPlayer2 = this.player;
        boolean z = false;
        if (videoPlayer2 != null && videoPlayer2.isPlaying()) {
            z = true;
        }
        if (z && (videoPlayer = this.player) != null) {
            videoPlayer.a();
        }
        VideoMusicCell playingCell = VideoMusicCell.Companion.getPlayingCell();
        if (playingCell == null) {
            return;
        }
        playingCell.onPlayStop();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intent intent;
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        this.showOriItem = (activity == null || (intent = activity.getIntent()) == null) ? true : intent.getBooleanExtra(us.pinguo.foundation.constant.a.f10982f, true);
        initFromIntent();
        this.current_page = 1;
        VideoPlayer videoPlayer = new VideoPlayer(getContext());
        this.player = videoPlayer;
        kotlin.jvm.internal.s.e(videoPlayer);
        videoPlayer.Y(new IMediaPlayer.OnCompletionListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.s0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                VideoMusicListFragment.m122onViewCreated$lambda1(VideoMusicListFragment.this, iMediaPlayer);
            }
        });
        VideoPlayer videoPlayer2 = this.player;
        kotlin.jvm.internal.s.e(videoPlayer2);
        videoPlayer2.a0(new IMediaPlayer.OnInfoListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.u0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
                boolean m124onViewCreated$lambda2;
                m124onViewCreated$lambda2 = VideoMusicListFragment.m124onViewCreated$lambda2(VideoMusicListFragment.this, iMediaPlayer, i2, i3);
                return m124onViewCreated$lambda2;
            }
        });
        VideoPlayer videoPlayer3 = this.player;
        kotlin.jvm.internal.s.e(videoPlayer3);
        videoPlayer3.Z(new IMediaPlayer.OnErrorListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.t0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
                boolean m125onViewCreated$lambda3;
                m125onViewCreated$lambda3 = VideoMusicListFragment.m125onViewCreated$lambda3(VideoMusicListFragment.this, iMediaPlayer, i2, i3);
                return m125onViewCreated$lambda3;
            }
        });
        getDefaultToolbar().setBackgroundColor(-328966);
        this.mRecyclerView.setBackgroundColor(-1);
        this.mRecyclerView.addItemDecoration(new us.pinguo.inspire.widget.i(us.pinguo.foundation.t.b.a.a(getContext(), 0.5f), -1710619));
        int a = us.pinguo.foundation.t.b.a.a(getContext(), 24.0f);
        new FrameLayout.LayoutParams(a, a).gravity = 17;
        LayoutInflater from = LayoutInflater.from(getContext());
        int i2 = us.pinguo.inspire.R.id.fl_list_content;
        from.inflate(R.layout.video_music_progress, (ViewGroup) ((FrameLayout) _$_findCachedViewById(i2)), true);
        this.downloadProgressView = (ProgressWheel) ((FrameLayout) _$_findCachedViewById(i2)).findViewById(R.id.video_music_download_progress);
        this.playProgressView = (ProgressWheel) ((FrameLayout) _$_findCachedViewById(i2)).findViewById(R.id.video_music_play_progress);
        ProgressWheel progressWheel = this.downloadProgressView;
        if (progressWheel != null) {
            progressWheel.setVisibility(8);
        }
        ProgressWheel progressWheel2 = this.playProgressView;
        if (progressWheel2 == null) {
            return;
        }
        progressWheel2.setVisibility(8);
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.IMusicListFragment
    public void pause() {
        VideoPlayer videoPlayer = this.player;
        if (videoPlayer == null) {
            return;
        }
        videoPlayer.a();
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.IMusicListFragment
    public void play(VideoMusicCell cell) {
        VideoPlayer videoPlayer;
        kotlin.jvm.internal.s.h(cell, "cell");
        VideoPlayer videoPlayer2 = this.player;
        boolean z = false;
        if (videoPlayer2 != null && videoPlayer2.isPlaying()) {
            z = true;
        }
        if (z && (videoPlayer = this.player) != null) {
            videoPlayer.a();
        }
        VideoPlayer videoPlayer3 = this.player;
        if (videoPlayer3 != null) {
            videoPlayer3.Q(Uri.parse(cell.getData().j()));
        }
        VideoPlayer videoPlayer4 = this.player;
        if (videoPlayer4 != null) {
            videoPlayer4.d();
        }
        us.pinguo.foundation.statistics.h.a.X("challenge_bgm_advance_action", cell.getData().h(), getReferer(), "audition");
    }

    public final void setCurrent_page(int i2) {
        this.current_page = i2;
    }

    public final void setDownloadProgressView(ProgressWheel progressWheel) {
        this.downloadProgressView = progressWheel;
    }

    public final void setLastDownloadMusic(VideoMusic videoMusic) {
        this.lastDownloadMusic = videoMusic;
    }

    public final void setLoadFromIntent(boolean z) {
        this.loadFromIntent = z;
    }

    public final void setPlayProgressView(ProgressWheel progressWheel) {
        this.playProgressView = progressWheel;
    }

    public final void setPlayer(VideoPlayer videoPlayer) {
        this.player = videoPlayer;
    }

    public final void setShowOriItem(boolean z) {
        this.showOriItem = z;
    }

    public final void showPlayProgress() {
        ProgressWheel progressWheel = this.playProgressView;
        if (progressWheel == null) {
            return;
        }
        progressWheel.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.v0
            @Override // java.lang.Runnable
            public final void run() {
                VideoMusicListFragment.m126showPlayProgress$lambda7(VideoMusicListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public HashMap<String, String> addParamForPage(VideoMusicResp videoMusicResp) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PageEvent.TYPE_NAME, String.valueOf(this.current_page + 1));
        hashMap.put("num", String.valueOf(this.COUNT));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b<? extends Object, us.pinguo.widget.common.cell.recycler.c>> appendCells(VideoMusicResp videoMusicResp) {
        List<VideoMusic> items;
        List<VideoMusic> items2;
        ArrayList arrayList = new ArrayList();
        if (videoMusicResp != null && (items2 = videoMusicResp.getItems()) != null) {
            for (VideoMusic videoMusic : items2) {
                arrayList.add(new VideoMusicCell(videoMusic, this));
            }
        }
        if ((videoMusicResp == null || (items = videoMusicResp.getItems()) == null || !(items.isEmpty() ^ true)) ? false : true) {
            this.current_page++;
        } else {
            setLoadMoreEnabled(false);
            this.mAdapter.showNoMoreContent();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b<? extends Object, us.pinguo.widget.common.cell.recycler.c>> createCells(VideoMusicResp videoMusicResp) {
        List<VideoMusic> items;
        ArrayList arrayList = new ArrayList();
        if (this.showOriItem) {
            arrayList.add(new VideoMusicOriCell(null, this));
        }
        if (videoMusicResp != null && (items = videoMusicResp.getItems()) != null) {
            for (VideoMusic videoMusic : items) {
                arrayList.add(new VideoMusicCell(videoMusic, this));
            }
        }
        setLoadMoreEnabled(true);
        return arrayList;
    }
}
