package com.growingio.android.sdk.java_websocket.util;

import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
/* loaded from: classes2.dex */
public class Charsetfunctions {
    public static CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;

    public static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void main(String[] strArr) throws InvalidDataException {
        stringUtf8(utf8Bytes("\u0000"));
        stringAscii(asciiBytes("\u0000"));
    }

    public static String stringAscii(byte[] bArr) {
        return stringAscii(bArr, 0, bArr.length);
    }

    public static String stringUtf8(byte[] bArr) throws InvalidDataException {
        return stringUtf8(ByteBuffer.wrap(bArr));
    }

    public static byte[] utf8Bytes(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String stringAscii(byte[] bArr, int i2, int i3) {
        try {
            return new String(bArr, i2, i3, "ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String stringUtf8(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(codingErrorAction);
        newDecoder.onUnmappableCharacter(codingErrorAction);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e2) {
            throw new InvalidDataException(1007, e2);
        }
    }
}
