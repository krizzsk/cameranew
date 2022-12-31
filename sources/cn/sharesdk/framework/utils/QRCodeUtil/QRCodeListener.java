package cn.sharesdk.framework.utils.QRCodeUtil;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public interface QRCodeListener {
    void onError(Throwable th);

    void onSuccess(Bitmap bitmap);
}
