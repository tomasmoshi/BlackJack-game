
public class Contact {
    String first, last, address;
    long number;

    public Contact(String f, String l, String a, long n)
    {
        first = f;
        last = l;
        address = a;
        number = n;
        //  next = null;
    }

    public String firstName() {
        return first;
    }

    public void setFirst(String f)
    {
        first = f;
        System.out.println("new first name is " + firstName());
    }

    public String lastName() {
        return last;
    }

    public void setLast(String l)
    {
        last = l;
        System.out.println("new last name is " + lastName());
    }

    public String Address() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
        System.out.println("new address is " + Address());
    }

    public long phoneNumber() {
        return number;
    }

    public void setPhoneNumber(long n) {
        number = n;
        System.out.println("new phone number is " + phoneNumber());
    }

    public String toString()
    {
        return firstName() + " " + lastName() + " " + Address() + " " + phoneNumber();
    }

}
