package us.pinguo.edit2020.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.SizeF;
import android.view.TextureView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
import kotlin.z.j;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.androidsdk.PGNativeMethod;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.controller.a3;
import us.pinguo.edit2020.model.e.g;
import us.pinguo.foundation.e;
import us.pinguo.foundation.statistics.h;
import us.pinguo.libblingbling.BlingBling;
import us.pinguo.nativeinterface.UnityInterface;
import us.pinguo.performance.manager.PerformanceLevelManager;
import us.pinguo.processor.PreviewProcessState;
import us.pinguo.processor.ShaderCache;
import us.pinguo.processor.i;
import us.pinguo.repository2020.utils.k;
import us.pinguo.repository2020.utils.n;
import us.pinguo.u3dengine.Module;
import us.pinguo.u3dengine.UnityControlCaller;
import us.pinguo.u3dengine.api.BlingBlingTextureInfo;
import us.pinguo.u3dengine.api.EngineMode;
import us.pinguo.u3dengine.api.MakeupMaterial;
import us.pinguo.u3dengine.api.NativeFacesData;
import us.pinguo.u3dengine.api.UnityFilterCallbackApi;
import us.pinguo.u3dengine.api.UnityFilterMethodCallback;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.BrushBuilder;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.HSLAdjustColor;
import us.pinguo.u3dengine.edit.NativeFilterRet;
import us.pinguo.u3dengine.edit.UnityEditCallback;
import us.pinguo.u3dengine.edit.UnityEditCallbackApi;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.util.m;
/* compiled from: EditRender.kt */
/* loaded from: classes4.dex */
public final class EditRender implements UnityEditCallbackApi, UnityFilterCallbackApi, UnityInterface.b {
    private static final EditModel[] h0 = {EditModel.ManualDeformation, EditModel.Brush, EditModel.SpotRemove, EditModel.SoftSkin, EditModel.Makeup, EditModel.MagicBackground, EditModel.StaticSticker, EditModel.BackgroundBlur};
    private r<? super Float, ? super Float, ? super Float, ? super Float, u> A;
    private kotlin.jvm.b.a<u> B;
    private kotlin.jvm.b.a<u> C;
    private l<? super String, u> D;
    private l<? super Float, u> E;
    private w<? super String, ? super Integer, ? super Integer, ? super Float, ? super Float, ? super Integer, ? super Integer, ? super Integer, ? super Integer, u> F;
    private w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> G;
    private w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> H;
    private q<? super String, ? super Boolean, ? super Boolean, u> I;
    private l<? super EditModel, u> J;
    private kotlin.jvm.b.b<? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> K;
    private kotlin.jvm.b.a<u> L;
    private kotlin.jvm.b.a<u> M;
    private s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> N;
    private s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> O;
    private us.pinguo.edit2020.b.a Q;
    private Boolean V;
    private volatile Size a;
    private kotlin.jvm.b.a<u> a0;
    private volatile Size b;
    private kotlin.jvm.b.a<u> b0;
    private String c;
    private l<? super Boolean, u> c0;
    private final int d0;

    /* renamed from: e  reason: collision with root package name */
    private l<? super Boolean, u> f10539e;
    private v<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> e0;

    /* renamed from: f  reason: collision with root package name */
    private volatile c f10540f;
    private t<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> f0;

    /* renamed from: g  reason: collision with root package name */
    private volatile d f10541g;
    private p<? super Boolean, ? super Boolean, u> g0;

    /* renamed from: h  reason: collision with root package name */
    private volatile b f10542h;

    /* renamed from: i  reason: collision with root package name */
    private NativeFilterRet f10543i;

    /* renamed from: j  reason: collision with root package name */
    private volatile us.pinguo.processor.d f10544j;

    /* renamed from: l  reason: collision with root package name */
    private l<? super EditModel, u> f10546l;
    private volatile int m;
    private volatile int n;
    private volatile int o;
    private boolean p;
    private a3 r;
    private kotlin.jvm.b.a<u> s;
    private kotlin.jvm.b.a<u> t;
    private us.pinguo.edit2020.model.a u;
    private long v;
    private t<? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> w;
    private l<? super Bitmap, u> x;
    private l<? super Bitmap, u> y;
    private l<? super Bitmap, u> z;

    /* renamed from: d  reason: collision with root package name */
    private final String f10538d = e.b().getCacheDir().getAbsolutePath() + ((Object) File.separator) + "temp.jpeg";

    /* renamed from: k  reason: collision with root package name */
    private final BlingBlingTextureInfo f10545k = new BlingBlingTextureInfo(0, 0, 0, 0, 15, null);
    private us.pinguo.repository2020.u<u0> q = new us.pinguo.repository2020.u<>();
    private us.pinguo.repository2020.u<us.pinguo.facedetector.c> P = new us.pinguo.repository2020.u<>();
    private final g R = new g();
    private final g S = new g();
    private String T = "";
    private EditModel U = EditModel.Normal;
    private final us.pinguo.edit2020.bean.l[] W = {new us.pinguo.edit2020.bean.l(0, 0, 0, 7, null), new us.pinguo.edit2020.bean.l(0, 0, 0, 7, null)};
    private final m X = new m(false);
    private float Y = 0.8f;
    private final AtomicInteger Z = new AtomicInteger(0);

