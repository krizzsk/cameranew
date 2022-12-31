package us.pinguo.camera2020.view;

import android.os.Environment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import us.pinguo.foundation.utils.NoProguard;
/* loaded from: classes3.dex */
public class IVideoPathGeneratorImpl implements us.pinguo.svideo.c.d, NoProguard {
    private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

    @Override // us.pinguo.svideo.c.d
    public String generate() {
        String str = "C360VID_" + this.dateFormat.format(Long.valueOf(System.currentTimeMillis())) + ".mp4";
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera/";
        us.pinguo.common.utils.e.b(str2);
        return str2 + str;
    }
}
