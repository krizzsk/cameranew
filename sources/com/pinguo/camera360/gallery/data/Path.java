package com.pinguo.camera360.gallery.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new a();
    private int mGalleryId;
    private WeakReference<x> mObject;
    private String mPath;
    private long mTakenDate;
    private int mType;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<Path> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Path createFromParcel(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Path[] newArray(int i2) {
            return new Path[i2];
        }
    }

    public Path(int i2, String str) {
        this.mType = i2;
        this.mPath = str;
    }

    public Path a() {
        Path path = new Path(this.mType, this.mPath);
        path.k(this.mGalleryId);
        path.l(this.mTakenDate);
        return path;
    }

    public int b() {
        return this.mGalleryId;
    }

    public x c() {
        x xVar;
        synchronized (Path.class) {
            WeakReference<x> weakReference = this.mObject;
            xVar = weakReference == null ? null : weakReference.get();
        }
        return xVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Path path = (Path) obj;
        if (this.mTakenDate == path.mTakenDate && this.mGalleryId == path.mGalleryId && this.mType == path.mType) {
            String str = this.mPath;
            String str2 = path.mPath;
            return str == null ? str2 == null : str.equals(str2);
        }
        return false;
    }

    public String f() {
        return this.mPath;
    }

    public long g() {
        return this.mTakenDate;
    }

    public int h() {
        return this.mType;
    }

    public int hashCode() {
        int i2 = this.mType * 31;
        String str = this.mPath;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.mTakenDate;
        int i3 = this.mGalleryId;
        return ((((i2 + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (i3 ^ (i3 >>> 32));
    }

    public void j(x xVar) {
        boolean z;
        synchronized (Path.class) {
            WeakReference<x> weakReference = this.mObject;
            if (weakReference != null && weakReference.get() != null) {
                z = false;
                com.pinguo.album.j.a.a(z);
                this.mObject = new WeakReference<>(xVar);
            }
            z = true;
            com.pinguo.album.j.a.a(z);
            this.mObject = new WeakReference<>(xVar);
        }
    }

    public Path k(int i2) {
        this.mGalleryId = i2;
        return this;
    }

    public Path l(long j2) {
        this.mTakenDate = j2;
        return this;
    }

    public String toString() {
        return "media-type:" + this.mType + " media-path-id:" + this.mPath;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mPath);
        parcel.writeLong(this.mTakenDate);
        parcel.writeInt(this.mGalleryId);
    }

    protected Path(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mPath = parcel.readString();
        this.mTakenDate = parcel.readLong();
        this.mGalleryId = parcel.readInt();
    }
}
