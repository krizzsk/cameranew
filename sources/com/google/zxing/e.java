package com.google.zxing;

import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.k;
import com.google.zxing.oned.n;
import com.google.zxing.oned.r;
import java.util.Map;
/* compiled from: MultiFormatWriter.java */
/* loaded from: classes2.dex */
public final class e implements j {

    /* compiled from: MultiFormatWriter.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        j jVar;
        switch (a.a[barcodeFormat.ordinal()]) {
            case 1:
                jVar = new com.google.zxing.oned.j();
                break;
            case 2:
                jVar = new r();
                break;
            case 3:
                jVar = new com.google.zxing.oned.i();
                break;
            case 4:
                jVar = new n();
                break;
            case 5:
                jVar = new com.google.zxing.n.b();
                break;
            case 6:
                jVar = new com.google.zxing.oned.e();
                break;
            case 7:
                jVar = new com.google.zxing.oned.g();
                break;
            case 8:
                jVar = new Code128Writer();
                break;
            case 9:
                jVar = new k();
                break;
            case 10:
                jVar = new com.google.zxing.m.a();
                break;
            case 11:
                jVar = new com.google.zxing.oned.b();
                break;
            case 12:
                jVar = new com.google.zxing.l.a();
                break;
            case 13:
                jVar = new com.google.zxing.k.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return jVar.a(str, barcodeFormat, i2, i3, map);
    }
}
