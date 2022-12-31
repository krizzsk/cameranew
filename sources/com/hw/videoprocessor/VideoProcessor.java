package com.hw.videoprocessor;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hw.videoprocessor.g.h;
import com.hw.videoprocessor.g.i;
import com.hw.videoprocessor.g.j;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(21)
/* loaded from: classes2.dex */
public class VideoProcessor {
    public static int a = 20;
    public static boolean b = true;

    /* loaded from: classes2.dex */
    public static class Processor {
        private Context a;
        private String b;
        private String c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Integer f5230d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private Integer f5231e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Integer f5232f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private Integer f5233g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Float f5234h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Boolean f5235i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private Integer f5236j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private Integer f5237k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private Integer f5238l;
        @Nullable
        private j m;
        private boolean n = true;

        public Processor(Context context) {
            this.a = context;
        }

        public Processor p(int i2) {
            this.f5236j = Integer.valueOf(i2);
            return this;
        }

        public Processor q(boolean z) {
            this.f5235i = Boolean.valueOf(z);
            return this;
        }

        public Processor r(int i2) {
            this.f5237k = Integer.valueOf(i2);
            return this;
        }

        public Processor s(int i2) {
            this.f5238l = Integer.valueOf(i2);
            return this;
        }

        public Processor t(String str) {
            this.b = str;
            return this;
        }

        public Processor u(int i2) {
            this.f5231e = Integer.valueOf(i2);
            return this;
        }

        public Processor v(int i2) {
            this.f5230d = Integer.valueOf(i2);
            return this;
        }

        public Processor w(String str) {
            this.c = str;
            return this;
        }

        public void x() throws Exception {
            VideoProcessor.c(this.a, this);
        }

        public Processor y(j jVar) {
            this.m = jVar;
            return this;
        }

