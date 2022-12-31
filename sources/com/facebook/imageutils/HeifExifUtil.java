package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class HeifExifUtil {

    @com.facebook.soloader.d
    /* loaded from: classes.dex */
    private static class HeifExifUtilAndroidN {
        private HeifExifUtilAndroidN() {
        }

        @RequiresApi(api = 24)
        static int a(InputStream inputStream) {
            try {
                return new ExifInterface(inputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            } catch (IOException e2) {
                com.facebook.common.logging.a.c("HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", e2);
                return 0;
            }
        }
    }

    public static int a(InputStream inputStream) {
        if (Build.VERSION.SDK_INT >= 24) {
            return HeifExifUtilAndroidN.a(inputStream);
        }
        com.facebook.common.logging.a.b("HeifExifUtil", "Trying to read Heif Exif information before Android N -> ignoring");
        return 0;
    }
}
