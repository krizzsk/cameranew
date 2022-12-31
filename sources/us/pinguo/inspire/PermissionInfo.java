package us.pinguo.inspire;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: PermissionBufferLauncher.kt */
/* loaded from: classes4.dex */
public final class PermissionInfo implements Parcelable {
    public static final a CREATOR = new a(null);
    private final boolean necessary;
    private final String permission;

    /* compiled from: PermissionBufferLauncher.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Parcelable.Creator<PermissionInfo> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PermissionInfo createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.s.h(parcel, "parcel");
            return new PermissionInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PermissionInfo[] newArray(int i2) {
            return new PermissionInfo[i2];
        }
    }

    public PermissionInfo(String str, boolean z) {
        this.permission = str;
        this.necessary = z;
    }

    public final boolean a() {
        return this.necessary;
    }

    public final String b() {
        return this.permission;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.s.h(parcel, "parcel");
        parcel.writeString(this.permission);
        parcel.writeByte(this.necessary ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PermissionInfo(Parcel parcel) {
        this(parcel.readString(), parcel.readByte() != 0);
        kotlin.jvm.internal.s.h(parcel, "parcel");
    }
}
