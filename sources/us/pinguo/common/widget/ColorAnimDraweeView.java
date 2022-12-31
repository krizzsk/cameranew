package us.pinguo.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.common.utils.j;
/* loaded from: classes4.dex */
public class ColorAnimDraweeView extends SimpleDraweeView implements f {

    /* renamed from: i  reason: collision with root package name */
    private int f9948i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9949j;

    /* loaded from: classes4.dex */
    class a extends com.facebook.drawee.controller.b<Object> {
        a(ColorAnimDraweeView colorAnimDraweeView) {
        }

        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void d(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    public ColorAnimDraweeView(Context context) {
        super(context);
        this.f9948i = -1;
        this.f9949j = false;
    }

    @Override // us.pinguo.common.widget.f
    public View getView() {
        return this;
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView
    public void setImageURI(Uri uri, Object obj) {
        this.f9949j = uri != null;
        com.facebook.drawee.backends.pipeline.e a2 = com.facebook.drawee.backends.pipeline.c.h().a(uri);
        a2.A(new a(this));
        setController(a2.build());
    }

    @Override // us.pinguo.common.widget.f
    public void setTheme(Resources.Theme theme) {
        int i2;
        if (this.f9949j || (i2 = this.f9948i) == -1) {
            return;
        }
        j.b(this, theme, i2);
    }

    public ColorAnimDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9948i = -1;
        this.f9949j = false;
        this.f9948i = j.f(attributeSet);
    }

    public ColorAnimDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9948i = -1;
        this.f9949j = false;
        this.f9948i = j.f(attributeSet);
    }
}
