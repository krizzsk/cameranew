package com.tapjoy.internal;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes3.dex */
public final class ek {
    final it a;

    /* renamed from: d  reason: collision with root package name */
    private int f7409d;

    /* renamed from: h  reason: collision with root package name */
    private eg f7413h;
    private long b = 0;
    private long c = LocationRequestCompat.PASSIVE_INTERVAL;

    /* renamed from: e  reason: collision with root package name */
    private int f7410e = 2;

    /* renamed from: f  reason: collision with root package name */
    private int f7411f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f7412g = -1;

    public ek(it itVar) {
        this.a = itVar;
    }

    private int i() {
        int i2;
        this.b++;
        byte c = this.a.c();
        if (c >= 0) {
            return c;
        }
        int i3 = c & Byte.MAX_VALUE;
        this.b++;
        byte c2 = this.a.c();
        if (c2 >= 0) {
            i2 = c2 << 7;
        } else {
            i3 |= (c2 & Byte.MAX_VALUE) << 7;
            this.b++;
            byte c3 = this.a.c();
            if (c3 >= 0) {
                i2 = c3 << 14;
            } else {
                i3 |= (c3 & Byte.MAX_VALUE) << 14;
                this.b++;
                byte c4 = this.a.c();
                if (c4 < 0) {
                    int i4 = i3 | ((c4 & Byte.MAX_VALUE) << 21);
                    this.b++;
                    byte c5 = this.a.c();
                    int i5 = i4 | (c5 << 28);
                    if (c5 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            this.b++;
                            if (this.a.c() >= 0) {
                                return i5;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i5;
                }
                i2 = c4 << 21;
            }
        }
        return i3 | i2;
    }

    public final long a() {
        if (this.f7410e == 2) {
            int i2 = this.f7409d + 1;
            this.f7409d = i2;
            if (i2 <= 65) {
                long j2 = this.f7412g;
                this.f7412g = -1L;
                this.f7410e = 6;
                return j2;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final int b() {
        int i2 = this.f7410e;
        if (i2 == 7) {
            this.f7410e = 2;
            return this.f7411f;
        } else if (i2 == 6) {
            while (this.b < this.c && !this.a.b()) {
                int i3 = i();
                if (i3 != 0) {
                    int i4 = i3 >> 3;
                    this.f7411f = i4;
                    int i5 = i3 & 7;
                    if (i5 == 0) {
                        this.f7413h = eg.VARINT;
                        this.f7410e = 0;
                        return i4;
                    } else if (i5 == 1) {
                        this.f7413h = eg.FIXED64;
                        this.f7410e = 1;
                        return i4;
                    } else if (i5 == 2) {
                        this.f7413h = eg.LENGTH_DELIMITED;
                        this.f7410e = 2;
                        int i6 = i();
                        if (i6 >= 0) {
                            if (this.f7412g == -1) {
                                long j2 = this.c;
                                this.f7412g = j2;
                                long j3 = this.b + i6;
                                this.c = j3;
                                if (j3 <= j2) {
                                    return this.f7411f;
                                }
                                throw new EOFException();
                            }
                            throw new IllegalStateException();
                        }
                        throw new ProtocolException("Negative length: " + i6);
                    } else if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                this.f7413h = eg.FIXED32;
                                this.f7410e = 5;
                                return i4;
                            }
                            throw new ProtocolException("Unexpected field encoding: " + i5);
                        }
                        throw new ProtocolException("Unexpected end group");
                    } else {
                        a(i4);
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public final eg c() {
        return this.f7413h;
    }

    public final int d() {
        int i2 = this.f7410e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f7410e);
        }
        int i3 = i();
        b(0);
        return i3;
    }

    public final long e() {
        byte c;
        int i2 = this.f7410e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f7410e);
        }
        long j2 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.b++;
            j2 |= (c & Byte.MAX_VALUE) << i3;
            if ((this.a.c() & 128) == 0) {
                b(0);
                return j2;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final int f() {
        int i2 = this.f7410e;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f7410e);
        }
        this.a.a(4L);
        this.b += 4;
        int e2 = this.a.e();
        b(5);
        return e2;
    }

    public final long g() {
        int i2 = this.f7410e;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f7410e);
        }
        this.a.a(8L);
        this.b += 8;
        long f2 = this.a.f();
        b(1);
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long h() {
        if (this.f7410e == 2) {
            long j2 = this.c - this.b;
            this.a.a(j2);
            this.f7410e = 6;
            this.b = this.c;
            this.c = this.f7412g;
            this.f7412g = -1L;
            return j2;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f7410e);
    }

    public final void a(long j2) {
        if (this.f7410e == 6) {
            int i2 = this.f7409d - 1;
            this.f7409d = i2;
            if (i2 >= 0 && this.f7412g == -1) {
                if (this.b != this.c && i2 != 0) {
                    throw new IOException("Expected to end at " + this.c + " but was " + this.b);
                }
                this.c = j2;
                return;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    private void a(int i2) {
        while (this.b < this.c && !this.a.b()) {
            int i3 = i();
            if (i3 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i4 = i3 >> 3;
            int i5 = i3 & 7;
            if (i5 == 0) {
                this.f7410e = 0;
                e();
            } else if (i5 == 1) {
                this.f7410e = 1;
                g();
            } else if (i5 == 2) {
                long i6 = i();
                this.b += i6;
                this.a.d(i6);
            } else if (i5 == 3) {
                a(i4);
            } else if (i5 == 4) {
                if (i4 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i5 == 5) {
                this.f7410e = 5;
                f();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i5);
            }
        }
        throw new EOFException();
    }

    private void b(int i2) {
        if (this.f7410e == i2) {
            this.f7410e = 6;
            return;
        }
        long j2 = this.b;
        long j3 = this.c;
        if (j2 > j3) {
            throw new IOException("Expected to end at " + this.c + " but was " + this.b);
        } else if (j2 == j3) {
            this.c = this.f7412g;
            this.f7412g = -1L;
            this.f7410e = 6;
        } else {
            this.f7410e = 7;
        }
    }
}
