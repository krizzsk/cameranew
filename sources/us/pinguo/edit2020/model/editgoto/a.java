package us.pinguo.edit2020.model.editgoto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.text.t;
/* compiled from: DestinationEdit.kt */
/* loaded from: classes4.dex */
public final class a extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        com.pinguo.camera360.j.a.a(context, uri);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        boolean x;
        x = t.x(String.valueOf(uri), "app://camera360/edit", false, 2, null);
        return x;
    }
}
