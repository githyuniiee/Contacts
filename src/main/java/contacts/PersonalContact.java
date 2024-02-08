package contacts;

public class PersonalContact extends Contact{

    private String relationShip;

    PersonalContact(String name, String phoneNumber, String relationShip) {
        super(name, phoneNumber);
        this.relationShip = relationShip;
    }

    public String getRelationship() {
        return relationShip;
    }
}
