package com.facebook.ads.internal.androidx.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class AbsSavedState implements Parcelable {
    public static byte[] A01;
    public static final AbsSavedState A02;
    public static final Parcelable.Creator<AbsSavedState> CREATOR;
    public final Parcelable A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 43);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{49, 55, 50, 39, 48, 17, 54, 35, 54, 39, 98, 47, 55, 49, 54, 98, 44, 45, 54, 98, 32, 39, 98, 44, 55, 46, 46};
    }

    static {
        A01();
        A02 = new AbsSavedState() { // from class: com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState.1
        };
        CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() { // from class: com.facebook.ads.redexgen.X.2a
            public static byte[] A00;

            static {
                A03();
            }

            public static String A02(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 92);
                }
                return new String(copyOfRange);
            }

            public static void A03() {
                A00 = new byte[]{88, 94, 91, 78, 89, 120, 95, 74, 95, 78, 11, 70, 94, 88, 95, 11, 73, 78, 11, 69, 94, 71, 71};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A00 */
            public final AbsSavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: A01 */
            public final AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (parcel.readParcelable(classLoader) == null) {
                    return AbsSavedState.A02;
                }
                throw new IllegalStateException(A02(0, 23, 119));
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A04 */
            public final AbsSavedState[] newArray(int i2) {
                return new AbsSavedState[i2];
            }
        };
    }

    public AbsSavedState() {
        this.A00 = null;
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.A00 = readParcelable == null ? A02 : readParcelable;
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.A00 = parcelable == A02 ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException(A00(0, 27, 105));
    }

    public final Parcelable A02() {
        return this.A00;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.A00, i2);
    }
}
