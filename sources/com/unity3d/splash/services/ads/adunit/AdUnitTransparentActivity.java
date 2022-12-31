package com.unity3d.splash.services.ads.adunit;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.unity3d.splash.services.c.a.c;
/* loaded from: classes3.dex */
public class AdUnitTransparentActivity extends AdUnitActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.splash.services.ads.adunit.AdUnitActivity
    public void a() {
        super.a();
        c.b(this.a, new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.splash.services.ads.adunit.AdUnitActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.b(this.a, new ColorDrawable(0));
    }
}
