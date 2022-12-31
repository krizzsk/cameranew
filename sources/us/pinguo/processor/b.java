package us.pinguo.processor;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import android.util.Size;
import androidx.work.Data;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.s;
/* compiled from: GLTextureUtils.kt */
/* loaded from: classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public static final int a(Bitmap bitmap, int i2, boolean z) {
        s.h(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return 0;
        }
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        if (z) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            s.g(bitmap, "createBitmap(bitmapNew, …New.height, matrix, true)");
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        return i2;
    }

    public static /* synthetic */ int b(Bitmap bitmap, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(bitmap, i2, z);
    }

    public static final int c() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public static final void d(int i2) {
        if (i2 == 0) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
    }

    public static final Bitmap e(int i2, Size size, boolean z) {
        s.h(size, "size");
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        int i3 = iArr[0];
        Log.d("texture2DToBitmap", s.q("oldFrameBuffer=", Integer.valueOf(i3)));
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i4 = iArr[0];
        Log.d("texture2DToBitmap", s.q("newFrameBuffer=", Integer.valueOf(i4)));
        GLES20.glBindFramebuffer(36160, i4);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        int width = size.getWidth();
        int height = size.getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.position(0);
        GLES20.glReadPixels(0, 0, width, height, 6408, 5121, allocateDirect);
        int[] iArr2 = new int[1];
        for (int i5 = 0; i5 < 1; i5++) {
            iArr2[i5] = i4;
        }
        GLES20.glDeleteFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, i3);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(allocateDirect);
        if (z) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            bitmap = createBitmap;
        }
        Log.d("texture2DToBitmap", "finish:" + bitmap.getWidth() + 'x' + bitmap.getHeight());
        s.g(bitmap, "bitmap");
        return bitmap;
    }

    public static final byte[] f(int i2, Size size, boolean z) {
        s.h(size, "size");
        Bitmap e2 = e(i2, size, z);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        e2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        s.g(byteArray, "byteArrayOutputStream.toByteArray()");
        return byteArray;
    }
}
