package com.pinguo.camera360.gallery.data;

import android.app.Application;
import com.pinguo.camera360.gallery.data.y;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import vStudio.Android.Camera360.R;
/* compiled from: MergeAlbum.java */
/* loaded from: classes3.dex */
public class z extends y implements n {

    /* renamed from: f  reason: collision with root package name */
    private final Comparator<w> f6400f;

    /* renamed from: g  reason: collision with root package name */
    private final Comparator<m> f6401g;

    /* renamed from: h  reason: collision with root package name */
    private final Comparator<y.c> f6402h;

    /* renamed from: i  reason: collision with root package name */
    private final y[] f6403i;

    /* renamed from: j  reason: collision with root package name */
    private c[] f6404j;

    /* renamed from: k  reason: collision with root package name */
    private int f6405k;

    /* renamed from: l  reason: collision with root package name */
    private TreeMap<Integer, int[]> f6406l;
    protected final Application m;

    /* compiled from: MergeAlbum.java */
    /* loaded from: classes3.dex */
    class a implements Comparator<m> {
        a(z zVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m mVar, m mVar2) {
            return -com.pinguo.album.j.a.g(mVar.b, mVar2.b);
        }
    }

    /* compiled from: MergeAlbum.java */
    /* loaded from: classes3.dex */
    class b implements Comparator<y.c> {
        b(z zVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(y.c cVar, y.c cVar2) {
            return Long.valueOf(cVar2.a - cVar.a).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MergeAlbum.java */
    /* loaded from: classes3.dex */
    public static class c {
        private y a;
        private SoftReference<ArrayList<w>> b;
        private int c;

        /* renamed from: e  reason: collision with root package name */
        private SoftReference<ArrayList<m>> f6408e;

        /* renamed from: f  reason: collision with root package name */
        private int f6409f;

        /* renamed from: d  reason: collision with root package name */
        private int f6407d = 64;

        /* renamed from: g  reason: collision with root package name */
        private int f6410g = 64;

        public c(y yVar) {
            this.a = yVar;
        }

        public w a(int i2) {
            return b(i2, 64);
        }

        public w b(int i2, int i3) {
            ArrayList<w> arrayList;
            int i4;
            SoftReference<ArrayList<w>> softReference = this.b;
            boolean z = true;
            if (softReference == null || i2 < (i4 = this.c) || i2 >= i4 + this.f6407d) {
                arrayList = null;
            } else {
                arrayList = softReference.get();
                if (arrayList != null) {
                    z = false;
                }
            }
            if (z) {
                arrayList = this.a.q(i2, i3);
                this.b = new SoftReference<>(arrayList);
                this.f6407d = i3;
                this.c = i2;
            }
            int i5 = this.c;
            if (i2 < i5 || i2 >= i5 + arrayList.size()) {
                return null;
            }
            return arrayList.get(i2 - this.c);
        }

        public m c(int i2, int i3) {
            ArrayList<m> arrayList;
            int i4;
            SoftReference<ArrayList<m>> softReference = this.f6408e;
            boolean z = true;
            if (softReference == null || i2 < (i4 = this.f6409f) || i2 >= i4 + this.f6410g) {
                arrayList = null;
            } else {
                arrayList = softReference.get();
                if (arrayList != null) {
                    z = false;
                }
            }
            if (z) {
                arrayList = this.a.p(i2, i3);
                this.f6408e = new SoftReference<>(arrayList);
                this.f6410g = i3;
                this.f6409f = i2;
            }
            int i5 = this.f6409f;
            if (i2 < i5 || i2 >= i5 + arrayList.size()) {
                return null;
            }
            return arrayList.get(i2 - this.f6409f);
        }

        public void d() {
            this.b = null;
        }
    }

    public z(Application application, Path path, Comparator<w> comparator, y[] yVarArr) {
        super(path, -1L);
        this.f6406l = new TreeMap<>();
        this.m = application;
        this.f6400f = comparator;
        this.f6401g = new a(this);
        this.f6403i = yVarArr;
        this.f6402h = new b(this);
        for (y yVar : yVarArr) {
            yVar.k(this);
        }
        x();
    }

    private int C(int i2, int i3) {
        if (i2 % i3 == 0) {
            return i2 / i3;
        }
        return (i2 / i3) + 1;
    }

    private boolean E(int i2, int i3) {
        int i4;
        int i5;
        y[] yVarArr = this.f6403i;
        if (yVarArr.length != 2 || yVarArr[0] == null || yVarArr[1] == null || (i4 = i3 - i2) < 128) {
            return false;
        }
        int r = yVarArr[0].r();
        int r2 = this.f6403i[1].r();
        if (r == 0 && r2 == 0) {
            return false;
        }
        int min = Math.min(r, r2);
        char c2 = r == min ? (char) 1 : (char) 0;
        char c3 = r == min ? (char) 0 : (char) 1;
        if (min > i4) {
            return false;
        }
        int i6 = i3 - min;
        if (i6 < 0) {
            i6 = 0;
        }
        w b2 = this.f6404j[c2].b(i6, Math.max((i3 - i6) + 1, 64));
        int max = Math.max(min, 64);
        int i7 = 0;
        while (true) {
            if (i7 >= min) {
                i5 = -1;
                break;
            } else if (this.f6400f.compare(b2, this.f6404j[c3].b(i7, max)) < 0) {
                i5 = i7 - 1;
                if (i5 < 0) {
                    i5 = 0;
                }
            } else {
                i7++;
            }
        }
        if (i5 == -1) {
            i5 = min != 0 ? min - 1 : 0;
        }
        int[] iArr = new int[this.f6403i.length];
        iArr[c2] = i6;
        iArr[c3] = i5;
        this.f6406l.put(Integer.valueOf(i5 + i6), iArr);
        return true;
    }

    private void F() {
        int length = this.f6403i.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f6404j[i2].d();
        }
        this.f6406l.clear();
        this.f6406l.put(0, new int[this.f6403i.length]);
    }

    private void H(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, int i2) {
        Collections.sort(arrayList2, this.f6402h);
        arrayList.clear();
        Iterator<y.c> it = arrayList2.iterator();
        int i3 = -1;
        int i4 = 0;
        while (it.hasNext()) {
            y.c next = it.next();
            y.c cVar = null;
            if (i3 >= 0 && i3 < arrayList.size()) {
                cVar = arrayList.get(i3);
            }
            if (cVar != null && cVar.a == next.a) {
                int i5 = cVar.f6393e + next.f6393e;
                cVar.f6393e = i5;
                cVar.f6395g = C(i5, i2);
            } else {
                next.f6392d = i4;
                arrayList.add(next);
                i3++;
            }
            i4 += next.f6393e;
        }
    }

    private void J() {
        y[] yVarArr = this.f6403i;
        int i2 = yVarArr.length == 0 ? 0 : -1;
        this.f6404j = new c[yVarArr.length];
        us.pinguo.common.log.a.m("MergeAlbum", "updateData mSources = " + this.f6403i.length + " supported =" + i2, new Object[0]);
        int length = this.f6403i.length;
        for (int i3 = 0; i3 < length; i3++) {
            us.pinguo.common.log.a.m("MergeAlbum", "updateData mSources[] " + this.f6403i[i3], new Object[0]);
            c[] cVarArr = this.f6404j;
            y[] yVarArr2 = this.f6403i;
            cVarArr[i3] = new c(yVarArr2[i3]);
            i2 &= yVarArr2[i3].h();
        }
        this.f6405k = i2;
        this.f6406l.clear();
        this.f6406l.put(0, new int[this.f6403i.length]);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public void A() {
        y[] yVarArr = this.f6403i;
        if (yVarArr != null) {
            for (y yVar : yVarArr) {
                yVar.A();
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public void B(long j2, long j3) {
        y[] yVarArr = this.f6403i;
        if (yVarArr != null) {
            for (y yVar : yVarArr) {
                yVar.B(j2, j3);
            }
        }
    }

    public boolean D() {
        y[] yVarArr = this.f6403i;
        if (yVarArr != null) {
            for (y yVar : yVarArr) {
                if ((yVar instanceof f) || (yVar instanceof g)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean G() {
        for (y yVar : this.f6403i) {
            if (!(yVar instanceof r)) {
                return false;
            }
        }
        return true;
    }

    public void I(w wVar) {
        y[] yVarArr = this.f6403i;
        if (yVarArr != null) {
            for (y yVar : yVarArr) {
                if (yVar instanceof com.pinguo.camera360.gallery.data.b) {
                    ((com.pinguo.camera360.gallery.data.b) yVar).K(wVar);
                }
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.data.n
    public void a() {
        w();
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void c(boolean z) {
        y[] yVarArr;
        for (y yVar : this.f6403i) {
            yVar.c(z);
            us.pinguo.common.log.a.m("MergeAlbum", "delete set = " + yVar, new Object[0]);
        }
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public int h() {
        return this.f6405k;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int l(ArrayList<y.c> arrayList) {
        int integer = this.m.getResources().getInteger(R.integer.album_rows_port);
        int length = this.f6403i.length;
        ArrayList<y.c> arrayList2 = new ArrayList<>();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            ArrayList<y.c> arrayList3 = new ArrayList<>();
            i2 += this.f6403i[i3].l(arrayList3);
            arrayList2.addAll(arrayList3);
        }
        H(arrayList, arrayList2, integer);
        return i2;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int m(ArrayList<y.c> arrayList, ArrayList<y.b> arrayList2) {
        return super.m(arrayList, arrayList2);
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int n(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2) {
        int length = this.f6403i.length;
        ArrayList<y.c> arrayList3 = new ArrayList<>();
        ArrayList<y.c> arrayList4 = new ArrayList<>();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            ArrayList<y.c> arrayList5 = new ArrayList<>();
            ArrayList<y.c> arrayList6 = new ArrayList<>();
            i2 += this.f6403i[i3].n(arrayList5, arrayList6);
            arrayList3.addAll(arrayList5);
            arrayList4.addAll(arrayList6);
        }
        int integer = this.m.getResources().getInteger(R.integer.album_rows_port);
        int integer2 = com.pinguo.album.e.e().b().getResources().getInteger(R.integer.album_rows_land);
        H(arrayList, arrayList3, integer);
        H(arrayList2, arrayList4, integer2);
        return i2;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<m> p(int i2, int i3) {
        int i4 = i2 + 1;
        SortedMap<Integer, int[]> headMap = this.f6406l.headMap(Integer.valueOf(i4));
        int intValue = headMap.lastKey().intValue();
        int[] iArr = (int[]) headMap.get(Integer.valueOf(intValue)).clone();
        if (E(intValue, i2)) {
            SortedMap<Integer, int[]> headMap2 = this.f6406l.headMap(Integer.valueOf(i4));
            intValue = headMap2.lastKey().intValue();
            iArr = (int[]) headMap2.get(Integer.valueOf(intValue)).clone();
        }
        y[] yVarArr = this.f6403i;
        m[] mVarArr = new m[yVarArr.length];
        int length = yVarArr.length;
        int[] iArr2 = new int[yVarArr.length];
        us.pinguo.common.log.a.m("MergeAlbum", "getMediaItem size = " + length, new Object[0]);
        for (int i5 = 0; i5 < length; i5++) {
            iArr2[i5] = Math.max(i3 / 2, 64);
            mVarArr[i5] = this.f6404j[i5].c(iArr[i5], iArr2[i5]);
        }
        ArrayList<m> arrayList = new ArrayList<>();
        while (intValue < i2 + i3) {
            int i6 = -1;
            for (int i7 = 0; i7 < length; i7++) {
                if (mVarArr[i7] != null && (i6 == -1 || this.f6401g.compare(mVarArr[i7], mVarArr[i6]) < 0)) {
                    i6 = i7;
                }
            }
            if (i6 == -1) {
                break;
            }
            iArr[i6] = iArr[i6] + 1;
            if (intValue >= i2) {
                arrayList.add(mVarArr[i6]);
            }
            mVarArr[i6] = this.f6404j[i6].c(iArr[i6], iArr2[i6]);
            intValue++;
            if (intValue % 64 == 0) {
                this.f6406l.put(Integer.valueOf(intValue), (int[]) iArr.clone());
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public ArrayList<w> q(int i2, int i3) {
        int i4 = i2 + 1;
        SortedMap<Integer, int[]> headMap = this.f6406l.headMap(Integer.valueOf(i4));
        int intValue = headMap.lastKey().intValue();
        int[] iArr = (int[]) headMap.get(Integer.valueOf(intValue)).clone();
        if (E(intValue, i2)) {
            SortedMap<Integer, int[]> headMap2 = this.f6406l.headMap(Integer.valueOf(i4));
            intValue = headMap2.lastKey().intValue();
            iArr = (int[]) headMap2.get(Integer.valueOf(intValue)).clone();
        }
        y[] yVarArr = this.f6403i;
        w[] wVarArr = new w[yVarArr.length];
        int length = yVarArr.length;
        us.pinguo.common.log.a.m("MergeAlbum", "getMediaItem size = " + length, new Object[0]);
        for (int i5 = 0; i5 < length; i5++) {
            wVarArr[i5] = this.f6404j[i5].a(iArr[i5]);
        }
        ArrayList<w> arrayList = new ArrayList<>();
        while (intValue < i2 + i3) {
            int i6 = -1;
            for (int i7 = 0; i7 < length; i7++) {
                if (wVarArr[i7] != null && (i6 == -1 || this.f6400f.compare(wVarArr[i7], wVarArr[i6]) < 0)) {
                    i6 = i7;
                }
            }
            if (i6 == -1) {
                break;
            }
            iArr[i6] = iArr[i6] + 1;
            if (intValue >= i2) {
                arrayList.add(wVarArr[i6]);
            }
            wVarArr[i6] = this.f6404j[i6].a(iArr[i6]);
            intValue++;
            if (intValue % 64 == 0) {
                this.f6406l.put(Integer.valueOf(intValue), (int[]) iArr.clone());
            }
        }
        return arrayList;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public int r() {
        int i2 = 0;
        for (y yVar : this.f6403i) {
            i2 += yVar.r();
        }
        return i2;
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public String s() {
        y[] yVarArr = this.f6403i;
        return yVarArr.length == 0 ? "" : yVarArr[0].s();
    }

    @Override // com.pinguo.camera360.gallery.data.y
    public long x() {
        us.pinguo.common.log.a.m("MergeAlbum", "reload mSource.length = " + this.f6403i.length + " mDataVersion = " + this.a, new Object[0]);
        int length = this.f6403i.length;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            long x = this.f6403i[i2].x();
            us.pinguo.common.log.a.m("MergeAlbum", "test = " + x, new Object[0]);
            if (x > this.a) {
                z = true;
            }
        }
        us.pinguo.common.log.a.m("MergeAlbum", "reload changed = " + z, new Object[0]);
        if (z) {
            this.a = x.j();
            J();
            F();
        }
        return this.a;
    }
}
