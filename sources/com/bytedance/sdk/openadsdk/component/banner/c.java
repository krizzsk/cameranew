package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.h;
/* compiled from: BannerCellView.java */
/* loaded from: classes.dex */
class c extends FrameLayout {
    private ImageView a;
    private final Context b;
    private h c;

    public c(@NonNull Context context) {
        super(context);
        this.b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.b);
        this.a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.a.setImageBitmap(null);
        setOnClickListener(null);
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        this.c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }
}
