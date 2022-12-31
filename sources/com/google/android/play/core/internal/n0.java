package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;
/* loaded from: classes2.dex */
final class n0 implements b0 {
    @Override // com.google.android.play.core.internal.b0
    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) t0.b(Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
