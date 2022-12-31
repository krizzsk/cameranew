package us.pinguo.edit2020.viewmodel.module;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Size;
import androidx.databinding.ObservableBoolean;
import androidx.exifinterface.media.ExifInterface;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.c0;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.repository.EditRepository;
import us.pinguo.performance.manager.PerformanceLevelManager;
import us.pinguo.repository2020.entity.Adjustment;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.BackgroundBlurShape;
import us.pinguo.repository2020.entity.BlurResponse;
import us.pinguo.repository2020.entity.BlurShapeResponse;
import us.pinguo.repository2020.entity.Shape;
import us.pinguo.repository2020.manager.BackgroundBlurDataManager;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditBackgroundBlurModule.kt */
/* loaded from: classes4.dex */
public final class EditBackgroundBlurModule implements us.pinguo.edit2020.utils.f {
    private final EditRender a;
    private BackgroundBlurMaterial b;
    private BackgroundBlur c;

    /* renamed from: d  reason: collision with root package name */
    private BackgroundBlur f10842d;

    /* renamed from: e  reason: collision with root package name */
    private BackgroundBlur f10843e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.edit2020.bean.e f10844f;

    /* renamed from: g  reason: collision with root package name */
    private BackgroundBlur f10845g;

    /* renamed from: h  reason: collision with root package name */
    private BackgroundBlur f10846h;

    /* renamed from: i  reason: collision with root package name */
    private BackgroundBlurShape f10847i;

    /* renamed from: j  reason: collision with root package name */
    private float f10848j;

    /* renamed from: k  reason: collision with root package name */
    private final EditRepository f10849k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<us.pinguo.edit2020.bean.e> f10850l;
    private final ArrayList<c0> m;
    private String n;
    private float o;
    private final int p;
    private final int q;
    private e r;
    private final HashMap<String, String> s;
    private us.pinguo.edit2020.c.b t;
    private kotlin.jvm.b.a<u> u;
    private kotlin.jvm.b.a<u> v;

    /* compiled from: EditBackgroundBlurModule.kt */
    /* renamed from: us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements l<Bitmap, u> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EditBackgroundBlurModule.kt */
        @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule$1$1", f = "EditBackgroundBlurModule.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C03921 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            final /* synthetic */ Bitmap $bitmap;
            int label;
            final /* synthetic */ EditBackgroundBlurModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03921(EditBackgroundBlurModule editBackgroundBlurModule, Bitmap bitmap, Continuation<? super C03921> continuation) {
                super(2, continuation);
                this.this$0 = editBackgroundBlurModule;
                this.$bitmap = bitmap;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new C03921(this.this$0, this.$bitmap, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((C03921) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    j.b(obj);
                    EditBackgroundBlurModule editBackgroundBlurModule = this.this$0;
                    Bitmap bitmap = this.$bitmap;
                    this.label = 1;
                    if (editBackgroundBlurModule.g(bitmap, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j.b(obj);
                }
                kotlin.jvm.b.a aVar = this.this$0.u;
                if (aVar != null) {
                    aVar.invoke();
                }
                return u.a;
            }
        }

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(Bitmap bitmap) {
            invoke2(bitmap);
            return u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap) {
            s.h(bitmap, "bitmap");
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new C03921(EditBackgroundBlurModule.this, bitmap, null), 3, null);
        }
    }

