package us.pinguo.camera2020.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.File;
import java.util.Locale;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.v1;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.AfterCaptureCircleImageView;
import us.pinguo.camera2020.widget.BottomMenuLayout;
import us.pinguo.camera2020.widget.CameraLaunchMode;
import us.pinguo.camera2020.widget.CameraModeSwitchLayout;
import us.pinguo.camera2020.widget.CameraSwitchMode;
import us.pinguo.camera2020.widget.ShutterButton;
import us.pinguo.camera2020.widget.ShutterButtonDrawable;
import us.pinguo.common.EventType;
import us.pinguo.common.h;
import us.pinguo.svideo.bean.VideoInfo;
/* compiled from: CameraBottomViewController.kt */
/* loaded from: classes3.dex */
public final class CameraBottomViewController implements LifecycleObserver, View.OnTouchListener, us.pinguo.svideo.c.e, us.pinguo.common.h, us.pinguo.common.g {
    private long A;
    private boolean B;
    private boolean C;
    private int D;
    private long E;
    private String F;
    private String G;
    private float H;
    private final float I;
    private final int J;
    private kotlin.jvm.b.l<? super View, kotlin.u> K;
    private kotlin.jvm.b.l<? super View, kotlin.u> L;
    private kotlin.jvm.b.l<? super View, kotlin.u> M;
    private kotlin.jvm.b.l<? super View, kotlin.u> N;
    private kotlin.jvm.b.l<? super View, kotlin.u> O;
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> P;
    private int Q;
    private boolean R;
    private long S;
    private boolean T;
    private boolean U;
    private final b V;
    private final Runnable W;
    private final View.OnClickListener X;
    private float Y;
    private float Z;
    private final LifecycleOwner a;
    private final us.pinguo.camera2020.module.settings.a b;
    private final BottomMenuLayout c;

    /* renamed from: d */
    private final CameraLaunchMode f9285d;
    private final int d0;

    /* renamed from: e */
    private final boolean f9286e;

    /* renamed from: f */
    private final ConstraintLayout f9287f;

    /* renamed from: g */
    private final ShutterButton f9288g;

    /* renamed from: h */
    private final AfterCaptureCircleImageView f9289h;

    /* renamed from: i */
    private final TextView f9290i;

    /* renamed from: j */
    private final ImageView f9291j;

    /* renamed from: k */
    private final TextView f9292k;

    /* renamed from: l */
    private final ImageView f9293l;
    private final TextView m;
    private final ImageView n;
    private final TextView o;
    private final ConstraintLayout p;
    private final View q;
    private final RecordTimeTextView r;
    private int s;
    private ShutterButtonDrawable.State t;
    private final CameraModeSwitchLayout u;
    private r2 v;
    private kotlinx.coroutines.v1 w;
    private final long x;
    private final Handler y;
    private boolean z;

    /* compiled from: CameraBottomViewController.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CameraLaunchMode.values().length];
            iArr[CameraLaunchMode.NORMAL.ordinal()] = 1;
            iArr[CameraLaunchMode.ONLY_MOVIE.ordinal()] = 2;
            iArr[CameraLaunchMode.ONLY_PHOTO.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: CameraBottomViewController.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        private boolean a;

        b() {
            CameraBottomViewController.this = r1;
        }

        public final boolean a() {
            return this.a;
        }

        public final void b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            long elapsedRealtime = SystemClock.elapsedRealtime() - CameraBottomViewController.this.E;
            if (this.a) {
                if (((float) elapsedRealtime) < 3200.0f) {
                    CameraBottomViewController.this.V0(elapsedRealtime);
                    CameraBottomViewController.this.y.postDelayed(this, 16L);
                    return;
                }
                this.a = false;
                r2 r2Var = CameraBottomViewController.this.v;
                if (r2Var == null) {
                    return;
                }
                r2Var.g();
            } else if ((CameraBottomViewController.this.S() <= 0 || elapsedRealtime < CameraBottomViewController.this.S() + 200) && ((float) elapsedRealtime) < 300200.0f) {
                CameraBottomViewController.this.V0(elapsedRealtime);
                CameraBottomViewController.this.y.postDelayed(this, 16L);
            } else {
                this.a = false;
                r2 r2Var2 = CameraBottomViewController.this.v;
                if (r2Var2 == null) {
                    return;
                }
                r2Var2.g();
            }
        }
    }

    /* compiled from: CameraBottomViewController.kt */
    /* loaded from: classes3.dex */
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ CameraSwitchMode b;

