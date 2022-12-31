package com.facebook.core.internal.logging.dumpsys;

import android.content.res.Resources;
import androidx.annotation.Nullable;
/* compiled from: ResourcesUtil.java */
/* loaded from: classes.dex */
class b {
    private static String a(int i2) {
        return "#" + Integer.toHexString(i2);
    }

    public static String b(@Nullable Resources resources, int i2) throws Resources.NotFoundException {
        String str;
        if (resources == null) {
            return a(i2);
        }
        String str2 = "";
        if (d(i2) != 127) {
            str2 = resources.getResourcePackageName(i2);
            str = ":";
        } else {
            str = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i2);
        String resourceEntryName = resources.getResourceEntryName(i2);
        StringBuilder sb = new StringBuilder(str2.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(str2);
        sb.append(str);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        return sb.toString();
    }

    public static String c(Object obj, @Nullable Resources resources, int i2) {
        try {
            return b(resources, i2);
        } catch (Resources.NotFoundException unused) {
            return a(i2);
        }
    }

    private static int d(int i2) {
        return (i2 >>> 24) & 255;
    }
}
