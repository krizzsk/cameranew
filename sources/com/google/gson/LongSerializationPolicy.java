package com.google.gson;
/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public k serialize(Long l2) {
            return new n(l2);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public k serialize(Long l2) {
            return new n(String.valueOf(l2));
        }
    };

    public abstract k serialize(Long l2);
}
