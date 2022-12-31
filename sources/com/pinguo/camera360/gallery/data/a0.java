package com.pinguo.camera360.gallery.data;

import android.app.Application;
import com.pinguo.album.a;
import java.util.ArrayList;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: MergeAlbumSet.java */
/* loaded from: classes3.dex */
public class a0 extends d {
    private final e s;

    public a0(Application application, Path path) {
        super(application, path);
        this.s = new e(this, application, "photo");
    }

    @Override // com.pinguo.camera360.gallery.data.d
    protected ArrayList<y> C(a.c cVar) {
        ArrayList<y> C = super.C(cVar);
        y yVar = C.get(0);
        if (yVar != null && !(yVar instanceof p)) {
            C.add(0, new p(BaseApplication.e(), new Path(1302, "")));
        }
        return C;
    }

    @Override // com.pinguo.camera360.gallery.data.d
    protected boolean D() {
        return super.D() || this.s.a();
    }
}
