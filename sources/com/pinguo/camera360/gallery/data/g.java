package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.Cursor;
import com.pinguo.camera360.gallery.data.y;
import java.util.ArrayList;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.entity.Photo;
/* compiled from: BigAlbumGallery.java */
/* loaded from: classes3.dex */
public class g extends b {
    public static final String[] p = {"width", "height", "createDate", "orientation"};

    /* renamed from: i  reason: collision with root package name */
    private final e f6353i;

    /* renamed from: j  reason: collision with root package name */
    private int f6354j;

    /* renamed from: k  reason: collision with root package name */
    private final String[] f6355k;

    /* renamed from: l  reason: collision with root package name */
    private final String f6356l;
    private final String m;
    private final String n;
    private long o;

    public g(Application application, Path path, String str) {
        super(application, path, x.j());
        this.f6354j = -1;
        this.n = str;
        this.f6355k = h.w;
        this.f6356l = "_id in  (SELECT photoID FROM galleryPhotoRelation WHERE galleryID = ?)";
        this.m = "createDate DESC ";
        this.f6353i = new e(this, application);
    }

    @Override // com.pinguo.camera360.gallery.data.b
    public void K(w wVar) {
        int i2;
        if (!(wVar instanceof h) || wVar.l() || wVar.g() == null) {
            return;
        }
        try {
            i2 = Integer.parseInt(wVar.g().f());
        } catch (NumberFormatException unused) {
            i2 = -1;
        }
        if (i2 >= 0) {
            BigAlbumManager.instance().deletePhoto(i2);
        }
    }

    public long[] L() {
        long[] jArr = new long[2];
        Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(new String[]{"max(createDate)", "min(createDate)"}, this.f6356l, new String[]{String.valueOf(this.b.f())}, null, null, null);
        if (queryPhoto != null) {
            try {
                queryPhoto.moveToFirst();
                jArr[0] = queryPhoto.getLong(0);
                jArr[1] = queryPhoto.getLong(1);
            } finally {
                if (queryPhoto != null) {
                    queryPhoto.close();
                }
            }
        }
        if (jArr[0] == 0 && jArr[1] == 0) {
            long j2 = this.o;
            jArr[0] = j2;
            jArr[1] = j2;
        }
        return jArr;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void c(boolean z) {
        com.pinguo.album.j.c.a();
        try {
            BigAlbumManager.instance().deleteGallery(Integer.parseInt(this.b.f()));
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void i(ArrayList<Integer> arrayList) {
        BigAlbumManager.instance().addPhotoToGallery(Integer.parseInt(this.b.f()), arrayList);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int l(ArrayList<y.c> arrayList) {
        String str = this.f6356l;
        if (str == null) {
            str = "1=1";
        }
        BigAlbumManager instance = BigAlbumManager.instance();
        String[] strArr = {"createDate", "count(*)"};
        String[] strArr2 = {String.valueOf(this.b.f())};
        return C(arrayList, instance.queryPhoto(strArr, str, strArr2, "((createDate+" + b.f6333h + ")/86400000)", null, this.m), 0, 1);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int m(ArrayList<y.c> arrayList, ArrayList<y.b> arrayList2) {
        Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(p, this.f6356l, new String[]{String.valueOf(this.b.f())}, null, null, this.m);
        if (queryPhoto == null) {
            return 0;
        }
        return G(arrayList, arrayList2, queryPhoto, 2, 0, 1, 3);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int n(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2) {
        String str = this.f6356l;
        if (str == null) {
            str = "1=1";
        }
        String[] strArr = {String.valueOf(this.b.f())};
        int C = C(arrayList, BigAlbumManager.instance().queryPhoto(new String[]{"createDate", "count(*)"}, str, strArr, "((createDate+" + b.f6333h + ")/86400000)", null, this.m), 0, 1);
        E(arrayList, arrayList2, C);
        return C;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public w o() {
        Photo galleryCoverPhoto = BigAlbumManager.instance().getGalleryCoverPhoto(Integer.parseInt(this.b.f()));
        if (galleryCoverPhoto != null) {
            Application application = this.f6334f;
            Path path = new Path(1205, String.valueOf(galleryCoverPhoto.id));
            path.k(Integer.parseInt(this.b.f()));
            return new h(application, path);
        }
        return super.o();
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<m> p(int i2, int i3) {
        ArrayList<m> arrayList = new ArrayList<>();
        com.pinguo.album.j.c.a();
        BigAlbumManager instance = BigAlbumManager.instance();
        String[] strArr = h.x;
        String str = this.f6356l;
        String[] strArr2 = {String.valueOf(this.b.f())};
        Cursor queryPhoto = instance.queryPhoto(strArr, str, strArr2, null, null, this.m + " limit " + i2 + "," + i3);
        if (queryPhoto == null) {
            us.pinguo.common.log.a.s("query fail", new Object[0]);
            return arrayList;
        }
        while (queryPhoto.moveToNext()) {
            try {
                Path path = new Path(1205, String.valueOf(queryPhoto.getInt(0)));
                path.k(Integer.parseInt(this.b.f()));
                arrayList.add(new m(path, queryPhoto.getLong(1)));
            } finally {
                queryPhoto.close();
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<w> q(int i2, int i3) {
        ArrayList<w> arrayList = new ArrayList<>();
        com.pinguo.album.j.c.a();
        BigAlbumManager instance = BigAlbumManager.instance();
        String[] strArr = this.f6355k;
        String str = this.f6356l;
        String[] strArr2 = {String.valueOf(this.b.f())};
        Cursor queryPhoto = instance.queryPhoto(strArr, str, strArr2, null, null, this.m + " limit " + i2 + "," + i3);
        if (queryPhoto == null) {
            us.pinguo.common.log.a.s("query fail", new Object[0]);
            return arrayList;
        }
        while (queryPhoto.moveToNext()) {
            try {
                Application application = this.f6334f;
                Path path = new Path(1205, String.valueOf(queryPhoto.getInt(0)));
                path.k(Integer.parseInt(this.b.f()));
                arrayList.add(new h(application, path, queryPhoto));
            } finally {
                queryPhoto.close();
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int r() {
        if (this.f6354j == -1) {
            Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(b.f6332g, this.f6356l, new String[]{String.valueOf(this.b.f())}, null, null, null);
            if (queryPhoto == null) {
                us.pinguo.common.log.a.s("query fail", new Object[0]);
                return 0;
            }
            try {
                com.pinguo.album.j.a.a(queryPhoto.moveToNext());
                this.f6354j = queryPhoto.getInt(0);
            } finally {
                queryPhoto.close();
            }
        }
        return this.f6354j;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        return this.n;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public long x() {
        if (this.f6353i.a()) {
            this.a = x.j();
            this.f6354j = -1;
        }
        return this.a;
    }

    public g(Application application, Path path, String str, long j2) {
        this(application, path, str);
        this.o = j2;
    }
}
