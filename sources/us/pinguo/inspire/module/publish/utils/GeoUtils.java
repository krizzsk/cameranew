package us.pinguo.inspire.module.publish.utils;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class GeoUtils {
    private static float getFloat(String[] strArr) {
        return Float.parseFloat(strArr[0]) / Float.parseFloat(strArr[1]);
    }

    public static float getFloatGeo(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1.0f;
        }
        String[] split = str.split(",");
        if (split.length == 3) {
            return getFloat(splitGeo(split[0])) + ((getFloat(splitGeo(split[1])) + (getFloat(splitGeo(split[2])) / 60.0f)) / 60.0f);
        } else if (split.length == 2) {
            return getFloat(splitGeo(split[0])) + (getFloat(splitGeo(split[1])) / 60.0f);
        } else {
            return getFloat(splitGeo(split[0]));
        }
    }

    private static String[] splitGeo(String str) {
        return str.split("/");
    }
}
