package com.pinguo.album.opengles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* compiled from: ResourceTexture.java */
/* loaded from: classes3.dex */
public class r extends y {
    protected final Context t;
    protected final int u;

    public r(Context context, int i2) {
        this.t = context;
        this.u = i2;
        E(false);
    }

    @Override // com.pinguo.album.opengles.y
    protected void A(Bitmap bitmap) {
        if (a.j()) {
            return;
        }
        bitmap.recycle();
    }

    @Override // com.pinguo.album.opengles.y
    protected Bitmap B() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeResource(this.t.getResources(), this.u, options);
    }
}