        public Processor z(float f2) {
            this.f5234h = Float.valueOf(f2);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ File b;
        final /* synthetic */ Integer c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Integer f5239d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f5240e;

        a(String str, File file, Integer num, Integer num2, CountDownLatch countDownLatch) {
            this.a = str;
            this.b = file;
            this.c = num;
            this.f5239d = num2;
            this.f5240e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    com.hw.videoprocessor.g.b.f(this.a, this.b.getAbsolutePath(), this.c, this.f5239d);
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } finally {
                this.f5240e.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ File b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5241d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f5242e;

        b(String str, File file, int i2, int i3, CountDownLatch countDownLatch) {
            this.a = str;
            this.b = file;
            this.c = i2;
            this.f5241d = i3;
            this.f5242e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    String str = this.a;
                    String absolutePath = this.b.getAbsolutePath();
                    int i2 = this.c;
                    int i3 = this.f5241d;
                    com.hw.videoprocessor.g.b.f(str, absolutePath, 0, Integer.valueOf(i2 > i3 ? i3 * 1000 : i2 * 1000));
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } finally {
                this.f5242e.countDown();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0219  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0310 -> B:46:0x020d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r37, java.lang.String r38, java.lang.String r39, @androidx.annotation.IntRange(from = 0, to = 100) int r40, float r41, float r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.VideoProcessor.a(android.content.Context, java.lang.String, java.lang.String, int, float, float):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0380, code lost:
        if (r1 != 0.0f) goto L227;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0588 A[Catch: all -> 0x05a7, TRY_LEAVE, TryCatch #2 {all -> 0x05a7, blocks: (B:127:0x0555, B:129:0x055f, B:133:0x0588, B:140:0x05b0), top: B:210:0x0555 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05b0 A[Catch: all -> 0x05a7, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x05a7, blocks: (B:127:0x0555, B:129:0x055f, B:133:0x0588, B:140:0x05b0), top: B:210:0x0555 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04be A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.Integer r42, java.lang.Integer r43, @androidx.annotation.IntRange(from = 0, to = 100) int r44, @androidx.annotation.IntRange(from = 0, to = 100) int r45, float r46, float r47) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1869
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.VideoProcessor.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, int, int, float, float):void");
    }

    public static void c(@NonNull Context context, @NonNull Processor processor) throws Exception {
        int i2;
        int i3;
        MediaMuxer mediaMuxer;
        Integer num;
        int i4;
        MediaMuxer mediaMuxer2;
        long j2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(processor.b);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        int parseInt4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int parseInt5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        mediaMetadataRetriever.release();
        if (processor.f5236j == null) {
            processor.f5236j = Integer.valueOf(parseInt4);
        }
        if (processor.f5238l == null) {
            processor.f5238l = 1;
        }
        if (processor.f5230d != null) {
            parseInt = processor.f5230d.intValue();
        }
        if (processor.f5231e != null) {
            parseInt2 = processor.f5231e.intValue();
        }
        if (parseInt % 2 != 0) {
            parseInt++;
        }
        if (parseInt2 % 2 != 0) {
            parseInt2++;
        }
        if (parseInt3 == 90 || parseInt3 == 270) {
            i2 = parseInt;
            i3 = parseInt2;
        } else {
            i3 = parseInt;
            i2 = parseInt2;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(processor.b);
        int h2 = e.h(mediaExtractor, false);
        int h3 = e.h(mediaExtractor, true);
        MediaMuxer mediaMuxer3 = new MediaMuxer(processor.c, 0);
        boolean booleanValue = processor.f5235i == null ? true : processor.f5235i.booleanValue();
        Integer num2 = processor.f5233g;
        if (h3 >= 0) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(h3);
            int g2 = com.hw.videoprocessor.g.b.g(trackFormat);
            int integer = trackFormat.getInteger("channel-count");
            int integer2 = trackFormat.getInteger("sample-rate");
            int h4 = com.hw.videoprocessor.g.b.h(trackFormat);
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer2, integer);
            createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, g2);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("max-input-size", h4);
            if (booleanValue) {
                if (processor.f5232f == null && processor.f5233g == null && processor.f5234h == null) {
                    mediaMuxer2 = mediaMuxer3;
                } else {
                    long j3 = trackFormat.getLong("durationUs");
                    if (processor.f5232f == null || processor.f5233g == null) {
                        mediaMuxer2 = mediaMuxer3;
                        j2 = j3;
                    } else {
                        mediaMuxer2 = mediaMuxer3;
                        j2 = (processor.f5233g.intValue() - processor.f5232f.intValue()) * 1000;
                    }
                    if (processor.f5234h != null) {
                        j2 = ((float) j2) / processor.f5234h.floatValue();
                    }
                    createAudioFormat.setLong("durationUs", j2);
                }
            } else {
                mediaMuxer2 = mediaMuxer3;
                long j4 = parseInt5 * 1000;
                long j5 = trackFormat.getLong("durationUs");
                if (processor.f5232f != null || processor.f5233g != null || processor.f5234h != null) {
                    if (processor.f5232f != null && processor.f5233g != null) {
                        j4 = (processor.f5233g.intValue() - processor.f5232f.intValue()) * 1000;
                    }
                    if (processor.f5234h != null) {
                        j4 = ((float) j4) / processor.f5234h.floatValue();
                    }
                    if (j4 >= j5) {
                        j4 = j5;
                    }
                    createAudioFormat.setLong("durationUs", j4);
                    num2 = Integer.valueOf((processor.f5232f == null ? 0 : processor.f5232f.intValue()) + ((int) (j4 / 1000)));
                }
            }
            com.hw.videoprocessor.g.b.d(createAudioFormat, 2, integer2, integer);
            mediaMuxer = mediaMuxer2;
            i4 = mediaMuxer.addTrack(createAudioFormat);
            num = num2;
        } else {
            mediaMuxer = mediaMuxer3;
            num = num2;
            i4 = 0;
        }
        mediaExtractor.selectTrack(h2);
        if (processor.f5232f != null) {
            mediaExtractor.seekTo(processor.f5232f.intValue() * 1000, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        i iVar = new i(processor.m);
        iVar.d(processor.f5234h);
        iVar.e(processor.f5232f == null ? 0 : processor.f5232f.intValue());
        if (processor.f5233g != null) {
            parseInt5 = processor.f5233g.intValue();
        }
        iVar.c(parseInt5);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d dVar = new d(mediaExtractor, mediaMuxer, processor.f5236j.intValue(), i3, i2, processor.f5238l.intValue(), processor.f5237k == null ? a : processor.f5237k.intValue(), h2, atomicBoolean, countDownLatch);
        int c = e.c(processor.b);
        if (c <= 0) {
            c = (int) Math.ceil(e.a(processor.b));
        }
        c cVar = new c(dVar, mediaExtractor, processor.f5232f, processor.f5233g, Integer.valueOf(c), Integer.valueOf(processor.f5237k == null ? a : processor.f5237k.intValue()), processor.f5234h, processor.n, h2, atomicBoolean);
        com.hw.videoprocessor.a aVar = new com.hw.videoprocessor.a(context, processor.b, mediaMuxer, processor.f5232f, num, booleanValue ? processor.f5234h : null, i4, countDownLatch);
        dVar.f(iVar);
        aVar.c(iVar);
        cVar.start();
        dVar.start();
        aVar.start();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            cVar.join();
            dVar.join();
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar.join();
            com.hw.videoprocessor.g.c.k(String.format("编解码:%dms,音频:%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)), new Object[0]);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        try {
            mediaMuxer.release();
            mediaExtractor.release();
        } catch (Exception e3) {
            com.hw.videoprocessor.g.c.d(e3);
        }
        if (dVar.d() == null) {
            if (cVar.b() == null) {
                if (aVar.b() != null) {
                    throw aVar.b();
                }
                return;
            }
            throw cVar.b();
        }
        throw dVar.d();
    }

    public static Processor d(Context context) {
        return new Processor(context);
    }

    public static void e(Context context, String str, String str2, boolean z, @Nullable j jVar) throws Exception {
        File file = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp");
        File file2 = new File(context.getCacheDir(), System.currentTimeMillis() + ".temp2");
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            mediaExtractor.selectTrack(e.h(mediaExtractor, false));
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int sampleFlags = mediaExtractor.getSampleFlags();
                if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                    i2++;
                }
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime < 0) {
                    break;
                }
                arrayList.add(Long.valueOf(sampleTime));
                i3++;
                mediaExtractor.advance();
            }
            mediaExtractor.release();
            if (i3 != i2 && i3 != i2 + 1) {
                int i4 = 1;
                h hVar = new h(new float[]{0.45f, 0.1f, 0.45f}, jVar);
                hVar.a(0);
                float f2 = i2;
                float f3 = 1.0f + ((i3 - i2) / f2);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                try {
                    Processor d2 = d(context);
                    d2.t(str);
                    d2.w(file.getAbsolutePath());
                    d2.p((int) (parseInt * f3));
                    d2.s(0);
                    d2.y(hVar);
                    d2.x();
                } catch (MediaCodec.CodecException e2) {
                    com.hw.videoprocessor.g.c.d(e2);
                    Processor d3 = d(context);
                    d3.t(str);
                    d3.w(file.getAbsolutePath());
                    d3.p((int) (parseInt * f3));
                    d3.s(-1);
                    d3.y(hVar);
                    d3.x();
                }
                hVar.a(1);
                f(file.getAbsolutePath(), file2.getAbsolutePath(), z, null, hVar);
                int i5 = (int) (f2 / (parseInt2 / 1000.0f));
                if (i5 != 0) {
                    i4 = i5;
                }
                hVar.a(2);
                Processor d4 = d(context);
                d4.t(file2.getAbsolutePath());
                d4.w(str2);
                d4.p(parseInt);
                d4.s(i4);
                d4.y(hVar);
                d4.x();
            }
            f(str, str2, z, arrayList, jVar);
        } finally {
            file.delete();
            file2.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012e A[Catch: all -> 0x01f5, Exception -> 0x01f7, TryCatch #1 {Exception -> 0x01f7, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0194, B:66:0x0199, B:67:0x019f, B:70:0x01a8, B:73:0x01bc, B:75:0x01c1, B:78:0x01cf, B:79:0x01d6, B:81:0x01dc, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e2), top: B:93:0x007e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dc A[Catch: all -> 0x01f5, Exception -> 0x01f7, TryCatch #1 {Exception -> 0x01f7, blocks: (B:12:0x007e, B:14:0x0084, B:16:0x0090, B:19:0x00aa, B:48:0x012e, B:50:0x0139, B:52:0x0149, B:55:0x0160, B:58:0x0176, B:60:0x017b, B:63:0x018a, B:65:0x0194, B:66:0x0199, B:67:0x019f, B:70:0x01a8, B:73:0x01bc, B:75:0x01c1, B:78:0x01cf, B:79:0x01d6, B:81:0x01dc, B:22:0x00c0, B:24:0x00c5, B:27:0x00d2, B:28:0x00d7, B:33:0x00e8, B:36:0x00f3, B:39:0x0109, B:41:0x010e, B:44:0x011b, B:45:0x0120, B:82:0x01e2), top: B:93:0x007e, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(java.lang.String r28, java.lang.String r29, boolean r30, java.util.List<java.lang.Long> r31, @androidx.annotation.Nullable com.hw.videoprocessor.g.j r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.VideoProcessor.f(java.lang.String, java.lang.String, boolean, java.util.List, com.hw.videoprocessor.g.j):void");
    }
}
