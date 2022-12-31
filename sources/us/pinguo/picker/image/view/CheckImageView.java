package us.pinguo.picker.image.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: CheckImageView.kt */
/* loaded from: classes5.dex */
public final class CheckImageView extends AppCompatImageView {
    private boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckImageView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    public final boolean a() {
        return this.a;
    }

    public final void setChecked(boolean z) {
        this.a = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
    }
}
