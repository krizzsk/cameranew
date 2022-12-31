package com.google.firebase.remoteconfig.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
/* loaded from: classes2.dex */
public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {
    private static final String ILLEGAL_ARGUMENT_STRING_FORMAT = "[Value: %s] cannot be converted to a %s.";
    private final int source;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfigValueImpl(String str, int i2) {
        this.value = str;
        this.source = i2;
    }

    private String asTrimmedString() {
        return asString().trim();
    }

    private void throwIfNullValue() {
        if (this.value == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public boolean asBoolean() throws IllegalArgumentException {
        if (this.source == 0) {
            return false;
        }
        String asTrimmedString = asTrimmedString();
        if (ConfigGetParameterHandler.TRUE_REGEX.matcher(asTrimmedString).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.FALSE_REGEX.matcher(asTrimmedString).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, asTrimmedString, TypedValues.Custom.S_BOOLEAN));
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public byte[] asByteArray() {
        if (this.source == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        return this.value.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public double asDouble() {
        if (this.source == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Double.valueOf(asTrimmedString).doubleValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, asTrimmedString, "double"), e2);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public long asLong() {
        if (this.source == 0) {
            return 0L;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Long.valueOf(asTrimmedString).longValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, asTrimmedString, Constants.LONG), e2);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public String asString() {
        if (this.source == 0) {
            return "";
        }
        throwIfNullValue();
        return this.value;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public int getSource() {
        return this.source;
    }
}
