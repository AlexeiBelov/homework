package phonebook;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Phonebook {
    private static final String SYMBOLS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final Map<Long, Contact> byPhone = new HashMap<>();
    private final List<Contact> contacts = new ArrayList<>();
    private final Set<Contact> contactsSet = new HashSet<>();


    public void generate() {

        for (int i = 0; i < 10000; i++) {
            Contact contact = makeNewContact();
            byPhone.put(contact.getPhoneNumber(), contact);
            contacts.add(contact);
            contactsSet.add(contact);
        }
    }

    private Contact makeNewContact() {
        Contact contact = new Contact();
        contact.setName(generateString());
        contact.setSureName(generateString());
        contact.setPhoneNumber(generatePhoneNumber());
        contact.setRelatedContacts(generateRelatedContacts());
        return contact;
    }

    private List<Long> generateRelatedContacts() {
        ArrayList<Long> relatedContacts = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(5); i++) {
            relatedContacts.add(generatePhoneNumber());
        }
        return relatedContacts;
    }

    private long generatePhoneNumber() {
        return ThreadLocalRandom.current().nextLong(79850000000L, 79850100000L);
    }

    public void iterate() {
        iterate(byPhone.values());
        iterate(contacts);
        iterate(contactsSet);
    }

    private void iterate (Iterable<Contact> contacts){
        long startTime = System.nanoTime();
        Map<Long, Integer> phonesFrequency = new HashMap<>(byPhone.size() * 2);
        for (Contact contact : contacts) {
            for (Long phone : contact.getRelatedContacts()) {
                if (!phonesFrequency.containsKey(phone)) {
                    phonesFrequency.put(phone, 0);
                }
                int count = phonesFrequency.get(phone);
                phonesFrequency.put(phone, count + 1);
            }
        }
        LinkedList<Map.Entry<Long, Integer>> entries = new LinkedList<>(phonesFrequency.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println("Самый часто используемый телефон: " + entries.iterator().next());
        System.out.println(contacts.getClass() + " Время выполнения: " + (System.nanoTime() - startTime));
    }

    private static String generateString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3, 10); i++) {
            int i1 = ThreadLocalRandom.current().nextInt(SYMBOLS.length());
            char c = SYMBOLS.charAt(i1);
            sb.append(c);
        }
        return sb.toString();
    }
}
