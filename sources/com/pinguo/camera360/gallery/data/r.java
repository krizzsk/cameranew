package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.pinguo.camera360.gallery.data.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.foundation.utils.p0;
/* compiled from: LocalAlbum.java */
/* loaded from: classes3.dex */
public class r extends b {
    private static final String[] q = {"bucket_id"};

    /* renamed from: i  reason: collision with root package name */
    private final String f6375i;

    /* renamed from: j  reason: collision with root package name */
    private final Uri f6376j;

    /* renamed from: k  reason: collision with root package name */
    private final String[] f6377k;

    /* renamed from: l  reason: collision with root package name */
    private final ContentResolver f6378l;
    private final String m;
    private final l n;
    private int o;
    private final boolean p;

    public r(Application application, Path path, String str, boolean z) {
        super(application, path, x.j());
        this.o = -1;
        this.f6378l = application.getContentResolver();
        this.m = str;
        this.p = z;
        if (z) {
            this.f6375i = "datetaken DESC, _id DESC";
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            this.f6376j = uri;
            this.f6377k = s.v;
            this.n = new l(this, uri, application);
            return;
        }
        this.f6375i = "datetaken DESC, _id DESC";
        Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        this.f6376j = uri2;
        this.f6377k = u.v;
        this.n = new l(this, uri2, application);
    }

    private Cursor L() {
        if (this.p) {
            return this.f6378l.query(this.f6376j, new String[]{"datetaken", "bucket_id", "count(bucket_id)"}, N(), M(), this.f6375i);
        }
        return this.f6378l.query(this.f6376j, new String[]{"datetaken", "bucket_id", "bucket_display_name"}, N(), M(), this.f6375i);
    }

    @Override // com.pinguo.camera360.gallery.data.b
    public void K(w wVar) {
        String[] strArr = new String[2];
        if (this.p) {
            strArr[0] = "_data";
            strArr[1] = "datetaken";
        } else {
            strArr[0] = "_data";
            strArr[1] = "datetaken";
        }
        Cursor query = this.f6378l.query(this.f6376j, strArr, N(), M(), this.f6375i);
        if (query == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                if (!new File(query.getString(0)).exists()) {
                    arrayList.add(String.valueOf(query.getLong(1)));
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        StringBuilder sb = new StringBuilder();
        if (!arrayList.isEmpty()) {
            if (this.p) {
                sb.append("datetaken");
                sb.append(" in(");
            } else {
                sb.append("datetaken");
                sb.append(" in(");
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(",");
            }
        }
        if (sb.lastIndexOf(",") > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            this.f6378l.delete(this.f6376j, sb.toString(), null);
        }
    }

    protected String[] M() {
        return TextUtils.isEmpty(this.b.f()) ? new String[0] : new String[]{String.valueOf(this.b.f())};
    }

    protected String N() {
        boolean z = this.p;
        return TextUtils.isEmpty(this.b.f()) ? "1 = 1" : "bucket_id = ?";
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void c(boolean z) {
        com.pinguo.album.j.c.a();
        w o = o();
        if (o != null && (o instanceof s)) {
            File file = new File(((s) o).p);
            File parentFile = file.getParentFile();
            us.pinguo.common.log.a.k("file isDirectory  =" + file.isDirectory() + "file.name = " + file.getName() + " parent name =" + parentFile.getName() + " parent.isDirec " + parentFile.isDirectory(), new Object[0]);
            com.pinguo.album.j.c.b(parentFile);
        }
        this.f6378l.delete(this.f6376j, N(), M());
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int l(ArrayList<y.c> arrayList) {
        return D(arrayList, L(), 0, 2);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int m(ArrayList<y.c> arrayList, ArrayList<y.b> arrayList2) {
        return super.m(arrayList, arrayList2);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int n(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2) {
        int D = D(arrayList, L(), 0, 2);
        E(arrayList, arrayList2, D);
        return D;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<m> p(int i2, int i3) {
        m mVar;
        Uri.Builder buildUpon = this.f6376j.buildUpon();
        Uri build = buildUpon.appendQueryParameter("limit", i2 + "," + i3).build();
        ArrayList<m> arrayList = new ArrayList<>();
        com.pinguo.album.j.c.a();
        Cursor query = this.f6378l.query(build, this.f6377k, N(), M(), this.f6375i);
        if (query == null) {
            us.pinguo.common.log.a.s("query fail: " + build, new Object[0]);
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                if (this.p) {
                    long j2 = query.getLong(5);
                    Path path = new Path(CloseFrame.NOCODE, query.getString(8));
                    path.l(j2);
                    mVar = new m(path, j2);
                } else {
                    long j3 = query.getLong(5);
                    Path path2 = new Path(1101, query.getString(8));
                    path2.l(j3);
                    mVar = new m(path2, j3);
                }
                arrayList.add(mVar);
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<w> q(int i2, int i3) {
        Cursor query;
        w uVar;
        ArrayList<w> arrayList = new ArrayList<>();
        com.pinguo.album.j.c.a();
        if (p0.b(this)) {
            Bundle bundle = new Bundle();
            bundle.putInt("android:query-arg-offset", i2);
            bundle.putInt("android:query-arg-limit", i3);
            bundle.putString("android:query-arg-sql-sort-order", this.f6375i);
            bundle.putString("android:query-arg-sql-selection", N());
            bundle.putStringArray("android:query-arg-sql-selection-args", M());
            query = this.f6378l.query(this.f6376j, this.f6377k, bundle, null);
        } else {
            ContentResolver contentResolver = this.f6378l;
            Uri.Builder buildUpon = this.f6376j.buildUpon();
            query = contentResolver.query(buildUpon.appendQueryParameter("limit", i2 + "," + i3).build(), this.f6377k, N(), M(), this.f6375i);
        }
        if (query == null) {
            us.pinguo.common.log.a.s("query fail: " + this.f6376j, new Object[0]);
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                if (this.p) {
                    Application application = this.f6334f;
                    Path path = new Path(CloseFrame.NOCODE, query.getString(8));
                    path.l(query.getLong(5));
                    uVar = new s(application, path, query);
                } else {
                    Application application2 = this.f6334f;
                    Path path2 = new Path(1101, query.getString(8));
                    path2.l(query.getLong(5));
                    uVar = new u(application2, path2, query);
                }
                arrayList.add(uVar);
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int r() {
        if (this.o == -1) {
            Cursor query = this.f6378l.query(this.f6376j, q, N(), M(), null);
            if (query == null) {
                us.pinguo.common.log.a.s("query fail", new Object[0]);
                return 0;
            }
            try {
                this.o = query.getCount();
            } finally {
                query.close();
            }
        }
        return this.o;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        return this.m;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public long x() {
        if (this.n.a()) {
            this.a = x.j();
            this.o = -1;
        }
        return this.a;
    }
}
