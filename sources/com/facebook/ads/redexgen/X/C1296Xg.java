package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Xg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1296Xg extends AbstractC06506z<HashMap<String, Integer>> {
    public static byte[] A00;
    public static String[] A01 = {"Nq1Kb9TOHvzWwANjwVGizSKF", "JWM4IVLufHQSkDOJGyecwcJ9XG51cvJk", "QEyZFLJTZNzdsjJkYvljVioyRUG2XSKd", "n7SG", "D5E01LJ4kvbqK2OQmpgiuXTPXhrvg0RI", "iCSdHB", "iogVWxzO6MdlKqT6F77t9UC3cqMLTkpE", "gUxLojtchnnArKauALgqkHsSrkkPr"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-44};
        if (A01[1].length() != 32) {
            throw new RuntimeException();
        }
        A01[5] = "SxUYlD3A0WMAhXB5PTE";
        A00 = bArr;
    }

    static {
        A01();
    }

    public C1296Xg(long j2, @Nullable C06486x c06486x, HashMap<String, Integer> signalValues) {
        super(j2, c06486x, signalValues, EnumC06496y.A07);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final int A06() {
        int i2 = 0;
        for (String key : A07().keySet()) {
            i2 += key.getBytes().length;
        }
        return (A07().size() * 4) + i2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        HashMap<String, Integer> A07 = A07();
        Set<String> keySet = A07.keySet();
        JSONObject jSONObject2 = new JSONObject();
        for (String str : keySet) {
            jSONObject2.put(str, A07.get(str));
        }
        jSONObject.put(A00(0, 1, 13), jSONObject2);
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.HashMap<java.lang.String, java.lang.Integer>> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    @SuppressLint({"Nullable Dereference"})
    public final boolean A0A(AbstractC06506z<HashMap<String, Integer>> abstractC06506z) {
        if (A07() != null) {
            HashMap<String, Integer> A07 = abstractC06506z.A07();
            if (A01[6].charAt(14) == 'I') {
                throw new RuntimeException();
            }
            A01[1] = "ZRsxwV5SobJQ5cDwe7XAzXaVJFGFHkOZ";
            if (A07 != null) {
                if (A07().size() != abstractC06506z.A07().size()) {
                    return false;
                }
                HashMap<String, Integer> A072 = abstractC06506z.A07();
                HashMap<String, Integer> A073 = A07();
                Iterator<String> it = A072.keySet().iterator();
                Iterator<String> prevSignalValueKeys = A073.keySet().iterator();
                while (it.hasNext() && prevSignalValueKeys.hasNext()) {
                    String newSignalValueKey = it.next();
                    String next = prevSignalValueKeys.next();
                    if (newSignalValueKey.equals(next) || !A072.containsKey(newSignalValueKey) || !A073.containsKey(next) || !A072.get(newSignalValueKey).equals(A073.get(next))) {
                        return false;
                    }
                    while (it.hasNext()) {
                        String newSignalValueKey2 = it.next();
                        String next2 = prevSignalValueKeys.next();
                        if (newSignalValueKey2.equals(next2)) {
                        }
                        return false;
                    }
                }
                return true;
            }
        }
        return A07() == null && abstractC06506z.A07() == null;
    }
}
