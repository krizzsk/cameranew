package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Base256Encoder.java */
/* loaded from: classes2.dex */
public final class b implements g {
    private static char c(char c, int i2) {
        int i3 = c + ((i2 * 149) % 255) + 1;
        return i3 <= 255 ? (char) i3 : (char) (i3 + InputDeviceCompat.SOURCE_ANY);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.i()) {
                break;
            }
            sb.append(hVar.c());
            hVar.f5010f++;
            if (j.n(hVar.d(), hVar.f5010f, b()) != b()) {
                hVar.o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a = hVar.a() + length + 1;
        hVar.q(a);
        boolean z = hVar.g().a() - a > 0;
        if (hVar.i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            hVar.r(c(sb.charAt(i2), hVar.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
