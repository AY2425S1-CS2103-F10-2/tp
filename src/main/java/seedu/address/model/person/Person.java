package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;

    // Data fields
    private final Optional<Address> address;
    private final Optional<Email> email;
    private final Set<Tag> tags = new HashSet<>();
    private final Optional<DateOfLastVisit> dateOfLastVisit;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Optional<Email> email, Optional<Address> address,
                  Set<Tag> tags, Optional<DateOfLastVisit> dateOfLastVisit) {
        requireAllNonNull(name, phone, email, address, tags, dateOfLastVisit);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.dateOfLastVisit = dateOfLastVisit;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    /**
     * Returns whether the Person has an email.
     */
    public boolean hasEmail() {
        return email.isPresent();
    }

    public Optional<Email> getEmail() {
        return email;
    }

    /**
     * Returns whether the Person has an address.
     */
    public boolean hasAddress() {
        return address.isPresent();
    }

    public Optional<Address> getAddress() {
        return address;
    }

    /**
     * Returns whether the Person has a dateOfLastVisit.
     */
    public boolean hasDateOfLastVisit() {
        return dateOfLastVisit.isPresent();
    }

    public Optional<DateOfLastVisit> getDateOfLastVisit() {
        return dateOfLastVisit;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && tags.equals(otherPerson.tags)
                && dateOfLastVisit.equals(otherPerson.dateOfLastVisit);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, dateOfLastVisit);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("tags", tags)
                .add("dateOfLastVisit", dateOfLastVisit)
                .toString();
    }

}
