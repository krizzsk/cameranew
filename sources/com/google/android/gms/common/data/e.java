package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class e<T extends SafeParcelable> extends a<T> {
    private static final String[] zals = {"data"};
    private final Parcelable.Creator<T> zalt;

    public e(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zalt = creator;
    }

    public static <T extends SafeParcelable> void addValue(DataHolder.a aVar, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        aVar.a(contentValues);
        obtain.recycle();
    }

    public static DataHolder.a buildDataHolder() {
        return DataHolder.h(zals);
    }

    @Override // com.google.android.gms.common.data.a, com.google.android.gms.common.data.b
    public T get(int i2) {
        DataHolder dataHolder = this.mDataHolder;
        byte[] j2 = dataHolder.j("data", i2, dataHolder.T(i2));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(j2, 0, j2.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.zalt.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
