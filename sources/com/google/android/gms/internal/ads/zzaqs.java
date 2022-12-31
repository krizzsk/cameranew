package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqs extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdfk = new ArrayList();

    public zzaqs(zzaej zzaejVar) {
        try {
            this.text = zzaejVar.getText();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            this.text = "";
        }
        try {
            for (zzaer zzaerVar : zzaejVar.zztd()) {
                zzaer zzo = zzaerVar instanceof IBinder ? zzaeq.zzo((IBinder) zzaerVar) : null;
                if (zzo != null) {
                    this.zzdfk.add(new zzaqu(zzo));
                }
            }
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdfk;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }
}
