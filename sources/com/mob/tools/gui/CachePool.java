package com.mob.tools.gui;

import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class CachePool<K, V> {
    private int capacity;
    private OnRemoveListener<K, V> listener;
    private LinkedList<CachePool<K, V>.Node<K, V>> pool = new LinkedList<>();
    private int poolSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Node<K, V> {
        private long cacheTime;
        public K key;
        private int size;
        public V value;

        private Node() {
        }
    }

    /* loaded from: classes2.dex */
    public interface OnRemoveListener<K, V> {
        void onRemove(K k2, V v);
    }

    public CachePool(int i2) {
        this.capacity = i2;
    }

    public synchronized void clear() {
        LinkedList<CachePool<K, V>.Node<K, V>> linkedList = this.pool;
        if (linkedList != null && this.capacity > 0) {
            if (this.listener == null) {
                linkedList.clear();
            } else {
                while (this.pool.size() > 0) {
                    CachePool<K, V>.Node<K, V> removeLast = this.pool.removeLast();
                    if (removeLast != null) {
                        this.poolSize -= ((Node) removeLast).size;
                        OnRemoveListener<K, V> onRemoveListener = this.listener;
                        if (onRemoveListener != null) {
                            onRemoveListener.onRemove(removeLast.key, removeLast.value);
                        }
                    }
                }
            }
            this.poolSize = 0;
        }
    }

    public synchronized V get(K k2) {
        CachePool<K, V>.Node<K, V> node;
        if (this.pool != null && this.capacity > 0) {
            while (this.poolSize > this.capacity) {
                CachePool<K, V>.Node<K, V> removeLast = this.pool.removeLast();
                if (removeLast != null) {
                    this.poolSize -= ((Node) removeLast).size;
                    OnRemoveListener<K, V> onRemoveListener = this.listener;
                    if (onRemoveListener != null) {
                        onRemoveListener.onRemove(removeLast.key, removeLast.value);
                    }
                }
            }
            Iterator<CachePool<K, V>.Node<K, V>> it = this.pool.iterator();
            while (true) {
                if (!it.hasNext()) {
                    node = null;
                    break;
                }
                node = it.next();
                if (node != null && ((k2 == null && node.key == null) || (k2 != null && k2.equals(node.key)))) {
                    break;
                }
            }
            if (node != null) {
                this.pool.set(0, node);
                ((Node) node).cacheTime = System.currentTimeMillis();
                return node.value;
            }
        }
        return null;
    }

    public synchronized boolean put(K k2, V v, int i2) {
        if (this.pool == null || this.capacity <= 0) {
            return false;
        }
        CachePool<K, V>.Node<K, V> node = new Node<>();
        node.key = k2;
        node.value = v;
        ((Node) node).cacheTime = System.currentTimeMillis();
        ((Node) node).size = i2;
        this.pool.add(0, node);
        this.poolSize += i2;
        while (this.poolSize > this.capacity) {
            CachePool<K, V>.Node<K, V> removeLast = this.pool.removeLast();
            if (removeLast != null) {
                this.poolSize -= ((Node) removeLast).size;
                OnRemoveListener<K, V> onRemoveListener = this.listener;
                if (onRemoveListener != null) {
                    onRemoveListener.onRemove(removeLast.key, removeLast.value);
                }
            }
        }
        return true;
    }

    public void setOnRemoveListener(OnRemoveListener<K, V> onRemoveListener) {
        this.listener = onRemoveListener;
    }

    public synchronized int size() {
        return this.poolSize;
    }

    public synchronized void trimBeforeTime(long j2) {
        LinkedList<CachePool<K, V>.Node<K, V>> linkedList = this.pool;
        if (linkedList != null && this.capacity > 0) {
            int size = linkedList.size() - 1;
            while (size >= 0) {
                if (((Node) this.pool.get(size)).cacheTime < j2) {
                    CachePool<K, V>.Node<K, V> remove = this.pool.remove(size);
                    if (remove != null) {
                        this.poolSize -= ((Node) remove).size;
                        OnRemoveListener<K, V> onRemoveListener = this.listener;
                        if (onRemoveListener != null) {
                            onRemoveListener.onRemove(remove.key, remove.value);
                        }
                    }
                } else {
                    size--;
                }
            }
            while (this.poolSize > this.capacity) {
                CachePool<K, V>.Node<K, V> removeLast = this.pool.removeLast();
                if (removeLast != null) {
                    this.poolSize -= ((Node) removeLast).size;
                    OnRemoveListener<K, V> onRemoveListener2 = this.listener;
                    if (onRemoveListener2 != null) {
                        onRemoveListener2.onRemove(removeLast.key, removeLast.value);
                    }
                }
            }
        }
    }

    public synchronized boolean put(K k2, V v) {
        return put(k2, v, 1);
    }
}
