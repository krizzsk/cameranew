package com.hw.videoprocessor.g;

import android.media.AudioRecord;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import us.pinguo.paylibcenter.bean.PayResult;
/* compiled from: PcmToWavUtil.java */
/* loaded from: classes2.dex */
public class f {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f5286d;

    /* renamed from: e  reason: collision with root package name */
    private int f5287e;

    public f(int i2, int i3, int i4, int i5) {
        this.b = PayResult.PAY_RESULT_ALIPAY_CHECK_IN;
        this.c = 12;
        this.f5286d = 2;
        this.f5287e = 2;
        this.b = i2;
        this.c = i3;
        this.f5286d = i4;
        this.f5287e = i5;
        this.a = AudioRecord.getMinBufferSize(i2, i3, i5);
    }

    private void b(FileOutputStream fileOutputStream, long j2, long j3, long j4, int i2, long j5) throws IOException {
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i2, 0, (byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255), (byte) (j5 & 255), (byte) ((j5 >> 8) & 255), (byte) ((j5 >> 16) & 255), (byte) ((j5 >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (j2 & 255), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255)}, 0, 44);
    }

    public void a(String str, String str2) {
        int i2 = this.b;
        long j2 = i2;
        int i3 = this.f5286d;
        long j3 = ((i2 * 16) * i3) / 8;
        byte[] bArr = new byte[this.a];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            long size = fileInputStream.getChannel().size();
            b(fileOutputStream, size, size + 36, j2, i3, j3);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
