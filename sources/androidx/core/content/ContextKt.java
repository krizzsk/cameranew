package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Context.kt */
/* loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        s.h(context, "<this>");
        s.n(4, "T");
        throw null;
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] attrs, @AttrRes int i2, @StyleRes int i3, l<? super TypedArray, u> block) {
        s.h(context, "<this>");
        s.h(attrs, "attrs");
        s.h(block, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i2, i3);
        s.g(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] attrs, int i2, int i3, l block, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attributeSet = null;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        s.h(context, "<this>");
        s.h(attrs, "attrs");
        s.h(block, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i2, i3);
        s.g(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, @StyleRes int i2, int[] attrs, l<? super TypedArray, u> block) {
        s.h(context, "<this>");
        s.h(attrs, "attrs");
        s.h(block, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, attrs);
        s.g(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
