package us.pinguo.advconfigdata.Utils;

import android.media.ExifInterface;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class AdvBitmapExif {
    private static final int BUFFER_SIZE = 8192;
    private static final int M_SOI = 65496;
    private static final String TAG = "Exif";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private int a;
        private int b;

        private b() {
        }
    }

    public static byte[] exifToJpegData(byte[] bArr, byte[] bArr2) {
        int i2;
        if (!isJpeg(bArr)) {
            StringBuilder sb = new StringBuilder();
            sb.append("jpeg data 数据不正确,");
            sb.append(bArr == null ? "jpeg is null!" : String.valueOf(bArr.length));
            throw new IllegalArgumentException(sb.toString());
        }
        int length = bArr.length;
        int i3 = 2;
        int i4 = 2;
        while (i3 + 2 < length) {
            int i5 = i3 + 1;
            if ((bArr[i3] & Draft_75.END_OF_FRAME) == 255) {
                int i6 = bArr[i5] & Draft_75.END_OF_FRAME;
                if (i6 != 255) {
                    if (i6 == 216 || i6 == 217 || i6 < 192 || i6 >= 255) {
                        break;
                    }
                    int i7 = i5 + 1;
                    int pack = pack(bArr, i7, 2, false);
                    if (pack < 2 || (i2 = i7 + pack) > length) {
                        AdvLog.Log("Invalid length");
                        return bArr;
                    } else if (i6 == 225) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr2.length + bArr.length);
                        byteArrayOutputStream.write(bArr, 0, i7 - 2);
                        byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                        byteArrayOutputStream.write(bArr, i2, (bArr.length - i7) - pack);
                        return byteArrayOutputStream.toByteArray();
                    } else if (i6 == 225) {
                        i3 = i2;
                        i4 = i3;
                    } else {
                        i3 = i2;
                    }
                } else {
                    i3 = i5;
                }
            } else {
                break;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr2.length + bArr.length);
        byteArrayOutputStream2.write(bArr, 0, i4);
        byteArrayOutputStream2.write(bArr2, 0, bArr2.length);
        byteArrayOutputStream2.write(bArr, i4, bArr.length - i4);
        return byteArrayOutputStream2.toByteArray();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002c: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:16:0x002c */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void exifToJpegFile(java.lang.String r4, java.lang.String r5, byte[] r6) throws java.io.IOException {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L2e
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L2e
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L24
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L24
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L24
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L24
            exifToJpegStream(r1, r2, r6)     // Catch: java.lang.Throwable -> L21
            r2.close()     // Catch: java.lang.Throwable -> L2b
            r1.close()
            return
        L21:
            r4 = move-exception
            r0 = r2
            goto L25
        L24:
            r4 = move-exception
        L25:
            if (r0 == 0) goto L2a
            r0.close()     // Catch: java.lang.Throwable -> L2b
        L2a:
            throw r4     // Catch: java.lang.Throwable -> L2b
        L2b:
            r4 = move-exception
            r0 = r1
            goto L2f
        L2e:
            r4 = move-exception
        L2f:
            if (r0 == 0) goto L34
            r0.close()
        L34:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advconfigdata.Utils.AdvBitmapExif.exifToJpegFile(java.lang.String, java.lang.String, byte[]):void");
    }

    private static void exifToJpegStream(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        boolean z;
        long j2;
        byte[] bArr2 = new byte[8192];
        int read = inputStream.read(bArr2);
        if (read == -1) {
            return;
        }
        if (read < 8192) {
            while (true) {
                int read2 = inputStream.read(bArr2, read, 8192 - read);
                if (read2 == -1 || read >= 8192) {
                    break;
                }
                read += read2;
            }
        }
        if (marker(bArr2, 0) != M_SOI) {
            throw new IllegalArgumentException("jpeg data 数据不正确");
        }
        int i2 = 2;
        int i3 = 2;
        while (true) {
            z = true;
            if (i2 + 3 > read) {
                break;
            }
            int i4 = i2 + 1;
            if ((bArr2[i2] & Draft_75.END_OF_FRAME) != 255) {
                break;
            }
            int i5 = i4 + 1;
            int i6 = bArr2[i4] & Draft_75.END_OF_FRAME;
            if (i6 < 224 || i6 > 239) {
                break;
            } else if (i6 == 225) {
                int pack = pack(bArr2, i5, 2, false);
                outputStream.write(bArr2, 0, i5 - 2);
                outputStream.write(bArr, 0, bArr.length);
                int i7 = i5 + pack;
                if (i7 > read) {
                    j2 = i7 - read;
                } else {
                    if (i7 < read) {
                        outputStream.write(bArr2, i7, (read - pack) - i5);
                    }
                    j2 = 0;
                }
            } else {
                i2 = i5 + pack(bArr2, i5, 2, false);
                if (i6 == 224) {
                    i3 = i2;
                }
            }
        }
        j2 = 0;
        z = false;
        if (!z) {
            outputStream.write(bArr2, 0, i3);
            outputStream.write(bArr, 0, bArr.length);
            if (i3 < read) {
                outputStream.write(bArr2, i3, read - i3);
            }
        }
        if (j2 > 0) {
            int i8 = 0;
            while (true) {
                long j3 = i8;
                if (j2 <= j3) {
                    break;
                }
                i8 = (int) (j3 + inputStream.skip(j2 - j3));
            }
        }
        while (true) {
            int read3 = inputStream.read(bArr2);
            if (read3 == -1) {
                return;
            }
            outputStream.write(bArr2, 0, read3);
        }
    }

    private static byte[] getExifAppData(InputStream inputStream, int i2, int i3, int i4) throws IOException {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        byteArrayOutputStream.write(255);
        byteArrayOutputStream.write(225);
        byteArrayOutputStream.write(i2);
        byteArrayOutputStream.write(i3);
        int i5 = i4 - 2;
        byte[] bArr = new byte[8192];
        int i6 = 0;
        while (true) {
            int i7 = i5 - i6;
            if (i7 <= 0) {
                if (i6 != i5) {
                    return new byte[0];
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray.length > 65538) {
                    return new byte[0];
                }
                if (pack(byteArray, 4, 4, false) == 1165519206 && pack(byteArray, 8, 2, false) == 0) {
                    return byteArray;
                }
                return null;
            }
            if (i7 > 8192) {
                read = inputStream.read(bArr);
            } else {
                read = inputStream.read(bArr, 0, i7);
            }
            if (read < 0) {
                return new byte[0];
            }
            byteArrayOutputStream.write(bArr, 0, read);
            i6 += read;
        }
    }

    public static byte[] getExifData(byte[] bArr) {
        b exifDataFromTo = getExifDataFromTo(bArr);
        if (exifDataFromTo == null) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[exifDataFromTo.b];
        System.arraycopy(bArr, exifDataFromTo.a, bArr2, 0, exifDataFromTo.b);
        return bArr2;
    }

    private static b getExifDataFromTo(byte[] bArr) {
        int i2;
        if (isJpeg(bArr)) {
            int length = bArr.length;
            int i3 = 2;
            while (i3 + 2 < length) {
                int i4 = i3 + 1;
                if ((bArr[i3] & Draft_75.END_OF_FRAME) == 255) {
                    int i5 = bArr[i4] & Draft_75.END_OF_FRAME;
                    if (i5 != 255) {
                        if (i5 == 216 || i5 == 217 || i5 < 192 || i5 >= 255) {
                            break;
                        }
                        int i6 = i4 + 1;
                        int pack = pack(bArr, i6, 2, false);
                        if (pack >= 2 && (i2 = i6 + pack) <= length) {
                            if (i5 == 225 && pack >= 8 && pack(bArr, i6 + 2, 4, false) == 1165519206 && pack(bArr, i6 + 6, 2, false) == 0) {
                                b bVar = new b();
                                bVar.a = i6 - 2;
                                bVar.b = pack + 2;
                                return bVar;
                            }
                            i3 = i2;
                        } else {
                            AdvLog.Log("Invalid length");
                            break;
                        }
                    } else {
                        i3 = i4;
                    }
                } else {
                    break;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("jpeg data 数据不正确");
    }

    public static int getExifOrientationFlag(String str) throws IOException {
        return new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
    }

    private static int getLen(int i2, int i3) {
        return (i2 << 8) | i3;
    }

    public static int getOrientation(int i2) {
        if (i2 != 3) {
            if (i2 != 6) {
                if (i2 != 8) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return 90;
        }
        return BaseBlurEffect.ROTATION_180;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0066, code lost:
        if (r3 <= 8) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0068, code lost:
        r2 = pack(r10, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006f, code lost:
        if (r2 == 1229531648) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0074, code lost:
        if (r2 == 1296891946) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0076, code lost:
        us.pinguo.advconfigdata.Utils.AdvLog.Log("Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007b, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007c, code lost:
        if (r2 != 1229531648) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0080, code lost:
        r2 = pack(r10, r1 + 4, 4, r5) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0089, code lost:
        if (r2 < 10) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008b, code lost:
        if (r2 <= r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008e, code lost:
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = pack(r10, r1 - 2, 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0096, code lost:
        r4 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
        if (r2 <= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
        if (r3 < 12) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a4, code lost:
        if (pack(r10, r1, 2, r5) != 274) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00af, code lost:
        return getOrientation(pack(r10, r1 + 8, 2, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b0, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b6, code lost:
        us.pinguo.advconfigdata.Utils.AdvLog.Log("Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00bb, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bc, code lost:
        us.pinguo.advconfigdata.Utils.AdvLog.Log("Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getOrientation(byte[] r10) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advconfigdata.Utils.AdvBitmapExif.getOrientation(byte[]):int");
    }

    public static int getOrientationFlag(int i2) {
        int i3 = ((i2 + 45) / 90) * 90;
        if (i3 != 90) {
            if (i3 != 180) {
                return i3 != 270 ? 1 : 8;
            }
            return 3;
        }
        return 6;
    }

    public static int getPhotoOrientation(String str) {
        try {
            return getOrientation(getExifOrientationFlag(str));
        } catch (IOException e2) {
            AdvLog.Log(e2.getMessage());
            return 0;
        }
    }

    public static boolean isJpeg(byte[] bArr) {
        return bArr != null && bArr.length >= 1024 && marker(bArr, 0) == M_SOI;
    }

    protected static int marker(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & Draft_75.END_OF_FRAME) | ((bArr[i2] & Draft_75.END_OF_FRAME) << 8);
    }

    public static int pack(byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        if (z) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                return i5;
            }
            i5 = (bArr[i2] & Draft_75.END_OF_FRAME) | (i5 << 8);
            i2 += i4;
            i3 = i6;
        }
    }

    private static boolean skip(InputStream inputStream, long j2) throws IOException {
        if (j2 <= 0) {
            return false;
        }
        long j3 = 0;
        while (true) {
            long j4 = j2 - j3;
            if (j4 <= 0) {
                return j3 == j2;
            }
            long skip = inputStream.skip(j4);
            if (skip <= 0) {
                return false;
            }
            j3 += skip;
        }
    }

    public static byte[] unpack(int i2, int i3, boolean z) {
        byte[] bArr = new byte[i3];
        if (z) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i4] = (byte) (i2 & 255);
                i2 >>= 8;
            }
        } else {
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                bArr[i5] = (byte) (i2 & 255);
                i2 >>= 8;
            }
        }
        return bArr;
    }

    public static byte[] getExifData(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (bufferedInputStream.read() != 255) {
                byte[] bArr = new byte[0];
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return bArr;
            } else if (bufferedInputStream.read() != 216) {
                byte[] bArr2 = new byte[0];
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } else {
                while (bufferedInputStream.read() == 255) {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byte[] bArr3 = new byte[0];
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused3) {
                        }
                        return bArr3;
                    }
                    int read2 = bufferedInputStream.read();
                    if (read2 == -1) {
                        byte[] bArr4 = new byte[0];
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                        }
                        return bArr4;
                    }
                    int read3 = bufferedInputStream.read();
                    if (read3 == -1) {
                        byte[] bArr5 = new byte[0];
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused5) {
                        }
                        return bArr5;
                    }
                    int len = getLen(read2, read3);
                    if (read == 225) {
                        byte[] exifAppData = getExifAppData(bufferedInputStream, read2, read3, len);
                        if (exifAppData != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused6) {
                            }
                            return exifAppData;
                        }
                    } else if (read < 224 && read > 239) {
                        byte[] bArr6 = new byte[0];
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused7) {
                        }
                        return bArr6;
                    } else if (!skip(bufferedInputStream, len - 2)) {
                        byte[] bArr7 = new byte[0];
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused8) {
                        }
                        return bArr7;
                    }
                }
                byte[] bArr8 = new byte[0];
                try {
                    bufferedInputStream.close();
                } catch (IOException unused9) {
                }
                return bArr8;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            byte[] bArr9 = new byte[0];
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused10) {
                }
            }
            return bArr9;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused11) {
                }
            }
            throw th;
        }
    }

    public static void unpack(byte[] bArr, int i2, int i3, int i4, boolean z) {
        if (z) {
            for (int i5 = 0; i5 < i3; i5++) {
                bArr[i4 + i5] = (byte) (i2 & 255);
                i2 >>= 8;
            }
            return;
        }
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            bArr[i4 + i6] = (byte) (i2 & 255);
            i2 >>= 8;
        }
    }
}
