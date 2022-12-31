package us.pinguo.androidsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import us.pinguo.androidsdk.PGThirdpartyHuaWeiMethod;
/* loaded from: classes3.dex */
public class PGNativeMethod {
    public static int BOUND_IN_RANGE;
    public static int BOUND_REACH_BOTTOM_EDGE;
    public static int BOUND_REACH_LEFT_EDGE;
    public static int BOUND_REACH_RIGHT_EDGE;
    public static int BOUND_REACH_TOP_EDGE;
    public static int Usage2D;
    public static int UsageSoftwareRead;
    public static int UsageSoftwareWrite;
    public static int UsageTarget;
    public static int UsageTexture;
    private static PGVideoPlayerCallback videoCallback;

    /* loaded from: classes3.dex */
    public enum DEBlendMode {
        FX_BLEND_ALPHA,
        FX_BLEND_MUL,
        FX_BLEND_AVERAGE,
        FX_BLEND_ADD,
        FX_BLEND_SUBSTRACT,
        FX_BLEND_DIFFRENCE,
        FX_BLEND_NEGATION,
        FX_BLEND_EXCUSION,
        FX_BLEND_BLENDSCREN,
        FX_BLEND_SOFTLIGHT
    }

    /* loaded from: classes3.dex */
    public enum Enum_FunnyMakeState {
        FUNNY_MAKE_STATE_PREVIEW,
        FUNNY_MAKE_STATE_SHOT
    }

    /* loaded from: classes3.dex */
    public enum Enum_HistogramType {
        HISTOGRAM_RED,
        HISTOGRAM_GREEN,
        HISTOGRAM_BLUE,
        HISTOGRAM_RGB,
        HISTOGRAM_BRIGHTNESS
    }

    /* loaded from: classes3.dex */
    public enum Enum_SourceTextureType {
        SOURCE_TEXTURE_TYPE_INPUT,
        SOURCE_TEXTURE_TYPE_OUTPUT
    }

    /* loaded from: classes3.dex */
    public enum FxColorBandMode {
        FX_BAND_GRAY,
        FX_BAND_RED,
        FX_BAND_GREEN,
        FX_BAND_BLUE
    }

    /* loaded from: classes3.dex */
    public interface PGVideoPlayerCallback {
        void playEndCallback();

        void renderNextFrameCallback();
    }

    static {
        System.loadLibrary("PinguoImageSDK");
        videoCallback = null;
        BOUND_IN_RANGE = 0;
        BOUND_REACH_LEFT_EDGE = 1;
        BOUND_REACH_TOP_EDGE = 16;
        BOUND_REACH_RIGHT_EDGE = 256;
        BOUND_REACH_BOTTOM_EDGE = 4096;
        UsageSoftwareRead = 1;
        UsageSoftwareWrite = 2;
        UsageTexture = 4;
        UsageTarget = 8;
        Usage2D = 16;
    }

    public static final native boolean CompositeSegmentVideo(long j2, String[] strArr, String str);

    public static final native boolean NV12To420P(byte[] bArr, int i2, int i3, int i4);

    public static final native boolean NV12ToNV21(byte[] bArr, int i2, int i3, int i4);

    public static final native boolean PortraitEditorAutoCleanAcne(long j2);

    public static final native boolean PortraitEditorBeautifyPupil(long j2, int i2, Bitmap bitmap, Bitmap bitmap2, int i3, int i4, int i5, int i6, boolean z);

    public static final native boolean PortraitEditorBigEye(long j2, float f2);

    public static final native void PortraitEditorClean(long j2);

    public static final native boolean PortraitEditorCleanAcne(long j2, int i2, int i3, int i4);

    public static final native boolean PortraitEditorDoubleLid(long j2, Bitmap bitmap, int[] iArr, Bitmap bitmap2, int[] iArr2, float f2);

    public static final native boolean PortraitEditorEyeBagRemoval(long j2, int i2);

