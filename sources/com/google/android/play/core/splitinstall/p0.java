package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes2.dex */
public final class p0 {
    private final Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static File b(Context context) {
        String string;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || (string = bundle.getString("local_testing_dir")) == null) {
                return null;
            }
            return new File(context.getExternalFilesDir(null), string);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final k0 a() {
        return k0.i(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context c() {
        return this.a;
    }
}
