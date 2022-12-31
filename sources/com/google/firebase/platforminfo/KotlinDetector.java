package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import kotlin.d;
/* loaded from: classes2.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    @Nullable
    public static String detectVersion() {
        try {
            return d.f8676e.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
