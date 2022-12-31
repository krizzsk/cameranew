package us.pinguo.inspire.widget.fresco;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes9.dex */
public class BlurBgDraweeView extends PhotoDraweeView {
    private GaussianBlurDrawable m;

    public BlurBgDraweeView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public String getTransitionName() {
        return super.getTransitionName();
    }

    @Override // android.view.View
    public boolean isLaidOut() {
        return super.isLaidOut();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.fresco.PhotoDraweeView
    public void n() {
        super.n();
        this.m = new GaussianBlurDrawable();
        e().v(this.m);
    }

    public void setWebp(String str) {
        setWebp(str, true, null);
    }

    public void setWebpWithBlur(String str, int i2, int i3) {
        if (i2 / i3 > 1.0f) {
            e().u(p.c.c);
            this.m.r(true);
        } else {
            e().u(p.c.f2566g);
            this.m.r(false);
        }
        GaussianBlurDrawable gaussianBlurDrawable = this.m;
        gaussianBlurDrawable.s(str + "_" + i2 + "x" + i3);
        e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.A(this.m);
        e eVar = h2;
        eVar.C(d());
        e eVar2 = eVar;
        eVar2.y(false);
        setController(eVar2.L(str).build());
    }

    public BlurBgDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setWebp(String str, boolean z, com.facebook.drawee.controller.c cVar) {
        e().u(p.c.f2566g);
        this.m.r(false);
        ImageRequest a = ImageRequestBuilder.s(Uri.parse(str)).a();
        e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.C(d());
        e eVar = h2;
        eVar.A(cVar);
        e eVar2 = eVar;
        eVar2.y(z);
        e eVar3 = eVar2;
        eVar3.B(a);
        setController(eVar3.build());
    }

    public BlurBgDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
