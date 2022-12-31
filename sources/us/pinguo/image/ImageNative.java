package us.pinguo.image;

import java.io.IOException;
/* loaded from: classes4.dex */
public final class ImageNative {
    public static final int ABI_TYPE_ARM64_V8A = 2;
    public static final int ABI_TYPE_ARMEABI_V7A = 1;
    public static final int ABI_TYPE_X86 = 3;
    public static final int ABI_TYPE_X86_64 = 4;
    private static int abiType = -1;
    private static final byte[] sLock = new byte[0];

    static {
        System.loadLibrary("image-native");
    }

    public static String abiName() {
        int abiType2 = abiType();
        return abiType2 != 2 ? abiType2 != 3 ? abiType2 != 4 ? "armeabi-v7a" : "x86-64" : "x86" : "arm64-v8a";
    }

    public static int abiType() {
        if (abiType == -1) {
            synchronized (sLock) {
                if (abiType == -1) {
                    abiType = getAbiType();
                }
            }
        }
        return abiType;
    }

    public static native int analyzeLightFromGray(byte[] bArr, int i2, int i3, int i4);

    public static native int analyzeLightFromJpeg(byte[] bArr, int i2);

    public static native int analyzeLightFromYuv(byte[] bArr, int i2, int i3, int i4);

    public static native boolean cropCImg(String str, String str2, int i2, int i3, int i4, int i5, float f2, float f3, int i6, int i7, int i8, int i9) throws IOException, OutOfMemoryError;

    public static native boolean fastCrop(String str, String str2, int i2, boolean z, float f2, int i3);

    private static native int getAbiType();

    public static native boolean scaleImg(String str, String str2, int i2, float f2, int i3);

    public static native boolean spliceImgs(SpliceInfo[] spliceInfoArr, String str, int i2, int i3);
}
