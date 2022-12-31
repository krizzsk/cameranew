package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String s = LottieAnimationView.class.getSimpleName();
    private static final i<Throwable> t = new a();
    private final i<e> a;
    private final i<Throwable> b;
    @Nullable
    private i<Throwable> c;
    @DrawableRes

    /* renamed from: d  reason: collision with root package name */
    private int f325d;

    /* renamed from: e  reason: collision with root package name */
    private final g f326e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f327f;

    /* renamed from: g  reason: collision with root package name */
    private String f328g;
    @RawRes

    /* renamed from: h  reason: collision with root package name */
    private int f329h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f330i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f331j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f332k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f333l;
    private boolean m;
    private RenderMode n;
    private Set<k> o;
    private int p;
    @Nullable
    private n<e> q;
    @Nullable
    private e r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;
        int b;
        float c;

        /* renamed from: d  reason: collision with root package name */
        boolean f334d;

        /* renamed from: e  reason: collision with root package name */
        String f335e;

        /* renamed from: f  reason: collision with root package name */
        int f336f;

        /* renamed from: g  reason: collision with root package name */
        int f337g;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.f334d ? 1 : 0);
            parcel.writeString(this.f335e);
            parcel.writeInt(this.f336f);
            parcel.writeInt(this.f337g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            this.f334d = parcel.readInt() == 1;
            this.f335e = parcel.readString();
            this.f336f = parcel.readInt();
            this.f337g = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements i<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.i
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (com.airbnb.lottie.w.h.k(th)) {
                com.airbnb.lottie.w.d.d("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* loaded from: classes.dex */
    class b implements i<e> {
        b() {
        }

        @Override // com.airbnb.lottie.i
        /* renamed from: a */
        public void onResult(e eVar) {
            LottieAnimationView.this.setComposition(eVar);
        }
    }

    /* loaded from: classes.dex */
    class c implements i<Throwable> {
        c() {
        }

        @Override // com.airbnb.lottie.i
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f325d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f325d);
            }
            (LottieAnimationView.this.c == null ? LottieAnimationView.t : LottieAnimationView.this.c).onResult(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.a = new b();
        this.b = new c();
        this.f325d = 0;
        this.f326e = new g();
        this.f330i = false;
        this.f331j = false;
        this.f332k = false;
        this.f333l = false;
        this.m = true;
        this.n = RenderMode.AUTOMATIC;
        this.o = new HashSet();
        this.p = 0;
        l(null);
    }

    private void g() {
        n<e> nVar = this.q;
        if (nVar != null) {
            nVar.k(this.a);
            this.q.j(this.b);
        }
    }

    private void h() {
        this.r = null;
        this.f326e.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
        if (r3 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.d.a
            com.airbnb.lottie.RenderMode r1 = r5.n
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L3d
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = 1
            goto L3d
        L15:
            com.airbnb.lottie.e r0 = r5.r
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.p()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L3b
        L27:
            com.airbnb.lottie.e r0 = r5.r
            if (r0 == 0) goto L33
            int r0 = r0.l()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L3b
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L3a
            goto L3b
        L3a:
            r3 = 1
        L3b:
            if (r3 == 0) goto L13
        L3d:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L47
            r0 = 0
            r5.setLayerType(r1, r0)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.j():void");
    }

    private void l(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        if (!isInEditMode()) {
            this.m = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            int i2 = R.styleable.LottieAnimationView_lottie_rawRes;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            int i3 = R.styleable.LottieAnimationView_lottie_fileName;
            boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
            int i4 = R.styleable.LottieAnimationView_lottie_url;
            boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(i3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f332k = true;
            this.f333l = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f326e.d0(-1);
        }
        int i5 = R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        i(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i8 = R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i8)) {
            e(new com.airbnb.lottie.model.d("**"), l.C, new com.airbnb.lottie.x.c(new q(obtainStyledAttributes.getColor(i8, 0))));
        }
        int i9 = R.styleable.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f326e.g0(obtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i10)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i11 = obtainStyledAttributes.getInt(i10, renderMode.ordinal());
            if (i11 >= RenderMode.values().length) {
                i11 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i11]);
        }
        if (getScaleType() != null) {
            this.f326e.h0(getScaleType());
        }
        obtainStyledAttributes.recycle();
        this.f326e.j0(Boolean.valueOf(com.airbnb.lottie.w.h.f(getContext()) != 0.0f));
        j();
        this.f327f = true;
    }

    private void t(n<e> nVar) {
        h();
        g();
        nVar.f(this.a);
        nVar.e(this.b);
        this.q = nVar;
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        com.airbnb.lottie.d.a("buildDrawingCache");
        this.p++;
        super.buildDrawingCache(z);
        if (this.p == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.p--;
        com.airbnb.lottie.d.b("buildDrawingCache");
    }

    public void d(Animator.AnimatorListener animatorListener) {
        this.f326e.c(animatorListener);
    }

    public <T> void e(com.airbnb.lottie.model.d dVar, T t2, com.airbnb.lottie.x.c<T> cVar) {
        this.f326e.d(dVar, t2, cVar);
    }

    @MainThread
    public void f() {
        this.f332k = false;
        this.f331j = false;
        this.f330i = false;
        this.f326e.f();
        j();
    }

    public void i(boolean z) {
        this.f326e.k(z);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        g gVar = this.f326e;
        if (drawable2 == gVar) {
            super.invalidateDrawable(gVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float k() {
        return this.f326e.w();
    }

    public boolean m() {
        return this.f326e.D();
    }

    @Deprecated
    public void n(boolean z) {
        this.f326e.d0(z ? -1 : 0);
    }

    @MainThread
    public void o() {
        this.f333l = false;
        this.f332k = false;
        this.f331j = false;
        this.f330i = false;
        this.f326e.F();
        j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f333l || this.f332k) {
            p();
            this.f333l = false;
            this.f332k = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m()) {
            f();
            this.f332k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.a;
        this.f328g = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f328g);
        }
        int i2 = savedState.b;
        this.f329h = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.c);
        if (savedState.f334d) {
            p();
        }
        this.f326e.Q(savedState.f335e);
        setRepeatMode(savedState.f336f);
        setRepeatCount(savedState.f337g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f328g;
        savedState.b = this.f329h;
        savedState.c = this.f326e.w();
        savedState.f334d = this.f326e.D() || (!ViewCompat.isAttachedToWindow(this) && this.f332k);
        savedState.f335e = this.f326e.s();
        savedState.f336f = this.f326e.y();
        savedState.f337g = this.f326e.x();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        if (this.f327f) {
            if (isShown()) {
                if (this.f331j) {
                    s();
                } else if (this.f330i) {
                    p();
                }
                this.f331j = false;
                this.f330i = false;
            } else if (m()) {
                o();
                this.f331j = true;
            }
        }
    }

    @MainThread
    public void p() {
        if (isShown()) {
            this.f326e.G();
            j();
            return;
        }
        this.f330i = true;
    }

    public void q() {
        this.f326e.H();
    }

    public void r(Animator.AnimatorListener animatorListener) {
        this.f326e.I(animatorListener);
    }

    @MainThread
    public void s() {
        if (isShown()) {
            this.f326e.K();
            j();
            return;
        }
        this.f330i = false;
        this.f331j = true;
    }

    public void setAnimation(@RawRes int i2) {
        this.f329h = i2;
        this.f328g = null;
        t(this.m ? f.l(getContext(), i2) : f.m(getContext(), i2, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        t(this.m ? f.p(getContext(), str) : f.q(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f326e.L(z);
    }

    public void setCacheComposition(boolean z) {
        this.m = z;
    }

    public void setComposition(@NonNull e eVar) {
        if (com.airbnb.lottie.d.a) {
            String str = s;
            Log.v(str, "Set Composition \n" + eVar);
        }
        this.f326e.setCallback(this);
        this.r = eVar;
        boolean M = this.f326e.M(eVar);
        j();
        if (getDrawable() != this.f326e || M) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (k kVar : this.o) {
                kVar.a(eVar);
            }
        }
    }

    public void setFailureListener(@Nullable i<Throwable> iVar) {
        this.c = iVar;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.f325d = i2;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f326e.N(bVar);
    }

    public void setFrame(int i2) {
        this.f326e.O(i2);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.c cVar) {
        this.f326e.P(cVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f326e.Q(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        g();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        g();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        g();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f326e.R(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f326e.T(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f326e.V(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.f326e.X(f2, f3);
    }

    public void setMinFrame(int i2) {
        this.f326e.Y(i2);
    }

    public void setMinProgress(float f2) {
        this.f326e.a0(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f326e.b0(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f326e.c0(f2);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.n = renderMode;
        j();
    }

    public void setRepeatCount(int i2) {
        this.f326e.d0(i2);
    }

    public void setRepeatMode(int i2) {
        this.f326e.e0(i2);
    }

    public void setSafeMode(boolean z) {
        this.f326e.f0(z);
    }

    public void setScale(float f2) {
        this.f326e.g0(f2);
        if (getDrawable() == this.f326e) {
            setImageDrawable(null);
            setImageDrawable(this.f326e);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        g gVar = this.f326e;
        if (gVar != null) {
            gVar.h0(scaleType);
        }
    }

    public void setSpeed(float f2) {
        this.f326e.i0(f2);
    }

    public void setTextDelegate(s sVar) {
        this.f326e.k0(sVar);
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f326e.S(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.f326e.W(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.f326e.Z(str);
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        this.f326e.U(i2, i3);
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        t(f.q(getContext(), str, str2));
    }

    public void setAnimation(String str) {
        this.f328g = str;
        this.f329h = 0;
        t(this.m ? f.d(getContext(), str) : f.e(getContext(), str, null));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        t(f.g(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.b = new c();
        this.f325d = 0;
        this.f326e = new g();
        this.f330i = false;
        this.f331j = false;
        this.f332k = false;
        this.f333l = false;
        this.m = true;
        this.n = RenderMode.AUTOMATIC;
        this.o = new HashSet();
        this.p = 0;
        l(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new b();
        this.b = new c();
        this.f325d = 0;
        this.f326e = new g();
        this.f330i = false;
        this.f331j = false;
        this.f332k = false;
        this.f333l = false;
        this.m = true;
        this.n = RenderMode.AUTOMATIC;
        this.o = new HashSet();
        this.p = 0;
        l(attributeSet);
    }
}
