package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import javax.annotation.Nullable;
@com.facebook.soloader.d
/* loaded from: classes.dex */
class PreverificationHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    @com.facebook.soloader.d
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(@Nullable Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
