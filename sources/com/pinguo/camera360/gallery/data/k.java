package com.pinguo.camera360.gallery.data;

import android.app.Application;
/* compiled from: C360VideoAlbum.java */
/* loaded from: classes3.dex */
public class k extends r {
    protected String r;

    public k(Application application, Path path) {
        super(application, path, "", false);
        this.r = "title like 'C360%' or title like 'getInstance%'";
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public void A() {
        this.r = "1=1";
    }

    @Override // com.pinguo.camera360.gallery.data.r
    protected String[] M() {
        return new String[0];
    }

    @Override // com.pinguo.camera360.gallery.data.r
    protected String N() {
        return this.r;
    }
}
