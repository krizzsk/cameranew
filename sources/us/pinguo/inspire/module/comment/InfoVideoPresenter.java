package us.pinguo.inspire.module.comment;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import java.util.Objects;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.IVideoInfo;
import us.pinguo.inspire.module.comment.cell.VideoInfoCell;
import us.pinguo.inspire.module.comment.widget.InfoVideoView;
import us.pinguo.inspire.widget.video.VideoPlayerAndroid;
import us.pinguo.ui.R;
import us.pinguo.ui.widget.video.VideoPlayer;
/* compiled from: InfoVideoPresenter.kt */
/* loaded from: classes9.dex */
public final class InfoVideoPresenter extends us.pinguo.foundation.p.a {
    public static final Companion Companion = new Companion(null);
    private static Boolean isPlayNoWifi;
    private boolean autoPlay = true;
    private BaseInfoCell mCurrentCell;
    private FeedsInfoFragment mInfoFragment;
    private VideoPlayer mPreloadPlayer;
    private VideoPlayer mVideoPlayer;

    /* compiled from: InfoVideoPresenter.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final Boolean isPlayNoWifi() {
            return InfoVideoPresenter.isPlayNoWifi;
        }

        public final void setPlayNoWifi(Boolean bool) {
            InfoVideoPresenter.isPlayNoWifi = bool;
        }
    }

    private final boolean checkNetwork(InfoVideoView infoVideoView, boolean z) {
        FeedsInfoFragment feedsInfoFragment = this.mInfoFragment;
        if (!us.pinguo.util.q.f(feedsInfoFragment == null ? null : feedsInfoFragment.getContext())) {
            us.pinguo.foundation.utils.j0.c(R.string.network_not_available);
            if (infoVideoView != null) {
                infoVideoView.showPlayView();
            }
            return false;
        }
        FeedsInfoFragment feedsInfoFragment2 = this.mInfoFragment;
        if (us.pinguo.util.q.f(feedsInfoFragment2 != null ? feedsInfoFragment2.getContext() : null)) {
            return true;
        }
        Boolean bool = isPlayNoWifi;
        if (bool == null) {
            showAskDialog(this.mCurrentCell);
            if (infoVideoView != null) {
                infoVideoView.showPlayView();
            }
            return false;
        } else if (kotlin.jvm.internal.s.c(bool, Boolean.FALSE)) {
            if (infoVideoView != null) {
                infoVideoView.showPlayView();
            }
            if (z) {
                showAskDialog(this.mCurrentCell);
            }
            return false;
        } else {
            return true;
        }
    }

    private final void play(BaseInfoCell baseInfoCell) {
        BaseInfoCell baseInfoCell2 = this.mCurrentCell;
        if (baseInfoCell2 == null || !(baseInfoCell2 instanceof IVideoInfo)) {
            return;
        }
        Objects.requireNonNull(baseInfoCell, "null cannot be cast to non-null type us.pinguo.inspire.module.comment.cell.IVideoInfo");
        IVideoInfo iVideoInfo = (IVideoInfo) baseInfoCell;
        String videoUrl = iVideoInfo.getVideoUrl();
        if (TextUtils.isEmpty(videoUrl)) {
            return;
        }
        InfoVideoView videoView = iVideoInfo.getVideoView();
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null) {
            VideoPlayer videoPlayer2 = new VideoPlayer(us.pinguo.foundation.e.b());
            this.mVideoPlayer = videoPlayer2;
            kotlin.jvm.internal.s.e(videoPlayer2);
            videoPlayer2.U(this.autoPlay);
        } else if (videoPlayer != null) {
            videoPlayer.f();
        }
        if (videoView != null) {
            videoView.hidePlayVideo();
        }
        if (videoView != null) {
            videoView.showProgressDelay();
        }
        if (videoView != null) {
            videoView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.j1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoVideoPresenter.m154play$lambda0(InfoVideoPresenter.this, view);
                }
            });
        }
        VideoPlayer videoPlayer3 = this.mVideoPlayer;
        if (videoPlayer3 != null) {
            videoPlayer3.Q(Uri.parse(videoUrl));
        }
        VideoPlayer videoPlayer4 = this.mVideoPlayer;
        kotlin.jvm.internal.s.e(videoPlayer4);
        videoPlayer4.V(true);
        VideoPlayer videoPlayer5 = this.mVideoPlayer;
        if (videoPlayer5 != null) {
            videoPlayer5.c(videoView == null ? null : videoView.getVideoView());
        }
        VideoPlayer videoPlayer6 = this.mVideoPlayer;
        if (videoPlayer6 != null) {
            videoPlayer6.a0(videoView);
        }
        VideoPlayer videoPlayer7 = this.mVideoPlayer;
        if (videoPlayer7 != null) {
            videoPlayer7.Z(videoView);
        }
        VideoPlayer videoPlayer8 = this.mVideoPlayer;
        if (videoPlayer8 == null) {
            return;
        }
        videoPlayer8.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: play$lambda-0  reason: not valid java name */
    public static final void m154play$lambda0(InfoVideoPresenter this$0, View view) {
        VideoPlayer videoPlayer;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        VideoPlayer videoPlayer2 = this$0.mVideoPlayer;
        boolean z = false;
        if (videoPlayer2 != null && videoPlayer2.F()) {
            z = true;
        }
        if (!z || (videoPlayer = this$0.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.d();
    }

    private final void recordWork() {
        InspireWork data;
        if (this.mCurrentCell instanceof VideoInfoCell) {
            VideoPlayer videoPlayer = this.mVideoPlayer;
            if ((videoPlayer == null ? 0L : videoPlayer.z()) > 1000) {
                BaseInfoCell baseInfoCell = this.mCurrentCell;
                String str = null;
                if (baseInfoCell != null && (data = baseInfoCell.getData()) != null) {
                    str = data.workId;
                }
                if (str != null) {
                    RecLoader.INSTANCE.recordWorkBrowsed(str);
                }
            }
        }
    }

    private final void showAskDialog(final BaseInfoCell baseInfoCell) {
        FeedsInfoFragment feedsInfoFragment = this.mInfoFragment;
        us.pinguo.foundation.utils.w.i(feedsInfoFragment == null ? null : feedsInfoFragment.getContext(), vStudio.Android.Camera360.R.string.no_wifi_play, vStudio.Android.Camera360.R.string.info_play, us.pinguo.foundation.R.string.cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.module.comment.i1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                InfoVideoPresenter.m155showAskDialog$lambda1(InfoVideoPresenter.this, baseInfoCell, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showAskDialog$lambda-1  reason: not valid java name */
    public static final void m155showAskDialog$lambda1(InfoVideoPresenter this$0, BaseInfoCell baseInfoCell, DialogInterface dialogInterface, int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -2) {
            isPlayNoWifi = Boolean.FALSE;
        } else if (i2 != -1) {
        } else {
            isPlayNoWifi = Boolean.TRUE;
            this$0.play(baseInfoCell);
        }
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        Objects.requireNonNull(bVar, "null cannot be cast to non-null type us.pinguo.inspire.module.comment.FeedsInfoFragment");
        this.mInfoFragment = (FeedsInfoFragment) bVar;
        this.mPreloadPlayer = new VideoPlayerAndroid(Inspire.a());
    }

    public final void checkPause() {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null) {
            return;
        }
        videoPlayer.b();
    }

    @Override // us.pinguo.foundation.p.a
    public void detachView() {
        super.detachView();
        this.mInfoFragment = null;
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.a();
        }
        VideoPlayer videoPlayer2 = this.mVideoPlayer;
        if (videoPlayer2 != null) {
            videoPlayer2.b();
        }
        this.mVideoPlayer = null;
        VideoPlayer videoPlayer3 = this.mPreloadPlayer;
        if (videoPlayer3 != null) {
            videoPlayer3.b();
        }
        this.mPreloadPlayer = null;
    }

    public final BaseInfoCell getMCurrentCell() {
        return this.mCurrentCell;
    }

    public final FeedsInfoFragment getMInfoFragment() {
        return this.mInfoFragment;
    }

    public final VideoPlayer getMPreloadPlayer() {
        return this.mPreloadPlayer;
    }

    public final VideoPlayer getMVideoPlayer() {
        return this.mVideoPlayer;
    }

    public final void onPageSelect(BaseInfoCell baseInfoCell) {
        us.pinguo.inspire.y.a.c mViewHolder;
        InfoVideoView infoVideoView;
        BaseInfoCell baseInfoCell2 = this.mCurrentCell;
        if ((baseInfoCell2 instanceof IVideoInfo) && baseInfoCell2 != null && (mViewHolder = baseInfoCell2.getMViewHolder()) != null && (infoVideoView = (InfoVideoView) mViewHolder.a(vStudio.Android.Camera360.R.id.info_video_view)) != null) {
            infoVideoView.setOnClickListener(null);
        }
        this.mCurrentCell = baseInfoCell;
        if (!(baseInfoCell instanceof IVideoInfo)) {
            VideoPlayer videoPlayer = this.mVideoPlayer;
            if (videoPlayer != null) {
                videoPlayer.f();
            }
            VideoPlayer videoPlayer2 = this.mVideoPlayer;
            if (videoPlayer2 == null) {
                return;
            }
            videoPlayer2.b();
            return;
        }
        if (checkNetwork(((IVideoInfo) baseInfoCell).getVideoView(), false)) {
            play(this.mCurrentCell);
        }
        recordWork();
    }

    public final void onPause() {
        if (this.mCurrentCell instanceof IVideoInfo) {
            recordWork();
            VideoPlayer videoPlayer = this.mVideoPlayer;
            if (videoPlayer != null) {
                videoPlayer.f();
            }
            VideoPlayer videoPlayer2 = this.mVideoPlayer;
            if (videoPlayer2 == null) {
                return;
            }
            videoPlayer2.b();
        }
    }

    public final void onResume() {
        us.pinguo.inspire.y.a.c mViewHolder;
        if (this.mCurrentCell instanceof IVideoInfo) {
            VideoPlayer videoPlayer = this.mVideoPlayer;
            boolean z = false;
            if (videoPlayer != null && !videoPlayer.isPlaying()) {
                z = true;
            }
            if (z) {
                BaseInfoCell baseInfoCell = this.mCurrentCell;
                InfoVideoView infoVideoView = (baseInfoCell == null || (mViewHolder = baseInfoCell.getMViewHolder()) == null) ? null : (InfoVideoView) mViewHolder.a(vStudio.Android.Camera360.R.id.info_video_view);
                if (infoVideoView != null) {
                    infoVideoView.showCover();
                }
                if (infoVideoView != null) {
                    infoVideoView.hidePlayVideo();
                }
                VideoPlayer videoPlayer2 = this.mVideoPlayer;
                if (videoPlayer2 != null) {
                    videoPlayer2.c(infoVideoView != null ? infoVideoView.getVideoView() : null);
                }
                play(this.mCurrentCell);
            }
        }
    }

    public final void onVideoClick(InfoVideoView videoView) {
        InspireWork data;
        InspireWork data2;
        InspireWork data3;
        InspireWork data4;
        kotlin.jvm.internal.s.h(videoView, "videoView");
        VideoPlayer videoPlayer = this.mVideoPlayer;
        boolean z = false;
        String str = null;
        if (videoPlayer != null && videoPlayer.isPlaying()) {
            videoView.showPlayView();
            VideoPlayer videoPlayer2 = this.mVideoPlayer;
            if (videoPlayer2 != null) {
                videoPlayer2.a();
            }
            BaseInfoCell baseInfoCell = this.mCurrentCell;
            kotlin.jvm.internal.s.e(baseInfoCell);
            InspireWork data5 = baseInfoCell.getData();
            if ((data5 == null ? null : Boolean.valueOf(data5.isAd)).booleanValue()) {
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                String element_id = FeedsInfoFragment.Companion.getElement_id();
                BaseInfoCell baseInfoCell2 = this.mCurrentCell;
                if (baseInfoCell2 != null && (data4 = baseInfoCell2.getData()) != null) {
                    str = data4.workId;
                }
                cVar.M(element_id, "pause", "is_ad", str, "click");
                return;
            }
            us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
            String element_id2 = FeedsInfoFragment.Companion.getElement_id();
            BaseInfoCell baseInfoCell3 = this.mCurrentCell;
            if (baseInfoCell3 != null && (data3 = baseInfoCell3.getData()) != null) {
                str = data3.workId;
            }
            cVar2.M(element_id2, "pause", "", str, "click");
        } else if (checkNetwork(videoView, true)) {
            BaseInfoCell baseInfoCell4 = this.mCurrentCell;
            kotlin.jvm.internal.s.e(baseInfoCell4);
            InspireWork data6 = baseInfoCell4.getData();
            if ((data6 == null ? null : Boolean.valueOf(data6.isAd)).booleanValue()) {
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                String element_id3 = FeedsInfoFragment.Companion.getElement_id();
                BaseInfoCell baseInfoCell5 = this.mCurrentCell;
                if (baseInfoCell5 != null && (data2 = baseInfoCell5.getData()) != null) {
                    str = data2.workId;
                }
                cVar3.M(element_id3, "play", "is_ad", str, "click");
            } else {
                us.pinguo.foundation.statistics.c cVar4 = us.pinguo.foundation.statistics.h.a;
                String element_id4 = FeedsInfoFragment.Companion.getElement_id();
                BaseInfoCell baseInfoCell6 = this.mCurrentCell;
                if (baseInfoCell6 != null && (data = baseInfoCell6.getData()) != null) {
                    str = data.workId;
                }
                cVar4.M(element_id4, "play", "", str, "click");
            }
            VideoPlayer videoPlayer3 = this.mVideoPlayer;
            if (videoPlayer3 != null) {
                if (videoPlayer3 != null && videoPlayer3.F()) {
                    z = true;
                }
                if (!z) {
                    videoView.hidePlayVideo();
                    VideoPlayer videoPlayer4 = this.mVideoPlayer;
                    if (videoPlayer4 == null) {
                        return;
                    }
                    videoPlayer4.d();
                    return;
                }
            }
            play(this.mCurrentCell);
        }
    }

    public final void preloadVideo(IVideoInfo nextCell) {
        kotlin.jvm.internal.s.h(nextCell, "nextCell");
        Context a = Inspire.a();
        kotlin.jvm.internal.s.g(a, "getAppContext()");
        if (us.pinguo.util.q.h(a)) {
            String videoUrl = nextCell.getVideoUrl();
            VideoPlayer videoPlayer = this.mPreloadPlayer;
            if (videoPlayer == null) {
                return;
            }
            videoPlayer.Q(Uri.parse(videoUrl));
        }
    }

    public final void setAutoPlayEnabled(boolean z) {
        this.autoPlay = z;
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer == null) {
            return;
        }
        videoPlayer.U(z);
    }

    public final void setMCurrentCell(BaseInfoCell baseInfoCell) {
        this.mCurrentCell = baseInfoCell;
    }

    public final void setMInfoFragment(FeedsInfoFragment feedsInfoFragment) {
        this.mInfoFragment = feedsInfoFragment;
    }

    public final void setMPreloadPlayer(VideoPlayer videoPlayer) {
        this.mPreloadPlayer = videoPlayer;
    }

    public final void setMVideoPlayer(VideoPlayer videoPlayer) {
        this.mVideoPlayer = videoPlayer;
    }
}
