package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzani extends zzgy implements zzanj {
    public zzani() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzank zzankVar = null;
        switch (i2) {
            case 1:
                b x0 = b.a.x0(parcel.readStrongBinder());
                zzvs zzvsVar = (zzvs) zzgx.zza(parcel, zzvs.CREATOR);
                zzvl zzvlVar = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface;
                    } else {
                        zzankVar = new zzanm(readStrongBinder);
                    }
                }
                zza(x0, zzvsVar, zzvlVar, readString, zzankVar);
                parcel2.writeNoException();
                return true;
            case 2:
                b zzuu = zzuu();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzuu);
                return true;
            case 3:
                b x02 = b.a.x0(parcel.readStrongBinder());
                zzvl zzvlVar2 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface2;
                    } else {
                        zzankVar = new zzanm(readStrongBinder2);
                    }
                }
                zza(x02, zzvlVar2, readString2, zzankVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                b x03 = b.a.x0(parcel.readStrongBinder());
                zzvs zzvsVar2 = (zzvs) zzgx.zza(parcel, zzvs.CREATOR);
                zzvl zzvlVar3 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface3;
                    } else {
                        zzankVar = new zzanm(readStrongBinder3);
                    }
                }
                zza(x03, zzvsVar2, zzvlVar3, readString3, readString4, zzankVar);
                parcel2.writeNoException();
                return true;
            case 7:
                b x04 = b.a.x0(parcel.readStrongBinder());
                zzvl zzvlVar4 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface4;
                    } else {
                        zzankVar = new zzanm(readStrongBinder4);
                    }
                }
                zza(x04, zzvlVar4, readString5, readString6, zzankVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(b.a.x0(parcel.readStrongBinder()), (zzvl) zzgx.zza(parcel, zzvl.CREATOR), parcel.readString(), zzave.zzap(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza((zzvl) zzgx.zza(parcel, zzvl.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isInitialized);
                return true;
            case 14:
                b x05 = b.a.x0(parcel.readStrongBinder());
                zzvl zzvlVar5 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface5;
                    } else {
                        zzankVar = new zzanm(readStrongBinder5);
                    }
                }
                zza(x05, zzvlVar5, readString7, readString8, zzankVar, (zzaeh) zzgx.zza(parcel, zzaeh.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzanr zzuv = zzuv();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzuv);
                return true;
            case 16:
                zzans zzuw = zzuw();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzuw);
                return true;
            case 17:
                Bundle zzux = zzux();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzux);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle zzuy = zzuy();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzuy);
                return true;
            case 20:
                zza((zzvl) zzgx.zza(parcel, zzvl.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzs(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zzuz = zzuz();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, zzuz);
                return true;
            case 23:
                zza(b.a.x0(parcel.readStrongBinder()), zzave.zzap(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzafn zzva = zzva();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzva);
                return true;
            case 25:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzzc videoController = getVideoController();
                parcel2.writeNoException();
                zzgx.zza(parcel2, videoController);
                return true;
            case 27:
                zzanx zzvb = zzvb();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzvb);
                return true;
            case 28:
                b x06 = b.a.x0(parcel.readStrongBinder());
                zzvl zzvlVar6 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface6;
                    } else {
                        zzankVar = new zzanm(readStrongBinder6);
                    }
                }
                zzb(x06, zzvlVar6, readString9, zzankVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                zzt(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                zza(b.a.x0(parcel.readStrongBinder()), zzaji.zzz(parcel.readStrongBinder()), parcel.createTypedArrayList(zzajr.CREATOR));
                parcel2.writeNoException();
                return true;
            case 32:
                b x07 = b.a.x0(parcel.readStrongBinder());
                zzvl zzvlVar7 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                String readString10 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface7 instanceof zzank) {
                        zzankVar = (zzank) queryLocalInterface7;
                    } else {
                        zzankVar = new zzanm(readStrongBinder7);
                    }
                }
                zzc(x07, zzvlVar7, readString10, zzankVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzapy zzvc = zzvc();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzvc);
                return true;
            case 34:
                zzapy zzvd = zzvd();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzvd);
                return true;
        }
    }
}
