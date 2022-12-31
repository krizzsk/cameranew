package com.pinguo.camera360.gallery.data;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.pinguo.album.a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import us.pinguo.foundation.utils.n0;
/* compiled from: BucketHelper.java */
/* loaded from: classes3.dex */
class j {
    private static final String[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BucketHelper.java */
    /* loaded from: classes3.dex */
    public class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            int i2 = bVar2.c;
            int i3 = bVar.c;
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 0 : -1;
        }
    }

    /* compiled from: BucketHelper.java */
    /* loaded from: classes3.dex */
    public static class b {
        public String a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public String f6369d;

        public b(int i2, String str, String str2) {
            this.b = i2;
            this.a = str == null ? "" : str;
            this.f6369d = str2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && this.b == ((b) obj).b;
        }

        public int hashCode() {
            return this.b;
        }
    }

    static {
        boolean z = us.pinguo.util.c.a;
        a = new String[]{"bucket_id", "datetaken", "bucket_display_name", "_data"};
    }

    public static b[] a(a.c cVar, ContentResolver contentResolver, int i2) {
        return b(cVar, contentResolver, i2);
    }

    private static b[] b(a.c cVar, ContentResolver contentResolver, int i2) {
        HashMap hashMap = new HashMap(64);
        if ((i2 & 2) != 0) {
            c(cVar, contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashMap);
        }
        if ((i2 & 4) != 0 && us.pinguo.util.c.c) {
            c(cVar, contentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, hashMap);
        }
        b[] bVarArr = (b[]) hashMap.values().toArray(new b[hashMap.size()]);
        Arrays.sort(bVarArr, new a());
        return bVarArr;
    }

    private static void c(a.c cVar, ContentResolver contentResolver, Uri uri, HashMap<Integer, b> hashMap) {
        Cursor query = contentResolver.query(uri, a, "1=1", null, "datetaken DESC");
        if (query == null) {
            us.pinguo.common.log.a.s("cannot open media database: " + uri, new Object[0]);
            return;
        }
        while (query.moveToNext()) {
            try {
                int i2 = query.getInt(0);
                int i3 = query.getInt(1);
                b bVar = hashMap.get(Integer.valueOf(i2));
                if (bVar == null) {
                    b bVar2 = new b(i2, query.getString(2), query.getString(3));
                    hashMap.put(Integer.valueOf(i2), bVar2);
                    bVar2.c = i3;
                } else {
                    bVar.c = Math.max(bVar.c, i3);
                }
            } finally {
                n0.a(query);
            }
        }
    }
}
