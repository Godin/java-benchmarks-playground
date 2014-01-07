package benchmarks;

import gnu.trove.impl.PrimeFinder;

import java.util.AbstractSet;
import java.util.Iterator;

public class MySet<E> extends AbstractSet<E> {

  private int size;
  private Object[] elements = new Object[13];

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean add(E element) {
    if (size >= (2 * elements.length) / 3) {
      rehash();
    }
    if (putImpl(elements, element) == null) {
      size++;
      return true;
    }
    return false;
  }

  private int hash(long id) {
    return ((int) id ^ (int) (id >>> 32)) & 0x7fffffff;
  }

  private int index0(int hash, int length) {
    return hash % length;
  }

  private int step(int hash, int length) {
    return 1 + (hash % (length - 2));
  }

  private int next(int index, int step, int length) {
    index += step;
    if (index >= length) {
      index -= length;
    }
    return index;
  }

  private Object putImpl(Object[] elements, Object element) {
    int id = element.hashCode();
    int hash = hash(id);
    int index = index0(hash, elements.length);
    Object obj = elements[index];
    if (obj == null || (obj.hashCode() == id && obj.equals(element))) {
      elements[index] = element;
      return obj;
    }
    int step = step(hash, elements.length);
    while ((obj = elements[index = next(index, step, elements.length)]) != null) {
      if (obj.hashCode() == id && obj.equals(element)) {
        break;
      }
    }
    elements[index] = element;
    return obj;
  }

  private void rehash() {
    Object[] tmp = new Object[PrimeFinder.nextPrime(elements.length * 2)];
    for (int i = elements.length; --i >= 0; ) {
      Object order = elements[i];
      if (order != null) {
        putImpl(tmp, order);
      }
    }
    elements = tmp;
  }

  @Override
  public Iterator<E> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<E> {
    private int index;

    private MyIterator() {
      for (index = 0; index < elements.length && elements[index] == null; index++);
    }

    @Override
    public boolean hasNext() {
      return index < elements.length;
    }

    @Override
    public E next() {
      int result = index;
      for (index += 1; index < elements.length && elements[index] == null; index++);
      return (E) elements[result];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

}
