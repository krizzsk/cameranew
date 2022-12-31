package us.pinguo.svideo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import j.a.f.e;
import java.io.File;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.d;
import us.pinguo.foundation.f;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.svideo.bean.VideoInfo;
import us.pinguo.svideo.utils.SVideoUtil;
import us.pinguo.svideo.utils.b;
import us.pinguo.util.c;
/* compiled from: VideoRecorderManager.java */
/* loaded from: classes6.dex */
public class a {
    static {
        b.k(d.f10987f);
    }

    public static void a(VideoInfo videoInfo) {
        b(BaseApplication.d(), videoInfo.getVideoPath(), videoInfo);
    }

    public static void b(Context context, String str, VideoInfo videoInfo) {
        int i2;
        if ((f.y || c.f12473g) && str.contains("/DCIM/Camera/")) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file));
                    context.sendBroadcast(intent);
                    return;
                }
                return;
            } catch (Throwable unused) {
            }
        }
        b.l("addVideoToMediaStore enter", new Object[0]);
        File file2 = new File(str);
        Uri parse = Uri.parse("content://media/external/video/media");
        long length = file2.length();
        int videoWidth = videoInfo.getVideoWidth();
        int videoHeight = videoInfo.getVideoHeight();
        b.l("addVideoToMediaStore length =" + length, new Object[0]);
        String name = file2.getName();
        String name2 = file2.getName();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues(7);
        contentValues.put("title", name);
        contentValues.put("_display_name", name2);
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("_data", str);
        contentValues.put("resolution", Integer.toString(videoWidth) + "x" + Integer.toString(videoHeight));
        contentValues.put("_size", Long.valueOf(length));
        us.pinguo.image.saver.d.b bVar = new us.pinguo.image.saver.d.b();
        us.pinguo.librouter.b.c.f location = us.pinguo.librouter.b.b.b().getInterface().getLocation();
        bVar.a(14);
        bVar.j(name);
        bVar.c(name2);
        bVar.h(currentTimeMillis);
        bVar.g("video/mp4");
        bVar.d(str);
        bVar.k(Integer.toString(videoWidth));
        bVar.e(Integer.toString(videoHeight));
        if (CameraBusinessSettingModel.v().l() && location != null) {
            contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Double.valueOf(location.c()));
            contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Double.valueOf(location.d()));
            bVar.b(location);
        }
        bVar.f(length);
        long duration = videoInfo.getDuration();
        if (duration > 0) {
            contentValues.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(duration));
            bVar.i(duration);
            i2 = 0;
        } else {
            i2 = 0;
            us.pinguo.common.log.a.s("Video duration <= 0 : " + duration, new Object[0]);
        }
        us.pinguo.common.log.a.q("addVideoToMediaStore start", new Object[i2]);
        try {
            Uri insert = BaseApplication.d().getContentResolver().insert(parse, contentValues);
            b.l("addVideoToMediaStore insert system DB done", new Object[0]);
            b.l("addVideoToMediaStore insert camera360 DB done", new Object[0]);
            if (SVideoUtil.a) {
                context.sendBroadcast(new Intent("android.hardware.action.NEW_VIDEO", insert));
            }
        } catch (Exception e2) {
            e.e(e2);
        }
    }
}
