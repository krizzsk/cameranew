package us.pinguo.svideo.utils;

import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
/* compiled from: DateVideoNameGenerator.java */
/* loaded from: classes6.dex */
public class a implements us.pinguo.svideo.c.d {
    @Override // us.pinguo.svideo.c.d
    public String generate() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "VID_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Long.valueOf(System.currentTimeMillis())) + ".mp4").getAbsolutePath();
    }
}
