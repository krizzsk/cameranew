package com.pinguo.camera360.camera.options;

import java.io.File;
import java.io.FileFilter;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g0 implements FileFilter {
    public static final /* synthetic */ g0 a = new g0();

    private /* synthetic */ g0() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return OptionsSavePath.z0(file);
    }
}
