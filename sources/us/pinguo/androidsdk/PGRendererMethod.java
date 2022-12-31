package us.pinguo.androidsdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import d.f.a.b.d;
import us.pinguo.androidsdk.PGNativeMethod;
/* loaded from: classes3.dex */
public abstract class PGRendererMethod {
    public static final int SSSO_BIG_EYE = 4;
    public static final int SSSO_BRIGHTEN_EYE = 16;
    public static final int SSSO_EYE_BAG_REMOVAL = 2;
    public static final int SSSO_FLW_REMOVAL = 1;
    public static final int SSSO_SKIN_SOFTEN_ALL = 31;
    public static final int SSSO_THIN_FACE = 8;
    public static volatile Boolean sSupportHighFloat;
    private String mFunnyXMLFilePath = null;
    private long mRendererPointer = 0;
    private boolean needCleanColor = false;
    private int lastPngFilename = -1;
    private int lastParamsString = -1;

    /* renamed from: us.pinguo.androidsdk.PGRendererMethod$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$us$pinguo$androidsdk$PGRendererMethod$EM_MAKE_TYPE;

        static {
            int[] iArr = new int[EM_MAKE_TYPE.values().length];
            $SwitchMap$us$pinguo$androidsdk$PGRendererMethod$EM_MAKE_TYPE = iArr;
            try {
                iArr[EM_MAKE_TYPE.RENDER_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$us$pinguo$androidsdk$PGRendererMethod$EM_MAKE_TYPE[EM_MAKE_TYPE.RENDER_SCENE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

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

    /* loaded from: classes3.dex */
    public enum EM_MAKE_TYPE {
        RENDER_NORMAL,
        RENDER_SCENE
    }

    private boolean checkSupportHighFloat() {
        if (sSupportHighFloat == null) {
            String str = Build.MODEL;
            boolean z = true;
            if (!(Build.VERSION.SDK_INT == 24 && ("SM-G935L".equals(str) || "SM-G935S".equals(str) || "SM-G935F".equals(str)))) {
                String str2 = Build.HARDWARE;
                if (!"samsungexynos8890".equals(str2) && !"pxa988".equals(str2)) {
                    z = false;
                }
            }
            if (z) {
                sSupportHighFloat = Boolean.FALSE;
            } else {
                sSupportHighFloat = Boolean.valueOf(PGNativeMethod.isSupportHighFloat(this.mRendererPointer));
            }
        }
        return sSupportHighFloat.booleanValue();
    }

    public boolean PortraitEditorAutoCleanAcne() {
        return PGNativeMethod.PortraitEditorAutoCleanAcne(this.mRendererPointer);
    }

    public boolean PortraitEditorBigEye(float f2) {
        return PGNativeMethod.PortraitEditorBigEye(this.mRendererPointer, f2);
    }

    public void PortraitEditorClean() {
        PGNativeMethod.PortraitEditorClean(this.mRendererPointer);
    }

    public boolean PortraitEditorCleanAcne(int i2, int i3, int i4) {
        return PGNativeMethod.PortraitEditorCleanAcne(this.mRendererPointer, i2, i3, i4);
    }

    public boolean PortraitEditorEyeBagRemoval(int i2) {
        return PGNativeMethod.PortraitEditorEyeBagRemoval(this.mRendererPointer, i2);
    }

    public boolean PortraitEditorGetImageToBitmap(Bitmap bitmap) {
        return PGNativeMethod.PortraitEditorGetImageToBitmap(this.mRendererPointer, bitmap);
    }

    public boolean PortraitEditorGetImageToPath(String str, int i2) {
        return PGNativeMethod.PortraitEditorGetImageToPath(this.mRendererPointer, str, i2);
    }

    public boolean PortraitEditorGetImageToPngPath(String str, int i2) {
        return PGNativeMethod.PortraitEditorGetImageToPngPath(this.mRendererPointer, str, i2);
    }

    public boolean PortraitEditorImproveNose(String str, int[] iArr, float f2, String str2, int[] iArr2, float f3) {
        return PGNativeMethod.PortraitEditorImproveNose(this.mRendererPointer, str, iArr, f2, str2, iArr2, f3);
    }

    public boolean PortraitEditorManualLiquify(int i2, int i3, int i4, int i5, int i6) {
        return PGNativeMethod.PortraitEditorManualLiquify(this.mRendererPointer, i2, i3, i4, i5, i6);
    }

