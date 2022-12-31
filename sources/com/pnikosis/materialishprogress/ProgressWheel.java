package com.pnikosis.materialishprogress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes3.dex */
public class ProgressWheel extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7079d;

    /* renamed from: e  reason: collision with root package name */
    private double f7080e;

    /* renamed from: f  reason: collision with root package name */
    private double f7081f;

    /* renamed from: g  reason: collision with root package name */
    private float f7082g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7083h;

    /* renamed from: i  reason: collision with root package name */
    private long f7084i;

    /* renamed from: j  reason: collision with root package name */
    private int f7085j;

    /* renamed from: k  reason: collision with root package name */
    private int f7086k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f7087l;
    private Paint m;
    private RectF n;
    private float o;
    private long p;
    private boolean q;
    private float r;
    private float s;
    private boolean t;
    private b u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new a();
        float a;
        float b;
        boolean c;

        /* renamed from: d  reason: collision with root package name */
        float f7088d;

        /* renamed from: e  reason: collision with root package name */
        int f7089e;

        /* renamed from: f  reason: collision with root package name */
        int f7090f;

        /* renamed from: g  reason: collision with root package name */
        int f7091g;

        /* renamed from: h  reason: collision with root package name */
        int f7092h;

        /* renamed from: i  reason: collision with root package name */
        int f7093i;

        /* renamed from: j  reason: collision with root package name */
        boolean f7094j;

        /* renamed from: k  reason: collision with root package name */
        boolean f7095k;

        /* loaded from: classes3.dex */
        static class a implements Parcelable.Creator<WheelSavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public WheelSavedState[] newArray(int i2) {
                return new WheelSavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f7088d);
            parcel.writeInt(this.f7089e);
            parcel.writeInt(this.f7090f);
            parcel.writeInt(this.f7091g);
            parcel.writeInt(this.f7092h);
            parcel.writeInt(this.f7093i);
            parcel.writeByte(this.f7094j ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f7095k ? (byte) 1 : (byte) 0);
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.c = parcel.readByte() != 0;
            this.f7088d = parcel.readFloat();
            this.f7089e = parcel.readInt();
            this.f7090f = parcel.readInt();
            this.f7091g = parcel.readInt();
            this.f7092h = parcel.readInt();
            this.f7093i = parcel.readInt();
            this.f7094j = parcel.readByte() != 0;
            this.f7095k = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(float f2);
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 28;
        this.b = 4;
        this.c = 4;
        this.f7079d = false;
        this.f7080e = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f7081f = 460.0d;
        this.f7082g = 0.0f;
        this.f7083h = true;
        this.f7084i = 0L;
        this.f7085j = -1442840576;
        this.f7086k = ViewCompat.MEASURED_SIZE_MASK;
        this.f7087l = new Paint();
        this.m = new Paint();
        this.n = new RectF();
        this.o = 230.0f;
        this.p = 0L;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        a(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
        d();
    }

    private void a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.b = (int) TypedValue.applyDimension(1, this.b, displayMetrics);
        this.c = (int) TypedValue.applyDimension(1, this.c, displayMetrics);
        int applyDimension = (int) TypedValue.applyDimension(1, this.a, displayMetrics);
        this.a = applyDimension;
        this.a = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_circleRadius, applyDimension);
        this.f7079d = typedArray.getBoolean(R.styleable.ProgressWheel_matProg_fillRadius, false);
        this.b = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_barWidth, this.b);
        this.c = (int) typedArray.getDimension(R.styleable.ProgressWheel_matProg_rimWidth, this.c);
        this.o = typedArray.getFloat(R.styleable.ProgressWheel_matProg_spinSpeed, this.o / 360.0f) * 360.0f;
        this.f7081f = typedArray.getInt(R.styleable.ProgressWheel_matProg_barSpinCycleTime, (int) this.f7081f);
        this.f7085j = typedArray.getColor(R.styleable.ProgressWheel_matProg_barColor, this.f7085j);
        this.f7086k = typedArray.getColor(R.styleable.ProgressWheel_matProg_rimColor, this.f7086k);
        this.q = typedArray.getBoolean(R.styleable.ProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(R.styleable.ProgressWheel_matProg_progressIndeterminate, false)) {
            g();
        }
        typedArray.recycle();
    }

    private void b() {
        if (this.u != null) {
            this.u.b(Math.round((this.r * 100.0f) / 360.0f) / 100.0f);
        }
    }

    private void c(float f2) {
        b bVar = this.u;
        if (bVar != null) {
            bVar.b(f2);
        }
    }

    @TargetApi(17)
    private void d() {
        float f2;
        if (Build.VERSION.SDK_INT >= 17) {
            f2 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f2 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        this.v = f2 != 0.0f;
    }

    private void e(int i2, int i3) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.f7079d) {
            int i4 = (i2 - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i4, (i3 - paddingBottom) - paddingTop), (this.a * 2) - (this.b * 2));
            int i5 = ((i4 - min) / 2) + paddingLeft;
            int i6 = ((((i3 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i7 = this.b;
            this.n = new RectF(i5 + i7, i6 + i7, (i5 + min) - i7, (i6 + min) - i7);
            return;
        }
        int i8 = this.b;
        this.n = new RectF(paddingLeft + i8, paddingTop + i8, (i2 - paddingRight) - i8, (i3 - paddingBottom) - i8);
    }

    private void f() {
        this.f7087l.setColor(this.f7085j);
        this.f7087l.setAntiAlias(true);
        this.f7087l.setStyle(Paint.Style.STROKE);
        this.f7087l.setStrokeWidth(this.b);
        this.m.setColor(this.f7086k);
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.c);
    }

    private void h(long j2) {
        long j3 = this.f7084i;
        if (j3 >= 200) {
            double d2 = this.f7080e + j2;
            this.f7080e = d2;
            double d3 = this.f7081f;
            if (d2 > d3) {
                this.f7080e = d2 - d3;
                this.f7084i = 0L;
                this.f7083h = !this.f7083h;
            }
            float cos = (((float) Math.cos(((this.f7080e / d3) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f7083h) {
                this.f7082g = cos * 254.0f;
                return;
            }
            float f2 = (1.0f - cos) * 254.0f;
            this.r += this.f7082g - f2;
            this.f7082g = f2;
            return;
        }
        this.f7084i = j3 + j2;
    }

    public void g() {
        this.p = SystemClock.uptimeMillis();
        this.t = true;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        canvas.drawArc(this.n, 360.0f, 360.0f, false, this.m);
        if (this.v) {
            float f4 = 0.0f;
            boolean z = true;
            if (this.t) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.p;
                h(uptimeMillis);
                float f5 = this.r + ((((float) uptimeMillis) * this.o) / 1000.0f);
                this.r = f5;
                if (f5 > 360.0f) {
                    this.r = f5 - 360.0f;
                    c(-1.0f);
                }
                this.p = SystemClock.uptimeMillis();
                float f6 = this.r - 90.0f;
                float f7 = this.f7082g + 16.0f;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f3 = 135.0f;
                } else {
                    f2 = f6;
                    f3 = f7;
                }
                canvas.drawArc(this.n, f2, f3, false, this.f7087l);
            } else {
                float f8 = this.r;
                if (f8 != this.s) {
                    this.r = Math.min(this.r + ((((float) (SystemClock.uptimeMillis() - this.p)) / 1000.0f) * this.o), this.s);
                    this.p = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (f8 != this.r) {
                    b();
                }
                float f9 = this.r;
                if (!this.q) {
                    float pow = ((float) (1.0d - Math.pow(1.0f - (this.r / 360.0f), 2.0f))) * 360.0f;
                    f4 = ((float) (1.0d - Math.pow(1.0f - (f9 / 360.0f), 4.0f))) * 360.0f;
                    f9 = pow;
                }
                canvas.drawArc(this.n, f4 - 90.0f, isInEditMode() ? 360.0f : f9, false, this.f7087l);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int paddingLeft = this.a + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.a + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.r = wheelSavedState.a;
        this.s = wheelSavedState.b;
        this.t = wheelSavedState.c;
        this.o = wheelSavedState.f7088d;
        this.b = wheelSavedState.f7089e;
        this.f7085j = wheelSavedState.f7090f;
        this.c = wheelSavedState.f7091g;
        this.f7086k = wheelSavedState.f7092h;
        this.a = wheelSavedState.f7093i;
        this.q = wheelSavedState.f7094j;
        this.f7079d = wheelSavedState.f7095k;
        this.p = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.a = this.r;
        wheelSavedState.b = this.s;
        wheelSavedState.c = this.t;
        wheelSavedState.f7088d = this.o;
        wheelSavedState.f7089e = this.b;
        wheelSavedState.f7090f = this.f7085j;
        wheelSavedState.f7091g = this.c;
        wheelSavedState.f7092h = this.f7086k;
        wheelSavedState.f7093i = this.a;
        wheelSavedState.f7094j = this.q;
        wheelSavedState.f7095k = this.f7079d;
        return wheelSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        e(i2, i3);
        f();
        invalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            this.p = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i2) {
        this.f7085j = i2;
        f();
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i2) {
        this.b = i2;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setCallback(b bVar) {
        this.u = bVar;
        if (this.t) {
            return;
        }
        b();
    }

    public void setCircleRadius(int i2) {
        this.a = i2;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f2) {
        if (this.t) {
            this.r = 0.0f;
            this.t = false;
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 == this.s) {
            return;
        }
        float min = Math.min(f2 * 360.0f, 360.0f);
        this.s = min;
        this.r = min;
        this.p = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z) {
        this.q = z;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f2) {
        if (this.t) {
            this.r = 0.0f;
            this.t = false;
            b();
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = this.s;
        if (f2 == f3) {
            return;
        }
        if (this.r == f3) {
            this.p = SystemClock.uptimeMillis();
        }
        this.s = Math.min(f2 * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i2) {
        this.f7086k = i2;
        f();
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i2) {
        this.c = i2;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f2) {
        this.o = f2 * 360.0f;
    }

    public ProgressWheel(Context context) {
        super(context);
        this.a = 28;
        this.b = 4;
        this.c = 4;
        this.f7079d = false;
        this.f7080e = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f7081f = 460.0d;
        this.f7082g = 0.0f;
        this.f7083h = true;
        this.f7084i = 0L;
        this.f7085j = -1442840576;
        this.f7086k = ViewCompat.MEASURED_SIZE_MASK;
        this.f7087l = new Paint();
        this.m = new Paint();
        this.n = new RectF();
        this.o = 230.0f;
        this.p = 0L;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        d();
    }
}
