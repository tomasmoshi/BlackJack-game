import java.util.LinkedList;
import java.util.*;


public class AddressBook {

    Contact head;
    Contact tail;
    Contact position;
    LinkedList<Contact> personContainer;
    int idx=-1;
    public AddressBook()
    {
        head = null;
        tail = null;
        position = head;
        personContainer = new LinkedList<>();
    }

    public void addContact(Contact c)
    {
        Contact temp = new Contact(c.firstName(),c.lastName(),c.Address(),c.phoneNumber());
        if(head==null){
            //head = temp;
            personContainer.add(temp);
            head = personContainer.getFirst();
            tail = personContainer.getFirst();
        }
        else{
            int t_idx = 0;
            if (personContainer.getLast().lastName().compareTo(temp.lastName()) < 0) {
                personContainer.add(temp);
                tail = personContainer.getLast();
                t_idx = personContainer.size() - 1;
            }
            else {
                while (personContainer.get(t_idx).lastName().compareTo(temp.lastName()) < 0) {
                    t_idx++;
                }
                personContainer.add(t_idx,temp);
                head = personContainer.getFirst();
                tail = personContainer.getLast();
            }
            idx = t_idx;
        }

    }

    public void deleteContact(Contact c)
    {
        int t_idx = -1;

        for(Contact x : personContainer)
        {
            ++t_idx;
            if (c.firstName().equalsIgnoreCase(x.firstName()) &&
                    c.lastName().equalsIgnoreCase(x.lastName()))
                break;
        }

        if(t_idx > -1)
        {
            personContainer.remove(personContainer.get(t_idx));
            idx = -1;
        }
    }

    public int findContact(String Name)
    {
        //Contact temp = new Contact((c.firstName(),c.lastName(),c.Address(),c.phoneNumber()));
        // personContainer.get(personContainer.indexOf(Name));
        String[] nameArr = Name.split(" ");
        LinkedList<String> lastNameList = new LinkedList<String>();
        LinkedList<String> firstNameList = new LinkedList<String>();
        for(Contact c: personContainer){
            lastNameList.add(c.lastName());
            firstNameList.add(c.firstName());
        }
        System.out.println("Lists initialized for search.");
        System.out.println("Name to search: " + Name);
        System.out.println("Size of Contact List: " + personContainer.size());
        // Hopefully this reduces the pool to one set
        int t_idx = idx;
        idx = 0;
        if (personContainer.size() != 0){
            for(Contact c: personContainer){
                if (lastNameList.get(0).compareTo(c.lastName()) == 0 && firstNameList.get(0).compareTo(c.firstName()) == 0){
                    System.out.println("DEBUG: TARGET FOUND");
                    return idx;
                } else {
                    //System.out.printf("%s and %s don\'t match?", lastNameList.get(idx), c.lastName());
                    idx += 1;
                }
            }
        }
        idx = t_idx;
        // Default
        return -1;
    }

    public Contact getCurrent()
    {
        if (idx > -1){
            return personContainer.get(idx);
        } else{
            return null;
        }

    }

    public void MakeEmpty(){
        personContainer.clear();
        idx = -1;
    }

}