    public boolean PortraitEditorSetImageByBitmap(Bitmap bitmap) {
        return PGNativeMethod.PortraitEditorSetImageByBitmap(this.mRendererPointer, bitmap);
    }

    public boolean PortraitEditorSetImageByPath(String str) {
        return PGNativeMethod.PortraitEditorSetImageByPath(this.mRendererPointer, str);
    }

    public boolean PortraitEditorSetImageByPngPath(String str) {
        return PGNativeMethod.PortraitEditorSetImageByPngPath(this.mRendererPointer, str);
    }

    public boolean PortraitEditorSetPoints(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int[] iArr3, PGFacialKeyPoints pGFacialKeyPoints) {
        return PGNativeMethod.PortraitEditorSetPoints(this.mRendererPointer, i2, i3, i4, i5, iArr, iArr2, iArr3, pGFacialKeyPoints);
    }

    public boolean PortraitEditorSetResultToGPUInput(int i2) {
        return PGNativeMethod.PortraitEditorSetResultToGPUInput(this.mRendererPointer, i2);
    }

    public boolean PortraitEditorSkinSoften(int i2) {
        return PGNativeMethod.PortraitEditorSkinSoften(this.mRendererPointer, i2);
    }

    public boolean PortraitEditorSparkingEye(int i2) {
        return PGNativeMethod.PortraitEditorSparkingEye(this.mRendererPointer, i2);
    }

    public boolean PortraitEditorThinFace(int i2, int i3) {
        return PGNativeMethod.PortraitEditorThinFace(this.mRendererPointer, i2, i3);
    }

    public boolean adjustCameraTexture(int i2, boolean z, int i3, PGRect pGRect, boolean z2, boolean z3, int i4, boolean z4) {
        PGRendererMethod pGRendererMethod;
        PGRect pGRect2;
        if (pGRect == null) {
            pGRect2 = new PGRect();
            pGRendererMethod = this;
        } else {
            pGRendererMethod = this;
            pGRect2 = pGRect;
        }
        return PGNativeMethod.adjustCameraTexture(pGRendererMethod.mRendererPointer, i2, z, i3, pGRect2.getX_1(), pGRect2.getY_1(), pGRect2.getX_2(), pGRect2.getY_2(), z2, z3, i4, z4);
    }

    public boolean adjustImage(int i2, boolean z, int i3, PGRect pGRect, boolean z2, boolean z3, int i4, boolean z4) {
        PGRendererMethod pGRendererMethod;
        PGRect pGRect2;
        if (pGRect == null) {
            pGRect2 = new PGRect();
            pGRendererMethod = this;
        } else {
            pGRendererMethod = this;
            pGRect2 = pGRect;
        }
        return PGNativeMethod.adjustImage(pGRendererMethod.mRendererPointer, i2, z, i3, pGRect2.getX_1(), pGRect2.getY_1(), pGRect2.getX_2(), pGRect2.getY_2(), z2, z3, i4, z4);
    }

    public void beginPlayVideo() {
        PGNativeMethod.beginVideoPlay(this.mRendererPointer);
    }

    public boolean clearImage(int i2) {
        return PGNativeMethod.clearImage(this.mRendererPointer, i2);
    }

