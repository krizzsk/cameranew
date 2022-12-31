package us.pinguo.foundation.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: Destination.java */
/* loaded from: classes4.dex */
public class c {
    private Uri a;
    private Bundle b = new Bundle();
    private a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Uri uri, a aVar) {
        this.a = uri;
        this.c = aVar;
    }

    public Intent a(Context context) {
        return this.c.a(this.a, this.b, context);
    }

    public void b(Context context) {
        if (this.c.c(this.a, this.b)) {
            Intent a = this.c.a(this.a, this.b, context);
            a.putExtras(this.b);
            this.c.b(this.a, context, a);
        }
    }

    public c c(String str, boolean z) {
        this.b.putBoolean(str, z);
        return this;
    }

    public c d(Bundle bundle) {
        this.b = bundle;
        return this;
    }
}
