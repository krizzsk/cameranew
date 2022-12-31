package com.google.android.gms.common.util;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class s {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
