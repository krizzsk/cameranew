package us.pinguo.PGEquinox;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class PGEquinoxEngine {
    private long m_pEngine = 0;

    /* loaded from: classes3.dex */
    public enum PGEquinoxProcessType {
        PGE_PROCESS_TYPE_FILTER(0),
        PGE_PROCESS_TYPE_MIX(1),
        PGE_PROCESS_TYPE_MAKEUP(2),
        PGE_PROCESS_TYPE_PORTRAITBOUNDRAYLIGHT(3),
        PGE_PROCESS_TYPE_HAIR_DRAWING(4),
        PGE_PROCESS_TYPE_REPLACE_ALPHA(5),
        PGE_PROCESS_TYPE_SHIFTED_MASK_EFFECT(6),
        PGE_PROCESS_TYPE_EXPAND_BOUNDRAY_EFFECT(7),
        PGE_PrOCESS_TYPE_ONE_KEY_BEATTIFY(8),
        PGE_PROCESS_TYPE_COLOR_SHADING(9),
        PGE_PROCESS_TYPE_HANDLE_ALPHA(10);
        
        private int index;

        PGEquinoxProcessType(int i2) {
            this.index = i2;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static native boolean ChangeCanvasSize(long j2, int i2, int i3, float f2, float f3, float f4, float f5);

    public static native boolean DeleteInputImage(long j2, int i2);

    public static native boolean DestroyPGEquinoxEngine(long j2);

    public static native boolean GetMattingMask(long j2, String str, int i2);

    public static native boolean GetMattingMaskExtend(long j2, int i2, int i3);

    public static native boolean GetOutput2File(long j2, String str, int i2);

    public static native boolean GetOutputBitmap(long j2, Bitmap bitmap, int i2);

    public static native boolean ImageMattingSDK(long j2, String str, int i2, int i3);

    public static native boolean IsUseChangeCanvasSize(long j2, boolean z);

    public static native boolean MattingMaskFeather(long j2, int i2, int i3);

    public static native long NewPGEquinoxEngine(Context context, byte[] bArr);

    public static native boolean ProcessImage(long j2, int[] iArr, int i2, Object obj);

    public static native boolean SetFacePP106Point(long j2, float[] fArr);

    public static native boolean SetInputImageByBitmap(long j2, Bitmap bitmap, int i2);

    public static native boolean SetInputImageByPath(long j2, String str, int i2);

    public static native boolean SetMattingMask(long j2, String str, int i2);

    public static native boolean SetModelFiles(long j2, String str, String str2, String str3);

    public static native void SetPGEquinoxEngineAssetsManager(AssetManager assetManager);

    public static void loadLibraries(String str, String str2, String str3) {
        System.load(str2);
        System.loadLibrary("PinguoImageSDK");
        System.load(str3);
        System.load(str);
    }

    public boolean ChangeCanvasSize(int i2, int i3, float f2, float f3, float f4, float f5) {
        return ChangeCanvasSize(this.m_pEngine, i2, i3, f2, f3, f4, f5);
    }

    public boolean DeleteInputImage(int i2) {
        return DeleteInputImage(this.m_pEngine, i2);
    }

    public boolean GetMattingMask(String str, int i2) {
        return GetMattingMask(this.m_pEngine, str, i2);
    }

    public boolean GetOutput2File(String str, int i2) {
        return GetOutput2File(this.m_pEngine, str, i2);
    }

    public boolean GetOutputBitmap(Bitmap bitmap, int i2) {
        return GetOutputBitmap(this.m_pEngine, bitmap, i2);
    }

    public boolean ImageMattingSDK(String str, int i2, int i3) {
        return ImageMattingSDK(this.m_pEngine, str, i2, i3);
    }

    public boolean IsUseChangeCanvasSize(boolean z) {
        return IsUseChangeCanvasSize(this.m_pEngine, z);
    }

    public boolean MattingMaskFeather(int i2, int i3) {
        return MattingMaskFeather(this.m_pEngine, i2, i3);
    }

    public boolean PGEquinoxDestroy() {
        return DestroyPGEquinoxEngine(this.m_pEngine);
    }

    public boolean PGEquinoxInitialise(Context context, byte[] bArr) {
        try {
            long NewPGEquinoxEngine = NewPGEquinoxEngine(context, bArr);
            this.m_pEngine = NewPGEquinoxEngine;
            return NewPGEquinoxEngine != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean ProcessImage(int[] iArr, int i2, PGEquinoxProcessParam pGEquinoxProcessParam) {
        return ProcessImage(this.m_pEngine, iArr, i2, pGEquinoxProcessParam);
    }

    public void SetAssetsManager(AssetManager assetManager) {
        SetPGEquinoxEngineAssetsManager(assetManager);
    }

    public boolean SetFacePP106Point(float[] fArr) {
        return SetFacePP106Point(this.m_pEngine, fArr);
    }

    public boolean SetInputImageByBitmap(Bitmap bitmap, int i2) {
        return SetInputImageByBitmap(this.m_pEngine, bitmap, i2);
    }

    public boolean SetInputImageByPath(String str, int i2) {
        return SetInputImageByPath(this.m_pEngine, str, i2);
    }

    public boolean SetMattingMask(String str, int i2) {
        return SetMattingMask(this.m_pEngine, str, i2);
    }

    public boolean SetModelFiles(String str, String str2, String str3) {
        return SetModelFiles(this.m_pEngine, str, str2, str3);
    }

    public boolean GetMattingMask(int i2, int i3) {
        return GetMattingMaskExtend(this.m_pEngine, i2, i3);
    }
}
