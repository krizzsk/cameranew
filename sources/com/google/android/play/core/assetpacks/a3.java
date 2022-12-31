package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class a3 implements FilenameFilter {
    static final FilenameFilter a = new a3();

    private a3() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        boolean matches;
        matches = b3.a.matcher(str).matches();
        return matches;
    }
}
