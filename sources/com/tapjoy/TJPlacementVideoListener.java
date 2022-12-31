package com.tapjoy;
/* loaded from: classes3.dex */
public interface TJPlacementVideoListener {
    void onVideoComplete(TJPlacement tJPlacement);

    void onVideoError(TJPlacement tJPlacement, String str);

    void onVideoStart(TJPlacement tJPlacement);
}
