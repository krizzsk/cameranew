package com.hw.videoprocessor.g;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.RandomAccessFile;
/* compiled from: AudioFadeUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(String str, int i2, int i3, float f2, float f3) throws IOException {
        float f4 = ((i2 * 16) / 8) * i3;
        int i4 = (int) (f2 * f4);
        int i5 = (int) (f4 * f3);
        byte[] bArr = new byte[i4];
        byte[] bArr2 = new byte[i5];
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.read(bArr, 0, i4);
        long j2 = i5;
        randomAccessFile.seek((int) (randomAccessFile.length() - j2));
        randomAccessFile.read(bArr2, 0, i5);
        b(bArr);
        c(bArr2);
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr, 0, i4);
        randomAccessFile.seek((int) (randomAccessFile.length() - j2));
        randomAccessFile.write(bArr2, 0, i5);
        randomAccessFile.close();
    }

    private static void b(byte[] bArr) {
        float length = 1.0f / (bArr.length / 2.0f);
        float f2 = 0.0f;
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            int i3 = i2 + 1;
            int i4 = (int) (((short) ((bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i3] & Draft_75.END_OF_FRAME) << 8))) * f2);
            if (i4 > 32767) {
                i4 = 32767;
            } else if (i4 < -32768) {
                i4 = -32768;
            }
            bArr[i2] = (byte) (i4 & 255);
            bArr[i3] = (byte) ((i4 >>> 8) & 255);
            f2 += length;
        }
    }

    private static void c(byte[] bArr) {
        float f2 = 1.0f;
        float length = 1.0f / (bArr.length / 2.0f);
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            int i3 = i2 + 1;
            int i4 = (int) (((short) ((bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i3] & Draft_75.END_OF_FRAME) << 8))) * f2);
            if (i4 > 32767) {
                i4 = 32767;
            } else if (i4 < -32768) {
                i4 = -32768;
            }
            bArr[i2] = (byte) (i4 & 255);
            bArr[i3] = (byte) ((i4 >>> 8) & 255);
            f2 -= length;
        }
    }
}
