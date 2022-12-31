package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.Cursor;
import com.pinguo.camera360.gallery.data.y;
import java.util.ArrayList;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
/* compiled from: FavoriteAlbum.java */
/* loaded from: classes3.dex */
public class p extends f {
    public static final String[] p = {"width", "height", BigAlbumStore.PhotoColumns.FAV_TIME, "orientation"};

    public p(Application application, Path path) {
        super(application, path);
        this.n = "favTime DESC ";
    }

    @Override // com.pinguo.camera360.gallery.data.f
    protected String[] L() {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.f
    protected String M() {
        return "isFav = 1";
    }

    @Override // com.pinguo.camera360.gallery.data.f, com.pinguo.camera360.gallery.data.y
    public int m(ArrayList<y.c> arrayList, ArrayList<y.b> arrayList2) {
        Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(p, this.f6352l, null, null, null, this.n);
        if (queryPhoto == null) {
            return 0;
        }
        return G(arrayList, arrayList2, queryPhoto, 2, 0, 1, 3);
    }

    @Override // com.pinguo.camera360.gallery.data.f, com.pinguo.camera360.gallery.data.y
    public String s() {
        return BaseApplication.d().getResources().getString(R.string.favorite_title);
    }
}
