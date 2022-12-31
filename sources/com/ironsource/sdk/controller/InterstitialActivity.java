package com.ironsource.sdk.controller;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class InterstitialActivity extends ControllerActivity {
    private static final String q = InterstitialActivity.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.ironsource.sdk.utils.d.d(q, "onCreate");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.ironsource.sdk.utils.d.d(q, "onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.ironsource.sdk.utils.d.d(q, "onResume");
    }
}
