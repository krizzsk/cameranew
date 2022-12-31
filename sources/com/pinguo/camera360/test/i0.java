package com.pinguo.camera360.test;

import java.io.File;
import java.io.FileFilter;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i0 implements FileFilter {
    public static final /* synthetic */ i0 a = new i0();

    private /* synthetic */ i0() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return PhotoEditTestActivity.r0(file);
    }
}
