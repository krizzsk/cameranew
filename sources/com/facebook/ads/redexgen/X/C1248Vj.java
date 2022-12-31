package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Vj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1248Vj implements InterfaceC0794Di {
    public static byte[] A02;
    public static String[] A03 = {"ggGLmhyInJSffjkfPU8VRn", "WisLA7DCjwWBxH7MqLlw8w9Z4gicIVYK", "baeaQjGS5RYnakDSUMD4HiL2ABi7hiKM", "QvfNkpkg0VH", "dkSLNeeU5ck3Twa6KyaCdOuwvlu7l8iW", "e6Ade", "C9ShSy7zMtGRXyHgR8PAzFWulvZi4KLP", "w2lskP6GH6NJyN70rzATNYjf2L9mjjHA"};
    public final int A00;
    public final List<Format> A01;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 6);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-120, -105, -105, -109, -112, -118, -120, -101, -112, -106, -107, 86, -118, -116, -120, 84, 93, 87, 95, -114, -99, -99, -103, -106, -112, -114, -95, -106, -100, -101, 92, -112, -110, -114, 90, 100, 93, 101};
    }

    static {
        A02();
    }

    public C1248Vj() {
        this(0);
    }

    public C1248Vj(int i2) {
        this(i2, Collections.emptyList());
    }

    public C1248Vj(int i2, List<Format> list) {
        this.A00 = i2;
        if (!A03(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.A00(null, A01(0, 19, 33), 0, null));
        }
        this.A01 = list;
    }

    private C0790De A00(C0793Dh c0793Dh) {
        String A01;
        int i2;
        if (A03(32)) {
            return new C0790De(this.A01);
        }
        IV iv = new IV(c0793Dh.A03);
        List<Format> list = this.A01;
        while (true) {
            int A04 = iv.A04();
            String[] strArr = A03;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[6] = "9wGqNU4xey1NmHgGithGb88lbeAMl0Qa";
            strArr2[5] = "Me3yU";
            if (A04 > 0) {
                int descriptorLength = iv.A0E();
                int descriptorTag = iv.A0E();
                int A06 = iv.A06() + descriptorTag;
                if (descriptorLength == 134) {
                    list = new ArrayList<>();
                    int nextDescriptorPosition = iv.A0E();
                    int i3 = nextDescriptorPosition & 31;
                    for (int accessibilityChannel = 0; accessibilityChannel < i3; accessibilityChannel++) {
                        String A0S = iv.A0S(3);
                        int A0E = iv.A0E();
                        int captionTypeByte = A0E & 128;
                        int captionTypeByte2 = captionTypeByte != 0 ? 1 : 0;
                        if (captionTypeByte2 != 0) {
                            A01 = A01(19, 19, 39);
                            i2 = A0E & 63;
                        } else {
                            A01 = A01(0, 19, 33);
                            i2 = 1;
                        }
                        list.add(Format.A08(null, A01, null, -1, 0, A0S, i2, null));
                        iv.A0Z(2);
                    }
                }
                iv.A0Y(A06);
            } else {
                return new C0790De(list);
            }
        }
    }

    private boolean A03(int i2) {
        return (this.A00 & i2) != 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0794Di
    public final SparseArray<InterfaceC0796Dk> A4I() {
        return new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0794Di
    public final InterfaceC0796Dk A4N(int i2, C0793Dh c0793Dh) {
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                return new C1241Va(new C1242Vb(c0793Dh.A01));
            }
            if (i2 == 15) {
                if (A03(2)) {
                    return null;
                }
                return new C1241Va(new Vk(false, c0793Dh.A01));
            } else if (i2 == 17) {
                if (A03(2)) {
                    return null;
                }
                return new C1241Va(new C1243Vc(c0793Dh.A01));
            } else if (i2 != 21) {
                if (i2 == 27) {
                    if (A03(4)) {
                        return null;
                    }
                    return new C1241Va(new Vf(A00(c0793Dh), A03(1), A03(8)));
                } else if (i2 != 36) {
                    if (i2 != 89) {
                        if (i2 != 138) {
                            if (i2 != 129) {
                                if (i2 != 130) {
                                    if (A03[7].charAt(7) != 'G') {
                                        throw new RuntimeException();
                                    }
                                    A03[2] = "XLjLYE0qXOuIs9WeBuWhNfn9nKSLWrdd";
                                    if (i2 == 134) {
                                        if (A03(16)) {
                                            return null;
                                        }
                                        return new VX(new VW());
                                    } else if (i2 != 135) {
                                        return null;
                                    }
                                }
                            }
                            return new C1241Va(new C1251Vn(c0793Dh.A01));
                        }
                        return new C1241Va(new C1247Vi(c0793Dh.A01));
                    }
                    return new C1241Va(new C1246Vh(c0793Dh.A02));
                } else {
                    return new C1241Va(new C1245Ve(A00(c0793Dh)));
                }
            } else {
                return new C1241Va(new C1244Vd());
            }
        }
        return new C1241Va(new Vg());
    }
}
