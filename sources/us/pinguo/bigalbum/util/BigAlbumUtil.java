package us.pinguo.bigalbum.util;

import android.database.Cursor;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class BigAlbumUtil {
    public static void closeCursorSilently(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Throwable unused) {
        }
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

    public static boolean hasField(Class<?> cls, String str) {
        try {
            cls.getDeclaredField(str);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }
}
