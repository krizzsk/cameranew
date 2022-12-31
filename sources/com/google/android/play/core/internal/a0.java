package com.google.android.play.core.internal;

import java.io.File;
/* loaded from: classes2.dex */
final class a0 implements b0 {
    @Override // com.google.android.play.core.internal.b0
    public final boolean a(Object obj, File file, File file2) {
        return new File((String) t0.c(obj.getClass(), String.class, File.class, file, File.class, file2)).exists();
    }
}