    public boolean configAVOutput(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return PGNativeMethod.configAVOutput(this.mRendererPointer, str, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean configSticker(String[] strArr) {
        long j2 = this.mRendererPointer;
        if (j2 == 0) {
            return false;
        }
        PGNativeMethod.configSticker(j2, strArr);
        return true;
    }

    public boolean configStickerOtherAttribute(String str) {
        return PGNativeMethod.configStickerOtherAttribute(this.mRendererPointer, str);
    }

    public void destroyCpuSkinSoftenEngine() {
        PGNativeMethod.destroyCpuSkinSoftenEngine(this.mRendererPointer);
    }

    protected boolean funnyMake(PGNativeMethod.Enum_FunnyMakeState enum_FunnyMakeState) {
        return PGNativeMethod.funnyMake(this.mRendererPointer, enum_FunnyMakeState.ordinal());
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

    public double[] getBenchmarkSkinColorJpeg(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return PGNativeMethod.getBenchmarkSkinColorJpeg(this.mRendererPointer, bArr, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public int getFunnyBGLayerEffectsNum() {
        return PGNativeMethod.getFunnyBGLayerEffectsNum(this.mRendererPointer);
    }

    public int[] getFunnyBGLayerRect() {
        return PGNativeMethod.getFunnyBGLayerRect(this.mRendererPointer);
    }

    public int getFunnyFGLayerEffectsNum() {
        return PGNativeMethod.getFunnyFGLayerEffectsNum(this.mRendererPointer);
    }

    public int[] getFunnyFGlayerRect() {
        return PGNativeMethod.getFunnyFGlayerRect(this.mRendererPointer);
    }

    public int getFunnyTemplateHeight() {
        return PGNativeMethod.getFunnyTemplateHeight(this.mRendererPointer);
    }

    public int getFunnyTemplateWidth() {
        return PGNativeMethod.getFunnyTemplateWidth(this.mRendererPointer);
    }

    public int getFunnyTransformLayerNum() {
        return PGNativeMethod.getFunnyTransformLayerNum(this.mRendererPointer);
    }

    public boolean getMakedImage2Bitmap(Bitmap bitmap) {
        return PGNativeMethod.getMakedImage2Bitmap(this.mRendererPointer, bitmap);
    }

    public PGColorBuffer getMakedImage2Buffer() {
        int[] makedImage2Buffer = PGNativeMethod.getMakedImage2Buffer(this.mRendererPointer);
        if (makedImage2Buffer == null) {
            return null;
        }
        PGColorBuffer pGColorBuffer = new PGColorBuffer();
        pGColorBuffer.setColorBuffer(makedImage2Buffer);
        pGColorBuffer.setImageWidth(PGNativeMethod.getMakedImage2BufferWidth(this.mRendererPointer));
        pGColorBuffer.setImageHeight(PGNativeMethod.getMakedImage2BufferHeight(this.mRendererPointer));
        return pGColorBuffer;
    }

    public byte[] getMakedImage2Byte(int i2, int i3, int i4, int i5, int i6, String str, int i7, boolean z) {
        if (str != null && !"Effect=Normal".equals(str)) {
            setEffect(str);
            if (z) {
                stickerPreviewFrameAdjust(0, i7, false, true);
            } else {
                stickerPreviewFrameAdjust(0, i7, true, true);
            }
            make();
            stickerPreviewFrameReset(0);
        }
        byte[] makedImagePreviewJpeg = PGNativeMethod.getMakedImagePreviewJpeg(this.mRendererPointer, i2, i3, i4, i5, i6, 0, 95);
        if (makedImagePreviewJpeg == null) {
            return null;
        }
        return makedImagePreviewJpeg;
    }

    public byte[] getMakedImage2Jpeg(int i2) {
        return PGNativeMethod.getMakedImage2Jpeg(this.mRendererPointer, i2);
    }

    public boolean getMakedImage2JpegFile(String str, int i2) {
        return PGNativeMethod.getMakedImage2JpegFile(this.mRendererPointer, str, i2);
    }

    public boolean getMakedImage2JpegFileEx(String str, int i2) {
        return PGNativeMethod.getMakedImage2JpegFileEx(this.mRendererPointer, str, i2, true);
    }

    public boolean getMakedImage2PngFile(String str, boolean z) {
        return PGNativeMethod.getMakedImage2PngFile(this.mRendererPointer, str, z);
    }

    public boolean getMakedImage2Screen(int i2, int i3, int i4, int i5, int i6) {
        return PGNativeMethod.getMakedImage2Screen(this.mRendererPointer, i2, i3, i4, i5, i6);
    }

    public boolean getMakedImage2Texture(long j2, int i2, int i3, int i4, int i5) {
        return PGNativeMethod.getMakedImage2Texture(this.mRendererPointer, i2, i3, i4, i5);
    }

    public PGColorBuffer getMakedImagePreview(int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] makedImagePreview = PGNativeMethod.getMakedImagePreview(this.mRendererPointer, i2, i3, i4, i5, i6, i7);
        if (makedImagePreview == null) {
            return null;
        }
        PGColorBuffer pGColorBuffer = new PGColorBuffer();
        pGColorBuffer.setColorBuffer(makedImagePreview);
        pGColorBuffer.setImageWidth(PGNativeMethod.getMakedImagePreviewWidth(this.mRendererPointer));
        pGColorBuffer.setImageHeight(PGNativeMethod.getMakedImagePreviewHeight(this.mRendererPointer));
        return pGColorBuffer;
    }

    public byte[] getMakedImagePreviewJpeg(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return PGNativeMethod.getMakedImagePreviewJpeg(this.mRendererPointer, i2, i3, i4, i5, i6, i7, i8);
    }

    public int getMakedImageTextureID() {
        return PGNativeMethod.getMakedImageTextureID(this.mRendererPointer);
    }

    public byte[] getMakedNormalImage2Buffer(int i2, int i3, int i4, int i5, int i6) {
        setEffect("Effect=Normal");
        make();
        byte[] makedImagePreviewJpeg = PGNativeMethod.getMakedImagePreviewJpeg(this.mRendererPointer, i2, i3, i4, i5, i6, 0, 95);
        if (makedImagePreviewJpeg == null) {
            return null;
        }
        return makedImagePreviewJpeg;
    }

    public long getRendererPointer() {
        return this.mRendererPointer;
    }

    public double[] getStickerDisplayPos() {
        return PGNativeMethod.getStickerCurrentDisplayPos(this.mRendererPointer);
    }

    protected int getTemplateHeight() {
        return PGNativeMethod.getTemplateHeight(this.mRendererPointer);
    }

    protected int getTemplateWidth() {
        return PGNativeMethod.getTemplateWidth(this.mRendererPointer);
    }

    public float getVideoDuration() {
        return PGNativeMethod.getVideoDuration(this.mRendererPointer);
    }

    public boolean getVideoFirstFrame(String str) {
        return PGNativeMethod.getVideoFirstFrame(this.mRendererPointer, str);
    }

    public float getVideoFrameRate() {
        return PGNativeMethod.getVideoFrameRate(this.mRendererPointer);
    }

    public boolean initBindEGLImage(String str, int i2, int i3, int i4, int i5) {
        return PGNativeMethod.initBindEGLImage(this.mRendererPointer, str, i2, i3, i4, i5);
    }

    public boolean initCpuSkinSoftenEngine(int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, PGFacialKeyPoints pGFacialKeyPoints, byte[] bArr) {
        return PGNativeMethod.initCpuSkinSoftenEngine(this.mRendererPointer, i2, i3, i4, i5, i6, i7, iArr, iArr2, iArr3, pGFacialKeyPoints, bArr);
    }

    protected boolean loadFunnyTemplate(String str, String[] strArr, String[] strArr2) {
        if (TextUtils.isEmpty(this.mFunnyXMLFilePath) || !this.mFunnyXMLFilePath.equals(str)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            boolean loadFunnyTemplate = PGNativeMethod.loadFunnyTemplate(this.mRendererPointer, str, strArr, strArr2);
            if (loadFunnyTemplate) {
                this.mFunnyXMLFilePath = str;
            }
            return loadFunnyTemplate;
        }
        return true;
    }

    protected boolean loadTemplate(String str, String str2) {
        if (this.lastPngFilename == str.hashCode() && this.lastParamsString == str2.hashCode()) {
            return true;
        }
        PGNativeMethod.loadTemplate(this.mRendererPointer, str, str2);
        if (PGNativeMethod.getTemplateLoadResult(this.mRendererPointer)) {
            this.lastPngFilename = str.hashCode();
            this.lastParamsString = str2.hashCode();
            return true;
        }
        this.lastPngFilename = -1;
        this.lastParamsString = -1;
        return false;
    }

    protected boolean loadTemplateSuccess() {
        return PGNativeMethod.getTemplateLoadResult(this.mRendererPointer);
    }

    public boolean make() {
        return PGNativeMethod.make(this.mRendererPointer);
    }

    public boolean makeWithSize(int i2, int i3) {
        return PGNativeMethod.makeWithSize(this.mRendererPointer, i2, i3);
    }

    public boolean mixAudio2File(String str, String str2, String str3) {
        return PGNativeMethod.mixAudio2File(this.mRendererPointer, str, str2, str3);
    }

    public void pausePlayVideo() {
        PGNativeMethod.pauseVideoPlay(this.mRendererPointer);
    }

    public void readEGLImage2NV12ForVideoSDK(int i2, int i3, byte[] bArr, boolean z) {
        PGNativeMethod.readEGLImage2NV12ForVideoSDK(this.mRendererPointer, i2, i3, bArr, z);
    }

    public boolean renderEndingFrame(int i2) {
        return PGNativeMethod.renderEndingFrame(this.mRendererPointer, i2);
    }

    public boolean renderType(EM_MAKE_TYPE em_make_type) {
        int i2 = AnonymousClass1.$SwitchMap$us$pinguo$androidsdk$PGRendererMethod$EM_MAKE_TYPE[em_make_type.ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            this.lastParamsString = -1;
            this.lastPngFilename = -1;
        } else {
            if (i2 != 2) {
                this.lastParamsString = -1;
                this.lastPngFilename = -1;
            }
            return PGNativeMethod.renderType(this.mRendererPointer, i3);
        }
        i3 = 0;
        return PGNativeMethod.renderType(this.mRendererPointer, i3);
    }

    public void renderVideoFrame2SurfaceView() {
        PGNativeMethod.renderNextFrame2View(this.mRendererPointer);
    }

    public void rendererAction() {
    }

    public void resetFunnyXMLFilePath() {
        this.mFunnyXMLFilePath = null;
    }

    public void resetRenderMethod() {
        this.lastParamsString = -1;
        this.lastPngFilename = -1;
    }

    public void resumePlayVideo() {
        PGNativeMethod.resumeVideoPlay(this.mRendererPointer);
    }

    public boolean runCpuSkinSoftenEngine(int i2, int i3) {
        return PGNativeMethod.runCpuSkinSoftenEngine(this.mRendererPointer, i2, i3);
    }

    public boolean setAutoClearShaderCache(boolean z) {
        return PGNativeMethod.setAutoClearShaderCache(this.mRendererPointer, z);
    }

    public void setBackground(float f2, float f3, float f4, float f5) {
        PGNativeMethod.setBackground(this.mRendererPointer, f2, f3, f4, f5);
    }

    public void setCleanColor() {
        if (this.needCleanColor) {
            PGNativeMethod.setCleanColor(this.mRendererPointer);
        }
    }

    public void setCpuSkinSoftenEngineParam(int i2, float f2, int i3, int i4, float f3, float f4, int i5, float f5, int i6) {
        PGNativeMethod.setCpuSkinSoftenEngineParam(this.mRendererPointer, i2, f2, i3, i4, f3, f4, i5, f5, i6, 16, 1.0f, 1.0f, 1.0f, false);
    }

    public boolean setEffect(String str) {
        if (!checkSupportHighFloat() && str.contains("Portrait_Foundation_Beauty")) {
            str = str.replace("Portrait_Foundation_Beauty", "Portrait_Foundation_Beauty_Medium");
        }
        d.d("PGRendererMethod.setEffect:" + str, new Object[0]);
        return PGNativeMethod.setEffect(this.mRendererPointer, str);
    }

    public boolean setEffectParams(String str, String str2) {
        if (!checkSupportHighFloat() && str.contains("Portrait_Foundation_Beauty")) {
            str = str.replace("Portrait_Foundation_Beauty", "Portrait_Foundation_Beauty_Medium");
        }
        return PGNativeMethod.setEffectParams(this.mRendererPointer, str, str2);
    }

    public void setFrameRect(Rect rect) {
    }

    public boolean setFunnyBGLayerEffect(int i2) {
        return PGNativeMethod.setFunnyBGLayerEffect(this.mRendererPointer, i2);
    }

    public boolean setFunnyBGLayerTransform(float f2, float f3, float f4, float f5) {
        return PGNativeMethod.setFunnyBGLayerTransform(this.mRendererPointer, f2, f3, f4, f5);
    }

    public boolean setFunnyFGLayerEffect(int i2) {
        return PGNativeMethod.setFunnyFGLayerEffect(this.mRendererPointer, i2);
    }

    public boolean setFunnyFGLayerTransform(float f2, float f3, float f4, float f5) {
        return PGNativeMethod.setFunnyFGLayerTransform(this.mRendererPointer, f2, f3, f4, f5);
    }

    public int setFunnyTransform(float f2, float f3, float f4, float f5) {
        return PGNativeMethod.SetFunnyTransform(this.mRendererPointer, f2, f3, f4, f5);
    }

    public boolean setImageFromARGB(int i2, int[] iArr, int i3, int i4) {
        return PGNativeMethod.setImageFromARGB(this.mRendererPointer, i2, iArr, i3, i4, 0.0f, 1.0f);
    }

    public boolean setImageFromBitmap(int i2, Bitmap bitmap) {
        return PGNativeMethod.setImageFromBitmap(this.mRendererPointer, i2, bitmap, 0.0f, 1.0f);
    }

    public boolean setImageFromJPEG(int i2, byte[] bArr) {
        return PGNativeMethod.setImageFromJPEG(this.mRendererPointer, i2, bArr, 0.0f, 1.0f, 0);
    }

    public boolean setImageFromPath(int i2, String str) {
        return PGNativeMethod.setImageFromPath(this.mRendererPointer, i2, str, 0.0f, 1.0f, 0);
    }

    public boolean setImageFromTexture(int i2, int i3, int i4, int i5, boolean z) {
        return PGNativeMethod.setImageFromTexture(this.mRendererPointer, i2, i3, i4, i5, z);
    }

    public boolean setImageFromYUV420SP(int i2, byte[] bArr, int i3, int i4) {
        return PGNativeMethod.setImageFromYUV(this.mRendererPointer, i2, bArr, i3, i4, 0.0f, 1.0f);
    }

    public void setInputVideoCutRect(float f2, float f3, float f4, float f5) {
        PGNativeMethod.setInputVideoCutRect(this.mRendererPointer, f2, f3, f4, f5);
    }

    public boolean setInputVideoRotation(int i2, boolean z, boolean z2) {
        return PGNativeMethod.setInputVideoRotation(this.mRendererPointer, i2, z, z2);
    }

    public boolean setOuputVideoRotation(int i2) {
        return PGNativeMethod.setOuputVideoRotation(this.mRendererPointer, i2);
    }

    public boolean setPreviewWaterMark(Bitmap bitmap, boolean z, float f2, float f3) {
        return PGNativeMethod.setPreviewWaterMark(this.mRendererPointer, bitmap, z, f2, f3);
    }

    public void setRendererPointer(long j2) {
        this.mRendererPointer = j2;
    }

    public boolean setResultImageToInput(int i2) {
        return PGNativeMethod.setResultImageToInput(this.mRendererPointer, i2);
    }

    public void setScreenSize(boolean z, int i2, int i3) {
    }

    public boolean setStickerBeginPos(int i2) {
        return PGNativeMethod.setVideoStickerBeginPos(this.mRendererPointer, i2);
    }

    public boolean setStickerTransform(int i2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return PGNativeMethod.setStickerTransform(this.mRendererPointer, i2, f2, f3, f4, f5, f6, f7, z);
    }

    public boolean setSupportImageFromPNG(int i2, byte[] bArr) {
        return PGNativeMethod.setSupportImageFromPNG(this.mRendererPointer, i2, bArr, 0.0f, 1.0f);
    }

    public boolean setSupportImageFromPNGPath(int i2, String str) {
        return PGNativeMethod.setSupportImageFromPNGPath(this.mRendererPointer, i2, str, 0.0f, 1.0f);
    }

    public boolean setSurfaceAndOutputVideoSize(int i2, int i3, int i4, int i5) {
        return PGNativeMethod.setSurfaceAndOutputVideoSize(this.mRendererPointer, i2, i3, i4, i5);
    }

    public boolean setVideoEffect(int i2, String str) {
        return PGNativeMethod.setVideoLayerEffect(this.mRendererPointer, i2, str);
    }

    public void setVideoEndingFile(String str) {
        PGNativeMethod.setVideoEndingFile(this.mRendererPointer, str);
    }

    public void setVideoPlayerCallback(PGNativeMethod.PGVideoPlayerCallback pGVideoPlayerCallback) {
        PGNativeMethod.setVideoSDKCallback(pGVideoPlayerCallback);
    }

    public boolean setVideoPlayerRotateAngle(int i2) {
        return PGNativeMethod.setOuputVideoRotation(this.mRendererPointer, i2);
    }

    public boolean setVideoTemplateAssets(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, float[][] fArr, String[] strArr3) {
        return PGNativeMethod.setVideoTemplateAssets(this.mRendererPointer, str, str2, str3, str4, strArr, strArr2, fArr, strArr3);
    }

    public void setVideoWaterMark(String str) {
        PGNativeMethod.setVideoWaterMark(this.mRendererPointer, str);
    }

    public boolean stickerPreviewFrameAdjust(int i2, int i3, boolean z, boolean z2) {
        return PGNativeMethod.stickerPreviewFrameAdjust(this.mRendererPointer, i2, i3, z, z2);
    }

    public boolean stickerPreviewFrameReset(int i2) {
        return PGNativeMethod.stickerPreviewFrameReset(this.mRendererPointer);
    }

    public void stopPlayVideo() {
        PGNativeMethod.stopVideoPlay(this.mRendererPointer);
    }

    public boolean writeAVFrame(int i2) {
        return PGNativeMethod.writeAVFrame(this.mRendererPointer, i2);
    }

    public void writeAVHeader() {
        PGNativeMethod.writeAVHeader(this.mRendererPointer);
    }

    public void writeAVTrailer() {
        PGNativeMethod.writeAVTrailer(this.mRendererPointer);
    }

    protected boolean setImageFromARGB(int i2, int[] iArr, int i3, int i4, float f2, float f3) {
        return PGNativeMethod.setImageFromARGB(this.mRendererPointer, i2, iArr, i3, i4, f2, f3);
    }

    protected boolean setImageFromJPEG(int i2, byte[] bArr, float f2, float f3) {
        return PGNativeMethod.setImageFromJPEG(this.mRendererPointer, i2, bArr, f2, f3, 0);
    }

    protected boolean setImageFromPath(int i2, String str, float f2, float f3) {
        return PGNativeMethod.setImageFromPath(this.mRendererPointer, i2, str, f2, f3, 0);
    }

    protected boolean setImageFromYUV420SP(int i2, byte[] bArr, int i3, int i4, float f2, float f3) {
        return PGNativeMethod.setImageFromYUV(this.mRendererPointer, i2, bArr, i3, i4, f2, f3);
    }

    public boolean setStickerTransform(int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return PGNativeMethod.setStickerTransform(this.mRendererPointer, i2, i3, f2, f3, f4, f5, f6, f7, z);
    }

    public boolean setSupportImageFromPNG(int i2, byte[] bArr, float f2, float f3) {
        return PGNativeMethod.setSupportImageFromPNG(this.mRendererPointer, i2, bArr, f2, f3);
    }

    public boolean setSupportImageFromPNGPath(int i2, String str, float f2, float f3) {
        return PGNativeMethod.setSupportImageFromPNGPath(this.mRendererPointer, i2, str, f2, f3);
    }

    public int setVideoEndingFile(long j2, String str, Bitmap bitmap) {
        return PGNativeMethod.setVideoEndingFile(this.mRendererPointer, str, bitmap);
    }

    public boolean setImageFromJPEG(int i2, byte[] bArr, int i3) {
        return PGNativeMethod.setImageFromJPEG(this.mRendererPointer, i2, bArr, 0.0f, 1.0f, i3);
    }

    public boolean setImageFromPath(int i2, String str, int i3) {
        return PGNativeMethod.setImageFromPath(this.mRendererPointer, i2, str, 0.0f, 1.0f, i3);
    }

    public boolean setStickerTransform(int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7) {
        return PGNativeMethod.setStickerTransform(this.mRendererPointer, i2, i3, f2, f3, f4, f5, f6, f7);
    }

    public int setVideoEndingFile(String str, byte[] bArr, int i2, int i3) {
        return PGNativeMethod.setVideoEndingFile(this.mRendererPointer, str, bArr, i2, i3);
    }

    protected boolean setImageFromJPEG(int i2, byte[] bArr, float f2, float f3, int i3) {
        return PGNativeMethod.setImageFromJPEG(this.mRendererPointer, i2, bArr, f2, f3, i3);
    }

    protected boolean setImageFromPath(int i2, String str, float f2, float f3, int i3) {
        return PGNativeMethod.setImageFromPath(this.mRendererPointer, i2, str, f2, f3, i3);
    }

    protected byte[] getMakedImagePreview(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return PGNativeMethod.getMakedImagePreviewJpeg(this.mRendererPointer, i2, i3, i4, i5, i6, i7, i8);
    }
}
