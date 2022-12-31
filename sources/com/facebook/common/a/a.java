package com.facebook.common.a;

import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: MediaUtils.java */
/* loaded from: classes.dex */
public class a {
    public static final Map<String, String> a = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");

    @Nullable
    private static String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    @Nullable
    public static String b(String str) {
        String a2 = a(str);
        if (a2 == null) {
            return null;
        }
        String lowerCase = a2.toLowerCase(Locale.US);
        String a3 = b.a(lowerCase);
        return a3 == null ? a.get(lowerCase) : a3;
    }

    public static boolean c(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }
}
