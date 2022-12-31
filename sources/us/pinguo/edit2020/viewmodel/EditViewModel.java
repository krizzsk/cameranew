package us.pinguo.edit2020.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelKt;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.h;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.t;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.controller.EditTabType;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.edit2020.viewmodel.module.AdjustModule;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.edit2020.viewmodel.module.e;
import us.pinguo.edit2020.viewmodel.module.f;
import us.pinguo.image.saver.Saver2020;
import us.pinguo.nativeinterface.UnityInterface;
import us.pinguo.u3dengine.BaseUnityPlayerFragment;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.util.j;
/* compiled from: EditViewModel.kt */
/* loaded from: classes4.dex */
public final class EditViewModel extends AndroidViewModel implements LifecycleObserver {
    private final long a;
    private final EditRender b;
    private final EditBeautyModule c;

    /* renamed from: d  reason: collision with root package name */
    private final EditFilterModule f10807d;

    /* renamed from: e  reason: collision with root package name */
    public e f10808e;

    /* renamed from: f  reason: collision with root package name */
    private final UnityInterface f10809f;

    /* renamed from: g  reason: collision with root package name */
    private final AdjustModule f10810g;

    /* renamed from: h  reason: collision with root package name */
    private final f f10811h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10812i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10813j;

    /* renamed from: k  reason: collision with root package name */
    private String f10814k;

    /* renamed from: l  reason: collision with root package name */
    private int f10815l;
    private List<HistoryRecord> m;
    private kotlin.jvm.b.a<u> n;
    private List<? extends x> o;
    private kotlin.jvm.b.a<u> p;
    private boolean q;
    private final us.pinguo.repository2020.u<String> r;
    private final LiveData<String> s;
    private final kotlin.f t;
    private final us.pinguo.repository2020.u<String> u;
    private ActivityResultLauncher<Intent> v;
    private final Integer[] w;

