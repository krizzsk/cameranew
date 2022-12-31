package us.pinguo.inspire.widget.fresco;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.p;
/* loaded from: classes9.dex */
public class PhotoDraweeView extends QiNiuDraweeView {

    /* renamed from: l  reason: collision with root package name */
    protected final Drawable f11356l;

    public PhotoDraweeView(Context context) {
        super(context);
        this.f11356l = new ColorDrawable(-2236963);
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        com.facebook.drawee.generic.a e2 = e();
        e2.u(p.c.f2566g);
        e2.C(this.f11356l);
        e2.x(400);
    }

    public void setImageURI(String str, int i2) {
        e().B(i2);
        setImageURI(str);
    }

    public PhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11356l = new ColorDrawable(-2236963);
        n();
    }

    public PhotoDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11356l = new ColorDrawable(-2236963);
        n();
    }
}
