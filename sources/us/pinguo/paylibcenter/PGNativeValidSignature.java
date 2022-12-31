package us.pinguo.paylibcenter;

import android.content.Context;
/* loaded from: classes5.dex */
public class PGNativeValidSignature {
    static {
        System.loadLibrary("signature");
    }

    public static final native String getGooglePlayPublicKey(Context context);

    public static final native boolean isAppSignatureValid(Context context);
}
