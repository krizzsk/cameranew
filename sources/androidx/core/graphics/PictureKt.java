package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Picture.kt */
/* loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i2, int i3, l<? super Canvas, u> block) {
        s.h(picture, "<this>");
        s.h(block, "block");
        Canvas beginRecording = picture.beginRecording(i2, i3);
        s.g(beginRecording, "beginRecording(width, height)");
        try {
            block.invoke(beginRecording);
            return picture;
        } finally {
            r.b(1);
            picture.endRecording();
            r.a(1);
        }
    }
}
