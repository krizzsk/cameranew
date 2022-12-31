package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.Cursor;
import com.pinguo.camera360.gallery.data.y;
import java.util.ArrayList;
import us.pinguo.bigalbum.BigAlbumManager;
/* compiled from: BigAlbumDefault.java */
/* loaded from: classes3.dex */
public class f extends b {
    public static final String[] o = {"width", "height", "createDate", "orientation"};

    /* renamed from: i  reason: collision with root package name */
    private final e f6349i;

    /* renamed from: j  reason: collision with root package name */
    private int f6350j;

    /* renamed from: k  reason: collision with root package name */
    private final String[] f6351k;

    /* renamed from: l  reason: collision with root package name */
    protected String f6352l;
    private String[] m;
    protected String n;

    public f(Application application, Path path) {
        super(application, path, x.j());
        this.f6350j = -1;
        this.f6351k = h.w;
        this.f6352l = M();
        this.m = L();
        this.n = "createDate DESC ";
        this.f6349i = new e(this, application, "photo");
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public void A() {
        this.f6352l = "";
        this.m = null;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public void B(long j2, long j3) {
        this.f6352l = "createDate between " + j2 + " and " + j3;
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

    protected String[] L() {
        return new String[]{"C360%"};
    }

    protected String M() {
        return "name like?";
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int l(ArrayList<y.c> arrayList) {
        String str = this.f6352l;
        if (str == null) {
            str = "1=1";
        }
        String str2 = str;
        String[] strArr = this.m;
        return C(arrayList, BigAlbumManager.instance().queryPhoto(new String[]{"createDate", "count(*)"}, str2, strArr, "((createDate+" + b.f6333h + ")/86400000)", null, this.n), 0, 1);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int m(ArrayList<y.c> arrayList, ArrayList<y.b> arrayList2) {
        Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(o, this.f6352l, this.m, null, null, this.n);
        if (queryPhoto == null) {
            return 0;
        }
        return G(arrayList, arrayList2, queryPhoto, 2, 0, 1, 3);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int n(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2) {
        String str = this.f6352l;
        if (str == null) {
            str = "1=1";
        }
        String str2 = str;
        String[] strArr = this.m;
        int C = C(arrayList, BigAlbumManager.instance().queryPhoto(new String[]{"createDate", "count(*)"}, str2, strArr, "((createDate+" + b.f6333h + ")/86400000)", null, this.n), 0, 1);
        E(arrayList, arrayList2, C);
        return C;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<m> p(int i2, int i3) {
        ArrayList<m> arrayList = new ArrayList<>();
        com.pinguo.album.j.c.a();
        BigAlbumManager instance = BigAlbumManager.instance();
        String[] strArr = h.x;
        String str = this.f6352l;
        String[] strArr2 = this.m;
        Cursor queryPhoto = instance.queryPhoto(strArr, str, strArr2, null, null, this.n + " limit " + i2 + "," + i3);
        if (queryPhoto == null) {
            us.pinguo.common.log.a.s("query fail", new Object[0]);
            return arrayList;
        }
        while (queryPhoto.moveToNext()) {
            try {
                arrayList.add(new m(new Path(1204, String.valueOf(queryPhoto.getInt(0))), queryPhoto.getLong(1)));
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
        String[] strArr = this.f6351k;
        String str = this.f6352l;
        String[] strArr2 = this.m;
        Cursor queryPhoto = instance.queryPhoto(strArr, str, strArr2, null, null, this.n + " limit " + i2 + "," + i3);
        if (queryPhoto == null) {
            us.pinguo.common.log.a.s("query fail", new Object[0]);
            return arrayList;
        }
        while (queryPhoto.moveToNext()) {
            try {
                try {
                    arrayList.add(new h(this.f6334f, new Path(1204, String.valueOf(queryPhoto.getInt(0))), queryPhoto));
                } catch (Exception e2) {
                    queryPhoto.close();
                    e2.printStackTrace();
                }
            } finally {
                queryPhoto.close();
            }
        }
        queryPhoto.close();
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int r() {
        if (this.f6350j == -1) {
            Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(b.f6332g, this.f6352l, this.m, null, null, null);
            if (queryPhoto == null) {
                us.pinguo.common.log.a.s("query fail", new Object[0]);
                return 0;
            }
            try {
                try {
                    com.pinguo.album.j.a.a(queryPhoto.moveToNext());
                    this.f6350j = queryPhoto.getInt(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                queryPhoto.close();
            }
        }
        return this.f6350j;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public long x() {
        if (this.f6349i.a()) {
            this.a = x.j();
            this.f6350j = -1;
        }
        return this.a;
    }
}
