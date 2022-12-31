package com.hw.videoprocessor.f;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
/* compiled from: SSRC.java */
/* loaded from: classes2.dex */
public class b {
    private static final int[] q = {0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};
    private static final int[] r = {1, 16, 20, 16, 16, 15, 16, 15};
    private static final int[] s = {8, 18, 27, 8, 8, 8, 10, 9};
    private static final double[][] t = {new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
    private ByteOrder a = ByteOrder.LITTLE_ENDIAN;
    private c b = new c();
    private double c = 170.0d;

    /* renamed from: d  reason: collision with root package name */
    private double f5269d = 100.0d;

    /* renamed from: e  reason: collision with root package name */
    private int f5270e = 65536;

    /* renamed from: f  reason: collision with root package name */
    private double[][] f5271f;

    /* renamed from: g  reason: collision with root package name */
    private int f5272g;

    /* renamed from: h  reason: collision with root package name */
    private int f5273h;

    /* renamed from: i  reason: collision with root package name */
    private int f5274i;

    /* renamed from: j  reason: collision with root package name */
    private int f5275j;

    /* renamed from: k  reason: collision with root package name */
    private double[] f5276k;

    /* renamed from: l  reason: collision with root package name */
    private int f5277l;
    private boolean m;
    private int n;
    private long o;
    private long p;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(java.io.InputStream r25, java.io.OutputStream r26, int r27, int r28, int r29, int r30, int r31, int r32, double r33, int r35, boolean r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.f.b.<init>(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, int, double, int, boolean):void");
    }

    private int a(double d2) {
        return (int) (d2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? d2 + 0.5d : d2 - 0.5d);
    }

    private double b(double d2) {
        if (d2 <= 21.0d) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (d2 <= 50.0d) {
            double d3 = d2 - 21.0d;
            return (Math.pow(d3, 0.4d) * 0.5842d) + (d3 * 0.07886d);
        }
        return (d2 - 8.7d) * 0.1102d;
    }

    private int e(int i2, int i3) {
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 == 0) {
                return i5;
            }
            i3 = i5 % i2;
        }
    }

    private double g(int i2, double d2, double d3) {
        double d4 = 1.0d / d3;
        return d2 * 2.0d * d4 * m(i2 * 6.283185307179586d * d2 * d4);
    }

    private void j(int i2) {
    }

    private void k() {
        this.o = System.currentTimeMillis();
        this.p = 0L;
        this.n = -1;
    }

    private void l(double d2) {
        if (this.m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        int i2 = d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : (int) ((currentTimeMillis * (1.0d - d2)) / d2);
        int i3 = (int) (d2 * 100.0d);
        if (i3 != this.n || currentTimeMillis != this.p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i3));
            this.n = i3;
        }
        if (currentTimeMillis != this.p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i2));
            this.p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    private double m(double d2) {
        if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 1.0d;
        }
        return Math.sin(d2) / d2;
    }

    private double o(double d2, int i2, double d3, double d4) {
        double d5 = 4.0d * d2 * d2;
        double d6 = i2 - 1.0d;
        return a.a(d3 * Math.sqrt(1.0d - (d5 / (d6 * d6)))) / d4;
    }

    public int c(double d2, double[] dArr, int i2, int i3) {
        int i4;
        double a;
        if (i2 == 1) {
            double[] dArr2 = this.f5276k;
            int i5 = this.f5277l;
            this.f5277l = i5 + 1;
            double d3 = d2 + dArr2[i5 & 65535];
            int i6 = this.f5274i;
            if (d3 < i6) {
                double d4 = d3 / i6;
                if (dArr[0] >= d4) {
                    d4 = dArr[0];
                }
                dArr[0] = d4;
                d3 = i6;
            }
            int i7 = this.f5275j;
            if (d3 > i7) {
                double d5 = d3 / i7;
                if (dArr[0] >= d5) {
                    d5 = dArr[0];
                }
                dArr[0] = d5;
                d3 = i7;
            }
            return a(d3);
        }
        double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i8 = 0;
        while (true) {
            i4 = this.f5273h;
            if (i8 >= i4) {
                break;
            }
            d6 += t[this.f5272g][i8] * this.f5271f[i3][i8];
            i8++;
        }
        double d7 = d2 + d6;
        double[] dArr3 = this.f5276k;
        int i9 = this.f5277l;
        this.f5277l = i9 + 1;
        double d8 = dArr3[65535 & i9] + d7;
        for (int i10 = i4 - 2; i10 >= 0; i10--) {
            double[][] dArr4 = this.f5271f;
            dArr4[i3][i10 + 1] = dArr4[i3][i10];
        }
        int i11 = this.f5274i;
        if (d8 < i11) {
            double d9 = d8 / i11;
            if (dArr[0] >= d9) {
                d9 = dArr[0];
            }
            dArr[0] = d9;
            a = i11;
            double[][] dArr5 = this.f5271f;
            dArr5[i3][0] = a - d7;
            if (dArr5[i3][0] > 1.0d) {
                dArr5[i3][0] = 1.0d;
            }
            if (dArr5[i3][0] < -1.0d) {
                dArr5[i3][0] = -1.0d;
            }
        } else {
            int i12 = this.f5275j;
            if (d8 > i12) {
                double d10 = d8 / i12;
                if (dArr[0] >= d10) {
                    d10 = dArr[0];
                }
                dArr[0] = d10;
                a = i12;
                double[][] dArr6 = this.f5271f;
                dArr6[i3][0] = a - d7;
                if (dArr6[i3][0] > 1.0d) {
                    dArr6[i3][0] = 1.0d;
                }
                if (dArr6[i3][0] < -1.0d) {
                    dArr6[i3][0] = -1.0d;
                }
            } else {
                a = a(d8);
                this.f5271f[i3][0] = a - d7;
            }
        }
        return (int) a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0433 A[LOOP:4: B:99:0x042f->B:101:0x0433, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0440 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x086d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x08e1  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x08e5 A[LOOP:14: B:266:0x08e3->B:267:0x08e5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0907 A[LOOP:15: B:269:0x0905->B:270:0x0907, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0918  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0921  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double d(java.io.InputStream r69, java.io.OutputStream r70, int r71, int r72, int r73, int r74, int r75, double r76, int r78, boolean r79, int r80) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.f.b.d(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    protected byte[] f(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    public int h(int i2, int i3, int i4, int i5, int i6, int i7, double d2) {
        int[] iArr = new int[97];
        int i8 = 1;
        while (i8 < 6 && i2 != q[i8]) {
            i8++;
        }
        if ((i6 == 3 || i6 == 4) && i8 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i2));
        }
        i8 = (i6 == 2 || i8 == 6) ? 0 : 0;
        if (i6 == 4 && (i8 == 1 || i8 == 2)) {
            i8 += 5;
        }
        this.f5272g = i8;
        this.f5271f = new double[i3];
        this.f5273h = r[i8];
        for (int i9 = 0; i9 < i3; i9++) {
            this.f5271f[i9] = new double[this.f5273h];
        }
        this.f5274i = i4;
        this.f5275j = i5;
        this.f5276k = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i10 = 0; i10 < 97; i10++) {
            iArr[i10] = random.nextInt();
        }
        if (i7 == 0) {
            for (int i11 = 0; i11 < 65536; i11++) {
                int nextInt = random.nextInt() % 97;
                int i12 = iArr[nextInt];
                iArr[nextInt] = random.nextInt();
                this.f5276k[i11] = ((i12 / 2.147483647E9d) - 0.5d) * d2;
            }
        } else if (i7 == 1) {
            for (int i13 = 0; i13 < 65536; i13++) {
                int nextInt2 = random.nextInt() % 97;
                int i14 = iArr[nextInt2];
                iArr[nextInt2] = random.nextInt();
                int nextInt3 = random.nextInt() % 97;
                int i15 = iArr[nextInt3];
                iArr[nextInt3] = random.nextInt();
                this.f5276k[i13] = d2 * ((i14 / 2.147483647E9d) - (i15 / 2.147483647E9d));
            }
        } else if (i7 == 2) {
            boolean z = false;
            double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            for (int i16 = 0; i16 < 65536; i16++) {
                if (!z) {
                    int nextInt4 = random.nextInt() % 97;
                    double d5 = iArr[nextInt4] / 2.147483647E9d;
                    iArr[nextInt4] = random.nextInt();
                    if (d5 == 1.0d) {
                        d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    }
                    d3 = Math.sqrt(Math.log(1.0d - d5) * (-2.0d));
                    int nextInt5 = random.nextInt() % 97;
                    iArr[nextInt5] = random.nextInt();
                    d4 = 6.283185307179586d * (iArr[nextInt5] / 2.147483647E9d);
                    this.f5276k[i16] = d2 * d3 * Math.cos(d4);
                    z = true;
                } else {
                    this.f5276k[i16] = d2 * d3 * Math.sin(d4);
                    z = false;
                }
            }
        }
        this.f5277l = 0;
        if (i6 == 0 || i6 == 1) {
            return 1;
        }
        return s[this.f5272g];
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x025c A[EDGE_INSN: B:69:0x025c->B:66:0x025c ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double i(java.io.InputStream r28, java.io.OutputStream r29, int r30, int r31, int r32, double r33, int r35, boolean r36, int r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.f.b.i(java.io.InputStream, java.io.OutputStream, int, int, int, double, int, boolean, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:249:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x08c4  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0964  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0970  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double n(java.io.InputStream r71, java.io.OutputStream r72, int r73, int r74, int r75, int r76, int r77, double r78, int r80, boolean r81, int r82) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.f.b.n(java.io.InputStream, java.io.OutputStream, int, int, int, int, int, double, int, boolean, int):double");
    }

    protected void p(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(f(byteBuffer));
        } catch (IOException unused) {
        }
    }
}
