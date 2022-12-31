package us.pinguo.advconfigdata.Utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;
@Deprecated
/* loaded from: classes3.dex */
public class AdvScreenUtils {
    public static final int ORIENTATION_HYSTERESIS = 20;
    private static long lastClickTime;
    public static final int[] COUNT_DOWN_TIME = {3, 5, 10};
    private static final String TAG = AdvScreenUtils.class.getSimpleName();
    public static String PACKAGE_NAME = "";
    public static String VERSION_CODE = "";
    public static String VERSION_NAME = "";
    public static String PHONE_IMEI = "";
    public static String PHONE_LOCALE = "";
    public static String NETWORK_TYPE = "";
    private static int SCREEN_HEIGHT = 0;
    private static int SCREEN_WIDTH = 0;
    private static float sPixelDensity = -1.0f;
    private static int versionCode = -1;

    private AdvScreenUtils() {
    }

    public static void Assert(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int clamp(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static float dpToPixel(float f2) {
        return sPixelDensity * f2;
    }

    public static int dpToPx(float f2) {
        return (int) ((sPixelDensity * f2) + 0.5f);
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int getDisplayRotation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return BaseBlurEffect.ROTATION_180;
        }
        return 90;
    }

    public static String getLanguage(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    public static PackageInfo getMyPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
    }

    public static float getPixelDensity() {
        float f2 = sPixelDensity;
        if (f2 != -1.0f) {
            return f2;
        }
        throw new RuntimeException("Must call initialize method first !!!");
    }

    public static String getRandomString() {
        return String.format(Locale.ENGLISH, "%8d", Integer.valueOf(new Random().nextInt(100000000))).replace(' ', '0');
    }

    public static int getScreenHeight() {
        int i2 = SCREEN_HEIGHT;
        if (i2 != 0) {
            return i2;
        }
        throw new RuntimeException("Must call initialize method first !!!");
    }

    public static int getScreenWidth() {
        int i2 = SCREEN_WIDTH;
        if (i2 != 0) {
            return i2;
        }
        throw new RuntimeException("Must call initialize method first !!!");
    }

    public static int getVersionCode(Context context) {
        int i2 = versionCode;
        if (i2 != -1) {
            return i2;
        }
        if (context == null) {
            versionCode = -1;
        }
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            versionCode = -1;
        }
        return versionCode;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        for (int i2 = 0; i2 < tArr.length; i2++) {
            if (tArr[i2].equals(t)) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - lastClickTime;
        if (0 >= j2 || j2 >= 400) {
            lastClickTime = currentTimeMillis;
            return false;
        }
        return true;
    }

    public static boolean isPhoneNum(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 11) {
            return false;
        }
        return Pattern.compile("1\\d{10}").matcher(str).matches();
    }

    public static boolean isSupportTiltshift() {
        return sPixelDensity > 1.0f;
    }

    public static boolean isSupported(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public static boolean isTabletDivice() {
        return pixelTodp(SCREEN_WIDTH) >= 600;
    }

    public static boolean isUriValid(Uri uri, ContentResolver contentResolver) {
        if (uri == null) {
            return false;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                String str = TAG;
                AdvLog.Log(str, "Fail to open URI. URI=" + uri);
                return false;
            }
            openFileDescriptor.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isZh(String str) {
        return "zh".equals(str.toLowerCase(Locale.ENGLISH));
    }

    public static boolean isZhForNow() {
        return isZh(Locale.getDefault().getLanguage());
    }

    public static int meterToPixel(float f2) {
        return Math.round(dpToPixel(f2 * 39.37f * 160.0f));
    }

    public static int pixelTodp(int i2) {
        return Math.round(i2 / sPixelDensity);
    }

    public static void prepareMatrix(Matrix matrix, boolean z, int i2, int i3, int i4) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i2);
        float f2 = i3;
        float f3 = i4;
        matrix.postScale(f2 / 2000.0f, f3 / 2000.0f);
        matrix.postTranslate(f2 / 2.0f, f3 / 2.0f);
    }

    public static void rectFToRect(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static int roundOrientation(int i2, int i3) {
        boolean z = true;
        if (i3 != -1) {
            int abs = Math.abs(i2 - i3);
            if (Math.min(abs, 360 - abs) < 65) {
                z = false;
            }
        }
        return z ? (((i2 + 45) / 90) * 90) % BaseBlurEffect.ROTATION_360 : i3;
    }

    public static int spToPx(int i2) {
        return (int) ((sPixelDensity * i2) + 0.5f);
    }

    public static int dpToPixel(int i2) {
        return Math.round(dpToPixel(i2));
    }
}
