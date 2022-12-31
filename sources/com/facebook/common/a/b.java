package com.facebook.common.a;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
/* compiled from: MimeTypeMapWrapper.java */
/* loaded from: classes.dex */
public class b {
    private static final MimeTypeMap a = MimeTypeMap.getSingleton();
    private static final Map<String, String> b = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    private static final Map<String, String> c = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");

    public static String a(String str) {
        String str2 = c.get(str);
        return str2 != null ? str2 : a.getMimeTypeFromExtension(str);
    }
}
