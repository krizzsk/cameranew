package us.pinguo.inspire.widget.videocell;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.pnikosis.materialishprogress.ProgressWheel;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.inspire.widget.video.WorkDetailVideoView;
import us.pinguo.inspire.widget.videocell.VisibilityListenImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireVideoView extends RelativeLayout implements VisibilityListenImageView.a, IMediaPlayer.OnInfoListener {
    private WorkDetailVideoView a;
    private PhotoImageView b;
    private ProgressWheel c;

    /* renamed from: d  reason: collision with root package name */
    private float f11481d;

    /* renamed from: e  reason: collision with root package name */
    private VisibilityListenImageView f11482e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f11483f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f11484g;

    public InspireVideoView(Context context) {
        super(context);
        this.f11483f = new Runnable() { // from class: us.pinguo.inspire.widget.videocell.b
            @Override // java.lang.Runnable
            public final void run() {
                InspireVideoView.this.g();
            }
        };
        this.f11484g = new Handler(Looper.getMainLooper());
        e();
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_video_inspire, this);
        this.a = (WorkDetailVideoView) findViewById(R.id.wdvv_video_video_view);
        this.b = (PhotoImageView) findViewById(R.id.piv_photo_video_view);
        this.c = (ProgressWheel) findViewById(R.id.iv_progress_video_view);
        VisibilityListenImageView visibilityListenImageView = (VisibilityListenImageView) findViewById(R.id.iv_play_video_view);
        this.f11482e = visibilityListenImageView;
        visibilityListenImageView.a(this);
        this.a.setProgressView(this.c);
        this.a.setPlayView(this.f11482e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void g() {
        this.c.setVisibility(0);
    }

    public PhotoImageView a() {
        return this.b;
    }

    public WorkDetailVideoView b() {
        return this.a;
    }

    public void c() {
        this.f11482e.setVisibility(8);
    }

    /* renamed from: d */
    public void i() {
        this.c.setVisibility(8);
    }

    public void j() {
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        this.f11482e.setVisibility(8);
    }

    public void k() {
        this.b.setVisibility(0);
    }

    public void l() {
        this.f11482e.setVisibility(0);
        this.c.setVisibility(8);
    }

    public void n() {
        h();
        this.f11484g.postDelayed(this.f11483f, 800L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
        if (i2 == 701) {
            this.f11484g.postDelayed(this.f11483f, 800L);
            return false;
        } else if (i2 != 702) {
            return false;
        } else {
            this.f11484g.removeCallbacks(this.f11483f);
            this.f11484g.post(new Runnable() { // from class: us.pinguo.inspire.widget.videocell.c
                @Override // java.lang.Runnable
                public final void run() {
                    InspireVideoView.this.i();
                }
            });
            return false;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        us.pinguo.common.log.a.m("measure", "inspireVideoView onMeasure" + System.currentTimeMillis() + "ms", new Object[0]);
        if (this.f11481d > 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size / this.f11481d), 1073741824));
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // us.pinguo.inspire.widget.videocell.VisibilityListenImageView.a
    public void onVisibilityChange(int i2) {
    }

    public void setRate(float f2) {
        this.f11481d = f2;
    }

    public void setVideoMargin(int i2, int i3) {
        ((RelativeLayout.LayoutParams) this.a.getLayoutParams()).setMargins(i3, i2, 0, 0);
    }

    public InspireVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11483f = new Runnable() { // from class: us.pinguo.inspire.widget.videocell.b
            @Override // java.lang.Runnable
            public final void run() {
                InspireVideoView.this.g();
            }
        };
        this.f11484g = new Handler(Looper.getMainLooper());
        e();
    }

    public InspireVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11483f = new Runnable() { // from class: us.pinguo.inspire.widget.videocell.b
            @Override // java.lang.Runnable
            public final void run() {
                InspireVideoView.this.g();
            }
        };
        this.f11484g = new Handler(Looper.getMainLooper());
        e();
    }
}
