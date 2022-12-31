package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdwd {
    private final String className;
    private final zzdwg zzhvu;
    private zzdwg zzhvv;
    private boolean zzhvw;

    private zzdwd(String str) {
        zzdwg zzdwgVar = new zzdwg();
        this.zzhvu = zzdwgVar;
        this.zzhvv = zzdwgVar;
        this.zzhvw = false;
        this.className = (String) zzdwl.checkNotNull(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdwg zzdwgVar = this.zzhvu.zzhvx;
        String str = "";
        while (zzdwgVar != null) {
            Object obj = zzdwgVar.value;
            sb.append(str);
            if (obj != null && obj.getClass().isArray()) {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            } else {
                sb.append(obj);
            }
            zzdwgVar = zzdwgVar.zzhvx;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdwd zzy(@NullableDecl Object obj) {
        zzdwg zzdwgVar = new zzdwg();
        this.zzhvv.zzhvx = zzdwgVar;
        this.zzhvv = zzdwgVar;
        zzdwgVar.value = obj;
        return this;
    }
}
