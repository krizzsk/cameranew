package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import us.pinguo.camera360.shop.StoreActivity2;
/* compiled from: DestinationStore.java */
/* loaded from: classes4.dex */
public class d0 extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        return new Intent(context, StoreActivity2.class);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://camera360/store");
    }
}
