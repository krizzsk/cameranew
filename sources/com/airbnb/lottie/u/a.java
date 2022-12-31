package com.airbnb.lottie.u;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.g;
import com.airbnb.lottie.w.d;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f566d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.airbnb.lottie.b f567e;
    private final g<String> a = new g<>();
    private final Map<g<String>, Typeface> b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f568f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f566d = null;
            return;
        }
        this.f566d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.b bVar = this.f567e;
        if (bVar != null) {
            bVar.a(str);
            throw null;
        } else if (bVar != null) {
            bVar.b(str);
            throw null;
        } else {
            Typeface createFromAsset = Typeface.createFromAsset(this.f566d, "fonts/" + str + this.f568f);
            this.c.put(str, createFromAsset);
            return createFromAsset;
        }
    }

    private Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.b.put(this.a, d2);
        return d2;
    }

    public void c(@Nullable com.airbnb.lottie.b bVar) {
    }
}
