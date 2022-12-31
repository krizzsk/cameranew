package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
/* compiled from: Icon.kt */
/* loaded from: classes.dex */
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        s.h(bitmap, "<this>");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        s.g(createWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        s.h(bitmap, "<this>");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        s.g(createWithBitmap, "createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        s.h(uri, "<this>");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        s.g(createWithContentUri, "createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        s.h(bArr, "<this>");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        s.g(createWithData, "createWithData(this, 0, size)");
        return createWithData;
    }
}
