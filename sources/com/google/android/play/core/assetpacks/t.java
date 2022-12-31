package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* loaded from: classes2.dex */
final class t extends s<ParcelFileDescriptor> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(z zVar, com.google.android.play.core.tasks.p<ParcelFileDescriptor> pVar) {
        super(zVar, pVar);
    }

    @Override // com.google.android.play.core.assetpacks.s, com.google.android.play.core.internal.x1
    public final void r(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.r(bundle, bundle2);
        this.a.e((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
