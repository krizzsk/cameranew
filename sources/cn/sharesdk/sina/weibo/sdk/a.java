package cn.sharesdk.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.util.StateSet;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.mob.tools.utils.Data;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class a {
    public static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, StateSet.WILD_CARD}, new int[]{i3, i3, i3, i2});
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            int i2 = 0;
            while (true) {
                Signature[] signatureArr = packageInfo.signatures;
                if (i2 >= signatureArr.length) {
                    break;
                }
                byte[] byteArray = signatureArr[i2].toByteArray();
                if (byteArray != null) {
                    return Data.MD5(byteArray);
                }
                i2++;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static byte[] a(byte[] bArr) {
        boolean z;
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = (bArr[i2] & Draft_75.END_OF_FRAME) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < bArr.length) {
                i4 |= bArr[i5] & Draft_75.END_OF_FRAME;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < bArr.length) {
                i6 |= bArr[i7] & Draft_75.END_OF_FRAME;
            } else {
                z2 = false;
            }
            int i8 = 64;
            bArr2[i3 + 3] = (byte) charArray[z2 ? i6 & 63 : 64];
            int i9 = i6 >> 6;
            int i10 = i3 + 2;
            if (z) {
                i8 = i9 & 63;
            }
            bArr2[i10] = (byte) charArray[i8];
            int i11 = i9 >> 6;
            bArr2[i3 + 1] = (byte) charArray[i11 & 63];
            bArr2[i3 + 0] = (byte) charArray[(i11 >> 6) & 63];
            i2 += 3;
            i3 += 4;
        }
        return bArr2;
    }
}