    public static final native boolean PortraitEditorFoundation(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean PortraitEditorGetDetailsRect(long j2, int i2, int i3, int i4, int i5, Bitmap bitmap);

    public static final native boolean PortraitEditorGetImageToBitmap(long j2, Bitmap bitmap);

    public static final native boolean PortraitEditorGetImageToPath(long j2, String str, int i2);

    public static final native String PortraitEditorGetImageToPixelAccessor(long j2);

    public static final native boolean PortraitEditorGetImageToPngPath(long j2, String str, int i2);

    public static final native boolean PortraitEditorImproveNose(long j2, String str, int[] iArr, float f2, String str2, int[] iArr2, float f3);

    public static final native boolean PortraitEditorMakeup(long j2, PGPortraitEditorMakeupParam pGPortraitEditorMakeupParam);

    public static final native boolean PortraitEditorManualLiquify(long j2, int i2, int i3, int i4, int i5, int i6);

    public static final native boolean PortraitEditorSetImageByBitmap(long j2, Bitmap bitmap);

    public static final native boolean PortraitEditorSetImageByMakedImage(long j2);

    public static final native boolean PortraitEditorSetImageByPath(long j2, String str);

    public static final native boolean PortraitEditorSetImageByPixelAccessor(long j2, String str);

    public static final native boolean PortraitEditorSetImageByPngPath(long j2, String str);

    public static final native boolean PortraitEditorSetPoints(long j2, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int[] iArr3, PGFacialKeyPoints pGFacialKeyPoints);

    public static final native boolean PortraitEditorSetResultToGPUInput(long j2, int i2);

    public static final native boolean PortraitEditorSkinSoften(long j2, int i2);

    public static final native boolean PortraitEditorSparkingEye(long j2, int i2);

    public static final native boolean PortraitEditorThinFace(long j2, int i2, int i3);

    public static final native int SetFunnyTransform(long j2, float f2, float f3, float f4, float f5);

    public static final native boolean StrechLegs2OutputTexture(long j2, float f2, float f3, float f4);

    public static final native boolean StrechLegs2OutputTexture(long j2, float f2, float f3, float f4, int i2);

    public static final native boolean adjustCameraTexture(long j2, int i2, boolean z, int i3, float f2, float f3, float f4, float f5, boolean z2, boolean z3, int i4, boolean z4);

    public static final native boolean adjustImage(long j2, int i2, boolean z, int i3, float f2, float f3, float f4, float f5, boolean z2, boolean z3, int i4, boolean z4);

    public static final native int[] adjustImageMIX(long j2, int i2, float f2, boolean z);

    public static final native int applyFFmepgCommandLine(String str);

    public static final native void assignTextureIdAfterImgPrepared(long j2, long j3, int i2, int i3);

    public static final native boolean avTranscode(String str, String str2);

    public static final native boolean backwardMosaicStep(long j2);

    public static final native boolean beginVideoPlay(long j2);

    public static final native boolean burstInit(long j2, int i2, int i3, int i4);

    public static final native boolean burstRelease(long j2);

    public static final native boolean burstTake(long j2, byte[] bArr, String str);

    public static final native void changeSSParamValue(long j2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2);

    public static final native void cleanFaceAnceFromBitmap(long j2, Bitmap bitmap);

    public static final native void cleanMosaicImage(long j2);

    public static final native void clearFaceAnce(long j2, String str, String str2, int i2);

    public static final native boolean clearImage(long j2, int i2);

    public static final native boolean clearOutputImage(long j2);

    public static final native void combineHuaWeiJpegToFile(byte[] bArr, byte[] bArr2, byte[] bArr3, String str);

    public static final native boolean compositeAVFiles(long j2, String str, String str2, String str3);

    public static final native boolean configAVOutput(long j2, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static final native boolean configSticker(long j2, String[] strArr);

    public static final native boolean configStickerOtherAttribute(long j2, String str);

    public static final native long createAndroidSDK(String str, Context context, byte[] bArr);

    public static final native long createEGLDisplay();

    public static final native int createExternalOESTexture();

    public static final native long createFaceMakeUp();

    public static final native long createMakeupRender(long j2);

    public static final native long createSSInstance();

    public static final native void deletePixelAccessor(long j2, String str);

    public static final native void demoFunction(long j2);

    public static final native boolean destoryArRenderer();

    public static final native void destorySSInstance(long j2);

    public static final native void destroyAndroidSDK(long j2);

    public static final native void destroyCpuSkinSoftenEngine(long j2);

    public static final native void destroyDoubleExposureSDK(long j2);

    public static final native void destroyEGLDisplay(long j2);

    public static final native void destroyExternalOESTexture(int i2);

    public static final native void destroyMakeUp(long j2);

    public static final native void destroyMakeupRender(long j2);

    public static final native boolean detectArFeatrue(byte[] bArr, int i2, int i3);

    public static final native void displayAr();

    public static final native void drawFaceMakeUp(long j2, String str, String str2, int i2);

    public static final native void drawFaceMakeUpFromBitmap(long j2, Bitmap bitmap);

    public static final native void drawFaceMakeUpWithClearAnce(long j2, String str, String str2, int i2);

    public static final native boolean drawMosaicAtPoints(long j2, int[] iArr, int i2);

    public static final native boolean drawMosaicStart(long j2);

    public static final native boolean drawMosaicStop(long j2);

    public static final native byte[] effectImgStrengthAdjust(String str, String str2, int i2);

    public static final native int faceFeatureValid(float[] fArr);

    public static final native boolean faceRectStablizer(int[] iArr);

    public static final native boolean forwardMosaicStep(long j2);

    public static final native boolean funnyMake(long j2, int i2);

    public static final native double[] genDisortCorrectMatrix(long j2, int i2, int i3, float f2, float f3, float f4, float f5, float f6);

    public static final native byte[] generateNoiseBigFrame2JPEG(byte[] bArr, int i2, int i3);

    public static final native byte[] generateNoiseFrame2JPEG(int i2, int i3, int i4, boolean z);

    public static final native double getArDisplayPos();

    public static final native byte[] getArJpegResult(int i2);

    public static final native PGARTrackingInfo getArTrackingFaceFeatures(byte[] bArr, int i2, int i3);

    public static final native double[] getBarrelDisortParam(long j2, int i2, int i3, int i4, float f2);

    public static final native double[] getBenchmarkSkinColor(long j2, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static final native double[] getBenchmarkSkinColorJpeg(long j2, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static final native byte[] getCpuSkinSoftenSpotMask(long j2, long j3, long j4);

    public static final native int getCurrentStepNum(long j2);

    public static final native boolean getDetailsRect(long j2, int i2, int i3, int i4, int i5, Bitmap bitmap);

    public static final native int getFunnyBGLayerEffectsNum(long j2);

    public static final native int[] getFunnyBGLayerRect(long j2);

    public static final native int getFunnyFGLayerEffectsNum(long j2);

    public static final native int[] getFunnyFGlayerRect(long j2);

    public static final native int getFunnyNeededShotImageCount(long j2);

    public static final native int getFunnyTemplateHeight(long j2);

    public static final native int getFunnyTemplateWidth(long j2);

    public static final native int getFunnyTransformLayerNum(long j2);

    public static final native int[] getHighlightHistogramEqualizationTable(Bitmap bitmap);

    public static final native int[] getInputTextureInfo(long j2, int i2);

    public static final native int getInputVideoTotalFrames(long j2);

    public static final native boolean getMakedImage2Bitmap(long j2, Bitmap bitmap);

    public static final native boolean getMakedImage2Bitmap(long j2, Bitmap bitmap, int i2);

    public static final native int[] getMakedImage2Buffer(long j2);

    public static final native int[] getMakedImage2Buffer(long j2, int i2, int i3);

    public static final native int getMakedImage2BufferHeight(long j2);

    public static final native int getMakedImage2BufferWidth(long j2);

    public static final native boolean getMakedImage2IntArray(long j2, int[] iArr);

    public static final native byte[] getMakedImage2Jpeg(long j2, int i2);

    public static final native boolean getMakedImage2JpegFile(long j2, String str, int i2);

    public static final native boolean getMakedImage2JpegFileEx(long j2, String str, int i2, boolean z);

    public static final native String getMakedImage2PixelsAccessor(long j2);

    public static final native boolean getMakedImage2PngFile(long j2, String str, boolean z);

    public static final native boolean getMakedImage2Screen(long j2, int i2, int i3, int i4, int i5, int i6);

    public static final native boolean getMakedImage2Screen(long j2, int i2, int i3, int i4, int i5, int i6, boolean z);

    public static final native boolean getMakedImage2Texture(long j2, int i2, int i3, int i4, int i5);

    public static final native int[] getMakedImagePreview(long j2, int i2, int i3, int i4, int i5, int i6, int i7);

    public static final native int[] getMakedImagePreview(long j2, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    public static final native int getMakedImagePreviewHeight(long j2);

    public static final native byte[] getMakedImagePreviewJpeg(long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static final native int getMakedImagePreviewWidth(long j2);

    public static final native int[] getMakedImageRGBA(long j2);

    public static final native int getMakedImageTextureID(long j2);

    public static final native int getMosaicImageHeight(long j2);

    public static final native int getMosaicImageWidth(long j2);

    public static final native byte[] getMosaicResult(long j2);

    public static final native String getMosaicResultToPixelAccessor(long j2);

    public static final native String getPortraitParams(long j2, int[] iArr, float f2, float f3, float f4, int i2, int i3, boolean z, int i4);

    public static final native byte[] getPreviewMakedImage2JPEG(long j2, int i2, boolean z, int i3, int i4, int i5);

    public static final native boolean getPreviewMakedImage2VideoFile(long j2, float f2, int i2, boolean z, int i3, int i4);

    public static final native boolean getPreviewMakedImage2YUV444Array(long j2, int i2, boolean z, int i3, int i4, int[] iArr);

    public static final native int[] getSSPixels(long j2);

    public static final native float getSkinAverageBrightness(long j2, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static final native float[] getSplitToneCurveSlope(int i2, int i3, int i4, int i5, int i6);

    public static final native double[] getStickerCurrentDisplayPos(long j2);

    public static final native int getSupportLength(long j2);

    public static final native float getTemplateDuration(long j2);

    public static final native int getTemplateHeight(long j2);

    public static final native boolean getTemplateLoadResult(long j2);

    public static final native int getTemplateWidth(long j2);

    public static final native float getVideoDuration(long j2);

    public static final native boolean getVideoFirstFrame(long j2, String str);

    public static final native float getVideoFrameRate(long j2);

    public static final native int getVideoHeight(long j2);

    public static final native int getVideoWidth(long j2);

    public static final native boolean initArRenderer();

    public static final native boolean initBindEGLImage(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean initBindEGLImage(long j2, String str, int i2, int i3, int i4, int i5);

    public static final native boolean initCpuSkinSoftenEngine(long j2, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, PGFacialKeyPoints pGFacialKeyPoints, byte[] bArr);

    public static final native long initDoubleExposureSDK();

    public static final native void initFaceMakeUp(long j2, int[] iArr, int[] iArr2, int[] iArr3);

    public static final native boolean isSupportHighFloat(long j2);

    public static final native boolean liquifyMake(long j2, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static final native boolean loadFunnyTemplate(long j2, String str, String[] strArr, String[] strArr2);

    public static final native boolean loadResource(long j2, byte[] bArr);

    public static final native boolean loadTemplate(long j2, String str, String str2);

    public static final native byte luminance(int i2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8);

    public static final native boolean make(long j2);

    public static final native boolean make2Texture(long j2, int i2);

    public static final native boolean make2texture(long j2, int i2);

    public static final native byte[] makeArBigImage(byte[] bArr, int i2, int i3);

    public static final native void makeArImage(byte[] bArr, int i2, double d2);

    public static final native void makeArImage(byte[] bArr, byte[] bArr2, int i2, float f2);

    public static final native boolean makeMult(long j2, int i2, int i3, int i4);

    public static final native boolean makePipelineWatermark(long j2);

    public static final native boolean makeWithSize(long j2, int i2, int i3);

    public static final native byte[] makeupAutoCleanAcne(long j2, String str, float[] fArr, int i2, float f2, float f3, float f4);

    public static final native boolean makeupClearAllTextures(long j2);

    public static final native boolean makeupClearMakedTextures(long j2);

    public static final native void makeupClearParamSkinExecAutoLevel(long j2, long j3);

    public static final native void makeupClearParamSkinExecAutoLevelYUV(long j2);

    public static final native int[] makeupGetCurrentActionType(long j2);

    public static final native float[] makeupGetFacePoints(long j2);

    public static final native byte[] makeupMakeSkinPro(long j2, String str, float[] fArr, int[] iArr, int i2);

    public static final native boolean makeupNeedPreProcess(long j2, int[] iArr, boolean z);

    public static final native boolean makeupPhotoMakeRGBA(long j2);

    public static final native boolean makeupPhotoMakeTexture(long j2);

    public static final native boolean makeupPhotoSetImage(long j2, int i2, int i3, int i4);

    public static final native boolean makeupPhotoSetImage(long j2, Bitmap bitmap);

    public static final native boolean makeupPhotoSetImage(long j2, String str);

    public static final native boolean makeupPhotoSetImage(long j2, byte[] bArr, int i2, int i3);

    public static final native byte[] makeupRenderAutoCleanAcne(long j2, String str, float[] fArr, int i2, float f2, float f3, float f4);

    public static final native byte[] makeupRenderAutoCleanAcneData(long j2, byte[] bArr, float[] fArr, int i2, float f2, float f3, float f4);

    public static final native void makeupRenderDisableAutoLevelCalc(long j2, long j3);

    public static final native void makeupRenderDisableAutoLevelCalcYUV(long j2);

    public static final native void makeupRenderExecAutoLevelCalc(long j2, long j3, int i2);

    public static final native void makeupRenderExecAutoLevelCalcYUV(long j2, long j3, int i2);

    public static final native boolean makeupRenderMake(long j2);

    public static final native byte[] makeupRenderMakeSkinPro(long j2, String str, float[] fArr, int i2, int i3, int i4, int i5, int i6);

    public static final native void makeupRenderSetBlushMaskColor(long j2, byte[] bArr, int i2);

    public static final native void makeupRenderSetBrowPaintColor(long j2, byte[] bArr, int i2);

    public static final native void makeupRenderSetContrast(long j2, float f2);

    public static final native boolean makeupRenderSetHPSkinTypeSmoothLevel(long j2, float f2);

    public static final native void makeupRenderSetLightness(long j2, float f2);

    public static final native void makeupRenderSetLipsPaintColor(long j2, byte[] bArr, int i2);

    public static final native void makeupRenderSetMUIntensity(long j2, int i2, float f2);

    public static final native void makeupRenderSetMaterial(long j2, int i2, Bitmap bitmap, int i3, float f2, float f3, int i4);

    public static final native void makeupRenderSetMeshGridSize(long j2, float f2);

    public static final native void makeupRenderSetSaturation(long j2, float f2);

    public static final native void makeupRenderSetSharpeness(long j2, float f2);

    public static final native void makeupRenderSetSkinColorLut(long j2, Bitmap bitmap);

    public static final native void makeupRenderSetSkinColorStrength(long j2, float f2);

    public static final native boolean makeupRenderSetSkinParam(long j2, float f2, int i2);

    public static final native boolean makeupRenderSetSkinSoftTypeWhiteLevel(long j2, float f2);

    public static final native void makeupRenderSetSkinStrength(long j2, float f2);

    public static final native boolean makeupRenderSetSkinType(long j2, int i2);

    public static final native void makeupRenderSetTemperature(long j2, float f2);

    public static final native void makeupRenderSetupBigEye(long j2, float f2);

    public static final native void makeupRenderSetupChinStretch(long j2, float f2);

    public static final native void makeupRenderSetupEyeHStretch(long j2, float f2);

    public static final native void makeupRenderSetupEyeMoveLR(long j2, float f2);

    public static final native void makeupRenderSetupEyeRotate(long j2, float f2);

    public static final native void makeupRenderSetupEyeVStretch(long j2, float f2);

    public static final native void makeupRenderSetupFacesPoints(long j2, float[] fArr);

    public static final native void makeupRenderSetupHeadStretch(long j2, float f2);

    public static final native void makeupRenderSetupMouth(long j2, float f2);

    public static final native void makeupRenderSetupSkinProEnable(long j2, boolean z);

    public static final native void makeupRenderSetupSmallFace(long j2, float f2);

    public static final native void makeupRenderSetupThinFace(long j2, float f2);

    public static final native void makeupRenderSetupThinNose(long j2, float f2);

    public static final native void makeupRenderSetupVFace(long j2, float f2);

    public static final native void makeupSdkDestroy(long j2);

    public static final native long makeupSdkInit();

    public static final native void makeupSetDebugEnable(long j2, boolean z);

    public static final native void makeupSetDebugFacePointType(long j2, int i2);

    public static final native boolean makeupSetFacePoints(long j2, float[] fArr);

    public static final native boolean makeupSetMaterialBrowPaint(long j2, Bitmap bitmap, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialBrowPaint(long j2, String str, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialBrowPaint(long j2, String str, AssetManager assetManager, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialDefect(long j2, Bitmap bitmap);

    public static final native boolean makeupSetMaterialDefect(long j2, String str);

    public static final native boolean makeupSetMaterialDefect(long j2, String str, AssetManager assetManager);

    public static final native boolean makeupSetMaterialEyeLash(long j2, Bitmap bitmap, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeLash(long j2, String str, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeLash(long j2, String str, AssetManager assetManager, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeLine(long j2, Bitmap bitmap, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeLine(long j2, String str, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeLine(long j2, String str, AssetManager assetManager, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyePup(long j2, Bitmap bitmap, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyePup(long j2, String str, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyePup(long j2, String str, AssetManager assetManager, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeShadow(long j2, Bitmap bitmap, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeShadow(long j2, String str, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialEyeShadow(long j2, String str, AssetManager assetManager, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialFaceBlush(long j2, Bitmap bitmap);

    public static final native boolean makeupSetMaterialFaceBlush(long j2, String str);

    public static final native boolean makeupSetMaterialFaceBlush(long j2, String str, AssetManager assetManager);

    public static final native boolean makeupSetMaterialFaceShadow(long j2, Bitmap bitmap);

    public static final native boolean makeupSetMaterialFaceShadow(long j2, String str);

    public static final native boolean makeupSetMaterialFaceShadow(long j2, String str, AssetManager assetManager);

    public static final native boolean makeupSetMaterialMouthLipsHL(long j2, Bitmap bitmap, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialMouthLipsHL(long j2, String str, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialMouthLipsHL(long j2, String str, AssetManager assetManager, int i2, float f2, float f3);

    public static final native boolean makeupSetMaterialMouthToothWhiten(long j2, Bitmap bitmap);

    public static final native boolean makeupSetMaterialMouthToothWhiten(long j2, String str);

    public static final native boolean makeupSetMaterialMouthToothWhiten(long j2, String str, AssetManager assetManager);

    public static final native boolean makeupSetMaterialSkinColor(long j2, Bitmap bitmap);

    public static final native boolean makeupSetMaterialSkinColor(long j2, String str);

    public static final native boolean makeupSetMaterialSkinColor(long j2, String str, AssetManager assetManager);

    public static final native boolean makeupSetParamBrowPaint(long j2, float f2, int i2, byte[] bArr);

    public static final native boolean makeupSetParamChinStretch(long j2, float f2);

    public static final native boolean makeupSetParamContrast(long j2, float f2);

    public static final native boolean makeupSetParamCrowFeetRemove(long j2, float f2);

    public static final native boolean makeupSetParamDarkCirclesRemove(long j2, float f2);

    public static final native boolean makeupSetParamEyeBrighten(long j2, float f2);

    public static final native boolean makeupSetParamEyeEnlarge(long j2, float f2);

    public static final native boolean makeupSetParamEyeLash(long j2, float f2, int i2);

    public static final native boolean makeupSetParamEyeLine(long j2, float f2, int i2);

    public static final native boolean makeupSetParamEyeMoveLR(long j2, float f2);

    public static final native boolean makeupSetParamEyePup(long j2, float f2, int i2);

    public static final native boolean makeupSetParamEyeRotate(long j2, float f2);

    public static final native boolean makeupSetParamEyeShadow(long j2, float f2, int i2);

    public static final native boolean makeupSetParamEyeStretchLR(long j2, float f2);

    public static final native boolean makeupSetParamEyeStretchUD(long j2, float f2);

    public static final native boolean makeupSetParamFaceBlush(long j2, float f2, int i2, byte[] bArr, int i3);

    public static final native boolean makeupSetParamFaceShadow(long j2, float f2, int i2);

    public static final native boolean makeupSetParamFaceSmall(long j2, float f2);

    public static final native boolean makeupSetParamFaceThin(long j2, float f2);

    public static final native boolean makeupSetParamFaceVShape(long j2, float f2);

    public static final native boolean makeupSetParamHeadStretch(long j2, float f2);

    public static final native boolean makeupSetParamLightness(long j2, float f2);

    public static final native boolean makeupSetParamMouthLipsHL(long j2, float f2, int i2);

    public static final native boolean makeupSetParamMouthLipsPaint(long j2, float f2, int i2, byte[] bArr, int i3);

    public static final native boolean makeupSetParamMouthStretch(long j2, float f2);

    public static final native boolean makeupSetParamMouthToothWhiten(long j2, float f2);

    public static final native boolean makeupSetParamNoseThin(long j2, float f2);

    public static final native boolean makeupSetParamSaturation(long j2, float f2);

    public static final native boolean makeupSetParamSharpen(long j2, float f2);

    public static final native boolean makeupSetParamSkinColor(long j2, float f2);

    public static final native boolean makeupSetParamSkinExecAutoLevel(long j2, long j3);

    public static final native boolean makeupSetParamSkinExecAutoLevelYUV(long j2, long j3);

    public static final native boolean makeupSetParamSkinScale(long j2, float f2, int i2);

    public static final native boolean makeupSetParamSkinSmoothLevel(long j2, float f2);

    public static final native boolean makeupSetParamSkinStrength(long j2, float f2);

    public static final native boolean makeupSetParamSkinType(long j2, int i2);

    public static final native boolean makeupSetParamSkinWhiteLevel(long j2, float f2);

    public static final native boolean makeupSetParamSmileLinesRemove(long j2, float f2);

    public static final native boolean makeupSetParamTemperature(long j2, float f2);

    public static final native boolean makeupStreamMake(long j2);

    public static final native boolean makeupStreamSetImage(long j2, int i2, int i3, int i4);

    public static final native boolean mixAudio2File(long j2, String str, String str2, String str3);

    public static final native void pauseDisplayAr();

    public static final native boolean pauseVideoPlay(long j2);

    public static final native void processSSImage(long j2);

    public static final native boolean readEGLImage(long j2, int i2, int i3, int i4, byte[] bArr);

    public static final native void readEGLImage2NV12(long j2, int i2, int i3, byte[] bArr, boolean z);

    public static final native void readEGLImage2NV12ForVideoSDK(long j2, int i2, int i3, byte[] bArr, boolean z);

    public static final native void releaseMakeUpAction(long j2);

    public static final native void renderAr2View();

    public static final native boolean renderEndingFrame(long j2, int i2);

    public static final native void renderNextFrame2View(long j2);

    public static void renderNextFrameCallback() {
        PGVideoPlayerCallback pGVideoPlayerCallback = videoCallback;
        if (pGVideoPlayerCallback != null) {
            pGVideoPlayerCallback.renderNextFrameCallback();
        }
    }

    public static final native boolean renderPreviewWaterMark(long j2, boolean z, int i2, int i3);

    public static final native void renderSSToSurfaceView(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean renderType(long j2, int i2);

    public static final native boolean resumeVideoPlay(long j2);

    public static final native boolean rotatingJpegAndSave(long j2, String str, String str2, float f2);

    public static final native boolean runCpuSkinSoftenEngine(long j2, int i2, int i3);

    public static final native boolean saveMosaicImageToStepList(long j2);

    public static final native boolean saveMosaicResult(long j2, String str, int i2);

    public static final native boolean saveMosaicResultAsPNG(long j2, String str, int i2);

    public static final native boolean savePixelAccessorAsJpeg(long j2, String str, String str2, int i2);

    public static final native boolean saveSSResultJpeg(long j2, String str, int i2);

    public static final native boolean saveSSResultPNG(long j2, String str, int i2);

    public static final native byte[] scaleImageBiCubic(String str, int i2, int i3, int i4);

    public static final native boolean scaleImageCPU(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5);

    public static final native boolean scaleImageLinearCPU(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5);

    public static final native boolean setArBgMusicFile(String str);

    public static final native boolean setArDetectConfiFile(String str);

    public static final native boolean setArFaceFeatures(byte[] bArr, int i2, int i3, int[] iArr, int[] iArr2, String str, String str2, String str3);

    public static final native boolean setArFlvFile(String str);

    public static final native boolean setArSignatureFile(String str);

    public static final native boolean setArSignatureFileJPG(String str);

    public static final native boolean setArSufaceSize(int i2, int i3, int i4, int i5, int i6);

    public static final native void setArTrackingRectangle(int[] iArr);

    public static final native void setArYuvFrameData(byte[] bArr, int i2, int i3);

    public static final native boolean setAutoClearShaderCache(long j2, boolean z);

    public static final native void setBackground(long j2, float f2, float f3, float f4, float f5);

    public static final native boolean setBrushThickness(long j2, int i2);

    public static final native void setCleanColor(long j2);

    public static final native void setCpuSkinSoftenEngineParam(long j2, int i2, float f2, int i3, int i4, float f3, float f4, int i5, float f5, int i6, int i7, float f6, float f7, float f8, boolean z);

    public static final native boolean setEffect(long j2, String str);

    public static final native boolean setEffectParams(long j2, String str, String str2);

    public static final native void setFaceAncePosition(long j2, int i2, int i3, int i4);

    public static final native void setFaceMakeUpAction(long j2, int i2, String str, int[] iArr);

    public static final native void setFaceMakeUpRender(long j2, long j3);

    public static final native boolean setFunnyBGLayerEffect(long j2, int i2);

    public static final native boolean setFunnyBGLayerTransform(long j2, float f2, float f3, float f4, float f5);

    public static final native boolean setFunnyFGLayerEffect(long j2, int i2);

    public static final native boolean setFunnyFGLayerTransform(long j2, float f2, float f3, float f4, float f5);

    public static final native boolean setImageFromARGB(long j2, int i2, int[] iArr, int i3, int i4, float f2, float f3);

    public static final native boolean setImageFromBitmap(long j2, int i2, Bitmap bitmap, float f2, float f3);

    public static final native boolean setImageFromJPEG(long j2, int i2, byte[] bArr, float f2, float f3, int i3);

    public static final native boolean setImageFromPath(long j2, int i2, String str, float f2, float f3, int i3);

    public static final native boolean setImageFromPath(long j2, int i2, String str, int i3, int i4, int i5, float f2);

    public static final native boolean setImageFromRGBA(long j2, int i2, byte[] bArr, int i3, int i4, float f2, float f3);

    public static final native boolean setImageFromSimple2D(long j2, int i2, int i3, int i4, int i5, boolean z);

    public static final native boolean setImageFromTexture(long j2, int i2, int i3, int i4, int i5, boolean z);

    public static final native boolean setImageFromYUV(long j2, int i2, byte[] bArr, int i3, int i4, float f2, float f3);

    public static final native boolean setInputVideoCutRect(long j2, float f2, float f3, float f4, float f5);

    public static final native boolean setInputVideoRotation(long j2, int i2, boolean z, boolean z2);

    public static final native boolean setMaxMosaicStep(long j2, int i2);

    public static final native boolean setMosaicImage(long j2, String str);

    public static final native boolean setMosaicImageByBitmap(long j2, Bitmap bitmap);

    public static final native boolean setMosaicImageByPNG(long j2, String str);

    public static final native boolean setMosaicImageByPixelAccessor(long j2, String str);

    public static final native boolean setMosaicType(long j2, int i2, String[] strArr, AssetManager assetManager);

    public static final native boolean setOuputVideoRotation(long j2, int i2);

    public static final native boolean setPipelineWatermarkImageBitmap(long j2, Bitmap bitmap);

    public static final native boolean setPipelineWatermarkImagePos(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean setPreviewWaterMark(long j2, Bitmap bitmap, boolean z, float f2, float f3);

    public static final native boolean setResultImageToInput(long j2, int i2);

    public static final native boolean setSSCanvasBg(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean setSSImageBitmap(long j2, Bitmap bitmap, int i2, int i3);

    public static final native boolean setSSImageJpeg(long j2, String str, int i2, int i3);

    public static final native boolean setSSImagePng(long j2, String str, int i2, int i3);

    public static final native boolean setSSNeedWatermark(long j2, boolean z);

    public static final native boolean setSSWatermarkImageBitmap(long j2, Bitmap bitmap);

    public static final native boolean setSSWatermarkImagePos(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean setStickerMaxDecodeFrames(long j2, int i2);

    public static final native boolean setStickerTransform(long j2, int i2, float f2, float f3, float f4, float f5, float f6, float f7);

    public static final native boolean setStickerTransform(long j2, int i2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z);

    public static final native boolean setStickerTransform(long j2, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7);

    public static final native boolean setStickerTransform(long j2, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, boolean z);

    public static final native boolean setStickerTransformWidthAlpha(long j2, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    public static final native boolean setSupportImageFromPNG(long j2, int i2, byte[] bArr, float f2, float f3);

    public static final native boolean setSupportImageFromPNGPath(long j2, int i2, String str, float f2, float f3);

    public static final native boolean setSurfaceAndOutputVideoSize(long j2, int i2, int i3, int i4, int i5);

    public static final native boolean setTemplateDuration(long j2, float f2);

    public static final native int setVideoEndingFile(long j2, String str, Bitmap bitmap);

    public static final native int setVideoEndingFile(long j2, String str, byte[] bArr, int i2, int i3);

    public static final native boolean setVideoEndingFile(long j2, String str);

    public static final native boolean setVideoLayerEffect(long j2, int i2, String str);

    public static void setVideoSDKCallback(PGVideoPlayerCallback pGVideoPlayerCallback) {
        videoCallback = pGVideoPlayerCallback;
    }

    public static final native boolean setVideoStickerBeginPos(long j2, int i2);

    public static final native boolean setVideoTemplateAssets(long j2, String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, float[][] fArr, String[] strArr3);

    public static final native boolean setVideoWaterMark(long j2, String str);

    public static final native PGThirdpartyHuaWeiMethod.PGThirdpartyHuaWeiStruct spliteHuaWeiJpegFromBuffer(byte[] bArr);

    public static final native PGThirdpartyHuaWeiMethod.PGThirdpartyHuaWeiStruct spliteHuaWeiJpegFromFile(String str);

    public static final native int spotDetectedForUnity(int i2, int i3, int i4, float f2, int i5);

    public static final native double[] statisticsHistogram(Bitmap bitmap, int i2);

    public static final native double[] statisticsHistogram(int[] iArr, int i2, int i3, int i4);

    public static final native boolean stickerPreviewFrameAdjust(long j2, int i2, int i3, boolean z, boolean z2);

    public static final native boolean stickerPreviewFrameReset(long j2);

    public static final native void stopDisplayAr();

    public static final native boolean stopVideoPlay(long j2);

    public static final native void syncExecCommand(long j2, boolean z);

    public static final native PGARTrackingInfo trackingArFeature(byte[] bArr, int i2, int i3, int i4);

    public static final native void turnOnSticker(long j2, boolean z);

    public static final native boolean updatePreviewImageWithSize(long j2, Bitmap bitmap);

    public static void videoPlayEndCallback() {
        PGVideoPlayerCallback pGVideoPlayerCallback = videoCallback;
        if (pGVideoPlayerCallback != null) {
            pGVideoPlayerCallback.playEndCallback();
        }
    }

    public static final native boolean writeAVFrame(long j2, int i2);

    public static final native boolean writeAVFrame(long j2, byte[] bArr, float f2, int i2, int i3, int i4, boolean z, boolean z2);

    public static final native boolean writeAVFrameRGB(long j2, int[] iArr, float f2, int i2, int i3, int i4, boolean z, boolean z2);

    public static final native boolean writeAVFrameYUV444(long j2, int[] iArr, float f2, int i2, int i3);

    public static final native boolean writeAVHeader(long j2);

    public static final native boolean writeAVTrailer(long j2);

    public static final native boolean writePcmFrame(long j2, byte[] bArr, float f2);

    public static final native boolean writePcmFrame(long j2, short[] sArr, float f2);

    public final native byte[] getClarityMask(Bitmap bitmap);

    public final native byte[] getClarityMask(byte[] bArr);

    public final native boolean rgba2YUV420SpCPU(int i2, int i3, byte[] bArr, byte[] bArr2);
}
