package us.pinguo.foundation.t.a;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
/* compiled from: AnimBitmapDisplayer.java */
/* loaded from: classes4.dex */
public abstract class a implements com.nostra13.universalimageloader.core.i.a {
    protected boolean animateFromDisk;
    protected boolean animateFromMemory;
    protected boolean animateFromNetwork;
    protected int durationMillis;

    public a(int i2, boolean z, boolean z2, boolean z3) {
        this.durationMillis = i2;
        this.animateFromDisk = z2;
        this.animateFromMemory = z3;
        this.animateFromNetwork = z;
    }

    @Override // com.nostra13.universalimageloader.core.i.a
    public abstract void display(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom);
}
