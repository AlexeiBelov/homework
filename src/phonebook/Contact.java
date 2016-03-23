package phonebook;

import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Contact {
    private String name;
    private String sureName;
    private long phoneNumber;
    private List<Long> relatedContacts = Collections.emptyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getRelatedContacts() {
        return relatedContacts;
    }

    public void setRelatedContacts(List<Long> relatedContacts) {
        this.relatedContacts = relatedContacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return phoneNumber == contact.phoneNumber &&
                Objects.equals(name, contact.name) &&
                Objects.equals(sureName, contact.sureName) &&
                Objects.equals(relatedContacts, contact.relatedContacts);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(name, sureName, phoneNumber, relatedContacts);
       return 1;
    }
}
