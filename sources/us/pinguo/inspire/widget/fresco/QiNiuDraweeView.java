package us.pinguo.inspire.widget.fresco;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes9.dex */
public class QiNiuDraweeView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private int f11357i;

    /* renamed from: j  reason: collision with root package name */
    private int f11358j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11359k;

    public QiNiuDraweeView(Context context) {
        super(context);
    }

    public void setImageSize(int i2, int i3) {
        this.f11357i = i2;
        this.f11358j = i3;
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView
    public void setImageURI(Uri uri, Object obj) {
        if (uri != null) {
            String uri2 = uri.toString();
            if (uri2 != null && uri2.startsWith("https")) {
                uri2 = uri2.replaceFirst("https", "http");
            }
            if (uri2.startsWith("http")) {
                uri = Uri.parse(PhotoImageView.addQiNiuSuffix(uri2, this.f11357i, this.f11358j, this.f11359k));
            }
        }
        super.setImageURI(uri, obj);
    }

    public void setVideoImageUrl(String str, int i2, int i3, int i4, int i5) {
        double d2;
        double d3;
        this.f11359k = true;
        if (i3 == 0 || i5 == 0) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            d2 = (i2 * 1.0d) / i3;
            d3 = (i4 * 1.0d) / i5;
        }
        if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i4 = 0;
            i5 = 0;
        } else if (d2 > d3) {
            i4 = (int) (d2 * i5);
        } else {
            i5 = (int) (i4 / d2);
        }
        if (i4 > 1 && i5 > 1 && i2 > 1 && i3 > 1) {
            setImageSize(i4, i5);
        } else {
            setImageSize(0, 0);
        }
        setImageURI(Uri.parse(str), (Object) null);
        this.f11359k = false;
    }

    public QiNiuDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QiNiuDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
