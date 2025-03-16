import java.util.HashSet;
import java.util.Set;

class test {
    public static void main(String[] args) {
        Set<Contact> contacts = new HashSet<>();
        Contact anna = new Contact("Anna", "Schulz", "123456789", "anna@schulz.de");
        contacts.add(anna);
        Contact beth = new Contact("Beth", "Schulz", "987654321", "beth@schulz.de");
        contacts.add(beth);
        Contact beth2 = new Contact("Ben", "Schuhemacher", "987654321", "ben@schuhemacher.de");
        contacts.add(beth2);
        for (Contact contact : contacts) {
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + "; Telefon: " + contact.getPhone() + "; E-Mail: " + contact.getEmail());
        }
    }
}