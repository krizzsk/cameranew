package com.hw.videoprocessor.g;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Pair;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.paylibcenter.bean.PayResult;
/* compiled from: AudioUtil.java */
/* loaded from: classes2.dex */
public class b {
    private static final Map<Integer, Integer> a;
    public static int b;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(96000, 0);
        hashMap.put(88200, 1);
        hashMap.put(64000, 2);
        hashMap.put(48000, 3);
        hashMap.put(44100, 4);
        hashMap.put(32000, 5);
        hashMap.put(24000, 6);
        hashMap.put(22050, 7);
        hashMap.put(16000, 8);
        hashMap.put(12000, 9);
        hashMap.put(11025, 10);
        hashMap.put(Integer.valueOf((int) PayResult.PAY_RESULT_ALIPAY_CHECK_IN), 11);
        hashMap.put(7350, 12);
        b = 1;
    }

    public static void a(String str, String str2, @IntRange(from = 0, to = 100) int i2) throws IOException {
        if (i2 == 100) {
            e(str, str2);
            return;
        }
        float j2 = j(i2);
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        while (fileInputStream.read(bArr) != -1) {
            try {
                for (int i3 = 0; i3 < 2048; i3 += 2) {
                    int i4 = i3 + 1;
                    int i5 = (int) (((short) ((bArr[i3] & Draft_75.END_OF_FRAME) | ((bArr[i4] & Draft_75.END_OF_FRAME) << 8))) * j2);
                    if (i5 > 32767) {
                        i5 = 32767;
                    } else if (i5 < -32768) {
                        i5 = -32768;
                    }
                    bArr[i3] = (byte) (i5 & 255);
                    bArr[i4] = (byte) ((i5 >>> 8) & 255);
                }
                fileOutputStream.write(bArr);
            } finally {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static Pair<Integer, Integer> b(String str, String str2, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        int i2;
        int i3 = 1;
        int integer = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
        int integer2 = mediaFormat2.containsKey("channel-count") ? mediaFormat2.getInteger("channel-count") : 1;
        int integer3 = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 44100;
        int integer4 = mediaFormat2.containsKey("sample-rate") ? mediaFormat2.getInteger("sample-rate") : 44100;
        if (integer == integer2 && integer3 == integer4 && integer <= 2) {
            return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
        }
        File file = new File(str + ".temp");
        File file2 = new File(str2 + ".temp");
        if (integer != integer2 || integer > 2 || integer2 > 2) {
            if (integer > 1) {
                try {
                    try {
                        n(str, file.getAbsolutePath(), integer);
                        File file3 = new File(str);
                        file3.delete();
                        file.renameTo(file3);
                        i2 = 1;
                    } catch (Throwable th) {
                        file.delete();
                        file2.exists();
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    c.d(e);
                    Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                    file.delete();
                    file2.exists();
                    return pair;
                }
            } else {
                i2 = integer;
            }
            if (integer2 > 1) {
                n(str2, file2.getAbsolutePath(), integer2);
                File file4 = new File(str2);
                file4.delete();
                file2.renameTo(file4);
                integer2 = 1;
            }
            integer = i2;
        } else {
            i3 = integer;
        }
        if (integer3 != integer4) {
            try {
                int min = Math.min(integer3, integer4);
                if (integer3 != min) {
                    try {
                        k(str, file.getAbsolutePath(), integer3, min, integer);
                        File file5 = new File(str);
                        file5.delete();
                        file.renameTo(file5);
                    } catch (Exception e3) {
                        e = e3;
                        integer3 = min;
                        integer = i3;
                        c.d(e);
                        Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer3));
                        file.delete();
                        file2.exists();
                        return pair2;
                    }
                }
                if (integer4 != min) {
                    k(str2, file2.getAbsolutePath(), integer4, min, integer2);
                    File file6 = new File(str2);
                    file6.delete();
                    file2.renameTo(file6);
                }
                integer3 = min;
            } catch (Exception e4) {
                e = e4;
            }
        }
        Pair<Integer, Integer> pair3 = new Pair<>(Integer.valueOf(i3), Integer.valueOf(integer3));
        file.delete();
        file2.exists();
        return pair3;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3 A[Catch: IOException -> 0x00cf, TryCatch #7 {IOException -> 0x00cf, blocks: (B:58:0x00cb, B:62:0x00d3, B:64:0x00d8, B:66:0x00dd), top: B:74:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8 A[Catch: IOException -> 0x00cf, TryCatch #7 {IOException -> 0x00cf, blocks: (B:58:0x00cb, B:62:0x00d3, B:64:0x00d8, B:66:0x00dd), top: B:74:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd A[Catch: IOException -> 0x00cf, TRY_LEAVE, TryCatch #7 {IOException -> 0x00cf, blocks: (B:58:0x00cb, B:62:0x00d3, B:64:0x00d8, B:66:0x00dd), top: B:74:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File c(java.io.File r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.g.b.c(java.io.File, int, int):java.io.File");
    }

    public static void d(MediaFormat mediaFormat, int i2, int i3, int i4) {
        Map<Integer, Integer> map = a;
        int intValue = map.containsKey(Integer.valueOf(i3)) ? map.get(Integer.valueOf(i3)).intValue() : 4;
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i2 << 3) | (intValue >> 1)));
        allocate.put(1, (byte) (((intValue & 1) << 7) | (i4 << 3)));
        mediaFormat.setByteBuffer("csd-0", allocate);
    }

    public static void e(String str, String str2) throws IOException {
        FileChannel channel = new FileOutputStream(str2).getChannel();
        FileChannel channel2 = new FileInputStream(str).getChannel();
        channel2.transferTo(0L, channel2.size(), channel);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0134, B:46:0x015c, B:45:0x013b, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(java.lang.String r21, java.lang.String r22, java.lang.Integer r23, java.lang.Integer r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.g.b.f(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer):void");
    }

    public static int g(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey(IjkMediaMeta.IJKM_KEY_BITRATE)) {
            return mediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE);
        }
        return 192000;
    }

    public static int h(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("max-input-size")) {
            return mediaFormat.getInteger("max-input-size");
        }
        return 100000;
    }

    public static void i(String str, String str2, String str3, @IntRange(from = 0, to = 100) int i2, @IntRange(from = 0, to = 100) int i3) throws IOException {
        float j2 = j(i2);
        float j3 = j(i3);
        int i4 = 2048;
        byte[] bArr = new byte[2048];
        byte[] bArr2 = new byte[2048];
        byte[] bArr3 = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str3);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z && z2) {
                fileInputStream.close();
                fileInputStream2.close();
                fileOutputStream.close();
                return;
            }
            if (!z) {
                try {
                    z = fileInputStream.read(bArr) == -1;
                    System.arraycopy(bArr, 0, bArr3, 0, i4);
                } catch (Throwable th) {
                    fileInputStream.close();
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            }
            if (!z2) {
                z2 = fileInputStream2.read(bArr2) == -1;
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = i5 + 1;
                    int i7 = (int) ((((short) (((bArr2[i6] & Draft_75.END_OF_FRAME) << 8) | (bArr2[i5] & Draft_75.END_OF_FRAME))) * j3) + (((short) ((bArr[i5] & Draft_75.END_OF_FRAME) | ((bArr[i6] & Draft_75.END_OF_FRAME) << 8))) * j2));
                    if (i7 > 32767) {
                        i7 = 32767;
                    } else if (i7 < -32768) {
                        i7 = -32768;
                    }
                    bArr3[i5] = (byte) (i7 & 255);
                    bArr3[i6] = (byte) ((i7 >>> 8) & 255);
                    i5 += 2;
                    i4 = 2048;
                }
            }
            fileOutputStream.write(bArr3);
            i4 = 2048;
        }
    }

    private static float j(@IntRange(from = 0, to = 100) int i2) {
        return (i2 / 100.0f) * b;
    }

    public static boolean k(String str, String str2, int i2, int i3, int i4) {
        try {
            new com.hw.videoprocessor.f.b(new FileInputStream(str), new FileOutputStream(str2), i2, i3, 2, 2, i4, (int) new File(str).length(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, true);
            return true;
        } catch (IOException e2) {
            c.d(e2);
            e2.printStackTrace();
            return true;
        }
    }

    public static void l(String str, String str2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        try {
            int h2 = com.hw.videoprocessor.e.h(mediaExtractor, false);
            mediaExtractor.selectTrack(h2);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(h2);
            MediaMuxer mediaMuxer = new MediaMuxer(str2, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    mediaMuxer.stop();
                    mediaMuxer.release();
                    return;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = readSampleData;
                mediaMuxer.writeSampleData(addTrack, allocateDirect, bufferInfo);
                mediaExtractor.advance();
            }
        } finally {
            mediaExtractor.release();
        }
    }

    public static void m(String str, String str2, String str3, boolean z) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(str2);
        try {
            int h2 = com.hw.videoprocessor.e.h(mediaExtractor, false);
            int h3 = com.hw.videoprocessor.e.h(mediaExtractor2, true);
            mediaExtractor.selectTrack(h2);
            mediaExtractor2.selectTrack(h3);
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(h3);
            MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(h2);
            MediaMuxer mediaMuxer = new MediaMuxer(str3, 0);
            int addTrack = mediaMuxer.addTrack(trackFormat);
            int addTrack2 = mediaMuxer.addTrack(trackFormat2);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat2.getInteger("max-input-size"));
            long j2 = 0;
            long j3 = 0;
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    break;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = readSampleData;
                mediaMuxer.writeSampleData(addTrack2, allocateDirect, bufferInfo);
                mediaExtractor.advance();
                j3 = sampleTime;
                j2 = 0;
            }
            int integer = 1024000000 / trackFormat.getInteger("sample-rate");
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(h(trackFormat));
            long j4 = j2;
            long j5 = j4;
            while (j4 < j3) {
                mediaExtractor2.seekTo(j2, 2);
                while (true) {
                    long sampleTime2 = mediaExtractor2.getSampleTime();
                    if (sampleTime2 == -1) {
                        break;
                    }
                    j4 = sampleTime2 + j5;
                    if (j4 > j3) {
                        break;
                    }
                    int sampleFlags2 = mediaExtractor2.getSampleFlags();
                    int readSampleData2 = mediaExtractor2.readSampleData(allocateDirect2, 0);
                    bufferInfo.presentationTimeUs = j4;
                    bufferInfo.flags = sampleFlags2;
                    bufferInfo.size = readSampleData2;
                    mediaMuxer.writeSampleData(addTrack, allocateDirect2, bufferInfo);
                    mediaExtractor2.advance();
                }
                j5 = j4 + integer;
                if (!z) {
                    break;
                }
                j2 = 0;
            }
            mediaMuxer.stop();
            mediaMuxer.release();
        } finally {
            mediaExtractor.release();
            mediaExtractor2.release();
        }
    }

    public static void n(String str, String str2, @IntRange(from = 2) int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[i2 * 1024];
        byte[] bArr2 = new byte[1024];
        while (fileInputStream.read(bArr) != -1) {
            for (int i3 = 0; i3 < 1024; i3 += 2) {
                int i4 = i2 * i3;
                bArr2[i3] = bArr[i4];
                bArr2[i3 + 1] = bArr[i4 + 1];
            }
            fileOutputStream.write(bArr2);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static long o(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i2, Integer num, Integer num2, long j2, j jVar) throws IOException {
        int h2 = com.hw.videoprocessor.e.h(mediaExtractor, true);
        mediaExtractor.selectTrack(h2);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(h2);
        long j3 = trackFormat.getLong("durationUs");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j4 = j2;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime == -1) {
                break;
            } else if (sampleTime < num3.intValue()) {
                mediaExtractor.advance();
            } else if (num2 != null && sampleTime > num2.intValue()) {
                break;
            } else {
                if (jVar != null) {
                    float intValue = ((float) (sampleTime - num3.intValue())) / ((float) (num2 == null ? j3 : num2.intValue() - num3.intValue()));
                    if (intValue < 0.0f) {
                        intValue = 0.0f;
                    }
                    if (intValue > 1.0f) {
                        intValue = 1.0f;
                    }
                    jVar.onProgress(intValue);
                }
                bufferInfo.presentationTimeUs = (sampleTime - num3.intValue()) + j2;
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
                bufferInfo.size = readSampleData;
                if (readSampleData < 0) {
                    break;
                }
                c.h("writeAudioSampleData,time:" + (((float) bufferInfo.presentationTimeUs) / 1000.0f), new Object[0]);
                mediaMuxer.writeSampleData(i2, allocateDirect, bufferInfo);
                long j5 = bufferInfo.presentationTimeUs;
                mediaExtractor.advance();
                j4 = j5;
            }
        }
        return j4;
    }

    public static long p(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i2, Integer num, Integer num2, j jVar) throws IOException {
        return o(mediaExtractor, mediaMuxer, i2, num, num2, 0L, jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0430 A[Catch: all -> 0x04af, TryCatch #4 {all -> 0x04af, blocks: (B:100:0x0404, B:104:0x0430, B:105:0x044e, B:107:0x0453, B:108:0x0455, B:110:0x045e, B:114:0x047a, B:120:0x048a, B:122:0x0496, B:113:0x0470), top: B:147:0x0404 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0453 A[Catch: all -> 0x04af, TryCatch #4 {all -> 0x04af, blocks: (B:100:0x0404, B:104:0x0430, B:105:0x044e, B:107:0x0453, B:108:0x0455, B:110:0x045e, B:114:0x047a, B:120:0x048a, B:122:0x0496, B:113:0x0470), top: B:147:0x0404 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x045e A[Catch: all -> 0x04af, TryCatch #4 {all -> 0x04af, blocks: (B:100:0x0404, B:104:0x0430, B:105:0x044e, B:107:0x0453, B:108:0x0455, B:110:0x045e, B:114:0x047a, B:120:0x048a, B:122:0x0496, B:113:0x0470), top: B:147:0x0404 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:10:0x0084, B:12:0x008a, B:25:0x00b9, B:31:0x0126, B:36:0x0134, B:38:0x0150, B:39:0x0166, B:50:0x01b3, B:42:0x016f, B:44:0x0193, B:48:0x01ab, B:47:0x01a1, B:26:0x00ce, B:16:0x0098, B:18:0x00a5, B:20:0x00ac), top: B:145:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:10:0x0084, B:12:0x008a, B:25:0x00b9, B:31:0x0126, B:36:0x0134, B:38:0x0150, B:39:0x0166, B:50:0x01b3, B:42:0x016f, B:44:0x0193, B:48:0x01ab, B:47:0x01a1, B:26:0x00ce, B:16:0x0098, B:18:0x00a5, B:20:0x00ac), top: B:145:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0126 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:10:0x0084, B:12:0x008a, B:25:0x00b9, B:31:0x0126, B:36:0x0134, B:38:0x0150, B:39:0x0166, B:50:0x01b3, B:42:0x016f, B:44:0x0193, B:48:0x01ab, B:47:0x01a1, B:26:0x00ce, B:16:0x0098, B:18:0x00a5, B:20:0x00ac), top: B:145:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0360  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q(android.content.Context r34, android.media.MediaExtractor r35, android.media.MediaMuxer r36, int r37, java.lang.Integer r38, java.lang.Integer r39, @androidx.annotation.NonNull java.lang.Float r40, @androidx.annotation.Nullable com.hw.videoprocessor.g.j r41) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.g.b.q(android.content.Context, android.media.MediaExtractor, android.media.MediaMuxer, int, java.lang.Integer, java.lang.Integer, java.lang.Float, com.hw.videoprocessor.g.j):void");
    }
}
