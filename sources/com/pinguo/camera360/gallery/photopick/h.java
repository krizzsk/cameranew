package com.pinguo.camera360.gallery.photopick;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
/* compiled from: PhotoPickUtils.java */
/* loaded from: classes3.dex */
public class h {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        return i2 >= 100 && i3 >= 100 && i2 / i3 < 3 && i3 / i2 < 3;
    }
}
