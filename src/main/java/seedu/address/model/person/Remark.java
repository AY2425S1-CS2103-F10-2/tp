package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a remark about a Person in the remark book.
 * Guarantees: immutable; is always valid.
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS = "Remarks can take any values at all";

    public final String value;

    /**
     * Constructs a {@code remark}.
     *
     * @param remark Any remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark)) {
            return false;
        }

        Remark otherRemark = (Remark) other;
        return value.equals(otherRemark.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
