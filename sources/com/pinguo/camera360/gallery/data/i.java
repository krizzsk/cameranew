package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.Cursor;
import android.os.Handler;
import com.pinguo.album.a;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: BigAlbumSet.java */
/* loaded from: classes3.dex */
public class i extends y implements com.pinguo.album.d<ArrayList<y>> {
    public static final String[] o = {"_id", "name", BigAlbumStore.GalleryColumns.COVER_PHOTO_ID, "createDate"};

    /* renamed from: f  reason: collision with root package name */
    private boolean f6362f;

    /* renamed from: g  reason: collision with root package name */
    private com.pinguo.album.c<ArrayList<y>> f6363g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<y> f6364h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f6365i;

    /* renamed from: j  reason: collision with root package name */
    private final e f6366j;

    /* renamed from: k  reason: collision with root package name */
    private Application f6367k;

    /* renamed from: l  reason: collision with root package name */
    private int f6368l;
    private ArrayList<y> m;
    protected final String n;

    /* compiled from: BigAlbumSet.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.w();
        }
    }

    /* compiled from: BigAlbumSet.java */
    /* loaded from: classes3.dex */
    private class b implements a.b<ArrayList<y>> {
        private b() {
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public ArrayList<y> a(a.c cVar) {
            return i.this.D();
        }

        /* synthetic */ b(i iVar, a aVar) {
            this();
        }
    }

    public i(Application application, Path path) {
        super(path, x.j());
        this.f6368l = -1;
        this.m = new ArrayList<>();
        this.f6367k = application;
        this.f6366j = new e(this, application);
        this.f6365i = new Handler(application.getMainLooper());
        this.n = "isPreset = 0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<y> D() {
        Cursor queryGallery = BigAlbumManager.instance().queryGallery(o, this.n, null, null, null, "createDate DESC");
        if (queryGallery == null) {
            return this.m;
        }
        ArrayList<y> arrayList = new ArrayList<>();
        while (queryGallery.moveToNext()) {
            try {
                arrayList.add(new g(this.f6367k, new Path(1203, String.valueOf(queryGallery.getInt(0))), queryGallery.getString(1), queryGallery.getLong(3)));
            } finally {
                queryGallery.close();
            }
        }
        return arrayList;
    }

    public boolean E() {
        Cursor queryGallery = BigAlbumManager.instance().queryGallery(o, this.n, null, null, null, null);
        if (queryGallery == null) {
            return false;
        }
        try {
            if (queryGallery.moveToNext()) {
                return true;
            }
            return false;
        } finally {
            queryGallery.close();
        }
    }

    @Override // com.pinguo.album.d
    public synchronized void b(com.pinguo.album.c<ArrayList<y>> cVar) {
        if (this.f6363g != cVar) {
            return;
        }
        ArrayList<y> arrayList = cVar.get();
        this.f6364h = arrayList;
        this.f6362f = false;
        if (arrayList == null) {
            this.f6364h = new ArrayList<>();
        }
        this.f6365i.post(new a());
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<m> p(int i2, int i3) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<w> q(int i2, int i3) {
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int r() {
        this.f6368l = 0;
        Iterator<y> it = this.m.iterator();
        while (it.hasNext()) {
            this.f6368l += it.next().r();
        }
        return this.f6368l;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        return "path-big-album-def";
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public y t(int i2) {
        if (i2 < 0 || i2 >= this.m.size()) {
            return null;
        }
        return this.m.get(i2);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int u() {
        return this.m.size();
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public synchronized boolean v() {
        return this.f6362f;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public synchronized long x() {
        if (this.f6366j.a()) {
            com.pinguo.album.c<ArrayList<y>> cVar = this.f6363g;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f6362f = true;
            this.f6363g = com.pinguo.album.e.e().a().b(new b(this, null), this);
        }
        ArrayList<y> arrayList = this.f6364h;
        if (arrayList != null) {
            this.m = arrayList;
            this.f6364h = null;
            Iterator<y> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().x();
            }
            this.a = x.j();
        }
        return this.a;
    }
}
