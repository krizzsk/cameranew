package us.pinguo.inspire_proxy.media;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pnikosis.materialishprogress.ProgressWheel;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.utils.x;
import us.pinguo.inspire_proxy.R;
import us.pinguo.ui.widget.dialog.LifeCycleDialog;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.VideoPlayer;
/* compiled from: DialogUtil.java */
/* loaded from: classes4.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        final /* synthetic */ VideoPlayer a;

        a(VideoPlayer videoPlayer) {
            this.a = videoPlayer;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.a.f();
            this.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class b extends LifeCycleDialog {
        private boolean b;
        final /* synthetic */ VideoPlayer c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ProgressWheel f11509d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FixedRateTextureView f11510e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Uri f11511f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f11512g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f11513h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ViewGroup f11514i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ BaseVideoTextureView f11515j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ boolean f11516k;

        /* compiled from: DialogUtil.java */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f2 = (0.19999999f * floatValue) + 0.8f;
                b.this.f11514i.setScaleX(f2);
                b.this.f11514i.setScaleY(f2);
                b.this.f11514i.setAlpha(floatValue);
            }
        }

        /* compiled from: DialogUtil.java */
        /* renamed from: us.pinguo.inspire_proxy.media.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0415b implements Animator.AnimatorListener {
            C0415b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                b.this.c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, int i2, VideoPlayer videoPlayer, ProgressWheel progressWheel, FixedRateTextureView fixedRateTextureView, Uri uri, int i3, DialogInterface.OnDismissListener onDismissListener, ViewGroup viewGroup, BaseVideoTextureView baseVideoTextureView, boolean z) {
            super(context, i2);
            this.c = videoPlayer;
            this.f11509d = progressWheel;
            this.f11510e = fixedRateTextureView;
            this.f11511f = uri;
            this.f11512g = i3;
            this.f11513h = onDismissListener;
            this.f11514i = viewGroup;
            this.f11515j = baseVideoTextureView;
            this.f11516k = z;
            this.b = false;
        }

        public void c() {
            super.dismiss();
            if (this.f11510e != null) {
                if (this.c.I()) {
                    this.c.f();
                    this.c.a();
                    this.c.d0(true);
                }
                BaseVideoTextureView baseVideoTextureView = this.f11515j;
                if (baseVideoTextureView != null) {
                    this.c.c(baseVideoTextureView);
                    if (this.f11516k) {
                        this.c.d();
                    }
                }
            }
        }

        @Override // us.pinguo.ui.widget.dialog.LifeCycleDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            if (this.b) {
                return;
            }
            this.f11513h.onDismiss(this);
            this.b = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new a());
            ofFloat.addListener(new C0415b());
            ofFloat.start();
            us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire_proxy.a.b());
        }

        @Override // us.pinguo.ui.widget.dialog.LifeCycleDialog, us.pinguo.ui.widget.dialog.a
        public void onPause() {
            super.onPause();
            e.m(this.c);
        }

        @Override // us.pinguo.ui.widget.dialog.LifeCycleDialog, us.pinguo.ui.widget.dialog.a
        public void onResume() {
            super.onResume();
            e.g(this.c, this.f11509d, this.f11510e, this.f11511f, this.f11512g, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ LifeCycleDialog a;

        c(LifeCycleDialog lifeCycleDialog) {
            this.a = lifeCycleDialog;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class d implements Runnable {
        final /* synthetic */ VideoPlayer a;
        final /* synthetic */ Uri b;
        final /* synthetic */ View c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BaseVideoTextureView f11517d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f11518e;

        /* compiled from: DialogUtil.java */
        /* loaded from: classes4.dex */
        class a implements IMediaPlayer.OnInfoListener {

            /* compiled from: DialogUtil.java */
            /* renamed from: us.pinguo.inspire_proxy.media.e$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            class RunnableC0416a implements Runnable {
                final /* synthetic */ int a;

                RunnableC0416a(int i2) {
                    this.a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view = d.this.c;
                    if (view == null) {
                        return;
                    }
                    int i2 = this.a;
                    if (i2 == 3) {
                        view.setVisibility(8);
                        VdsAgent.onSetViewVisibility(view, 8);
                    } else if (i2 == 702) {
                        view.setVisibility(8);
                        VdsAgent.onSetViewVisibility(view, 8);
                    } else if (i2 == 701) {
                        view.setVisibility(0);
                        VdsAgent.onSetViewVisibility(view, 0);
                    }
                }
            }

            a() {
            }

            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
                BaseVideoTextureView baseVideoTextureView;
                d dVar = d.this;
                if (dVar.c == null) {
                    return true;
                }
                if (i2 == 10001 && (baseVideoTextureView = dVar.f11517d) != null && (baseVideoTextureView instanceof FixedRateTextureView)) {
                    FixedRateTextureView fixedRateTextureView = (FixedRateTextureView) baseVideoTextureView;
                    if (fixedRateTextureView.d() == 0 && i3 != 0) {
                        fixedRateTextureView.setFixRotation(i3);
                    }
                }
                d.this.c.post(new RunnableC0416a(i2));
                return true;
            }
        }

        d(VideoPlayer videoPlayer, Uri uri, View view, BaseVideoTextureView baseVideoTextureView, boolean z) {
            this.a = videoPlayer;
            this.b = uri;
            this.c = view;
            this.f11517d = baseVideoTextureView;
            this.f11518e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayer videoPlayer = this.a;
            if (videoPlayer != null) {
                if (videoPlayer.I() && this.a.E(this.b)) {
                    this.a.f();
                    this.a.a();
                    this.a.d0(false);
                    View view = this.c;
                    view.setVisibility(8);
                    VdsAgent.onSetViewVisibility(view, 8);
                } else {
                    this.a.Q(this.b);
                    this.a.V(false);
                    View view2 = this.c;
                    view2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(view2, 0);
                }
                this.a.c(this.f11517d);
                this.a.a0(new a());
                if (this.f11518e) {
                    return;
                }
                this.a.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* renamed from: us.pinguo.inspire_proxy.media.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogC0417e extends Dialog {
        private boolean a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ IjkVideoView c;

        /* compiled from: DialogUtil.java */
        /* renamed from: us.pinguo.inspire_proxy.media.e$e$a */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f2 = (0.19999999f * floatValue) + 0.8f;
                DialogC0417e.this.b.setScaleX(f2);
                DialogC0417e.this.b.setScaleY(f2);
                DialogC0417e.this.b.setAlpha(floatValue);
            }
        }

        /* compiled from: DialogUtil.java */
        /* renamed from: us.pinguo.inspire_proxy.media.e$e$b */
        /* loaded from: classes4.dex */
        class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                DialogC0417e.this.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DialogC0417e.this.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        DialogC0417e(Context context, int i2, ViewGroup viewGroup, IjkVideoView ijkVideoView) {
            super(context, i2);
            this.b = viewGroup;
            this.c = ijkVideoView;
            this.a = false;
        }

        public void a() {
            super.dismiss();
            IjkVideoView ijkVideoView = this.c;
            if (ijkVideoView != null) {
                ijkVideoView.O();
            }
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            if (this.a) {
                return;
            }
            this.a = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new a());
            ofFloat.addListener(new b());
            ofFloat.start();
            us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire_proxy.a.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class f implements IMediaPlayer.OnPreparedListener {
        final /* synthetic */ ProgressWheel a;

        f(ProgressWheel progressWheel) {
            this.a = progressWheel;
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            ProgressWheel progressWheel = this.a;
            progressWheel.setVisibility(8);
            VdsAgent.onSetViewVisibility(progressWheel, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        final /* synthetic */ Dialog a;

        g(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogUtil.java */
    /* loaded from: classes4.dex */
    public class h extends LifeCycleDialog {
        private boolean b;
        final /* synthetic */ VideoPlayer c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ProgressWheel f11519d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FixedRateTextureView f11520e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Uri f11521f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ViewGroup f11522g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ BaseVideoTextureView f11523h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f11524i;

        /* compiled from: DialogUtil.java */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {

            /* compiled from: DialogUtil.java */
            /* renamed from: us.pinguo.inspire_proxy.media.e$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            class RunnableC0418a implements Runnable {
                final /* synthetic */ float a;
                final /* synthetic */ float b;

                RunnableC0418a(float f2, float f3) {
                    this.a = f2;
                    this.b = f3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.this.f11522g.setScaleX(this.a);
                    h.this.f11522g.setScaleY(this.a);
                    h.this.f11522g.setAlpha(this.b);
                }
            }

            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                h.this.f11522g.post(new RunnableC0418a((0.19999999f * floatValue) + 0.8f, floatValue));
            }
        }

        /* compiled from: DialogUtil.java */
        /* loaded from: classes4.dex */
        class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                h.this.c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Context context, int i2, VideoPlayer videoPlayer, ProgressWheel progressWheel, FixedRateTextureView fixedRateTextureView, Uri uri, ViewGroup viewGroup, BaseVideoTextureView baseVideoTextureView, boolean z) {
            super(context, i2);
            this.c = videoPlayer;
            this.f11519d = progressWheel;
            this.f11520e = fixedRateTextureView;
            this.f11521f = uri;
            this.f11522g = viewGroup;
            this.f11523h = baseVideoTextureView;
            this.f11524i = z;
            this.b = false;
        }

        public void c() {
            super.dismiss();
            if (this.f11520e != null) {
                if (this.c.I()) {
                    this.c.f();
                    this.c.a();
                    this.c.d0(true);
                }
                BaseVideoTextureView baseVideoTextureView = this.f11523h;
                if (baseVideoTextureView != null) {
                    this.c.c(baseVideoTextureView);
                    if (this.f11524i) {
                        this.c.d();
                    }
                }
            }
        }

        @Override // us.pinguo.ui.widget.dialog.LifeCycleDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            if (this.b) {
                return;
            }
            this.b = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new a());
            ofFloat.addListener(new b());
            ofFloat.start();
            us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire_proxy.a.b());
        }

        @Override // us.pinguo.ui.widget.dialog.LifeCycleDialog, us.pinguo.ui.widget.dialog.a
        public void onPause() {
            super.onPause();
            e.m(this.c);
        }

        @Override // us.pinguo.ui.widget.dialog.LifeCycleDialog, us.pinguo.ui.widget.dialog.a
        public void onResume() {
            super.onResume();
            e.g(this.c, this.f11519d, this.f11520e, this.f11521f, 200, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(LifeCycleDialog lifeCycleDialog, View view) {
        VdsAgent.lambdaOnClick(view);
        lifeCycleDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(ImageView imageView, VideoPlayer videoPlayer, View view) {
        VdsAgent.lambdaOnClick(view);
        boolean z = !((Boolean) imageView.getTag()).booleanValue();
        imageView.setTag(Boolean.valueOf(z));
        if (z) {
            imageView.setImageResource(R.drawable.voice_silent_true);
        } else {
            imageView.setImageResource(R.drawable.voice_silent_false);
        }
        videoPlayer.d0(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(ImageView imageView, IjkVideoView ijkVideoView, View view) {
        VdsAgent.lambdaOnClick(view);
        boolean z = !((Boolean) imageView.getTag()).booleanValue();
        imageView.setTag(Boolean.valueOf(z));
        if (z) {
            imageView.setImageResource(R.drawable.voice_silent_true);
        } else {
            imageView.setImageResource(R.drawable.voice_silent_false);
        }
        ijkVideoView.setSilent(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(VideoPlayer videoPlayer, View view, BaseVideoTextureView baseVideoTextureView, Uri uri, int i2, boolean z) {
        baseVideoTextureView.postDelayed(new d(videoPlayer, uri, view, baseVideoTextureView, z), i2);
    }

    public static LifeCycleDialog h(InspireBaseActivity inspireBaseActivity, Uri uri, int i2, int i3, int i4) {
        VideoPlayer videoPlayer = new VideoPlayer(inspireBaseActivity);
        boolean isPlaying = videoPlayer.isPlaying();
        BaseVideoTextureView A = videoPlayer.A();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(inspireBaseActivity).inflate(R.layout.challenge_video_player_fullscreen_layout, (ViewGroup) null);
        FixedRateTextureView fixedRateTextureView = (FixedRateTextureView) viewGroup.findViewById(R.id.dialog_video);
        View findViewById = viewGroup.findViewById(R.id.dialog_video_pass);
        fixedRateTextureView.setRate(i2 / i3, i4);
        ProgressWheel progressWheel = (ProgressWheel) viewGroup.findViewById(R.id.dialog_video_progress);
        final h hVar = new h(inspireBaseActivity, 16973831, videoPlayer, progressWheel, fixedRateTextureView, uri, viewGroup, A, isPlaying);
        hVar.a(inspireBaseActivity);
        videoPlayer.Y(new IMediaPlayer.OnCompletionListener() { // from class: us.pinguo.inspire_proxy.media.a
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                LifeCycleDialog.this.dismiss();
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire_proxy.media.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.d(LifeCycleDialog.this, view);
            }
        });
        hVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        hVar.getWindow().addFlags(128);
        hVar.setContentView(viewGroup);
        g(videoPlayer, progressWheel, fixedRateTextureView, uri, 200, false);
        hVar.getWindow().setWindowAnimations(R.style.Dialog_Video_Animations);
        hVar.show();
        VdsAgent.showDialog(hVar);
        return hVar;
    }

    public static LifeCycleDialog i(Context context, Uri uri, int i2, int i3, int i4) {
        VideoPlayer videoPlayer = new VideoPlayer(context);
        return k(context, videoPlayer, uri, i2, i3, i4, 200, new a(videoPlayer));
    }

    public static LifeCycleDialog j(Context context, String str) {
        int j2;
        int i2;
        int i3;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            if (Build.VERSION.SDK_INT >= 17) {
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                i3 = !TextUtils.isEmpty(extractMetadata) ? Integer.parseInt(extractMetadata) : 0;
            } else {
                i3 = us.pinguo.librouter.c.d.b().getInterface().f(str);
            }
            j2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        } catch (Exception e2) {
            e2.printStackTrace();
            j2 = us.pinguo.foundation.t.b.a.j(context);
            i2 = j2;
            i3 = 0;
        }
        d.f.a.b.d.d("video:" + str + " w:" + j2 + " h:" + i2 + " rotation:" + i3, new Object[0]);
        return i(context, Uri.parse(str), j2, i2, i3);
    }

    public static LifeCycleDialog k(Context context, final VideoPlayer videoPlayer, Uri uri, int i2, int i3, int i4, int i5, DialogInterface.OnDismissListener onDismissListener) {
        boolean isPlaying = videoPlayer.isPlaying();
        BaseVideoTextureView A = videoPlayer.A();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.comment_video_player_fullscreen_layout, (ViewGroup) null);
        FixedRateTextureView fixedRateTextureView = (FixedRateTextureView) viewGroup.findViewById(R.id.dialog_video);
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.dialog_video_voice_silent);
        imageView.setTag(Boolean.FALSE);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire_proxy.media.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.e(imageView, videoPlayer, view);
            }
        });
        fixedRateTextureView.setRate(i2 / i3, i4);
        ProgressWheel progressWheel = (ProgressWheel) viewGroup.findViewById(R.id.dialog_video_progress);
        b bVar = new b(context, 16973831, videoPlayer, progressWheel, fixedRateTextureView, uri, i5, onDismissListener, viewGroup, A, isPlaying);
        Window window = bVar.getWindow();
        x.a.d(-1, window);
        window.addFlags(128);
        bVar.setContentView(viewGroup);
        g(videoPlayer, progressWheel, fixedRateTextureView, uri, i5, false);
        window.setWindowAnimations(R.style.Dialog_Video_Animations);
        bVar.show();
        VdsAgent.showDialog(bVar);
        viewGroup.setOnClickListener(new c(bVar));
        return bVar;
    }

    @Deprecated
    public static Dialog l(Context context, Uri uri) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.comment_video_fullscreen_layout, (ViewGroup) null);
        final IjkVideoView ijkVideoView = (IjkVideoView) viewGroup.findViewById(R.id.dialog_video);
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.dialog_video_voice_silent);
        imageView.setTag(Boolean.FALSE);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire_proxy.media.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.f(imageView, ijkVideoView, view);
            }
        });
        DialogC0417e dialogC0417e = new DialogC0417e(context, 16973831, viewGroup, ijkVideoView);
        dialogC0417e.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialogC0417e.getWindow().addFlags(128);
        dialogC0417e.setContentView(viewGroup);
        ijkVideoView.setLooping(true);
        ijkVideoView.setVideoURI(uri);
        ijkVideoView.setOnPreparedListener(new f((ProgressWheel) viewGroup.findViewById(R.id.dialog_video_progress)));
        ijkVideoView.start();
        dialogC0417e.getWindow().setWindowAnimations(R.style.Dialog_Video_Animations);
        dialogC0417e.show();
        VdsAgent.showDialog(dialogC0417e);
        viewGroup.setOnClickListener(new g(dialogC0417e));
        return dialogC0417e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(VideoPlayer videoPlayer) {
        if (videoPlayer != null) {
            videoPlayer.f();
            videoPlayer.b();
        }
    }
}
