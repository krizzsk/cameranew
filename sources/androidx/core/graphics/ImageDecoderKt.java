package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ImageDecoder.kt */
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, u> action) {
        s.h(source, "<this>");
        s.h(action, "action");
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source2) {
                s.h(decoder, "decoder");
                s.h(info, "info");
                s.h(source2, "source");
                action.invoke(decoder, info, source2);
            }
        });
        s.g(decodeBitmap, "crossinline action: Imag…ction(info, source)\n    }");
        return decodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, final q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, u> action) {
        s.h(source, "<this>");
        s.h(action, "action");
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source2) {
                s.h(decoder, "decoder");
                s.h(info, "info");
                s.h(source2, "source");
                action.invoke(decoder, info, source2);
            }
        });
        s.g(decodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
        return decodeDrawable;
    }
}
