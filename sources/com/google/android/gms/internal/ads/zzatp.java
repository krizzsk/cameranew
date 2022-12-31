package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.k;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzatp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatp> CREATOR = new zzatr();
    private ParcelFileDescriptor zzdxf;
    private Parcelable zzdxg = null;
    private boolean zzdxh = true;

    public zzatp(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzdxf = parcelFileDescriptor;
    }

    private static <T> ParcelFileDescriptor zzh(final byte[] bArr) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] createPipe;
        try {
            createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
        try {
            zzazp.zzeic.execute(new Runnable(autoCloseOutputStream, bArr) { // from class: com.google.android.gms.internal.ads.zzato
                private final OutputStream zzdxd;
                private final byte[] zzdxe;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdxd = autoCloseOutputStream;
                    this.zzdxe = bArr;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzatp.zza(this.zzdxd, this.zzdxe);
                }
            });
            return createPipe[0];
        } catch (IOException e3) {
            e = e3;
            zzazk.zzc("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e, "LargeParcelTeleporter.pipeData.2");
            k.a(autoCloseOutputStream);
            return null;
        }
    }

    private final ParcelFileDescriptor zzwj() {
        if (this.zzdxf == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzdxg.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzdxf = zzh(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzdxf;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzwj();
        int a = a.a(parcel);
        a.t(parcel, 2, this.zzdxf, i2, false);
        a.b(parcel, a);
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzdxh) {
            if (this.zzdxf == null) {
                zzazk.zzev("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzdxf));
            try {
                try {
                    int readInt = dataInputStream.readInt();
                    byte[] bArr = new byte[readInt];
                    dataInputStream.readFully(bArr, 0, readInt);
                    k.a(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, readInt);
                        obtain.setDataPosition(0);
                        this.zzdxg = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.zzdxh = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e2) {
                    zzazk.zzc("Could not read from parcel file descriptor", e2);
                    k.a(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                k.a(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzdxg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(OutputStream outputStream, byte[] bArr) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
            k.a(dataOutputStream);
        } catch (IOException e3) {
            e = e3;
            dataOutputStream2 = dataOutputStream;
            zzazk.zzc("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e, "LargeParcelTeleporter.pipeData.1");
            if (dataOutputStream2 == null) {
                k.a(outputStream);
            } else {
                k.a(dataOutputStream2);
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 == null) {
                k.a(outputStream);
            } else {
                k.a(dataOutputStream2);
            }
            throw th;
        }
    }
}
