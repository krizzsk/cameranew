package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzags extends UnifiedNativeAd {
    private final zzaes zzdgb;
    private final NativeAd.AdChoicesInfo zzdgc;
    private final zzagr zzdgi;
    private final List<NativeAd.Image> zzdga = new ArrayList();
    private final VideoController zzckl = new VideoController();
    private final List<MuteThisAdReason> zzdgj = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(3:2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6)))|24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28))|41|42|(7:44|45|46|47|(2:49|50)|52|53)|58|45|46|47|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bb, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bc, code lost:
        com.google.android.gms.internal.ads.zzazk.zzc("", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ae A[Catch: RemoteException -> 0x00bb, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00bb, blocks: (B:44:0x00a6, B:46:0x00ae), top: B:56:0x00a6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzags(com.google.android.gms.internal.ads.zzagr r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdga = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzckl = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdgj = r1
            r5.zzdgi = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch: android.os.RemoteException -> L5a
            if (r6 == 0) goto L5e
            java.util.Iterator r6 = r6.iterator()     // Catch: android.os.RemoteException -> L5a
        L27:
            boolean r2 = r6.hasNext()     // Catch: android.os.RemoteException -> L5a
            if (r2 == 0) goto L5e
            java.lang.Object r2 = r6.next()     // Catch: android.os.RemoteException -> L5a
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L5a
            if (r3 == 0) goto L4c
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L5a
            if (r2 == 0) goto L4c
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch: android.os.RemoteException -> L5a
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaer     // Catch: android.os.RemoteException -> L5a
            if (r4 == 0) goto L46
            com.google.android.gms.internal.ads.zzaer r3 = (com.google.android.gms.internal.ads.zzaer) r3     // Catch: android.os.RemoteException -> L5a
            goto L4d
        L46:
            com.google.android.gms.internal.ads.zzaet r3 = new com.google.android.gms.internal.ads.zzaet     // Catch: android.os.RemoteException -> L5a
            r3.<init>(r2)     // Catch: android.os.RemoteException -> L5a
            goto L4d
        L4c:
            r3 = r1
        L4d:
            if (r3 == 0) goto L27
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzdga     // Catch: android.os.RemoteException -> L5a
            com.google.android.gms.internal.ads.zzaes r4 = new com.google.android.gms.internal.ads.zzaes     // Catch: android.os.RemoteException -> L5a
            r4.<init>(r3)     // Catch: android.os.RemoteException -> L5a
            r2.add(r4)     // Catch: android.os.RemoteException -> L5a
            goto L27
        L5a:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        L5e:
            com.google.android.gms.internal.ads.zzagr r6 = r5.zzdgi     // Catch: android.os.RemoteException -> L8d
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch: android.os.RemoteException -> L8d
            if (r6 == 0) goto L91
            java.util.Iterator r6 = r6.iterator()     // Catch: android.os.RemoteException -> L8d
        L6a:
            boolean r2 = r6.hasNext()     // Catch: android.os.RemoteException -> L8d
            if (r2 == 0) goto L91
            java.lang.Object r2 = r6.next()     // Catch: android.os.RemoteException -> L8d
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L8d
            if (r3 == 0) goto L7f
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L8d
            com.google.android.gms.internal.ads.zzyn r2 = com.google.android.gms.internal.ads.zzyq.zzg(r2)     // Catch: android.os.RemoteException -> L8d
            goto L80
        L7f:
            r2 = r1
        L80:
            if (r2 == 0) goto L6a
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzdgj     // Catch: android.os.RemoteException -> L8d
            com.google.android.gms.internal.ads.zzys r4 = new com.google.android.gms.internal.ads.zzys     // Catch: android.os.RemoteException -> L8d
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L8d
            r3.add(r4)     // Catch: android.os.RemoteException -> L8d
            goto L6a
        L8d:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        L91:
            com.google.android.gms.internal.ads.zzagr r6 = r5.zzdgi     // Catch: android.os.RemoteException -> L9f
            com.google.android.gms.internal.ads.zzaer r6 = r6.zztn()     // Catch: android.os.RemoteException -> L9f
            if (r6 == 0) goto La3
            com.google.android.gms.internal.ads.zzaes r2 = new com.google.android.gms.internal.ads.zzaes     // Catch: android.os.RemoteException -> L9f
            r2.<init>(r6)     // Catch: android.os.RemoteException -> L9f
            goto La4
        L9f:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        La3:
            r2 = r1
        La4:
            r5.zzdgb = r2
            com.google.android.gms.internal.ads.zzagr r6 = r5.zzdgi     // Catch: android.os.RemoteException -> Lbb
            com.google.android.gms.internal.ads.zzaej r6 = r6.zzto()     // Catch: android.os.RemoteException -> Lbb
            if (r6 == 0) goto Lbf
            com.google.android.gms.internal.ads.zzaek r6 = new com.google.android.gms.internal.ads.zzaek     // Catch: android.os.RemoteException -> Lbb
            com.google.android.gms.internal.ads.zzagr r2 = r5.zzdgi     // Catch: android.os.RemoteException -> Lbb
            com.google.android.gms.internal.ads.zzaej r2 = r2.zzto()     // Catch: android.os.RemoteException -> Lbb
            r6.<init>(r2)     // Catch: android.os.RemoteException -> Lbb
            r1 = r6
            goto Lbf
        Lbb:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r6)
        Lbf:
            r5.zzdgc = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzags.<init>(com.google.android.gms.internal.ads.zzagr):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: zztm */
    public final b zzjs() {
        try {
            return this.zzdgi.zztm();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdgi.cancelUnconfirmedClick();
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzdgi.destroy();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdgi.zztx();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdgc;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdgi.getAdvertiser();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzdgi.getBody();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzdgi.getCallToAction();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzdgi.getHeadline();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzdgb;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdga;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdgi.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdgj;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzdgi.getPrice();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzdgi.getStore();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdgi.getVideoController() != null) {
                this.zzckl.zza(this.zzdgi.getVideoController());
            }
        } catch (RemoteException e2) {
            zzazk.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzckl;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdgi.isCustomClickGestureEnabled();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdgi.isCustomMuteThisAdEnabled();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdgi.performClick(bundle);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdgi.recordCustomClickGesture();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdgi.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdgi.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdgi.zza(new zzyo(muteThisAdListener));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdgi.zza(new zzaap(onPaidEventListener));
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to setOnPaidEventListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdgi.zza(new zzahg(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzazk.zzc("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzjw() {
        try {
            b zztp = this.zzdgi.zztp();
            if (zztp != null) {
                return d.y0(zztp);
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }
}
