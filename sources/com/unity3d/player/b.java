package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.room.RoomDatabase;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class b {
    private static CameraManager b;
    private static String[] c;

    /* renamed from: e  reason: collision with root package name */
    private static Semaphore f8386e = new Semaphore(1);
    private d a;

    /* renamed from: d  reason: collision with root package name */
    private CameraDevice f8387d;

    /* renamed from: f  reason: collision with root package name */
    private HandlerThread f8388f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f8389g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f8390h;

    /* renamed from: i  reason: collision with root package name */
    private Rect f8391i;

    /* renamed from: j  reason: collision with root package name */
    private int f8392j;

    /* renamed from: k  reason: collision with root package name */
    private int f8393k;
    private int n;
    private int o;
    private Range q;
    private Image s;
    private CaptureRequest.Builder t;
    private int w;
    private SurfaceTexture x;

    /* renamed from: l  reason: collision with root package name */
    private float f8394l = -1.0f;
    private float m = -1.0f;
    private boolean p = false;
    private ImageReader r = null;
    private CameraCaptureSession u = null;
    private Object v = new Object();
    private Surface y = null;
    private int z = a.c;
    private CameraCaptureSession.CaptureCallback A = new CameraCaptureSession.CaptureCallback() { // from class: com.unity3d.player.b.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            b.this.a(captureRequest.getTag());
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            g.Log(5, "Camera2: Capture session failed " + captureRequest.getTag() + " reason " + captureFailure.getReason());
            b.this.a(captureRequest.getTag());
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i2) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i2, long j2) {
        }
    };
    private final CameraDevice.StateCallback B = new CameraDevice.StateCallback() { // from class: com.unity3d.player.b.3
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice cameraDevice) {
            b.f8386e.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) {
            g.Log(5, "Camera2: CameraDevice disconnected.");
            b.this.a(cameraDevice);
            b.f8386e.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i2) {
            g.Log(6, "Camera2: Error opeining CameraDevice " + i2);
            b.this.a(cameraDevice);
            b.f8386e.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) {
            b.this.f8387d = cameraDevice;
            b.f8386e.release();
        }
    };
    private final ImageReader.OnImageAvailableListener C = new ImageReader.OnImageAvailableListener() { // from class: com.unity3d.player.b.4
        @Override // android.media.ImageReader.OnImageAvailableListener
        public final void onImageAvailable(ImageReader imageReader) {
            if (b.f8386e.tryAcquire()) {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    Image.Plane[] planes = acquireNextImage.getPlanes();
                    if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        b.this.a.a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        g.Log(6, "Camera2: Wrong image format.");
                    }
                    if (b.this.s != null) {
                        b.this.s.close();
                    }
                    b.this.s = acquireNextImage;
                }
                b.f8386e.release();
            }
        }
    };
    private final SurfaceTexture.OnFrameAvailableListener D = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.unity3d.player.b.5
        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            b.this.a.a(surfaceTexture);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ int[] f8395d = {1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(d dVar) {
        this.a = null;
        this.a = dVar;
        g();
    }

    public static int a(Context context) {
        return c(context).length;
    }

    public static int a(Context context, int i2) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(c(context)[i2]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
            return 0;
        }
    }

    private static int a(Range[] rangeArr, int i2) {
        int i3 = -1;
        double d2 = Double.MAX_VALUE;
        for (int i4 = 0; i4 < rangeArr.length; i4++) {
            int intValue = ((Integer) rangeArr[i4].getLower()).intValue();
            int intValue2 = ((Integer) rangeArr[i4].getUpper()).intValue();
            float f2 = i2;
            if (f2 + 0.1f > intValue && f2 - 0.1f < intValue2) {
                return i2;
            }
            if (r4 < d2) {
                i3 = i4;
                d2 = r4;
            }
        }
        return ((Integer) (i2 > ((Integer) rangeArr[i3].getUpper()).intValue() ? rangeArr[i3].getUpper() : rangeArr[i3].getLower())).intValue();
    }

    private static Rect a(Size[] sizeArr, double d2, double d3) {
        double d4 = Double.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < sizeArr.length; i4++) {
            int width = sizeArr[i4].getWidth();
            int height = sizeArr[i4].getHeight();
            double abs = Math.abs(Math.log(d2 / width)) + Math.abs(Math.log(d3 / height));
            if (abs < d4) {
                i2 = width;
                i3 = height;
                d4 = abs;
            }
        }
        return new Rect(0, 0, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CameraDevice cameraDevice) {
        synchronized (this.v) {
            this.u = null;
        }
        cameraDevice.close();
        this.f8387d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        if (obj != "Focus") {
            if (obj == "Cancel focus") {
                synchronized (this.v) {
                    if (this.u != null) {
                        j();
                    }
                }
                return;
            }
            return;
        }
        this.p = false;
        synchronized (this.v) {
            if (this.u != null) {
                try {
                    this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                    this.t.setTag("Regular");
                    this.u.setRepeatingRequest(this.t.build(), this.A, this.f8389g);
                } catch (CameraAccessException e2) {
                    g.Log(6, "Camera2: CameraAccessException " + e2);
                }
            }
        }
    }

    private static Size[] a(CameraCharacteristics cameraCharacteristics) {
        String str;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            str = "Camera2: configuration map is not available.";
        } else {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes != null && outputSizes.length != 0) {
                return outputSizes;
            }
            str = "Camera2: output sizes for YUV_420_888 format are not avialable.";
        }
        g.Log(6, str);
        return null;
    }

    private static CameraManager b(Context context) {
        if (b == null) {
            b = (CameraManager) context.getSystemService("camera");
        }
        return b;
    }

    private void b(CameraCharacteristics cameraCharacteristics) {
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
        this.f8393k = intValue;
        if (intValue > 0) {
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.f8391i = rect;
            float width = rect.width() / this.f8391i.height();
            float width2 = this.f8390h.width() / this.f8390h.height();
            if (width2 > width) {
                this.n = 0;
                this.o = (int) ((this.f8391i.height() - (this.f8391i.width() / width2)) / 2.0f);
            } else {
                this.o = 0;
                this.n = (int) ((this.f8391i.width() - (this.f8391i.height() * width2)) / 2.0f);
            }
            this.f8392j = Math.min(this.f8391i.width(), this.f8391i.height()) / 20;
        }
    }

    public static boolean b(Context context, int i2) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(c(context)[i2]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
            return false;
        }
    }

    public static boolean c(Context context, int i2) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(c(context)[i2]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
            return false;
        }
    }

    private static String[] c(Context context) {
        if (c == null) {
            try {
                c = b(context).getCameraIdList();
            } catch (CameraAccessException e2) {
                g.Log(6, "Camera2: CameraAccessException " + e2);
                c = new String[0];
            }
        }
        return c;
    }

    public static int[] d(Context context, int i2) {
        try {
            Size[] a2 = a(b(context).getCameraCharacteristics(c(context)[i2]));
            if (a2 != null) {
                int[] iArr = new int[a2.length * 2];
                for (int i3 = 0; i3 < a2.length; i3++) {
                    int i4 = i3 * 2;
                    iArr[i4] = a2[i3].getWidth();
                    iArr[i4 + 1] = a2[i3].getHeight();
                }
                return iArr;
            }
            return null;
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
            return null;
        }
    }

    private void g() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f8388f = handlerThread;
        handlerThread.start();
        this.f8389g = new Handler(this.f8388f.getLooper());
    }

    private void h() {
        this.f8388f.quit();
        try {
            this.f8388f.join(4000L);
            this.f8388f = null;
            this.f8389g = null;
        } catch (InterruptedException e2) {
            this.f8388f.interrupt();
            g.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e2);
        }
    }

    private void i() {
        try {
            Semaphore semaphore = f8386e;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!semaphore.tryAcquire(4L, timeUnit)) {
                g.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f8387d.close();
            try {
                if (!f8386e.tryAcquire(4L, timeUnit)) {
                    g.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e2) {
                g.Log(6, "Camera2: Interrupted while waiting to close camera " + e2);
            }
            this.f8387d = null;
            f8386e.release();
        } catch (InterruptedException e3) {
            g.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            if (this.f8393k != 0) {
                float f2 = this.f8394l;
                if (f2 >= 0.0f && f2 <= 1.0f) {
                    float f3 = this.m;
                    if (f3 >= 0.0f && f3 <= 1.0f) {
                        this.p = true;
                        int width = this.f8391i.width();
                        int i2 = this.n;
                        int height = this.f8391i.height();
                        int i3 = this.o;
                        int i4 = (int) (((height - (i3 * 2)) * (1.0d - this.m)) + i3);
                        int max = Math.max(this.f8392j + 1, Math.min((int) (((width - (i2 * 2)) * this.f8394l) + i2), (this.f8391i.width() - this.f8392j) - 1));
                        int max2 = Math.max(this.f8392j + 1, Math.min(i4, (this.f8391i.height() - this.f8392j) - 1));
                        CaptureRequest.Builder builder = this.t;
                        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
                        int i5 = this.f8392j;
                        builder.set(key, new MeteringRectangle[]{new MeteringRectangle(max - i5, max2 - i5, i5 * 2, i5 * 2, RoomDatabase.MAX_BIND_PARAMETER_CNT)});
                        this.t.set(CaptureRequest.CONTROL_AF_MODE, 1);
                        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                        this.t.setTag("Focus");
                        this.u.capture(this.t.build(), this.A, this.f8389g);
                        return;
                    }
                }
            }
            this.t.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.t.setTag("Regular");
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(this.t.build(), this.A, this.f8389g);
            }
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    private void k() {
        try {
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.t.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.t.setTag("Cancel focus");
                this.u.capture(this.t.build(), this.A, this.f8389g);
            }
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    public final Rect a() {
        return this.f8390h;
    }

    public final boolean a(float f2, float f3) {
        if (this.f8393k > 0) {
            if (this.p) {
                g.Log(5, "Camera2: Setting manual focus point already started.");
                return false;
            }
            this.f8394l = f2;
            this.m = f3;
            synchronized (this.v) {
                if (this.u != null && this.z != a.b) {
                    k();
                }
            }
            return true;
        }
        return false;
    }

    public final boolean a(Context context, int i2, int i3, int i4, int i5, int i6) {
        try {
            CameraCharacteristics cameraCharacteristics = b.getCameraCharacteristics(c(context)[i2]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                g.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            Size[] a2 = a(cameraCharacteristics);
            if (a2 != null && a2.length != 0) {
                this.f8390h = a(a2, i3, i4);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr != null && rangeArr.length != 0) {
                    int a3 = a(rangeArr, i5);
                    this.q = new Range(Integer.valueOf(a3), Integer.valueOf(a3));
                    try {
                        Semaphore semaphore = f8386e;
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        if (!semaphore.tryAcquire(4L, timeUnit)) {
                            g.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                            return false;
                        }
                        try {
                            b.openCamera(c(context)[i2], this.B, this.f8389g);
                            try {
                            } catch (InterruptedException e2) {
                                g.Log(6, "Camera2: Interrupted while waiting to open camera " + e2);
                            }
                            if (!f8386e.tryAcquire(4L, timeUnit)) {
                                g.Log(5, "Camera2: Timeout waiting to open camera.");
                                return false;
                            }
                            f8386e.release();
                            this.w = i6;
                            b(cameraCharacteristics);
                            return this.f8387d != null;
                        } catch (CameraAccessException e3) {
                            g.Log(6, "Camera2: CameraAccessException " + e3);
                            f8386e.release();
                            return false;
                        }
                    } catch (InterruptedException e4) {
                        g.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e4);
                        return false;
                    }
                }
                g.Log(6, "Camera2: target FPS ranges are not avialable.");
            }
            return false;
        } catch (CameraAccessException e5) {
            g.Log(6, "Camera2: CameraAccessException " + e5);
            return false;
        }
    }

    public final void b() {
        if (this.f8387d != null) {
            e();
            i();
            this.A = null;
            this.y = null;
            this.x = null;
            Image image = this.s;
            if (image != null) {
                image.close();
                this.s = null;
            }
            ImageReader imageReader = this.r;
            if (imageReader != null) {
                imageReader.close();
                this.r = null;
            }
        }
        h();
    }

    public final void c() {
        if (this.r == null) {
            ImageReader newInstance = ImageReader.newInstance(this.f8390h.width(), this.f8390h.height(), 35, 2);
            this.r = newInstance;
            newInstance.setOnImageAvailableListener(this.C, this.f8389g);
            this.s = null;
            if (this.w != 0) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.w);
                this.x = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.f8390h.width(), this.f8390h.height());
                this.x.setOnFrameAvailableListener(this.D, this.f8389g);
                this.y = new Surface(this.x);
            }
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession == null) {
                CameraDevice cameraDevice = this.f8387d;
                Surface surface = this.y;
                cameraDevice.createCaptureSession(surface != null ? Arrays.asList(surface, this.r.getSurface()) : Arrays.asList(this.r.getSurface()), new CameraCaptureSession.StateCallback() { // from class: com.unity3d.player.b.2
                    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession2) {
                        g.Log(6, "Camera2: CaptureSession configuration failed.");
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                    public final void onConfigured(CameraCaptureSession cameraCaptureSession2) {
                        if (b.this.f8387d == null) {
                            return;
                        }
                        synchronized (b.this.v) {
                            b.this.u = cameraCaptureSession2;
                            try {
                                b bVar = b.this;
                                bVar.t = bVar.f8387d.createCaptureRequest(1);
                                if (b.this.y != null) {
                                    b.this.t.addTarget(b.this.y);
                                }
                                b.this.t.addTarget(b.this.r.getSurface());
                                b.this.t.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, b.this.q);
                                b.this.j();
                            } catch (CameraAccessException e2) {
                                g.Log(6, "Camera2: CameraAccessException " + e2);
                            }
                        }
                    }
                }, this.f8389g);
            } else if (this.z == a.b) {
                cameraCaptureSession.setRepeatingRequest(this.t.build(), this.A, this.f8389g);
            }
            this.z = a.a;
        } catch (CameraAccessException e2) {
            g.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    public final void d() {
        synchronized (this.v) {
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                    this.z = a.b;
                } catch (CameraAccessException e2) {
                    g.Log(6, "Camera2: CameraAccessException " + e2);
                }
            }
        }
    }

    public final void e() {
        synchronized (this.v) {
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.abortCaptures();
                } catch (CameraAccessException e2) {
                    g.Log(6, "Camera2: CameraAccessException " + e2);
                }
                this.u.close();
                this.u = null;
                this.z = a.c;
            }
        }
    }
}
