package com.tapjoy.internal;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
/* loaded from: classes3.dex */
public class TJPlacementListenerNative implements TJPlacementListener {
    private final long a;

    private TJPlacementListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJPlacementListenerNative(j2);
    }

    private static native void onClickNative(long j2, TJPlacement tJPlacement, String str);

    private static native void onContentDismissNative(long j2, TJPlacement tJPlacement, String str);

    private static native void onContentReadyNative(long j2, TJPlacement tJPlacement, String str);

    private static native void onContentShowNative(long j2, TJPlacement tJPlacement, String str);

    private static native void onPurchaseRequestNative(long j2, TJPlacement tJPlacement, String str, TJActionRequest tJActionRequest, String str2, String str3, String str4);

    private static native void onRequestFailureNative(long j2, TJPlacement tJPlacement, String str, int i2, String str2);

    private static native void onRequestSuccessNative(long j2, TJPlacement tJPlacement, String str);

    private static native void onRewardRequestNative(long j2, TJPlacement tJPlacement, String str, TJActionRequest tJActionRequest, String str2, String str3, String str4, int i2);

    @Override // com.tapjoy.TJPlacementListener
    public void onClick(TJPlacement tJPlacement) {
        onClickNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentDismiss(TJPlacement tJPlacement) {
        onContentDismissNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentReady(TJPlacement tJPlacement) {
        onContentReadyNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentShow(TJPlacement tJPlacement) {
        onContentShowNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        onPurchaseRequestNative(this.a, tJPlacement, tJPlacement.getName(), tJActionRequest, tJActionRequest.getRequestId(), tJActionRequest.getToken(), str);
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
        onRequestFailureNative(this.a, tJPlacement, tJPlacement.getName(), tJError.code, tJError.message);
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRequestSuccess(TJPlacement tJPlacement) {
        onRequestSuccessNative(this.a, tJPlacement, tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i2) {
        onRewardRequestNative(this.a, tJPlacement, tJPlacement.getName(), tJActionRequest, tJActionRequest.getRequestId(), tJActionRequest.getToken(), str, i2);
    }
}
