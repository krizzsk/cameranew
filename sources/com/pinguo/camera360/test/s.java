package com.pinguo.camera360.test;

import java.io.File;
import java.io.FileFilter;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class s implements FileFilter {
    public static final /* synthetic */ s a = new s();

    private /* synthetic */ s() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        boolean p0;
        p0 = ExifTestActivity.p0(file);
        return p0;
    }
}
