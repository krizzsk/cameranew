package us.pinguo.svideo.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.os.Build;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.Locale;
@TargetApi(16)
/* loaded from: classes6.dex */
public class SVideoUtil {
    public static final boolean a;
    public static final boolean b;
    public static boolean c;

    /* renamed from: d  reason: collision with root package name */
    private static long f12072d;

    /* loaded from: classes6.dex */
    private static class ColorFormatNotSupportThrowable extends Throwable {
        public ColorFormatNotSupportThrowable(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    private static class NotSupportAvcThrowable extends Throwable {
        public NotSupportAvcThrowable(String str) {
            super(str);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 >= 14;
        b = i2 < 18;
        c = false;
        f12072d = 0L;
    }

    @TargetApi(17)
    public static void a(String str, boolean z) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            b.d(str + ": EGL Error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
            if (z) {
                throw new RuntimeException(str + ": EGL Error: 0x" + Integer.toHexString(eglGetError));
            }
        }
    }

    public static void b(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            File file = new File(list.get(i2));
            if (file.exists()) {
                file.delete();
            }
        }
        list.clear();
    }

    public static Rect c(Rect rect, int i2, int i3, float f2, float f3) {
        if (rect == null) {
            rect = new Rect();
        }
        float f4 = f2 / f3;
        float f5 = i2;
        float f6 = i3;
        float f7 = f5 / f6;
        if (Math.abs(f4 - f7) < 0.01d) {
            rect.left = 0;
            rect.top = 0;
            rect.right = i2;
            rect.bottom = i3;
        } else if (f7 > f4) {
            float f8 = f3 / f6;
            int i4 = (int) ((((f5 * f8) - f2) / f8) / 2.0f);
            rect.left = i4;
            rect.top = 0;
            rect.right = i2 - i4;
            rect.bottom = i3;
        } else {
            float f9 = f2 / f5;
            rect.left = 0;
            int i5 = (int) ((((f6 * f9) - f3) / f9) / 2.0f);
            rect.top = i5;
            rect.right = i2;
            rect.bottom = i3 - i5;
        }
        return rect;
    }

    private static long d(long j2) {
        return (long) ((j2 - f12072d) * e.b());
    }

    public static long e(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e2) {
                b.d("MediaMetadataRetriever exception " + e2, new Object[0]);
                mediaMetadataRetriever.release();
                return 0L;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static us.pinguo.svideo.recorder.b f(Context context, us.pinguo.svideo.c.a aVar, String str) {
        return new us.pinguo.svideo.recorder.d(context.getApplicationContext(), str, aVar);
    }

    public static final boolean g() {
        Locale locale = Locale.getDefault();
        return locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE);
    }

    public static void h(long j2) {
        if (c) {
            c = false;
            f12072d = j2;
        }
        long d2 = d(j2);
        PrintStream printStream = System.out;
        printStream.println("Video UTSTime at: " + d2);
        if (Build.VERSION.SDK_INT >= 18) {
            EGLExt.eglPresentationTimeANDROID(EGL14.eglGetDisplay(0), EGL14.eglGetCurrentSurface(12377), d2);
            a("eglPresentationTimeANDROID", false);
        }
    }
}
