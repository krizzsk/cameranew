package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.b;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqx extends NativeAd {
    private final zzagr zzdgi;
    private final zzaqu zzdqq;
    private final NativeAd.AdChoicesInfo zzdqr;
    private final List<NativeAd.Image> zzdga = new ArrayList();
    private final List<MuteThisAdReason> zzdgj = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|2|3|(2:5|(5:8|(1:10)(1:17)|(3:12|13|14)(1:16)|15|6))|(3:19|20|(2:22|(5:25|(1:27)(1:34)|(3:29|30|31)(1:33)|32|23)))|36|37|(7:39|40|41|42|(2:44|45)|47|48)|53|40|41|42|(0)|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a4, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
        com.google.android.gms.internal.ads.zzazk.zzc("", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: RemoteException -> 0x00a4, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00a4, blocks: (B:39:0x008f, B:41:0x0097), top: B:51:0x008f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzaqx(com.google.android.gms.internal.ads.zzagr r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdga = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdgj = r1
            r5.zzdgi = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch: android.os.RemoteException -> L43
            if (r6 == 0) goto L47
            java.util.Iterator r6 = r6.iterator()     // Catch: android.os.RemoteException -> L43
        L20:
            boolean r2 = r6.hasNext()     // Catch: android.os.RemoteException -> L43
            if (r2 == 0) goto L47
            java.lang.Object r2 = r6.next()     // Catch: android.os.RemoteException -> L43
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L43
            if (r3 == 0) goto L35
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L43
            com.google.android.gms.internal.ads.zzaer r2 = com.google.android.gms.internal.ads.zzaeq.zzo(r2)     // Catch: android.os.RemoteException -> L43
            goto L36
        L35:
            r2 = r1
        L36:
            if (r2 == 0) goto L20
            java.util.List<com.google.android.gms.ads.nativead.NativeAd$Image> r3 = r5.zzdga     // Catch: android.os.RemoteException -> L43
            com.google.android.gms.internal.ads.zzaqu r4 = new com.google.android.gms.internal.ads.zzaqu     // Catch: android.os.RemoteException -> L43
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L43
            r3.add(r4)     // Catch: android.os.RemoteException -> L43
            goto L20
        L43:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        L47:
            com.google.android.gms.internal.ads.zzagr r6 = r5.zzdgi     // Catch: android.os.RemoteException -> L76
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch: android.os.RemoteException -> L76
            if (r6 == 0) goto L7a
            java.util.Iterator r6 = r6.iterator()     // Catch: android.os.RemoteException -> L76
        L53:
            boolean r2 = r6.hasNext()     // Catch: android.os.RemoteException -> L76
            if (r2 == 0) goto L7a
            java.lang.Object r2 = r6.next()     // Catch: android.os.RemoteException -> L76
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L76
            if (r3 == 0) goto L68
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L76
            com.google.android.gms.internal.ads.zzyn r2 = com.google.android.gms.internal.ads.zzyq.zzg(r2)     // Catch: android.os.RemoteException -> L76
            goto L69
        L68:
            r2 = r1
        L69:
            if (r2 == 0) goto L53
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzdgj     // Catch: android.os.RemoteException -> L76
            com.google.android.gms.internal.ads.zzys r4 = new com.google.android.gms.internal.ads.zzys     // Catch: android.os.RemoteException -> L76
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L76
            r3.add(r4)     // Catch: android.os.RemoteException -> L76
            goto L53
        L76:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        L7a:
            com.google.android.gms.internal.ads.zzagr r6 = r5.zzdgi     // Catch: android.os.RemoteException -> L88
            com.google.android.gms.internal.ads.zzaer r6 = r6.zztn()     // Catch: android.os.RemoteException -> L88
            if (r6 == 0) goto L8c
            com.google.android.gms.internal.ads.zzaqu r2 = new com.google.android.gms.internal.ads.zzaqu     // Catch: android.os.RemoteException -> L88
            r2.<init>(r6)     // Catch: android.os.RemoteException -> L88
            goto L8d
        L88:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        L8c:
            r2 = r1
        L8d:
            r5.zzdqq = r2
            com.google.android.gms.internal.ads.zzagr r6 = r5.zzdgi     // Catch: android.os.RemoteException -> La4
            com.google.android.gms.internal.ads.zzaej r6 = r6.zzto()     // Catch: android.os.RemoteException -> La4
            if (r6 == 0) goto La8
            com.google.android.gms.internal.ads.zzaqs r6 = new com.google.android.gms.internal.ads.zzaqs     // Catch: android.os.RemoteException -> La4
            com.google.android.gms.internal.ads.zzagr r2 = r5.zzdgi     // Catch: android.os.RemoteException -> La4
            com.google.android.gms.internal.ads.zzaej r2 = r2.zzto()     // Catch: android.os.RemoteException -> La4
            r6.<init>(r2)     // Catch: android.os.RemoteException -> La4
            r1 = r6
            goto La8
        La4:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        La8:
            r5.zzdqr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqx.<init>(com.google.android.gms.internal.ads.zzagr):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.nativead.NativeAd
    /* renamed from: zztm */
    public final b zzjs() {
        try {
            return this.zzdgi.zztm();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdgi.cancelUnconfirmedClick();
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void destroy() {
        try {
            this.zzdgi.destroy();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdgi.zztx();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdqr;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdgi.getAdvertiser();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getBody() {
        try {
            return this.zzdgi.getBody();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getCallToAction() {
        try {
            return this.zzdgi.getCallToAction();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdgi.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getHeadline() {
        try {
            return this.zzdgi.getHeadline();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final NativeAd.Image getIcon() {
        return this.zzdqq;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdga;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final MediaContent getMediaContent() {
        try {
            if (this.zzdgi.zzty() != null) {
                return new zzzw(this.zzdgi.zzty());
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdgj;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getPrice() {
        try {
            return this.zzdgi.getPrice();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final ResponseInfo getResponseInfo() {
        zzyx zzyxVar;
        try {
            zzyxVar = this.zzdgi.zzki();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            zzyxVar = null;
        }
        return ResponseInfo.zza(zzyxVar);
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdgi.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getStore() {
        try {
            return this.zzdgi.getStore();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdgi.isCustomClickGestureEnabled();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdgi.isCustomMuteThisAdEnabled();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzazk.zzev("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzdgi.zza((zzyn) null);
            } else if (muteThisAdReason instanceof zzys) {
                this.zzdgi.zza(((zzys) muteThisAdReason).zzrf());
            } else {
                zzazk.zzev("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdgi.performClick(bundle);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdgi.recordCustomClickGesture();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdgi.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdgi.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdgi.zza(new zzyo(muteThisAdListener));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdgi.zza(new zzaap(onPaidEventListener));
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to setOnPaidEventListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdgi.zza(new zzarc(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to setUnconfirmedClickListener", e2);
        }
    }
}
