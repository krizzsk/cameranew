package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class a {
    private static int A(Parcel parcel, int i2) {
        parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void B(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    private static <T extends Parcelable> void C(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void D(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static int a(Parcel parcel) {
        return A(parcel, 20293);
    }

    public static void b(Parcel parcel, int i2) {
        D(parcel, i2);
    }

    public static void c(Parcel parcel, int i2, boolean z) {
        B(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(Parcel parcel, int i2, Boolean bool, boolean z) {
        if (bool != null) {
            B(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void e(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeBundle(bundle);
        D(parcel, A);
    }

    public static void f(Parcel parcel, int i2, byte b) {
        B(parcel, i2, 4);
        parcel.writeInt(b);
    }

    public static void g(Parcel parcel, int i2, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeByteArray(bArr);
        D(parcel, A);
    }

    public static void h(Parcel parcel, int i2, double d2) {
        B(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void i(Parcel parcel, int i2, Double d2, boolean z) {
        if (d2 != null) {
            B(parcel, i2, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void j(Parcel parcel, int i2, float f2) {
        B(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void k(Parcel parcel, int i2, Float f2, boolean z) {
        if (f2 != null) {
            B(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void l(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeStrongBinder(iBinder);
        D(parcel, A);
    }

    public static void m(Parcel parcel, int i2, int i3) {
        B(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void n(Parcel parcel, int i2, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).intValue());
        }
        D(parcel, A);
    }

    public static void o(Parcel parcel, int i2, Integer num, boolean z) {
        if (num != null) {
            B(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void p(Parcel parcel, int i2, List list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeList(list);
        D(parcel, A);
    }

    public static void q(Parcel parcel, int i2, long j2) {
        B(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void r(Parcel parcel, int i2, Long l2, boolean z) {
        if (l2 != null) {
            B(parcel, i2, 8);
            parcel.writeLong(l2.longValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void s(Parcel parcel, int i2, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        D(parcel, A);
    }

    public static void t(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        D(parcel, A);
    }

    public static void u(Parcel parcel, int i2, short s) {
        B(parcel, i2, 4);
        parcel.writeInt(s);
    }

    public static void v(Parcel parcel, int i2, String str, boolean z) {
        if (str == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeString(str);
        D(parcel, A);
    }

    public static void w(Parcel parcel, int i2, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeStringArray(strArr);
        D(parcel, A);
    }

    public static void x(Parcel parcel, int i2, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeStringList(list);
        D(parcel, A);
    }

    public static <T extends Parcelable> void y(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                C(parcel, t, i3);
            }
        }
        D(parcel, A);
    }

    public static <T extends Parcelable> void z(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int A = A(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                C(parcel, t, 0);
            }
        }
        D(parcel, A);
    }
}