    /* compiled from: EditRender.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditModel.values().length];
            iArr[EditModel.Brush.ordinal()] = 1;
            iArr[EditModel.SpotRemove.ordinal()] = 2;
            iArr[EditModel.MagicBackground.ordinal()] = 3;
            iArr[EditModel.StaticSticker.ordinal()] = 4;
            iArr[EditModel.BackgroundBlur.ordinal()] = 5;
            iArr[EditModel.SoftSkin.ordinal()] = 6;
            iArr[EditModel.Makeup.ordinal()] = 7;
            iArr[EditModel.ManualDeformation.ordinal()] = 8;
            a = iArr;
        }
    }

    public EditRender() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        j.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.d0 = !p1();
    }

    private final boolean p(String str) {
        List<String> p0;
        us.pinguo.common.log.a.q(kotlin.jvm.internal.s.q("start check:", str), new Object[0]);
        p0 = StringsKt__StringsKt.p0(str, new String[]{" "}, false, 0, 6, null);
        for (String str2 : p0) {
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (kotlin.jvm.internal.s.c(lowerCase, "gl_arm_shader_framebuffer_fetch")) {
                us.pinguo.common.log.a.c("support gl_arm_shader_framebuffer_fetch", new Object[0]);
                return true;
            }
            String lowerCase2 = str2.toLowerCase(locale);
            kotlin.jvm.internal.s.g(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (kotlin.jvm.internal.s.c(lowerCase2, "gl_ext_shader_framebuffer_fetch")) {
                us.pinguo.common.log.a.c("support gl_ext_shader_framebuffer_fetch", new Object[0]);
                return true;
            }
        }
        us.pinguo.common.log.a.c("not support shader_framebuffer_fetch", new Object[0]);
        return false;
    }

    private final void q1() {
        if (this.R.e()) {
            l<? super Boolean, u> lVar = this.f10539e;
            if (lVar == null) {
                return;
            }
            lVar.invoke(Boolean.FALSE);
            return;
        }
        int dimensionPixelOffset = us.pinguo.util.v.a().getResources().getDimensionPixelOffset(R.dimen.magnifier_width);
        UnityEditCaller.Common common = UnityEditCaller.Common.INSTANCE;
        Size size = new Size(dimensionPixelOffset, dimensionPixelOffset);
        float f2 = dimensionPixelOffset;
        common.requestMagnifierTexture(size, new SizeF(f2, f2));
    }

    private final void u(NativeFilterRet nativeFilterRet) {
        UnityEditCaller.Filter.updateEditFilter(nativeFilterRet.getTid(), nativeFilterRet.getWidth(), nativeFilterRet.getHeight(), true);
    }

    public static /* synthetic */ void v0(EditRender editRender, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        editRender.u0(str, z, z2);
    }

    public final EditModel A() {
        return this.U;
    }

