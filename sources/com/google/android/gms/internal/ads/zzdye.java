package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdye implements FilenameFilter {
    private final Pattern zzhlm;

    public zzdye(Pattern pattern) {
        this.zzhlm = (Pattern) zzdwl.checkNotNull(pattern);
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(@NullableDecl File file, String str) {
        return this.zzhlm.matcher(str).matches();
    }
}
