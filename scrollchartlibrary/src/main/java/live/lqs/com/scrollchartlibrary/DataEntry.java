package live.lqs.com.scrollchartlibrary;

import java.util.Map;

/**
 * Created by dell on 2017/3/27.
 */
public class DataEntry<K, V> implements Map.Entry<K, V> { //数据类
    private final K key;
    private final V value;

    public DataEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        return value;
    }
}