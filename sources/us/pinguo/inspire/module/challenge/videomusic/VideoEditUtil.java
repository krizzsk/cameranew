package us.pinguo.inspire.module.challenge.videomusic;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import com.hw.videoprocessor.VideoProcessor;
import java.io.File;
/* loaded from: classes9.dex */
public class VideoEditUtil {
    public static boolean checkScaleVideo(String str, float f2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        int parseInt4 = Build.VERSION.SDK_INT >= 17 ? Integer.parseInt(mediaMetadataRetriever.extractMetadata(24)) : 0;
        int c = com.hw.videoprocessor.e.c(str);
        if (parseInt > parseInt2) {
            parseInt = parseInt2;
        }
        if (parseInt > 640) {
            us.pinguo.common.log.a.s("视频尺寸过大，压缩", new Object[0]);
        } else if (parseInt3 > 2000000.0f * f2) {
            us.pinguo.common.log.a.s("视频比特率过大" + parseInt3 + "，压缩到->" + VideoEdit2Activity.MAX_SCALED_BITRATE, new Object[0]);
        } else if (c > f2 * 15.0f) {
            us.pinguo.common.log.a.s("视频帧率:" + c + "过大，压缩到->15", new Object[0]);
        } else if (parseInt4 == 0) {
            return false;
        } else {
            us.pinguo.common.log.a.s("视频角度:" + parseInt4 + ",压缩矫正", new Object[0]);
        }
        return true;
    }

    public static void printVideoInfo(String str) {
        if (!us.pinguo.foundation.d.f10987f || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
            mediaMetadataRetriever.release();
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(com.hw.videoprocessor.e.h(mediaExtractor, false));
            String format = String.format("fileSize:%.1fm,size:%dX%d,framerate:%d,rotation:%d,bitrate:%d", Float.valueOf((((float) new File(str).length()) / 1024.0f) / 1024.0f), Integer.valueOf(trackFormat.getInteger("width")), Integer.valueOf(trackFormat.getInteger("height")), Integer.valueOf(trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : -1), Integer.valueOf(trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : -1), Integer.valueOf(parseInt));
            mediaExtractor.release();
            us.pinguo.common.log.a.s(format, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void scaleVideoForEdit(Context context, String str, String str2, com.hw.videoprocessor.g.j jVar) throws Exception {
        int b = com.hw.videoprocessor.e.b(str);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        if (Math.min(parseInt, parseInt2) > 640) {
            if (parseInt > parseInt2) {
                parseInt = (int) ((parseInt / parseInt2) * ((float) VideoEdit2Activity.MIN_SCALED_SIZE));
                parseInt2 = VideoEdit2Activity.MIN_SCALED_SIZE;
            } else {
                parseInt2 = (int) ((parseInt2 / parseInt) * ((float) VideoEdit2Activity.MIN_SCALED_SIZE));
                parseInt = VideoEdit2Activity.MIN_SCALED_SIZE;
            }
        }
        if (parseInt3 > 2000000) {
            b = (int) (b / (parseInt3 / 2000000.0f));
        }
        int c = com.hw.videoprocessor.e.c(str);
        c = (c <= 0 || c >= 15) ? 15 : 15;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            VideoProcessor.Processor d2 = VideoProcessor.d(context);
            d2.t(str);
            d2.w(str2);
            d2.v(parseInt);
            d2.u(parseInt2);
            d2.p(b);
            d2.r(c);
            d2.s(0);
            d2.y(jVar);
            d2.x();
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            VideoProcessor.Processor d3 = VideoProcessor.d(context);
            d3.t(str);
            d3.w(str2);
            d3.v(parseInt);
            d3.u(parseInt2);
            d3.p(b);
            d3.r(c);
            d3.s(-1);
            d3.y(jVar);
            d3.x();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        us.pinguo.common.log.a.s("视频压缩成功,压缩到,bitrate:" + b + " " + parseInt + "X" + parseInt + ",耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
    }

    public static void scaleVideoForUpload(Context context, String str, String str2, com.hw.videoprocessor.g.j jVar) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        mediaMetadataRetriever.release();
        if (Math.min(parseInt, parseInt2) > 640) {
            if (parseInt > parseInt2) {
                parseInt = (int) ((parseInt / parseInt2) * ((float) VideoEdit2Activity.MIN_SCALED_SIZE));
                parseInt2 = VideoEdit2Activity.MIN_SCALED_SIZE;
            } else {
                parseInt2 = (int) ((parseInt2 / parseInt) * ((float) VideoEdit2Activity.MIN_SCALED_SIZE));
                parseInt = VideoEdit2Activity.MIN_SCALED_SIZE;
            }
        }
        if (parseInt3 > 2000000) {
            parseInt3 = VideoEdit2Activity.MAX_SCALED_BITRATE;
        }
        int c = com.hw.videoprocessor.e.c(str);
        c = (c <= 0 || c >= 15) ? 15 : 15;
        long currentTimeMillis = System.currentTimeMillis();
        VideoProcessor.Processor d2 = VideoProcessor.d(context);
        d2.t(str);
        d2.w(str2);
        d2.v(parseInt);
        d2.u(parseInt2);
        d2.p(parseInt3);
        d2.r(c);
        d2.s(1);
        d2.y(jVar);
        d2.x();
        long currentTimeMillis2 = System.currentTimeMillis();
        us.pinguo.common.log.a.s("视频压缩成功,压缩到,bitrate:" + parseInt3 + " " + parseInt + "X" + parseInt + ",耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
    }
}
