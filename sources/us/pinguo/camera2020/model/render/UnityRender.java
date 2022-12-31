package us.pinguo.camera2020.model.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.pinguo.lib.HardwareInfo;
import com.pinguo.lib.LowerResolutionCpuMobile;
import java.util.HashMap;
import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.b.s;
import kotlin.jvm.internal.o;
import kotlin.u;
import us.pinguo.camera2020.model.Scene;
import us.pinguo.camera2020.model.render.c;
import us.pinguo.libblingbling.BlingBling;
import us.pinguo.processor.PreviewProcessState;
import us.pinguo.processor.ShaderCache;
import us.pinguo.processor.e;
import us.pinguo.processor.i;
import us.pinguo.u3dengine.Module;
import us.pinguo.u3dengine.UnityControlCaller;
import us.pinguo.u3dengine.api.BlingBlingTextureInfo;
import us.pinguo.u3dengine.api.CaptureModel;
import us.pinguo.u3dengine.api.EngineMode;
import us.pinguo.u3dengine.api.HDCameraSessionResult;
import us.pinguo.u3dengine.api.NativeFacesData;
import us.pinguo.u3dengine.api.RenderState;
import us.pinguo.u3dengine.api.ScreenOrientation;
import us.pinguo.u3dengine.api.UnityCallbackAdapter;
import us.pinguo.u3dengine.api.UnityMethodCaller;
import us.pinguo.u3dengine.api.WatermarkStyle;
import us.pinguo.util.m;
/* compiled from: UnityRender.kt */
/* loaded from: classes3.dex */
public final class UnityRender implements us.pinguo.cameramanger.viewfinder.a {
    private static String I;
    private int A;
    private boolean B;
    private boolean C;
    private volatile boolean D;
    private final m E;
    private final UnityCallbackAdapter F;
    private int a;
    private b b;
    private RenderState c;

    /* renamed from: d  reason: collision with root package name */
    private final BlingBlingTextureInfo f9185d;

    /* renamed from: e  reason: collision with root package name */
    private final NativeFacesData f9186e;

    /* renamed from: f  reason: collision with root package name */
    private NativeFacesData f9187f;

    /* renamed from: g  reason: collision with root package name */
    private final us.pinguo.camera2020.model.render.c f9188g;

    /* renamed from: h  reason: collision with root package name */
    private final us.pinguo.camera2020.model.render.b f9189h;

    /* renamed from: i  reason: collision with root package name */
    private l<? super Scene, u> f9190i;

    /* renamed from: j  reason: collision with root package name */
    private l<? super CaptureModel, u> f9191j;

    /* renamed from: k  reason: collision with root package name */
    private q<? super String, ? super Integer, ? super Scene, u> f9192k;

    /* renamed from: l  reason: collision with root package name */
    private final HDCameraSessionResult f9193l;
    private final us.pinguo.repository2020.u<Size> m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private l<? super String, us.pinguo.processor.d> w;
    private l<? super String, Boolean> x;
    private s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> y;
    private boolean z;
    public static final a G = new a(null);
    private static final us.pinguo.processor.c H = new us.pinguo.processor.c(ShaderCache.a.a());
    private static final HashMap<String, Integer> J = new HashMap<>();

    /* compiled from: UnityRender.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnityRender.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private Scene a;
        private Scene b;

        public b() {
            Scene scene = Scene.NONE;
            this.a = scene;
            this.b = scene;
        }

        public final Scene a() {
            return this.b;
        }

        public final Scene b() {
            return this.a;
        }

        public final void c(Scene scene) {
            kotlin.jvm.internal.s.h(scene, "scene");
            this.a = scene;
            us.pinguo.common.log.a.c("switchScene, currentScene=" + this.b + ", nextScene=" + this.a, new Object[0]);
        }

        public final void d() {
            this.b = this.a;
        }
    }

    /* compiled from: UnityRender.kt */
    /* loaded from: classes3.dex */
    public static final class c implements c.a {
        final /* synthetic */ kotlin.jvm.b.a<u> b;

        c(kotlin.jvm.b.a<u> aVar) {
            this.b = aVar;
        }

        @Override // us.pinguo.camera2020.model.render.c.a
        public void a() {
            UnityRender.this.n = false;
            UnityMethodCaller.startRender();
            this.b.invoke();
        }
    }

