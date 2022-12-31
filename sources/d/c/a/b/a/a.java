package d.c.a.b.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import d.c.a.a.b;
import d.c.a.a.c;
/* compiled from: IGetInstallReferrerService.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IGetInstallReferrerService.java */
    /* renamed from: d.c.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0292a extends b implements a {

        /* compiled from: IGetInstallReferrerService.java */
        /* renamed from: d.c.a.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0293a extends d.c.a.a.a implements a {
            C0293a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // d.c.a.b.a.a
            public final Bundle b(Bundle bundle) throws RemoteException {
                Parcel x0 = x0();
                c.b(x0, bundle);
                Parcel y0 = y0(x0);
                Bundle bundle2 = (Bundle) c.a(y0, Bundle.CREATOR);
                y0.recycle();
                return bundle2;
            }
        }

        public static a x0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0293a(iBinder);
        }
    }

    Bundle b(Bundle bundle) throws RemoteException;
}
