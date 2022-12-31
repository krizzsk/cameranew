package com.growingio.android.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class LinkedString {
    private int hash;
    private LinkedNode mHead;
    private LinkedString mHeadLinkedString;
    private LinkedNode mTail;
    private int size;
    private WeakReference<String> valueRef;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LinkedNode {
        private LinkedNode next;
        private String value;

        private LinkedNode() {
        }
    }

    /* loaded from: classes2.dex */
    public class LinkedStringIterator {
        private int currentIndex;
        private LinkedNode currentNode;
        private boolean hasNext;
        private LinkedStringIterator headIterator;
        private int mCurrentStrOffset;

        private void calculateRightCurrentNodeByOffset() {
            LinkedNode linkedNode = LinkedString.this.mHead;
            int i2 = 0;
            while (true) {
                if (linkedNode == null) {
                    break;
                }
                int length = linkedNode.value.length() + i2;
                int i3 = this.mCurrentStrOffset;
                if (length <= i3) {
                    if (linkedNode == LinkedString.this.mTail) {
                        linkedNode = null;
                    } else {
                        i2 += linkedNode.value.length();
                        linkedNode = linkedNode.next;
                    }
                } else {
                    this.currentIndex = i3 - i2;
                    break;
                }
            }
            this.currentNode = linkedNode;
        }

        private void findRightIndex() {
            LinkedNode linkedNode = this.currentNode;
            if (linkedNode == null) {
                return;
            }
            if (this.currentIndex == linkedNode.value.length()) {
                this.currentIndex = 0;
                if (this.currentNode != LinkedString.this.mTail) {
                    this.currentNode = this.currentNode.next;
                } else {
                    this.currentNode = null;
                }
            }
            this.hasNext = this.currentNode != null;
        }

        private void firstCalRightIndex() {
            calculateRightCurrentNodeByOffset();
            findRightIndex();
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public char next() {
            LinkedStringIterator linkedStringIterator = this.headIterator;
            if (!(linkedStringIterator != null && linkedStringIterator.hasNext())) {
                char charAt = this.currentNode.value.charAt(this.currentIndex);
                this.currentIndex++;
                findRightIndex();
                return charAt;
            }
            char next = this.headIterator.next();
            if (this.headIterator.hasNext()) {
                return next;
            }
            firstCalRightIndex();
            return next;
        }

        private LinkedStringIterator(int i2) {
            this.hasNext = false;
            this.mCurrentStrOffset = i2;
            if (LinkedString.this.mHeadLinkedString != null) {
                if (this.mCurrentStrOffset >= LinkedString.this.mHeadLinkedString.size) {
                    this.mCurrentStrOffset -= LinkedString.this.mHeadLinkedString.size;
                } else {
                    LinkedString linkedString = LinkedString.this.mHeadLinkedString;
                    linkedString.getClass();
                    this.headIterator = new LinkedStringIterator(this.mCurrentStrOffset);
                    this.mCurrentStrOffset = 0;
                }
            }
            if (this.headIterator == null) {
                firstCalRightIndex();
            } else {
                this.hasNext = true;
            }
        }
    }

    public static LinkedString copy(LinkedString linkedString) {
        LinkedString linkedString2 = new LinkedString();
        if (linkedString != null) {
            linkedString2.mHeadLinkedString = linkedString;
            linkedString2.size = linkedString.size;
            linkedString2.valueRef = linkedString.valueRef;
        }
        return linkedString2;
    }

    public static LinkedString fromString(String str) {
        LinkedString linkedString = new LinkedString();
        if (str != null) {
            linkedString.append(str);
            linkedString.valueRef = new WeakReference<>(str);
        }
        return linkedString;
    }

    public LinkedString append(String str) {
        if (str.length() == 0) {
            return this;
        }
        LinkedNode linkedNode = new LinkedNode();
        linkedNode.value = str;
        this.size += str.length();
        if (this.mHead != null) {
            this.mTail.next = linkedNode;
            this.mTail = linkedNode;
        } else {
            this.mHead = linkedNode;
            this.mTail = linkedNode;
        }
        this.valueRef = null;
        this.hash = 0;
        return this;
    }

    public char end() {
        LinkedString linkedString;
        LinkedNode linkedNode = this.mTail;
        if (linkedNode != null || (linkedString = this.mHeadLinkedString) == null) {
            if (linkedNode != null) {
                return linkedNode.value.charAt(this.mTail.value.length() - 1);
            }
            throw new IllegalStateException("mTail should not be null");
        }
        return linkedString.end();
    }

    public boolean endsWith(String str) {
        int length = str.length();
        int i2 = this.size;
        if (length > i2) {
            return false;
        }
        LinkedStringIterator linkedStringIterator = new LinkedStringIterator(i2 - str.length());
        if (linkedStringIterator.hasNext()) {
            int i3 = 0;
            while (linkedStringIterator.hasNext()) {
                if (str.charAt(i3) != linkedStringIterator.next()) {
                    return false;
                }
                i3++;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.growingio.android.sdk.utils.LinkedString
            r1 = 0
            if (r0 == 0) goto L38
            int r0 = r4.length()
            com.growingio.android.sdk.utils.LinkedString r5 = (com.growingio.android.sdk.utils.LinkedString) r5
            int r2 = r5.length()
            if (r0 == r2) goto L12
            return r1
        L12:
            com.growingio.android.sdk.utils.LinkedString$LinkedStringIterator r0 = r4.iterator()
            com.growingio.android.sdk.utils.LinkedString$LinkedStringIterator r5 = r5.iterator()
        L1a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L31
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L30
            char r2 = r0.next()
            char r3 = r5.next()
            if (r2 == r3) goto L1a
        L30:
            return r1
        L31:
            boolean r5 = r5.hasNext()
            r5 = r5 ^ 1
            return r5
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.utils.LinkedString.equals(java.lang.Object):boolean");
    }

    public char first() {
        LinkedString linkedString = this.mHeadLinkedString;
        if (linkedString != null && linkedString.size > 0) {
            return linkedString.first();
        }
        LinkedNode linkedNode = this.mHead;
        if (linkedNode != null) {
            return linkedNode.value.charAt(0);
        }
        throw new IllegalStateException("mHead should not be null");
    }

    public int hashCode() {
        int i2 = this.hash;
        if (i2 == 0 && this.size != 0) {
            LinkedStringIterator it = iterator();
            while (it.hasNext()) {
                i2 = (i2 * 31) + it.next();
            }
            this.hash = i2;
        }
        return i2;
    }

    public LinkedStringIterator iterator() {
        return new LinkedStringIterator(0);
    }

    public int length() {
        return this.size;
    }

    public String toString() {
        return toStringValue();
    }

    public String toStringValue() {
        WeakReference<String> weakReference = this.valueRef;
        if (weakReference != null && weakReference.get() != null) {
            return this.valueRef.get();
        }
        if (this.mHeadLinkedString == null && this.mHead == this.mTail) {
            WeakReference<String> weakReference2 = new WeakReference<>(this.mHead.value);
            this.valueRef = weakReference2;
            return weakReference2.get();
        }
        StringBuilder sb = new StringBuilder(length());
        LinkedString linkedString = this.mHeadLinkedString;
        if (linkedString != null) {
            sb.append(linkedString.toStringValue());
        }
        LinkedNode linkedNode = this.mHead;
        if (linkedNode != null) {
            while (linkedNode != null) {
                sb.append(linkedNode.value);
                if (linkedNode == this.mTail) {
                    break;
                }
                linkedNode = linkedNode.next;
            }
        }
        String sb2 = sb.toString();
        this.valueRef = new WeakReference<>(sb2);
        return sb2;
    }

    public LinkedString append(Object obj) {
        return obj == null ? this : append(obj.toString());
    }
}
