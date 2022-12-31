package cn.sharesdk.framework.utils;

import java.io.IOException;
/* compiled from: UnicodeEscaper.java */
/* loaded from: classes.dex */
public abstract class j implements Escaper {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnicodeEscaper.java */
    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal<char[]> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    protected static final int b(CharSequence charSequence, int i2, int i3) {
        if (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            int i4 = i2 + 1;
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append((int) charAt);
                sb.append(" at index ");
                sb.append(i4 - 1);
                throw new IllegalArgumentException(sb.toString());
            } else if (i4 == i3) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i4);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i4);
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    protected int a(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            int b = b(charSequence, i2, i3);
            if (b < 0 || a(b) != null) {
                break;
            }
            i2 += Character.isSupplementaryCodePoint(b) ? 2 : 1;
        }
        return i2;
    }

    protected abstract char[] a(int i2);

    @Override // cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        int a2 = a(str, 0, length);
        return a2 == length ? str : a(str, a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(String str, int i2) {
        int length = str.length();
        char[] cArr = new a().get();
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int b = b(str, i2, length);
            if (b >= 0) {
                char[] a2 = a(b);
                if (a2 != null) {
                    int i5 = i2 - i3;
                    int i6 = i4 + i5;
                    int length2 = a2.length + i6;
                    if (cArr.length < length2) {
                        cArr = a(cArr, i4, length2 + (length - i2) + 32);
                    }
                    if (i5 > 0) {
                        str.getChars(i3, i2, cArr, i4);
                        i4 = i6;
                    }
                    if (a2.length > 0) {
                        System.arraycopy(a2, 0, cArr, i4, a2.length);
                        i4 += a2.length;
                    }
                }
                i3 = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + i2;
                i2 = a(str, i3, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i7 = length - i3;
        if (i7 > 0) {
            int i8 = i7 + i4;
            if (cArr.length < i8) {
                cArr = a(cArr, i4, i8);
            }
            str.getChars(i3, length, cArr, i4);
            i4 = i8;
        }
        return new String(cArr, 0, i4);
    }

    @Override // cn.sharesdk.framework.utils.Escaper
    public Appendable escape(final Appendable appendable) {
        e.a(appendable);
        return new Appendable() { // from class: cn.sharesdk.framework.utils.j.1
            int a = -1;
            char[] b = new char[2];

            private void a(char[] cArr, int i2) throws IOException {
                for (int i3 = 0; i3 < i2; i3++) {
                    appendable.append(cArr[i3]);
                }
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) throws IOException {
                return append(charSequence, 0, charSequence.length());
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
                int i4;
                if (i2 < i3) {
                    if (this.a != -1) {
                        char charAt = charSequence.charAt(i2);
                        int i5 = i2 + 1;
                        if (Character.isLowSurrogate(charAt)) {
                            char[] a2 = j.this.a(Character.toCodePoint((char) this.a, charAt));
                            if (a2 != null) {
                                a(a2, a2.length);
                                i2 = i5;
                            } else {
                                appendable.append((char) this.a);
                            }
                            this.a = -1;
                            i4 = i2;
                            i2 = i5;
                        } else {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + charAt);
                        }
                    } else {
                        i4 = i2;
                    }
                    while (true) {
                        int a3 = j.this.a(charSequence, i2, i3);
                        if (a3 > i4) {
                            appendable.append(charSequence, i4, a3);
                        }
                        if (a3 == i3) {
                            break;
                        }
                        int b = j.b(charSequence, a3, i3);
                        if (b < 0) {
                            this.a = -b;
                            break;
                        }
                        char[] a4 = j.this.a(b);
                        if (a4 != null) {
                            a(a4, a4.length);
                        } else {
                            a(this.b, Character.toChars(b, this.b, 0));
                        }
                        i4 = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + a3;
                        i2 = i4;
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) throws IOException {
                if (this.a != -1) {
                    if (Character.isLowSurrogate(c)) {
                        char[] a2 = j.this.a(Character.toCodePoint((char) this.a, c));
                        if (a2 != null) {
                            a(a2, a2.length);
                        } else {
                            appendable.append((char) this.a);
                            appendable.append(c);
                        }
                        this.a = -1;
                    } else {
                        throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + ((int) c));
                    }
                } else if (Character.isHighSurrogate(c)) {
                    this.a = c;
                } else if (!Character.isLowSurrogate(c)) {
                    char[] a3 = j.this.a(c);
                    if (a3 != null) {
                        a(a3, a3.length);
                    } else {
                        appendable.append(c);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + ((int) c));
                }
                return this;
            }
        };
    }

    private static final char[] a(char[] cArr, int i2, int i3) {
        char[] cArr2 = new char[i3];
        if (i2 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i2);
        }
        return cArr2;
    }
}
