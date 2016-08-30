package org.springsource.loaded;

/**
 * Created by sergei1 on 8/23/2016.
 */
public class NameAndDescriptor {

  final String name;

  final String descriptor;

  public NameAndDescriptor(String name, String descriptor) {
    this.name = name.intern();
    this.descriptor = descriptor.intern();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    NameAndDescriptor that = (NameAndDescriptor) o;
    return name == that.name && descriptor == that.descriptor;

  }

  public boolean equals2(String thatName, String thatDescriptor) {
    if (name.length() != thatName.length() || descriptor.length() != thatDescriptor.length()) {
      return false;
    }

    if (!name.equals(thatName)) return false;
    return descriptor.equals(thatDescriptor);

  }
  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + descriptor.hashCode();
    return result;
  }

  public String getName() {
    return name;
  }

  public String getDescriptor() {
    return descriptor;
  }

  @Override
  public String toString() {
    return name + descriptor;
  }
}
