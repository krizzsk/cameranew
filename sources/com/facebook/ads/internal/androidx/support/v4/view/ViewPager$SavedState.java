package com.facebook.ads.internal.androidx.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class ViewPager$SavedState extends AbsSavedState {
    public static byte[] A03;
    public static String[] A04 = {"AuWUrmLwM7GJPOP8rAuSpECd", "zFZ56n4eT6FX9g05wYbCu7I1KdVlhoN5", "3SSlkU9NidmbZe3U4TW9jjT4o2WSslgz", "APX54tRZsJmOx3lXT4kxzRZl5L0Cy1ng", "WyhnJgw7sEVfHQ6PVTSepOeMPj7Mc4Ks", "C9gBfAnfslWjb6MmPGJedCbgsvPnDQHc", "ftNuqlGlWzKSfY1f2k31BPROKX0YPmxK", "PuGcjbCEvSEVXUJBdaZJQ0xYiuJzE14G"};
    public static final Parcelable.Creator<ViewPager$SavedState> CREATOR;
    public int A00;
    public Parcelable A01;
    public ClassLoader A02;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 31);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {26, 74, 85, 73, 83, 78, 83, 85, 84, 7, 104, 92, 79, 73, 67, 75, 64, 90, 126, 79, 73, 75, 92, 0, 125, 79, 88, 75, 74, 125, 90, 79, 90, 75, 85, 110};
        if (A04[0].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[4] = "6MXMF3gfP26OkwGb8wx6s6o6EzMLPjev";
        strArr[6] = "tN9YMGevxJBQbN1CuNoijuB9DRrwOltB";
        A03 = bArr;
    }

    static {
        A02();
        CREATOR = new Parcelable.ClassLoaderCreator<ViewPager$SavedState>() { // from class: com.facebook.ads.redexgen.X.3D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A00 */
            public final ViewPager$SavedState createFromParcel(Parcel parcel) {
                return new ViewPager$SavedState(parcel, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: A01 */
            public final ViewPager$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new ViewPager$SavedState(parcel, classLoader);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A02 */
            public final ViewPager$SavedState[] newArray(int i2) {
                return new ViewPager$SavedState[i2];
            }
        };
    }

    public ViewPager$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
        this.A00 = parcel.readInt();
        this.A01 = parcel.readParcelable(classLoader);
        this.A02 = classLoader;
    }

    public ViewPager$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public final String toString() {
        return A01(10, 25, 49) + Integer.toHexString(System.identityHashCode(this)) + A01(0, 10, 37) + this.A00 + A01(35, 1, 12);
    }

    @Override // com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.A00);
        parcel.writeParcelable(this.A01, i2);
    }
}
