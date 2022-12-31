package com.pinguo.camera360.gallery.photopick;

import android.graphics.Bitmap;
import com.pinguo.camera360.gallery.data.Path;
/* compiled from: PhotoPickBean.java */
/* loaded from: classes3.dex */
public class e {
    public int a;
    public Bitmap b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public Path f6437d;

    /* renamed from: e  reason: collision with root package name */
    public Path f6438e;

    public e(int i2, String str, Path path, Path path2) {
        this(i2, str, null, 0, path, path2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a != eVar.a) {
                return false;
            }
            String str = this.c;
            if (str == null) {
                if (eVar.c != null) {
                    return false;
                }
            } else if (!str.equals(eVar.c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.a;
        String str = this.c;
        return str != null ? (i2 * 31) + str.hashCode() : i2;
    }

    public e(int i2, String str, Bitmap bitmap, int i3, Path path, Path path2) {
        this.a = i2;
        this.c = str;
        this.b = bitmap;
        this.f6437d = path;
        this.f6438e = path2;
    }
}
