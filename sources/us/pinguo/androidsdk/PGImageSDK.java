package us.pinguo.androidsdk;

import android.content.Context;
import android.graphics.Bitmap;
import us.pinguo.androidsdk.PGNativeMethod;
/* loaded from: classes3.dex */
public class PGImageSDK {
    public static final int SDK_STATUS_CREATE = 268435456;
    public static final int SDK_STATUS_DESTROY = 268435458;
    public static final int SDK_STATUS_DRAW = 268435457;
    public static final int SDK_STATUS_RELOAD = 268435459;
    private byte[] bShaderScript;
    private Context mContext;
    private String strKey;
    private long mRendererPointer = 0;
    private long mEGLPointer = 0;
    private int nSDKStatus = SDK_STATUS_CREATE;
    private boolean bReload = false;
    private boolean bRunning = false;
    private PGGLThread mThread = null;
    private PGRendererMethod mMethod = null;
    private final Object mRenderActionLock = new Object();

    /* loaded from: classes3.dex */
    public enum BarrelMode {
        BARREL_MODE_TOTAL(0),
        BARREL_MODE_UD_SIDE(1),
        BARREL_MODE_LR_SIDE(2);
        
        private int index;

        BarrelMode(int i2) {
            this.index = i2;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public PGImageSDK(Context context, String str, byte[] bArr) {
        this.bShaderScript = null;
        this.bShaderScript = bArr;
        init(context, str);
    }

    private void init(Context context, String str) {
        this.mContext = context;
        this.strKey = str;
        PGGLThread pGGLThread = new PGGLThread();
        this.mThread = pGGLThread;
        pGGLThread.setImageSDK(this);
    }

    public void PortraitEditorClean() {
        PGNativeMethod.PortraitEditorClean(this.mRendererPointer);
    }

    public boolean backwardMosaicStep() {
        return PGNativeMethod.backwardMosaicStep(this.mRendererPointer);
    }

    public void beginPlayVideo() {
        PGNativeMethod.beginVideoPlay(this.mRendererPointer);
    }

    public void beginPlayVideoWidthWait() {
        synchronized (this.mRenderActionLock) {
            PGNativeMethod.beginVideoPlay(this.mRendererPointer);
        }
    }

    public boolean compositeAVFiles(String str, String str2, String str3) {
        return PGNativeMethod.compositeAVFiles(this.mRendererPointer, str, str2, str3);
    }

    public boolean configAVOutput(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return PGNativeMethod.configAVOutput(this.mRendererPointer, str, i2, i3, i4, i5, i6, i7, i8);
    }

    public void create() {
        RenderPointerManager.getCurrentThreadPointer().initRenderPointer(this.strKey, this.mContext, this.bShaderScript);
        RenderPointerManager.getCurrentThreadPointer().initMakeupPointer();
        this.mRendererPointer = RenderPointerManager.getCurrentThreadPointer().getRendererPointer();
        this.nSDKStatus = SDK_STATUS_DRAW;
    }

    public boolean createEGLDisplay() {
        long createEGLDisplay = PGNativeMethod.createEGLDisplay();
        this.mEGLPointer = createEGLDisplay;
        return createEGLDisplay != 0;
    }

    public void destroy() {
        RenderPointerManager.getCurrentThreadPointer().destroyPointer();
        this.mRendererPointer = 0L;
    }

    public void destroyCpuSkinSoftenEngine() {
        PGNativeMethod.destroyCpuSkinSoftenEngine(this.mRendererPointer);
    }

    public void destroySDK() {
        synchronized (this.mRenderActionLock) {
            this.nSDKStatus = SDK_STATUS_DESTROY;
            this.mRenderActionLock.notify();
            this.mContext = null;
        }
    }

    public boolean forwardMosaicStep() {
        return PGNativeMethod.forwardMosaicStep(this.mRendererPointer);
    }

    public double[] genDisortCorrectMatrix(int i2, int i3, float f2, float f3, float f4, float f5, float f6) {
        return PGNativeMethod.genDisortCorrectMatrix(this.mRendererPointer, i2, i3, f2, f3, f4, f5, f6);
    }

    public double[] getBarrelDisortParam(BarrelMode barrelMode, int i2, int i3, float f2) {
        return PGNativeMethod.getBarrelDisortParam(this.mRendererPointer, barrelMode.getIndex(), i2, i3, f2);
    }

    public double[] getBenchmarkSkinColor(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return PGNativeMethod.getBenchmarkSkinColor(this.mRendererPointer, bArr, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public int getCurrentStepNum() {
        return PGNativeMethod.getCurrentStepNum(this.mRendererPointer);
    }

    public Object getRenderActionLock() {
        return this.mRenderActionLock;
    }

    public PGRendererMethod getRenderMethod() {
        return this.mMethod;
    }

    public long getRenderPointer() {
        return this.mRendererPointer;
    }

    public byte[] getResource() {
        return this.bShaderScript;
    }

    public int getSDKStatus() {
        return this.nSDKStatus;
    }

    public float getSaveVideoDuration() {
        return PGNativeMethod.getVideoDuration(this.mRendererPointer);
    }

    public float getSaveVideoFrameRate() {
        return PGNativeMethod.getVideoFrameRate(this.mRendererPointer);
    }

    public int getSaveVideoHeight() {
        return PGNativeMethod.getVideoHeight(this.mRendererPointer);
    }

    public int getSaveVideoWidth() {
        return PGNativeMethod.getVideoWidth(this.mRendererPointer);
    }

    public float getSkinAverageBrightness(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return PGNativeMethod.getSkinAverageBrightness(this.mRendererPointer, bArr, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public int getTemplateDuration() {
        return (int) PGNativeMethod.getTemplateDuration(this.mRendererPointer);
    }

    public boolean isDestroy() {
        return 268435458 == this.nSDKStatus;
    }

    public boolean isRenderActionBusyRunning() {
        PGGLThread pGGLThread = this.mThread;
        return pGGLThread != null && pGGLThread.isBusyRunning();
    }

    public boolean isSupportHighPrecision() {
        return PGNativeMethod.isSupportHighFloat(this.mRendererPointer);
    }

    public boolean mixAudio2File(String str, String str2, String str3) {
        return PGNativeMethod.mixAudio2File(this.mRendererPointer, str, str2, str3);
    }

    public void pausePlayVideo() {
        PGNativeMethod.pauseVideoPlay(this.mRendererPointer);
    }

    public void releaseEGLDisplay() {
        long j2 = this.mEGLPointer;
        if (j2 != 0) {
            PGNativeMethod.destroyEGLDisplay(j2);
        }
    }

    public boolean reloadResource(byte[] bArr) {
        boolean z;
        synchronized (this.mRenderActionLock) {
            this.bShaderScript = bArr;
            this.nSDKStatus = SDK_STATUS_RELOAD;
            if (!this.bRunning) {
                this.mThread.run();
                try {
                    this.mRenderActionLock.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.bRunning = true;
            }
            this.mRenderActionLock.notify();
            try {
                this.mRenderActionLock.wait();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            this.nSDKStatus = SDK_STATUS_DRAW;
            z = this.bReload;
        }
        return z;
    }

    public void renderAction(PGRendererMethod pGRendererMethod) {
        if (this.bRunning) {
            if (pGRendererMethod == null || this.mRendererPointer == 0) {
                return;
            }
        } else if (pGRendererMethod == null) {
            return;
        }
        this.mMethod = pGRendererMethod;
        synchronized (this.mRenderActionLock) {
            if (!this.bRunning) {
                this.mThread.run();
                try {
                    this.mRenderActionLock.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.bRunning = true;
            }
            this.mMethod.setRendererPointer(this.mRendererPointer);
            this.mRenderActionLock.notify();
        }
    }

    public void renderActionWithWait(PGRendererMethod pGRendererMethod) {
        synchronized (this.mRenderActionLock) {
            boolean z = this.bRunning;
            if (z) {
                if (pGRendererMethod == null || this.mRendererPointer == 0) {
                    return;
                }
            } else if (pGRendererMethod == null) {
                return;
            }
            this.mMethod = pGRendererMethod;
            if (!z) {
                this.mThread.run();
                try {
                    this.mRenderActionLock.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.bRunning = true;
            }
            this.mMethod.setRendererPointer(this.mRendererPointer);
            this.mRenderActionLock.notify();
            try {
                this.mRenderActionLock.wait();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void resumePlayVideo() {
        PGNativeMethod.resumeVideoPlay(this.mRendererPointer);
    }

    public boolean rotatingJpegAndSave(String str, String str2, float f2) {
        return PGNativeMethod.rotatingJpegAndSave(this.mRendererPointer, str, str2, f2);
    }

    public boolean saveMosaicImageToStepList() {
        return PGNativeMethod.saveMosaicImageToStepList(this.mRendererPointer);
    }

    public void setResourceStatus(boolean z) {
        this.bReload = z;
    }

    public void setSDKStatus(int i2) {
        this.nSDKStatus = i2;
    }

    public boolean setTemplateDuration(float f2) {
        return PGNativeMethod.setTemplateDuration(this.mRendererPointer, f2);
    }

    public boolean setVideoLayerEffect(int i2, String str) {
        return PGNativeMethod.setVideoLayerEffect(this.mRendererPointer, i2, str);
    }

    public void setVideoPlayCallback(PGNativeMethod.PGVideoPlayerCallback pGVideoPlayerCallback) {
        PGNativeMethod.setVideoSDKCallback(pGVideoPlayerCallback);
    }

    public void stopPlayVideo() {
        PGNativeMethod.stopVideoPlay(this.mRendererPointer);
    }

    public void stopPlayVideoWithWait() {
        synchronized (this.mRenderActionLock) {
            PGNativeMethod.stopVideoPlay(this.mRendererPointer);
        }
    }

    public boolean updatePreviewImageWithSize(Bitmap bitmap) {
        return PGNativeMethod.updatePreviewImageWithSize(this.mRendererPointer, bitmap);
    }

    public boolean writeAVFrame(byte[] bArr, float f2, int i2, int i3, int i4, boolean z, boolean z2) {
        return PGNativeMethod.writeAVFrame(this.mRendererPointer, bArr, f2, i2, i3, i4, z, z2);
    }

    public boolean writeAVFrameRGB(int[] iArr, float f2, int i2, int i3, int i4, boolean z, boolean z2) {
        return PGNativeMethod.writeAVFrameRGB(this.mRendererPointer, iArr, f2, i2, i3, i4, z, z2);
    }

    public boolean writeAVFrameYUV444(int[] iArr, float f2, int i2, int i3) {
        return PGNativeMethod.writeAVFrameYUV444(this.mRendererPointer, iArr, f2, i2, i3);
    }

    public void writeAVHeader() {
        PGNativeMethod.writeAVHeader(this.mRendererPointer);
    }

    public void writeAVTrailer() {
        PGNativeMethod.writeAVTrailer(this.mRendererPointer);
    }

    public boolean writePcmFrame(byte[] bArr, float f2) {
        return PGNativeMethod.writePcmFrame(this.mRendererPointer, bArr, f2);
    }

    public boolean writePcmFrame(short[] sArr, float f2) {
        return PGNativeMethod.writePcmFrame(this.mRendererPointer, sArr, f2);
    }
}
