package us.pinguo.svideo.manager;

import android.os.Build;
import android.text.TextUtils;
import java.util.regex.Pattern;
import us.pinguo.svideo.utils.SVideoUtil;
import us.pinguo.svideo.utils.b;
/* loaded from: classes6.dex */
public class VideoRecorderAdapter {
    private static ModelInfo a;

    /* loaded from: classes6.dex */
    public static class ModelInfo {
        public String api;
        public String brand;
        public String codec;
        public String color;
        public String device;
        public String draw_mode;
        public String model;
        public String no_video;
        public String read_pixels;
        public String version;

        public String toString() {
            return "model:" + this.model + " device:" + this.device + " brand:" + this.brand + " api:" + this.api + " codec:" + this.codec + " no_video:" + this.no_video + " color:" + this.color + " read_pixels:" + this.read_pixels + " draw_mode:" + this.draw_mode + " version:" + this.version;
        }
    }

    static {
        b();
    }

    private static void a(ModelInfo modelInfo) {
        if (modelInfo == null) {
            return;
        }
        if (!d(modelInfo)) {
            b.i("not current phone,filter modelInfo:" + modelInfo, new Object[0]);
            return;
        }
        if (a == null) {
            a = new ModelInfo();
        }
        if (!TextUtils.isEmpty(modelInfo.api)) {
            a.api = modelInfo.api;
        }
        if (!TextUtils.isEmpty(modelInfo.brand)) {
            a.brand = modelInfo.brand;
        }
        if (!TextUtils.isEmpty(modelInfo.read_pixels)) {
            a.read_pixels = modelInfo.read_pixels;
        }
        if (!TextUtils.isEmpty(modelInfo.codec)) {
            a.codec = modelInfo.codec;
        }
        if (!TextUtils.isEmpty(modelInfo.color)) {
            a.color = modelInfo.color;
        }
        if (!TextUtils.isEmpty(modelInfo.device)) {
            a.device = modelInfo.device;
        }
        if (!TextUtils.isEmpty(modelInfo.model)) {
            a.model = modelInfo.model;
        }
        if (!TextUtils.isEmpty(modelInfo.no_video)) {
            a.no_video = modelInfo.no_video;
        }
        if (!TextUtils.isEmpty(modelInfo.version)) {
            a.version = modelInfo.version;
        }
        if (!TextUtils.isEmpty(modelInfo.draw_mode)) {
            a.draw_mode = modelInfo.draw_mode;
        }
        b.i("modelInfo:" + a.toString(), new Object[0]);
    }

    private static void b() {
        g("ASUS_Z00ADB", "blit2x");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
        if (java.lang.Integer.valueOf(r7).intValue() == r2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(us.pinguo.svideo.manager.VideoRecorderAdapter.ModelInfo r7) {
        /*
            if (r7 != 0) goto L5
            java.lang.String r7 = ""
            goto L7
        L5:
            java.lang.String r7 = r7.api
        L7:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 1
            if (r0 == 0) goto Lf
            return r1
        Lf:
            r0 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NumberFormatException -> Lbb
            char r3 = r7.charAt(r0)     // Catch: java.lang.NumberFormatException -> Lbb
            r4 = 43
            if (r3 != r4) goto L2b
            java.lang.String r3 = r7.substring(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            if (r2 < r3) goto L29
            goto L94
        L29:
            r1 = 0
            goto L94
        L2b:
            char r3 = r7.charAt(r0)     // Catch: java.lang.NumberFormatException -> Lbb
            r4 = 45
            if (r3 != r4) goto L42
            java.lang.String r3 = r7.substring(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            if (r2 > r3) goto L29
            goto L94
        L42:
            r3 = 126(0x7e, float:1.77E-43)
            int r4 = r7.indexOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            if (r4 <= 0) goto L8a
            int r3 = r7.indexOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r4 = r7.substring(r0, r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3 + r1
            java.lang.String r3 = r7.substring(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            int r4 = r4.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lbb
            r5.<init>()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r6 = "startApi:"
            r5.append(r6)     // Catch: java.lang.NumberFormatException -> Lbb
            r5.append(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r6 = " endApi:"
            r5.append(r6)     // Catch: java.lang.NumberFormatException -> Lbb
            r5.append(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r5 = r5.toString()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.NumberFormatException -> Lbb
            us.pinguo.svideo.utils.b.i(r5, r6)     // Catch: java.lang.NumberFormatException -> Lbb
            if (r2 < r4) goto L29
            if (r2 > r3) goto L29
            goto L94
        L8a:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            if (r3 != r2) goto L29
        L94:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lbb
            r3.<init>()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r4 = "currentApi:"
            r3.append(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r2 = " modelApi:"
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lbb
            r3.append(r7)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r7 = " isCurrentVersion:"
            r3.append(r7)     // Catch: java.lang.NumberFormatException -> Lbb
            r3.append(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r7 = r3.toString()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.NumberFormatException -> Lbb
            us.pinguo.svideo.utils.b.i(r7, r2)     // Catch: java.lang.NumberFormatException -> Lbb
            return r1
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.svideo.manager.VideoRecorderAdapter.c(us.pinguo.svideo.manager.VideoRecorderAdapter$ModelInfo):boolean");
    }

    public static boolean d(ModelInfo modelInfo) {
        if (modelInfo != null && c(modelInfo)) {
            String str = modelInfo.model;
            if (!TextUtils.isEmpty(str)) {
                return e(str, Build.MODEL);
            }
            String str2 = modelInfo.device;
            if (!TextUtils.isEmpty(str2)) {
                return e(str2, Build.DEVICE);
            }
            String str3 = modelInfo.brand;
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return e(str3, Build.BRAND);
        }
        return false;
    }

    private static boolean e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return Pattern.compile(str).matcher(str2).find();
    }

    public static boolean f() {
        if (SVideoUtil.b) {
            return false;
        }
        ModelInfo modelInfo = a;
        if (modelInfo == null) {
            return true;
        }
        return !"true".equals(modelInfo.no_video);
    }

    public static void g(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        ModelInfo modelInfo = new ModelInfo();
        modelInfo.model = str;
        modelInfo.draw_mode = str2;
        a(modelInfo);
    }

    public static boolean h() {
        ModelInfo modelInfo = a;
        return "blitFrameBuffer".equals(modelInfo == null ? null : modelInfo.draw_mode);
    }
}
