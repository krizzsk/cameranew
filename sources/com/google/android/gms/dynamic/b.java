package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static abstract class a extends zza implements b {

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        /* renamed from: com.google.android.gms.dynamic.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0140a extends zzb implements b {
            C0140a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static b x0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof b) {
                return (b) queryLocalInterface;
            }
            return new C0140a(iBinder);
        }
    }
}
