package us.pinguo.libdeepretouch;

import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class DeepRetouch {
    static {
        System.loadLibrary("DeepRetouch");
    }

    public static native void clear();

    public static native void init(String str, String str2, String str3, boolean z);

    public static void testSaveTemp(byte[] bArr, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        File file = new File("/sdcard/Camera360/retouch.jpg");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
