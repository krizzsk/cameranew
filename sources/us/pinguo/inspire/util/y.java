package us.pinguo.inspire.util;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Pair;
import us.pinguo.inspire.Inspire;
/* compiled from: WorkUtil.java */
/* loaded from: classes9.dex */
public class y {
    public static String a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                return mediaMetadataRetriever.extractMetadata(9);
            } catch (Exception e2) {
                us.pinguo.common.log.a.e("MediaMetadataRetriever exception " + e2, new Object[0]);
                Inspire.f(e2);
                mediaMetadataRetriever.release();
                return "";
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String b(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                return mediaMetadataRetriever.extractMetadata(19);
            } catch (Exception e2) {
                us.pinguo.common.log.a.e("MediaMetadataRetriever exception " + e2, new Object[0]);
                Inspire.f(e2);
                mediaMetadataRetriever.release();
                return "";
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String c(String str, String str2) {
        Pair<Integer, Integer> a;
        Object obj;
        if (TextUtils.isEmpty(str2)) {
            return b(str);
        }
        String b = b(str);
        if (TextUtils.isEmpty(b)) {
            String f2 = f(str2);
            String b2 = b(str2);
            if (TextUtils.isEmpty(f2) || TextUtils.isEmpty(b2) || (a = us.pinguo.inspire_proxy.media.k.a(Integer.parseInt(f2), Integer.parseInt(b2))) == null || (obj = a.second) == null) {
                return null;
            }
            return String.valueOf(obj);
        }
        return b;
    }

    public static int d(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                if (!TextUtils.isEmpty(extractMetadata)) {
                    return Integer.parseInt(extractMetadata);
                }
            } catch (Exception e2) {
                Inspire.f(e2);
            }
            mediaMetadataRetriever.release();
            return 0;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static int e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return d(str);
        }
        if (!TextUtils.isEmpty(f(str))) {
            return d(str);
        }
        String f2 = f(str2);
        String b = b(str2);
        if (!TextUtils.isEmpty(f2) && !TextUtils.isEmpty(b)) {
            return d(str2);
        }
        return d(str);
    }

    public static String f(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                return mediaMetadataRetriever.extractMetadata(18);
            } catch (Exception e2) {
                Inspire.f(e2);
                us.pinguo.common.log.a.e("MediaMetadataRetriever exception " + e2, new Object[0]);
                mediaMetadataRetriever.release();
                return "";
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String g(String str, String str2) {
        Pair<Integer, Integer> a;
        Object obj;
        if (TextUtils.isEmpty(str2)) {
            return f(str);
        }
        String f2 = f(str);
        if (TextUtils.isEmpty(f2)) {
            String f3 = f(str2);
            String b = b(str2);
            if (TextUtils.isEmpty(f3) || TextUtils.isEmpty(b) || (a = us.pinguo.inspire_proxy.media.k.a(Integer.parseInt(f3), Integer.parseInt(b))) == null || (obj = a.first) == null) {
                return null;
            }
            return String.valueOf(obj);
        }
        return f2;
    }
}
