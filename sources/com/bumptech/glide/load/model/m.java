package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class m<T> implements k<Integer, T> {
    private final k<Uri, T> a;
    private final Resources b;

    public m(Context context, k<Uri, T> kVar) {
        this(context.getResources(), kVar);
    }

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: b */
    public com.bumptech.glide.load.g.c<T> a(Integer num, int i2, int i3) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            }
            uri = null;
        }
        if (uri != null) {
            return this.a.a(uri, i2, i3);
        }
        return null;
    }

    public m(Resources resources, k<Uri, T> kVar) {
        this.b = resources;
        this.a = kVar;
    }
}
