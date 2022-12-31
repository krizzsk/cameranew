package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes6.dex */
public class RoundRecImageView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private int f12190i;

    public RoundRecImageView(Context context) {
        super(context);
        this.f12190i = 0;
        g(context);
    }

    private void g(Context context) {
        this.f12190i = us.pinguo.foundation.t.b.a.a(context, 5.0f);
    }

    public void setImageUri(String str) {
        setBackgroundColor(getResources().getColor(17170445));
        e().E(RoundingParams.a(this.f12190i));
        setImageURI(str);
    }

    public void setRoundPx(int i2) {
        this.f12190i = i2;
    }

    public RoundRecImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12190i = 0;
        g(context);
    }

    public RoundRecImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12190i = 0;
        g(context);
    }
}