    /* compiled from: UnityRender.kt */
    /* loaded from: classes3.dex */
    public static final class d extends UnityCallbackAdapter {
        private Scene a = Scene.CAMERA_PREVIEW;

        /* compiled from: UnityRender.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Scene.values().length];
                iArr[Scene.CAMERA_PREVIEW.ordinal()] = 1;
                iArr[Scene.AFTER_VIDEO_RECORD.ordinal()] = 2;
                iArr[Scene.VIDEO_RECORD.ordinal()] = 3;
                iArr[Scene.AFTER_CAPTURE.ordinal()] = 4;
                iArr[Scene.HD_IMAGE.ordinal()] = 5;
                iArr[Scene.AFTER_SCREEN_IMAGE.ordinal()] = 6;
                a = iArr;
            }
        }

        d() {
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public boolean changeFilter(String filterPath) {
            kotlin.jvm.internal.s.h(filterPath, "filterPath");
            l<String, us.pinguo.processor.d> P = UnityRender.this.P();
            us.pinguo.processor.d invoke = P == null ? null : P.invoke(filterPath);
            if (invoke == null) {
                invoke = e.a();
            }
            invoke.e(UnityRender.H.n().d());
            UnityRender.H.p(invoke);
            return true;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public boolean changeMakeUp(String makeupPath) {
            Boolean invoke;
            kotlin.jvm.internal.s.h(makeupPath, "makeupPath");
            l<String, Boolean> Q = UnityRender.this.Q();
            if (Q == null || (invoke = Q.invoke(makeupPath)) == null) {
                return true;
            }
            return invoke.booleanValue();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityFilterCallbackApi
        public long getBlingBlingRenderResult() {
            return BlingBling.getRenderResult();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public HDCameraSessionResult getCameraSessionResult() {
            us.pinguo.common.log.a.q("getCameraSessionResult start", new Object[0]);
            int i2 = !UnityRender.this.X();
            HDCameraSessionResult hDCameraSessionResult = UnityRender.this.f9193l;
            UnityRender unityRender = UnityRender.this;
            hDCameraSessionResult.setRotation((unityRender.X() || unityRender.L() != 270) ? 0 : BaseBlurEffect.ROTATION_180);
            hDCameraSessionResult.setCameraPressent(unityRender.X() ? 1 : 0);
            hDCameraSessionResult.setVerFlip(i2);
            hDCameraSessionResult.setTextureWidth(unityRender.V().h());
            hDCameraSessionResult.setTextureHeight(unityRender.V().g());
            int e2 = unityRender.V().e();
            if (e2 != -1) {
                hDCameraSessionResult.setInputTextureID(e2);
            }
            if (unityRender.n) {
                hDCameraSessionResult.setInputTextureID(-1);
            }
            if (unityRender.z) {
                int textureWidth = hDCameraSessionResult.getTextureWidth() < hDCameraSessionResult.getTextureHeight() ? hDCameraSessionResult.getTextureWidth() : hDCameraSessionResult.getTextureHeight();
                hDCameraSessionResult.setOutputWidth(textureWidth);
                hDCameraSessionResult.setOutputHeight(textureWidth);
            } else {
                hDCameraSessionResult.setOutputWidth(hDCameraSessionResult.getTextureWidth());
                hDCameraSessionResult.setOutputHeight(hDCameraSessionResult.getTextureHeight());
            }
            us.pinguo.common.log.a.q("getCameraSessionResult end, output=" + hDCameraSessionResult.getOutputWidth() + " x " + hDCameraSessionResult.getOutputHeight(), new Object[0]);
            if (unityRender.C && hDCameraSessionResult.getOutputWidth() > 720) {
                hDCameraSessionResult.setOutputWidth(720);
                hDCameraSessionResult.setOutputHeight((int) (hDCameraSessionResult.getOutputWidth() * (hDCameraSessionResult.getOutputHeight() / hDCameraSessionResult.getOutputWidth())));
                us.pinguo.common.log.a.q("LowerResolution, output=" + hDCameraSessionResult.getOutputWidth() + " x " + hDCameraSessionResult.getOutputHeight(), new Object[0]);
            }
            return hDCameraSessionResult;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public HDCameraSessionResult getCaptureSessionResult() {
            us.pinguo.common.log.a.q("getCaptureSessionResult", new Object[0]);
            int i2 = a.a[UnityRender.this.b.a().ordinal()];
            if (i2 != 3) {
                if (i2 != 5) {
                    HDCameraSessionResult c = UnityRender.this.f9189h.c();
                    us.pinguo.common.log.a.c("session, CaputureMirrorState=" + c.getCaputureMirrorState() + ", MirrorState=" + c.getMirrorState(), new Object[0]);
                    return c;
                }
                return UnityRender.this.f9189h.d();
            }
            HDCameraSessionResult hDCameraSessionResult = new HDCameraSessionResult();
            UnityRender unityRender = UnityRender.this;
            if (unityRender.z) {
                int h2 = unityRender.V().h();
                int g2 = unityRender.V().g();
                if (h2 >= g2) {
                    h2 = g2;
                }
                hDCameraSessionResult.setOutputWidth(h2);
                hDCameraSessionResult.setOutputHeight(h2);
            } else {
                hDCameraSessionResult.setOutputWidth(unityRender.V().h());
                hDCameraSessionResult.setOutputHeight(unityRender.V().g());
            }
            us.pinguo.common.log.a.c("VIDEO_RECORD, w=" + hDCameraSessionResult.getOutputWidth() + ", h=" + hDCameraSessionResult.getOutputHeight(), new Object[0]);
            hDCameraSessionResult.setCaputureMirrorState(0);
            return hDCameraSessionResult;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public int getImageSaveQuality() {
            return UnityRender.this.a;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public NativeFacesData getNativeFaceData() {
            us.pinguo.common.log.a.q("getNativeFaceData", new Object[0]);
            int i2 = a.a[UnityRender.this.b.a().ordinal()];
            if (i2 != 2) {
                return i2 != 4 ? UnityRender.this.f9187f : UnityRender.this.f9189h.f();
            }
            return UnityRender.this.f9186e;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityFilterCallbackApi
        public int getNativeFilterResult() {
            us.pinguo.common.log.a.q("getNativeFilterResult", new Object[0]);
            int i2 = a.a[UnityRender.this.b.a().ordinal()];
            if (i2 != 2) {
                if (i2 == 4) {
                    return UnityRender.this.f9189h.g();
                }
                return UnityRender.this.V().f();
            }
            return -1;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public int getSubSticker() {
            Integer num = (Integer) UnityRender.J.get(UnityRender.I);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
        public void glCleanUp() {
            us.pinguo.common.log.a.c("glCleanUp", new Object[0]);
            UnityRender.this.V().i();
            UnityRender.this.H();
            i.a.e();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
        public void glRenderBeforeGetCameraSession() {
            us.pinguo.common.log.a.q(kotlin.jvm.internal.s.q("glRenderBeforeGetCameraSession:", Thread.currentThread().getName()), new Object[0]);
            UnityRender.this.H();
            UnityRender.this.V().k();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
        public void glRenderBeforeGetCaptureSession() {
            us.pinguo.common.log.a.q(kotlin.jvm.internal.s.q("glRenderBeforeGetCaptureSession:", UnityRender.this.b.a()), new Object[0]);
            if (a.a[UnityRender.this.b.a().ordinal()] == 5) {
                return;
            }
            UnityRender unityRender = UnityRender.this;
            unityRender.A = unityRender.f9189h.j(UnityRender.this.X(), UnityRender.this.s, UnityRender.H.m(), UnityRender.this.L(), UnityRender.this.z);
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void glRenderBlingBlingFilter() {
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
        public void glRenderNativeFilter() {
            us.pinguo.common.log.a.q("glRenderNativeFilter", new Object[0]);
            int i2 = a.a[UnityRender.this.b.a().ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        UnityRender.this.V().c(UnityRender.this.z);
                        return;
                    }
                    UnityRender.this.f9189h.b();
                    i.a.j(PreviewProcessState.COMPLETE);
                    return;
                }
                UnityRender.this.V().c(UnityRender.this.z);
                if (UnityRender.this.r > 0) {
                    int h2 = UnityRender.this.V().h();
                    int g2 = UnityRender.this.V().g();
                    if (UnityRender.this.z) {
                        if (h2 >= g2) {
                            h2 = g2;
                        }
                        us.pinguo.camera2020.utils.d.d.f(UnityRender.this.r, h2, h2);
                        return;
                    }
                    us.pinguo.camera2020.utils.d.d.f(UnityRender.this.r, h2, g2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x009a, code lost:
            if (r7 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x009d, code lost:
            if (r7 != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
            r3 = 90;
         */
        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onImageSaved(java.lang.String r6, us.pinguo.u3dengine.api.CaptureModel r7) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.model.render.UnityRender.d.onImageSaved(java.lang.String, us.pinguo.u3dengine.api.CaptureModel):void");
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void onRenderImageEnd(CaptureModel captureModel) {
            kotlin.jvm.internal.s.h(captureModel, "captureModel");
            us.pinguo.common.log.a.c("onRenderImageEnd", new Object[0]);
            l<CaptureModel, u> M = UnityRender.this.M();
            if (M == null) {
                return;
            }
            M.invoke(captureModel);
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void onSubStickerSelect(int i2) {
            String str = UnityRender.I;
            if (str == null) {
                return;
            }
            UnityRender.J.put(str, Integer.valueOf(i2));
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void onUnityRenderEnd() {
            l<Scene, u> O;
            l<Scene, u> O2;
            UnityRender.this.E.a();
            us.pinguo.common.log.a.q("onUnityRenderEnd, last=" + this.a + ", current=" + UnityRender.this.b.a(), new Object[0]);
            int i2 = a.a[UnityRender.this.b.a().ordinal()];
            if (i2 == 2) {
                UnityRender.this.x0(RenderState.ONLY_FILTER_OPACITY);
            } else if (i2 == 3) {
                if (UnityRender.this.r == -1 || !UnityRender.this.U()) {
                    return;
                }
                int h2 = UnityRender.this.V().h();
                int g2 = UnityRender.this.V().g();
                if (UnityRender.this.z) {
                    if (h2 >= g2) {
                        h2 = g2;
                    }
                    us.pinguo.camera2020.utils.d.d.f(UnityRender.this.r, h2, h2);
                    return;
                }
                us.pinguo.camera2020.utils.d.d.f(UnityRender.this.r, h2, g2);
            } else if (i2 != 4) {
                if (i2 != 6) {
                    return;
                }
                Scene scene = this.a;
                Scene scene2 = Scene.AFTER_SCREEN_IMAGE;
                if (scene == scene2 || (O2 = UnityRender.this.O()) == null) {
                    return;
                }
                O2.invoke(scene2);
            } else {
                if (UnityRender.this.B) {
                    UnityRender.this.x0(RenderState.NORMAL);
                    UnityRender.this.B = false;
                } else if (UnityRender.this.o) {
                    UnityRender.this.B0(false);
                    UnityRender.this.x0(RenderState.ORG_TEXTURE);
                } else {
                    UnityRender.this.B0(true);
                    UnityRender.this.x0(RenderState.ONLY_FILTER_OPACITY);
                }
                Scene scene3 = this.a;
                Scene scene4 = Scene.AFTER_CAPTURE;
                if (scene3 == scene4 || scene3 == Scene.HD_IMAGE || (O = UnityRender.this.O()) == null) {
                    return;
                }
                O.invoke(scene4);
            }
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void onUnityRenderStart() {
            this.a = UnityRender.this.b.a();
            UnityRender.this.b.d();
            Scene a2 = UnityRender.this.b.a();
            us.pinguo.common.log.a.q("onUnityRenderStart, last:" + this.a + ", current:" + a2, new Object[0]);
            int i2 = a.a[a2.ordinal()];
            if (i2 == 1) {
                if (this.a != Scene.CAMERA_PREVIEW) {
                    UnityRender.this.B0(false);
                }
                if (UnityRender.this.p) {
                    UnityRender.this.x0(RenderState.SOFT_SKIN_AND_FILTER);
                } else {
                    UnityRender.this.x0(RenderState.NORMAL);
                }
            } else if (i2 != 2) {
                if (i2 == 3 && UnityRender.this.q) {
                    UnityRender.this.q = false;
                    UnityMethodCaller.startRecord();
                }
            } else {
                UnityRender.this.x0(RenderState.ONLY_FILTER_OPACITY);
            }
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void onVideoRecordPrepared(int i2) {
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("onVideoRecordPrepared:", Integer.valueOf(i2)), new Object[0]);
            UnityRender.this.r = i2;
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void preCameraSessionResult() {
            us.pinguo.common.log.a.q("preCameraSessionResult", new Object[0]);
            UnityRender.this.V().m();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityCallbackApi
        public void preCaptureSessionResult() {
            us.pinguo.common.log.a.q("preCaptureSessionResult", new Object[0]);
            if (a.a[UnityRender.this.b.a().ordinal()] == 5) {
                return;
            }
            UnityRender.this.f9189h.k();
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityFilterCallbackApi
        public void preNativeFilterResult(int i2, int i3, int i4) {
            us.pinguo.common.log.a.q("preNativeFilterResult", new Object[0]);
            int i5 = a.a[UnityRender.this.b.a().ordinal()];
            if (i5 != 2) {
                if (i5 == 4) {
                    UnityRender.this.f9189h.l(i2, i3, i4);
                } else {
                    UnityRender.this.V().q(i2);
                }
            }
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityFilterCallbackApi
        public void receiveBlingBlingTextureInfo(int i2, int i3, int i4, int i5) {
            UnityRender.this.f9185d.setTid(i2);
            UnityRender.this.f9185d.setWidth(i3);
            UnityRender.this.f9185d.setHeight(i4);
            UnityRender.this.f9185d.setMaxCount(i5);
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityFilterCallbackApi
        public void reportSkyChangeRenderComplete(String uid, float f2, float f3, float f4, float f5) {
            kotlin.jvm.internal.s.h(uid, "uid");
            us.pinguo.common.log.a.k("reportSkyChangeRenderComplete:" + f2 + ',' + f3 + ',' + f4 + ',' + f5, new Object[0]);
            s<String, Float, Float, Float, Float, u> R = UnityRender.this.R();
            if (R == null) {
                return;
            }
            R.invoke(uid, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
        }

        @Override // us.pinguo.u3dengine.api.UnityCallbackAdapter, us.pinguo.u3dengine.api.UnityFilterCallbackApi
        public void reportSkyChangeTransformPrepare(String uid, float f2, float f3, float f4, float f5) {
            kotlin.jvm.internal.s.h(uid, "uid");
            us.pinguo.common.log.a.k("reportSkyChangeTransformPrepare:" + f2 + ',' + f3 + ',' + f4 + ',' + f5, new Object[0]);
        }
    }

    public UnityRender(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        this.a = 98;
        this.b = new b();
        this.c = RenderState.NONE;
        this.f9185d = new BlingBlingTextureInfo(0, 0, 0, 0, 15, null);
        NativeFacesData nativeFacesData = new NativeFacesData();
        this.f9186e = nativeFacesData;
        this.f9187f = nativeFacesData;
        this.f9188g = new us.pinguo.camera2020.model.render.c(context, H);
        this.f9189h = new us.pinguo.camera2020.model.render.b();
        this.f9193l = new HDCameraSessionResult();
        this.m = new us.pinguo.repository2020.u<>();
        this.r = -1;
        this.v = true;
        this.E = new m(false);
        this.F = new d();
    }

    private final void A0(int i2) {
        if (i2 == 90) {
            if (this.v) {
                UnityMethodCaller.setScreenOrientation(ScreenOrientation.LandscapeRight);
            } else {
                UnityMethodCaller.setScreenOrientation(ScreenOrientation.LandscapeRight);
            }
        } else if (i2 == 180) {
            UnityMethodCaller.setScreenOrientation(ScreenOrientation.PortraitUpsideDown);
        } else if (i2 != 270) {
            UnityMethodCaller.setScreenOrientation(ScreenOrientation.PORTRAIT);
        } else if (this.v) {
            UnityMethodCaller.setScreenOrientation(ScreenOrientation.LandscapeLeft);
        } else {
            UnityMethodCaller.setScreenOrientation(ScreenOrientation.LandscapeLeft);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(boolean z) {
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("setWatermarkShowOnScreen:", Boolean.valueOf(z)), new Object[0]);
        UnityMethodCaller.setWatermarkShowOnScreen(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(int i2, String str) {
        this.f9189h.o(i2, str);
        this.b.c(Scene.AFTER_SCREEN_IMAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        int i2 = this.A;
        if (i2 > 0) {
            us.pinguo.processor.b.d(i2);
            us.pinguo.common.log.a.k("delete lastCaptureTexture", new Object[0]);
            this.A = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(RenderState renderState) {
        if (this.c != renderState) {
            this.c = renderState;
            UnityMethodCaller.setPreviewRenderState(renderState);
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("setUnityState:", renderState), new Object[0]);
        }
    }

    public final void C0(WatermarkStyle style) {
        kotlin.jvm.internal.s.h(style, "style");
        UnityMethodCaller.setWatermarkStyle(style);
    }

    public final void E0(int i2) {
        A0(i2);
        this.t = i2;
        UnityMethodCaller.startRenderScreenImage$default(false, 1, null);
        this.b.c(Scene.AUTO_SAVE);
    }

    public final void F0() {
        us.pinguo.common.log.a.k("startCameraRender", new Object[0]);
        UnityMethodCaller.startRender();
        this.b.c(Scene.CAMERA_PREVIEW);
    }

    public final void G0(int i2, byte[] jpegData) {
        kotlin.jvm.internal.s.h(jpegData, "jpegData");
        A0(0);
        this.f9189h.p(i2, jpegData);
        this.b.c(Scene.AFTER_CAPTURE);
    }

    public final void H0() {
        UnityMethodCaller.startRenderHDImage$default(false, 1, null);
        this.b.c(Scene.HD_IMAGE);
    }

    public final void I(String filterPath) {
        kotlin.jvm.internal.s.h(filterPath, "filterPath");
        UnityMethodCaller.setFilterInfo(UnityMethodCaller.FilterType.Path, filterPath);
        if (this.b.a() == Scene.AFTER_CAPTURE || this.b.a() == Scene.HD_IMAGE) {
            this.B = true;
        }
    }

    public final void I0(int i2) {
        A0(i2);
        this.t = i2;
        UnityMethodCaller.startRenderScreenImage$default(false, 1, null);
        this.b.c(Scene.SCREEN_IMAGE);
    }

    public final void J() {
        UnityMethodCaller.setFilterInfo(UnityMethodCaller.FilterType.None, "");
        if (this.b.a() == Scene.AFTER_CAPTURE || this.b.a() == Scene.HD_IMAGE) {
            this.B = true;
        }
    }

    public final void J0() {
        UnityMethodCaller.startRenderHDImage$default(false, 1, null);
        this.b.c(Scene.AFTER_CAPTURE);
    }

    public final void K(String filterPath) {
        kotlin.jvm.internal.s.h(filterPath, "filterPath");
        UnityMethodCaller.setSkyChangeFilterInfo(UnityMethodCaller.FilterType.Path, filterPath);
        if (this.b.a() == Scene.AFTER_CAPTURE || this.b.a() == Scene.HD_IMAGE) {
            this.B = true;
        }
    }

    public final void K0(int i2) {
        A0(i2);
        this.b.c(Scene.VIDEO_RECORD);
        this.q = true;
    }

    public final int L() {
        return this.u;
    }

    public final void L0() {
        this.f9187f = this.f9186e;
        this.n = true;
    }

    public final l<CaptureModel, u> M() {
        return this.f9191j;
    }

    public final void M0() {
        this.r = -1;
        UnityMethodCaller.stopRecord();
        UnityMethodCaller.clearSticker$default(false, 1, null);
        this.b.c(Scene.AFTER_VIDEO_RECORD);
    }

    public final q<String, Integer, Scene, u> N() {
        return this.f9192k;
    }

    public final void N0(us.pinguo.facedetector.c cVar) {
        if (Z()) {
            NativeFacesData nativeFacesData = null;
            if (cVar != null) {
                us.pinguo.facedetector.c.b(cVar, L() + BaseBlurEffect.ROTATION_180, !X(), 0, 0, 12, null);
                cVar.i();
                nativeFacesData = us.pinguo.repository2020.utils.i.e(cVar, X(), false, 2, null);
            }
            if (nativeFacesData == null) {
                nativeFacesData = this.f9186e;
            }
            this.f9187f = nativeFacesData;
        }
    }

    public final l<Scene, u> O() {
        return this.f9190i;
    }

    public final l<String, us.pinguo.processor.d> P() {
        return this.w;
    }

    public final l<String, Boolean> Q() {
        return this.x;
    }

    public final s<String, Float, Float, Float, Float, u> R() {
        return this.y;
    }

    public final us.pinguo.repository2020.u<Size> S() {
        return this.m;
    }

    public final UnityCallbackAdapter T() {
        return this.F;
    }

    public final boolean U() {
        return this.D;
    }

    public final us.pinguo.camera2020.model.render.c V() {
        return this.f9188g;
    }

    public final void W() {
        UnityControlCaller.setEngineMode(EngineMode.CAMERA, Module.CAMERA);
        UnityControlCaller.setCurrentLanguage$default(null, 1, null);
        UnityMethodCaller.setContrastValue(0.0f);
        UnityMethodCaller.setSaturationValue(0.0f);
        this.C = LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList();
        us.pinguo.common.log.a.c(((Object) HardwareInfo.get().getHardware()) + " is lower resolution:" + this.C, new Object[0]);
    }

    public final boolean X() {
        return this.v;
    }

    public final void Y(String bundlePath, String luaName) {
        kotlin.jvm.internal.s.h(bundlePath, "bundlePath");
        kotlin.jvm.internal.s.h(luaName, "luaName");
        I = bundlePath;
        UnityMethodCaller.loadStickerBundle(bundlePath, luaName);
    }

    public final boolean Z() {
        return (this.n || this.b.a() == Scene.AFTER_CAPTURE || this.b.a() == Scene.AFTER_VIDEO_RECORD) ? false : true;
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void a() {
        this.f9188g.b();
    }

    public final void a0() {
        UnityControlCaller.setEngineMode(EngineMode.CAMERA, Module.CAMERA);
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void b() {
        this.f9188g.d();
    }

    public final void b0(l<? super CaptureModel, u> lVar) {
        this.f9191j = lVar;
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void c() {
        this.f9188g.a();
    }

    public final void c0(q<? super String, ? super Integer, ? super Scene, u> qVar) {
        this.f9192k = qVar;
    }

    public final void d0(us.pinguo.processor.d makeInfo) {
        kotlin.jvm.internal.s.h(makeInfo, "makeInfo");
        makeInfo.e(H.n().d());
        this.f9189h.m(makeInfo);
    }

    public final void e0(l<? super Scene, u> lVar) {
        this.f9190i = lVar;
    }

    public final void f0(float f2) {
        UnityMethodCaller.setContrastValue(f2);
    }

    public final void g0(l<? super String, us.pinguo.processor.d> lVar) {
        this.w = lVar;
    }

    public final void h0(float f2) {
        UnityMethodCaller.setFilterOpacity(f2);
    }

    public final void i0(float f2) {
    }

    public final void j0(int i2) {
        this.a = i2;
    }

    public final void k0(boolean z) {
        this.z = z;
    }

    public final void l0(boolean z) {
        this.s = z;
    }

    public final void m0(boolean z) {
        this.p = z;
    }

    public final void n0(boolean z) {
        this.o = z;
    }

    public final void o0(us.pinguo.processor.d makeInfo) {
        kotlin.jvm.internal.s.h(makeInfo, "makeInfo");
        UnityMethodCaller.setFilterInfo$default(UnityMethodCaller.FilterType.Local, null, 2, null);
        us.pinguo.processor.c cVar = H;
        makeInfo.e(cVar.n().d());
        cVar.p(makeInfo);
        if (this.b.a() == Scene.AFTER_CAPTURE || this.b.a() == Scene.HD_IMAGE) {
            this.B = true;
        }
    }

    public final void p0(l<? super String, Boolean> lVar) {
        this.x = lVar;
    }

    public final void q0(float f2) {
        UnityMethodCaller.setMakeupThemeValue(f2);
    }

    public final void r0(kotlin.jvm.b.a<u> block) {
        kotlin.jvm.internal.s.h(block, "block");
        this.f9188g.n(new c(block));
    }

    public final void s0(int i2) {
        H.o(i2);
        A0(i2);
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void setCameraInfo(boolean z, int i2) {
        this.v = z;
        this.u = i2;
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        kotlin.jvm.internal.s.h(surfaceTexture, "surfaceTexture");
        this.f9188g.o(surfaceTexture);
    }

    @Override // us.pinguo.cameramanger.viewfinder.a
    public void setTextureSize(int i2, int i3) {
        this.f9188g.p(i2, i3);
        this.m.postValue(new Size(i2, i3));
    }

    public final void t0(q<? super Boolean, ? super Boolean, ? super String, u> qVar) {
        this.f9189h.n(qVar);
    }

    public final void u0(float f2) {
        UnityMethodCaller.setSaturationValue(f2);
    }

    public final void v0(s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, u> sVar) {
        this.y = sVar;
    }

    public final void w0(boolean z) {
        this.D = z;
    }

    public final void y0(boolean z) {
        UnityMethodCaller.setUnityVolume(z ? 1.0f : 0.0f);
    }

    public final void z0(boolean z) {
        H.n().e(z);
        this.f9189h.e().e(z);
    }
}
