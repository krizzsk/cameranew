package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.RemoteCreator;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class r extends RemoteCreator<o> {
    private static final r a = new r();

    private r() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i2, int i3) throws RemoteCreator.RemoteCreatorException {
        return a.c(context, i2, i3);
    }

    private final View c(Context context, int i2, int i3) throws RemoteCreator.RemoteCreatorException {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i2, i3, null);
            return (View) com.google.android.gms.dynamic.d.y0(getRemoteCreatorInstance(context).q(com.google.android.gms.dynamic.d.z0(context), signInButtonConfig));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    /* renamed from: b */
    public final o getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof o) {
            return (o) queryLocalInterface;
        }
        return new y(iBinder);
    }
}
