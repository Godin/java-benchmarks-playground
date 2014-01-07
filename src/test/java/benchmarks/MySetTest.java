package benchmarks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

public class MySetTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  private final Set<Integer> set = new MySet<Integer>();

  @Test
  public void test() {
    int n = 42;

    assertThat(set.size()).isEqualTo(0);
    for (int i = 0; i < n; i++) {
      assertThat(set.add(i)).isTrue();
      assertThat(set.size()).isEqualTo(i + 1);
    }
    for (int i = 0; i < n; i++) {
      assertThat(set.add(i)).isFalse();
      assertThat(set.size()).isEqualTo(n);
    }
    for (int i = 0; i < n; i++) {
      assertThat(set.contains(i)).isTrue();
    }
    assertThat(set.contains(-1)).isFalse();
  }

  @Test
  public void iteratorRemove_not_supported() {
    set.add(0);
    thrown.expect(UnsupportedOperationException.class);
    set.iterator().remove();
  }

}
