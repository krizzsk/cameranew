package us.pinguo.camera2020.module;

import androidx.lifecycle.LiveData;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.model.Scene;
import us.pinguo.camera2020.model.render.UnityRender;
import us.pinguo.foundation.j;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.k0;
import us.pinguo.image.saver.Saver2020;
import us.pinguo.librouter.b.c.f;
import us.pinguo.location.d;
import us.pinguo.processor.PreviewProcessState;
import us.pinguo.processor.i;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.u;
import us.pinguo.svideo.bean.VideoInfo;
import us.pinguo.u3dengine.api.WatermarkStyle;
/* compiled from: AfterCaptureModule.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureModule {
    private final UnityRender a;
    private volatile String b;
    private volatile int c;

    /* renamed from: d  reason: collision with root package name */
    private volatile AfterCaptureMode f9207d;

    /* renamed from: e  reason: collision with root package name */
    private volatile VideoInfo f9208e;

    /* renamed from: f  reason: collision with root package name */
    private final u<c> f9209f;

    /* renamed from: g  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f9210g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f9211h;

    /* renamed from: i  reason: collision with root package name */
    private l<? super Integer, kotlin.u> f9212i;

    /* renamed from: j  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f9213j;

    /* renamed from: k  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f9214k;

    /* renamed from: l  reason: collision with root package name */
    private final u<Boolean> f9215l;
    private SaveReason m;
    private l<? super String, kotlin.u> n;
    private kotlin.jvm.b.a<kotlin.u> o;
    private us.pinguo.image.saver.b p;
    private boolean q;
    private boolean r;

    /* compiled from: AfterCaptureModule.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Scene.values().length];
            iArr[Scene.HD_IMAGE.ordinal()] = 1;
            iArr[Scene.SCREEN_IMAGE.ordinal()] = 2;
            iArr[Scene.AUTO_SAVE.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[SaveReason.values().length];
            iArr2[SaveReason.USER.ordinal()] = 1;
            iArr2[SaveReason.EDIT.ordinal()] = 2;
            iArr2[SaveReason.SHARE.ordinal()] = 3;
            b = iArr2;
            int[] iArr3 = new int[AfterCaptureMode.values().length];
            iArr3[AfterCaptureMode.VIDEO.ordinal()] = 1;
            iArr3[AfterCaptureMode.PHOTO.ordinal()] = 2;
            c = iArr3;
        }
    }

    public AfterCaptureModule(UnityRender unityRender) {
        s.h(unityRender, "unityRender");
        this.a = unityRender;
        this.f9209f = new u<>();
        this.f9215l = new u<>(Boolean.FALSE);
        this.m = SaveReason.USER;
    }

    private final boolean o() {
        if (this.f9207d != AfterCaptureMode.VIDEO) {
            i iVar = i.a;
            boolean z = iVar.f() == PreviewProcessState.START;
            boolean z2 = iVar.f() == PreviewProcessState.LONG_RENDERING;
            if (!z && !z2) {
                if (iVar.f() == PreviewProcessState.CANCLING) {
                    k0.a.c(R.string.canceling_task);
                    return true;
                }
            } else {
                iVar.c();
                if (z2) {
                    k0.a.c(R.string.canceling_task);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.f9209f.postValue(new c(null, PhotoState.FAILED));
        this.f9207d = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        if (o()) {
            return;
        }
        this.f9209f.setValue(new c(null, PhotoState.DISCARDED));
        this.f9207d = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str) {
        this.f9209f.postValue(new c(str, PhotoState.SAVED));
        this.f9207d = null;
        this.b = null;
    }

    private final void y(String str, int i2, boolean z) {
        boolean z2;
        if (!new File(str).exists()) {
            u();
            return;
        }
        f e2 = s.c(j.e().k("pref_camera_recordlocation_key", "off"), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON) ? d.c().e() : null;
        us.pinguo.image.saver.b bVar = this.p;
        if (bVar != null) {
            bVar.f(s.c(j.e().k("pref_camera_saveorg_key", "off"), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON));
        }
        us.pinguo.image.saver.b bVar2 = this.p;
        if (bVar2 != null) {
            m mVar = m.a;
            if (s.c(mVar.y().getValue(), Boolean.TRUE)) {
                Boolean value = mVar.j().getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                z2 = value.booleanValue();
            } else {
                z2 = false;
            }
            bVar2.e(z2);
        }
        Saver2020.a.e(str, i2, e2, this.p, (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? true : !z, true, new AfterCaptureModule$saveToDb$1(z, this));
    }

    static /* synthetic */ void z(AfterCaptureModule afterCaptureModule, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        afterCaptureModule.y(str, i2, z);
    }

    public final void A(boolean z) {
        this.q = z;
    }

    public final void B(l<? super Integer, kotlin.u> lVar) {
        this.f9212i = lVar;
    }

    public final void C(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.f9213j = aVar;
    }

    public final void D(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.f9214k = aVar;
    }

    public final void E(AfterCaptureMode afterCaptureMode) {
        this.f9207d = afterCaptureMode;
    }

    public final void F(us.pinguo.image.saver.b bVar) {
        this.p = bVar;
    }

    public final void G(l<? super String, kotlin.u> lVar) {
        this.n = lVar;
    }

    public final void H(boolean z) {
        this.r = z;
    }

    public final void I(VideoInfo videoInfo) {
        this.f9208e = videoInfo;
    }

    public final void J(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.o = aVar;
    }

    public final void K() {
        SaveReason saveReason = this.m;
        h.b.h0();
        this.m = SaveReason.SHARE;
        if (this.f9207d == AfterCaptureMode.PHOTO && (this.b == null || saveReason == SaveReason.SKY_CHANGE)) {
            this.f9215l.setValue(Boolean.TRUE);
            kotlin.jvm.b.a<kotlin.u> aVar = this.f9210g;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        } else if (this.f9207d == AfterCaptureMode.VIDEO) {
            kotlin.jvm.b.a<kotlin.u> aVar2 = this.f9214k;
            if (aVar2 == null) {
                return;
            }
            aVar2.invoke();
        } else if (this.b == null) {
            u();
        } else {
            kotlin.jvm.b.a<kotlin.u> aVar3 = this.f9213j;
            if (aVar3 == null) {
                return;
            }
            aVar3.invoke();
        }
    }

    public final void L(boolean z) {
        this.a.n0(z);
    }

    public final void M() {
        this.m = SaveReason.SKY_CHANGE;
        if (this.f9207d == AfterCaptureMode.PHOTO && this.b == null) {
            this.f9215l.postValue(Boolean.TRUE);
            kotlin.jvm.b.a<kotlin.u> aVar = this.f9211h;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    public final void N(Integer num) {
        Integer h2;
        boolean c = s.c(j.e().k("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
        String k2 = j.e().k("key_watermark_type", "0");
        s.g(k2, "get().getString(CameraBu….KEY_WATERMARK_TYPE, \"0\")");
        h2 = kotlin.text.s.h(k2);
        int intValue = h2 == null ? 1 : h2.intValue();
        if (num != null || c) {
            if (c && num != null && num.intValue() == intValue) {
                return;
            }
            if (num == null) {
                this.a.C0(WatermarkStyle.NONE);
                j.e().s("key_watermark_new", "off");
                return;
            }
            if (num.intValue() == 0) {
                this.a.C0(WatermarkStyle.STYLE_0);
            } else if (num.intValue() == 1) {
                this.a.C0(WatermarkStyle.STYLE_1);
            } else if (num.intValue() == 2) {
                this.a.C0(WatermarkStyle.STYLE_2);
            } else if (num.intValue() == 3) {
                this.a.C0(WatermarkStyle.STYLE_3);
            } else if (num.intValue() == 4) {
                this.a.C0(WatermarkStyle.STYLE_4);
            } else if (num.intValue() == 5) {
                this.a.C0(WatermarkStyle.STYLE_5);
            } else if (num.intValue() == 6) {
                this.a.C0(WatermarkStyle.STYLE_6);
            }
            j.e().s("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
            j.e().s("key_watermark_type", String.valueOf(num));
            e();
        }
    }

    public final void e() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AfterCaptureModule$clearTempPath$1(this, null), 3, null);
    }

    public final void f() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AfterCaptureModule$discard$1(this, null), 3, null);
    }

    public final boolean g() {
        return this.q;
    }

    public final SaveReason h() {
        return this.m;
    }

    public final AfterCaptureMode i() {
        return this.f9207d;
    }

    public final l<String, kotlin.u> j() {
        return this.n;
    }

    public final LiveData<c> k() {
        return this.f9209f;
    }

    public final String l() {
        return this.b;
    }

    public final VideoInfo m() {
        return this.f9208e;
    }

    public final void n() {
        SaveReason saveReason = this.m;
        this.m = SaveReason.EDIT;
        if (this.f9207d == AfterCaptureMode.PHOTO && (this.b == null || saveReason == SaveReason.SKY_CHANGE)) {
            this.f9215l.setValue(Boolean.TRUE);
            kotlin.jvm.b.a<kotlin.u> aVar = this.f9210g;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
            return;
        }
        l<? super Integer, kotlin.u> lVar = this.f9212i;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Integer.valueOf(this.c));
    }

    public final void p(kotlin.jvm.b.a<kotlin.u> procedure) {
        s.h(procedure, "procedure");
        this.f9210g = procedure;
    }

    public final void q(kotlin.jvm.b.a<kotlin.u> procedure) {
        s.h(procedure, "procedure");
        this.f9211h = procedure;
    }

    public final u<Boolean> r() {
        return this.f9215l;
    }

    public final boolean s() {
        return this.r;
    }

    public final void t(String path, int i2, Scene scene) {
        kotlin.jvm.b.a<kotlin.u> aVar;
        s.h(path, "path");
        s.h(scene, "scene");
        this.b = path;
        int i3 = a.a[scene.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this.c = i2;
                return;
            } else if (i3 != 3) {
                return;
            } else {
                z(this, path, i2, false, 4, null);
                return;
            }
        }
        int i4 = a.b[this.m.ordinal()];
        if (i4 == 1) {
            z(this, path, i2, false, 4, null);
        } else if (i4 != 2) {
            if (i4 == 3 && (aVar = this.f9213j) != null) {
                aVar.invoke();
            }
        } else {
            l<? super Integer, kotlin.u> lVar = this.f9212i;
            if (lVar == null) {
                return;
            }
            lVar.invoke(Integer.valueOf(i2));
        }
    }

    public final void x() {
        SaveReason saveReason = this.m;
        this.m = SaveReason.USER;
        AfterCaptureMode afterCaptureMode = this.f9207d;
        int i2 = afterCaptureMode == null ? -1 : a.c[afterCaptureMode.ordinal()];
        if (i2 == 1) {
            kotlin.jvm.b.a<kotlin.u> aVar = this.o;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        } else if (i2 != 2) {
            String str = this.b;
            if (str == null) {
                u();
            } else {
                z(this, str, this.c, false, 4, null);
            }
        } else if (this.b != null && saveReason != SaveReason.SKY_CHANGE) {
            String str2 = this.b;
            s.e(str2);
            z(this, str2, this.c, false, 4, null);
        } else {
            kotlin.jvm.b.a<kotlin.u> aVar2 = this.f9210g;
            if (aVar2 == null) {
                return;
            }
            aVar2.invoke();
        }
    }
}
