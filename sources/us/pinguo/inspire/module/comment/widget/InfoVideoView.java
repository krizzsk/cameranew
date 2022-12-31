package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.util.w;
import us.pinguo.inspire.widget.videocell.VisibilityListenImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
/* compiled from: InfoVideoView.kt */
/* loaded from: classes9.dex */
public class InfoVideoView extends FrameLayout implements VisibilityListenImageView.a, IMediaPlayer.OnInfoListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnPreparedListener {
    private final long PROGRESS_DELAY_TIME;
    public Map<Integer, View> _$_findViewCache;
    public View contentLayout;
    private PhotoImageView coverImg;
    private FrameLayout coverView;
    private int mWorkHeight;
    private int mWorkWidth;
    private VisibilityListenImageView playVideoIv;
    private final Handler progressHandler;
    private View progressView;
    private final Runnable showProgressRunnalbe;
    private BaseVideoTextureView videoView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoVideoView(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.PROGRESS_DELAY_TIME = 800L;
        this.showProgressRunnalbe = new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                InfoVideoView.m182showProgressRunnalbe$lambda0(InfoVideoView.this);
            }
        };
        this.progressHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public static /* synthetic */ Pair calFullScreenSize$default(InfoVideoView infoVideoView, int i2, int i3, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 4) != 0) {
                i4 = 0;
            }
            return infoVideoView.calFullScreenSize(i2, i3, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calFullScreenSize");
    }

    private final void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_info_layout, this);
        View findViewById = findViewById(R.id.wdvv_video_video_view);
        s.g(findViewById, "findViewById(R.id.wdvv_video_video_view)");
        this.videoView = (BaseVideoTextureView) findViewById;
        View findViewById2 = findViewById(R.id.video_info_cover_layout);
        s.g(findViewById2, "findViewById(R.id.video_info_cover_layout)");
        this.coverView = (FrameLayout) findViewById2;
        VisibilityListenImageView visibilityListenImageView = (VisibilityListenImageView) findViewById(R.id.iv_play_video_view);
        this.playVideoIv = visibilityListenImageView;
        s.e(visibilityListenImageView);
        visibilityListenImageView.a(this);
        View findViewById3 = getCoverView().findViewById(R.id.piv_photo_video_view);
        s.g(findViewById3, "coverView.findViewById<P….id.piv_photo_video_view)");
        this.coverImg = (PhotoImageView) findViewById3;
        FrameLayout video_info_content = (FrameLayout) _$_findCachedViewById(us.pinguo.inspire.R.id.video_info_content);
        s.g(video_info_content, "video_info_content");
        setContentLayout(video_info_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onError$lambda-4  reason: not valid java name */
    public static final void m178onError$lambda4(InfoVideoView this$0) {
        s.h(this$0, "this$0");
        this$0.showPlayView();
        this$0.hideProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onInfo$lambda-1  reason: not valid java name */
    public static final void m179onInfo$lambda1(InfoVideoView this$0) {
        s.h(this$0, "this$0");
        this$0.hidePlayVideo();
        this$0.hideProgress();
        this$0.hideCoverView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onInfo$lambda-2  reason: not valid java name */
    public static final void m180onInfo$lambda2(InfoVideoView this$0) {
        s.h(this$0, "this$0");
        this$0.hideProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupVideoSize$lambda-3  reason: not valid java name */
    public static final void m181setupVideoSize$lambda3(InfoVideoView this$0, FrameLayout.LayoutParams layoutParams) {
        s.h(this$0, "this$0");
        s.h(layoutParams, "$layoutParams");
        this$0.getVideoView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showProgressRunnalbe$lambda-0  reason: not valid java name */
    public static final void m182showProgressRunnalbe$lambda0(InfoVideoView this$0) {
        s.h(this$0, "this$0");
        this$0.showProgress();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    protected final Pair<Integer, Integer> calFullScreenSize(int i2, int i3, int i4) {
        int j2 = us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b());
        us.pinguo.foundation.t.b.a.h(us.pinguo.foundation.e.b());
        if (!w.b()) {
            us.pinguo.foundation.t.b.a.k();
        }
        return new Pair<>(Integer.valueOf(j2), Integer.valueOf((int) (j2 / ((i4 == 90 || i4 == 270) ? i3 / i2 : i2 / i3))));
    }

    public final View getContentLayout() {
        View view = this.contentLayout;
        if (view != null) {
            return view;
        }
        s.z("contentLayout");
        throw null;
    }

    public final PhotoImageView getCoverImg() {
        PhotoImageView photoImageView = this.coverImg;
        if (photoImageView != null) {
            return photoImageView;
        }
        s.z("coverImg");
        throw null;
    }

    public final FrameLayout getCoverView() {
        FrameLayout frameLayout = this.coverView;
        if (frameLayout != null) {
            return frameLayout;
        }
        s.z("coverView");
        throw null;
    }

    public final Drawable getLoadingDrawable() {
        String b = d.f.a.b.e.b("drawalbe://challenge_video_loading", new com.nostra13.universalimageloader.core.assist.c(0, 0));
        Bitmap bitmap = ImageLoader.getInstance().o().get(b);
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.challenge_video_loading);
                ImageLoader.getInstance().o().put(b, bitmap);
            } catch (NullPointerException e2) {
                us.pinguo.common.log.a.f(e2);
            } catch (OutOfMemoryError e3) {
                us.pinguo.common.log.a.f(e3);
            }
        }
        if (bitmap != null) {
            return new us.pinguo.foundation.t.a.e(bitmap);
        }
        return null;
    }

    public final View getProgressView() {
        return this.progressView;
    }

    public final BaseVideoTextureView getVideoView() {
        BaseVideoTextureView baseVideoTextureView = this.videoView;
        if (baseVideoTextureView != null) {
            return baseVideoTextureView;
        }
        s.z("videoView");
        throw null;
    }

    public final void hideCoverView() {
        FrameLayout coverView = getCoverView();
        s.e(coverView);
        coverView.setVisibility(8);
        getCoverView().setBackgroundDrawable(null);
        setBackgroundDrawable(null);
    }

    public final void hidePlayVideo() {
        VisibilityListenImageView visibilityListenImageView = this.playVideoIv;
        s.e(visibilityListenImageView);
        visibilityListenImageView.setVisibility(8);
    }

    public final void hideProgress() {
        View view = this.progressView;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void loadCover(String url, int i2, int i3, final com.nostra13.universalimageloader.core.k.c cVar) {
        s.h(url, "url");
        this.mWorkWidth = i2;
        this.mWorkHeight = i3;
        Pair calFullScreenSize$default = calFullScreenSize$default(this, i2, i3, 0, 4, null);
        int intValue = ((Number) calFullScreenSize$default.component1()).intValue();
        int intValue2 = ((Number) calFullScreenSize$default.component2()).intValue();
        int min = Math.min(i2, intValue);
        int min2 = Math.min(i3, intValue2);
        getCoverImg().setImageDrawable(getLoadingDrawable());
        setBackgroundDrawable(getLoadingDrawable());
        showCover();
        getCoverImg().setSimpleImageLoadingListener(new com.nostra13.universalimageloader.core.k.c() { // from class: us.pinguo.inspire.module.comment.widget.InfoVideoView$loadCover$1
            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                super.onLoadingComplete(str, view, bitmap);
                InfoVideoView.this.setBackgroundDrawable(null);
                com.nostra13.universalimageloader.core.k.c cVar2 = cVar;
                if (cVar2 == null) {
                    return;
                }
                cVar2.onLoadingComplete(str, view, bitmap);
            }
        });
        getCoverImg().setVideoImageUrl(url, min, min2);
        getCoverImg().setSize(intValue, intValue2);
        int i4 = us.pinguo.inspire.R.id.video_info_content;
        ViewGroup.LayoutParams layoutParams = ((FrameLayout) _$_findCachedViewById(i4)).getLayoutParams();
        layoutParams.width = intValue;
        layoutParams.height = intValue2;
        ((FrameLayout) _$_findCachedViewById(i4)).setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = getVideoView().getLayoutParams();
        layoutParams2.width = intValue;
        layoutParams2.height = intValue2;
        getVideoView().setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = getCoverView().getLayoutParams();
        layoutParams3.width = intValue;
        layoutParams3.height = intValue2;
        getCoverView().setLayoutParams(layoutParams3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
        us.pinguo.common.log.a.k(s.q("video error:", Integer.valueOf(i2)), new Object[0]);
        if (!q.f(getContext())) {
            j0.c(us.pinguo.c360.i18n.R.string.network_error);
        }
        post(new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                InfoVideoView.m178onError$lambda4(InfoVideoView.this);
            }
        });
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer mediaPlayer, int i2, int i3) {
        s.h(mediaPlayer, "mediaPlayer");
        if (i2 == 3) {
            us.pinguo.common.log.a.k("video start render.", new Object[0]);
            post(new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.a
                @Override // java.lang.Runnable
                public final void run() {
                    InfoVideoView.m179onInfo$lambda1(InfoVideoView.this);
                }
            });
        } else if (i2 == 10001) {
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            us.pinguo.common.log.a.k("video rotation:" + i3 + " size:" + videoWidth + " x " + videoHeight, new Object[0]);
            if (videoWidth > 0 && videoHeight > 0) {
                setupVideoSize(videoWidth, videoHeight, i3);
            } else if (i3 != 90 && i3 != 270) {
                setupVideoSize(this.mWorkWidth, this.mWorkHeight, i3);
            } else {
                setupVideoSize(this.mWorkHeight, this.mWorkWidth, i3);
            }
        } else if (i2 == 701) {
            this.progressHandler.postDelayed(this.showProgressRunnalbe, this.PROGRESS_DELAY_TIME);
        } else if (i2 == 702) {
            this.progressHandler.removeCallbacks(this.showProgressRunnalbe);
            this.progressHandler.post(new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    InfoVideoView.m180onInfo$lambda2(InfoVideoView.this);
                }
            });
        }
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer mediaPlayer) {
        s.h(mediaPlayer, "mediaPlayer");
    }

    @Override // us.pinguo.inspire.widget.videocell.VisibilityListenImageView.a
    public void onVisibilityChange(int i2) {
    }

    public final void setContentLayout(View view) {
        s.h(view, "<set-?>");
        this.contentLayout = view;
    }

    public final void setProgressView(View view) {
        this.progressView = view;
    }

    public final void setVideoProgressView(View progressView) {
        s.h(progressView, "progressView");
        this.progressView = progressView;
        getVideoView().setProgressView(progressView);
    }

    public final void setupVideoSize(int i2, int i3, int i4) {
        Pair<Integer, Integer> calFullScreenSize = calFullScreenSize(i2, i3, i4);
        int intValue = calFullScreenSize.component1().intValue();
        int intValue2 = calFullScreenSize.component2().intValue();
        ViewGroup.LayoutParams layoutParams = getVideoView().getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        us.pinguo.common.log.a.k("setupVideoSize rotation:" + i4 + " size:" + i2 + " x " + i3, new Object[0]);
        if (i4 != 90 && i4 != 270) {
            layoutParams2.width = intValue;
            layoutParams2.height = intValue2;
        } else {
            layoutParams2.width = intValue2;
            layoutParams2.height = intValue;
        }
        if (i4 != 0) {
            layoutParams2.gravity = 17;
            getVideoView().setPivotX(layoutParams2.width / 2.0f);
            getVideoView().setPivotY(layoutParams2.height / 2.0f);
        }
        getVideoView().setRotation(i4);
        getVideoView().post(new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                InfoVideoView.m181setupVideoSize$lambda3(InfoVideoView.this, layoutParams2);
            }
        });
    }

    public final void showCover() {
        FrameLayout coverView = getCoverView();
        s.e(coverView);
        coverView.setVisibility(0);
        VisibilityListenImageView visibilityListenImageView = this.playVideoIv;
        s.e(visibilityListenImageView);
        visibilityListenImageView.setVisibility(8);
    }

    public final void showPlayView() {
        VisibilityListenImageView visibilityListenImageView = this.playVideoIv;
        s.e(visibilityListenImageView);
        visibilityListenImageView.setVisibility(0);
    }

    public final void showProgress() {
        View view = this.progressView;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.progressView;
        Drawable background = view2 == null ? null : view2.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) background).start();
        hidePlayVideo();
    }

    public final void showProgressDelay() {
        hideProgress();
        this.progressHandler.postDelayed(this.showProgressRunnalbe, this.PROGRESS_DELAY_TIME);
    }

    public final void showVideo() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.PROGRESS_DELAY_TIME = 800L;
        this.showProgressRunnalbe = new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                InfoVideoView.m182showProgressRunnalbe$lambda0(InfoVideoView.this);
            }
        };
        this.progressHandler = new Handler(Looper.getMainLooper());
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoVideoView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.PROGRESS_DELAY_TIME = 800L;
        this.showProgressRunnalbe = new Runnable() { // from class: us.pinguo.inspire.module.comment.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                InfoVideoView.m182showProgressRunnalbe$lambda0(InfoVideoView.this);
            }
        };
        this.progressHandler = new Handler(Looper.getMainLooper());
        init();
    }
}
