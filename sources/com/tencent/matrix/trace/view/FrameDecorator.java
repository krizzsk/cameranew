package com.tencent.matrix.trace.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.facebook.ads.AdError;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.listeners.IAppForeground;
import com.tencent.matrix.trace.R;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.listeners.IDoFrameListener;
import com.tencent.matrix.trace.tracer.FrameTracer;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.util.Objects;
import java.util.concurrent.Executor;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes3.dex */
public class FrameDecorator extends IDoFrameListener implements IAppForeground {
    private static final String TAG = "Matrix.FrameDecorator";
    private static FrameDecorator instance;
    private int belongColor;
    private int bestColor;
    private View.OnClickListener clickListener;
    private DisplayMetrics displayMetrics;
    private int[] dropLevel;
    private Executor executor;
    private float frameIntervalMs;
    private int frozenColor;
    private Handler handler;
    private int highColor;
    private boolean isEnable;
    private boolean isShowing;
    private long[] lastCost;
    private long[] lastFrames;
    private String lastVisibleScene;
    private WindowManager.LayoutParams layoutParam;
    private float maxFps;
    private int middleColor;
    private int normalColor;
    private int[] sumDropLevel;
    private long sumFrameCost;
    private long sumFrames;
    private Runnable updateDefaultRunnable;
    private FloatFrameView view;
    private WindowManager windowManager;
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Object lock = new Object();

    /* loaded from: classes3.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            TracePlugin tracePlugin;
            MatrixLog.i(FrameDecorator.TAG, "onViewAttachedToWindow", new Object[0]);
            if (!Matrix.isInstalled() || (tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class)) == null) {
                return;
            }
            tracePlugin.getFrameTracer().addListener(FrameDecorator.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            TracePlugin tracePlugin;
            MatrixLog.i(FrameDecorator.TAG, "onViewDetachedFromWindow", new Object[0]);
            if (!Matrix.isInstalled() || (tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class)) == null) {
                return;
            }
            tracePlugin.getFrameTracer().removeListener(FrameDecorator.this);
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnTouchListener {
        float a = 0.0f;
        float b = 0.0f;
        int c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f8113d = 0;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FloatFrameView f8114e;

        /* loaded from: classes3.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View a;

            a(View view) {
                this.a = view;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (FrameDecorator.this.isShowing) {
                    FrameDecorator.this.layoutParam.x = ((Integer) valueAnimator.getAnimatedValue("trans")).intValue();
                    FrameDecorator.this.windowManager.updateViewLayout(this.a, FrameDecorator.this.layoutParam);
                }
            }
        }

        b(FloatFrameView floatFrameView) {
            this.f8114e = floatFrameView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = FrameDecorator.this.layoutParam.x;
                this.f8113d = FrameDecorator.this.layoutParam.y;
            } else if (action == 1) {
                int[] iArr = new int[2];
                iArr[0] = FrameDecorator.this.layoutParam.x;
                iArr[1] = FrameDecorator.this.layoutParam.x > FrameDecorator.this.displayMetrics.widthPixels / 2 ? FrameDecorator.this.displayMetrics.widthPixels - this.f8114e.getWidth() : 0;
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("trans", iArr));
                ofPropertyValuesHolder.addUpdateListener(new a(view));
                ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                ofPropertyValuesHolder.setDuration(180L).start();
                int i2 = FrameDecorator.this.layoutParam.x;
                int i3 = FrameDecorator.this.layoutParam.y;
                if (Math.abs(i2 - this.c) <= 20 && Math.abs(i3 - this.f8113d) <= 20 && FrameDecorator.this.clickListener != null) {
                    FrameDecorator.this.clickListener.onClick(view);
                }
            } else if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                WindowManager.LayoutParams layoutParams = FrameDecorator.this.layoutParam;
                layoutParams.x = (int) (layoutParams.x + ((x - this.a) / 3.0f));
                WindowManager.LayoutParams layoutParams2 = FrameDecorator.this.layoutParam;
                layoutParams2.y = (int) (layoutParams2.y + ((y - this.b) / 3.0f));
                if (view != null) {
                    FrameDecorator.this.windowManager.updateViewLayout(view, FrameDecorator.this.layoutParam);
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameDecorator.this.view.fpsView.setText(String.format("%.2f FPS", Float.valueOf(FrameDecorator.this.maxFps)));
            FrameDecorator.this.view.fpsView.setTextColor(FrameDecorator.this.view.getResources().getColor(R.color.level_best_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        final /* synthetic */ FloatFrameView a;
        final /* synthetic */ float b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f8116d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f8117e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f8118f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f8119g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f8120h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f8121i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f8122j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ String f8123k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ String f8124l;
        final /* synthetic */ String m;
        final /* synthetic */ String n;

