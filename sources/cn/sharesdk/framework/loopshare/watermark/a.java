package cn.sharesdk.framework.loopshare.watermark;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import java.io.FileOutputStream;
/* compiled from: BitmapFactory.java */
/* loaded from: classes.dex */
public class a {
    private static int b = 15;
    private static int c = 270;
    private static int[] a = new int[3];

    /* renamed from: d  reason: collision with root package name */
    private static float[] f130d = {60.0f, 30.0f, 10.0f};

    /* renamed from: e  reason: collision with root package name */
    private static int f131e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static int f132f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static int f133g = 100;

    public static boolean a(String str, String[] strArr) {
        try {
            Paint paint = new Paint(1);
            paint.setColor(f131e);
            c = 0;
            b = 0;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                paint.setTextSize(f130d[i2]);
                Rect rect = new Rect();
                paint.getTextBounds(strArr[i2], 0, strArr[i2].length(), rect);
                if (c < rect.width()) {
                    c = rect.width();
                }
                a[i2] = rect.height();
                b += rect.height() * 2;
            }
            Bitmap createBitmap = Bitmap.createBitmap(c, b, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(f132f);
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                paint.setTextSize(f130d[i4]);
                int[] iArr = a;
                i3 += iArr[i4];
                if (i4 > 0) {
                    i3 += iArr[i4 - 1];
                }
                canvas.drawText(strArr[i4], 0.0f, i3, paint);
            }
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "path:" + str);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, f133g, new FileOutputStream(str));
            g.a = c;
            g.b = b;
            return true;
        } catch (Throwable th) {
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "e:" + th.toString());
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "writeImage catch: " + th);
            return false;
        }
    }
}