    public EditBackgroundBlurModule(EditRender editRender) {
        s.h(editRender, "editRender");
        this.a = editRender;
        EditRepository editRepository = new EditRepository();
        this.f10849k = editRepository;
        this.f10850l = editRepository.e();
        this.m = editRepository.d();
        this.o = us.pinguo.foundation.utils.n0.i();
        this.p = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_max_in_discrete_mode);
        this.q = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_min_in_discrete_mode);
        this.s = new HashMap<>();
        editRender.B0(new AnonymousClass1());
    }

    private final Size M(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Size(options.outWidth, options.outHeight);
    }

    private final int R(Float f2) {
        return (int) ((f2 == null ? 0.0f : f2.floatValue()) * 100);
    }

    private final float S(int i2) {
        return i2 / 100.0f;
    }

    private final int U(Float f2) {
        return ((int) ((f2 == null ? 0.0f : f2.floatValue()) * 30)) - 15;
    }

    private final void a0(String str, int i2, q<? super String, ? super Boolean, ? super String, u> qVar) {
        us.pinguo.edit2020.c.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
        }
        us.pinguo.edit2020.c.b bVar2 = new us.pinguo.edit2020.c.b(str, i2, false, this.s, qVar);
        this.t = bVar2;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(bVar2);
    }

    private final void b0() {
        this.a.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x026e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(android.graphics.Bitmap r18, kotlin.coroutines.Continuation<? super kotlin.u> r19) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule.g(android.graphics.Bitmap, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void j(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setCorrosion(Float.valueOf(S));
        }
        l0(this, null, Float.valueOf(S), null, null, null, null, null, 125, null);
        b0();
    }

    private final void j0(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8) {
        this.a.e0(f2, f3, f4, f5, f6, f7, f8);
    }

    private final void k(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setHalo(Float.valueOf(S));
        }
        l0(this, null, null, null, null, null, null, Float.valueOf(S), 63, null);
        b0();
    }

    private final void k0(BackgroundBlur backgroundBlur) {
        Adjustment adjusment;
        if (backgroundBlur == null || (adjusment = backgroundBlur.getAdjusment()) == null) {
            return;
        }
        EditRender editRender = this.a;
        Float size = adjusment.getSize();
        Float valueOf = Float.valueOf(size == null ? 0.5f : size.floatValue());
        Float corrosion = adjusment.getCorrosion();
        Float valueOf2 = Float.valueOf(corrosion == null ? 0.0f : corrosion.floatValue());
        Float swirly = adjusment.getSwirly();
        Float valueOf3 = Float.valueOf(swirly == null ? 0.0f : swirly.floatValue());
        Float radial = adjusment.getRadial();
        Float valueOf4 = Float.valueOf(radial != null ? radial.floatValue() : 0.0f);
        Float highlight = adjusment.getHighlight();
        Float valueOf5 = Float.valueOf(highlight == null ? 0.75f : highlight.floatValue());
        Float vivid = adjusment.getVivid();
        Float valueOf6 = Float.valueOf(vivid != null ? vivid.floatValue() : 0.5f);
        Float halo = adjusment.getHalo();
        editRender.e0(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, Float.valueOf(halo == null ? 0.65f : halo.floatValue()));
    }

    private final void l(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setHighlight(Float.valueOf(S));
        }
        l0(this, null, null, null, null, Float.valueOf(S), null, null, 111, null);
        b0();
    }

    static /* synthetic */ void l0(EditBackgroundBlurModule editBackgroundBlurModule, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = null;
        }
        if ((i2 & 2) != 0) {
            f3 = null;
        }
        if ((i2 & 4) != 0) {
            f4 = null;
        }
        if ((i2 & 8) != 0) {
            f5 = null;
        }
        if ((i2 & 16) != 0) {
            f6 = null;
        }
        if ((i2 & 32) != 0) {
            f7 = null;
        }
        if ((i2 & 64) != 0) {
            f8 = null;
        }
        editBackgroundBlurModule.j0(f2, f3, f4, f5, f6, f7, f8);
    }

    private final void m(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setRadial(Float.valueOf(S));
        }
        l0(this, null, null, null, Float.valueOf(S), null, null, null, 119, null);
        b0();
    }

    private final void n(float f2) {
        float K = K(f2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setSize(Float.valueOf(K));
        }
        l0(this, Float.valueOf(K), null, null, null, null, null, null, 126, null);
        b0();
    }

    private final void o(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setSwirly(Float.valueOf(S));
        }
        l0(this, null, null, Float.valueOf(S), null, null, null, null, 123, null);
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String str) {
        this.a.h0(str);
    }

    private final void p(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Adjustment adjusment = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment != null) {
            adjusment.setVivid(Float.valueOf(S));
        }
        l0(this, null, null, null, null, null, Float.valueOf(S), null, 95, null);
        b0();
    }

    private final void p0(Float f2, Float f3, Float f4, Float f5, String str) {
        this.a.i0(f2, f3, f4, f5, str);
    }

    private final void q0(BackgroundBlur backgroundBlur) {
        Shape shape;
        if (backgroundBlur == null || (shape = backgroundBlur.getShape()) == null) {
            return;
        }
        EditRender editRender = this.a;
        Float creamy = shape.getCreamy();
        Float valueOf = Float.valueOf(creamy == null ? 0.0f : creamy.floatValue());
        Float soft = shape.getSoft();
        Float valueOf2 = Float.valueOf(soft == null ? 0.0f : soft.floatValue());
        Float reflex = shape.getReflex();
        Float valueOf3 = Float.valueOf(reflex == null ? 0.0f : reflex.floatValue());
        Float bilinear = shape.getBilinear();
        Float valueOf4 = Float.valueOf(bilinear != null ? bilinear.floatValue() : 0.0f);
        String shapeTexture = shape.getShapeTexture();
        if (shapeTexture == null) {
            shapeTexture = "";
        }
        editRender.i0(valueOf, valueOf2, valueOf3, valueOf4, shapeTexture);
    }

    private final void r(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Shape shape = backgroundBlur == null ? null : backgroundBlur.getShape();
        if (shape != null) {
            shape.setBilinear(Float.valueOf(S));
        }
        r0(this, null, null, null, Float.valueOf(S), null, 23, null);
        b0();
    }

    static /* synthetic */ void r0(EditBackgroundBlurModule editBackgroundBlurModule, Float f2, Float f3, Float f4, Float f5, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = null;
        }
        if ((i2 & 2) != 0) {
            f3 = null;
        }
        if ((i2 & 4) != 0) {
            f4 = null;
        }
        if ((i2 & 8) != 0) {
            f5 = null;
        }
        if ((i2 & 16) != 0) {
            str = null;
        }
        editBackgroundBlurModule.p0(f2, f3, f4, f5, str);
    }

    private final void s(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Shape shape = backgroundBlur == null ? null : backgroundBlur.getShape();
        if (shape != null) {
            shape.setCreamy(Float.valueOf(S));
        }
        r0(this, Float.valueOf(S), null, null, null, null, 30, null);
        b0();
    }

    private final void t(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Shape shape = backgroundBlur == null ? null : backgroundBlur.getShape();
        if (shape != null) {
            shape.setReflex(Float.valueOf(S));
        }
        r0(this, null, null, Float.valueOf(S), null, null, 27, null);
        b0();
    }

    private final void u(int i2) {
        float S = S(i2);
        BackgroundBlur backgroundBlur = this.c;
        Shape shape = backgroundBlur == null ? null : backgroundBlur.getShape();
        if (shape != null) {
            shape.setSoft(Float.valueOf(S));
        }
        r0(this, null, Float.valueOf(S), null, null, null, 29, null);
        b0();
    }

    private final void v(String str) {
        BackgroundBlur backgroundBlur = this.c;
        Shape shape = backgroundBlur == null ? null : backgroundBlur.getShape();
        if (shape != null) {
            shape.setShapeTexture(str);
        }
        r0(this, null, null, null, null, str, 15, null);
        b0();
    }

    public final ArrayList<c0> A() {
        return this.m;
    }

    public final void A0(BackgroundBlur backgroundBlur) {
        this.f10846h = backgroundBlur;
    }

    public final ArrayList<us.pinguo.edit2020.bean.e> B() {
        return this.f10850l;
    }

    public final void B0(BackgroundBlur backgroundBlur) {
        this.f10843e = backgroundBlur;
    }

    public final List<BackgroundBlur> C() {
        BlurResponse l2 = BackgroundBlurDataManager.a.l();
        if (l2 == null) {
            return null;
        }
        return l2.getPackages();
    }

    public final void C0(BackgroundBlur backgroundBlur) {
        this.f10845g = backgroundBlur;
    }

    public final List<BackgroundBlurShape> D() {
        BlurShapeResponse m = BackgroundBlurDataManager.a.m();
        if (m == null) {
            return null;
        }
        return m.getPackages();
    }

    public final void D0(BackgroundBlurShape backgroundBlurShape) {
        this.f10847i = backgroundBlurShape;
    }

    public final Float E() {
        Integer g2 = PerformanceLevelManager.a.g();
        boolean z = false;
        int intValue = g2 == null ? 0 : g2.intValue();
        if (90 <= intValue && intValue < 100) {
            z = true;
        }
        if (z) {
            return Float.valueOf(0.8f);
        }
        if (intValue > 100) {
            return Float.valueOf(1.0f);
        }
        return null;
    }

    public final void E0(BackgroundBlur backgroundBlur) {
        this.f10842d = backgroundBlur;
    }

    public final float F(int i2) {
        int i3 = this.p;
        int i4 = this.q;
        return (((i2 / 100.0f) * (i3 - i4)) + i4) / this.o;
    }

    public final us.pinguo.repository2020.u<u0> G() {
        return this.a.L();
    }

    public final float H() {
        return this.f10848j;
    }

    public final BackgroundBlurMaterial I() {
        return this.b;
    }

    public final BackgroundBlur J() {
        return this.c;
    }

    public final float K(float f2) {
        return (f2 + 15) / 30;
    }

    public final kotlin.jvm.b.a<u> L() {
        return this.v;
    }

    public final BackgroundBlur N() {
        return this.f10846h;
    }

    public final BackgroundBlur O() {
        return this.f10845g;
    }

    public final BackgroundBlurShape P() {
        return this.f10847i;
    }

    public final BackgroundBlur Q() {
        return this.f10842d;
    }

    public final List<x> T() {
        List<x> e2;
        BackgroundBlur backgroundBlur = this.c;
        if (backgroundBlur == null) {
            return null;
        }
        e2 = t.e(new us.pinguo.edit2020.bean.d(backgroundBlur));
        return e2;
    }

    public final void V(boolean z) {
        this.a.N(z);
    }

    public final void W(l<? super Boolean, u> callback) {
        us.pinguo.edit2020.manager.c a;
        HistoryRecord c;
        s.h(callback, "callback");
        e eVar = this.r;
        String str = null;
        if (eVar != null && (a = eVar.a()) != null && (c = a.c()) != null) {
            str = c.getPicturePath();
        }
        if (str == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        int rotationDegrees = new ExifInterface(str).getRotationDegrees();
        int i2 = rotationDegrees % BaseBlurEffect.ROTATION_360;
        if (i2 != 90 && i2 != 270) {
            M(str);
        } else {
            Size M = M(str);
            new Size(M.getHeight(), M.getWidth());
        }
        a0(str, rotationDegrees, new EditBackgroundBlurModule$initBackgroundBlur$1(this, callback));
    }

    public final void X(BackgroundBlur backgroundBlur) {
        if (backgroundBlur == null) {
            return;
        }
        us.pinguo.edit2020.bean.e eVar = B().get(0);
        Adjustment adjusment = backgroundBlur.getAdjusment();
        eVar.k(U(adjusment == null ? null : adjusment.getSize()));
        us.pinguo.edit2020.bean.e eVar2 = B().get(2);
        Adjustment adjusment2 = backgroundBlur.getAdjusment();
        eVar2.k(R(adjusment2 == null ? null : adjusment2.getHalo()));
        us.pinguo.edit2020.bean.e eVar3 = B().get(3);
        Shape shape = backgroundBlur.getShape();
        eVar3.k(R(shape == null ? null : shape.getCreamy()));
        us.pinguo.edit2020.bean.e eVar4 = B().get(4);
        Shape shape2 = backgroundBlur.getShape();
        eVar4.k(R(shape2 == null ? null : shape2.getSoft()));
        us.pinguo.edit2020.bean.e eVar5 = B().get(5);
        Shape shape3 = backgroundBlur.getShape();
        eVar5.k(R(shape3 == null ? null : shape3.getReflex()));
        us.pinguo.edit2020.bean.e eVar6 = B().get(6);
        Shape shape4 = backgroundBlur.getShape();
        eVar6.k(R(shape4 == null ? null : shape4.getBilinear()));
        us.pinguo.edit2020.bean.e eVar7 = B().get(7);
        Adjustment adjusment3 = backgroundBlur.getAdjusment();
        eVar7.k(R(adjusment3 == null ? null : adjusment3.getCorrosion()));
        us.pinguo.edit2020.bean.e eVar8 = B().get(8);
        Adjustment adjusment4 = backgroundBlur.getAdjusment();
        eVar8.k(R(adjusment4 == null ? null : adjusment4.getSwirly()));
        us.pinguo.edit2020.bean.e eVar9 = B().get(9);
        Adjustment adjusment5 = backgroundBlur.getAdjusment();
        eVar9.k(R(adjusment5 == null ? null : adjusment5.getRadial()));
        us.pinguo.edit2020.bean.e eVar10 = B().get(10);
        Adjustment adjusment6 = backgroundBlur.getAdjusment();
        eVar10.k(R(adjusment6 == null ? null : adjusment6.getHighlight()));
        us.pinguo.edit2020.bean.e eVar11 = B().get(11);
        Adjustment adjusment7 = backgroundBlur.getAdjusment();
        eVar11.k(R(adjusment7 != null ? adjusment7.getVivid() : null));
    }

    public final void Y() {
        this.a.P();
    }

    public final boolean Z() {
        Adjustment adjusment;
        Adjustment adjusment2;
        Adjustment adjusment3;
        Adjustment adjusment4;
        Adjustment adjusment5;
        Adjustment adjusment6;
        Adjustment adjusment7;
        Adjustment adjusment8;
        Adjustment adjusment9;
        Adjustment adjusment10;
        Adjustment adjusment11;
        Adjustment adjusment12;
        Shape shape;
        Shape shape2;
        Shape shape3;
        Shape shape4;
        Shape shape5;
        Shape shape6;
        Shape shape7;
        Shape shape8;
        Shape shape9;
        Shape shape10;
        BackgroundBlur backgroundBlur = this.f10842d;
        String str = null;
        Float halo = (backgroundBlur == null || (adjusment = backgroundBlur.getAdjusment()) == null) ? null : adjusment.getHalo();
        BackgroundBlur backgroundBlur2 = this.f10843e;
        if (s.b(halo, (backgroundBlur2 == null || (adjusment2 = backgroundBlur2.getAdjusment()) == null) ? null : adjusment2.getHalo())) {
            BackgroundBlur backgroundBlur3 = this.f10842d;
            Float vivid = (backgroundBlur3 == null || (adjusment3 = backgroundBlur3.getAdjusment()) == null) ? null : adjusment3.getVivid();
            BackgroundBlur backgroundBlur4 = this.f10843e;
            if (s.b(vivid, (backgroundBlur4 == null || (adjusment4 = backgroundBlur4.getAdjusment()) == null) ? null : adjusment4.getVivid())) {
                BackgroundBlur backgroundBlur5 = this.f10842d;
                Float highlight = (backgroundBlur5 == null || (adjusment5 = backgroundBlur5.getAdjusment()) == null) ? null : adjusment5.getHighlight();
                BackgroundBlur backgroundBlur6 = this.f10843e;
                if (s.b(highlight, (backgroundBlur6 == null || (adjusment6 = backgroundBlur6.getAdjusment()) == null) ? null : adjusment6.getHighlight())) {
                    BackgroundBlur backgroundBlur7 = this.f10842d;
                    Float radial = (backgroundBlur7 == null || (adjusment7 = backgroundBlur7.getAdjusment()) == null) ? null : adjusment7.getRadial();
                    BackgroundBlur backgroundBlur8 = this.f10843e;
                    if (s.b(radial, (backgroundBlur8 == null || (adjusment8 = backgroundBlur8.getAdjusment()) == null) ? null : adjusment8.getRadial())) {
                        BackgroundBlur backgroundBlur9 = this.f10842d;
                        Float swirly = (backgroundBlur9 == null || (adjusment9 = backgroundBlur9.getAdjusment()) == null) ? null : adjusment9.getSwirly();
                        BackgroundBlur backgroundBlur10 = this.f10843e;
                        if (s.b(swirly, (backgroundBlur10 == null || (adjusment10 = backgroundBlur10.getAdjusment()) == null) ? null : adjusment10.getSwirly())) {
                            BackgroundBlur backgroundBlur11 = this.f10842d;
                            Float corrosion = (backgroundBlur11 == null || (adjusment11 = backgroundBlur11.getAdjusment()) == null) ? null : adjusment11.getCorrosion();
                            BackgroundBlur backgroundBlur12 = this.f10843e;
                            if (s.b(corrosion, (backgroundBlur12 == null || (adjusment12 = backgroundBlur12.getAdjusment()) == null) ? null : adjusment12.getCorrosion())) {
                                BackgroundBlur backgroundBlur13 = this.f10842d;
                                Float bilinear = (backgroundBlur13 == null || (shape = backgroundBlur13.getShape()) == null) ? null : shape.getBilinear();
                                BackgroundBlur backgroundBlur14 = this.f10843e;
                                if (s.b(bilinear, (backgroundBlur14 == null || (shape2 = backgroundBlur14.getShape()) == null) ? null : shape2.getBilinear())) {
                                    BackgroundBlur backgroundBlur15 = this.f10842d;
                                    Float reflex = (backgroundBlur15 == null || (shape3 = backgroundBlur15.getShape()) == null) ? null : shape3.getReflex();
                                    BackgroundBlur backgroundBlur16 = this.f10843e;
                                    if (s.b(reflex, (backgroundBlur16 == null || (shape4 = backgroundBlur16.getShape()) == null) ? null : shape4.getReflex())) {
                                        BackgroundBlur backgroundBlur17 = this.f10842d;
                                        Float soft = (backgroundBlur17 == null || (shape5 = backgroundBlur17.getShape()) == null) ? null : shape5.getSoft();
                                        BackgroundBlur backgroundBlur18 = this.f10843e;
                                        if (s.b(soft, (backgroundBlur18 == null || (shape6 = backgroundBlur18.getShape()) == null) ? null : shape6.getSoft())) {
                                            BackgroundBlur backgroundBlur19 = this.f10842d;
                                            Float creamy = (backgroundBlur19 == null || (shape7 = backgroundBlur19.getShape()) == null) ? null : shape7.getCreamy();
                                            BackgroundBlur backgroundBlur20 = this.f10843e;
                                            if (s.b(creamy, (backgroundBlur20 == null || (shape8 = backgroundBlur20.getShape()) == null) ? null : shape8.getCreamy())) {
                                                BackgroundBlur backgroundBlur21 = this.f10842d;
                                                String shapeTexture = (backgroundBlur21 == null || (shape9 = backgroundBlur21.getShape()) == null) ? null : shape9.getShapeTexture();
                                                BackgroundBlur backgroundBlur22 = this.f10843e;
                                                if (backgroundBlur22 != null && (shape10 = backgroundBlur22.getShape()) != null) {
                                                    str = shape10.getShapeTexture();
                                                }
                                                return !s.c(shapeTexture, str);
                                            }
                                            return true;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // us.pinguo.edit2020.utils.f
    public u0 a() {
        return this.a.L().getValue();
    }

    @Override // us.pinguo.edit2020.utils.f
    public void b() {
        this.a.reportMagnifierRenderer();
    }

    public final void c0(kotlin.jvm.b.a<u> aVar) {
        this.u = aVar;
        this.a.V();
    }

    public final void d0() {
        this.a.W();
    }

    public final void e0() {
        String str = this.n;
        if (str == null) {
            return;
        }
        this.a.Y(str);
    }

    public final void f0() {
        List<BackgroundBlurShape> packages;
        BlurShapeResponse m = BackgroundBlurDataManager.a.m();
        if (m == null || (packages = m.getPackages()) == null) {
            return;
        }
        for (BackgroundBlurShape backgroundBlurShape : packages) {
            ObservableBoolean isSelected = backgroundBlurShape.isSelected();
            if (isSelected != null) {
                isSelected.set(false);
            }
        }
    }

    public final void g0() {
        ObservableBoolean isSelected;
        ObservableBoolean isSelected2;
        BackgroundBlur backgroundBlur = this.c;
        if (backgroundBlur != null && (isSelected2 = backgroundBlur.isSelected()) != null) {
            isSelected2.set(false);
        }
        BackgroundBlur backgroundBlur2 = this.f10845g;
        if (backgroundBlur2 != null && (isSelected = backgroundBlur2.isSelected()) != null) {
            isSelected.set(false);
        }
        this.f10848j = 0.0f;
        this.c = null;
        this.f10845g = null;
        this.f10842d = null;
        this.f10843e = null;
    }

    public final void h(BackgroundBlurMaterial backgroundBlurMaterial) {
        if (backgroundBlurMaterial instanceof BackgroundBlur) {
            BackgroundBlur backgroundBlur = (BackgroundBlur) backgroundBlurMaterial;
            Adjustment adjusment = backgroundBlur.getAdjusment();
            if (adjusment != null) {
                adjusment.setSize(Float.valueOf(K(this.f10848j)));
            }
            q0(backgroundBlur);
            k0(backgroundBlur);
            b0();
        } else if (backgroundBlurMaterial instanceof BackgroundBlurShape) {
            v(((BackgroundBlurShape) backgroundBlurMaterial).getShapeTexture());
        }
    }

    public final void h0() {
        Shape shape;
        Shape shape2;
        Shape shape3;
        Shape shape4;
        Shape shape5;
        Adjustment adjusment;
        Adjustment adjusment2;
        Adjustment adjusment3;
        Adjustment adjusment4;
        Adjustment adjusment5;
        Adjustment adjusment6;
        Adjustment adjusment7;
        BackgroundBlur backgroundBlur = this.f10842d;
        String str = null;
        Adjustment adjusment8 = backgroundBlur == null ? null : backgroundBlur.getAdjusment();
        if (adjusment8 != null) {
            BackgroundBlur backgroundBlur2 = this.f10843e;
            adjusment8.setHalo((backgroundBlur2 == null || (adjusment7 = backgroundBlur2.getAdjusment()) == null) ? null : adjusment7.getHalo());
        }
        BackgroundBlur backgroundBlur3 = this.f10842d;
        Adjustment adjusment9 = backgroundBlur3 == null ? null : backgroundBlur3.getAdjusment();
        if (adjusment9 != null) {
            BackgroundBlur backgroundBlur4 = this.f10843e;
            adjusment9.setVivid((backgroundBlur4 == null || (adjusment6 = backgroundBlur4.getAdjusment()) == null) ? null : adjusment6.getVivid());
        }
        BackgroundBlur backgroundBlur5 = this.f10842d;
        Adjustment adjusment10 = backgroundBlur5 == null ? null : backgroundBlur5.getAdjusment();
        if (adjusment10 != null) {
            BackgroundBlur backgroundBlur6 = this.f10843e;
            adjusment10.setHighlight((backgroundBlur6 == null || (adjusment5 = backgroundBlur6.getAdjusment()) == null) ? null : adjusment5.getHighlight());
        }
        BackgroundBlur backgroundBlur7 = this.f10842d;
        Adjustment adjusment11 = backgroundBlur7 == null ? null : backgroundBlur7.getAdjusment();
        if (adjusment11 != null) {
            BackgroundBlur backgroundBlur8 = this.f10843e;
            adjusment11.setRadial((backgroundBlur8 == null || (adjusment4 = backgroundBlur8.getAdjusment()) == null) ? null : adjusment4.getRadial());
        }
        BackgroundBlur backgroundBlur9 = this.f10842d;
        Adjustment adjusment12 = backgroundBlur9 == null ? null : backgroundBlur9.getAdjusment();
        if (adjusment12 != null) {
            BackgroundBlur backgroundBlur10 = this.f10843e;
            adjusment12.setSwirly((backgroundBlur10 == null || (adjusment3 = backgroundBlur10.getAdjusment()) == null) ? null : adjusment3.getSwirly());
        }
        BackgroundBlur backgroundBlur11 = this.f10842d;
        Adjustment adjusment13 = backgroundBlur11 == null ? null : backgroundBlur11.getAdjusment();
        if (adjusment13 != null) {
            BackgroundBlur backgroundBlur12 = this.f10843e;
            adjusment13.setCorrosion((backgroundBlur12 == null || (adjusment2 = backgroundBlur12.getAdjusment()) == null) ? null : adjusment2.getCorrosion());
        }
        BackgroundBlur backgroundBlur13 = this.f10842d;
        Adjustment adjusment14 = backgroundBlur13 == null ? null : backgroundBlur13.getAdjusment();
        if (adjusment14 != null) {
            BackgroundBlur backgroundBlur14 = this.f10843e;
            adjusment14.setSize((backgroundBlur14 == null || (adjusment = backgroundBlur14.getAdjusment()) == null) ? null : adjusment.getSize());
        }
        BackgroundBlur backgroundBlur15 = this.f10842d;
        Shape shape6 = backgroundBlur15 == null ? null : backgroundBlur15.getShape();
        if (shape6 != null) {
            BackgroundBlur backgroundBlur16 = this.f10843e;
            shape6.setBilinear((backgroundBlur16 == null || (shape5 = backgroundBlur16.getShape()) == null) ? null : shape5.getBilinear());
        }
        BackgroundBlur backgroundBlur17 = this.f10842d;
        Shape shape7 = backgroundBlur17 == null ? null : backgroundBlur17.getShape();
        if (shape7 != null) {
            BackgroundBlur backgroundBlur18 = this.f10843e;
            shape7.setReflex((backgroundBlur18 == null || (shape4 = backgroundBlur18.getShape()) == null) ? null : shape4.getReflex());
        }
        BackgroundBlur backgroundBlur19 = this.f10842d;
        Shape shape8 = backgroundBlur19 == null ? null : backgroundBlur19.getShape();
        if (shape8 != null) {
            BackgroundBlur backgroundBlur20 = this.f10843e;
            shape8.setSoft((backgroundBlur20 == null || (shape3 = backgroundBlur20.getShape()) == null) ? null : shape3.getSoft());
        }
        BackgroundBlur backgroundBlur21 = this.f10842d;
        Shape shape9 = backgroundBlur21 == null ? null : backgroundBlur21.getShape();
        if (shape9 != null) {
            BackgroundBlur backgroundBlur22 = this.f10843e;
            shape9.setCreamy((backgroundBlur22 == null || (shape2 = backgroundBlur22.getShape()) == null) ? null : shape2.getCreamy());
        }
        BackgroundBlur backgroundBlur23 = this.f10842d;
        Shape shape10 = backgroundBlur23 == null ? null : backgroundBlur23.getShape();
        if (shape10 == null) {
            return;
        }
        BackgroundBlur backgroundBlur24 = this.f10843e;
        if (backgroundBlur24 != null && (shape = backgroundBlur24.getShape()) != null) {
            str = shape.getShapeTexture();
        }
        shape10.setShapeTexture(str);
    }

    public final void i() {
        us.pinguo.edit2020.c.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
        }
        this.t = null;
    }

    public final void i0(float f2) {
        this.f10848j = f2;
        n(f2);
    }

    public final void m0(boolean z) {
        this.a.f0(z);
    }

    public final void n0(float f2) {
        this.a.g0(f2);
    }

    public final void q(int i2, kotlin.jvm.b.a<u> aVar) {
        us.pinguo.edit2020.bean.e eVar = this.f10844f;
        if (eVar == null) {
            return;
        }
        eVar.k(i2);
        String f2 = eVar.f();
        switch (f2.hashCode()) {
            case -1549354799:
                if (f2.equals("background_blur_corrosion")) {
                    j(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case -1296275438:
                if (f2.equals("background_blur_quantity")) {
                    k(eVar.g());
                    return;
                }
                break;
            case -1263611087:
                if (f2.equals("background_blur_soft")) {
                    u(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case -517451398:
                if (f2.equals("background_blur_shape")) {
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case -514631081:
                if (f2.equals("background_blur_vivid")) {
                    p(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case 149915020:
                if (f2.equals("background_blur_intensity")) {
                    n(eVar.g());
                    return;
                }
                break;
            case 690149758:
                if (f2.equals("background_blur_creamy")) {
                    s(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case 876350899:
                if (f2.equals("background_blur_bilinear")) {
                    r(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case 1103864678:
                if (f2.equals("background_blur_radial")) {
                    m(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case 1107621363:
                if (f2.equals("background_blur_reflex")) {
                    t(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case 1152969249:
                if (f2.equals("background_blur_swirly")) {
                    o(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
            case 2041147904:
                if (f2.equals("background_blur_high_light")) {
                    l(eVar.g());
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                break;
        }
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    public final void s0(BasicBrushMode brushMode, Float f2, Float f3) {
        s.h(brushMode, "brushMode");
        UnityEditCaller.Brush.setCurrentBrushMode(brushMode);
        if (f2 == null || f3 == null) {
            return;
        }
        UnityEditCaller.Brush.setBrushSize(brushMode, f2.floatValue());
    }

    public final void t0(BackgroundBlurMaterial backgroundBlurMaterial) {
        this.b = backgroundBlurMaterial;
    }

    public final void u0(BackgroundBlur backgroundBlur) {
        this.c = backgroundBlur;
    }

    public final void v0(us.pinguo.edit2020.bean.e eVar) {
        this.f10844f = eVar;
    }

    public final void w(l<? super EditModel, u> prepareCallback) {
        s.h(prepareCallback, "prepareCallback");
        this.a.s0(prepareCallback);
        EditModel A = this.a.A();
        EditModel editModel = EditModel.BackgroundBlur;
        if (A != editModel) {
            this.a.o(editModel);
        }
    }

    public final void w0(BackgroundBlurShape backgroundBlurShape) {
    }

    public final void x() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new EditBackgroundBlurModule$deleteCustomizedLens$1(this, null), 3, null);
    }

    public final void x0(kotlin.jvm.b.a<u> aVar) {
        this.v = aVar;
    }

    public final void y(boolean z) {
        this.a.n1(z);
    }

    public final void y0(boolean z) {
    }

    public final void z() {
        UnityEditCaller.Brush.setCurrentBrushMode(BasicBrushMode.None);
    }

    public final void z0(e eVar) {
        this.r = eVar;
    }
}
