package us.pinguo.facedetector.e;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.s;
/* compiled from: ImageConvertUtils.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final byte[] a(Bitmap bitmap) {
        s.i(bitmap, "bitmap");
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        s.d(array, "byteBuffer.array()");
        return array;
    }
}
