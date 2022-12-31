package com.pinguo.lib;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements FilenameFilter {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return HardwareInfo.a(file, str);
    }
}
