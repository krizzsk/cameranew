package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.facebook.common.internal.h;
import com.facebook.common.internal.k;
import com.facebook.common.util.d;
import com.facebook.drawee.R;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class SimpleDraweeView extends GenericDraweeView {

    /* renamed from: h  reason: collision with root package name */
    private static k<? extends AbstractDraweeControllerBuilder> f2607h;

    /* renamed from: g  reason: collision with root package name */
    private AbstractDraweeControllerBuilder f2608g;

    public SimpleDraweeView(Context context) {
        super(context);
        l(context, null);
    }

    private void l(Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                f().setVisible(true, false);
                f().invalidateSelf();
            } else {
                h.h(f2607h, "SimpleDraweeView was not initialized!");
                this.f2608g = f2607h.get();
            }
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleDraweeView);
                int i2 = R.styleable.SimpleDraweeView_actualImageUri;
                if (obtainStyledAttributes.hasValue(i2)) {
                    setImageURI(Uri.parse(obtainStyledAttributes.getString(i2)), (Object) null);
                } else {
                    int i3 = R.styleable.SimpleDraweeView_actualImageResource;
                    if (obtainStyledAttributes.hasValue(i3) && (resourceId = obtainStyledAttributes.getResourceId(i3, -1)) != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId);
                        } else {
                            setActualImageResource(resourceId);
                        }
                    }
                }
                obtainStyledAttributes.recycle();
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    public static void m(k<? extends AbstractDraweeControllerBuilder> kVar) {
        f2607h = kVar;
    }

    public void setActualImageResource(@DrawableRes int i2) {
        setActualImageResource(i2, null);
    }

    public void setImageRequest(ImageRequest imageRequest) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.f2608g;
        abstractDraweeControllerBuilder.B(imageRequest);
        abstractDraweeControllerBuilder.C(d());
        setController(abstractDraweeControllerBuilder.build());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setActualImageResource(@DrawableRes int i2, @Nullable Object obj) {
        setImageURI(d.e(i2), obj);
    }

    public void setImageURI(@Nullable String str) {
        setImageURI(str, (Object) null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(context, attributeSet);
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.f2608g;
        abstractDraweeControllerBuilder.z(obj);
        com.facebook.drawee.b.d a = abstractDraweeControllerBuilder.a(uri);
        a.b(d());
        setController(a.build());
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l(context, attributeSet);
    }

    public void setImageURI(@Nullable String str, @Nullable Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }
}
