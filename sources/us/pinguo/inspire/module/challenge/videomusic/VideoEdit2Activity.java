package us.pinguo.inspire.module.challenge.videomusic;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.work.WorkRequest;
import com.hw.videoprocessor.VideoProcessor;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.rockerhieu.emoji.KeyboardFrameLayout;
import com.rockerhieu.emoji.KeyboardLayout;
import com.rockerhieu.emoji.model.Emoticon;
import com.tencent.connect.share.QzonePublish;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import rx.functions.Action1;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.publish.vo.LocationInfo;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.module.publish.vo.SelectLocResp;
import us.pinguo.inspire.util.InspireLocationManager;
import us.pinguo.inspire.widget.chat.ChatBottomLayout;
import us.pinguo.svideo.bean.VideoInfo;
import us.pinguo.ui.R;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.snack.SnackTop;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.VideoPlayer;
import us.pinguo.ui.widget.video.c;
import us.pinguo.widget.discreteseekbar.DiscreteSeekBar;
/* loaded from: classes9.dex */
public class VideoEdit2Activity extends InspireBaseActivity implements View.OnClickListener, DiscreteSeekBar.g, com.hw.videoprocessor.g.j {
    private static final int HIDE_SNACK_BAR_AND_FINISH = 1;
    private static final int I_FRAME_INTERVAL = 1;
    private static final int MAX_DURATION = 30000;
    public static final int MAX_SCALED_BITRATE = 2000000;
    public static final int MAX_SCALED_FRAMERATE = 15;
    private static final int MAX_SCALED_WAIT_TIME = 80000;
    private static final int MAX_VIDEO_SIZE = 2000;
    private static final int MIN_DURATION = 10000;
    public static final int MIN_SCALED_SIZE = 640;
    private static final int REQUEST_LOGIN = 21;
    private static final int REQUEST_MUSIC = 213;
    private static final String TEST_PATH = "/mnt/sdcard/DCIM/out.mp4";
    public static String sTaskId;
    private boolean DEV_MODE;
    private VideoEditAnim mAnim;
    private VideoEditChatBottom mChatBottomLayout;
    private VideoContentTextView mContentTxt;
    private View mCoverView;
    private int mCurrentEffects;
    private boolean mDestroyed;
    private SparseArray<String> mEffectsVideoMap;
    private boolean mEnableEffects;
    private InspireTask mInspireTask;
    private VideoInfo mIntentVideoInfo;
    private boolean mIsRestoring;
    private boolean mIsResume;
    private ProgressWheel mLoadingProgress;
    private LocationInfo mLocationInfo;
    private View mMusicAnim;
    private View mMusicBtn;
    private View mMusicLock;
    private us.pinguo.foundation.i mMusicPlayer;
    private DiscreteSeekBar mMusicVolumnSeekBar;
    private DiscreteSeekBar mOriVolumnSeekBar;
    private String mProcessedVideoPath;
    private volatile boolean mProcessingVideo;
    private VideoMusic mRecordBgMusic;
    private View mRoot;
    private volatile Semaphore mScaleSemaphore;
    private volatile String mScaleVideoPath;
    private ViewGroup mSelectEffectLayout;
    private String mSelectedMusicId;
    private String mSelectedMusicPath;
    private TextView mTitleTxt;
    private String mVideoPath;
    private VideoPlayer mVideoPlayer;
    private volatile com.hw.videoprocessor.g.h mVideoProgress;
    private AlertDialog mVideoProgressDialog;
    protected BaseVideoTextureView mVideoTextureView;
    private int mVideoType;
    private boolean mVolumeAdjustedByUser;
    protected int videoHeight;
    protected int videoWidth;
    private SnackTop mSnackTop = null;
    private Handler mHandler = new Handler() { // from class: us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1 || VideoEdit2Activity.this.mDestroyed) {
                return;
            }
            if (VideoEdit2Activity.this.mSnackTop != null && VideoEdit2Activity.this.mSnackTop.g()) {
                VideoEdit2Activity.this.mSnackTop.d();
                VideoEdit2Activity.this.mSnackTop = null;
            }
            VideoEdit2Activity.this.finish();
            VideoEdit2Activity.this.overridePendingTransition(0, R.anim.slide_right_to_left_out);
        }
    };
    private boolean mNoPermission = false;
    private int mOriVolume = 100;
    private int mMusicVolume = 50;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity$3  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass3 implements us.pinguo.librouter.b.c.g {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(String str, String str2, SelectLocResp selectLocResp) {
            if (selectLocResp == null || us.pinguo.foundation.utils.k.a(selectLocResp.list)) {
                return;
            }
            VideoEdit2Activity.this.mLocationInfo = new LocationInfo();
            VideoEdit2Activity.this.mLocationInfo.lon = String.valueOf(str);
            VideoEdit2Activity.this.mLocationInfo.lat = String.valueOf(str2);
        }

        @Override // us.pinguo.librouter.b.c.g
        public void locationError(String str) {
        }

        @Override // us.pinguo.librouter.b.c.g
        public void locationReceived(us.pinguo.librouter.b.c.f fVar) {
            final String valueOf = String.valueOf(fVar.c());
            final String valueOf2 = String.valueOf(fVar.d());
            VideoEdit2Activity.this.addSubscription(InspireLocationManager.getInstance().a(valueOf, valueOf2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.challenge.videomusic.f
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    VideoEdit2Activity.AnonymousClass3.this.b(valueOf2, valueOf, (SelectLocResp) obj);
                }
            }, e.a));
            us.pinguo.librouter.b.b.b().getInterface().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class CircleColorDrawable extends Drawable {
        private Paint mPaint;

        public CircleColorDrawable(int i2) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            setColor(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), bounds.width() / 2, this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            this.mPaint.setAlpha(i2);
        }

        public CircleColorDrawable setColor(int i2) {
            this.mPaint.setColor(i2);
            return this;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    public VideoEdit2Activity() {
        boolean z = us.pinguo.foundation.d.f10985d;
        this.DEV_MODE = false;
        this.mEffectsVideoMap = new SparseArray<>();
        this.mEnableEffects = true;
        this.mCurrentEffects = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void B0(ViewGroup viewGroup, View view, View view2) {
        List<VideoMusic> list;
        if (view2 == viewGroup) {
            String str = this.mVideoType == 0 ? "shot_video" : "library_video";
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            InspireTask inspireTask = this.mInspireTask;
            cVar.k("challenge_submit_preview_action", "original_btn", str, inspireTask != null ? inspireTask.taskId : "", "click");
            if (!this.mEnableEffects) {
                showSnackBar(getString(vStudio.Android.Camera360.R.string.video_edit_not_support), false, false);
                return;
            }
            this.mProcessedVideoPath = null;
            playVideo(this.mVideoPath);
            setEffectSelect(this.mSelectEffectLayout, false);
            setEffectSelect((ViewGroup) view2, true);
        } else if (view2 == this.mMusicBtn) {
            InspireTask inspireTask2 = this.mInspireTask;
            if ((inspireTask2.bgMusicType == 3 && (list = inspireTask2.fixedMusic) != null && list.size() <= 1) || this.mInspireTask.bgMusicType == 2) {
                us.pinguo.foundation.utils.j0.c(vStudio.Android.Camera360.R.string.no_replace_music);
                return;
            }
            Intent intent = new Intent(this, VideoMusicListActivity.class);
            intent.putExtra("publish_video_type", this.mVideoType);
            intent.putExtra(us.pinguo.foundation.constant.a.f10982f, this.mRecordBgMusic == null);
            intent.putExtra(us.pinguo.foundation.constant.a.f10983g, "challenge_submit_preview_page");
            InspireTask inspireTask3 = this.mInspireTask;
            if (inspireTask3 != null) {
                intent.putExtra("task", inspireTask3);
            }
            startActivityForResult(intent, REQUEST_MUSIC);
            String str2 = this.mVideoType == 0 ? "shot_video" : "library_video";
            us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
            InspireTask inspireTask4 = this.mInspireTask;
            cVar2.k("challenge_submit_preview_action", "bgm_adv_btn", str2, inspireTask4 != null ? inspireTask4.taskId : "", "click");
        } else if (view2 == view) {
            if (this.mAnim.getVolumnLayout() != null && this.mAnim.getVolumnLayout().getVisibility() == 0) {
                this.mAnim.hideVolumnLayout();
            } else if (this.mAnim.getVolumnLayout() == null) {
                this.mAnim.showVolumnLayout(this.mRecordBgMusic == null, !TextUtils.isEmpty(this.mSelectedMusicPath));
                View volumnLayout = this.mAnim.getVolumnLayout();
                this.mMusicVolumnSeekBar = (DiscreteSeekBar) volumnLayout.findViewById(vStudio.Android.Camera360.R.id.video_deit_volumn_music);
                this.mOriVolumnSeekBar = (DiscreteSeekBar) volumnLayout.findViewById(vStudio.Android.Camera360.R.id.video_deit_volumn_ori);
                this.mMusicVolumnSeekBar.setProgress(this.mMusicVolume);
                this.mOriVolumnSeekBar.setProgress(this.mOriVolume);
                this.mOriVolumnSeekBar.setOnProgressChangeListener(this);
                this.mMusicVolumnSeekBar.setOnProgressChangeListener(this);
            } else {
                this.mMusicVolumnSeekBar.setProgress(this.mMusicVolume);
                this.mOriVolumnSeekBar.setProgress(this.mOriVolume);
                this.mAnim.showVolumnLayout(this.mRecordBgMusic == null, !TextUtils.isEmpty(this.mSelectedMusicPath));
            }
            String str3 = this.mVideoType == 0 ? "shot_video" : "library_video";
            us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
            InspireTask inspireTask5 = this.mInspireTask;
            cVar3.k("challenge_submit_preview_action", "vol_control_btn", str3, inspireTask5 != null ? inspireTask5.taskId : "", "click");
        } else {
            onClickEffects(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void D0() {
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.i
            @Override // java.lang.Runnable
            public final void run() {
                VideoEdit2Activity.this.J0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void F0() {
        this.mVideoPlayer.d();
        us.pinguo.foundation.i iVar = this.mMusicPlayer;
        if (iVar == null || !iVar.b()) {
            return;
        }
        this.mMusicPlayer.j();
        this.mMusicPlayer.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ boolean H0(boolean z, IMediaPlayer iMediaPlayer, int i2, int i3) {
        if (i2 == 3 && z) {
            this.mVideoPlayer.a();
            this.mVideoPlayer.a0(null);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0() {
        ProgressWheel progressWheel = this.mLoadingProgress;
        if (progressWheel != null) {
            progressWheel.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0() {
        showSnackBar(vStudio.Android.Camera360.R.string.video_process_error, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0 */
    public /* synthetic */ void N0(View view) {
        setEffectSelect(this.mSelectEffectLayout, false);
        setEffectSelect((ViewGroup) view, true);
        this.mVideoProgressDialog.dismiss();
        playVideo(this.mProcessedVideoPath);
        String str = this.mSelectedMusicPath;
        if (str != null) {
            playMusic(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0140 A[Catch: all -> 0x0259, Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:3:0x000a, B:5:0x001d, B:7:0x0022, B:11:0x0036, B:13:0x0082, B:17:0x0089, B:21:0x0098, B:71:0x0211, B:20:0x0095, B:12:0x0062, B:22:0x00a1, B:24:0x00aa, B:26:0x00d5, B:28:0x0114, B:30:0x011a, B:35:0x012b, B:46:0x0140, B:48:0x0154, B:52:0x015b, B:56:0x016a, B:55:0x0167, B:47:0x014a, B:42:0x0139, B:43:0x013c, B:41:0x0135, B:27:0x00f8, B:57:0x0171, B:60:0x017e, B:62:0x01f2, B:66:0x01fb, B:70:0x020c, B:69:0x0208, B:61:0x01e4, B:6:0x0020), top: B:90:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014a A[Catch: all -> 0x0259, Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:3:0x000a, B:5:0x001d, B:7:0x0022, B:11:0x0036, B:13:0x0082, B:17:0x0089, B:21:0x0098, B:71:0x0211, B:20:0x0095, B:12:0x0062, B:22:0x00a1, B:24:0x00aa, B:26:0x00d5, B:28:0x0114, B:30:0x011a, B:35:0x012b, B:46:0x0140, B:48:0x0154, B:52:0x015b, B:56:0x016a, B:55:0x0167, B:47:0x014a, B:42:0x0139, B:43:0x013c, B:41:0x0135, B:27:0x00f8, B:57:0x0171, B:60:0x017e, B:62:0x01f2, B:66:0x01fb, B:70:0x020c, B:69:0x0208, B:61:0x01e4, B:6:0x0020), top: B:90:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0167 A[Catch: all -> 0x0259, Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:3:0x000a, B:5:0x001d, B:7:0x0022, B:11:0x0036, B:13:0x0082, B:17:0x0089, B:21:0x0098, B:71:0x0211, B:20:0x0095, B:12:0x0062, B:22:0x00a1, B:24:0x00aa, B:26:0x00d5, B:28:0x0114, B:30:0x011a, B:35:0x012b, B:46:0x0140, B:48:0x0154, B:52:0x015b, B:56:0x016a, B:55:0x0167, B:47:0x014a, B:42:0x0139, B:43:0x013c, B:41:0x0135, B:27:0x00f8, B:57:0x0171, B:60:0x017e, B:62:0x01f2, B:66:0x01fb, B:70:0x020c, B:69:0x0208, B:61:0x01e4, B:6:0x0020), top: B:90:0x000a, outer: #1 }] */
    /* renamed from: O0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void P0(final android.view.View r23, java.io.File r24) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity.P0(android.view.View, java.io.File):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0() {
        b1(TEST_PATH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0() {
        ProgressWheel progressWheel = this.mLoadingProgress;
        if (progressWheel != null) {
            progressWheel.setVisibility(8);
        }
        this.mVideoTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                VideoEdit2Activity.this.hideCover(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0 */
    public /* synthetic */ void W0(IMediaPlayer iMediaPlayer) {
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.g0
            @Override // java.lang.Runnable
            public final void run() {
                VideoEdit2Activity.this.U0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public /* synthetic */ void Y0(boolean z, String str, String str2) {
        if (!z) {
            str = str2;
        }
        b1(str);
        setCoverAndStartRotation(this.mRecordBgMusic.b());
        playMusic(this.mRecordBgMusic.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0 */
    public /* synthetic */ void a1(final String str) {
        final String genOutputPath = genOutputPath();
        final boolean z = false;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.hw.videoprocessor.g.b.l(str, genOutputPath);
            long currentTimeMillis2 = System.currentTimeMillis();
            us.pinguo.common.log.a.s("去掉视频音轨耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
            new File(str).delete();
            this.mSelectedMusicPath = this.mRecordBgMusic.c();
            this.mSelectedMusicId = this.mRecordBgMusic.g();
            z = true;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.o
            @Override // java.lang.Runnable
            public final void run() {
                VideoEdit2Activity.this.Y0(z, genOutputPath, str);
            }
        });
    }

    private void checkAnonymousPublish() {
        if (!us.pinguo.user.s0.getInstance().e() && !CommentLoader.isLoginRequired()) {
            us.pinguo.foundation.utils.w.i(this, vStudio.Android.Camera360.R.string.anonymous_publish, R.string.ok, us.pinguo.foundation.R.string.cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.z
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VideoEdit2Activity.this.r0(dialogInterface, i2);
                }
            });
        } else {
            processAndPublish();
        }
    }

    private boolean checkDefaultEffect(String str) {
        long parseLong;
        InspireTask inspireTask;
        int i2;
        VideoInfo videoInfo = this.mIntentVideoInfo;
        if (videoInfo != null) {
            parseLong = videoInfo.getDuration();
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        }
        if (parseLong < 10000 || parseLong > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS || (inspireTask = this.mInspireTask) == null || (i2 = inspireTask.specialEffect) <= 0) {
            return false;
        }
        View view = null;
        if (i2 == 2) {
            view = findViewById(vStudio.Android.Camera360.R.id.video_edit_increase);
        } else if (i2 == 3) {
            view = findViewById(vStudio.Android.Camera360.R.id.video_edit_decrease);
        } else if (i2 == 4) {
            view = findViewById(vStudio.Android.Camera360.R.id.video_edit_reverse);
        }
        if (view != null) {
            view.performClick();
        }
        return true;
    }

    private void checkEnableEffects(String str) {
        long parseLong;
        VideoInfo videoInfo = this.mIntentVideoInfo;
        if (videoInfo != null) {
            parseLong = videoInfo.getDuration();
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        }
        this.mEnableEffects = parseLong >= 10000 && parseLong <= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    }

    private boolean checkIsLogin() {
        if (us.pinguo.user.s0.getInstance().e() || !CommentLoader.isLoginRequired()) {
            return true;
        }
        us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
        us.pinguo.user.s0.getInstance().a(this, 21, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
        return false;
    }

    private void checkPreScaleVideo(final String str) {
        if (supportEdit() && TextUtils.isEmpty(this.mScaleVideoPath) && VideoEditUtil.checkScaleVideo(str, 1.0f)) {
            new Thread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.h0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.t0(str);
                }
            }).start();
        }
    }

    private boolean checkVideoBad(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            us.pinguo.common.log.a.f(e);
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            throw th;
        }
        if (Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) <= 0) {
            mediaMetadataRetriever.release();
            return true;
        }
        mediaMetadataRetriever.release();
        mediaMetadataRetriever.release();
        return false;
    }

    private boolean checkVideoBadOrTooLarge(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        int parseInt;
        int parseInt2;
        if (TextUtils.isEmpty(str)) {
            showSnackBar(getString(vStudio.Android.Camera360.R.string.video_edit_bad_video), true, true);
            return true;
        } else if (!str.toLowerCase().endsWith(".mp4")) {
            showSnackBar(getString(vStudio.Android.Camera360.R.string.video_format_not_support), true, true);
            return true;
        } else {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
            if (parseInt <= 2000 && parseInt2 <= 2000) {
                if (Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) > 0) {
                    mediaMetadataRetriever.release();
                    return false;
                }
                showSnackBar(getString(vStudio.Android.Camera360.R.string.video_edit_bad_video), true, true);
                return true;
            }
            showSnackBar(getString(vStudio.Android.Camera360.R.string.video_edit_large_video), true, true);
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str2 = this.mVideoType == 0 ? "shot_video" : "library_video";
            InspireTask inspireTask = this.mInspireTask;
            cVar.k0("oversize", str2, inspireTask == null ? "" : inspireTask.taskId, "feedback");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1 */
    public /* synthetic */ void e1(int i2, int i3) {
        onProgress(i2 / i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1() {
        if (!this.mDestroyed) {
            this.mVideoProgressDialog.dismiss();
        }
        publish(this.mProcessedVideoPath, false);
    }

    private String genOutputPath() {
        try {
            Class<?> cls = Class.forName("us.pinguo.camera2020.view.IVideoPathGeneratorImpl");
            return (String) cls.getDeclaredMethod("generate", new Class[0]).invoke(cls.newInstance(), new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera");
            file.mkdir();
            return new File(file, "C360VID_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Long.valueOf(System.currentTimeMillis())) + ".mp4").getAbsolutePath();
        }
    }

    private VideoInfo genVideoInfo(String str) {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(str);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        videoInfo.setDuration(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
        videoInfo.setVideoWidth(Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)));
        videoInfo.setVideoHeight(Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)));
        return videoInfo;
    }

    private CharSequence getEmojiText(String str) {
        return us.pinguo.inspire.widget.j.b.l(str, 14);
    }

    private void getIntentExtra() {
        List<VideoMusic> list;
        Intent intent = getIntent();
        this.mVideoType = intent.getIntExtra("publish_video_type", 0);
        InspireTask inspireTask = (InspireTask) intent.getParcelableExtra("task");
        this.mInspireTask = inspireTask;
        if (inspireTask != null && !TextUtils.isEmpty(inspireTask.taskName)) {
            this.mTitleTxt.setText(this.mInspireTask.taskName);
        }
        this.mRecordBgMusic = (VideoMusic) intent.getParcelableExtra(us.pinguo.foundation.constant.a.f10981e);
        InspireTask inspireTask2 = this.mInspireTask;
        if ((inspireTask2.bgMusicType == 3 && (list = inspireTask2.fixedMusic) != null && list.size() <= 1) || this.mInspireTask.bgMusicType == 2) {
            this.mMusicLock.setVisibility(0);
        }
        InspireTask inspireTask3 = this.mInspireTask;
        if (inspireTask3 != null && inspireTask3.bgMusicType == 2) {
            this.mMusicAnim.setVisibility(8);
        } else {
            VideoMusic videoMusic = this.mRecordBgMusic;
            setCoverAndStartRotation(videoMusic == null ? null : videoMusic.b());
        }
        if (this.mRecordBgMusic != null) {
            this.mOriVolume = 30;
            this.mMusicVolume = 70;
        }
    }

    public static Intent getStartIntent(Activity activity, String str, Parcelable parcelable, int i2) {
        Intent intent = new Intent();
        intent.setClassName(activity, "us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity");
        if (parcelable != null) {
            intent.putExtra("task", parcelable);
        }
        if (TextUtils.isEmpty(str)) {
            intent.putExtra("save_video", true);
        } else {
            intent.putExtra("save_video", false);
            intent.putExtra("save_video_path", str);
        }
        intent.putExtra("publish_video_type", i2);
        return intent;
    }

    private int getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            mediaMetadataRetriever.release();
            return parseInt;
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            us.pinguo.common.log.a.f(e);
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            throw th;
        }
    }

    private void hideChatBottom() {
        this.mChatBottomLayout.hideSoftInput();
        setContentText(this.mChatBottomLayout.getEditText().getText());
        this.mChatBottomLayout.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.j
            @Override // java.lang.Runnable
            public final void run() {
                VideoEdit2Activity.this.v0();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCover(boolean z) {
        if (this.mCoverView.getVisibility() == 0) {
            this.mCoverView.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.y
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.x0();
                }
            }, z ? 100L : 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1() {
        this.mVideoProgressDialog.dismiss();
        showSnackBar(vStudio.Android.Camera360.R.string.video_process_error, false, true);
    }

    private void initChatBottom() {
        this.mChatBottomLayout = (VideoEditChatBottom) findViewById(vStudio.Android.Camera360.R.id.video_edit_chat_layout);
        KeyboardFrameLayout keyboardFrameLayout = (KeyboardFrameLayout) findViewById(vStudio.Android.Camera360.R.id.video_edit_chat_keyboard_layout);
        keyboardFrameLayout.setOnkbdStateListener(this.mChatBottomLayout);
        keyboardFrameLayout.setOnDispatchTouchListener(new KeyboardLayout.a() { // from class: us.pinguo.inspire.module.challenge.videomusic.r
            @Override // com.rockerhieu.emoji.KeyboardLayout.a
            public final void onDispatchTouchEvent(MotionEvent motionEvent) {
                VideoEdit2Activity.this.z0(motionEvent);
            }
        });
    }

    private void initEffectsBtns() {
        View findViewById = findViewById(vStudio.Android.Camera360.R.id.video_edit_effect_layout);
        this.mMusicAnim = findViewById(vStudio.Android.Camera360.R.id.video_edit_music_anim);
        if (!supportEdit()) {
            this.mMusicAnim.setVisibility(8);
            findViewById.setVisibility(8);
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) findViewById(vStudio.Android.Camera360.R.id.video_edit_revert);
        this.mMusicBtn = findViewById(vStudio.Android.Camera360.R.id.video_edit_music);
        final View findViewById2 = findViewById(vStudio.Android.Camera360.R.id.video_edit_volumn);
        setEffectSelect(viewGroup, true);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoEdit2Activity.this.B0(viewGroup, findViewById2, view);
            }
        };
        ((ViewGroup) findViewById(vStudio.Android.Camera360.R.id.video_edit_increase)).setOnClickListener(onClickListener);
        ((ViewGroup) findViewById(vStudio.Android.Camera360.R.id.video_edit_decrease)).setOnClickListener(onClickListener);
        ((ViewGroup) findViewById(vStudio.Android.Camera360.R.id.video_edit_reverse)).setOnClickListener(onClickListener);
        viewGroup.setOnClickListener(onClickListener);
        this.mMusicBtn.setOnClickListener(onClickListener);
        findViewById2.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initVideo */
    public void c1(String str) {
        if (checkVideoBadOrTooLarge(str)) {
            return;
        }
        checkPreScaleVideo(str);
        checkEnableEffects(str);
        setupVideoSize(str);
        final boolean checkDefaultEffect = checkDefaultEffect(str);
        this.mVideoPath = str;
        Uri fromFile = Uri.fromFile(new File(str));
        VideoPlayer videoPlayer = new VideoPlayer(getApplicationContext());
        this.mVideoPlayer = videoPlayer;
        videoPlayer.c0(new c.InterfaceC0457c() { // from class: us.pinguo.inspire.module.challenge.videomusic.s
            @Override // us.pinguo.ui.widget.video.c.InterfaceC0457c
            public final void onPrepared() {
                VideoEdit2Activity.this.D0();
            }
        });
        this.mVideoPlayer.X(new c.b() { // from class: us.pinguo.inspire.module.challenge.videomusic.q
            @Override // us.pinguo.ui.widget.video.c.b
            public final void onComplete() {
                VideoEdit2Activity.this.F0();
            }
        });
        this.mVideoPlayer.a0(new IMediaPlayer.OnInfoListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.n
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
                return VideoEdit2Activity.this.H0(checkDefaultEffect, iMediaPlayer, i2, i3);
            }
        });
        this.mVideoPlayer.Q(fromFile);
        this.mVideoPlayer.c(this.mVideoTextureView);
        this.mVideoPlayer.V(false);
        this.mVideoPlayer.e0(this.mOriVolume / 100.0f);
        if (this.mIsResume) {
            this.mVideoPlayer.d();
        }
    }

    private void initViews() {
        this.mAnim = new VideoEditAnim(this);
        this.mRoot = findViewById(16908290).getRootView();
        this.mLoadingProgress = (ProgressWheel) findViewById(vStudio.Android.Camera360.R.id.video_loading_progress);
        this.mTitleTxt = (TextView) findViewById(vStudio.Android.Camera360.R.id.video_edit_title);
        this.mVideoTextureView = (BaseVideoTextureView) findViewById(vStudio.Android.Camera360.R.id.video_publish_video);
        this.mContentTxt = (VideoContentTextView) findViewById(vStudio.Android.Camera360.R.id.video_edit_content);
        this.mCoverView = findViewById(vStudio.Android.Camera360.R.id.video_edit_cover);
        this.mMusicLock = findViewById(vStudio.Android.Camera360.R.id.video_edit_music_lock);
        findViewById(vStudio.Android.Camera360.R.id.video_edit_back).setOnClickListener(this);
        findViewById(vStudio.Android.Camera360.R.id.video_edit_participate).setOnClickListener(this);
        findViewById(vStudio.Android.Camera360.R.id.video_edit_content).setOnClickListener(this);
        if (us.pinguo.inspire.util.w.b()) {
            int k2 = us.pinguo.foundation.t.b.a.k();
            View findViewById = findViewById(vStudio.Android.Camera360.R.id.video_edit_music_anim);
            View findViewById2 = findViewById(vStudio.Android.Camera360.R.id.video_edit_title_layout);
            View findViewById3 = findViewById(vStudio.Android.Camera360.R.id.video_edit_effect_layout);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) findViewById3.getLayoutParams();
            marginLayoutParams.topMargin += k2;
            marginLayoutParams2.topMargin += k2;
            marginLayoutParams3.topMargin += k2;
        }
        this.mLoadingProgress.setVisibility(0);
        initEffectsBtns();
        initChatBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(String str, String str2, final us.pinguo.inspire.util.m mVar) {
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.mSelectedMusicPath != null) {
                    if (this.mRecordBgMusic != null) {
                        File f2 = com.hw.videoprocessor.e.f(getApplicationContext());
                        File file = new File(f2, System.currentTimeMillis() + ".mp4");
                        com.hw.videoprocessor.g.b.m(str, this.mSelectedMusicPath, file.getAbsolutePath(), true);
                        VideoProcessor.a(getApplicationContext(), file.getAbsolutePath(), str2, this.mMusicVolume, 1.0f, 1.0f);
                    } else {
                        VideoProcessor.b(getApplicationContext(), str, this.mSelectedMusicPath, str2, null, null, this.mOriVolume, this.mMusicVolume, 1.0f, 1.0f);
                    }
                } else {
                    VideoProcessor.a(getApplicationContext(), str, str2, this.mOriVolume, 1.0f, 1.0f);
                }
                runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        us.pinguo.inspire.util.m.this.a();
                    }
                });
                long currentTimeMillis2 = System.currentTimeMillis();
                us.pinguo.common.log.a.s("音频合成耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
                this.mProcessedVideoPath = str2;
                SystemClock.sleep(300L);
                runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoEdit2Activity.this.h1();
                    }
                });
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                String str3 = this.mVideoType == 0 ? "shot_video" : "library_video";
                InspireTask inspireTask = this.mInspireTask;
                cVar.k0("apply_effect_type_faild", str3, inspireTask == null ? "" : inspireTask.taskId, "feedback");
                runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoEdit2Activity.this.j1();
                    }
                });
            }
        } finally {
            this.mProcessingVideo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1(boolean z, String str) {
        if (this.mInspireTask != null) {
            Intent intent = new Intent(this, TaskDetailActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("task_id", this.mInspireTask.taskId);
            intent.putExtra("key_from_page", "发布");
            startActivity(intent);
            Intent intent2 = new Intent();
            if (str == null) {
                str = "";
            }
            intent2.putExtra("client_id", str);
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void p1() {
        this.mChatBottomLayout.getEditText().requestFocus();
        this.mChatBottomLayout.showSoftInput();
    }

    private void onClickEffects(final View view) {
        String str = this.mEffectsVideoMap.get(view.getId());
        if (str != null && new File(str).exists()) {
            setEffectSelect(this.mSelectEffectLayout, false);
            setEffectSelect((ViewGroup) view, true);
            this.mProcessedVideoPath = str;
            playVideo(str);
            String str2 = this.mSelectedMusicPath;
            if (str2 != null) {
                playMusic(str2);
            }
        } else if (!this.mEnableEffects) {
            showSnackBar(getString(vStudio.Android.Camera360.R.string.video_edit_not_support), false, false);
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str3 = this.mVideoType == 0 ? "shot_video" : "library_video";
            InspireTask inspireTask = this.mInspireTask;
            cVar.k0("video_time_misfit", str3, inspireTask == null ? "" : inspireTask.taskId, "feedback");
        } else {
            if (this.mScaleVideoPath != null && this.mVideoProgress != null) {
                this.mVideoProgress.b(null);
                this.mVideoProgress = new com.hw.videoprocessor.g.h(new float[]{0.0f, 1.0f}, this);
            } else if (this.mVideoProgress == null) {
                this.mVideoProgress = new com.hw.videoprocessor.g.h(new float[]{0.0f, 1.0f}, this);
            }
            File cacheDir = getCacheDir();
            final File file = new File(cacheDir, System.currentTimeMillis() + ".mp4");
            AlertDialog showProgressDialog = VideoEditProgressDialog.showProgressDialog(this);
            this.mVideoProgressDialog = showProgressDialog;
            showProgressDialog.setCancelable(false);
            this.mVideoProgressDialog.setCanceledOnTouchOutside(false);
            onProgress(0.0f);
            pausePlay();
            new Thread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.l
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.P0(view, file);
                }
            }).start();
        }
    }

    private void pausePlay() {
        pausePlay(true, true);
    }

    private void playMusic(String str) {
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.T(0);
        }
        this.mMusicPlayer.f(getApplicationContext(), Uri.fromFile(new File(str)));
        this.mMusicPlayer.h(this.mMusicVolume / 100.0f);
        this.mMusicPlayer.i();
    }

    private void playVideo(String str) {
        if (this.mVideoPlayer == null) {
            return;
        }
        pausePlay(true, false);
        setupVideoSize(str);
        Uri fromFile = Uri.fromFile(new File(str));
        this.mVideoTextureView.setSurfaceTextureListener(null);
        this.mVideoPlayer.b0(new IMediaPlayer.OnPreparedListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.k
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                VideoEdit2Activity.this.W0(iMediaPlayer);
            }
        });
        this.mVideoPlayer.Q(fromFile);
        this.mVideoPlayer.c(this.mVideoTextureView);
        this.mVideoPlayer.V(false);
        this.mVideoPlayer.d();
        this.mVideoPlayer.e0(this.mOriVolume / 100.0f);
    }

    private void processAndInit(final String str) {
        if (this.mRecordBgMusic != null) {
            new Thread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.p
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.a1(str);
                }
            }).start();
        } else {
            new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.x
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.c1(str);
                }
            }, 300L);
        }
    }

    private void processAndPublish() {
        if (checkIsLogin()) {
            pausePlay();
            final String genOutputPath = genOutputPath();
            if (TextUtils.isEmpty(this.mSelectedMusicPath) && this.mOriVolume == 100) {
                String str = this.mProcessedVideoPath;
                if (str != null) {
                    try {
                        us.pinguo.common.utils.e.f(str, genOutputPath);
                        publish(genOutputPath, true);
                        return;
                    } catch (IOException e2) {
                        us.pinguo.common.log.a.f(e2);
                        return;
                    }
                }
                publish(this.mVideoPath, false);
                com.hw.videoprocessor.g.c.h("publish video size:" + ((((float) new File(this.mVideoPath).length()) / 1024.0f) / 1024.0f) + "m", new Object[0]);
                return;
            }
            if (this.mVideoProgressDialog == null) {
                this.mVideoProgressDialog = VideoEditProgressDialog.showProgressDialog(this);
            }
            if (this.mVideoProgress != null) {
                this.mVideoProgress.b(null);
            }
            onProgress(0.0f);
            this.mVideoProgressDialog.show();
            final String str2 = (this.mProcessedVideoPath == null || !new File(this.mProcessedVideoPath).exists()) ? this.mVideoPath : this.mProcessedVideoPath;
            int videoDuration = getVideoDuration(str2) / 1000;
            if (videoDuration == 0) {
                videoDuration = 10;
            }
            final us.pinguo.inspire.util.m mVar = new us.pinguo.inspire.util.m(100, videoDuration * 1000, 5, 200L, new us.pinguo.inspire.util.n() { // from class: us.pinguo.inspire.module.challenge.videomusic.g
                @Override // us.pinguo.inspire.util.n
                public final void a(int i2, int i3) {
                    VideoEdit2Activity.this.e1(i2, i3);
                }
            });
            mVar.b();
            this.mProcessingVideo = true;
            new Thread(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.d0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.l1(str2, genOutputPath, mVar);
                }
            }).start();
        }
    }

    private void publish(String str, boolean z) {
        if (this.DEV_MODE) {
            us.pinguo.inspire_proxy.media.e.j(this, str);
        } else if (verify() || !CommentLoader.isLoginRequired()) {
            VideoInfo videoInfo = this.mIntentVideoInfo;
            if (videoInfo != null && us.pinguo.foundation.utils.f0.b(videoInfo.getVideoPath(), str)) {
                us.pinguo.librouter.c.d.b().getVideoInterface().a(this.mIntentVideoInfo);
            } else {
                us.pinguo.librouter.c.d.b().getVideoInterface().a(genVideoInfo(str));
            }
            for (int i2 = 0; i2 < this.mEffectsVideoMap.size(); i2++) {
                new File(this.mEffectsVideoMap.valueAt(i2)).delete();
            }
            VideoPublish videoPublish = VideoPublish.INSTANCE;
            CharSequence oriText = this.mContentTxt.getOriText();
            ArrayList<InspireAttention> attentions = this.mChatBottomLayout.getAttentions();
            InspireTask inspireTask = this.mInspireTask;
            PublishData createPublishData = videoPublish.createPublishData(oriText, attentions, inspireTask == null ? sTaskId : inspireTask.taskId, this.mVideoType, str, this.mLocationInfo);
            createPublishData.compressed = z;
            createPublishData.backgroundVolume = this.mMusicVolume;
            createPublishData.quondamVolume = this.mOriVolume;
            createPublishData.specialEffect = this.mCurrentEffects;
            createPublishData.musicId = this.mSelectedMusicId;
            videoPublish.publish(createPublishData, new VideoPublishListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.w
                @Override // us.pinguo.inspire.module.challenge.videomusic.VideoPublishListener
                public final void onPublishFinish(boolean z2, String str2) {
                    VideoEdit2Activity.this.n1(z2, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            processAndPublish();
            return;
        }
        us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
        us.pinguo.user.s0.getInstance().a(this, 21, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1(String str, List list, InspireComment inspireComment, String[] strArr, Emoticon emoticon) {
        hideChatBottom();
        setContentText(this.mChatBottomLayout.getEditText().getText());
    }

    private void resetVolume(int i2, int i3) {
        if (this.mVolumeAdjustedByUser) {
            return;
        }
        setVolume(i2, i3);
    }

    private void resumePlay() {
        if (this.mVideoPlayer != null && this.mNoPermission && !TextUtils.isEmpty(this.mVideoPath) && us.pinguo.util.v.j()) {
            this.mNoPermission = false;
            b1(this.mVideoPath);
            hideCover(false);
        } else {
            VideoPlayer videoPlayer = this.mVideoPlayer;
            if (videoPlayer != null && !videoPlayer.isPlaying() && !this.mIsRestoring) {
                this.mVideoPlayer.f();
                this.mVideoPlayer.c(this.mVideoTextureView);
                this.mVideoPlayer.d();
                hideCover(false);
            }
        }
        us.pinguo.foundation.i iVar = this.mMusicPlayer;
        if (iVar == null || iVar.b() || this.mIsRestoring || this.mSelectedMusicPath == null) {
            return;
        }
        this.mMusicPlayer.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(String str) {
        String absolutePath;
        this.mScaleSemaphore = new Semaphore(1);
        try {
            try {
                this.mScaleSemaphore.acquire(1);
                File cacheDir = getCacheDir();
                absolutePath = new File(cacheDir, "scaled_" + System.currentTimeMillis() + ".mp4").getAbsolutePath();
                this.mVideoProgress = new com.hw.videoprocessor.g.h(new float[]{0.4f, 0.6f}, this);
                VideoEditUtil.scaleVideoForEdit(getApplicationContext(), str, absolutePath, this.mVideoProgress);
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
            if (checkVideoBad(absolutePath)) {
                us.pinguo.common.log.a.e("压缩视频损坏", new Object[0]);
                return;
            }
            VideoEditUtil.printVideoInfo(absolutePath);
            if (this.mDestroyed) {
                new File(absolutePath).delete();
            } else {
                this.mScaleVideoPath = absolutePath;
            }
        } finally {
            this.mScaleSemaphore.release(1);
        }
    }

    private void setContentText(CharSequence charSequence) {
        this.mContentTxt.setOmitedText(charSequence);
    }

    private void setCoverAndStartRotation(String str) {
        View findViewById = findViewById(vStudio.Android.Camera360.R.id.video_edit_music_anim);
        PhotoImageView photoImageView = (PhotoImageView) findViewById(vStudio.Android.Camera360.R.id.video_edit_music);
        findViewById.setVisibility(0);
        ((AnimationDrawable) findViewById.getBackground()).start();
        if (TextUtils.isEmpty(str)) {
            photoImageView.setImageResource(vStudio.Android.Camera360.R.drawable.video_edit_music_ic);
        } else {
            photoImageView.setImageUri(str);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(photoImageView, Key.ROTATION, 0.0f, 360.0f);
        photoImageView.setTag(ofFloat);
        ofFloat.setDuration(4000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
    }

    private void setEffectSelect(ViewGroup viewGroup, boolean z) {
        int a;
        if (viewGroup == null) {
            return;
        }
        if (z) {
            this.mSelectEffectLayout = viewGroup;
            if (viewGroup.getId() == vStudio.Android.Camera360.R.id.video_edit_reverse) {
                this.mCurrentEffects = 4;
            } else if (viewGroup.getId() == vStudio.Android.Camera360.R.id.video_edit_increase) {
                this.mCurrentEffects = 2;
            } else if (viewGroup.getId() == vStudio.Android.Camera360.R.id.video_edit_decrease) {
                this.mCurrentEffects = 3;
            } else {
                this.mCurrentEffects = 0;
            }
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ImageView) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (z) {
                    a = us.pinguo.foundation.t.b.a.a(getApplicationContext(), 45.0f);
                    childAt.setBackgroundDrawable(new CircleColorDrawable(2130706432));
                } else {
                    a = us.pinguo.foundation.t.b.a.a(getApplicationContext(), 35.0f);
                    childAt.setBackgroundDrawable(null);
                }
                layoutParams.height = a;
                layoutParams.width = a;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    private void setVolume(int i2, int i3) {
        if (i2 != this.mOriVolume) {
            this.mOriVolume = i2;
            this.mVideoPlayer.e0(i2 / 100.0f);
        }
        if (this.mMusicVolume != i3) {
            this.mMusicVolume = i3;
            this.mMusicPlayer.h(i3 / 100.0f);
        }
    }

    private void setupVideoSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i2 = 0;
            try {
                i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            } catch (Exception unused) {
            }
            int j2 = us.pinguo.foundation.t.b.a.j(this);
            if (i2 != 90 && i2 != 270) {
                ViewGroup.LayoutParams layoutParams = this.mVideoTextureView.getLayoutParams();
                layoutParams.width = j2;
                layoutParams.height = (int) (j2 / (parseInt / parseInt2));
                this.mVideoTextureView.setRotation(0.0f);
                this.mVideoTextureView.setLayoutParams(layoutParams);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.mVideoTextureView.getLayoutParams();
            layoutParams2.width = (int) (j2 * (parseInt / parseInt2));
            layoutParams2.height = j2;
            this.mVideoTextureView.setRotation(i2);
            this.mVideoTextureView.setLayoutParams(layoutParams2);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    private void showChatBottom() {
        findViewById(vStudio.Android.Camera360.R.id.video_edit_chat_keyboard_layout).setVisibility(0);
        findViewById(vStudio.Android.Camera360.R.id.video_edit_participate_ripple).setVisibility(8);
        this.mChatBottomLayout.getEditText().setText(this.mContentTxt.getOriText());
        this.mChatBottomLayout.getEditText().setSelection(this.mContentTxt.getOriText().length());
        this.mChatBottomLayout.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.t
            @Override // java.lang.Runnable
            public final void run() {
                VideoEdit2Activity.this.p1();
            }
        });
        this.mChatBottomLayout.setOnSendClickListener(new ChatBottomLayout.f() { // from class: us.pinguo.inspire.module.challenge.videomusic.e0
            @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout.f
            public final void onSendClick(String str, List list, InspireComment inspireComment, String[] strArr, Emoticon emoticon) {
                VideoEdit2Activity.this.r1(str, list, inspireComment, strArr, emoticon);
            }
        });
        this.mContentTxt.setVisibility(8);
    }

    @SuppressLint({"WrongConstant"})
    private void showSnackBar(int i2, boolean z, boolean z2) {
        CharSequence emojiText = getEmojiText(i2);
        this.mHandler.removeMessages(1);
        if (z) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
        us.pinguo.foundation.utils.j0.d(emojiText);
    }

    private void startLocation() {
        us.pinguo.librouter.b.b.b().getInterface().a(new AnonymousClass3());
    }

    public static boolean supportEdit() {
        return us.pinguo.util.c.f12472f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0() {
        findViewById(vStudio.Android.Camera360.R.id.video_edit_chat_keyboard_layout).setVisibility(8);
        findViewById(vStudio.Android.Camera360.R.id.video_edit_participate_ripple).setVisibility(0);
        this.mContentTxt.setVisibility(0);
    }

    private boolean verify() {
        if (checkIsLogin()) {
            if (this.mContentTxt.getOriText().length() > 140) {
                SnackTop.p(this.mRoot, getResources().getString(vStudio.Android.Camera360.R.string.publish_content_too_long), 0, -218253006).m();
                return false;
            } else if (us.pinguo.util.q.f(Inspire.a())) {
                return true;
            } else {
                showSnackBar(R.string.network_not_available, false, true);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0() {
        ViewCompat.setBackground(this.mCoverView, null);
        this.mCoverView.setVisibility(8);
    }

    private void waitForVideoScale() {
        if (this.mScaleSemaphore != null) {
            try {
                us.pinguo.common.log.a.s("开始等待压缩完成", new Object[0]);
                this.mScaleSemaphore.tryAcquire(80000L, TimeUnit.MILLISECONDS);
                this.mScaleSemaphore.release();
                this.mScaleSemaphore = null;
                us.pinguo.common.log.a.s("压缩已完成", new Object[0]);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(MotionEvent motionEvent) {
        this.mChatBottomLayout.onDispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            this.mChatBottomLayout.getLocationInWindow(iArr);
            if (motionEvent.getRawY() <= iArr[1]) {
                hideChatBottom();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mAnim.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // us.pinguo.foundation.base.BaseActivity
    protected String getPageId() {
        return "challenge_submit_preview_page";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireRedirectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        VideoMusic videoMusic;
        super.onActivityResult(i2, i3, intent);
        if (i2 != REQUEST_MUSIC) {
            if (i2 == 21 && us.pinguo.user.s0.getInstance().e()) {
                processAndPublish();
            }
        } else if (i3 != -1 || intent == null) {
        } else {
            VideoMusic videoMusic2 = (VideoMusic) intent.getParcelableExtra("music_select");
            if (videoMusic2 == null && (videoMusic = this.mRecordBgMusic) != null) {
                videoMusic2 = videoMusic;
            }
            if (videoMusic2 == null) {
                this.mSelectedMusicPath = null;
                this.mSelectedMusicId = null;
                pausePlay();
                us.pinguo.foundation.i iVar = this.mMusicPlayer;
                if (iVar != null) {
                    iVar.d();
                }
                resetVolume(100, 50);
                setCoverAndStartRotation(null);
                return;
            }
            this.mSelectedMusicPath = videoMusic2.c();
            this.mSelectedMusicId = videoMusic2.g();
            setCoverAndStartRotation(videoMusic2.b());
            playMusic(this.mSelectedMusicPath);
            resetVolume(30, 70);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PGEventBus.getInstance().a(new us.pinguo.foundation.eventbus.c());
        String str = this.mVideoType == 0 ? "shot_video" : "library_video";
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        InspireTask inspireTask = this.mInspireTask;
        cVar.k("challenge_submit_preview_action", "give_up_sub_btn", str, inspireTask == null ? "" : inspireTask.taskId, "click");
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == vStudio.Android.Camera360.R.id.video_edit_back) {
            onBackPressed();
            return;
        }
        if (view.getId() == vStudio.Android.Camera360.R.id.video_edit_participate) {
            checkAnonymousPublish();
            String str = this.mVideoType == 0 ? "shot_video" : "library_video";
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            InspireTask inspireTask = this.mInspireTask;
            cVar.k("challenge_submit_preview_action", "submit_btn", str, inspireTask != null ? inspireTask.taskId : "", "click");
        } else if (view.getId() == vStudio.Android.Camera360.R.id.video_edit_content) {
            showChatBottom();
            String str2 = this.mVideoType == 0 ? "shot_video" : "library_video";
            us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
            InspireTask inspireTask2 = this.mInspireTask;
            cVar2.k("challenge_submit_preview_action", "share_content", str2, inspireTask2 != null ? inspireTask2.taskId : "", "click");
        }
    }

    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        com.hw.videoprocessor.g.b.b = 1;
        us.pinguo.inspire.util.w.a(this);
        setContentView(vStudio.Android.Camera360.R.layout.video_edit_2_activity);
        com.hw.videoprocessor.g.c.j(us.pinguo.foundation.d.f10987f);
        if (supportEdit()) {
            VideoProcessor.a = 15;
        }
        this.mDestroyed = false;
        this.mVolumeAdjustedByUser = false;
        this.mMusicPlayer = new us.pinguo.foundation.i();
        initViews();
        getIntentExtra();
        if (!this.DEV_MODE) {
            processAndInit(getIntent().getStringExtra("save_video_path"));
        } else {
            new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.m
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEdit2Activity.this.R0();
                }
            }, 1000L);
        }
        onPageStart();
    }

    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        sTaskId = null;
        this.mDestroyed = true;
        if (this.mScaleVideoPath != null) {
            new File(this.mScaleVideoPath).delete();
        }
        VideoPlayer videoPlayer = this.mVideoPlayer;
        if (videoPlayer != null) {
            videoPlayer.b();
            this.mVideoPlayer = null;
        }
        us.pinguo.foundation.i iVar = this.mMusicPlayer;
        if (iVar != null) {
            iVar.d();
            this.mMusicPlayer = null;
        }
        onPageEnd();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsResume = false;
        pausePlay();
    }

    @Override // com.hw.videoprocessor.g.j
    public void onProgress(final float f2) {
        AlertDialog alertDialog = this.mVideoProgressDialog;
        if (alertDialog != null) {
            final TextView textView = (TextView) alertDialog.findViewById(vStudio.Android.Camera360.R.id.video_edit_progress_txt);
            textView.post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.a0
                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView2 = textView;
                    float f3 = f2;
                    textView2.setText(((int) (f3 * 100.0f)) + PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT);
                }
            });
        }
    }

    @Override // us.pinguo.widget.discreteseekbar.DiscreteSeekBar.g
    public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i2, boolean z) {
        if (z) {
            this.mVolumeAdjustedByUser = true;
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mIsRestoring = true;
        this.mVideoPath = bundle.getString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        this.mNoPermission = !us.pinguo.util.v.j();
        b1(this.mVideoPath);
    }

    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        startLocation();
        this.mIsResume = true;
        resumePlay();
        this.mIsRestoring = false;
    }

    @Override // us.pinguo.widget.discreteseekbar.DiscreteSeekBar.g
    public void onStartTrackingTouch(DiscreteSeekBar discreteSeekBar) {
    }

    @Override // us.pinguo.widget.discreteseekbar.DiscreteSeekBar.g
    public void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar) {
        int n = discreteSeekBar.n();
        if (discreteSeekBar == this.mOriVolumnSeekBar) {
            setVolume(n, this.mMusicVolume);
        } else if (discreteSeekBar == this.mMusicVolumnSeekBar) {
            setVolume(this.mOriVolume, n);
        }
    }

    @Override // us.pinguo.foundation.base.BaseActivity
    protected boolean useDefaultPageStatistic() {
        return false;
    }

    private CharSequence getEmojiText(int i2) {
        return getEmojiText(getResources().getString(i2));
    }

    private void pausePlay(boolean z, boolean z2) {
        VideoPlayer videoPlayer;
        us.pinguo.foundation.i iVar;
        VideoPlayer videoPlayer2 = this.mVideoPlayer;
        if (videoPlayer2 != null && z) {
            videoPlayer2.a();
            try {
                ViewCompat.setBackground(this.mCoverView, new BitmapDrawable(this.mVideoTextureView.getBitmap()));
                this.mCoverView.setVisibility(0);
                this.mCoverView.setRotation(this.mVideoTextureView.getRotation());
                ViewGroup.LayoutParams layoutParams = this.mCoverView.getLayoutParams();
                layoutParams.width = this.mVideoTextureView.getWidth();
                layoutParams.height = this.mVideoTextureView.getHeight();
            } catch (OutOfMemoryError e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }
        us.pinguo.foundation.i iVar2 = this.mMusicPlayer;
        if (iVar2 != null && z2 && iVar2.b()) {
            this.mMusicPlayer.j();
        }
        if (this.mIsResume || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        if (z && videoPlayer.isPlaying()) {
            this.mVideoPlayer.a();
        }
        if (z2 && (iVar = this.mMusicPlayer) != null && iVar.b()) {
            this.mMusicPlayer.j();
        }
    }

    @SuppressLint({"WrongConstant"})
    private void showSnackBar(String str, boolean z, boolean z2) {
        CharSequence emojiText = getEmojiText(str);
        this.mHandler.removeMessages(1);
        if (z) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
        us.pinguo.foundation.utils.j0.d(emojiText);
    }
}
