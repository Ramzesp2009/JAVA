public class Contact {
    String firstName;
    String lastName;
    String phone;
    String email;

    public Contact(String firstName, String LastName, String phone, String mail) {
        this.firstName = firstName;
        this.lastName = LastName;
        this.phone = phone;
        this.email = mail;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}