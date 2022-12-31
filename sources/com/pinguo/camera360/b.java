package com.pinguo.camera360;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements FilenameFilter {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        boolean endsWith;
        endsWith = str.endsWith(".err");
        return endsWith;
    }
}
