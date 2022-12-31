package us.pinguo.picker.image.gallery;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new a();
    private int mGalleryId;
    private WeakReference<n> mObject;
    private String mPath;
    private long mTakenDate;
    private int mType;

    /* loaded from: classes5.dex */
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

    public n a() {
        n nVar;
        synchronized (Path.class) {
            WeakReference<n> weakReference = this.mObject;
            nVar = weakReference == null ? null : weakReference.get();
        }
        return nVar;
    }

    public String b() {
        return this.mPath;
    }

    public long c() {
        return this.mTakenDate;
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

    public int f() {
        return this.mType;
    }

    public void g(n nVar) {
        boolean z;
        synchronized (Path.class) {
            WeakReference<n> weakReference = this.mObject;
            if (weakReference != null && weakReference.get() != null) {
                z = false;
                com.pinguo.album.j.a.a(z);
                this.mObject = new WeakReference<>(nVar);
            }
            z = true;
            com.pinguo.album.j.a.a(z);
            this.mObject = new WeakReference<>(nVar);
        }
    }

    public Path h(long j2) {
        this.mTakenDate = j2;
        return this;
    }

    public int hashCode() {
        int i2 = this.mType * 31;
        String str = this.mPath;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.mTakenDate;
        int i3 = this.mGalleryId;
        return ((((i2 + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (i3 ^ (i3 >>> 32));
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
