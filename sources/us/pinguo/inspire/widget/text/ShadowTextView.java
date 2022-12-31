package us.pinguo.inspire.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import us.pinguo.foundation.t.b.a;
/* loaded from: classes9.dex */
public class ShadowTextView extends AppCompatTextView {
    public ShadowTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setShadowLayer(a.b(getResources(), 2.0f), 0.0f, 0.0f, -1627389952);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShadowTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
