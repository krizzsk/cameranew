package com.pinguo.camera360.test;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class o0 implements FilenameFilter {
    public static final /* synthetic */ o0 a = new o0();

    private /* synthetic */ o0() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        boolean N0;
        N0 = UnityImportActivity.N0(file, str);
        return N0;
    }
}