        c(CameraSwitchMode cameraSwitchMode) {
            CameraBottomViewController.this = r1;
            this.b = cameraSwitchMode;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraBottomViewController.this.X0(this.b);
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Runnable {
        public d() {
            CameraBottomViewController.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CameraBottomViewController.this.V()) {
                return;
            }
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new CameraBottomViewController$longPressRunnable$1$1(CameraBottomViewController.this, null), 3, null);
        }
    }

    public CameraBottomViewController(LifecycleOwner lifecycleOwner, us.pinguo.camera2020.module.settings.a cameraBottomModule, BottomMenuLayout cameraBottomView, CameraLaunchMode cameraLaunchMode, boolean z, boolean z2) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(cameraBottomModule, "cameraBottomModule");
        kotlin.jvm.internal.s.h(cameraBottomView, "cameraBottomView");
        kotlin.jvm.internal.s.h(cameraLaunchMode, "cameraLaunchMode");
        this.a = lifecycleOwner;
        this.b = cameraBottomModule;
        this.c = cameraBottomView;
        this.f9285d = cameraLaunchMode;
        this.f9286e = z;
        this.f9287f = (ConstraintLayout) cameraBottomView._$_findCachedViewById(R.id.clFuncArea);
        ShutterButton shutterButton = (ShutterButton) cameraBottomView._$_findCachedViewById(R.id.imgShutterOrSave);
        this.f9288g = shutterButton;
        AfterCaptureCircleImageView afterCaptureCircleImageView = (AfterCaptureCircleImageView) cameraBottomView._$_findCachedViewById(R.id.imgAlbumMusicDiscard);
        this.f9289h = afterCaptureCircleImageView;
        this.f9290i = (TextView) cameraBottomView._$_findCachedViewById(R.id.txtAlbumMusicDiscard);
        this.f9291j = (ImageView) cameraBottomView._$_findCachedViewById(R.id.imgBeauty);
        this.f9292k = (TextView) cameraBottomView._$_findCachedViewById(R.id.txtBeauty);
        this.f9293l = (ImageView) cameraBottomView._$_findCachedViewById(R.id.imgStickerOrFilter);
        this.m = (TextView) cameraBottomView._$_findCachedViewById(R.id.txtStickerOrFilter);
        this.n = (ImageView) cameraBottomView._$_findCachedViewById(R.id.imgFilterOrShare);
        this.o = (TextView) cameraBottomView._$_findCachedViewById(R.id.txtFilterOrShare);
        ConstraintLayout constraintLayout = (ConstraintLayout) cameraBottomView._$_findCachedViewById(R.id.clVideoRecordTime);
        this.p = constraintLayout;
        this.q = constraintLayout.findViewById(R.id.vRecordTimePoint);
        this.r = (RecordTimeTextView) constraintLayout.findViewById(R.id.tvRecordTime);
        this.s = -1;
        View _$_findCachedViewById = cameraBottomView._$_findCachedViewById(R.id.cameraModeSwitchLayout);
        Objects.requireNonNull(_$_findCachedViewById, "null cannot be cast to non-null type us.pinguo.camera2020.widget.CameraModeSwitchLayout");
        CameraModeSwitchLayout cameraModeSwitchLayout = (CameraModeSwitchLayout) _$_findCachedViewById;
        this.u = cameraModeSwitchLayout;
        this.x = ViewConfiguration.getLongPressTimeout();
        this.y = new Handler();
        this.D = -1;
        this.H = Float.NaN;
        Resources resources = cameraBottomView.getResources();
        int i2 = R.dimen.shutter_size_small;
        float dimension = resources.getDimension(i2);
        Resources resources2 = cameraBottomView.getResources();
        int i3 = R.dimen.shutter_size_normal;
        this.I = dimension / resources2.getDimension(i3);
        cameraBottomView.getResources().getDimensionPixelSize(i2);
        cameraBottomView.getResources().getDimensionPixelSize(i3);
        this.J = cameraBottomView.getResources().getDimensionPixelSize(R.dimen.shutter_size_big);
        this.R = true;
        this.T = true;
        this.V = new b();
        this.W = new d();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.camera2020.view.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraBottomViewController.Q0(CameraBottomViewController.this, view);
            }
        };
        this.X = onClickListener;
        this.d0 = ViewConfiguration.get(cameraBottomView.getContext()).getScaledTouchSlop();
        int i4 = a.a[cameraLaunchMode.ordinal()];
        if (i4 == 1) {
            cameraBottomModule.a().setValue(CameraSwitchMode.PHOTO);
            cameraModeSwitchLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 0);
            shutterButton.setOnClickListener(onClickListener);
            shutterButton.setOnTouchListener(this);
        } else if (i4 == 2) {
            cameraBottomModule.a().setValue(CameraSwitchMode.MOVIE);
            cameraModeSwitchLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 4);
            shutterButton.setOnClickListener(null);
            shutterButton.setOnTouchListener(this);
        } else if (i4 == 3) {
            cameraBottomModule.a().setValue(CameraSwitchMode.PHOTO);
            cameraModeSwitchLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 4);
            shutterButton.setOnClickListener(onClickListener);
            shutterButton.setOnTouchListener(null);
        }
        cameraModeSwitchLayout.setOnCameraModeSelectListener(new CameraModeSwitchLayout.b() { // from class: us.pinguo.camera2020.view.j0
            @Override // us.pinguo.camera2020.widget.CameraModeSwitchLayout.b
            public final void a(CameraSwitchMode cameraSwitchMode) {
                CameraBottomViewController.e(CameraBottomViewController.this, cameraSwitchMode);
            }
        });
        shutterButton.setMax(1000);
        shutterButton.setProgress(0.0f);
        if (z) {
            afterCaptureCircleImageView.setVisibility(4);
        }
    }

    public static /* synthetic */ void E0(CameraBottomViewController cameraBottomViewController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        cameraBottomViewController.D0(z);
    }

    public static final void F0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    public static final void G0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    public static final void H0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    public static final void I0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    public static final void J0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    public static /* synthetic */ void K(CameraBottomViewController cameraBottomViewController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        cameraBottomViewController.I(z);
    }

    public final void K0() {
        String str = this.F;
        if (str == null) {
            this.f9289h.setDefaultImageView(Boolean.TRUE);
            this.f9289h.setImageResource(this.C ? R.drawable.ic_album_icon : R.drawable.ic_album_light);
            this.G = null;
        } else if (kotlin.jvm.internal.s.c(this.G, str)) {
        } else {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.b(), null, new CameraBottomViewController$showScaleUserPic$1(this, null), 2, null);
        }
    }

    public static final void L(CameraBottomViewController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ConstraintLayout functionArea = this$0.f9287f;
        kotlin.jvm.internal.s.g(functionArea, "functionArea");
        functionArea.setVisibility(0);
        VdsAgent.onSetViewVisibility(functionArea, 0);
    }

    public static /* synthetic */ void N(CameraBottomViewController cameraBottomViewController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        cameraBottomViewController.M(z);
    }

    public static final void N0(ShutterButton shutter) {
        kotlin.jvm.internal.s.h(shutter, "$shutter");
        shutter.setVisibility(0);
        VdsAgent.onSetViewVisibility(shutter, 0);
    }

    public static final void P(CameraBottomViewController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ConstraintLayout functionArea = this$0.f9287f;
        kotlin.jvm.internal.s.g(functionArea, "functionArea");
        functionArea.setVisibility(4);
        VdsAgent.onSetViewVisibility(functionArea, 4);
    }

    public static final void P0(ShutterButton shutter) {
        kotlin.jvm.internal.s.h(shutter, "$shutter");
        shutter.setVisibility(4);
        VdsAgent.onSetViewVisibility(shutter, 4);
    }

    public final String Q() {
        String i0;
        String str;
        boolean x;
        if (us.pinguo.util.v.j()) {
            String k2 = us.pinguo.foundation.j.e().k("pref_camera_save_path_key", us.pinguo.image.saver.c.c);
            kotlin.jvm.internal.s.g(k2, "get().getString(CameraBu…torage.DEFAULT_DIRECTORY)");
            String separator = File.separator;
            kotlin.jvm.internal.s.g(separator, "separator");
            i0 = StringsKt__StringsKt.i0(k2, separator);
            Locale ENGLISH = Locale.ENGLISH;
            kotlin.jvm.internal.s.g(ENGLISH, "ENGLISH");
            String lowerCase = i0.toLowerCase(ENGLISH);
            kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Cursor query = us.pinguo.foundation.e.b().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "date_modified"}, "bucket_id = ?", new String[]{String.valueOf(lowerCase.hashCode())}, "date_modified DESC");
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        str = query.getString(query.getColumnIndex("_data"));
                        x = kotlin.text.t.x(str, i0 + ((Object) File.separator) + "C360", false, 2, null);
                        if (x) {
                            break;
                        }
                    } while (query.moveToNext());
                } else {
                    str = null;
                }
                kotlin.io.b.a(query, null);
                return str;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.b.a(query, th);
                    throw th2;
                }
            }
        }
        return null;
    }

    public static final void Q0(CameraBottomViewController this$0, View view) {
        r2 r2Var;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (!this$0.B && Math.abs(System.currentTimeMillis() - this$0.S) > 1000) {
            r2 r2Var2 = this$0.v;
            boolean z = false;
            if (r2Var2 != null && r2Var2.e()) {
                z = true;
            }
            if (z || (r2Var = this$0.v) == null) {
                return;
            }
            r2Var.f();
        }
    }

    private final void R0() {
        ViewPropertyAnimator scaleY = this.f9289h.animate().scaleX(1.2f).scaleY(1.2f);
        scaleY.setDuration(200L);
        scaleY.setInterpolator(new AccelerateInterpolator());
        scaleY.withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.k0
            @Override // java.lang.Runnable
            public final void run() {
                CameraBottomViewController.S0(CameraBottomViewController.this);
            }
        });
        scaleY.start();
    }

    public static final void S0(CameraBottomViewController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ViewPropertyAnimator scaleY = this$0.f9289h.animate().scaleX(1.0f).scaleY(1.0f);
        scaleY.setDuration(200L);
        scaleY.setInterpolator(new DecelerateInterpolator());
        scaleY.start();
    }

    public static final void U(CameraBottomViewController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f9291j.setVisibility(4);
        TextView textView = this$0.f9292k;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    @SuppressLint({"SetTextI18n"})
    public final void V0(long j2) {
        Integer value = us.pinguo.repository2020.m.a.u().getValue();
        float intValue = value == null ? 300200.0f : (value.intValue() * 1000.0f) + 200;
        float f2 = ((float) j2) / intValue;
        this.f9288g.setProgress(f2);
        RecordTimeTextView recordTimeTextView = this.r;
        int i2 = (int) intValue;
        int i3 = ((int) (f2 * i2)) / 1000;
        if (i3 < 0) {
            i3 = 0;
        } else {
            int i4 = i2 / 1000;
            if (i3 > i4) {
                i3 = i4;
            }
        }
        int i5 = i3 / 60;
        int i6 = i3 - (i5 * 60);
        String valueOf = String.valueOf(i6);
        if (i6 < 10) {
            valueOf = kotlin.jvm.internal.s.q("0", valueOf);
        }
        recordTimeTextView.setText('0' + i5 + ':' + valueOf);
    }

    public final void X0(CameraSwitchMode cameraSwitchMode) {
        ShutterButton btShutter = this.f9288g;
        kotlin.jvm.internal.s.g(btShutter, "btShutter");
        ViewGroup.LayoutParams layoutParams = btShutter.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i2 = this.J;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
        btShutter.setLayoutParams(layoutParams2);
        this.f9288g.setBackgroundResource(0);
        this.f9288g.setImageResource(0);
        if (cameraSwitchMode == CameraSwitchMode.PHOTO) {
            this.f9288g.setState(ShutterButtonDrawable.State.CAMERA);
            this.f9288g.setOnClickListener(this.X);
            if (this.f9285d != CameraLaunchMode.ONLY_PHOTO) {
                this.f9288g.setOnTouchListener(this);
            }
        } else {
            this.f9288g.setState(ShutterButtonDrawable.State.VIDEO);
            this.f9288g.setOnClickListener(null);
            this.f9288g.setOnTouchListener(this);
        }
        this.f9288g.setTransparentMode(!this.C);
    }

    public static final void e(CameraBottomViewController this$0, CameraSwitchMode cameraSwitchMode) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b.a().setValue(cameraSwitchMode);
        this$0.f9289h.setDefaultImageView(Boolean.TRUE);
        if (cameraSwitchMode == CameraSwitchMode.PHOTO) {
            this$0.f9288g.setState(ShutterButtonDrawable.State.CAMERA);
            this$0.f9288g.setOnClickListener(this$0.X);
            if (this$0.f9286e) {
                this$0.f9289h.setVisibility(4);
                TextView textView = this$0.f9290i;
                textView.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView, 4);
                return;
            }
            this$0.K0();
            AfterCaptureCircleImageView afterCaptureCircleImageView = this$0.f9289h;
            final kotlin.jvm.b.l<? super View, kotlin.u> lVar = this$0.L;
            afterCaptureCircleImageView.setOnClickListener(lVar != null ? new View.OnClickListener() { // from class: us.pinguo.camera2020.view.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CameraBottomViewController.m0(kotlin.jvm.b.l.this, view);
                }
            } : null);
            this$0.f9290i.setText(R.string.album);
            return;
        }
        this$0.f9288g.setState(ShutterButtonDrawable.State.VIDEO);
        this$0.f9288g.setOnClickListener(null);
        this$0.f9288g.setOnTouchListener(this$0);
        this$0.f9289h.setImageResource(this$0.C ? R.drawable.ic_music_dark : R.drawable.ic_music_light);
        AfterCaptureCircleImageView afterCaptureCircleImageView2 = this$0.f9289h;
        final kotlin.jvm.b.l<? super View, kotlin.u> lVar2 = this$0.K;
        afterCaptureCircleImageView2.setOnClickListener(lVar2 != null ? new View.OnClickListener() { // from class: us.pinguo.camera2020.view.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraBottomViewController.n0(kotlin.jvm.b.l.this, view);
            }
        } : null);
        this$0.f9290i.setText(R.string.music);
        this$0.s0();
    }

    public static final void m0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    public static final void n0(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        this.T = true;
        this.y.removeCallbacksAndMessages(null);
        this.v = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        this.U = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        this.U = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onStop() {
        this.f9288g.setProgress(0.0f);
        this.y.removeCallbacksAndMessages(null);
        this.T = true;
    }

    public static final void p0(CameraBottomViewController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f9288g.setProgress(0.0f);
        this$0.T = true;
    }

    public final void A0(r2 shutterBlock) {
        kotlin.jvm.internal.s.h(shutterBlock, "shutterBlock");
        this.v = shutterBlock;
    }

    public final void B0(kotlin.jvm.b.l<? super View, kotlin.u> lVar) {
        this.N = lVar;
    }

    public final void C0(int i2) {
        this.D = i2;
    }

    @Override // us.pinguo.common.h
    public int D() {
        return h.a.f(this);
    }

    public final void D0(boolean z) {
        this.R = true;
        this.f9287f.setAlpha(1.0f);
        ConstraintLayout constraintLayout = this.f9287f;
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        if (this.f9285d == CameraLaunchMode.NORMAL) {
            CameraModeSwitchLayout cameraModeSwitchLayout = this.u;
            cameraModeSwitchLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 0);
        }
        CameraSwitchMode value = this.b.a().getValue();
        if (value == null) {
            value = CameraSwitchMode.PHOTO;
        }
        kotlin.jvm.internal.s.g(value, "cameraBottomModule.camer…?: CameraSwitchMode.PHOTO");
        if (z) {
            this.f9288g.w(new c(value));
        } else {
            X0(value);
        }
        this.f9289h.setDefaultImageView(Boolean.TRUE);
        if (value == CameraSwitchMode.PHOTO) {
            if (this.f9286e) {
                this.f9289h.setVisibility(4);
                TextView textView = this.f9290i;
                textView.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView, 4);
            } else {
                K0();
                AfterCaptureCircleImageView afterCaptureCircleImageView = this.f9289h;
                final kotlin.jvm.b.l<? super View, kotlin.u> lVar = this.L;
                afterCaptureCircleImageView.setOnClickListener(lVar == null ? null : new View.OnClickListener() { // from class: us.pinguo.camera2020.view.e0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CameraBottomViewController.I0(kotlin.jvm.b.l.this, view);
                    }
                });
                this.f9289h.setVisibility(0);
                this.f9290i.setText(R.string.album);
                TextView textView2 = this.f9290i;
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
            }
        } else {
            this.f9289h.setImageResource(this.C ? R.drawable.ic_music_dark : R.drawable.ic_music_light);
            AfterCaptureCircleImageView afterCaptureCircleImageView2 = this.f9289h;
            final kotlin.jvm.b.l<? super View, kotlin.u> lVar2 = this.K;
            afterCaptureCircleImageView2.setOnClickListener(lVar2 == null ? null : new View.OnClickListener() { // from class: us.pinguo.camera2020.view.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CameraBottomViewController.J0(kotlin.jvm.b.l.this, view);
                }
            });
            this.f9289h.setVisibility(0);
            this.f9290i.setText(R.string.music);
            TextView textView3 = this.f9290i;
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
        }
        this.f9291j.setVisibility(0);
        this.f9291j.setImageResource(this.C ? R.drawable.ic_beauty_dark : R.drawable.ic_beauty_light);
        TextView textView4 = this.f9292k;
        textView4.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView4, 0);
        this.f9293l.setVisibility(0);
        this.f9293l.setImageResource(this.C ? R.drawable.ic_sticker_dark : R.drawable.ic_sticker_light);
        TextView textView5 = this.m;
        textView5.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView5, 0);
        this.m.setText(R.string.sticker);
        this.n.setVisibility(0);
        this.n.setImageResource(this.C ? R.drawable.ic_filter_dark : R.drawable.ic_filter_light);
        TextView textView6 = this.o;
        textView6.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView6, 0);
        this.o.setText(R.string.filter);
        ImageView imageView = this.f9291j;
        final kotlin.jvm.b.l<? super View, kotlin.u> lVar3 = this.M;
        imageView.setOnClickListener(lVar3 == null ? null : new View.OnClickListener() { // from class: us.pinguo.camera2020.view.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraBottomViewController.F0(kotlin.jvm.b.l.this, view);
            }
        });
        ImageView imageView2 = this.f9293l;
        final kotlin.jvm.b.l<? super View, kotlin.u> lVar4 = this.N;
        imageView2.setOnClickListener(lVar4 == null ? null : new View.OnClickListener() { // from class: us.pinguo.camera2020.view.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraBottomViewController.G0(kotlin.jvm.b.l.this, view);
            }
        });
        ImageView imageView3 = this.n;
        final kotlin.jvm.b.l<? super View, kotlin.u> lVar5 = this.O;
        imageView3.setOnClickListener(lVar5 != null ? new View.OnClickListener() { // from class: us.pinguo.camera2020.view.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraBottomViewController.H0(kotlin.jvm.b.l.this, view);
            }
        } : null);
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (this.R) {
            ConstraintLayout functionArea = this.f9287f;
            kotlin.jvm.internal.s.g(functionArea, "functionArea");
            if (functionArea.getVisibility() == 0) {
                return false;
            }
            if (event.c() == EventType.TOUCH_UP || event.c() == EventType.DOUBLE_CLICK || event.c() == EventType.BACK_PRESS) {
                ShutterButton btShutter = this.f9288g;
                kotlin.jvm.internal.s.g(btShutter, "btShutter");
                if (btShutter.getVisibility() == 0) {
                    K(this, false, 1, null);
                    if (!(this.f9288g.getTranslationY() == 0.0f)) {
                        T0();
                    }
                } else {
                    M0();
                    if (this.f9288g.getTranslationY() == 0.0f) {
                        K(this, false, 1, null);
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final void F(int i2) {
        int i3 = this.p.getLayoutParams().height;
        int i4 = this.s;
        if (i4 == -1) {
            int[] iArr = new int[2];
            this.p.getLocationOnScreen(iArr);
            Context context = this.c.getContext();
            kotlin.jvm.internal.s.g(context, "cameraBottomView.context");
            i4 = (us.pinguo.util.h.g(context) - iArr[1]) - this.p.getLayoutParams().height;
            this.s = i4;
        }
        if (i2 <= i4) {
            ConstraintLayout layoutRecordTime = this.p;
            kotlin.jvm.internal.s.g(layoutRecordTime, "layoutRecordTime");
            ViewGroup.LayoutParams layoutParams = layoutRecordTime.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Context context2 = this.c.getContext();
            kotlin.jvm.internal.s.g(context2, "cameraBottomView.context");
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = us.pinguo.util.g.a(context2, 10.0f);
            layoutRecordTime.setLayoutParams(layoutParams2);
            this.r.setTextColor(-1907998);
            this.r.setShadowLayer(1.0f, 0.0f, 0.0f, Integer.MIN_VALUE);
        } else if (i2 > i4 && i2 < i3 + i4) {
            int i5 = i2 - i4;
            ConstraintLayout layoutRecordTime2 = this.p;
            kotlin.jvm.internal.s.g(layoutRecordTime2, "layoutRecordTime");
            ViewGroup.LayoutParams layoutParams3 = layoutRecordTime2.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            Context context3 = this.c.getContext();
            kotlin.jvm.internal.s.g(context3, "cameraBottomView.context");
            ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i5 + us.pinguo.util.g.a(context3, 10.0f);
            layoutRecordTime2.setLayoutParams(layoutParams4);
            this.r.setTextColor(-1907998);
            this.r.setShadowLayer(1.0f, 0.0f, 0.0f, Integer.MIN_VALUE);
        } else {
            ConstraintLayout layoutRecordTime3 = this.p;
            kotlin.jvm.internal.s.g(layoutRecordTime3, "layoutRecordTime");
            ViewGroup.LayoutParams layoutParams5 = layoutRecordTime3.getLayoutParams();
            Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
            Context context4 = this.c.getContext();
            kotlin.jvm.internal.s.g(context4, "cameraBottomView.context");
            ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = us.pinguo.util.g.a(context4, 10.0f);
            layoutRecordTime3.setLayoutParams(layoutParams6);
            this.r.setTextColor(-12959668);
            this.r.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // us.pinguo.common.h
    public int G() {
        return h.a.h(this);
    }

    public final void H() {
        float f2 = this.H;
        ShutterButton shutterButton = this.f9288g;
        if (Float.isNaN(f2)) {
            Context b2 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b2, "getAppContext()");
            f2 = (this.c.getLayoutParams().height - (this.f9287f.getLayoutParams().height * 0.5f)) - (this.Q + us.pinguo.util.g.b(b2, 31.0f));
            this.H = f2;
        }
        float f3 = this.I;
        if (shutterButton.getScaleX() == f3) {
            if (shutterButton.getScaleY() == f3) {
                if (shutterButton.getTranslationY() == f2) {
                    return;
                }
            }
        }
        shutterButton.animate().scaleX(f3).scaleY(f3).translationY(f2).setDuration(200L).start();
    }

    public final void I(boolean z) {
        if (this.f9285d == CameraLaunchMode.NORMAL) {
            CameraModeSwitchLayout cameraModeSwitchLayout = this.u;
            cameraModeSwitchLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 0);
        }
        ConstraintLayout functionArea = this.f9287f;
        kotlin.jvm.internal.s.g(functionArea, "functionArea");
        if (functionArea.getVisibility() == 0) {
            return;
        }
        if (z) {
            this.f9287f.animate().alpha(1.0f).setDuration(200L).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.i0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraBottomViewController.L(CameraBottomViewController.this);
                }
            }).start();
            if (!(this.f9287f.getTranslationY() == 0.0f)) {
                this.f9287f.animate().translationY(0.0f).setDuration(200L).start();
            }
        } else {
            this.f9287f.setTranslationY(0.0f);
            ConstraintLayout functionArea2 = this.f9287f;
            kotlin.jvm.internal.s.g(functionArea2, "functionArea");
            functionArea2.setVisibility(0);
            VdsAgent.onSetViewVisibility(functionArea2, 0);
        }
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.P;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Boolean.TRUE);
    }

    @Override // us.pinguo.common.h
    public void J(boolean z) {
        h.a.b(this, z);
    }

    public final void L0() {
        K0();
        R0();
    }

    public final void M(boolean z) {
        CameraModeSwitchLayout cameraModeSwitchLayout = this.u;
        cameraModeSwitchLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 4);
        ConstraintLayout functionArea = this.f9287f;
        kotlin.jvm.internal.s.g(functionArea, "functionArea");
        if (functionArea.getVisibility() == 4) {
            return;
        }
        if (z) {
            this.f9287f.animate().alpha(0.0f).setDuration(100L).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.b0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraBottomViewController.P(CameraBottomViewController.this);
                }
            }).start();
        } else {
            ConstraintLayout functionArea2 = this.f9287f;
            kotlin.jvm.internal.s.g(functionArea2, "functionArea");
            functionArea2.setVisibility(4);
            VdsAgent.onSetViewVisibility(functionArea2, 4);
        }
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.P;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Boolean.FALSE);
    }

    public final void M0() {
        final ShutterButton shutterButton = this.f9288g;
        if (shutterButton == null) {
            return;
        }
        if (shutterButton.getVisibility() == 0) {
            return;
        }
        shutterButton.animate().alpha(1.0f).setDuration(200L).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.z
            @Override // java.lang.Runnable
            public final void run() {
                CameraBottomViewController.N0(ShutterButton.this);
            }
        }).start();
    }

    @Override // us.pinguo.common.h
    public int O() {
        return h.a.i(this);
    }

    public final void O0() {
        final ShutterButton shutterButton = this.f9288g;
        if (shutterButton == null) {
            return;
        }
        if (shutterButton.getVisibility() == 0) {
            shutterButton.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.l0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraBottomViewController.P0(ShutterButton.this);
                }
            }).start();
        }
    }

    public final kotlin.jvm.b.l<View, kotlin.u> R() {
        return this.M;
    }

    public final int S() {
        return this.D;
    }

    public final void T(boolean z) {
        this.R = false;
        CameraModeSwitchLayout cameraModeSwitchLayout = this.u;
        cameraModeSwitchLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(cameraModeSwitchLayout, 8);
        if (z) {
            this.f9287f.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.h0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraBottomViewController.U(CameraBottomViewController.this);
                }
            }).setDuration(100L).start();
            return;
        }
        this.f9291j.setVisibility(4);
        TextView textView = this.f9292k;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    public final void T0() {
        ShutterButton shutterButton = this.f9288g;
        if (shutterButton.getScaleX() == 1.0f) {
            if (shutterButton.getScaleY() == 1.0f) {
                if (shutterButton.getTranslationY() == 0.0f) {
                    return;
                }
            }
        }
        shutterButton.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(200L).start();
    }

    public final void U0() {
        CameraSwitchMode value = this.b.a().getValue();
        if (value == null) {
            value = CameraSwitchMode.PHOTO;
        }
        kotlin.jvm.internal.s.g(value, "cameraBottomModule.camer…?: CameraSwitchMode.PHOTO");
        if (value == CameraSwitchMode.PHOTO && this.R) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.b(), null, new CameraBottomViewController$updateAlbumIcon$1(this, null), 2, null);
        }
    }

    public final boolean V() {
        return this.B;
    }

    public final void W0(boolean z) {
        kotlinx.coroutines.v1 d2;
        this.B = z;
        this.S = System.currentTimeMillis();
        if (z) {
            this.f9288g.setProgress(0.0f);
            ConstraintLayout constraintLayout = this.p;
            constraintLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout, 0);
            View view = this.q;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            if (this.z) {
                this.f9288g.setState(ShutterButtonDrawable.State.VIDEO_LONG_TOUCH);
            } else {
                this.f9288g.setState(ShutterButtonDrawable.State.VIDEO_TIMER_RECORD);
            }
            d2 = kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new CameraBottomViewController$updateRecordState$1(this, null), 2, null);
            this.w = d2;
            return;
        }
        this.y.removeCallbacks(this.V);
        ConstraintLayout constraintLayout2 = this.p;
        constraintLayout2.setVisibility(4);
        VdsAgent.onSetViewVisibility(constraintLayout2, 4);
        kotlinx.coroutines.v1 v1Var = this.w;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        if (this.b.a().getValue() == CameraSwitchMode.MOVIE) {
            this.f9288g.setState(ShutterButtonDrawable.State.VIDEO);
        } else {
            this.f9288g.setState(ShutterButtonDrawable.State.CAMERA);
        }
    }

    @Override // us.pinguo.svideo.c.e
    public void a() {
        W0(false);
        r2 r2Var = this.v;
        if (r2Var != null) {
            r2Var.a();
        }
        this.V.b(true);
        this.A = SystemClock.elapsedRealtime();
    }

    @Override // us.pinguo.svideo.c.e
    public void b(VideoInfo videoInfo) {
        kotlin.jvm.internal.s.h(videoInfo, "videoInfo");
        r2 r2Var = this.v;
        if (r2Var != null) {
            r2Var.b(videoInfo);
        }
        this.A = SystemClock.elapsedRealtime();
        this.y.postDelayed(new Runnable() { // from class: us.pinguo.camera2020.view.d0
            @Override // java.lang.Runnable
            public final void run() {
                CameraBottomViewController.p0(CameraBottomViewController.this);
            }
        }, 600L);
    }

    @Override // us.pinguo.svideo.c.e
    public void c() {
        this.E = SystemClock.elapsedRealtime();
        this.V.b(false);
        this.y.removeCallbacks(this.V);
        this.y.postDelayed(this.V, 16L);
        W0(true);
        r2 r2Var = this.v;
        if (r2Var != null) {
            r2Var.c();
        }
        this.A = SystemClock.elapsedRealtime();
    }

    @Override // us.pinguo.svideo.c.e
    public void d(Throwable error) {
        kotlin.jvm.internal.s.h(error, "error");
        W0(false);
        r2 r2Var = this.v;
        if (r2Var != null) {
            r2Var.a();
        }
        r2 r2Var2 = this.v;
        if (r2Var2 != null) {
            r2Var2.h();
        }
        this.V.b(true);
        this.T = true;
        Toast makeText = Toast.makeText(us.pinguo.util.v.a(), R.string.record_failed, 1);
        makeText.show();
        VdsAgent.showToast(makeText);
        this.A = SystemClock.elapsedRealtime();
    }

    @Override // us.pinguo.common.h
    public void h(boolean z) {
        h.a.d(this, z);
    }

    @Override // us.pinguo.common.h
    public void i(boolean z) {
        h.a.e(this, z);
    }

    public final void o0() {
        this.t = this.f9288g.v();
        this.f9288g.setState(ShutterButtonDrawable.State.CAMERA_TIMER);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0025, code lost:
        if (r8 != 3) goto L14;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.CameraBottomViewController.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // us.pinguo.common.h
    public void p(boolean z) {
        this.C = z;
        CameraSwitchMode value = this.b.a().getValue();
        if (value == null) {
            value = CameraSwitchMode.PHOTO;
        }
        kotlin.jvm.internal.s.g(value, "cameraBottomModule.camer…?: CameraSwitchMode.PHOTO");
        this.f9289h.setDefaultImageView(Boolean.TRUE);
        if (value == CameraSwitchMode.PHOTO) {
            K0();
        } else {
            this.f9289h.setImageResource(z ? R.drawable.ic_music_dark : R.drawable.ic_music_light);
        }
        this.f9291j.setImageResource(z ? R.drawable.ic_beauty_dark : R.drawable.ic_beauty_light);
        this.f9293l.setImageResource(z ? R.drawable.ic_sticker_dark : R.drawable.ic_sticker_light);
        this.n.setImageResource(z ? R.drawable.ic_filter_dark : R.drawable.ic_filter_light);
        int parseColor = z ? Color.parseColor("#FF3A404D") : -1;
        this.f9290i.setTextColor(parseColor);
        this.f9292k.setTextColor(parseColor);
        this.m.setTextColor(parseColor);
        this.o.setTextColor(parseColor);
        if (this.C) {
            this.f9290i.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.f9292k.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.m.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.o.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        } else {
            int parseColor2 = Color.parseColor("#FF000000");
            this.f9290i.setShadowLayer(1.0f, 0.0f, 0.0f, parseColor2);
            this.f9292k.setShadowLayer(1.0f, 0.0f, 0.0f, parseColor2);
            this.m.setShadowLayer(1.0f, 0.0f, 0.0f, parseColor2);
            this.o.setShadowLayer(1.0f, 0.0f, 0.0f, parseColor2);
        }
        this.f9288g.setTransparentMode(!this.C);
        this.u.setStyle(z);
    }

    public final void q0() {
        this.T = true;
        ShutterButtonDrawable.State state = this.t;
        if (state == null) {
            return;
        }
        this.f9288g.setState(state);
    }

    public final void r0() {
        this.t = this.f9288g.v();
        this.f9288g.setState(ShutterButtonDrawable.State.VIDEO_TIMER);
    }

    @Override // us.pinguo.common.h
    public boolean s() {
        return this.R;
    }

    public final void s0() {
        this.G = null;
    }

    public final void t0(int i2) {
        this.Q = i2;
    }

    public final void u0(String str) {
        this.F = str;
    }

    public final void v0(kotlin.jvm.b.l<? super View, kotlin.u> lVar) {
        this.L = lVar;
    }

    @Override // us.pinguo.common.h
    public void w(int i2) {
        h.a.a(this, i2);
    }

    public final void w0(kotlin.jvm.b.l<? super View, kotlin.u> lVar) {
        this.M = lVar;
    }

    @Override // us.pinguo.common.h
    public int x() {
        return this.c.getLayoutParams().height;
    }

    public final void x0(kotlin.jvm.b.l<? super View, kotlin.u> lVar) {
        this.O = lVar;
    }

    public final void y0(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        this.P = lVar;
    }

    public final void z0(kotlin.jvm.b.l<? super View, kotlin.u> lVar) {
        this.K = lVar;
    }
}
