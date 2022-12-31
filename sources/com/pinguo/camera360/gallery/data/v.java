package com.pinguo.camera360.gallery.data;

import android.annotation.SuppressLint;
import android.media.ExifInterface;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import vStudio.Android.Camera360.R;
/* compiled from: MediaDetails.java */
/* loaded from: classes3.dex */
public class v implements Iterable<Map.Entry<Integer, Object>> {
    private TreeMap<Integer, Object> a = new TreeMap<>();
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> b = new HashMap<>();

    /* compiled from: MediaDetails.java */
    /* loaded from: classes3.dex */
    public static class a {
        public a(int i2) {
        }
    }

    public static void b(v vVar, String str) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            d(vVar, exifInterface, androidx.exifinterface.media.ExifInterface.TAG_FLASH, 102);
            d(vVar, exifInterface, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 5);
            d(vVar, exifInterface, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, 6);
            d(vVar, exifInterface, androidx.exifinterface.media.ExifInterface.TAG_MAKE, 100);
            d(vVar, exifInterface, androidx.exifinterface.media.ExifInterface.TAG_MODEL, 101);
            d(vVar, exifInterface, androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE, 104);
            double attributeDouble = exifInterface.getAttributeDouble(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (attributeDouble != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                vVar.a(103, Double.valueOf(attributeDouble));
                vVar.e(103, R.string.unit_mm);
            }
        } catch (IOException e2) {
            us.pinguo.common.log.a.u("MediaDetails", "", e2);
        }
    }

    private static void d(v vVar, ExifInterface exifInterface, String str, int i2) {
        String attribute = exifInterface.getAttribute(str);
        if (attribute != null) {
            if (i2 == 102) {
                vVar.a(i2, new a(Integer.valueOf(attribute.toString()).intValue()));
            } else {
                vVar.a(i2, attribute);
            }
        }
    }

    public void a(int i2, Object obj) {
        this.a.put(Integer.valueOf(i2), obj);
    }

    public Object c(int i2) {
        return this.a.get(Integer.valueOf(i2));
    }

    public void e(int i2, int i3) {
        this.b.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Integer, Object>> iterator() {
        return this.a.entrySet().iterator();
    }
}