    public final void A0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        UnityEditCaller.Filter.setFilterTemplateIntensity(f2);
    }

    public final l<Bitmap, u> B() {
        return this.z;
    }

    public final void B0(l<? super Bitmap, u> lVar) {
        this.z = lVar;
    }

    public final Size C() {
        return this.b;
    }

    public final void C0(TextureView textureView) {
        kotlin.jvm.internal.s.h(textureView, "textureView");
        this.S.o(textureView);
    }

    public final l<Boolean, u> D() {
        return this.c0;
    }

    public final void D0(a3 a3Var) {
        this.r = a3Var;
    }

    public final kotlin.jvm.b.a<u> E() {
        return this.b0;
    }

    public final void E0(l<? super Bitmap, u> lVar) {
        this.x = lVar;
    }

    public final long F() {
        return this.v;
    }

    public final void F0(Size size) {
        this.b = size;
    }

    public final l<Bitmap, u> G() {
        return this.y;
    }

    public final void G0(TextureView textureView, l<? super Boolean, u> lVar) {
        kotlin.jvm.internal.s.h(textureView, "textureView");
        this.f10539e = lVar;
        this.R.o(textureView);
    }

    public final AtomicInteger H() {
        return this.Z;
    }

    public final void H0(int i2, float f2, float f3, float f4, float f5) {
        UnityEditCaller.Makeup.setMakeupBaseInfo(i2, f2, f3, f4, f5);
    }

    public final s<String, Float, Float, Float, Float, u> I() {
        return this.O;
    }

    public final void I0(kotlin.jvm.b.a<u> aVar) {
        this.t = aVar;
    }

    public final s<String, Float, Float, Float, Float, u> J() {
        return this.N;
    }

    public final void J0(l<? super EditModel, u> lVar) {
        this.J = lVar;
    }

    public final Size K() {
        return this.a;
    }

    public final void K0(BrushBuilder brushBuilder) {
        kotlin.jvm.internal.s.h(brushBuilder, "brushBuilder");
        UnityEditCaller.Mosaic.setBrush(brushBuilder);
    }

    public final us.pinguo.repository2020.u<u0> L() {
        return this.q;
    }

    public final void L0(w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> wVar) {
        this.G = wVar;
    }

    public final boolean M() {
        return this.p;
    }

    public final void M0(r<? super Float, ? super Float, ? super Float, ? super Float, u> rVar) {
        this.A = rVar;
    }

    public final void N(boolean z) {
        UnityEditCaller.BackgroundBlur.hideBokehUnmarkedArea(z);
    }

    public final void N0(w<? super String, ? super Integer, ? super Integer, ? super Float, ? super Float, ? super Integer, ? super Integer, ? super Integer, ? super Integer, u> wVar) {
        this.F = wVar;
    }

    public final void O() {
        UnityControlCaller.setEngineMode(EngineMode.EDIT, Module.EDIT);
        UnityControlCaller.setCurrentLanguage$default(null, 1, null);
        UnityEditCaller.Common.INSTANCE.setDebugMode(us.pinguo.foundation.d.f10987f);
        UnityEditCallback.registerImpl(this);
        UnityFilterMethodCallback.registerImpl(this);
        k.a.b();
        i.a.l(ShaderCache.a.a());
        this.R.c();
        this.S.c();
    }

    public final void O0(l<? super Boolean, u> lVar) {
        this.c0 = lVar;
    }

    public final void P() {
        UnityEditCaller.BackgroundBlur.inverseBokehMask();
    }

    public final void P0(kotlin.jvm.b.a<u> aVar) {
        this.b0 = aVar;
    }

    public final Boolean Q() {
        return this.V;
    }

    public final void Q0(kotlin.jvm.b.a<u> aVar) {
        this.M = aVar;
    }

    public final boolean R() {
        boolean C;
        C = StringsKt__StringsKt.C(this.T, "GL_EXT_blend_minmax", false, 2, null);
        return C;
    }

    public final void R0(kotlin.jvm.b.a<u> aVar) {
        this.L = aVar;
    }

    public final void S() {
        UnityEditCaller.BackgroundBlur.renderBokehEffect();
    }

    public final void S0(w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> wVar) {
        this.H = wVar;
    }

    public final void T(int i2, MakeupMaterial theme) {
        kotlin.jvm.internal.s.h(theme, "theme");
        UnityEditCaller.Makeup.setEditCustomMakeup$default(i2, theme, null, 4, null);
    }

    public final void T0(us.pinguo.edit2020.b.a aVar) {
        this.Q = aVar;
    }

    public final void U(int i2, List<MakeupMaterial> theme, float f2) {
        kotlin.jvm.internal.s.h(theme, "theme");
        UnityEditCaller.Makeup.renderEditStyleMakeup(i2, theme, f2);
    }

    public final void U0(long j2) {
        this.v = j2;
    }

    public final void V() {
        UnityEditCaller.BackgroundBlur.requestBokehIconTextureWithCurrentBokehValue();
    }

    public final void V0(float f2) {
        UnityEditCaller.Crop.setPerspectiveX(f2);
    }

    public final void W() {
        g.m(this.S, null, 1, null);
    }

    public final void W0(float f2) {
        UnityEditCaller.Crop.setPerspectiveY(f2);
    }

    public final void X(RectF rectF) {
        kotlin.jvm.internal.s.h(rectF, "rectF");
        float f2 = 1;
        UnityEditCaller.Crop.resetAllCrop(rectF.left, f2 - rectF.top, rectF.right, f2 - rectF.bottom);
    }

    public final void X0(l<? super Bitmap, u> lVar) {
        this.y = lVar;
    }

    public final void Y(String maskPath) {
        kotlin.jvm.internal.s.h(maskPath, "maskPath");
        UnityEditCaller.BackgroundBlur.resetBokehMask(maskPath);
    }

    public final void Y0(String key, float f2) {
        kotlin.jvm.internal.s.h(key, "key");
        UnityEditCaller.SoftSkin.setRefreshSkinManaulOpacity(key, f2);
    }

    public final void Z(float f2, float f3, float f4, float f5) {
        float f6 = 1;
        UnityEditCaller.Crop.INSTANCE.rotateCCW90(f2, f6 - f3, f4, f6 - f5);
    }

    public final void Z0(kotlin.jvm.b.a<u> aVar) {
        this.C = aVar;
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void a() {
        us.pinguo.processor.d dVar;
        NativeFilterRet nativeFilterRet;
        us.pinguo.common.log.a.d(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, "glMakeOnlineFilter", new Object[0]);
        b bVar = this.f10542h;
        if (bVar == null || (dVar = this.f10544j) == null) {
            return;
        }
        i iVar = i.a;
        boolean i2 = iVar.i(dVar);
        us.pinguo.edit2020.model.a aVar = this.u;
        if (aVar != null) {
            aVar.b(i2);
        }
        Pair<Integer, String> h2 = iVar.h(bVar.c(), new Size(bVar.d(), bVar.a()), dVar, false, i2);
        if (h2.getFirst().intValue() == 0) {
            nativeFilterRet = new NativeFilterRet(0, 0, 0);
        } else {
            nativeFilterRet = new NativeFilterRet(h2.getFirst().intValue(), bVar.d(), bVar.a());
        }
        this.f10543i = nativeFilterRet;
        u(nativeFilterRet);
        z0(1.0f);
        us.pinguo.edit2020.model.a aVar2 = this.u;
        if (aVar2 != null) {
            aVar2.a();
        }
        iVar.j(PreviewProcessState.COMPLETE);
    }

    public final void a0(float f2, float f3, float f4, float f5) {
        float f6 = 1;
        UnityEditCaller.Crop.INSTANCE.rotateCW90(f2, f6 - f3, f4, f6 - f5);
    }

    public final void a1(kotlin.jvm.b.a<u> aVar) {
        this.B = aVar;
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void b() {
        try {
            String glGetString = GLES20.glGetString(7939);
            if (glGetString == null) {
                glGetString = "";
            }
            this.T = glGetString;
            if (this.V == null) {
                this.V = Boolean.valueOf(p(glGetString));
            }
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("isSupport shader_framebuffer_fetch:", this.V), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(kotlin.coroutines.Continuation<? super kotlin.u> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof us.pinguo.edit2020.model.EditRender$save$1
            if (r0 == 0) goto L13
            r0 = r5
            us.pinguo.edit2020.model.EditRender$save$1 r0 = (us.pinguo.edit2020.model.EditRender$save$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.edit2020.model.EditRender$save$1 r0 = new us.pinguo.edit2020.model.EditRender$save$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            us.pinguo.edit2020.model.EditRender r0 = (us.pinguo.edit2020.model.EditRender) r0
            kotlin.j.b(r5)
            goto L76
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L39:
            kotlin.j.b(r5)
            us.pinguo.u3dengine.edit.EditModel r5 = r4.A()
            us.pinguo.u3dengine.edit.EditModel r2 = us.pinguo.u3dengine.edit.EditModel.Normal
            if (r5 != r2) goto L47
            kotlin.u r5 = kotlin.u.a
            return r5
        L47:
            kotlin.jvm.b.l<? super java.lang.Boolean, kotlin.u> r5 = r4.f10539e
            if (r5 != 0) goto L4c
            goto L54
        L4c:
            r2 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r5.invoke(r2)
        L54:
            android.content.Context r5 = us.pinguo.util.v.a()
            java.lang.String r2 = "pgEditCache"
            java.io.File r5 = us.pinguo.foundation.n.a.a(r5, r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r2 = "getDiskCacheDir(\n       …              .toString()"
            kotlin.jvm.internal.s.g(r5, r2)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r0 = us.pinguo.util.FileUtils.f(r5, r0)
            if (r0 != r1) goto L74
            return r1
        L74:
            r0 = r4
            r1 = r5
        L76:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = java.io.File.separator
            r5.append(r1)
            java.util.UUID r1 = java.util.UUID.randomUUID()
            r5.append(r1)
            java.lang.String r1 = ".jpg"
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.util.concurrent.atomic.AtomicInteger r0 = r0.H()
            r0.incrementAndGet()
            us.pinguo.u3dengine.edit.UnityEditCaller.Common.requestFinalRenderedTexture(r5)
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.model.EditRender.b0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b1(us.pinguo.edit2020.model.a aVar) {
        this.u = aVar;
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void c() {
        us.pinguo.edit2020.bean.l lVar = this.W[1];
        Bitmap e2 = us.pinguo.processor.b.e(lVar.b(), new Size(lVar.c(), lVar.a()), true);
        l<Bitmap, u> G = G();
        if (G == null) {
            return;
        }
        G.invoke(e2);
    }

    public final void c0(t<? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> tVar) {
        this.w = tVar;
    }

    public final void c1(kotlin.jvm.b.a<u> aVar) {
        this.a0 = aVar;
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void d() {
        this.R.b();
    }

    public final void d0(kotlin.jvm.b.b<? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> bVar) {
        this.K = bVar;
    }

    public final void d1(float f2) {
        UnityEditCaller.Crop.setScaleX(f2);
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void e() {
        Bitmap e2 = us.pinguo.processor.b.e(this.m, new Size(this.n, this.o), true);
        l<? super Bitmap, u> lVar = this.x;
        if (lVar != null) {
            lVar.invoke(e2);
        }
        us.pinguo.common.log.a.c("glEditUpdate", new Object[0]);
    }

    public final void e0(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8) {
        UnityEditCaller.BackgroundBlur.setBokehAdjustmentAdjustValue(f2, f3, f4, f5, f6, f7, f8);
    }

    public final void e1(float f2) {
        UnityEditCaller.Crop.setScaleY(f2);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public NativeFacesData editUpdateFaceData(int i2, int i3, int i4) {
        String str = this.c;
        if (str == null) {
            return new NativeFacesData();
        }
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("face result sourcePath:", str), new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        us.pinguo.facedetector.c c = us.pinguo.edit2020.manager.e.a.c(str);
        if (c == null) {
            return new NativeFacesData();
        }
        us.pinguo.facedetector.c b = us.pinguo.repository2020.utils.i.b(c);
        if (b.c() == 1 && this.U == EditModel.AutoDeformation) {
            UnityEditCaller.AutoDeformation.setAutoDeformationFaceIndex(0);
        }
        us.pinguo.facedetector.c.b(b, BaseBlurEffect.ROTATION_180, true, 0, 0, 12, null);
        b.i();
        us.pinguo.common.log.a.c("face result:" + b.c() + "   time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return us.pinguo.repository2020.utils.i.d(b, false, true);
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void f() {
        c cVar = this.f10540f;
        if (cVar == null) {
            return;
        }
        d dVar = this.f10541g;
        if (dVar == null) {
            dVar = new d(cVar.e(), cVar.b(), us.pinguo.processor.b.c());
            this.f10541g = dVar;
        } else if (dVar.c() != cVar.e() || dVar.a() != cVar.b()) {
            us.pinguo.processor.b.d(dVar.b());
            dVar = new d(cVar.e(), cVar.b(), us.pinguo.processor.b.c());
            this.f10541g = dVar;
        }
        PGNativeMethod.spotDetectedForUnity(cVar.d(), cVar.e(), cVar.b(), cVar.a(), dVar.b());
        cVar.c().countDown();
    }

    public final void f0(boolean z) {
        UnityEditCaller.BackgroundBlur.setBokehBrushEffectIsApplied(z);
    }

    public final void f1(int i2, String colorHex, int i3) {
        kotlin.jvm.internal.s.h(colorHex, "colorHex");
        UnityEditCaller.Makeup.setSelfDefMakeupColor(i2, colorHex, i3);
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void g() {
        this.S.b();
    }

    public final void g0(float f2) {
        UnityEditCaller.BackgroundBlur.INSTANCE.setBokehEffectQuality(f2);
    }

    public final void g1(int i2, int i3, float f2, float f3, boolean z) {
        UnityEditCaller.Makeup.setSelfDefMakeupValue(i2, i3, f2, f3, z);
    }

    @Override // us.pinguo.u3dengine.api.UnityFilterCallbackApi
    public long getBlingBlingRenderResult() {
        return BlingBling.getRenderResult();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public int getCustomSpotDetected() {
        CountDownLatch c;
        c cVar = this.f10540f;
        if (cVar != null && (c = cVar.c()) != null) {
            c.await();
        }
        d dVar = this.f10541g;
        this.f10540f = null;
        if (dVar == null) {
            return 0;
        }
        return dVar.b();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public boolean getFilterAdjustIs64Level() {
        Integer g2 = PerformanceLevelManager.a.g();
        return (g2 == null ? 0 : g2.intValue()) >= 90;
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public String getGLExtensions() {
        us.pinguo.common.log.a.d(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, kotlin.jvm.internal.s.q("getGLExtensions:", this.T), new Object[0]);
        return this.T;
    }

    @Override // us.pinguo.u3dengine.api.UnityFilterCallbackApi
    public int getNativeFilterResult() {
        CountDownLatch b;
        b bVar = this.f10542h;
        if (bVar != null && (b = bVar.b()) != null) {
            b.await();
        }
        us.pinguo.edit2020.model.a aVar = this.u;
        if (aVar != null) {
            aVar.a();
        }
        this.f10542h = null;
        i.a.j(PreviewProcessState.COMPLETE);
        NativeFilterRet nativeFilterRet = this.f10543i;
        if (nativeFilterRet == null) {
            return 0;
        }
        return nativeFilterRet.getTid();
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void glRenderBlingBlingFilter() {
        BlingBlingTextureInfo blingBlingTextureInfo = this.f10545k;
        BlingBling.render(blingBlingTextureInfo.getTid(), blingBlingTextureInfo.getWidth(), blingBlingTextureInfo.getHeight(), blingBlingTextureInfo.getMaxCount());
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void glRenderNativeFilter() {
        us.pinguo.processor.d dVar;
        NativeFilterRet nativeFilterRet;
        CountDownLatch b;
        us.pinguo.common.log.a.d(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, "glEditFilter", new Object[0]);
        b bVar = this.f10542h;
        if (bVar == null || (dVar = this.f10544j) == null) {
            return;
        }
        i iVar = i.a;
        boolean i2 = iVar.i(dVar);
        us.pinguo.edit2020.model.a aVar = this.u;
        if (aVar != null) {
            aVar.b(i2);
        }
        Pair<Integer, String> h2 = iVar.h(bVar.c(), new Size(bVar.d(), bVar.a()), dVar, false, i2);
        if (h2.getFirst().intValue() == 0) {
            nativeFilterRet = new NativeFilterRet(0, 0, 0);
        } else {
            nativeFilterRet = new NativeFilterRet(h2.getFirst().intValue(), bVar.d(), bVar.a());
        }
        this.f10543i = nativeFilterRet;
        b bVar2 = this.f10542h;
        if (bVar2 == null || (b = bVar2.b()) == null) {
            return;
        }
        b.countDown();
    }

    @Override // us.pinguo.nativeinterface.UnityInterface.b
    public void h() {
        us.pinguo.edit2020.bean.l lVar = this.W[0];
        Bitmap e2 = us.pinguo.processor.b.e(lVar.b(), new Size(lVar.c(), lVar.a()), true);
        l<Bitmap, u> B = B();
        if (B == null) {
            return;
        }
        B.invoke(e2);
    }

    public final void h0(String maskFilePath) {
        kotlin.jvm.internal.s.h(maskFilePath, "maskFilePath");
        UnityEditCaller.BackgroundBlur.setBokehMaskFile(maskFilePath);
    }

    public final void h1(s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> sVar) {
        this.O = sVar;
    }

    public final void i0(Float f2, Float f3, Float f4, Float f5, String str) {
        UnityEditCaller.BackgroundBlur.setBokehShapeAdjustmentAdjustValue(f2, f3, f4, f5, str);
    }

    public final void i1(s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> sVar) {
        this.N = sVar;
    }

    public final void j(int i2, int i3) {
        UnityEditCaller.Makeup.cancelSelfDefMakeup(i2, i3);
    }

    public final void j0(@ColorInt int i2) {
        UnityEditCaller.Brush.setBrushColor(i2);
    }

    public final void j1(q<? super String, ? super Boolean, ? super Boolean, u> qVar) {
        this.I = qVar;
    }

    public final void k(int i2) {
        UnityEditCaller.Makeup.cancelStyleMakeup(i2);
    }

    public final void k0(float f2) {
        UnityEditCaller.Brush.setBrushEffectIntensity(f2);
    }

    public final void k1(l<? super String, u> lVar) {
        this.D = lVar;
    }

    public final void l(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
        kotlin.jvm.internal.s.h(normalizedFocusPoint, "normalizedFocusPoint");
        kotlin.jvm.internal.s.h(normalizedOffset, "normalizedOffset");
        UnityEditCaller.Common.canvasAnimationTo(normalizedFocusPoint, f2, normalizedOffset, i2);
    }

    public final void l0(l<? super Float, u> lVar) {
        this.E = lVar;
    }

    public final void l1(float f2, float f3, boolean z) {
        UnityEditCaller.Makeup.setStyleMakeupFilterValue(f2, f3, z);
    }

    public final void m(String value) {
        kotlin.jvm.internal.s.h(value, "value");
        UnityEditCaller.Facial3d.setStereorectifyStrength(value);
    }

    public final void m0(float f2) {
        UnityEditCaller.Mosaic.setClassicMosaicGridSize(f2);
    }

    public final void m1(int i2, float f2, float f3, boolean z) {
        UnityEditCaller.Makeup.setStyleMakeupValue(i2, f2, f3, z);
    }

    public final void n(String mode) {
        kotlin.jvm.internal.s.h(mode, "mode");
        UnityEditCaller.SoftSkin.setRefreshSkinManaulMode(mode);
    }

    public final void n0(float f2, float f3, float f4, float f5, boolean z) {
        float f6 = 1;
        UnityEditCaller.Crop.setCropFrame(f2, f6 - f3, f4, f6 - f5, z);
    }

    public final void n1(boolean z) {
        this.p = z;
    }

    public final boolean o(EditModel editModel) {
        kotlin.jvm.internal.s.h(editModel, "editModel");
        UnityEditCaller.Common.changedToEditComponent(editModel);
        this.U = editModel;
        return true;
    }

    public final void o0(float f2) {
        UnityEditCaller.Crop.INSTANCE.setRotation(f2);
    }

    public final void o1(kotlin.jvm.b.a<u> aVar) {
        this.s = aVar;
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onCanvasTransformChanged(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        u0 value = this.q.getValue();
        if (value == null) {
            float sqrt = ((0.5f * f2) * 2.0f) / ((float) Math.sqrt((f6 * f6) + (f7 * f7)));
            if (sqrt >= 0.8f) {
                sqrt = 0.8f;
            }
            this.Y = sqrt;
            value = new u0(f2, f3, f4, f5, f6, f7, f8, f9, f10);
        } else {
            value.r(f2);
            value.q(f3);
            value.p(f4);
            value.o(f5);
            value.n(f6);
            value.m(f7);
            value.j(f8);
            value.k(f9);
            value.l(f10);
        }
        this.q.postValue(value);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onClipViewChanged(float f2, float f3, float f4, float f5) {
        r<? super Float, ? super Float, ? super Float, ? super Float, u> rVar = this.A;
        if (rVar == null) {
            return;
        }
        rVar.invoke(Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onEditCurrentTextureUpdate(int i2, int i3, int i4) {
        us.pinguo.common.log.a.k("onEditCurrentTextureUpdate, textureId=" + i2 + ", " + i3 + " x " + i4, new Object[0]);
        Size size = new Size(i3, i4);
        if (!kotlin.jvm.internal.s.c(this.a, size)) {
            this.a = size;
        }
        this.m = i2;
        this.n = i3;
        this.o = i4;
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onEditImagedSavedSuccess(String path, boolean z) {
        kotlin.jvm.internal.s.h(path, "path");
        us.pinguo.common.log.a.k("onEditImagedSavedSuccess:" + path + "    " + z, new Object[0]);
        us.pinguo.edit2020.b.a aVar = this.Q;
        if (aVar != null) {
            aVar.onEditImagedSavedSuccess(path, z);
        }
        this.c = path;
        this.P.postValue(us.pinguo.edit2020.manager.e.a.a(path, 0));
        this.Z.decrementAndGet();
        kotlin.jvm.b.a<u> aVar2 = this.a0;
        if (aVar2 == null) {
            return;
        }
        aVar2.invoke();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onEditMakeupInitRenderComplete() {
        us.pinguo.common.log.a.d(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, "onEditMakeupInitRenderComplete", new Object[0]);
        kotlin.jvm.b.a<u> aVar = this.t;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onMagicBackgroundItemStatusChanged(String key, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        kotlin.jvm.internal.s.h(key, "key");
        us.pinguo.common.log.a.c("onMagicBackgroundItemStatusChanged:key=" + key + ", normalizedSizeX=" + f2 + ", normalizedSizeY=" + f3 + ", normalizedCenterX=" + f4 + ", normalizedCenterY=" + f5 + ", rotateAngle=" + f6 + ", stickerStatus=" + i3, new Object[0]);
        w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> wVar = this.G;
        if (wVar == null) {
            return;
        }
        wVar.invoke(key, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onMagicBackgroundMattingMaskImagePrepared(String key, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3, int i4, int i5, float f8, float f9) {
        kotlin.jvm.internal.s.h(key, "key");
        us.pinguo.common.log.a.c("onMagicBackgroundMattingMaskImagePrepared:imageW=" + f2 + ", imageH=" + f3 + ", cutCenterX=" + f4 + ", cutCenterY=" + f5 + ", cutWidth=" + f6 + ", cutHeight=" + f7 + ", cutTexTid=" + i2 + ", maskWidth=" + i3 + ", maskHeight=" + i4 + ", maskTid=" + i5 + ", scaleX=" + f8 + ", scaleY=" + f9, new Object[0]);
        w<? super String, ? super Integer, ? super Integer, ? super Float, ? super Float, ? super Integer, ? super Integer, ? super Integer, ? super Integer, u> wVar = this.F;
        if (wVar == null) {
            return;
        }
        wVar.invoke(key, Integer.valueOf((int) f6), Integer.valueOf((int) f7), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf((int) f2), Integer.valueOf((int) f3), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onRetouchFinished() {
        kotlin.jvm.b.a<u> aVar = this.M;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onRetouchStart() {
        kotlin.jvm.b.a<u> aVar = this.L;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onSpotRemoveEnd() {
        kotlin.jvm.b.a<u> aVar = this.C;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onSpotRemoveStart() {
        kotlin.jvm.b.a<u> aVar = this.B;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onStaticStickerStatusChanged(String key, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        kotlin.jvm.internal.s.h(key, "key");
        w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> wVar = this.H;
        if (wVar == null) {
            return;
        }
        wVar.invoke(key, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public String onUnityInitFilterPath() {
        return n.a.c(kotlin.jvm.internal.s.q("basedata", File.separator));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onUnityRenderEnd() {
        this.X.a();
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void onVipStatus(String vips) {
        kotlin.jvm.internal.s.h(vips, "vips");
        a3 a3Var = this.r;
        if (a3Var == null) {
            return;
        }
        a3Var.i(vips);
    }

    public final void p0(BasicBrushMode brushMode, float f2) {
        kotlin.jvm.internal.s.h(brushMode, "brushMode");
        UnityEditCaller.Brush.setBrushSize(brushMode, f2);
    }

    public final boolean p1() {
        return us.pinguo.foundation.n.b.f() || (us.pinguo.foundation.utils.m.b(3072.0f, e.b()) && us.pinguo.util.c.f12478l);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void preCustomSpotDetected(int i2, int i3, int i4, float f2) {
        this.f10540f = new c(i2, i3, i4, f2, null, 16, null);
    }

    @Override // us.pinguo.u3dengine.api.UnityFilterCallbackApi
    public void preNativeFilterResult(int i2, int i3, int i4) {
        this.f10542h = new b(i2, i3, i4, null, 8, null);
    }

    public final void q() {
        l<? super Boolean, u> lVar = this.f10539e;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        o(EditModel.Normal);
    }

    public final void q0(BasicBrushMode brushMode) {
        kotlin.jvm.internal.s.h(brushMode, "brushMode");
        UnityEditCaller.Brush.setCurrentBrushMode(brushMode);
    }

    public final void r() {
        UnityEditCaller.Facial3d.resetStereorectifyStrength();
    }

    public final void r0(@ColorInt int i2) {
        UnityEditCaller.Common.setEditCanvasInfo(this.Y, 10.0f, i2);
    }

    @Override // us.pinguo.u3dengine.api.UnityFilterCallbackApi
    public void receiveBlingBlingTextureInfo(int i2, int i3, int i4, int i5) {
        this.f10545k.setTid(i2);
        this.f10545k.setWidth(i3);
        this.f10545k.setHeight(i4);
        this.f10545k.setMaxCount(i5);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void receiveBlurProtectedAreaInfos(boolean z, float f2, float f3, float f4, float f5, float f6) {
        t<? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> tVar = this.w;
        if (tVar == null) {
            return;
        }
        tVar.invoke(Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void repaintTransformObjectComplete(String uid, float f2, float f3, float f4, float f5, float f6) {
        kotlin.jvm.internal.s.h(uid, "uid");
        t<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> tVar = this.f0;
        if (tVar == null) {
            return;
        }
        kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new EditRender$repaintTransformObjectComplete$1$1(tVar, uid, f2, f3, f4, f5, f6, null), 3, null);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportBodyBeatifyEffectStatus(boolean z) {
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportBodyBeautifyToolUpdated(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z) {
        kotlin.jvm.b.b<? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> bVar = this.K;
        if (bVar == null) {
            return;
        }
        bVar.invoke(Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10), Boolean.valueOf(z));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportBokehGeneratedIconTexture(int i2, int i3, int i4) {
        us.pinguo.edit2020.bean.l lVar = this.W[0];
        lVar.e(i2);
        lVar.f(i3);
        lVar.d(i4);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportBokehGeneratedPreviewMaskTexture(int i2, int i3, int i4) {
        us.pinguo.edit2020.bean.l lVar = this.W[1];
        lVar.e(i2);
        lVar.f(i3);
        lVar.d(i4);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportBokehShapePreviewTexture(int i2, int i3, int i4) {
        this.S.n(i2, i3, i4);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportColorAfterHSLAdjust(HSLAdjustColor hslColor, @ColorInt int i2) {
        kotlin.jvm.internal.s.h(hslColor, "hslColor");
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportCurrentFilterTexture(int i2, int i3, int i4) {
        this.f10542h = new b(i2, i3, i4, null, 8, null);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportGestureTransformIfNeed(boolean z, boolean z2) {
        p<? super Boolean, ? super Boolean, u> pVar = this.g0;
        if (pVar == null) {
            return;
        }
        kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new EditRender$reportGestureTransformIfNeed$1$1(pVar, z, z2, null), 3, null);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportMagicBackgroundBrushMaskStatus(float f2) {
        l<? super Float, u> lVar = this.E;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Float.valueOf(f2));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportMagnifierRenderer() {
        boolean m;
        m = kotlin.collections.n.m(h0, this.U);
        if (m) {
            l<? super Boolean, u> lVar = this.f10539e;
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
        } else {
            l<? super Boolean, u> lVar2 = this.f10539e;
            if (lVar2 != null) {
                lVar2.invoke(Boolean.FALSE);
            }
        }
        g.m(this.R, null, 1, null);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportMagnifierTexture(int i2, int i3, int i4) {
        this.R.n(i2, i3, i4);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportSelectTransformObjectInfo(String uid, int i2, boolean z, float f2, float f3, float f4, float f5, float f6) {
        kotlin.jvm.internal.s.h(uid, "uid");
        v<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> vVar = this.e0;
        if (vVar == null) {
            return;
        }
        kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new EditRender$reportSelectTransformObjectInfo$1$1(vVar, uid, i2, z, f2, f3, f4, f5, f6, null), 3, null);
    }

    @Override // us.pinguo.u3dengine.api.UnityFilterCallbackApi
    public void reportSkyChangeRenderComplete(String uid, float f2, float f3, float f4, float f5) {
        kotlin.jvm.internal.s.h(uid, "uid");
        us.pinguo.common.log.a.k("reportSkyChangeRenderComplete:" + f2 + ',' + f3 + ',' + f4 + ',' + f5 + "->skyChangeRenderCompleteCallback:" + this.O, new Object[0]);
        s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> sVar = this.O;
        if (sVar == null) {
            return;
        }
        sVar.invoke(uid, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
    }

    @Override // us.pinguo.u3dengine.api.UnityFilterCallbackApi
    public void reportSkyChangeTransformPrepare(String uid, float f2, float f3, float f4, float f5) {
        kotlin.jvm.internal.s.h(uid, "uid");
        us.pinguo.common.log.a.k("reportSkyChangeTransformPrepare:" + f2 + ',' + f3 + ',' + f4 + ',' + f5, new Object[0]);
        s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> sVar = this.N;
        if (sVar == null) {
            return;
        }
        sVar.invoke(uid, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportStaticStickerLayerStatus(String key, boolean z, boolean z2) {
        kotlin.jvm.internal.s.h(key, "key");
        q<? super String, ? super Boolean, ? super Boolean, u> qVar = this.I;
        if (qVar == null) {
            return;
        }
        qVar.invoke(key, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportUnityStepManagerForDetail(String result) {
        kotlin.jvm.internal.s.h(result, "result");
        l<? super String, u> lVar = this.D;
        if (lVar == null) {
            return;
        }
        lVar.invoke(result);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void reportUnityStepManagerState(boolean z, boolean z2) {
        us.pinguo.common.log.a.d(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, "reportUnityStepManagerState, pre=" + z + ", next=" + z2, new Object[0]);
        a3 a3Var = this.r;
        if (a3Var == null) {
            return;
        }
        a3Var.n(z, z2);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public int requestAutoBeautifyVersion() {
        return this.d0;
    }

    public final void s() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new EditRender$destroy$1(this, null), 3, null);
        this.R.a();
        this.S.a();
        this.J = null;
        this.s = null;
        this.t = null;
        this.r = null;
        UnityEditCallback.unregister(this);
        UnityFilterMethodCallback.unregister(this);
        us.pinguo.edit2020.manager.e.a.b();
    }

    public final void s0(l<? super EditModel, u> lVar) {
        this.f10546l = lVar;
    }

    public final void t(us.pinguo.processor.d makeInfo) {
        kotlin.jvm.internal.s.h(makeInfo, "makeInfo");
        us.pinguo.edit2020.model.a aVar = this.u;
        if (aVar != null) {
            aVar.c();
        }
        this.f10544j = makeInfo;
        UnityEditCaller.Filter.INSTANCE.requestCurrentFilterTexture();
    }

    public final void t0(String filterPath, float f2, float f3, int i2, boolean z) {
        kotlin.jvm.internal.s.h(filterPath, "filterPath");
        UnityEditCaller.Makeup.setEditMakeupFilter(filterPath, f2, f3, i2, z);
    }

    public final void u0(String path, boolean z, boolean z2) {
        Size size;
        kotlin.jvm.internal.s.h(path, "path");
        if (new File(path).exists()) {
            this.c = path;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            Size size2 = new Size(options.outWidth, options.outHeight);
            if (z) {
                this.a = new Size(size2.getWidth(), size2.getHeight());
                this.P.setValue(us.pinguo.edit2020.manager.e.a.a(path, 0));
                UnityEditCaller.Common.setEditHistoryFromPath(path, size2, PerformanceLevelManager.a.h());
                return;
            }
            int l2 = kotlin.jvm.internal.s.c(options.outMimeType, "image/png") ? 0 : us.pinguo.util.j.l(path);
            if (l2 != 90 && l2 != 270) {
                size = new Size(size2.getWidth(), size2.getHeight());
            } else {
                size = new Size(size2.getHeight(), size2.getWidth());
            }
            this.a = size;
            this.P.setValue(us.pinguo.edit2020.manager.e.a.a(path, l2));
            us.pinguo.util.d.f(size2.toString());
            Size size3 = this.a;
            if (size3 == null) {
                return;
            }
            boolean z3 = kotlin.jvm.internal.s.c(options.outMimeType, "image/png") || kotlin.jvm.internal.s.c(options.outMimeType, "image/jpg") || kotlin.jvm.internal.s.c(options.outMimeType, "image/jpeg");
            String str = z3 ? path : this.f10538d;
            Size C = C();
            if (C == null) {
                kotlinx.coroutines.l.d(n0.a(z0.a()), null, null, new EditRender$setEditSourceFromPath$1$1(size3, this, z2, z3, path, str, size2, l2, null), 3, null);
                return;
            }
            UnityEditCaller.Common.setEditSourceFromPath(str, size2, l2, Integer.valueOf(Math.max(C.getWidth(), C.getHeight())));
            if (z2) {
                h.b.V(String.valueOf(size3.getHeight()), String.valueOf(size3.getWidth()), String.valueOf(size3.getWidth() * size3.getHeight()), "import");
                return;
            }
            return;
        }
        this.a = null;
        this.c = null;
        us.pinguo.common.log.a.e("Image file " + path + " not exist", new Object[0]);
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void unityEditComponentPrepared() {
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("unityEditComponentPrepared:", this.U), new Object[0]);
        l<? super EditModel, u> lVar = this.f10546l;
        if (lVar != null) {
            lVar.invoke(this.U);
        }
        l<? super EditModel, u> lVar2 = this.J;
        if (lVar2 != null) {
            lVar2.invoke(this.U);
        }
        switch (a.a[this.U.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                q1();
                return;
            case 8:
                q1();
                UnityEditCaller.Brush.INSTANCE.setBrushMaskHighlightColor(587137024, 1124007936);
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.u3dengine.edit.UnityEditCallbackApi
    public void unityEditMainPrepared(int i2, int i3, int i4) {
        us.pinguo.common.log.a.k("unityEditMainPrepared currentTextureId=" + i2 + ", width=" + i3 + ", height=" + i4, new Object[0]);
        kotlin.jvm.b.a<u> aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    public final void v(us.pinguo.processor.d makeInfo) {
        kotlin.jvm.internal.s.h(makeInfo, "makeInfo");
        if (kotlin.jvm.internal.s.c(makeInfo.a(), Effect.EFFECT_FILTER_NONE_KEY)) {
            this.f10544j = makeInfo;
            UnityEditCaller.Filter.setEditFilterInfo$default(UnityEditCaller.Filter.FilterType.None, null, 2, null);
            return;
        }
        us.pinguo.edit2020.model.a aVar = this.u;
        if (aVar != null) {
            aVar.c();
        }
        this.f10544j = makeInfo;
        UnityEditCaller.Filter.setEditFilterInfo$default(UnityEditCaller.Filter.FilterType.Local, null, 2, null);
    }

    public final void w(String filterPath) {
        kotlin.jvm.internal.s.h(filterPath, "filterPath");
        UnityEditCaller.Filter.setEditFilterInfo(UnityEditCaller.Filter.FilterType.Path, filterPath);
    }

    public final void w0(p<? super Boolean, ? super Boolean, u> pVar) {
        this.g0 = pVar;
    }

    public final void x(boolean z) {
        UnityEditCaller.Filter.setEditFilterFlipMode(z);
    }

    public final void x0(t<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> tVar) {
        this.f0 = tVar;
    }

    public final void y() {
        UnityEditCaller.Crop.flipX();
    }

    public final void y0(v<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> vVar) {
        this.e0 = vVar;
    }

    public final us.pinguo.repository2020.u<us.pinguo.facedetector.c> z() {
        return this.P;
    }

    public final void z0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        UnityEditCaller.Filter.setEditFilterOpacity(f2);
    }
}
