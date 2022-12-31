package us.pinguo.cameramanger;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Size;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.cameramanger.impl.Camera1Impl;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.Flash;
import us.pinguo.cameramanger.info.LensFacing;
import us.pinguo.cameramanger.info.WhiteBalance;
/* compiled from: CameraManager.kt */
/* loaded from: classes4.dex */
public final class c implements e {
    private final Camera1Impl a;
    private LifecycleOwner b;
    private Size c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.cameramanger.viewfinder.a f9763d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9764e;

    /* compiled from: CameraManager.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Flash.values().length];
            iArr[Flash.AUTO.ordinal()] = 1;
            iArr[Flash.ON.ordinal()] = 2;
            iArr[Flash.OFF.ordinal()] = 3;
            a = iArr;
        }
    }

    public c(LensFacing facing, CameraFrame frame) {
        s.h(facing, "facing");
        s.h(frame, "frame");
        this.a = new Camera1Impl(frame, facing);
        this.f9764e = true;
    }

    private final Rect E(PointF pointF, float f2) {
        float f3 = (-1.0f) + f2;
        float f4 = 1.0f - f2;
        PointF I = I(pointF, l().b() + BaseBlurEffect.ROTATION_180);
        float f5 = I.x;
        if (f5 < f3) {
            f5 = f3;
        } else if (f5 > f4) {
            f5 = f4;
        }
        float f6 = I.y;
        if (f6 >= f3) {
            f3 = f6 > f4 ? f4 : f6;
        }
        float f7 = 1000;
        Rect rect = new Rect((int) ((f5 - f2) * f7), (int) ((f3 - f2) * f7), (int) ((f5 + f2) * f7), (int) ((f3 + f2) * f7));
        us.pinguo.common.log.a.c("area: point=" + pointF + ", adjustPoint=" + I + ", rect=" + rect, new Object[0]);
        return rect;
    }

    private final boolean F() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = this.b;
        Lifecycle.State state = null;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            state = lifecycle.getCurrentState();
        }
        return state == Lifecycle.State.RESUMED;
    }

    private final PointF I(PointF pointF, int i2) {
        double d2 = (i2 * 3.141592653589793d) / ((double) BaseBlurEffect.ROTATION_180);
        return new PointF((float) ((pointF.x * Math.cos(d2)) - (pointF.y * Math.sin(d2))), (float) ((pointF.y * Math.cos(d2)) + (pointF.x * Math.sin(d2))));
    }

    private final Camera.Parameters J() {
        try {
            Camera m = this.a.m();
            if (m == null) {
                return null;
            }
            return m.getParameters();
        } catch (Exception unused) {
            us.pinguo.common.log.a.e("Get camera parameter fail", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K() {
        us.pinguo.common.log.a.d("takePicture", "shutter", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(c this$0, l endBlock, byte[] data, Camera camera) {
        s.h(this$0, "this$0");
        s.h(endBlock, "$endBlock");
        us.pinguo.common.log.a.d("takePicture", s.q("picture:", Integer.valueOf(data.length)), new Object[0]);
        Camera.Parameters J = this$0.J();
        us.pinguo.common.log.a.d("takePicture", s.q("param,currentFlashMode:", J == null ? null : J.getFlashMode()), new Object[0]);
        camera.setPreviewCallbackWithBuffer(null);
        camera.stopPreview();
        s.g(data, "data");
        endBlock.invoke(data);
        camera.startPreview();
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        Camera1Impl camera1Impl = this$0.a;
        s.g(camera, "camera");
        camera1Impl.C(camera, new Size(previewSize.width, previewSize.height));
    }

    @Override // us.pinguo.cameramanger.e
    public void A() {
        Camera m;
        if (F() && m() && (m = this.a.m()) != null) {
            Camera.Parameters parameters = m.getParameters();
            this.a.e();
            if (parameters != null) {
                parameters.setFocusAreas(null);
            }
            if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
            }
            this.a.J(parameters);
        }
    }

    @Override // us.pinguo.cameramanger.e
    public List<WhiteBalance> B() {
        Camera.Parameters J;
        if (!F() || (J = J()) == null) {
            return null;
        }
        List<String> rawList = J.getSupportedWhiteBalance();
        ArrayList arrayList = new ArrayList();
        s.g(rawList, "rawList");
        for (String str : rawList) {
            us.pinguo.common.log.a.k(s.q("param:", str), new Object[0]);
            if (str != null) {
                switch (str.hashCode()) {
                    case -939299377:
                        if (str.equals("incandescent")) {
                            arrayList.add(WhiteBalance.INCANDESCENT);
                            break;
                        } else {
                            continue;
                        }
                    case -719316704:
                        if (str.equals("warm-fluorescent")) {
                            arrayList.add(WhiteBalance.WARM_FLUORESCENT);
                            break;
                        } else {
                            continue;
                        }
                    case 3005871:
                        if (str.equals("auto")) {
                            arrayList.add(WhiteBalance.AUTO);
                            break;
                        } else {
                            continue;
                        }
                    case 109399597:
                        if (str.equals("shade")) {
                            arrayList.add(WhiteBalance.SHADE);
                            break;
                        } else {
                            continue;
                        }
                    case 474934723:
                        if (str.equals("cloudy-daylight")) {
                            arrayList.add(WhiteBalance.CLOUDY_DAYLIGHT);
                            break;
                        } else {
                            continue;
                        }
                    case 1650323088:
                        if (str.equals("twilight")) {
                            arrayList.add(WhiteBalance.TWILIGHT);
                            break;
                        } else {
                            continue;
                        }
                    case 1902580840:
                        if (str.equals("fluorescent")) {
                            arrayList.add(WhiteBalance.FLUORESCENT);
                            break;
                        } else {
                            continue;
                        }
                    case 1942983418:
                        if (str.equals("daylight")) {
                            arrayList.add(WhiteBalance.DAYLIGHT);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.cameramanger.e
    public void C(float f2) {
        Camera.Parameters J;
        if (!F() || (J = J()) == null) {
            return;
        }
        float f3 = 1.0f;
        if (f2 < 0.0f) {
            f3 = 0.0f;
        } else if (f2 <= 1.0f) {
            f3 = f2;
        }
        J.setZoom((int) (f3 * J.getMaxZoom()));
        us.pinguo.common.log.a.c("value:" + f2 + ", " + J.getZoom(), new Object[0]);
        this.a.J(J);
    }

    @Override // us.pinguo.cameramanger.e
    public boolean D(CameraFrame frame) {
        s.h(frame, "frame");
        return F() && this.a.L() != d();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
    @Override // us.pinguo.cameramanger.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(us.pinguo.cameramanger.info.Flash r5) {
        /*
            r4 = this;
            java.lang.String r0 = "flash"
            kotlin.jvm.internal.s.h(r5, r0)
            boolean r0 = r4.F()
            r1 = 0
            if (r0 == 0) goto Lbc
            android.hardware.Camera$Parameters r0 = r4.J()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "CameraManager.setFlash.rawCamera:"
            r2.append(r3)
            us.pinguo.cameramanger.impl.Camera1Impl r3 = r4.a
            android.hardware.Camera r3 = r3.m()
            r2.append(r3)
            java.lang.String r3 = " parameters:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " param?.supportedFlashModes:"
            r2.append(r3)
            if (r0 != 0) goto L34
            r3 = 0
            goto L38
        L34:
            java.util.List r3 = r0.getSupportedFlashModes()
        L38:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r1]
            us.pinguo.common.log.a.k(r2, r3)
            if (r0 != 0) goto L48
        L46:
            r2 = 0
            goto L53
        L48:
            java.util.List r2 = r0.getSupportedFlashModes()
            if (r2 != 0) goto L4f
            goto L46
        L4f:
            int r2 = r2.size()
        L53:
            if (r2 <= 0) goto Lbc
            int[] r2 = us.pinguo.cameramanger.c.a.a
            int r5 = r5.ordinal()
            r5 = r2[r5]
            r2 = 1
            if (r5 == r2) goto L9b
            r3 = 2
            if (r5 == r3) goto L81
            r3 = 3
            if (r5 == r3) goto L67
            goto Lb5
        L67:
            java.lang.String r5 = "off"
            if (r0 != 0) goto L6d
        L6b:
            r3 = 0
            goto L7b
        L6d:
            java.util.List r3 = r0.getSupportedFlashModes()
            if (r3 != 0) goto L74
            goto L6b
        L74:
            boolean r3 = r3.contains(r5)
            if (r3 != r2) goto L6b
            r3 = 1
        L7b:
            if (r3 == 0) goto Lb5
            r0.setFlashMode(r5)
            goto Lb4
        L81:
            java.lang.String r5 = "on"
            if (r0 != 0) goto L87
        L85:
            r3 = 0
            goto L95
        L87:
            java.util.List r3 = r0.getSupportedFlashModes()
            if (r3 != 0) goto L8e
            goto L85
        L8e:
            boolean r3 = r3.contains(r5)
            if (r3 != r2) goto L85
            r3 = 1
        L95:
            if (r3 == 0) goto Lb5
            r0.setFlashMode(r5)
            goto Lb4
        L9b:
            java.lang.String r5 = "auto"
            if (r0 != 0) goto La1
        L9f:
            r3 = 0
            goto Laf
        La1:
            java.util.List r3 = r0.getSupportedFlashModes()
            if (r3 != 0) goto La8
            goto L9f
        La8:
            boolean r3 = r3.contains(r5)
            if (r3 != r2) goto L9f
            r3 = 1
        Laf:
            if (r3 == 0) goto Lb5
            r0.setFlashMode(r5)
        Lb4:
            r1 = 1
        Lb5:
            if (r1 == 0) goto Lbc
            us.pinguo.cameramanger.impl.Camera1Impl r5 = r4.a
            r5.J(r0)
        Lbc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.cameramanger.c.a(us.pinguo.cameramanger.info.Flash):boolean");
    }

    @Override // us.pinguo.cameramanger.e
    public void b(g listener) {
        s.h(listener, "listener");
        this.a.I(listener);
    }

    @Override // us.pinguo.cameramanger.e
    public boolean c() {
        return CameraPreferencesManager.a.g(this.a.k());
    }

    @Override // us.pinguo.cameramanger.e
    public LensFacing d() {
        return this.a.k();
    }

    @Override // us.pinguo.cameramanger.e
    public Flash e() {
        Camera.Parameters J = J();
        String flashMode = J == null ? null : J.getFlashMode();
        return s.c(flashMode, "auto") ? Flash.AUTO : s.c(flashMode, TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON) ? Flash.ON : Flash.OFF;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0044  */
    @Override // us.pinguo.cameramanger.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(boolean r5) {
        /*
            r4 = this;
            boolean r0 = r4.F()
            r1 = 0
            if (r0 == 0) goto L49
            android.hardware.Camera$Parameters r0 = r4.J()
            r2 = 1
            if (r5 == 0) goto L28
            java.lang.String r5 = "torch"
            if (r0 != 0) goto L14
        L12:
            r3 = 0
            goto L22
        L14:
            java.util.List r3 = r0.getSupportedFlashModes()
            if (r3 != 0) goto L1b
            goto L12
        L1b:
            boolean r3 = r3.contains(r5)
            if (r3 != r2) goto L12
            r3 = 1
        L22:
            if (r3 == 0) goto L42
            r0.setFlashMode(r5)
            goto L41
        L28:
            java.lang.String r5 = "off"
            if (r0 != 0) goto L2e
        L2c:
            r3 = 0
            goto L3c
        L2e:
            java.util.List r3 = r0.getSupportedFlashModes()
            if (r3 != 0) goto L35
            goto L2c
        L35:
            boolean r3 = r3.contains(r5)
            if (r3 != r2) goto L2c
            r3 = 1
        L3c:
            if (r3 == 0) goto L42
            r0.setFlashMode(r5)
        L41:
            r1 = 1
        L42:
            if (r1 == 0) goto L49
            us.pinguo.cameramanger.impl.Camera1Impl r5 = r4.a
            r5.J(r0)
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.cameramanger.c.f(boolean):boolean");
    }

    @Override // us.pinguo.cameramanger.e
    public void g(int i2, int i3) {
        Size size = new Size(i2, i3);
        this.a.G(size);
        this.c = size;
    }

    @Override // us.pinguo.cameramanger.e
    public void h(final l<? super byte[], u> endBlock) {
        s.h(endBlock, "endBlock");
        if (F()) {
            us.pinguo.cameramanger.a aVar = this.f9764e ? us.pinguo.cameramanger.a.a : null;
            try {
                Camera m = this.a.m();
                if (m == null) {
                    return;
                }
                m.takePicture(aVar, null, new Camera.PictureCallback() { // from class: us.pinguo.cameramanger.b
                    @Override // android.hardware.Camera.PictureCallback
                    public final void onPictureTaken(byte[] bArr, Camera camera) {
                        c.L(c.this, endBlock, bArr, camera);
                    }
                });
            } catch (RuntimeException unused) {
                us.pinguo.common.log.a.e("Take picture fail! ", new Object[0]);
            }
        }
    }

    @Override // us.pinguo.cameramanger.e
    public void i(f listener) {
        s.h(listener, "listener");
        this.a.H(listener);
    }

    @Override // us.pinguo.cameramanger.e
    public boolean j(CameraFrame frame) {
        s.h(frame, "frame");
        if (this.a.l() != frame) {
            return this.a.g(frame);
        }
        return false;
    }

    @Override // us.pinguo.cameramanger.e
    public void k(float f2) {
        if (F()) {
            if (f2 < -1.0f) {
                f2 = -1.0f;
            } else if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            Camera.Parameters J = J();
            if (J == null) {
                return;
            }
            int maxExposureCompensation = J.getMaxExposureCompensation();
            int minExposureCompensation = J.getMinExposureCompensation();
            float f3 = (f2 < 0.0f ? -minExposureCompensation : maxExposureCompensation) * f2;
            J.setExposureCompensation((int) f3);
            us.pinguo.common.log.a.c("adjustValue:" + f2 + ", currentCaculate:" + f3 + ", currentValue:" + J.getExposureCompensation() + ",  max:" + maxExposureCompensation + ",  min:" + minExposureCompensation + ",  step:" + J.getExposureCompensationStep(), new Object[0]);
            this.a.J(J);
        }
    }

    @Override // us.pinguo.cameramanger.e
    public us.pinguo.cameramanger.info.a l() {
        return q(this.a.k());
    }

    @Override // us.pinguo.cameramanger.e
    public boolean m() {
        boolean f2 = CameraPreferencesManager.a.f(this.a.k());
        us.pinguo.common.log.a.c("isFocusAreaSupport " + this.a.k() + ':' + f2, new Object[0]);
        return f2;
    }

    @Override // us.pinguo.cameramanger.e
    public boolean n(LensFacing lensFacing) {
        s.h(lensFacing, "lensFacing");
        return this.a.j().containsKey(lensFacing);
    }

    @Override // us.pinguo.cameramanger.e
    public CameraFrame o() {
        return this.a.l();
    }

    @Override // us.pinguo.cameramanger.e
    public void p(boolean z) {
        try {
            this.f9764e = z;
            Camera m = this.a.m();
            if (m == null) {
                return;
            }
            m.enableShutterSound(z);
        } catch (RuntimeException e2) {
            this.f9764e = !z;
            us.pinguo.common.log.a.e(s.q("Enable shutter sound failed==>", e2.getMessage()), new Object[0]);
        }
    }

    @Override // us.pinguo.cameramanger.e
    public us.pinguo.cameramanger.info.a q(LensFacing facing) {
        s.h(facing, "facing");
        us.pinguo.cameramanger.info.a aVar = this.a.j().get(facing);
        if (aVar == null) {
            StringBuilder sb = new StringBuilder("cameraInfos size:" + this.a.j().size() + ", ");
            for (LensFacing lensFacing : this.a.j().keySet()) {
                this.a.j().get(lensFacing);
                sb.append('[' + lensFacing + "], ");
            }
            int numberOfCameras = Camera.getNumberOfCameras();
            sb.append("Camera.getNumber=" + numberOfCameras + ", ");
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                sb.append(" Camera[" + i2 + "]:facing=" + cameraInfo.facing + ", ");
            }
            throw new IllegalArgumentException("Can not find " + facing + " camera info! info=" + aVar + ", " + ((Object) sb));
        }
        return aVar;
    }

    @Override // us.pinguo.cameramanger.e
    public void r(LifecycleOwner lifecycleOwner) {
        s.h(lifecycleOwner, "lifecycleOwner");
        if (this.c != null) {
            this.b = lifecycleOwner;
            lifecycleOwner.getLifecycle().addObserver(this.a);
            return;
        }
        throw new RuntimeException("You need call setFullScreenSize before bind!");
    }

    @Override // us.pinguo.cameramanger.e
    public void s() {
        if (F() && c()) {
            Camera.Parameters J = J();
            if (J != null) {
                J.setMeteringAreas(null);
            }
            this.a.J(J);
        }
    }

    @Override // us.pinguo.cameramanger.e
    public void t(PointF point, float f2, int i2) {
        List<Camera.Area> e2;
        s.h(point, "point");
        if (F() && c()) {
            Camera.Area area = new Camera.Area(E(point, f2), i2);
            Camera.Parameters J = J();
            if (J != null) {
                e2 = t.e(area);
                J.setMeteringAreas(e2);
            }
            this.a.J(J);
        }
    }

    @Override // us.pinguo.cameramanger.e
    public boolean u() {
        return CameraPreferencesManager.a.h(this.a.k());
    }

    @Override // us.pinguo.cameramanger.e
    public boolean v() {
        return CameraPreferencesManager.a.e(this.a.k());
    }

    @Override // us.pinguo.cameramanger.e
    public void w(us.pinguo.cameramanger.viewfinder.a viewFinder) {
        s.h(viewFinder, "viewFinder");
        this.f9763d = viewFinder;
        this.a.K(viewFinder);
    }

    @Override // us.pinguo.cameramanger.e
    public void x(WhiteBalance whiteBalance) {
        Camera.Parameters J;
        s.h(whiteBalance, "whiteBalance");
        if (F()) {
            List<WhiteBalance> B = B();
            boolean z = false;
            if (B != null && B.contains(whiteBalance)) {
                z = true;
            }
            if (!z || (J = J()) == null) {
                return;
            }
            J.setWhiteBalance(whiteBalance.toCamera1Param$camera_manager_release());
            this.a.J(J);
        }
    }

    @Override // us.pinguo.cameramanger.e
    public boolean y() {
        if (F()) {
            Camera.Parameters J = J();
            if (s.c(J == null ? null : J.getFlashMode(), "torch")) {
                return true;
            }
        }
        return false;
    }

    @Override // us.pinguo.cameramanger.e
    public void z(PointF point, float f2, int i2) {
        Camera m;
        List<Camera.Area> e2;
        s.h(point, "point");
        if (F() && m() && (m = this.a.m()) != null) {
            Camera.Area area = new Camera.Area(E(point, f2), i2);
            Camera.Parameters parameters = m.getParameters();
            if (parameters.getSupportedFocusModes().contains("auto")) {
                parameters.setFocusMode("auto");
            }
            e2 = t.e(area);
            parameters.setFocusAreas(e2);
            this.a.J(parameters);
            this.a.a();
        }
    }
}
