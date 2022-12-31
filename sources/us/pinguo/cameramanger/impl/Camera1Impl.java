package us.pinguo.cameramanger.impl;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.pinguo.lib.AppContextProvider;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.s;
import us.pinguo.cameramanger.CameraPreferencesManager;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.LensFacing;
/* compiled from: Camera1Impl.kt */
/* loaded from: classes4.dex */
public final class Camera1Impl implements LifecycleObserver {
    private CameraFrame a;
    private LensFacing b;
    private HandlerThread c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f9765d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f9766e;

    /* renamed from: f  reason: collision with root package name */
    private Camera f9767f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.cameramanger.viewfinder.a f9768g;

    /* renamed from: h  reason: collision with root package name */
    private EnumMap<LensFacing, us.pinguo.cameramanger.info.a> f9769h;

    /* renamed from: i  reason: collision with root package name */
    private SurfaceTexture f9770i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9771j;

    /* renamed from: k  reason: collision with root package name */
    private Size f9772k;

    /* renamed from: l  reason: collision with root package name */
    private us.pinguo.cameramanger.f f9773l;
    private us.pinguo.cameramanger.g m;

    /* compiled from: Camera1Impl.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LensFacing.values().length];
            iArr[LensFacing.BACK.ordinal()] = 1;
            iArr[LensFacing.FRONT.ordinal()] = 2;
            a = iArr;
        }
    }

    public Camera1Impl(CameraFrame frame, LensFacing facing) {
        s.h(frame, "frame");
        s.h(facing, "facing");
        this.a = frame;
        this.b = facing;
        this.f9765d = Executors.newSingleThreadExecutor();
        this.f9769h = new EnumMap<>(LensFacing.class);
        int numberOfCameras = Camera.getNumberOfCameras();
        StringBuilder sb = new StringBuilder("cam num:" + numberOfCameras + ", ");
        int i2 = 0;
        while (i2 < numberOfCameras) {
            int i3 = i2 + 1;
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            us.pinguo.common.log.a.c("Camera[" + i2 + "]:facing=" + us.pinguo.cameramanger.d.a(cameraInfo) + ", orientation=" + cameraInfo.orientation, new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Camera[");
            sb2.append(i2);
            sb2.append("]:facing=");
            sb2.append(us.pinguo.cameramanger.d.a(cameraInfo));
            sb2.append(", ");
            sb.append(sb2.toString());
            if (!this.f9769h.containsKey(us.pinguo.cameramanger.d.a(cameraInfo))) {
                this.f9769h.put((EnumMap<LensFacing, us.pinguo.cameramanger.info.a>) us.pinguo.cameramanger.d.a(cameraInfo), (LensFacing) new us.pinguo.cameramanger.info.a(i2, cameraInfo.orientation));
            }
            i2 = i3;
        }
        us.pinguo.common.log.a.c(s.q("cameraInfoStr:", sb), new Object[0]);
        if (this.f9769h.get(this.b) == null) {
            AppContextProvider appContextProvider = AppContextProvider.INSTANCE;
            boolean hasSystemFeature = appContextProvider.getContext().getPackageManager().hasSystemFeature("android.hardware.camera");
            Object systemService = appContextProvider.getContext().getSystemService("camera");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            int length = ((CameraManager) systemService).getCameraIdList().length;
            throw new IllegalArgumentException("Can not init CameraManager with " + this.b + " camera, " + ((Object) sb) + ", camera2size=" + length + ", hasCameraFeature=" + hasSystemFeature);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Camera1Impl this$0) {
        Camera camera;
        Size size;
        Size size2;
        s.h(this$0, "this$0");
        try {
            CameraPreferencesManager cameraPreferencesManager = CameraPreferencesManager.a;
            if (!cameraPreferencesManager.d()) {
                cameraPreferencesManager.a();
            }
            us.pinguo.cameramanger.info.a aVar = this$0.f9769h.get(this$0.b);
            boolean z = false;
            if (aVar != null) {
                us.pinguo.common.log.a.c(s.q("openCamera:", this$0.b), new Object[0]);
                try {
                    camera = Camera.open(aVar.a());
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    camera = null;
                }
                this$0.f9767f = camera;
                if (camera != null) {
                    us.pinguo.cameramanger.viewfinder.a aVar2 = this$0.f9768g;
                    if (aVar2 != null) {
                        aVar2.setCameraInfo(this$0.b == LensFacing.FRONT, aVar.b());
                    }
                    Camera.Parameters param = camera.getParameters();
                    LensFacing lensFacing = this$0.b;
                    s.g(param, "param");
                    this$0.F(lensFacing, camera, param);
                    us.pinguo.cameramanger.info.b value = aVar.c().getValue();
                    if (value == null) {
                        Camera.Parameters parameters = camera.getParameters();
                        s.g(parameters, "camera.parameters");
                        value = this$0.o(parameters);
                        aVar.d(value);
                    }
                    if (value.c().containsKey(this$0.a) && value.b().containsKey(this$0.a)) {
                        Size size3 = value.c().get(this$0.a);
                        s.e(size3);
                        s.g(size3, "resolutionInfo.targetPreviewSize[frame]!!");
                        size = size3;
                        Size size4 = value.b().get(this$0.a);
                        s.e(size4);
                        s.g(size4, "resolutionInfo.targetPictureSize[frame]!!");
                        size2 = size4;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Can not find matched frame of ");
                        sb.append(this$0.a);
                        sb.append(", change to ");
                        CameraFrame cameraFrame = CameraFrame.FRAME_4_3;
                        sb.append(cameraFrame);
                        us.pinguo.common.log.a.e(sb.toString(), new Object[0]);
                        this$0.a = cameraFrame;
                        us.pinguo.cameramanger.g gVar = this$0.m;
                        if (gVar != null) {
                            gVar.a(cameraFrame);
                        }
                        Size size5 = value.c().get(this$0.a);
                        s.e(size5);
                        s.g(size5, "resolutionInfo.targetPreviewSize[frame]!!");
                        size = size5;
                        Size size6 = value.b().get(this$0.a);
                        s.e(size6);
                        s.g(size6, "resolutionInfo.targetPictureSize[frame]!!");
                        size2 = size6;
                    }
                    param.setPreviewSize(size.getWidth(), size.getHeight());
                    param.setPictureSize(size2.getWidth(), size2.getHeight());
                    us.pinguo.cameramanger.viewfinder.a aVar3 = this$0.f9768g;
                    if (aVar3 != null) {
                        aVar3.setTextureSize(size.getHeight(), size.getWidth());
                    }
                    SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                    surfaceTexture.detachFromGLContext();
                    us.pinguo.cameramanger.viewfinder.a n = this$0.n();
                    if (n != null) {
                        n.setSurfaceTexture(surfaceTexture);
                    }
                    camera.setPreviewTexture(surfaceTexture);
                    this$0.f9770i = surfaceTexture;
                    List<String> supportedWhiteBalance = param.getSupportedWhiteBalance();
                    if (supportedWhiteBalance != null && supportedWhiteBalance.contains("auto")) {
                        z = true;
                    }
                    if (z) {
                        param.setWhiteBalance("auto");
                    }
                    camera.setParameters(param);
                    this$0.C(camera, size);
                    camera.startPreview();
                    this$0.f9767f = camera;
                    return;
                }
                us.pinguo.common.log.a.e("Open camera failed", new Object[0]);
                return;
            }
            us.pinguo.common.log.a.e(s.q("Can not find camera of facing:", this$0.b), new Object[0]);
        } catch (Exception e3) {
            us.pinguo.common.log.a.f(e3);
            CrashReport.postCatchedException(new RuntimeException("OpenCameraException", e3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Camera1Impl this$0) {
        s.h(this$0, "this$0");
        us.pinguo.common.log.a.c("release", new Object[0]);
        HandlerThread handlerThread = this$0.c;
        if (handlerThread != null) {
            handlerThread.quit();
        } else {
            s.z("cameraThread");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Camera camera, final Size previewSize, final Camera1Impl this$0, final byte[] bArr, Camera camera2) {
        s.h(camera, "$camera");
        s.h(previewSize, "$previewSize");
        s.h(this$0, "this$0");
        camera.addCallbackBuffer(bArr);
        if (bArr == null || ((int) (previewSize.getWidth() * previewSize.getHeight() * 1.5f)) != bArr.length) {
            return;
        }
        this$0.f9765d.execute(new Runnable() { // from class: us.pinguo.cameramanger.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                Camera1Impl.E(Camera1Impl.this, bArr, previewSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Camera1Impl this$0, byte[] bArr, Size previewSize) {
        s.h(this$0, "this$0");
        s.h(previewSize, "$previewSize");
        us.pinguo.cameramanger.f fVar = this$0.f9773l;
        if (fVar == null) {
            return;
        }
        fVar.a(bArr, previewSize.getWidth(), previewSize.getHeight());
    }

    private final Camera.Parameters F(LensFacing lensFacing, Camera camera, Camera.Parameters parameters) {
        camera.setDisplayOrientation(90);
        CameraPreferencesManager cameraPreferencesManager = CameraPreferencesManager.a;
        if (cameraPreferencesManager.f(lensFacing)) {
            parameters.setFocusAreas(null);
        }
        if (cameraPreferencesManager.g(lensFacing)) {
            parameters.setMeteringAreas(null);
        }
        if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        }
        parameters.setRecordingHint(false);
        parameters.setJpegQuality(95);
        parameters.setRotation(0);
        return parameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Camera1Impl this$0) {
        s.h(this$0, "this$0");
        this$0.closeCamera$camera_manager_release();
        this$0.openCamera$camera_manager_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Camera camera) {
        s.h(camera, "$camera");
        camera.cancelAutoFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Camera camera, final Camera1Impl this$0) {
        s.h(camera, "$camera");
        s.h(this$0, "this$0");
        try {
            camera.autoFocus(new Camera.AutoFocusCallback() { // from class: us.pinguo.cameramanger.impl.e
                @Override // android.hardware.Camera.AutoFocusCallback
                public final void onAutoFocus(boolean z, Camera camera2) {
                    Camera1Impl.d(Camera1Impl.this, z, camera2);
                }
            });
            this$0.f9771j = true;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Camera1Impl this$0, boolean z, Camera camera) {
        s.h(this$0, "this$0");
        this$0.f9771j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Camera1Impl this$0) {
        s.h(this$0, "this$0");
        Camera camera = this$0.f9767f;
        if (camera != null) {
            camera.cancelAutoFocus();
        }
        this$0.f9771j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Camera1Impl this$0, Size size, Size size2) {
        s.h(this$0, "this$0");
        Camera camera = this$0.f9767f;
        if (camera == null) {
            return;
        }
        camera.setPreviewCallbackWithBuffer(null);
        camera.stopPreview();
        Camera.Parameters parameters = camera.getParameters();
        if (parameters != null) {
            parameters.setPreviewSize(size.getWidth(), size.getHeight());
        }
        if (parameters != null) {
            parameters.setPictureSize(size2.getWidth(), size2.getHeight());
        }
        camera.setParameters(parameters);
        us.pinguo.cameramanger.viewfinder.a n = this$0.n();
        if (n != null) {
            n.setTextureSize(size.getHeight(), size.getWidth());
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        us.pinguo.cameramanger.viewfinder.a n2 = this$0.n();
        if (n2 != null) {
            n2.setSurfaceTexture(surfaceTexture);
        }
        camera.setPreviewTexture(surfaceTexture);
        this$0.f9770i = surfaceTexture;
        camera.startPreview();
        this$0.C(camera, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Camera1Impl this$0, Camera camera) {
        s.h(this$0, "this$0");
        us.pinguo.common.log.a.c("closeCamera", new Object[0]);
        SurfaceTexture surfaceTexture = this$0.f9770i;
        this$0.f9770i = null;
        us.pinguo.cameramanger.viewfinder.a aVar = this$0.f9768g;
        if (aVar != null) {
            aVar.c();
        }
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (camera != null) {
            camera.stopPreview();
        }
        if (camera == null) {
            return;
        }
        camera.release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void initCamera() {
        us.pinguo.common.log.a.c("ON_CREATE", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("CameraThread");
        this.c = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            HandlerThread handlerThread2 = this.c;
            if (handlerThread2 != null) {
                this.f9766e = new Handler(handlerThread2.getLooper());
                return;
            } else {
                s.z("cameraThread");
                throw null;
            }
        }
        s.z("cameraThread");
        throw null;
    }

    private final us.pinguo.cameramanger.info.b o(Camera.Parameters parameters) {
        List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> pictureSizes = parameters.getSupportedPictureSizes();
        s.g(previewSizes, "previewSizes");
        s.g(pictureSizes, "pictureSizes");
        Size size = this.f9772k;
        if (size != null) {
            return new us.pinguo.cameramanger.info.b(previewSizes, pictureSizes, size);
        }
        s.z("screenSize");
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void release() {
        us.pinguo.common.log.a.c("ON_DESTROY", new Object[0]);
        Handler handler = this.f9766e;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Impl.B(Camera1Impl.this);
                }
            });
        } else {
            s.z("cameraHandler");
            throw null;
        }
    }

    public final void C(final Camera camera, final Size previewSize) {
        s.h(camera, "camera");
        s.h(previewSize, "previewSize");
        us.pinguo.common.log.a.c("setCameraCallbackBuffer", new Object[0]);
        camera.addCallbackBuffer(new byte[(int) (previewSize.getWidth() * previewSize.getHeight() * 1.5f)]);
        camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: us.pinguo.cameramanger.impl.j
            @Override // android.hardware.Camera.PreviewCallback
            public final void onPreviewFrame(byte[] bArr, Camera camera2) {
                Camera1Impl.D(camera, previewSize, this, bArr, camera2);
            }
        });
    }

    public final void G(Size size) {
        s.h(size, "size");
        this.f9772k = size;
    }

    public final void H(us.pinguo.cameramanger.f fVar) {
        this.f9773l = fVar;
    }

    public final void I(us.pinguo.cameramanger.g gVar) {
        this.m = gVar;
    }

    public final void J(Camera.Parameters parameters) {
        if (parameters != null) {
            try {
                Camera camera = this.f9767f;
                if (camera == null) {
                    return;
                }
                camera.setParameters(parameters);
            } catch (RuntimeException e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }
    }

    public final void K(us.pinguo.cameramanger.viewfinder.a aVar) {
        this.f9768g = aVar;
    }

    public final LensFacing L() {
        LensFacing lensFacing;
        int i2 = a.a[this.b.ordinal()];
        if (i2 == 1) {
            lensFacing = LensFacing.FRONT;
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            lensFacing = LensFacing.BACK;
        }
        this.b = lensFacing;
        Handler handler = this.f9766e;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Impl.M(Camera1Impl.this);
                }
            });
            return this.b;
        }
        s.z("cameraHandler");
        throw null;
    }

    public final void a() {
        Camera.Parameters parameters;
        final Camera camera = this.f9767f;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return;
        }
        if (s.c(parameters.getFocusMode(), "auto") || s.c(parameters.getFocusMode(), "macro")) {
            if (this.f9771j) {
                Handler handler = this.f9766e;
                if (handler == null) {
                    s.z("cameraHandler");
                    throw null;
                }
                handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        Camera1Impl.b(camera);
                    }
                });
            }
            Handler handler2 = this.f9766e;
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        Camera1Impl.c(camera, this);
                    }
                });
            } else {
                s.z("cameraHandler");
                throw null;
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void closeCamera$camera_manager_release() {
        us.pinguo.common.log.a.c("ON_PAUSE", new Object[0]);
        final Camera camera = this.f9767f;
        if (camera != null) {
            camera.setPreviewCallbackWithBuffer(null);
        }
        this.f9767f = null;
        us.pinguo.cameramanger.viewfinder.a aVar = this.f9768g;
        if (aVar != null) {
            aVar.a();
        }
        Handler handler = this.f9766e;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Impl.i(Camera1Impl.this, camera);
                }
            });
        } else {
            s.z("cameraHandler");
            throw null;
        }
    }

    public final void e() {
        if (this.f9771j) {
            Handler handler = this.f9766e;
            if (handler != null) {
                handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        Camera1Impl.f(Camera1Impl.this);
                    }
                });
            } else {
                s.z("cameraHandler");
                throw null;
            }
        }
    }

    public final boolean g(CameraFrame frame) {
        LiveData<us.pinguo.cameramanger.info.b> c;
        us.pinguo.cameramanger.info.b value;
        EnumMap<CameraFrame, Size> c2;
        LiveData<us.pinguo.cameramanger.info.b> c3;
        us.pinguo.cameramanger.info.b value2;
        EnumMap<CameraFrame, Size> b;
        s.h(frame, "frame");
        this.a = frame;
        us.pinguo.cameramanger.info.a aVar = this.f9769h.get(this.b);
        final Size size = (aVar == null || (c = aVar.c()) == null || (value = c.getValue()) == null || (c2 = value.c()) == null) ? null : c2.get(frame);
        us.pinguo.cameramanger.info.a aVar2 = this.f9769h.get(this.b);
        final Size size2 = (aVar2 == null || (c3 = aVar2.c()) == null || (value2 = c3.getValue()) == null || (b = value2.b()) == null) ? null : b.get(frame);
        us.pinguo.common.log.a.c("changeFrame:" + frame + ", previewSize=" + size, new Object[0]);
        if (size == null || size2 == null) {
            return false;
        }
        Handler handler = this.f9766e;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Impl.h(Camera1Impl.this, size, size2);
                }
            });
            return true;
        }
        s.z("cameraHandler");
        throw null;
    }

    public final EnumMap<LensFacing, us.pinguo.cameramanger.info.a> j() {
        return this.f9769h;
    }

    public final LensFacing k() {
        return this.b;
    }

    public final CameraFrame l() {
        return this.a;
    }

    public final Camera m() {
        return this.f9767f;
    }

    public final us.pinguo.cameramanger.viewfinder.a n() {
        return this.f9768g;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void openCamera$camera_manager_release() {
        us.pinguo.common.log.a.c("ON_RESUME", new Object[0]);
        Handler handler = this.f9766e;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.cameramanger.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    Camera1Impl.A(Camera1Impl.this);
                }
            });
            us.pinguo.cameramanger.viewfinder.a aVar = this.f9768g;
            if (aVar == null) {
                return;
            }
            aVar.b();
            return;
        }
        s.z("cameraHandler");
        throw null;
    }
}
