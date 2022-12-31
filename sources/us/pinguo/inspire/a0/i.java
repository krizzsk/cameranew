package us.pinguo.inspire.a0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Type;
/* compiled from: ObjectCreator.java */
/* loaded from: classes4.dex */
public abstract class i<T> implements Parcelable.Creator<T> {
    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return null;
    }

    public abstract Type getType();

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i2) {
        return null;
    }

    public abstract T newInstance();
}
