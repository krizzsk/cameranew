package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: VideoUtil.java */
/* loaded from: classes2.dex */
public class e {
    public static float a(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i2 = 0;
        mediaExtractor.selectTrack(h(mediaExtractor, false));
        long j2 = 0;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                mediaExtractor.release();
                return i2 / ((((float) j2) / 1000.0f) / 1000.0f);
            }
            i2++;
            mediaExtractor.advance();
            j2 = sampleTime;
        }
    }

    public static int b(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i2 = 0;
        mediaExtractor.selectTrack(h(mediaExtractor, false));
        int i3 = 0;
        while (true) {
            int sampleFlags = mediaExtractor.getSampleFlags();
            if (sampleFlags > 0 && (sampleFlags & 1) != 0) {
                i2++;
            }
            if (mediaExtractor.getSampleTime() < 0) {
                break;
            }
            i3++;
            mediaExtractor.advance();
        }
        mediaExtractor.release();
        float f2 = ((i3 - i2) / i2) + 1.0f;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        return i3 == i2 ? parseInt : (int) (f2 * parseInt);
    }

    public static int c(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(h(mediaExtractor, false));
            return trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : -1;
        } catch (IOException e2) {
            com.hw.videoprocessor.g.c.d(e2);
            return -1;
        } finally {
            mediaExtractor.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> d(MediaExtractor mediaExtractor) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime < 0) {
                return arrayList;
            }
            arrayList.add(Long.valueOf(sampleTime));
            mediaExtractor.advance();
        }
    }

    public static int e(MediaCodec mediaCodec, String str) {
        try {
            return mediaCodec.getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange().getUpper().intValue();
        } catch (Exception e2) {
            com.hw.videoprocessor.g.c.d(e2);
            return -1;
        }
    }

    public static File f(Context context) {
        File file = new File(context.getCacheDir(), "video/");
        file.mkdirs();
        return file;
    }

    public static void g(MediaExtractor mediaExtractor, int i2, int i3) {
        int i4 = i3 * 1000;
        if (mediaExtractor.getSampleTrackIndex() != i2) {
            mediaExtractor.selectTrack(i2);
        }
        mediaExtractor.seekTo(i4, 0);
        while (i4 > 0 && mediaExtractor.getSampleTrackIndex() != i2) {
            i4 -= 10000;
            mediaExtractor.seekTo(i4, 0);
        }
    }

    public static int h(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            String string = mediaExtractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME);
            if (z) {
                if (string.startsWith("audio/")) {
                    return i2;
                }
            } else if (string.startsWith("video/")) {
                return i2;
            }
        }
        return -5;
    }

    public static boolean i(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, int i2, int i3) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodec.getCodecInfo().getCapabilitiesForType(str).profileLevels;
        if (codecProfileLevelArr == null) {
            return false;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i2 && codecProfileLevel.level == i3) {
                mediaFormat.setInteger("profile", i2);
                mediaFormat.setInteger("level", i3);
                return true;
            }
        }
        return false;
    }
}