    /* compiled from: EditViewModel.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditTabType.values().length];
            iArr[EditTabType.BEAUTY.ordinal()] = 1;
            iArr[EditTabType.FILTER.ordinal()] = 2;
            iArr[EditTabType.ADJUST.ordinal()] = 3;
            iArr[EditTabType.EDIT.ordinal()] = 4;
            iArr[EditTabType.MAKEUP.ordinal()] = 5;
            a = iArr;
        }
    }

    /* compiled from: EditViewModel.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.edit2020.b.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(EditViewModel this$0) {
            s.h(this$0, "this$0");
            kotlin.jvm.b.a<u> r = this$0.r();
            if (r == null) {
                return;
            }
            r.invoke();
        }

        @Override // us.pinguo.edit2020.b.a
        public void onEditImagedSavedSuccess(String path, boolean z) {
            s.h(path, "path");
            EditViewModel.this.I(path);
            EditViewModel.this.j().a().n(new HistoryRecord(path, EditViewModel.this.x()));
            EditViewModel.this.U(true);
            final EditViewModel editViewModel = EditViewModel.this;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.viewmodel.c
                @Override // java.lang.Runnable
                public final void run() {
                    EditViewModel.b.b(EditViewModel.this);
                }
            });
            EditViewModel.this.i().s0(path);
            EditViewModel.this.k().k().t(true);
            EditViewModel.this.k().k().n0();
            EditViewModel.this.l().o(EditModel.Normal);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditViewModel(Application application) {
        super(application);
        kotlin.f a2;
        s.h(application, "application");
        this.a = System.currentTimeMillis();
        EditRender editRender = new EditRender();
        this.b = editRender;
        this.c = new EditBeautyModule(editRender);
        this.f10807d = new EditFilterModule(editRender);
        this.f10809f = BaseUnityPlayerFragment.b.a();
        this.f10810g = new AdjustModule(editRender);
        this.f10811h = new f(editRender);
        this.f10814k = "";
        this.f10815l = -1;
        this.q = true;
        us.pinguo.repository2020.u<String> uVar = new us.pinguo.repository2020.u<>();
        this.r = uVar;
        this.s = uVar;
        a2 = h.a(LazyThreadSafetyMode.NONE, EditViewModel$_resultChannel$2.INSTANCE);
        this.t = a2;
        this.u = new us.pinguo.repository2020.u<>();
        this.w = new Integer[]{37, 35, 65, 33, 38, 40, 70, 42, 55, 72, 73, 52, 53, 58, 75, 60, 61, 76, 46, 6, 26, 16, 84, 90, 87, 93, 94, 92, 85, 89, 95, 91, 86, 88};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        c(new PointF(0.5f, 0.5f), 1.0f, new PointF(0.0f, 0.0f), 200);
    }

    private final void J(@ColorInt int i2) {
        this.b.r0(i2);
    }

    private final String u() {
        String i0;
        Iterator it;
        List<x> j2 = j().a().j();
        String str = "";
        if (j2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : j2) {
                if (obj instanceof us.pinguo.edit2020.bean.a) {
                    arrayList.add(obj);
                }
            }
            while (arrayList.iterator().hasNext()) {
                str = str + ((us.pinguo.edit2020.bean.a) it.next()).f() + '-';
            }
        }
        i0 = StringsKt__StringsKt.i0(str, PGTransHeader.CONNECTOR);
        return i0;
    }

    private final String v() {
        String i0;
        Iterator it;
        List<x> j2 = j().a().j();
        String str = "";
        if (j2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : j2) {
                if (obj instanceof us.pinguo.edit2020.bean.s) {
                    arrayList.add(obj);
                }
            }
            while (arrayList.iterator().hasNext()) {
                str = str + ((us.pinguo.edit2020.bean.s) it.next()).f() + '-';
            }
        }
        i0 = StringsKt__StringsKt.i0(str, PGTransHeader.CONNECTOR);
        return i0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.channels.e<ActivityResult> z() {
        return (kotlinx.coroutines.channels.e) this.t.getValue();
    }

    public final boolean A() {
        return this.f10812i;
    }

    public final boolean B() {
        return this.b.A() == EditModel.Normal;
    }

    public final void D(ImageView view) {
        String picturePath;
        Bitmap p;
        s.h(view, "view");
        HistoryRecord g2 = j().a().g();
        if (g2 == null || (picturePath = g2.getPicturePath()) == null) {
            return;
        }
        I(picturePath);
        int l2 = j.l(picturePath);
        Bitmap decodeFile = BitmapFactory.decodeFile(picturePath);
        if (decodeFile != null && decodeFile.getByteCount() > 104857600) {
            float sqrt = ((float) Math.sqrt(1.048576E8f / decodeFile.getByteCount())) - 0.01f;
            p = us.pinguo.util.e.u(decodeFile, sqrt, sqrt, l2);
        } else {
            p = us.pinguo.util.e.p(decodeFile, l2);
        }
        view.setImageBitmap(p);
        EditRender.v0(l(), picturePath, true, false, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (kotlin.jvm.internal.s.c(r9 == null ? null : r9.getItemId(), com.pinguo.camera360.effect.model.entity.Effect.EFFECT_FILTER_NONE_KEY) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(us.pinguo.edit2020.controller.EditTabType r9, kotlin.jvm.b.a<kotlin.u> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "tabType"
            kotlin.jvm.internal.s.h(r9, r0)
            java.lang.String r0 = "saveEndAction"
            kotlin.jvm.internal.s.h(r10, r0)
            int[] r0 = us.pinguo.edit2020.viewmodel.EditViewModel.a.a
            int r9 = r9.ordinal()
            r9 = r0[r9]
            r0 = 0
            r1 = 1
            r2 = 0
            if (r9 == r1) goto L87
            r3 = 2
            if (r9 == r3) goto L6a
            r3 = 3
            if (r9 == r3) goto L42
            r1 = 4
            if (r9 == r1) goto L2f
            r1 = 5
            if (r9 == r1) goto L26
        L23:
            r1 = 0
            goto L99
        L26:
            us.pinguo.edit2020.viewmodel.module.EditBeautyModule r9 = r8.c
            us.pinguo.edit2020.viewmodel.FunctionType r1 = us.pinguo.edit2020.viewmodel.FunctionType.MakeupMenu
            boolean r1 = r9.b0(r1)
            goto L99
        L2f:
            us.pinguo.edit2020.viewmodel.module.f r9 = r8.f10811h
            us.pinguo.repository2020.u r9 = r9.i()
            java.lang.Object r9 = r9.getValue()
            us.pinguo.edit2020.viewmodel.FunctionType r9 = (us.pinguo.edit2020.viewmodel.FunctionType) r9
            us.pinguo.edit2020.viewmodel.module.f r1 = r8.f10811h
            boolean r1 = r1.v(r9)
            goto L99
        L42:
            us.pinguo.edit2020.viewmodel.module.AdjustModule r9 = r8.f10810g
            java.util.List r9 = r9.g()
            boolean r3 = r9 instanceof java.util.Collection
            if (r3 == 0) goto L53
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L53
            goto L23
        L53:
            java.util.Iterator r9 = r9.iterator()
        L57:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L23
            java.lang.Object r3 = r9.next()
            us.pinguo.edit2020.bean.a r3 = (us.pinguo.edit2020.bean.a) r3
            boolean r3 = r3.e()
            if (r3 == 0) goto L57
            goto L99
        L6a:
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r9 = r8.f10807d
            us.pinguo.repository2020.u r9 = r9.y()
            java.lang.Object r9 = r9.getValue()
            us.pinguo.repository2020.entity.FilterEntry r9 = (us.pinguo.repository2020.entity.FilterEntry) r9
            if (r9 != 0) goto L7a
            r9 = r0
            goto L7e
        L7a:
            java.lang.String r9 = r9.getItemId()
        L7e:
            java.lang.String r3 = "C360_None"
            boolean r9 = kotlin.jvm.internal.s.c(r9, r3)
            if (r9 != 0) goto L23
            goto L99
        L87:
            us.pinguo.edit2020.viewmodel.module.EditBeautyModule r9 = r8.c
            us.pinguo.repository2020.u r9 = r9.t()
            java.lang.Object r9 = r9.getValue()
            us.pinguo.edit2020.viewmodel.FunctionType r9 = (us.pinguo.edit2020.viewmodel.FunctionType) r9
            us.pinguo.edit2020.viewmodel.module.EditBeautyModule r1 = r8.c
            boolean r1 = r1.b0(r9)
        L99:
            kotlinx.coroutines.g2 r9 = kotlinx.coroutines.z0.c()
            kotlinx.coroutines.m0 r2 = kotlinx.coroutines.n0.a(r9)
            r3 = 0
            r4 = 0
            us.pinguo.edit2020.viewmodel.EditViewModel$save$1 r5 = new us.pinguo.edit2020.viewmodel.EditViewModel$save$1
            r5.<init>(r8, r1, r10, r0)
            r6 = 3
            r7 = 0
            kotlinx.coroutines.j.d(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.EditViewModel.E(us.pinguo.edit2020.controller.EditTabType, kotlin.jvm.b.a):void");
    }

    public final void F(ActivityResult result) {
        s.h(result, "result");
        l.d(ViewModelKt.getViewModelScope(this), null, null, new EditViewModel$sendActivityResult$1(this, result, null), 3, null);
    }

    public final void G() {
        this.r.postValue("");
    }

    public final void H(String path) {
        s.h(path, "path");
        this.u.postValue(path);
    }

    public final void I(String str) {
        this.f10814k = str;
    }

    public final void K(e eVar) {
        s.h(eVar, "<set-?>");
        this.f10808e = eVar;
    }

    public final void L() {
        boolean z;
        String str;
        boolean p;
        String str2 = this.f10814k;
        if (str2 != null) {
            p = t.p(str2);
            if (!p) {
                z = false;
                if (z && (str = this.f10814k) != null) {
                    EditRender.v0(l(), str, false, true, 2, null);
                }
                return;
            }
        }
        z = true;
        if (z) {
            return;
        }
        EditRender.v0(l(), str, false, true, 2, null);
    }

    public final void M(kotlin.jvm.b.a<u> aVar) {
        this.p = aVar;
    }

    public final void N(boolean z) {
        this.f10812i = z;
    }

    public final void O(boolean z) {
        this.f10813j = z;
    }

    public final void P(TextureView textureView) {
        s.h(textureView, "textureView");
        this.b.C0(textureView);
    }

    public final void Q(TextureView textureView, kotlin.jvm.b.l<? super Boolean, u> lVar) {
        s.h(textureView, "textureView");
        this.b.G0(textureView, lVar);
    }

    public final void R(kotlin.jvm.b.a<u> callback) {
        s.h(callback, "callback");
        this.b.I0(callback);
    }

    public final void S(kotlin.jvm.b.a<u> aVar) {
        this.n = aVar;
    }

    public final void T(ActivityResultLauncher<Intent> activityResultLauncher) {
        this.v = activityResultLauncher;
    }

    public final void U(boolean z) {
        this.q = z;
    }

    public final void V(kotlin.jvm.b.a<u> callback) {
        s.h(callback, "callback");
        this.b.o1(callback);
    }

    public final void W(List<? extends x> list) {
        this.o = list;
    }

    public final void X(boolean z) {
        UnityEditCaller.Common.showOriginalTexture(z);
    }

    public final void Y(String action) {
        s.h(action, "action");
        l.d(n0.a(z0.b()), null, null, new EditViewModel$statSourceAction$1(this, action, null), 3, null);
    }

    public final void Z(ImageView view) {
        String picturePath;
        s.h(view, "view");
        HistoryRecord f2 = j().a().f();
        if (f2 == null || (picturePath = f2.getPicturePath()) == null) {
            return;
        }
        I(picturePath);
        view.setImageBitmap(us.pinguo.util.e.w(picturePath, us.pinguo.foundation.utils.n0.h(), 1, true));
        EditRender.v0(l(), picturePath, j().a().b(), false, 4, null);
    }

    public final void c(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
        s.h(normalizedFocusPoint, "normalizedFocusPoint");
        s.h(normalizedOffset, "normalizedOffset");
        this.b.l(normalizedFocusPoint, f2, normalizedOffset, i2);
    }

    public final void clear() {
        u0 value = this.b.L().getValue();
        boolean z = false;
        if (value != null && value.i()) {
            z = true;
        }
        if (z) {
            c(new PointF(0.5f, 0.5f), 1.0f, new PointF(0.0f, 0.0f), 200);
        }
        this.b.q();
    }

    public final void d() {
        EditRender editRender = (EditRender) this.f10809f.getEditRender();
        boolean z = false;
        if (editRender != null && editRender.F() == this.a) {
            z = true;
        }
        if (z) {
            this.f10809f.setEditRender(null);
        }
        this.b.s();
    }

    public final void e(kotlin.jvm.b.l<? super String, u> lVar) {
        us.pinguo.edit2020.manager.c a2 = j().a();
        HistoryRecord c = a2.c();
        if (c == null) {
            CrashReport.postCatchedException(new IllegalArgumentException("empty record"));
            return;
        }
        String picturePath = c.getPicturePath();
        if (!new File(picturePath).exists()) {
            CrashReport.postCatchedException(new IllegalStateException(s.q("no such file:", picturePath)));
            return;
        }
        try {
            int attributeInt = new ExifInterface(picturePath).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            int i2 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : BaseBlurEffect.ROTATION_270 : 90 : BaseBlurEffect.ROTATION_180;
            byte[] d2 = j.d(a2.e().get(0).getPicturePath());
            Saver2020 saver2020 = Saver2020.a;
            String picturePath2 = c.getPicturePath();
            HistoryRecord d3 = a2.d();
            saver2020.e(picturePath, i2, null, null, d2, false, !s.c(picturePath2, d3 == null ? null : d3.getPicturePath()), new EditViewModel$finalSave$1(lVar));
        } catch (Exception e2) {
            e2.printStackTrace();
            CrashReport.postCatchedException(e2);
        }
    }

    public final AdjustModule f() {
        return this.f10810g;
    }

    public final String g() {
        return this.f10814k;
    }

    public final EditBeautyModule h() {
        return this.c;
    }

    public final EditFilterModule i() {
        return this.f10807d;
    }

    public final void initRender() {
        int i2;
        this.b.O();
        this.b.U0(this.a);
        this.f10809f.setEditRender(this.b);
        this.b.T0(new b());
        K(new e(this.m, this.f10815l));
        List<HistoryRecord> list = this.m;
        if (!(list == null || list.isEmpty()) && (i2 = this.f10815l) >= 0 && i2 < list.size()) {
            this.f10814k = list.get(this.f10815l).getPicturePath();
        }
        this.b.J0(EditViewModel$initRender$2.INSTANCE);
        this.f10811h.o().s(new EditViewModel$initRender$3(this));
        this.f10811h.n().w(new EditViewModel$initRender$4(this));
        this.c.D().f0(new EditViewModel$initRender$5(this));
        this.f10811h.k().C0(j());
        this.f10811h.p().z0(kotlinx.coroutines.flow.e.z(z()));
        this.f10811h.p().y0(this.v);
        this.f10811h.j().z0(j());
        this.f10811h.j().x0(new EditViewModel$initRender$6(this));
        this.c.C().i(new EditViewModel$initRender$7(this));
        J(-1118482);
    }

    public final e j() {
        e eVar = this.f10808e;
        if (eVar != null) {
            return eVar;
        }
        s.z("editHistoryModule");
        throw null;
    }

    public final f k() {
        return this.f10811h;
    }

    public final EditRender l() {
        return this.b;
    }

    public final kotlin.jvm.b.a<u> m() {
        return this.p;
    }

    public final Integer[] n() {
        return this.w;
    }

    public final us.pinguo.repository2020.u<us.pinguo.facedetector.c> o() {
        return this.b.z();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        us.pinguo.common.log.a.e("ON_STOP", new Object[0]);
        this.f10811h.w();
    }

    public final boolean p() {
        return this.f10813j;
    }

    public final us.pinguo.repository2020.u<String> q() {
        return this.u;
    }

    public final kotlin.jvm.b.a<u> r() {
        return this.n;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        us.pinguo.common.log.a.e("ON_DESTROY", new Object[0]);
        this.f10811h.y();
    }

    public final LiveData<String> s() {
        return this.s;
    }

    public final boolean t() {
        return this.q;
    }

    public final us.pinguo.repository2020.u<u0> w() {
        return this.b.L();
    }

    public final List<x> x() {
        return this.o;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 771
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:59)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:394:0x0eea -> B:395:0x0f18). Please submit an issue!!! */
    public final java.lang.Object y(kotlin.coroutines.Continuation<? super java.util.ArrayList<java.lang.String>> r66) {
        /*
            Method dump skipped, instructions count: 5102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.EditViewModel.y(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
