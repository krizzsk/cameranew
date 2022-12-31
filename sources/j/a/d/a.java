package j.a.d;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.util.Matrix;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.Iterator;
import us.pinguo.androidsdk.PGNativeMethod;
/* compiled from: VideoScale.java */
/* loaded from: classes5.dex */
public class a {
    private static String a(int i2) {
        if (i2 != 90) {
            if (i2 != 180) {
                if (i2 != 270) {
                    return null;
                }
                return "transpose=2";
            }
            return "transpose=1,transpose=1";
        }
        return "transpose=1";
    }

    public static Pair<Integer, Integer> b(int i2, int i3) {
        if (i2 > i3 && i3 > 480) {
            int i4 = (int) ((i2 / i3) * 480.0f);
            if (i4 % 2 != 0) {
                i4++;
            }
            return new Pair<>(Integer.valueOf(i4), 480);
        } else if (i3 >= i2 && i2 > 480) {
            int i5 = (int) ((i3 / i2) * 480.0f);
            if (i5 % 2 != 0) {
                i5++;
            }
            return new Pair<>(480, Integer.valueOf(i5));
        } else {
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public static int c(String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                if (TextUtils.isEmpty(extractMetadata)) {
                    return 0;
                }
                return Integer.parseInt(extractMetadata);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return d(str);
    }

    public static int d(String str) {
        Track track;
        try {
            track = null;
            Iterator<Track> it = MovieCreator.build(str).getTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Track next = it.next();
                if (next.getHandler().equals("vide")) {
                    track = next;
                    break;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (track == null) {
            return 0;
        }
        Matrix matrix = track.getTrackMetaData().getMatrix();
        if (Matrix.ROTATE_270.equals(matrix)) {
            return BaseBlurEffect.ROTATION_270;
        }
        if (Matrix.ROTATE_90.equals(matrix)) {
            return 90;
        }
        if (Matrix.ROTATE_180.equals(matrix)) {
            return BaseBlurEffect.ROTATION_180;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[Catch: Exception -> 0x00ff, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ff, blocks: (B:3:0x0003, B:7:0x0028, B:9:0x0055, B:25:0x009c, B:21:0x0083, B:13:0x0062), top: B:31:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String e(java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.a.d.a.e(java.lang.String, java.lang.String):java.lang.String");
    }

    public static int f(String str, String str2) {
        String e2 = e(str, str2);
        if (TextUtils.isEmpty(e2)) {
            return -1;
        }
        return PGNativeMethod.applyFFmepgCommandLine(e2);
    }
}
