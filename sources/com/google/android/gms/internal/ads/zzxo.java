package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzxo extends zzgy implements zzxl {
    public zzxo() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzxl zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzxl) {
            return (zzxl) queryLocalInterface;
        }
        return new zzxn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzwx zzwxVar = null;
        zzyb zzybVar = null;
        zzxc zzxcVar = null;
        zzyw zzywVar = null;
        zzxs zzxsVar = null;
        zzxz zzxzVar = null;
        zzww zzwwVar = null;
        zzxt zzxtVar = null;
        switch (i2) {
            case 1:
                b zzke = zzke();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzke);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isReady = isReady();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isReady);
                return true;
            case 4:
                boolean zza = zza((zzvl) zzgx.zza(parcel, zzvl.CREATOR));
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, zza);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzwx) {
                        zzwxVar = (zzwx) queryLocalInterface;
                    } else {
                        zzwxVar = new zzwz(readStrongBinder);
                    }
                }
                zza(zzwxVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzxt) {
                        zzxtVar = (zzxt) queryLocalInterface2;
                    } else {
                        zzxtVar = new zzxv(readStrongBinder2);
                    }
                }
                zza(zzxtVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzkf();
                parcel2.writeNoException();
                return true;
            case 12:
                zzvs zzkg = zzkg();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, zzkg);
                return true;
            case 13:
                zza((zzvs) zzgx.zza(parcel, zzvs.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzasb.zzaj(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzash.zzal(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzack.zzl(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzww) {
                        zzwwVar = (zzww) queryLocalInterface3;
                    } else {
                        zzwwVar = new zzwy(readStrongBinder3);
                    }
                }
                zza(zzwwVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzxz) {
                        zzxzVar = (zzxz) queryLocalInterface4;
                    } else {
                        zzxzVar = new zzyc(readStrongBinder4);
                    }
                }
                zza(zzxzVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isLoading);
                return true;
            case 24:
                zza(zzaux.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzzc videoController = getVideoController();
                parcel2.writeNoException();
                zzgx.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzaau) zzgx.zza(parcel, zzaau.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzzi) zzgx.zza(parcel, zzzi.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzxt zzkj = zzkj();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzkj);
                return true;
            case 33:
                zzwx zzkk = zzkk();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzkk);
                return true;
            case 34:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String zzkh = zzkh();
                parcel2.writeNoException();
                parcel2.writeString(zzkh);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzxs) {
                        zzxsVar = (zzxs) queryLocalInterface5;
                    } else {
                        zzxsVar = new zzxu(readStrongBinder5);
                    }
                }
                zza(zzxsVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, adMetadata);
                return true;
            case 38:
                zzbl(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                zza((zzvx) zzgx.zza(parcel, zzvx.CREATOR));
                parcel2.writeNoException();
                return true;
            case 40:
                zza(zzso.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 41:
                zzyx zzki = zzki();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzki);
                return true;
            case 42:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    if (queryLocalInterface6 instanceof zzyw) {
                        zzywVar = (zzyw) queryLocalInterface6;
                    } else {
                        zzywVar = new zzyy(readStrongBinder6);
                    }
                }
                zza(zzywVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzvl zzvlVar = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    if (queryLocalInterface7 instanceof zzxc) {
                        zzxcVar = (zzxc) queryLocalInterface7;
                    } else {
                        zzxcVar = new zzxe(readStrongBinder7);
                    }
                }
                zza(zzvlVar, zzxcVar);
                parcel2.writeNoException();
                return true;
            case 44:
                zze(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    if (queryLocalInterface8 instanceof zzyb) {
                        zzybVar = (zzyb) queryLocalInterface8;
                    } else {
                        zzybVar = new zzyd(readStrongBinder8);
                    }
                }
                zza(zzybVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
