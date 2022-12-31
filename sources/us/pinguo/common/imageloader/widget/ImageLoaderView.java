package us.pinguo.common.imageloader.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.c;
/* loaded from: classes4.dex */
public class ImageLoaderView extends ImageView {
    private c a;
    private ImageLoader b;
    private com.nostra13.universalimageloader.core.k.a c;

    /* loaded from: classes4.dex */
    class a implements com.nostra13.universalimageloader.core.k.a {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if ((view instanceof ImageView) && ImageLoaderView.this.b.n((ImageView) view).contains(str)) {
                ImageLoaderView.this.setImageUrl(this.a);
            }
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    public ImageLoaderView(Context context) {
        super(context);
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        this.a = bVar.t();
        this.b = ImageLoader.getInstance();
    }

    public void setCacheInMemory(boolean z) {
        if (this.a.F() || z) {
            c.b bVar = new c.b();
            bVar.w(this.a);
            bVar.u(z);
            this.a = bVar.t();
        }
    }

    public void setCacheOnDisK(boolean z) {
        if (this.a.F() || z) {
            c.b bVar = new c.b();
            bVar.w(this.a);
            bVar.v(z);
            this.a = bVar.t();
        }
    }

    public void setDefaultImage(int i2) {
        c.b bVar = new c.b();
        bVar.w(this.a);
        bVar.I(i2);
        bVar.E(i2);
        bVar.G(i2);
        this.a = bVar.t();
    }

    public void setImageLoadingListener(com.nostra13.universalimageloader.core.k.a aVar) {
        this.c = aVar;
    }

    public void setImageUrl(String str) {
        this.b.a(this);
        if (str == null) {
            str = "";
        }
        this.b.g(str, this, this.a, this.c);
    }

    public void setOptions(c cVar) {
        this.a = cVar;
    }

    public void setImageUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            setImageUrl(str);
            return;
        }
        this.b.a(this);
        this.b.g(str, this, this.a, new a(str2));
    }

    public ImageLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        this.a = bVar.t();
        this.b = ImageLoader.getInstance();
    }

    public ImageLoaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        this.a = bVar.t();
        this.b = ImageLoader.getInstance();
    }
}
