package com.airbnb.lottie.w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.b.s;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class h {
    private static final PathMeasure a = new PathMeasure();
    private static final Path b = new Path();
    private static final Path c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private static final float[] f580d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    private static final float f581e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: f  reason: collision with root package name */
    private static float f582f = -1.0f;

    public static void a(Path path, float f2, float f3, float f4) {
        com.airbnb.lottie.d.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.airbnb.lottie.d.b("applyTrimPathIfNeeded");
        } else if (length >= 1.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = g.f(min, length);
                max = g.f(max, length);
            }
            if (min < 0.0f) {
                min = g.f(min, length);
            }
            if (max < 0.0f) {
                max = g.f(max, length);
            }
            int i2 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i2 == 0) {
                path.reset();
                com.airbnb.lottie.d.b("applyTrimPathIfNeeded");
                return;
            }
            if (i2 >= 0) {
                min -= length;
            }
            Path path2 = b;
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                Path path3 = c;
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                Path path4 = c;
                path4.reset();
                pathMeasure.getSegment(min + length, length, path4, true);
                path2.addPath(path4);
            }
            path.set(path2);
            com.airbnb.lottie.d.b("applyTrimPathIfNeeded");
        } else {
            com.airbnb.lottie.d.b("applyTrimPathIfNeeded");
        }
    }

    public static void b(Path path, @Nullable s sVar) {
        if (sVar == null || sVar.j()) {
            return;
        }
        a(path, ((com.airbnb.lottie.t.c.c) sVar.h()).o() / 100.0f, ((com.airbnb.lottie.t.c.c) sVar.d()).o() / 100.0f, ((com.airbnb.lottie.t.c.c) sVar.f()).o() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f2 = pointF.x;
            float f3 = pointF2.x;
            float f4 = pointF2.y;
            path.cubicTo(pointF3.x + f2, pointF.y + pointF3.y, f3 + pointF4.x, f4 + pointF4.y, f3, f4);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float e() {
        if (f582f == -1.0f) {
            f582f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f582f;
    }

    public static float f(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = f580d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f581e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = f580d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int i(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    public static boolean j(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    public static boolean k(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static Bitmap l(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void m(Canvas canvas, RectF rectF, Paint paint) {
        n(canvas, rectF, paint, 31);
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint, int i2) {
        com.airbnb.lottie.d.a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i2);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.airbnb.lottie.d.b("Utils#saveLayer");
    }
}
