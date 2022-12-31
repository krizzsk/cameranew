package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzya extends zzgw implements zzxy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzya(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zza(b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2) throws RemoteException {
        zzxl zzxnVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(1, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zzb(b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2) throws RemoteException {
        zzxl zzxnVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(2, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzyg zzc(b bVar) throws RemoteException {
        zzyg zzyiVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(4, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzyiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyg) {
                zzyiVar = (zzyg) queryLocalInterface;
            } else {
                zzyiVar = new zzyi(readStrongBinder);
            }
        }
        zza.recycle();
        return zzyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzasd zzd(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(7, zzdo);
        zzasd zzak = zzasc.zzak(zza.readStrongBinder());
        zza.recycle();
        return zzak;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zzc(b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2) throws RemoteException {
        zzxl zzxnVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(13, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxi zza(b bVar, String str, zzane zzaneVar, int i2) throws RemoteException {
        zzxi zzxkVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(3, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzxi) {
                zzxkVar = (zzxi) queryLocalInterface;
            } else {
                zzxkVar = new zzxk(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaro zzb(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(8, zzdo);
        zzaro zzai = zzarr.zzai(zza.readStrongBinder());
        zza.recycle();
        return zzai;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzavm zzb(b bVar, String str, zzane zzaneVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(12, zzdo);
        zzavm zzar = zzavp.zzar(zza.readStrongBinder());
        zza.recycle();
        return zzar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzarf zzc(b bVar, zzane zzaneVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(15, zzdo);
        zzarf zzag = zzare.zzag(zza.readStrongBinder());
        zza.recycle();
        return zzag;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaev zza(b bVar, b bVar2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, bVar2);
        Parcel zza = zza(5, zzdo);
        zzaev zzp = zzaeu.zzp(zza.readStrongBinder());
        zza.recycle();
        return zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaxy zzb(b bVar, zzane zzaneVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(14, zzdo);
        zzaxy zzas = zzayb.zzas(zza.readStrongBinder());
        zza.recycle();
        return zzas;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaur zza(b bVar, zzane zzaneVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(6, zzdo);
        zzaur zzan = zzauq.zzan(zza.readStrongBinder());
        zza.recycle();
        return zzan;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzyg zza(b bVar, int i2) throws RemoteException {
        zzyg zzyiVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeInt(i2);
        Parcel zza = zza(9, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzyiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyg) {
                zzyiVar = (zzyg) queryLocalInterface;
            } else {
                zzyiVar = new zzyi(readStrongBinder);
            }
        }
        zza.recycle();
        return zzyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zza(b bVar, zzvs zzvsVar, String str, int i2) throws RemoteException {
        zzxl zzxnVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzdo.writeString(str);
        zzdo.writeInt(i2);
        Parcel zza = zza(10, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                zzxnVar = (zzxl) queryLocalInterface;
            } else {
                zzxnVar = new zzxn(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaey zza(b bVar, b bVar2, b bVar3) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, bVar2);
        zzgx.zza(zzdo, bVar3);
        Parcel zza = zza(11, zzdo);
        zzaey zzq = zzafb.zzq(zza.readStrongBinder());
        zza.recycle();
        return zzq;
    }
}
