package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaek extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdfk = new ArrayList();
    private final zzaej zzdfv;

    public zzaek(zzaej zzaejVar) {
        zzaer zzaerVar;
        IBinder iBinder;
        this.zzdfv = zzaejVar;
        try {
            this.text = zzaejVar.getText();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            this.text = "";
        }
        try {
            for (zzaer zzaerVar2 : zzaejVar.zztd()) {
                if (!(zzaerVar2 instanceof IBinder) || (iBinder = (IBinder) zzaerVar2) == null) {
                    zzaerVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    if (queryLocalInterface instanceof zzaer) {
                        zzaerVar = (zzaer) queryLocalInterface;
                    } else {
                        zzaerVar = new zzaet(iBinder);
                    }
                }
                if (zzaerVar != null) {
                    this.zzdfk.add(new zzaes(zzaerVar));
                }
            }
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdfk;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }
}
