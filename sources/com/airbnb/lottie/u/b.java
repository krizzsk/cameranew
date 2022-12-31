package com.airbnb.lottie.u;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.w.d;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f569e = new Object();
    private final Context a;
    private String b;
    @Nullable
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, h> f570d;

    public b(Drawable.Callback callback, String str, c cVar, Map<String, h> map) {
        String str2;
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.b.charAt(str2.length() - 1) != '/') {
                this.b += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f570d = new HashMap();
            this.a = null;
            return;
        }
        this.a = ((View) callback).getContext();
        this.f570d = map;
        d(cVar);
    }

    private Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f569e) {
            this.f570d.get(str).f(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        h hVar = this.f570d.get(str);
        if (hVar == null) {
            return null;
        }
        Bitmap a = hVar.a();
        if (a != null) {
            return a;
        }
        c cVar = this.c;
        if (cVar != null) {
            Bitmap a2 = cVar.a(hVar);
            if (a2 != null) {
                c(str, a2);
            }
            return a2;
        }
        String b = hVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b.startsWith("data:") && b.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                c(str, decodeByteArray);
                return decodeByteArray;
            } catch (IllegalArgumentException e2) {
                d.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.b)) {
                AssetManager assets = this.a.getAssets();
                Bitmap l2 = com.airbnb.lottie.w.h.l(BitmapFactory.decodeStream(assets.open(this.b + b), null, options), hVar.e(), hVar.c());
                c(str, l2);
                return l2;
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            d.d("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public void d(@Nullable c cVar) {
        this.c = cVar;
    }
}
