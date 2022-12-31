package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzapn extends zzgy implements zzapk {
    public zzapn() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzapk zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzapk) {
            return (zzapk) queryLocalInterface;
        }
        return new zzapm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzapp zzaprVar;
        zzapp zzappVar;
        zzaoy zzaoyVar = null;
        zzapj zzaplVar = null;
        zzape zzapgVar = null;
        zzapj zzaplVar2 = null;
        zzapd zzapfVar = null;
        if (i2 == 1) {
            b x0 = b.a.x0(parcel.readStrongBinder());
            String readString = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzgx.zza(parcel, creator);
            Bundle bundle2 = (Bundle) zzgx.zza(parcel, creator);
            zzvs zzvsVar = (zzvs) zzgx.zza(parcel, zzvs.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzappVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                if (queryLocalInterface instanceof zzapp) {
                    zzaprVar = (zzapp) queryLocalInterface;
                } else {
                    zzaprVar = new zzapr(readStrongBinder);
                }
                zzappVar = zzaprVar;
            }
            zza(x0, readString, bundle, bundle2, zzvsVar, zzappVar);
            parcel2.writeNoException();
        } else if (i2 == 2) {
            zzapy zzvc = zzvc();
            parcel2.writeNoException();
            zzgx.zzb(parcel2, zzvc);
        } else if (i2 == 3) {
            zzapy zzvd = zzvd();
            parcel2.writeNoException();
            zzgx.zzb(parcel2, zzvd);
        } else if (i2 == 5) {
            zzzc videoController = getVideoController();
            parcel2.writeNoException();
            zzgx.zza(parcel2, videoController);
        } else if (i2 == 10) {
            zzy(b.a.x0(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i2 != 11) {
            switch (i2) {
                case 13:
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    zzvl zzvlVar = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                    b x02 = b.a.x0(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        if (queryLocalInterface2 instanceof zzaoy) {
                            zzaoyVar = (zzaoy) queryLocalInterface2;
                        } else {
                            zzaoyVar = new zzapa(readStrongBinder2);
                        }
                    }
                    zza(readString2, readString3, zzvlVar, x02, zzaoyVar, zzann.zzad(parcel.readStrongBinder()), (zzvs) zzgx.zza(parcel, zzvs.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 14:
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    zzvl zzvlVar2 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                    b x03 = b.a.x0(parcel.readStrongBinder());
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        if (queryLocalInterface3 instanceof zzapd) {
                            zzapfVar = (zzapd) queryLocalInterface3;
                        } else {
                            zzapfVar = new zzapf(readStrongBinder3);
                        }
                    }
                    zza(readString4, readString5, zzvlVar2, x03, zzapfVar, zzann.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 15:
                    boolean zzz = zzz(b.a.x0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgx.writeBoolean(parcel2, zzz);
                    break;
                case 16:
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    zzvl zzvlVar3 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                    b x04 = b.a.x0(parcel.readStrongBinder());
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface4 instanceof zzapj) {
                            zzaplVar2 = (zzapj) queryLocalInterface4;
                        } else {
                            zzaplVar2 = new zzapl(readStrongBinder4);
                        }
                    }
                    zza(readString6, readString7, zzvlVar3, x04, zzaplVar2, zzann.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 17:
                    boolean zzaa = zzaa(b.a.x0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgx.writeBoolean(parcel2, zzaa);
                    break;
                case 18:
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    zzvl zzvlVar4 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                    b x05 = b.a.x0(parcel.readStrongBinder());
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 != null) {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        if (queryLocalInterface5 instanceof zzape) {
                            zzapgVar = (zzape) queryLocalInterface5;
                        } else {
                            zzapgVar = new zzapg(readStrongBinder5);
                        }
                    }
                    zza(readString8, readString9, zzvlVar4, x05, zzapgVar, zzann.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 19:
                    zzdm(parcel.readString());
                    parcel2.writeNoException();
                    break;
                case 20:
                    String readString10 = parcel.readString();
                    String readString11 = parcel.readString();
                    zzvl zzvlVar5 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                    b x06 = b.a.x0(parcel.readStrongBinder());
                    IBinder readStrongBinder6 = parcel.readStrongBinder();
                    if (readStrongBinder6 != null) {
                        IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface6 instanceof zzapj) {
                            zzaplVar = (zzapj) queryLocalInterface6;
                        } else {
                            zzaplVar = new zzapl(readStrongBinder6);
                        }
                    }
                    zzb(readString10, readString11, zzvlVar5, x06, zzaplVar, zzann.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
        } else {
            zza(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
            parcel2.writeNoException();
        }
        return true;
    }
}