        d(FrameDecorator frameDecorator, FloatFrameView floatFrameView, float f2, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
            this.a = floatFrameView;
            this.b = f2;
            this.c = i2;
            this.f8116d = str;
            this.f8117e = str2;
            this.f8118f = str3;
            this.f8119g = str4;
            this.f8120h = str5;
            this.f8121i = str6;
            this.f8122j = str7;
            this.f8123k = str8;
            this.f8124l = str9;
            this.m = str10;
            this.n = str11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.chartView.addFps((int) this.b, this.c);
            this.a.fpsView.setText(this.f8116d);
            this.a.fpsView.setTextColor(this.c);
            this.a.qiWangView.setText(this.f8117e);
            this.a.levelFrozenView.setText(this.f8118f);
            this.a.levelHighView.setText(this.f8119g);
            this.a.levelMiddleView.setText(this.f8120h);
            this.a.levelNormalView.setText(this.f8121i);
            this.a.sumQiWangView.setText(this.f8122j);
            this.a.sumLevelFrozenView.setText(this.f8123k);
            this.a.sumLevelHighView.setText(this.f8124l);
            this.a.sumLevelMiddleView.setText(this.m);
            this.a.sumLevelNormalView.setText(this.n);
        }
    }

    /* loaded from: classes3.dex */
    class e implements Executor {
        e() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            FrameDecorator.this.getHandler().post(runnable);
        }
    }

    /* loaded from: classes3.dex */
    static class f implements Runnable {
        final /* synthetic */ Context a;

        f(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameDecorator unused = FrameDecorator.instance = new FrameDecorator(this.a, new FloatFrameView(this.a), null);
            synchronized (FrameDecorator.lock) {
                FrameDecorator.lock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrameDecorator.this.isShowing) {
                return;
            }
            FrameDecorator.this.isShowing = true;
            FrameDecorator.this.windowManager.addView(FrameDecorator.this.view, FrameDecorator.this.layoutParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrameDecorator.this.isShowing) {
                FrameDecorator.this.isShowing = false;
                FrameDecorator.this.windowManager.removeView(FrameDecorator.this.view);
            }
        }
    }

    /* loaded from: classes3.dex */
    class i implements Runnable {
        final /* synthetic */ boolean a;

        i(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                FrameDecorator.this.show();
            } else {
                FrameDecorator.this.dismiss();
            }
        }
    }

    /* synthetic */ FrameDecorator(Context context, FloatFrameView floatFrameView, a aVar) {
        this(context, floatFrameView);
    }

    public static FrameDecorator get() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getHandler() {
        Handler handler = this.handler;
        if ((handler == null || !handler.getLooper().getThread().isAlive()) && MatrixHandlerThread.getDefaultHandlerThread() != null) {
            this.handler = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper());
        }
        return this.handler;
    }

    public static FrameDecorator getInstance(Context context) {
        if (instance == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                instance = new FrameDecorator(context, new FloatFrameView(context));
            } else {
                try {
                    Object obj = lock;
                    synchronized (obj) {
                        mainHandler.post(new f(context));
                        obj.wait();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return instance;
    }

    private void initLayoutParams(Context context) {
        this.windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (this.windowManager.getDefaultDisplay() != null) {
                this.windowManager.getDefaultDisplay().getMetrics(this.displayMetrics);
                this.windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.layoutParam = layoutParams;
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = AdError.CACHE_ERROR_CODE;
            }
            layoutParams.flags = 40;
            layoutParams.gravity = 8388659;
            FloatFrameView floatFrameView = this.view;
            if (floatFrameView != null) {
                layoutParams.x = displayMetrics.widthPixels - (floatFrameView.getLayoutParams().width * 2);
            }
            WindowManager.LayoutParams layoutParams2 = this.layoutParam;
            layoutParams2.y = 0;
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.format = -2;
        } catch (Exception unused) {
        }
    }

    private void updateView(FloatFrameView floatFrameView, float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i3 + i4 + i5 + i6;
        float f3 = i11 <= 0 ? 0.0f : ((i6 * 1.0f) / i11) * 60.0f;
        float f4 = i11 <= 0 ? 0.0f : ((i5 * 1.0f) / i11) * 25.0f;
        float f5 = i11 <= 0 ? 0.0f : ((i4 * 1.0f) / i11) * 14.0f;
        float f6 = i11 <= 0 ? 0.0f : ((i3 * 1.0f) / i11) * 1.0f;
        float f7 = f3 + f4 + f5 + f6;
        int i12 = i7 + i8 + i9 + i10;
        float f8 = i12 <= 0 ? 0.0f : ((i10 * 1.0f) / i12) * 60.0f;
        float f9 = i12 <= 0 ? 0.0f : ((i9 * 1.0f) / i12) * 25.0f;
        float f10 = i12 <= 0 ? 0.0f : ((i8 * 1.0f) / i12) * 14.0f;
        float f11 = i12 > 0 ? ((i7 * 1.0f) / i12) * 1.0f : 0.0f;
        String format = String.format("%.1f", Float.valueOf(f3));
        String format2 = String.format("%.1f", Float.valueOf(f4));
        String format3 = String.format("%.1f", Float.valueOf(f5));
        String format4 = String.format("%.1f", Float.valueOf(f6));
        mainHandler.post(new d(this, floatFrameView, f2, i2, String.format("%.2f FPS", Float.valueOf(f2)), String.format("current: %.1f", Float.valueOf(f7)), format, format2, format3, format4, String.format("sum: %.1f", Float.valueOf(f8 + f9 + f10 + f11)), String.format("%.1f", Float.valueOf(f8)), String.format("%.1f", Float.valueOf(f9)), String.format("%.1f", Float.valueOf(f10)), String.format("%.1f", Float.valueOf(f11))));
    }

    public void dismiss() {
        if (this.isEnable) {
            mainHandler.post(new h());
        }
    }

    @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
    public void doFrameAsync(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
        super.doFrameAsync(str, j2, j3, i2, z, j4, j5, j6, j7);
        if (!Objects.equals(str, this.lastVisibleScene)) {
            this.dropLevel = new int[FrameTracer.DropStatus.values().length];
            this.lastVisibleScene = str;
            this.lastCost[0] = 0;
            this.lastFrames[0] = 0;
        }
        long j8 = ((float) this.sumFrameCost) + ((i2 + 1) * this.frameIntervalMs);
        this.sumFrameCost = j8;
        long j9 = this.sumFrames + 1;
        this.sumFrames = j9;
        float f2 = (float) (j8 - this.lastCost[0]);
        if (i2 >= 42) {
            int[] iArr = this.dropLevel;
            int i3 = FrameTracer.DropStatus.DROPPED_FROZEN.index;
            iArr[i3] = iArr[i3] + 1;
            int[] iArr2 = this.sumDropLevel;
            iArr2[i3] = iArr2[i3] + 1;
            this.belongColor = this.frozenColor;
        } else if (i2 >= 24) {
            int[] iArr3 = this.dropLevel;
            int i4 = FrameTracer.DropStatus.DROPPED_HIGH.index;
            iArr3[i4] = iArr3[i4] + 1;
            int[] iArr4 = this.sumDropLevel;
            iArr4[i4] = iArr4[i4] + 1;
            if (this.belongColor != this.frozenColor) {
                this.belongColor = this.highColor;
            }
        } else if (i2 >= 9) {
            int[] iArr5 = this.dropLevel;
            int i5 = FrameTracer.DropStatus.DROPPED_MIDDLE.index;
            iArr5[i5] = iArr5[i5] + 1;
            int[] iArr6 = this.sumDropLevel;
            iArr6[i5] = iArr6[i5] + 1;
            int i6 = this.belongColor;
            if (i6 != this.frozenColor && i6 != this.highColor) {
                this.belongColor = this.middleColor;
            }
        } else if (i2 >= 3) {
            int[] iArr7 = this.dropLevel;
            int i7 = FrameTracer.DropStatus.DROPPED_NORMAL.index;
            iArr7[i7] = iArr7[i7] + 1;
            int[] iArr8 = this.sumDropLevel;
            iArr8[i7] = iArr8[i7] + 1;
            int i8 = this.belongColor;
            if (i8 != this.frozenColor && i8 != this.highColor && i8 != this.middleColor) {
                this.belongColor = this.normalColor;
            }
        } else {
            int[] iArr9 = this.dropLevel;
            int i9 = FrameTracer.DropStatus.DROPPED_BEST.index;
            iArr9[i9] = iArr9[i9] + 1;
            int[] iArr10 = this.sumDropLevel;
            iArr10[i9] = iArr10[i9] + 1;
            int i10 = this.belongColor;
            if (i10 != this.frozenColor && i10 != this.highColor && i10 != this.middleColor && i10 != this.normalColor) {
                this.belongColor = this.bestColor;
            }
        }
        long j10 = j9 - this.lastFrames[0];
        if (f2 >= 200.0f) {
            float min = Math.min(this.maxFps, (((float) j10) * 1000.0f) / f2);
            FloatFrameView floatFrameView = this.view;
            int i11 = this.belongColor;
            int[] iArr11 = this.dropLevel;
            int i12 = FrameTracer.DropStatus.DROPPED_NORMAL.index;
            int i13 = iArr11[i12];
            int i14 = FrameTracer.DropStatus.DROPPED_MIDDLE.index;
            int i15 = iArr11[i14];
            int i16 = FrameTracer.DropStatus.DROPPED_HIGH.index;
            int i17 = iArr11[i16];
            int i18 = FrameTracer.DropStatus.DROPPED_FROZEN.index;
            int i19 = iArr11[i18];
            int[] iArr12 = this.sumDropLevel;
            updateView(floatFrameView, min, i11, i13, i15, i17, i19, iArr12[i12], iArr12[i14], iArr12[i16], iArr12[i18]);
            this.belongColor = this.bestColor;
            this.lastCost[0] = this.sumFrameCost;
            this.lastFrames[0] = this.sumFrames;
            mainHandler.removeCallbacks(this.updateDefaultRunnable);
            mainHandler.postDelayed(this.updateDefaultRunnable, 250L);
        }
    }

    @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
    public Executor getExecutor() {
        return this.executor;
    }

    public FloatFrameView getView() {
        return this.view;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    @Override // com.tencent.matrix.listeners.IAppForeground
    public void onForeground(boolean z) {
        Handler handler;
        MatrixLog.i(TAG, "[onForeground] isForeground:%s", Boolean.valueOf(z));
        if (this.isEnable && (handler = mainHandler) != null) {
            handler.post(new i(z));
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setExtraInfo(String str) {
        TextView textView;
        if (getView() == null || (textView = (TextView) getView().findViewById(R.id.extra_info)) == null) {
            return;
        }
        textView.setText(str);
    }

    public void show() {
        if (this.isEnable) {
            mainHandler.post(new g());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private FrameDecorator(Context context, FloatFrameView floatFrameView) {
        this.displayMetrics = new DisplayMetrics();
        this.isEnable = true;
        this.lastCost = new long[1];
        this.belongColor = this.bestColor;
        this.lastFrames = new long[1];
        this.dropLevel = new int[FrameTracer.DropStatus.values().length];
        this.sumDropLevel = new int[FrameTracer.DropStatus.values().length];
        this.lastVisibleScene = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        this.updateDefaultRunnable = new c();
        this.executor = new e();
        float frameIntervalNanos = (((float) UIThreadMonitor.getMonitor().getFrameIntervalNanos()) * 1.0f) / 1000000.0f;
        this.frameIntervalMs = frameIntervalNanos;
        float round = Math.round(1000.0f / frameIntervalNanos);
        this.maxFps = round;
        this.view = floatFrameView;
        floatFrameView.fpsView.setText(String.format("%.2f FPS", Float.valueOf(round)));
        this.bestColor = context.getResources().getColor(R.color.level_best_color);
        this.normalColor = context.getResources().getColor(R.color.level_normal_color);
        this.middleColor = context.getResources().getColor(R.color.level_middle_color);
        this.highColor = context.getResources().getColor(R.color.level_high_color);
        this.frozenColor = context.getResources().getColor(R.color.level_frozen_color);
        AppActiveMatrixDelegate.INSTANCE.addListener(this);
        floatFrameView.addOnAttachStateChangeListener(new a());
        initLayoutParams(context);
        floatFrameView.setOnTouchListener(new b(floatFrameView));
    }
}
