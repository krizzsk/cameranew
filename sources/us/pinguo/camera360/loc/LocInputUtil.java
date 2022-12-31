package us.pinguo.camera360.loc;

import android.graphics.Point;
import com.pinguo.lib.PGDisplayUtils;
import com.tencent.bugly.crashreport.CrashReport;
import us.pinguo.image.ImageNative;
import us.pinguo.util.e;
/* loaded from: classes3.dex */
public class LocInputUtil {

    /* loaded from: classes3.dex */
    private static class LocInputUtilScaleImageError extends Exception {
        LocInputUtilScaleImageError(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str) {
        Point m = e.m(str);
        int max = Math.max(m.x, m.y);
        int previewLength = PGDisplayUtils.getPreviewLength();
        float f2 = previewLength / max;
        float f3 = 0.0f;
        while (f3 <= 0.4f) {
            try {
                ImageNative.scaleImg(str, str, 0, (1.0f - f3) * f2, 95);
                return;
            } catch (OutOfMemoryError e2) {
                f3 += 0.1f;
                CrashReport.postCatchedException(new LocInputUtilScaleImageError("size:" + m.toString() + "   maxLength:" + previewLength + "  sub:" + f3, e2));
            }
        }
    }
}
